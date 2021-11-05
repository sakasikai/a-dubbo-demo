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
        this.input = "No Input";
        this.output = "No Response";
        this.providerName = "None";
    }

}
