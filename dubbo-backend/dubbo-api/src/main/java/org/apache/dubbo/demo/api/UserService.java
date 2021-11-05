package org.apache.dubbo.demo.api;


public interface UserService {

    // provider say hello to userName
    // add ip info
    public String sayHello(String userName);

    public String getIpInfo();
}
