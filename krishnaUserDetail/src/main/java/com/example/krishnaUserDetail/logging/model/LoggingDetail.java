package com.example.krishnaUserDetail.logging.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoggingDetail")

public class LoggingDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false,unique = true)
	private long id;
	@Column(name = "exception",length = 24)
	private String exception;
	@Column(name = "code",length = 24)
	private int code;
	@Column(name = "status",length = 24)
	private boolean status;
	@Column(name = "message",length = 244)
	private String message;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp creationtime;
	
	//getter-setter methods
	
	public long getId() {
		return id;
	}
	public String getException() {
		return exception;
	}
	public int getCode() {
		return code;
	}
	public boolean isStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Timestamp getCreationtime() {
		return creationtime;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	

}
