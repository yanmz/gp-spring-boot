package com.example.gpspringboot.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tom
 */
@RestController
public class Controller {

    @RequestMapping(path = "/html/demo/header")
    public String  getIndex(@RequestHeader(value = "Accept") String index){
        return  "<html><body>Request 'Accept' header value : " + index + " </body></html>";
    }
}
