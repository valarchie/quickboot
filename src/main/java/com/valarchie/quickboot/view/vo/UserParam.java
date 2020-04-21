package com.valarchie.quickboot.view.vo;

import lombok.Data;
import lombok.ToString;

/**
 * Created by
 * author:valarchie
 * on 2020/4/16 23:17
 * mailbox:343928303@qq.com
 **/
@Data
@ToString
public class UserParam {

    private String name;
    private String age;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

}
