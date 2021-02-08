package com.example.krishnaUserDetail.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.krishnaUserDetail.dto.KavyaUserdetailDTO;
import com.example.krishnaUserDetail.model.KavyaUserRespo;
import com.example.krishnaUserDetail.model.KavyaUserdetail;
import com.example.krishnaUserDetail.repository.KavyaUserdetailRepository;
import com.example.krishnaUserDetail.service.KavyaUserdetailService;

@Service
public class KavyaUserdetailServiceImpl implements KavyaUserdetailService{
	
	@Autowired
	KavyaUserdetailRepository repository;
	@Autowired
	KavyaUserRespo res;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime ldt = LocalDateTime.now();

	@Override
	public ResponseEntity<?> createUserdetail(KavyaUserdetailDTO dto) {
		
		LinkedHashMap<String, Object> hashmap = new LinkedHashMap<String, Object>();

		String regexp = "^[a-zA-Z]*$";
		String firstname = dto.getFirstname();
		if (null == firstname) {
			hashmap.put("code", 400);
			hashmap.put("message", "First Name is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (firstname == "") {
			hashmap.put("code", 400);
			hashmap.put("message", "First Name is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		boolean firstNameValid = firstname.matches(regexp);

		if (!(firstNameValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "First Name has Only Alphabets.");
			hashmap.put("status", false);
			hashmap.put("firstName", firstname);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}
		String lastname = dto.getLastname();
		if (null == lastname) {
			hashmap.put("code", 404);
			hashmap.put("message", "Last Name is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (lastname == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Last Name is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		boolean lastNameValid = lastname.matches(regexp);

		if (!(lastNameValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Last Name has Only Alphabets.");
			hashmap.put("status", false);
			hashmap.put("firstName", firstname);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		String email = dto.getEmail();
		if (null == email) {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (email == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		boolean emailValid = email.matches(emailRegex);

		if (!(emailValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is not Valid.");
			hashmap.put("status", false);
			hashmap.put("email", email);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		KavyaUserdetail detail = repository.findByEmail(email);

		if (null != detail) {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is Already Exist.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String username = dto.getUsername();
		if (null == username) {
			hashmap.put("code", 404);
			hashmap.put("message", "UserName is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (username == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "UserName is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		KavyaUserdetail repoUname = repository.findByUsername(username);

		if (null != repoUname) {
			hashmap.put("code", 404);
			hashmap.put("message", "UserName is Already Exist.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String contact = dto.getContact();
		String cregex = "^[0-9]*$";

		if (null == contact) {
			hashmap.put("code", 404);
			hashmap.put("message", "Contact is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (contact == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Contact is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		boolean contactValid = contact.matches(cregex);

		if (!(contactValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Contact is not Valid.");
			hashmap.put("status", false);
			hashmap.put("contact", contact);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String designation = dto.getDesignation();
		if (null == designation) {
			hashmap.put("code", 404);
			hashmap.put("message", "Designation is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (designation == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Designation is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		String bloodgroup = dto.getBloodgroup();
		if (null == bloodgroup) {
			hashmap.put("code", 404);
			hashmap.put("message", "Bloodgroup is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (bloodgroup == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Bloodgroup is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		
		String gender = dto.getGender();
		if (null == gender) {
			hashmap.put("code", 404);
			hashmap.put("message", "Gender is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (gender == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Gender is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		String address = dto.getAddress();

		if (null == address) {
			hashmap.put("code", 404);
			hashmap.put("message", "Address is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (address == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Address is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		String password = dto.getPassword();
		String confirmpassword = dto.getConfirmpassword();

		if (password == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Password is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (null == password) {
			hashmap.put("code", 404);
			hashmap.put("message", "Password is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (null == confirmpassword) {
			hashmap.put("code", 404);
			hashmap.put("message", "ConfirmPassword is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (confirmpassword == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "ConfirmPassword is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		boolean validpass = password.equals(confirmpassword);
		if (validpass == false) {
			hashmap.put("code", 410);
			hashmap.put("message", "Password and confirm password are not same");
			hashmap.put("status", false);
			hashmap.put("password", password);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}
		String role = dto.getRole();
		if (null == role) {
			hashmap.put("code", 404);
			hashmap.put("message", "Role is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (role == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Role is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		boolean uservalid = role.equals("ROLE_USER");
		boolean adminvalid = role.equals("ROLE_ADMIN");
		if (!(uservalid || adminvalid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Role has only ROLE_USER or ROLE_ADMIN.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		
		else {
		
		dto.setUsertoken(generateRandom());
		dto.setCreatedtime(dtf.format(ldt));
		ModelMapper mapper = new ModelMapper();
		KavyaUserdetail model = mapper.map(dto, KavyaUserdetail.class);
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("firstName", model.getFirstname());
		map.put("lastName", model.getLastname());
		map.put("email", model.getEmail());
		map.put("userName", model.getUsername());
		map.put("contact", model.getContact());
		map.put("designation", model.getDesignation());
		map.put("createdTime", model.getCreatedtime());
		map.put("bloodgroup", model.getBloodgroup());
		map.put("gender", model.getGender());
		map.put("address", model.getAddress());
		map.put("password", model.getPassword());
		map.put("role", model.getRole());	
		return ResponseEntity.ok(res.addMap(map));
		}	
		
	}

	private String generateRandom() {
		String aToZ = "01234ABCDEFGHIJKLMNO012345PQRSTUVWXYZ678901235abcdefghijklmnopqrstuvwxyz6789";

		Random rand = new Random();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			int randIndex = rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
		}

	@Override
	public ResponseEntity<?> getAllUser() {
		
		List<KavyaUserdetail> listUser = repository.findAll();
		return ResponseEntity.ok(res.getUseraddMap(listUser));	}

	@Override
	public ResponseEntity<?> deleteUserDetail(String usertoken) {
		
		KavyaUserdetail kavya = repository.findByUsertoken(usertoken);
		LinkedHashMap<String, Object> hashmap = new LinkedHashMap<String, Object>();
		if (null == kavya) {
			hashmap.put("code", 404);
			hashmap.put("message", "User is not Found.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);

		}
		repository.delete(kavya);
		
		return ResponseEntity.ok(res.deleteUseraddMap(usertoken));
	}

	

	@Override
	public ResponseEntity<?> updateUserDetail(String usertoken, KavyaUserdetail dto) {
		LinkedHashMap<String, Object> hashmap = new LinkedHashMap<String, Object>();

		String regexp = "^[a-zA-Z]*$";
		String firstname = dto.getFirstname();
		if (null == firstname) {
			hashmap.put("code", 400);
			hashmap.put("message", "First Name is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (firstname == "") {
			hashmap.put("code", 400);
			hashmap.put("message", "First Name is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		boolean firstNameValid = firstname.matches(regexp);

		if (!(firstNameValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "First Name has Only Alphabets.");
			hashmap.put("status", false);
			hashmap.put("firstName", firstname);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}
		String lastname = dto.getLastname();
		if (null == lastname) {
			hashmap.put("code", 404);
			hashmap.put("message", "Last Name is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (lastname == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Last Name is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		boolean lastNameValid = lastname.matches(regexp);

		if (!(lastNameValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Last Name has Only Alphabets.");
			hashmap.put("status", false);
			hashmap.put("firstName", firstname);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		String email = dto.getEmail();
		if (null == email) {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (email == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		boolean emailValid = email.matches(emailRegex);

		if (!(emailValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is not Valid.");
			hashmap.put("status", false);
			hashmap.put("email", email);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		KavyaUserdetail detail = repository.findByEmail(email);

		if (null != detail) {
			hashmap.put("code", 404);
			hashmap.put("message", "Email is Already Exist.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String username = dto.getUsername();
		if (null == username) {
			hashmap.put("code", 404);
			hashmap.put("message", "UserName is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (username == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "UserName is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		KavyaUserdetail repoUname = repository.findByUsername(username);

		if (null != repoUname) {
			hashmap.put("code", 404);
			hashmap.put("message", "UserName is Already Exist.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String contact = dto.getContact();
		String cregex = "^[0-9]*$";

		if (null == contact) {
			hashmap.put("code", 404);
			hashmap.put("message", "Contact is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (contact == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Contact is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		boolean contactValid = contact.matches(cregex);

		if (!(contactValid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Contact is not Valid.");
			hashmap.put("status", false);
			hashmap.put("contact", contact);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}

		String designation = dto.getDesignation();
		if (null == designation) {
			hashmap.put("code", 404);
			hashmap.put("message", "Designation is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (designation == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Designation is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		String bloodgroup = dto.getBloodgroup();
		if (null == bloodgroup) {
			hashmap.put("code", 404);
			hashmap.put("message", "Bloodgroup is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (bloodgroup == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Bloodgroup is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		
		String gender = dto.getGender();
		if (null == gender) {
			hashmap.put("code", 404);
			hashmap.put("message", "Gender is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (gender == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Gender is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		String address = dto.getAddress();

		if (null == address) {
			hashmap.put("code", 404);
			hashmap.put("message", "Address is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (address == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Address is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		String password = dto.getPassword();
		String confirmpassword = dto.getConfirmpassword();

		if (password == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Password is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (null == password) {
			hashmap.put("code", 404);
			hashmap.put("message", "Password is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (null == confirmpassword) {
			hashmap.put("code", 404);
			hashmap.put("message", "ConfirmPassword is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (confirmpassword == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "ConfirmPassword is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		boolean validpass = password.equals(confirmpassword);
		if (validpass == false) {
			hashmap.put("code", 410);
			hashmap.put("message", "Password and confirm password are not same");
			hashmap.put("status", false);
			hashmap.put("password", password);
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(hashmap);
		}
		String role = dto.getRole();
		if (null == role) {
			hashmap.put("code", 404);
			hashmap.put("message", "Role is not Available.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		if (role == "") {
			hashmap.put("code", 404);
			hashmap.put("message", "Role is Empty.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}

		boolean uservalid = role.equals("ROLE_USER");
		boolean adminvalid = role.equals("ROLE_ADMIN");
		if (!(uservalid || adminvalid)) {
			hashmap.put("code", 404);
			hashmap.put("message", "Role has only ROLE_USER or ROLE_ADMIN.");
			hashmap.put("status", false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashmap);
		}
		
		else {
		
		dto.setCreatedtime(dtf.format(ldt));
		ModelMapper mapper = new ModelMapper();
		KavyaUserdetail model = mapper.map(dto, KavyaUserdetail.class);
		repository.save(model);
		return ResponseEntity.ok(res.updateUseraddMap(model));
		}	
			}
	}
	
	

