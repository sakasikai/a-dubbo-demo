package org.apache.dubbo.demo.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.demo.api.TalkService;
import org.apache.dubbo.demo.model.TalkResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Service
public class TalkServiceImpl implements TalkService {
    @Value("${service.user.name}")
    private String name;


    @Override
    public TalkResponse query(String input) {

        if(input.contains("the time")){
            String msg = "【response】current time is: [" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "]";
            return new TalkResponse(input, msg, name);
        }else if(input.contains("your ip")){
            String msg = "【response】my ip is: "+ RpcContext.getContext().getLocalAddress();
            return new TalkResponse(input, msg, name);
        }else{
            TalkResponse res = new TalkResponse();
            res.setInput(input);
            res.setProviderName(name);
            return res;
        }


    }
}
