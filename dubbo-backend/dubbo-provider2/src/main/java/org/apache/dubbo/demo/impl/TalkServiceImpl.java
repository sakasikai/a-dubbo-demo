package org.apache.dubbo.demo.impl;

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

        if(input.startsWith("what's the time?")){
            String msg = "current time is: [" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "]";
            return new TalkResponse(input, msg, name);
        }else{
            return new TalkResponse();
        }


    }
}
