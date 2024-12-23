package com.muzi.easychat.websocket.domin.vo.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @CreateTime: 2024-12-15  21:58
 * @Description: 用户上下线变动的推送类
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WSOnlineOfflineNotify {
    private List<ChatMemberResp> changeList = new ArrayList<>();//新的上下线用户
    private Long onlineNum;//在线人数
}
