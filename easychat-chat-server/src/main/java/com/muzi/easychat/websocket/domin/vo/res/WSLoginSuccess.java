package com.muzi.easychat.websocket.domin.vo.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @CreateTime: 2024-12-15  21:54
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WSLoginSuccess {
    private Long uid;
    private String avatar;
    private String token;
    private String name;
    //用户权限 0普通用户 1超管
    private Integer power;
}
