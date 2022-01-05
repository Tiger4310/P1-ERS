package com.ERS.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

		@Column
		public String email;
		
		@Column(name = "first_name")
		public String firstName;
		
		@Column(name= "last_name")
		public String lastName;
		
		@Column
		public String password;
		
		@Column(name = "role_id")
		@JoinColumn(name = "role_id")
		public int roleId;
		
		@Column
		public String username;
	  
		@Id
	    @Column(name = "user_id")
	    public int userId;

		
		public String getEmail() {
			return email;
		}

		
		public void setEmail(String email) {
			this.email = email;
		}

		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getRoleId() {
			return roleId;
		}

		
		public void setRoleId(int roleId) {
			this.roleId = roleId;
		}

		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(email, firstName, lastName, password, roleId, userId, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
					&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
					&& roleId == other.roleId && userId == other.userId && Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
					+ ", roleId=" + roleId + ", username=" + username + ", userId=" + userId + "]";
		}

		public User(String email, String firstName, String lastName, String password, int roleId, String username,
				int userId) {
			super();
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.roleId = roleId;
			this.username = username;
			this.userId = userId;
		}

		public User() {
			super();
		}

		public User(String password, String username) {
			super();
			this.password = password;
			this.username = username;
		}
	}
	
		