package cn.springboot.web.controller;

import cn.springboot.model.auth.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 认证相关接口
 *
 * @author 胡桃夹子
 * @date 2022/3/15 11:07
 */
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("login")
    String login(Model model) {
        model.addAttribute("user", new User());
        LOG.info("#去登录");
        return "view/login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userForm") User user, RedirectAttributes redirectAttributes) {
        LOG.info("# 登录中 ");
        if (null == user || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            LOG.error("# 账号或密码错误");
            return "login";
        }

        String username = user.getUsername();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            LOG.info("对用户[{}]进行登录验证..验证开始", username);
            currentUser.login(token);
            LOG.info("对用户[{}]进行登录验证..验证通过", username);
        } catch (UnknownAccountException uae) {
            LOG.error("对用户[{}]进行登录验证..验证未通过,未知账户", username);
            setRedirectAttributes(redirectAttributes, "未知账户");
        } catch (IncorrectCredentialsException ice) {
            LOG.error("对用户[{}]进行登录验证..验证未通过,错误的凭证", username);
            setRedirectAttributes(redirectAttributes, "密码不正确");
        } catch (LockedAccountException lae) {
            LOG.error("对用户[{}]进行登录验证..验证未通过,账户已锁定", username);
            setRedirectAttributes(redirectAttributes, "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            LOG.error("对用户[{}]进行登录验证..验证未通过,错误次数过多", username);
            setRedirectAttributes(redirectAttributes, "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            LOG.error("对用户[{}]进行登录验证..验证未通过,堆栈轨迹如下", username);
            setRedirectAttributes(redirectAttributes, "用户名或密码不正确");
        }
        // 验证是否登录成功
        if (currentUser.isAuthenticated()) {
            LOG.info("用户[{}]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)", username);
            return "redirect:/index";
        } else {
            token.clear();
            return "redirect:/login";
        }
    }

    private void setRedirectAttributes(RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute("message", message);
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "view/login/login";
    }

    @GetMapping("/403")
    public String unauthorizedRole() {
        LOG.info("------没有权限-------");
        return "403";
    }

}
