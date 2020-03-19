package com.service.user.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



@Entity
@Table(name="users")
public class User {
 @Id
 @Column(name="id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public Long id;
 
 @Column(name="name", nullable = false, length = 30)
 public String name;
 

 @JsonFormat(pattern = "yyyy/MM/dd", shape= Shape.STRING)
 @Column(name="dateBirth")
 public String dateBirth;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDateBirth() {
	return dateBirth;
}


public void setDateBirth(String dateBirth) {
	this.dateBirth = dateBirth;
}


@Override
public String toString() {
	return "Users [id=" + id + ", name=" + name + ", dateBirth=" + dateBirth + "]";
}



}



