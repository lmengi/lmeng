package com.lmeng.controller.admin;

import com.lmeng.Response.LMResponse;
import com.lmeng.constants.factory.ConstantFactory;
import com.lmeng.controller.base.BaseController;
import com.lmeng.exception.LmException;
import com.lmeng.exception.LmExceptionEnum;
import com.lmeng.model.AdminUserModel;
import com.lmeng.pojo.Adminuser;
import com.lmeng.service.IAdminUserService;
import com.lmeng.shiro.ShiroKit;
import com.lmeng.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 系统管理员控制器
 *
 * @author lsk
 * @Date 2018年11月13日
 */

@Controller
@RequestMapping("/mgr")
public class AdminUserController extends BaseController {

    private static String PREFIX = "/adminUser/";

    @Autowired
    private IAdminUserService adminUserService;
    /**
     * 跳转到查看管理员列表的页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "adminUser.html";
    }

    /**
     * 跳转到查看用户详情页面
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {
        Integer userId = ShiroKit.getUser().getUserId();
        if (ToolUtil.isEmpty(userId)) {
            throw new LmException(LmExceptionEnum.REQUEST_NULL);
        }
        Adminuser user = this.adminUserService.queryUserById(userId);
        model.addAttribute("user",user);
        model.addAttribute("roleName", ConstantFactory.me().getSingleRoleName(user.getRoleid()));
        return PREFIX + "adminUser_view.html";
    }

    /**
     * 修改管理员个人详情
     */
    @RequestMapping("/edit")
    @ResponseBody
    public LMResponse editAdminUser(@Valid AdminUserModel adminUser, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new LmException(LmExceptionEnum.REQUEST_NULL);
        }

        Adminuser user = adminUserService.queryUserById(adminUser.getId());
        if (user == null)
        {
            return new LMResponse(false, "505", "用户不存在","");
        }
        return new LMResponse(true, "200", "修改成功",user);
    }
}
