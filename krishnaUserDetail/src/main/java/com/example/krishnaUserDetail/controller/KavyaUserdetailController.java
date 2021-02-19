package com.example.krishnaUserDetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.krishnaUserDetail.dto.KavyaUserdetailDTO;
import com.example.krishnaUserDetail.logging.service.LoggingDetailService;
import com.example.krishnaUserDetail.model.KavyaUserdetail;
import com.example.krishnaUserDetail.service.KavyaUserdetailService;

@Controller
@RequestMapping(value = "/KavyaUserDetail")
public class KavyaUserdetailController {

	@Autowired
	KavyaUserdetailService service;
	
	
	//for create the user
	@PostMapping(value = "/addinguser")
	public ResponseEntity<?> createuser(@RequestBody KavyaUserdetailDTO  dto)throws Exception {
		return ResponseEntity.ok(service.createUserdetail(dto));
		
	}
	
	//for get all the user
	@GetMapping("/gettinguser")
	public ResponseEntity<?> getalluser(){
			
			return service.getAllUser();	
	}
	
	//for delete the user
	@DeleteMapping("/deletinguser")
	public ResponseEntity<?> deleteuser(@RequestParam String usertoken){
	
		return service.deleteUserDetail(usertoken);
		
	}
	
	//for update the user
	@PutMapping("/updatinguser")
	public ResponseEntity<?> updateuser(@RequestParam String usertoken,@RequestBody KavyaUserdetail dto)
	{
		return service.updateUserDetail(usertoken, dto);
		
	}
	
	
	
	
	
	
	
}
