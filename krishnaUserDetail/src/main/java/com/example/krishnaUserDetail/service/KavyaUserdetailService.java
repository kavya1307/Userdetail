package com.example.krishnaUserDetail.service;

import org.springframework.http.ResponseEntity;

import com.example.krishnaUserDetail.dto.KavyaUserdetailDTO;
import com.example.krishnaUserDetail.model.KavyaUserdetail;

public interface KavyaUserdetailService {
	
	public ResponseEntity<?> createUserdetail(KavyaUserdetailDTO dto);
	public ResponseEntity<?> getAllUser();
	public ResponseEntity<?> deleteUserDetail(String usertoken);
	public ResponseEntity<?> updateUserDetail(String usertoken,KavyaUserdetail dto);

}
