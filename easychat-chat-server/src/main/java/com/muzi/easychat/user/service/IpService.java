package com.muzi.easychat.user.service;

public interface IpService {
    /**
     * 异步更新用户ip详情
     *
     * @param uid
     */
    void refreshIpDetailAsync(Long uid);
}
