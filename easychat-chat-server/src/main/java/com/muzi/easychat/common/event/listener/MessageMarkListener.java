package com.muzi.easychat.common.event.listener;

import com.muzi.easychat.chat.dao.MessageDao;
import com.muzi.easychat.chat.dao.MessageMarkDao;
import com.muzi.easychat.chat.domain.dto.ChatMessageMarkDTO;
import com.muzi.easychat.chat.domain.entity.Message;
import com.muzi.easychat.chat.domain.enums.MessageMarkTypeEnum;
import com.muzi.easychat.chat.domain.enums.MessageTypeEnum;
import com.muzi.easychat.common.domain.enums.IdempotentEnum;
import com.muzi.easychat.common.event.MessageMarkEvent;
import com.muzi.easychat.user.domain.enums.ItemEnum;
import com.muzi.easychat.user.service.IUserBackpackService;
import com.muzi.easychat.user.service.adapter.WSAdapter;
import com.muzi.easychat.user.service.impl.PushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Objects;

/**
 * 消息标记监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
public class MessageMarkListener {
    @Autowired
    private MessageMarkDao messageMarkDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private IUserBackpackService iUserBackpackService;
    @Autowired
    private PushService pushService;

    @Async
    @TransactionalEventListener(classes = MessageMarkEvent.class, fallbackExecution = true)
    public void changeMsgType(MessageMarkEvent event) {
        ChatMessageMarkDTO dto = event.getDto();
        Message msg = messageDao.getById(dto.getMsgId());
        if (!Objects.equals(msg.getType(), MessageTypeEnum.TEXT.getType())) {//普通消息才需要升级
            return;
        }
        //消息被标记次数
        Integer markCount = messageMarkDao.getMarkCount(dto.getMsgId(), dto.getMarkType());
        MessageMarkTypeEnum markTypeEnum = MessageMarkTypeEnum.of(dto.getMarkType());
        if (markCount < markTypeEnum.getRiseNum()) {
            return;
        }
        if (MessageMarkTypeEnum.LIKE.getType().equals(dto.getMarkType())) {//尝试给用户发送一张徽章
            iUserBackpackService.acquireItem(msg.getFromUid(), ItemEnum.LIKE_BADGE.getId(), IdempotentEnum.MSG_ID, msg.getId().toString());
        }
    }

    @Async
    @TransactionalEventListener(classes = MessageMarkEvent.class, fallbackExecution = true)
    public void notifyAll(MessageMarkEvent event) {//后续可做合并查询，目前异步影响不大
        ChatMessageMarkDTO dto = event.getDto();
        Integer markCount = messageMarkDao.getMarkCount(dto.getMsgId(), dto.getMarkType());
        pushService.sendPushMsg(WSAdapter.buildMsgMarkSend(dto, markCount));
    }

}
