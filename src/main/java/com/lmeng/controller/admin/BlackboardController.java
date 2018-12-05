package com.lmeng.controller.admin;

import com.lmeng.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 总览信息
 *
 * @author fengshuonan
 * @Date 2017年3月4日23:05:54
 */
@Controller
@RequestMapping("/blackboard")
public class BlackboardController extends BaseController {

    /**
     * 跳转到黑板
     */
    @RequestMapping("")
    public String blackboard(Model model) {
        return "/blackboard.html";
    }
}
