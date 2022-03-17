package com.cs527.web.controller;

import com.cs527.web.entity.Result;
import com.cs527.web.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql")
public class SqlPageController {
    @RequestMapping("/")
    public String index() {
        return "sql_page";
    }

    @Autowired
    SqlService sqlService;

     @PostMapping("/rds")
     public Result rdsExec(@RequestBody String sql) {
         return sqlService.rdsExecute(sql);
     }

     @PostMapping("/redshift")
     public Result redshiftExec(@RequestBody String sql) {
         System.out.println("redshift");
         return sqlService.redshiftExecute(sql);
     }
}
