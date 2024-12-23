package com.muzi.easychat.websocket.domin.vo.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @CreateTime: 2024-12-15  22:00
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WSMsgMark {
    private List<WSMsgMarkItem> markList;

    @Data
    public static class WSMsgMarkItem {
        @ApiModelProperty("操作者")
        private Long uid;
        @ApiModelProperty("消息id")
        private Long msgId;
        /**
         * @see
         */
        @ApiModelProperty("标记类型 1点赞 2举报")
        private Integer markType;
        @ApiModelProperty("被标记的数量")
        private Integer markCount;
        /**
         * @see
         */
        @ApiModelProperty("动作类型 1确认 2取消")
        private Integer actType;
    }
}