package com.dong.cbu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhendong on 2016/4/25.
 * email:myyizhendong@gmail.com
 */
@Controller
public class ActorAction {
    @RequestMapping(value="/")
    public String  home(){
        return "test";
    }
}
