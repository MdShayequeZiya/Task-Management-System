package com.tms.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", initialValue = 100, allocationSize = 1, sequenceName = "user_generator")
	private int id;
	
	private String name;
	private String email;
	private String password;
	private String role;
	private String designation;
	private double salary;
	
	@OneToMany(mappedBy = "assignedTo")
	private List<Task> task;
	
	@CreationTimestamp
	private LocalDateTime userCreatedTime;

}
