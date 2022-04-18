package com.cs527.web.service;

import com.cs527.web.entity.Result;
import com.cs527.web.enums.DatabaseName;
import com.cs527.web.enums.InstanceType;
import com.cs527.web.mapper.rds.abc.RdsABCMapper;
import com.cs527.web.mapper.rds.instacart.RdsInstacartMapper;
import com.cs527.web.mapper.redshift.abc.RedshiftABCMapper;
import com.cs527.web.mapper.redshift.instacart.RedshiftInstacartMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SqlService {
	@Resource
	private RdsABCMapper rdsABCMapper;

	@Resource
	private RedshiftABCMapper redshiftABCMapper;

	@Resource
	private RdsInstacartMapper rdsInstacartMapper;

	@Resource
	private RedshiftInstacartMapper redshiftInstacartMapper;

	public Result exec(String instance, String database, String sql) {
		Result result = new Result();
		try {
			long startTime = System.nanoTime();
			String ret = exec(InstanceType.parse(instance), DatabaseName.parse(database), sql);
			result.setElapsedTime((System.nanoTime() - startTime) / 1000000);
			result.setData(ret);
			result.setStatus("Query completed");
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getCause() == null) {
				result.setStatus(e.getMessage());
			} else {
				result.setStatus(e.getCause().getMessage());
			}
		}
		return result;
	}

	private String exec(InstanceType instance, DatabaseName database, String sql) throws JsonProcessingException {
		if (instance == null || database == null) throw new NullPointerException();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		switch (instance) {
			case RDS: {
				switch (database) {
					case Instacart:
						return objectMapper.writeValueAsString(rdsInstacartMapper.exec(sql));
					case ABCRetail:
						return objectMapper.writeValueAsString(rdsABCMapper.exec(sql));
				}
			}
			case Redshift: {
				switch (database) {
					case Instacart:
						return objectMapper.writeValueAsString(redshiftInstacartMapper.exec(sql));
					case ABCRetail:
						return objectMapper.writeValueAsString(redshiftABCMapper.exec(sql));
				}
			}
		}

		return "";
	}
}
