package com.lmeng.controller.client;

import com.lmeng.Response.LMResponse;
import com.lmeng.controller.base.BaseController;
import com.lmeng.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController extends BaseController {

    @Resource
    private IUserService IUserService;


    @RequestMapping("getUsers/{id}")
    @ResponseBody()
    public LMResponse GetUsers(@PathVariable("id") String id)
    {
        Integer userId = Integer.valueOf(id);
        //User user = IUserService.queryUserByIdCustom(userId);
        return new LMResponse(true, "200", "接口正常","") ;
    }
}
