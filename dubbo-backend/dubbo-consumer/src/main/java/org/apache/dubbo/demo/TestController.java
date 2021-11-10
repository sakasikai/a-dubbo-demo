package org.apache.dubbo.demo;

import ch.qos.logback.classic.Level;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.demo.api.TalkService;
import org.apache.dubbo.demo.api.UserService;
import org.apache.dubbo.demo.model.TalkResponse;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author cvictory ON 2018/11/29
 */
@RestController
@RequestMapping("/dubbo")
public class TestController {

    @Reference
    private UserService userService;
    @Reference
    private TalkService talkService;

    @RequestMapping("/user/get")
    public String userServ() {
        System.out.println("consumer start on url /test/user");
        System.out.println("Getting service from org.apache.dubbo.demo.api.UserService");

        String msg = userService.sayHello("李四");
        String ip_msg = userService.getIpInfo();
        String out = msg + "</br>with info:</br>" + ip_msg;

        return out;
    }

    @RequestMapping("/talk/{id}/get")
    public String talkServ(@PathVariable("id") int choice) {
        TalkResponse res;

        if(choice == 1){
             res = talkService.query("what's the time?");
        }else if(choice == 2){
            res = talkService.query("what's your ip?");
        }else {
             res = talkService.query("query out of range");
        }

        return res.toString();
    }

    @RequestMapping("/error")
    public String error() {
        return "the error";
    }
}
