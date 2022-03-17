package com.cs527.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SqlPageController {
    @RequestMapping("/sql")
    public String index() {
        return "sql_page";
    }
}
