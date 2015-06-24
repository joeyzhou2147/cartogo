package org.codingpedia.demo.rest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Podcast entity 
 * 
 * @author ama
 *
 */
@XmlRootElement
public class User implements Serializable {

	private static final long serialVersionUID = -8039686696076337053L;


	/* 1 - Declare
	---------------------------------------------------------------------- */
	/** user_id of the User */
	private Long user_id;

	/** phone number of the User */
	private int phone_num;

	/** email of the User */
	private String email;

	/** first name of the User*/
	private String first_name;

	/** last name of the User*/
	private String last_name;

	/** detail_address of the User */
	private String detail_address;

	/** city of the User */
	private String city;

	/** state of the User */
	private String state;

	/** user_name of the User */
	private String user_name;

	/** password of the User */
	private String password;

	/** salt of the User */
	private String salt;

	/** when user was registered on the system*/
	private Date register_date;

	/** when user was last login on the system*/
	private Date last_login;


	/* 2 - Construct
    ---------------------------------------------------------------------- */

	public User(){}

	public User(Long user_id,String email,int phone_num,String first_name,String last_name, String detail_address, String city,
				String state,String user_name,String password,String salt,Date register_date,Date last_login) {

		this.user_id = user_id;
		this.email = email;
		this.phone_num = phone_num;
		this.first_name = first_name;
		this.last_name = last_name;
		this.detail_address = detail_address;
		this.city = city;
		this.state = state;
		this.user_name = user_name;
		this.password = password;
		this.salt = salt;
		this.register_date = register_date;
		this.last_login = last_login;
	}


	/* 3 - setting
    ---------------------------------------------------------------------- */
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getPhoneNum() {
		return phone_num;
	}

	public void setPhoneNum(int phone_num) {
		this.phone_num = phone_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getDetailAddress() {
		return detail_address;
	}

	public void setDetailAddress(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getRegisterDate() {
		return register_date;
	}

	public void setRegisterDate(Date register_date) {
		this.register_date = register_date;
	}

	public Date getLastlogin() {
		return last_login;
	}

	public void setLastlogin(Date last_login) {
		this.last_login = last_login;
	}




}
