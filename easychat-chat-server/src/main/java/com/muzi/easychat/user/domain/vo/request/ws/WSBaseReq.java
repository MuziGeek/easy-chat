package com.muzi.easychat.user.domain.vo.request.ws;

import lombok.Data;

/**
 * Description: websocket前端请求体
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * Date: 2023-03-19
 */
@Data
public class WSBaseReq {
    /**
     * 请求类型 1.请求登录二维码，2心跳检测
     *
     * @see com.muzi.easychat.user.domain.enums.WSReqTypeEnum
     */
    private Integer type;

    /**
     * 每个请求包具体的数据，类型不同结果不同
     */
    private String data;
}
