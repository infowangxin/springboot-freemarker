package cn.springboot.web.shiro;

import cn.springboot.framework.constant.Constants;
import cn.springboot.framework.exception.BusinessException;
import cn.springboot.model.auth.Role;
import cn.springboot.model.auth.User;
import cn.springboot.service.LdapService;
import cn.springboot.service.auth.PermissionService;
import cn.springboot.service.auth.RoleService;
import cn.springboot.service.auth.UserService;
import cn.springboot.util.salt.Encodes;
import cn.springboot.web.shiro.vo.PermissionVo;
import cn.springboot.web.shiro.vo.Principal;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 胡桃夹子
 */
public class AuthorizingRealmImpl extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthorizingRealmImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private LdapService ldapService;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        try {
            if (log.isDebugEnabled()) {
                log.debug("## 正在验证用户登录...");
            }

            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            String username = token.getUsername();
            String password = String.valueOf(token.getPassword());
            log.debug("# username={}, password={}", username, password);

            if (StringUtils.isBlank(username)) {
                log.error("## 非法登录 .");
                throw new BusinessException("非法用户身份");
            }

            User user = userService.findUserByName(username);
            if (null == user) {
                log.error("## 用户不存在={} .", username);
                throw new BusinessException("账号或密码错误");
            }

            //boolean areYouOk = ldapService.authenticate(username, password);
            //log.debug("# areYouOk={}", areYouOk);
            //if (!areYouOk) {
            //    throw new BusinessException("LDAP认证失败，账号或密码错误");
            //}

            byte[] salt = Encodes.decodeHex(user.getSalt());

            Principal principal = new Principal();
            principal.setUser(user);
            principal.setRoles(roleService.findRoleByUserId(user.getId()));

            SecurityUtils.getSubject().getSession().setAttribute(Constants.PERMISSION_SESSION, permissionService.getPermissions(user.getId()));

            return new SimpleAuthenticationInfo(principal, user.getPassword(), ByteSource.Util.bytes(salt), getName());
        } catch (AuthenticationException e) {
            log.error("# doGetAuthenticationInfo error , message={}", e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @SuppressWarnings("unchecked")
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Principal principal = (Principal) principals.fromRealm(getName()).iterator().next();
        Session session = SecurityUtils.getSubject().getSession();
        // ---
        Set<String> permissions = new HashSet<>();
        Object permisObj = session.getAttribute(Constants.PERMISSION_URL);
        if (null == permisObj) {
            Collection<PermissionVo> pers = permissionService.getPermissions(principal.getUser().getId());
            for (PermissionVo permission : pers) {
                permissions.add(permission.getUrl());
                if (CollectionUtils.isNotEmpty(permission.getChildren())) {
                    for (PermissionVo childrenPer : permission.getChildren()) {
                        permissions.add(childrenPer.getUrl());
                    }
                }
            }
            session.setAttribute(Constants.PERMISSION_URL, permissions);
        } else {
            permissions = (Set<String>) permisObj;
        }

        Set<String> roleCodes = new HashSet<>();
        Object roleNameObj = session.getAttribute(Constants.ROLE_CODE);
        if (null == roleNameObj) {
            for (Role role : roleService.findRoleByUserId(principal.getUser().getId())) {
                roleCodes.add(role.getCode());
            }
            session.setAttribute(Constants.ROLE_CODE, roleCodes);
        } else {
            roleCodes = (Set<String>) roleNameObj;
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleCodes);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
        matcher.setHashIterations(1024);
        setCredentialsMatcher(matcher);
    }

}
