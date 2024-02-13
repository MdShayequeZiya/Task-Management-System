package com.tms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "task_generator")
	@SequenceGenerator(name = "task_generator", initialValue = 100, allocationSize = 1, sequenceName = "task_generator")
	private int id;
	
	private String description;
	
	@CreationTimestamp
	private LocalDateTime createdTaskTime;
	@UpdateTimestamp
	private LocalDateTime taskCompletedTime;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "assigned_to_id")
	private UserInfo assignedTo;		// reference to the assigned employee

}
