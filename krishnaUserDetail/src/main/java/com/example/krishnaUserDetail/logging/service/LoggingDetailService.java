package com.example.krishnaUserDetail.logging.service;

import java.sql.Timestamp;

public interface LoggingDetailService {

	void create(String exception,Timestamp creationtime, int code,boolean status,String message);
}
