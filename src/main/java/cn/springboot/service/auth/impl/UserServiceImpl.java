package cn.springboot.service.auth.impl;

import cn.springboot.framework.constant.Constants;
import cn.springboot.framework.exception.BusinessException;
import cn.springboot.framework.pk.FactoryAboutKey;
import cn.springboot.framework.pk.TableEnum;
import cn.springboot.mapper.auth.RoleMapper;
import cn.springboot.mapper.auth.UserMapper;
import cn.springboot.mapper.auth.UserRoleMapper;
import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.User;
import cn.springboot.model.auth.UserRole;
import cn.springboot.service.auth.UserService;
import cn.springboot.util.salt.Digests;
import cn.springboot.util.salt.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * 用户相关接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 14:18
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public void addUser(User user, Role role) {
        if (user == null || role == null || StringUtils.isAnyBlank(user.getUsername(), user.getPassword())) {
            throw new BusinessException("user.registr.error", "注册信息错误");
        }

        if (StringUtils.isBlank(role.getId())) {
            throw new BusinessException("user.registr.error", "用户未指定所属角色");
        }

        Role r = roleMapper.selectById(role.getId());
        if (r == null) {
            throw new BusinessException("user.registr.error", "用户未指定所属组织或角色");
        }

        User u = userMapper.findUserByName(user.getUsername());
        if (u != null) {
            throw new BusinessException("user.registr.error", "用户账号已经存在,username=" + user.getUsername());
        }

        entryptPassword(user);
        user.setStatus(Constants.STATUS_VALID);
        user.setCreateTime(Calendar.getInstance().getTime());
        user.setId(FactoryAboutKey.getPK(TableEnum.T_SYS_USER));
        userMapper.insert(user);

        UserRole ur = new UserRole();
        ur.setRoleId(r.getId());
        ur.setUserId(user.getId());
        ur.setId(FactoryAboutKey.getPK(TableEnum.T_SYS_USER_ROLE));
        userRoleMapper.insert(ur);
    }

    @Override
    public void updatePassword(User user) {
        if (log.isDebugEnabled()) {
            log.debug("## update User password.");
        }
        User u = userMapper.selectById(user.getId());
        u.setPassword(user.getPassword());
        entryptPassword(u);
        u.setModifyTime(Calendar.getInstance().getTime());
        userMapper.updateById(u);
    }

    @Override
    public User findUserByName(String username) {
        try {
            return userMapper.findUserByName(username);
        } catch (Exception e) {
            log.error("# 根据账号查询用户报错 , username={}", username);
            throw new BusinessException("1001", "查询用户失败");
        }
    }

    @Override
    public void updateUserLastLoginTime(User user) {
        User u = userMapper.selectById(user.getId());
        if (u != null) {
            user = new User();
            user.setLastLoginTime(Calendar.getInstance().getTime());
            user.setId(u.getId());
            userMapper.updateById(u);
        }
    }

    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

    @Override
    public List<User> findEmp(String shopId, String empName) {
        return userMapper.findEmp(Constants.COMMON_ROLE_CODE, Constants.STATUS_VALID, shopId, empName);
    }
}
