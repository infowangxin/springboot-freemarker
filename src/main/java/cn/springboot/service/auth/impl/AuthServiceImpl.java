package cn.springboot.service.auth.impl;

import cn.springboot.mapper.auth.RoleMapper;
import cn.springboot.mapper.auth.UserMapper;
import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.User;
import cn.springboot.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组装权限接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:09
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public Role findRoleByRoleCode(String roleCode) {
        return roleMapper.findRoleByCode(roleCode);
    }

    @Override
    public List<User> findUserByRoleCode(String roleCode) {
        return userMapper.findUserByRoleCode(roleCode);
    }

}
