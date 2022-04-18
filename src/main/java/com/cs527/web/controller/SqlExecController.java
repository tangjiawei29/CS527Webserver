package com.cs527.web.controller;

import com.cs527.web.entity.Result;
import com.cs527.web.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ds")
public class SqlExecController {

    @Autowired
    SqlService sqlService;

    @PostMapping("/{instance}/{database}")
    public Result sqlExec(@PathVariable("instance") String instance, @PathVariable("database") String database, @RequestBody String sql) {
        sql = sql.trim();
        return sqlService.exec(instance, database, sql);
    }
}
