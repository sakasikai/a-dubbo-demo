package org.apache.dubbo.demo.api;

import org.apache.dubbo.demo.model.TalkResponse;

public interface TalkService {
    public TalkResponse query(String input);
}
