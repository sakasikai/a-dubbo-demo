package org.apache.dubbo.demo.impl;


import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.demo.api.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component(value = "userService")
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Value("${service.user.name}")
    private String name;

    @Override
    public String sayHello(String userName) {
        String msg = "Hello " + userName + " , response from provider: "+name;

        return msg;
    }

    public String getIpInfo(){
        String ip_msg = "consumer ip: "+RpcContext.getContext().getRemoteAddress()+
                "\nprovider ip: "+ RpcContext.getContext().getLocalAddress();

        return ip_msg;
    }



}
