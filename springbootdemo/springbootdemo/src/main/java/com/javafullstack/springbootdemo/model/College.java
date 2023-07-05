package com.javafullstack.springbootdemo.model;



import java.util.List;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.*;


@Entity
@Table(name = "colleges")
public class College{
	
 public College(long id, String collegeName, String department) {
  super();
  this.collegeId = id;
  this.collegeName = collegeName;
  this.department = department;
 }



@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long collegeId;
	
 @Column(name = "collegeName")
 private String collegeName;

 @Column(name = "department")
 private String department;

 
 
 
 @JsonManagedReference
 @OneToMany(mappedBy = "college")
 List<Professor> professors;
	
 public College() {
  
 }
 public long getCollegeId() {
	return collegeId;
}

public void setCollegeId(long collegeId) {
	this.collegeId = collegeId;
}

public String getCollegeName() {
	return collegeName;
}

public void setCollegeName(String collegeName) {
	this.collegeName = collegeName;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}


@Override
public String toString() {
 return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", department="
   + department+ ", getCollegeName()=" + getCollegeName()
   + ", getDepartment()=" + getDepartment() + ", getCollegeId()=" + getCollegeId() + "]";
}
public List<Professor> getProfessors() {
	return professors;
}

public void setProfessors(List<Professor> professors) {
	this.professors = professors;
}


}