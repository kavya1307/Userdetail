package com.example.krishnaUserDetail.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class KavyaUserdetail {
	
	@Id
	public String usertoken;
	public String firstname;
	public String lastname;
	public String email;
	public String username;
	public String contact;
	public String designation;
	public String bloodgroup;
	public String gender;
	public String address;
	public String password;

	public String role;
	public String createdtime;
	public String updatetime;
	
	
	public String getUsertoken() {
		return usertoken;
	}
	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreatedtime() {
		return createdtime;
	}
	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "KavyaUserdetail [usertoken=" + usertoken + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", username=" + username + ", contact=" + contact + ", designation="
				+ designation + ", bloodgroup=" + bloodgroup + ", gender=" + gender + ", address=" + address
				+ ", password=" + password + ", role=" + role + ", createdtime=" + createdtime + ", updatetime="
				+ updatetime + "]";
	}
	public String getConfirmpassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
