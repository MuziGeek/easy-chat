package com.muzi.easychat.websocket.domin.vo.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @CreateTime: 2024-12-15  21:52
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WSLoginUrl {
    private String loginUrl;
}
