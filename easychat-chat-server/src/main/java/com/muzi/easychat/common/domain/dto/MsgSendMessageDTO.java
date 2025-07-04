package com.muzi.easychat.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * Date: 2023-08-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgSendMessageDTO implements Serializable {
    private Long msgId;
}
