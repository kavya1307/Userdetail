package com.example.krishnaUserDetail.logging.serviceimpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.krishnaUserDetail.logging.model.LoggingDetail;
import com.example.krishnaUserDetail.logging.repository.LoggingDetailRepository;
import com.example.krishnaUserDetail.logging.service.LoggingDetailService;

@Service
public class LoggingDetailServiceImpl implements LoggingDetailService{

	@Autowired
	LoggingDetailRepository repo;
	@Override
	public void create(String exception, Timestamp creationtime, int code, boolean status, String message) {
		LoggingDetail detail = new LoggingDetail();
		detail.setException(exception);
		detail.setMessage(message);
		detail.setCode(code);
		detail.setStatus(status);
		repo.save(detail);
	}

}
