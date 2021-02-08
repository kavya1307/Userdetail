package com.example.krishnaUserDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.krishnaUserDetail.model.KavyaUserdetail;

public interface KavyaUserdetailRepository extends JpaRepository<KavyaUserdetail, String> {

	KavyaUserdetail findByEmail(String email);

	KavyaUserdetail findByUsername(String username);

	KavyaUserdetail findByUsertoken(String usertoken);
	
	

}
