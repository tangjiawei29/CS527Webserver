package com.cs527.web.service;

import com.cs527.web.entity.Result;
// import com.cs527.web.mapper.rds.RdsMapper;
// import com.cs527.web.mapper.redshift.RedshiftMapper;
import com.cs527.web.mapper.rds.RdsMapper;
import com.cs527.web.mapper.redshift.RedshiftMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SqlService {
	@Resource
	private RdsMapper rdsMapper;

	@Resource
	private RedshiftMapper redshiftMapper;

	public Result rdsExecute(String sql) {
		ObjectMapper objectMapper = new ObjectMapper();
		Result result = new Result();
		try {
			long startTime = System.nanoTime();
			String ret = objectMapper.writeValueAsString(rdsMapper.exec(sql));
			result.setElapsedTime((System.nanoTime() - startTime) / 1000000);
			result.setData(ret);
			result.setStatus("Query completed");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(e.getCause().getMessage());
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
			result.setStatus("Query completed");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(e.getCause().getMessage());
		}
		return result;
	}
}
