package org.apache.dubbo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class TalkResponse implements Serializable {
    private String input;
    private String output;
    private String providerName;

    public TalkResponse(){
        this.input = "None";
        this.output = "I have no answer for this query :(";
        this.providerName = "None";
    }

}
