package com.service.user.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
 @Id
 @Column(name="id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public Long id;
 
 @Column(name="name", nullable = false, length = 30)
 public String name;
 
 @DateTimeFormat(pattern = "dd/MM/yyyy")
 @Column(name="dateBirth")
 public Date dateBirth;

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

public Date getDateBirth() {
	return dateBirth;
}

public void setDateBirth(Date dateBirth) {
	this.dateBirth = dateBirth;
}

@Override
public String toString() {
	return "Users [id=" + id + ", name=" + name + ", dateBirth=" + dateBirth + "]";
}



}



