package com.muzi.easychat.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description: 扫码成功对象，推送给用户的消息对象
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * Date: 2023-08-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScanSuccessMessageDTO implements Serializable {
    /**
     * 推送的uid
     */
    private Integer code;

}
