package com.muzi.easychat.user.service;

import com.muzi.easychat.user.domain.vo.request.oss.UploadUrlReq;
import com.muzi.easychat
.oss.domain.OssResp;

/**
 * <p>
 * oss 服务类
 * </p>
 *
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @since 2023-03-19
 */
public interface OssService {

    /**
     * 获取临时的上传链接
     */
    OssResp getUploadUrl(Long uid, UploadUrlReq req);
}
