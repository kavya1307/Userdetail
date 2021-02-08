package com.example.krishnaUserDetail.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class KavyaUserRespo {

	public HashMap<String,Object> addMap(LinkedHashMap<String, Object> addmap){
		LinkedHashMap<String , Object> datamap = new LinkedHashMap<String , Object>(); 
		datamap.put("code", 200);
		datamap.put("status", true);
		datamap.put("message", "User Created....");
		datamap.put("data", addmap);
		return datamap;
	}
	public HashMap<String,Object> getUseraddMap(List<KavyaUserdetail> list){
		LinkedHashMap<String , Object> datamap = new LinkedHashMap<String , Object>(); 
		datamap.put("code", 200);
		datamap.put("status", true);
		datamap.put("message", "GetAll User....");
		datamap.put("data", list);
		return datamap;
	}
	
	public HashMap<String,Object> deleteUseraddMap(String usertoken){
		LinkedHashMap<String , Object> datamap = new LinkedHashMap<String , Object>(); 
		datamap.put("code", 200);
		datamap.put("status", true);
		datamap.put("message", "Delete User....");
		datamap.put("usertoken", usertoken);
		return datamap;
	}
	
	public HashMap<String,Object> updateUseraddMap(KavyaUserdetail UserDetail){
		LinkedHashMap<String , Object> datamap = new LinkedHashMap<String , Object>(); 
		datamap.put("code", 200);
		datamap.put("status", true);
		datamap.put("message", "Update UserDetail....");
		datamap.put("data" , UserDetail);
		return datamap;
	}
}
