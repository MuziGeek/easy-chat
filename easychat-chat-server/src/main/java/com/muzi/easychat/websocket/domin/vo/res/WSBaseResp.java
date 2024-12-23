package com.muzi.easychat.websocket.domin.vo.res;

import com.muzi.easychat.websocket.domin.enums.WSRespTypeEnum;
import lombok.Data;

/**
 * @Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @CreateTime: 2024-12-15  22:15
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class WSBaseResp<T> {
    /**
     * ws推送给前端的消息
     *
     * @see WSRespTypeEnum
     */
    private Integer type;
    private T data;
}
