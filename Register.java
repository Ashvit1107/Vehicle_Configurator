package servlet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Register 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String address;
	private int conntactNumber;
	private String EMail;
	private String userId;
	private String password;
		
	@NotEmpty(message="name can not be empty")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain characters")
	public String getName() {
		return name;
	}	
	@Column
	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message="Address can not be empty")
	public String getAddress() {
		return address;
	}	
	@Column
	public void setAddress(String address) {
		this.address = address;
	}
	
	@NotEmpty(message="email can not be empty")
	@Email(message="invalid email id")
	public String getEMail() {
		return EMail;
	}	
	@Column
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	
	@NotEmpty(message="UserID can not be empty")
	@Pattern(regexp = "[A-Za-z0-9_]+", message = "UserID must contain only Alphabets, Numbers and _ ")
	public String getUserId() {
		return userId;
	}	
	@Column
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@NotEmpty(message="Password can not be empty")
	@Pattern(regexp = "[A-Za-z0-9_]+", message = "Password    must contain only Alphabets, Numbers and _ ")
	public String getPassword() {
		return password;
	}	
	@Column
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getConntactNumber() {
		return conntactNumber;
	}
	@Column
	public void setConntactNumber(int conntactNumber) {
		this.conntactNumber = conntactNumber;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", address=" + address
				+ ", conntactNumber=" + conntactNumber + ", EMail=" + EMail
				+ ", userId=" + userId + ", password=" + password + "]";
	}
	
	
}
