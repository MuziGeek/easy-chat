package com.muzi.easychat.common.event.listener;

import com.muzi.easychat.common.domain.enums.IdempotentEnum;
import com.muzi.easychat.common.event.UserRegisterEvent;
import com.muzi.easychat.user.dao.UserDao;
import com.muzi.easychat.user.domain.entity.User;
import com.muzi.easychat.user.domain.enums.ItemEnum;
import com.muzi.easychat.user.service.IUserBackpackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 用户上线监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
public class UserRegisterListener {
    @Autowired
    private UserDao userDao;
    @Autowired
    private IUserBackpackService iUserBackpackService;

    @Async
    @EventListener(classes = UserRegisterEvent.class)
    public void sendCard(UserRegisterEvent event) {
        User user = event.getUser();
        //送一张改名卡
        iUserBackpackService.acquireItem(user.getId(), ItemEnum.MODIFY_NAME_CARD.getId(), IdempotentEnum.UID, user.getId().toString());
    }

//    @Async
//    @EventListener(classes = UserRegisterEvent.class)
//    public void sendBadge(UserRegisterEvent event) {
//        User user = event.getUser();
//        int count = userDao.count();// 性能瓶颈，等注册用户多了直接删掉
//        if (count <= 10) {
//            iUserBackpackService.acquireItem(user.getId(), ItemEnum.REG_TOP10_BADGE.getId(), IdempotentEnum.UID, user.getId().toString());
//        } else if (count <= 100) {
//            iUserBackpackService.acquireItem(user.getId(), ItemEnum.REG_TOP100_BADGE.getId(), IdempotentEnum.UID, user.getId().toString());
//        }
//    }

}
