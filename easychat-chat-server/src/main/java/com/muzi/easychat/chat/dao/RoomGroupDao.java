package com.muzi.easychat.chat.dao;

import com.muzi.easychat.chat.domain.entity.RoomGroup;
import com.muzi.easychat.chat.mapper.RoomGroupMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 群聊房间表 服务实现类
 * </p>
 *
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @since 2023-07-22
 */
@Service
public class RoomGroupDao extends ServiceImpl<RoomGroupMapper, RoomGroup> {

    public List<RoomGroup> listByRoomIds(List<Long> roomIds) {
        return lambdaQuery()
                .in(RoomGroup::getRoomId, roomIds)
                .list();
    }

    public RoomGroup getByRoomId(Long roomId) {
        return lambdaQuery()
                .eq(RoomGroup::getRoomId, roomId)
                .one();
    }
}
