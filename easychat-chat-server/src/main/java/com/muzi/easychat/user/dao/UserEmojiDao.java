package com.muzi.easychat.user.dao;

import com.muzi.easychat.user.domain.entity.UserEmoji;
import com.muzi.easychat.user.mapper.UserEmojiMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表情包 服务实现类
 * </p>
 *
 * Author: <a href="https://github.com/MuziGeek">Muzi</a>
 * @since 2023-07-09
 */
@Service
public class UserEmojiDao extends ServiceImpl<UserEmojiMapper, UserEmoji> {

    public List<UserEmoji> listByUid(Long uid) {
        return lambdaQuery().eq(UserEmoji::getUid, uid).list();
    }

    public int countByUid(Long uid) {
        return lambdaQuery().eq(UserEmoji::getUid, uid).count();
    }
}
