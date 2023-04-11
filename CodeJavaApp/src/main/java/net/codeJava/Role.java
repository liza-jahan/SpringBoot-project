package net.codeJava;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "roles")
	public class Role {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	     
	    @Column(nullable = false, length = 45)
	    private String name;
	 
	    public Role() { }
	     
	    public Role(String name) {
	        this.name = name;
	    }
	     
	    public Role(Integer id, String name) {
	        this.id = id;
	        this.name = name;
	    }
	 
	    public Role(Integer id) {
	        this.id = id;
	    }
	     
	 
		

		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		@Override
	    public String toString() {
	        return this.name;
	    }

		
	}


