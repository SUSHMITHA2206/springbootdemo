package com.javafullstack.springbootdemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.*;


@Entity
@Table(name = "professors")
public class Professor{
	
 public Professor(long id, String professorName, String subject,College college) {
  super();
  this.professorId = id;
  this.professorName = professorName;
  this.subject = subject;
  this.college=college;
 }


 


@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long professorId;
	
 @Column(name = "professorName")
 private String professorName;

 @Column(name = "subject")
 private String subject;

 
 @JsonBackReference
	
 @JoinColumn(name = "collegeId")
 @ManyToOne
 private College college;
	
 
 
 @JsonManagedReference
 @OneToMany(mappedBy = "professor")
 List<Student> students;
	
 public Professor() {
  
 }


public long getProfessorId() {
	return professorId;
}

public void setProfessorId(long professorId) {
	this.professorId = professorId;
}

public String getProfessorName() {
	return professorName;
}

public void setProfessorName(String professorName) {
	this.professorName = professorName;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

@Override
public String toString() {
 return "Professor [professorId=" + professorId + ", professorName=" + professorName + ", subject="
   + subject+ ", getProfessorName()=" + getProfessorName()
   + ", getSubject()=" + getSubject() + ", getProfessorId()=" + getProfessorId() + "]";
}
	
public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}

public College getCollege() {
	return college;
}


public void setCollege(College college) {
	this.college = college;
}

	
}