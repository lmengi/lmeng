package com.lmeng.controller.admin;

import com.google.code.kaptcha.Constants;
import com.lmeng.Response.LMResponse;
import com.lmeng.controller.base.BaseController;
import com.lmeng.enums.RoleTypeEnum;
import com.lmeng.exception.LmException;
import com.lmeng.exception.LmExceptionEnum;
import com.lmeng.pojo.Adminuser;
import com.lmeng.pojo.User;
import com.lmeng.service.IAdminUserService;
import com.lmeng.service.IMenuService;
import com.lmeng.service.IUserService;
import com.lmeng.shiro.CustomShiroLoginToken;
import com.lmeng.shiro.ShiroKit;
import com.lmeng.shiro.ShiroUser;
import com.lmeng.utils.KaptchaUtil;
import com.lmeng.utils.ToolUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminUserController extends BaseController {

    @Value("${lmeng.session-invalidate-time}")
    private int sessionInvalidateTime;

    @Autowired
    private IAdminUserService adminUserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        Integer roleId = 0;
        ShiroUser shiroUser = ShiroKit.getUser();
        if (shiroUser != null)
        {
            roleId = shiroUser.getRoleId();
        }

        if (shiroUser == null && roleId <= 0)
        {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
        model.addAttribute("menus", ShiroKit.getUser().getMenus());

        //获取用户头像
        Integer id = ShiroKit.getUser().getUserId();
        Adminuser user = adminUserService.queryUserById(id);
        String avatar = "";
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            model.addAttribute("name", "qwwer");
            return "/login.html";
        }
    }


    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCommit() {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        String remember = super.getPara("remember");

        //验证验证码是否正确
        if (KaptchaUtil.getKaptchaOnOff()) {
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new LmException(LmExceptionEnum.KAPTCHA_ERROR);
            }
        }

        String salt = "1234567890";
        String pwd = ShiroKit.md5(password, salt);

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        if ("on".equals(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }

        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getUserName());
        ShiroKit.getSession().setAttribute("sessionFlag", true);

        return REDIRECT + "/";
    }
}
