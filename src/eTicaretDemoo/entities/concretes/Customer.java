package eTicaretDemoo.entities.concretes;

import eTicaretDemoo.entities.abstracts.Entity;

public class Customer implements Entity {
	
		private int id;
		private String name;
		private String lastName;
		private String email;
		private String password;
		public Customer() {}
		
		public Customer(int id ,String name, String lastName, String email, String password) {
			super();
			this.name = name;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.id=id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
}
