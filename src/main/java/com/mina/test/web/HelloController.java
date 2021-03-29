package com.mina.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어줌.
//  @ResponseBody를 각 메소드 마다 선언했던 것을 한번에 사용할 수 있게 해줌
@RestController
public class HelloController {

    // Http Method 인 Get의 요청을 받을 수 있는 API를 만들어줌
    // 예전에는 @RequusetMapping(method=RequestMehod.GET) 으로 사용.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
