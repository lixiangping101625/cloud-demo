package com.hlkj.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lixiangping
 * @createTime 2022年10月20日 14:49
 * @decription:
 */
@RestController
public class Controller {

    @Autowired
    private MyService myService;

    @GetMapping("/fallback")
    public String fallback(){
        return myService.error();
    }

    @GetMapping("/timeout")
    public String timeout(@RequestParam("count") Integer count){
        return myService.timeout(count);
    }

}
