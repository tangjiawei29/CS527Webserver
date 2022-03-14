package com.cs527.web.service;

import com.cs527.web.entity.Result;
import com.cs527.web.mapper.DatabaseMapper;
// import com.cs527.web.mapper.RdsMapper;
// import com.cs527.web.mapper.RedshiftMapper;
import com.cs527.web.mapper.RdsMapper;
import com.cs527.web.mapper.RedshiftMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SqlService {
	@Resource
	private DatabaseMapper databaseMapper;

	@Resource
	private RdsMapper rdsMapper;

	@Resource
	private RedshiftMapper redshiftMapper;

	public Result execute(String sql) {
		ObjectMapper objectMapper = new ObjectMapper();
		Result result = new Result();
		try {
			long startTime = System.nanoTime();
			String ret = objectMapper.writeValueAsString(databaseMapper.exec(sql));
			result.setElapsedTime((System.nanoTime() - startTime) / 1000000);
			result.setData(ret);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Result rdsExecute(String sql) {
		ObjectMapper objectMapper = new ObjectMapper();
		Result result = new Result();
		try {
			long startTime = System.nanoTime();
			String ret = objectMapper.writeValueAsString(rdsMapper.exec(sql));
			result.setElapsedTime((System.nanoTime() - startTime) / 1000000);
			result.setData(ret);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Result redshiftExecute(String sql) {
		ObjectMapper objectMapper = new ObjectMapper();
		Result result = new Result();
		try {
			long startTime = System.nanoTime();
			System.out.println(sql);
			String ret = objectMapper.writeValueAsString(redshiftMapper.exec(sql));
			result.setElapsedTime((System.nanoTime() - startTime) / 1000000);
			result.setData(ret);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
