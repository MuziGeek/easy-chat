package com.muzi.easychat.user.service;

import com.muzi.easychat.common.domain.enums.IdempotentEnum;

/**
 * <p>
 * 用户背包表 服务类
 * </p>
 *
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @since 2023-03-19
 */
public interface IUserBackpackService {


    /**
     * 用户获取一个物品
     *
     * @param uid            用户id
     * @param itemId         物品id
     * @param idempotentEnum 幂等类型
     * @param businessId     上层业务发送的唯一标识
     */
    void acquireItem(Long uid, Long itemId, IdempotentEnum idempotentEnum, String businessId);
}
