package com.muzi.easychat.common.event.listener;

import com.muzi.easychat.common.event.ItemReceiveEvent;
import com.muzi.easychat.user.dao.UserDao;
import com.muzi.easychat.user.domain.entity.ItemConfig;
import com.muzi.easychat.user.domain.entity.User;
import com.muzi.easychat.user.domain.entity.UserBackpack;
import com.muzi.easychat.user.domain.enums.ItemTypeEnum;
import com.muzi.easychat.user.service.cache.ItemCache;
import com.muzi.easychat.user.service.cache.UserCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户收到物品监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
public class ItemReceiveListener {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ItemCache itemCache;
    @Autowired
    private UserCache userCache;

    /**
     * 徽章类型，帮忙默认佩戴
     *
     * @param event
     */
    @Async
    @EventListener(classes = ItemReceiveEvent.class)
    public void wear(ItemReceiveEvent event) {
        UserBackpack userBackpack = event.getUserBackpack();
        ItemConfig itemConfig = itemCache.getById(userBackpack.getItemId());
        if (ItemTypeEnum.BADGE.getType().equals(itemConfig.getType())) {
            User user = userDao.getById(userBackpack.getUid());
            if (Objects.isNull(user.getItemId())) {
                userDao.wearingBadge(userBackpack.getUid(), userBackpack.getItemId());
                userCache.userInfoChange(userBackpack.getUid());
            }
        }
    }

}
