package com.javafullstack.springbootdemo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javafullstack.springbootdemo.model.Student;
import com.javafullstack.springbootdemo.model.Student.StudentDTOIntf;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String fname, Sort sort);

    List<Student> findByFirstNameAndLastName(String fname, String lname);

    List<Student> findByFirstNameOrLastName(String fname, String lname);
//   
//    List<Student> findAll();
    
    List<Student> findByOrderByTotalDesc();
    @Query(value="select s.id,s.first_name as firstName ,s.total,p.professor_id as ProfessorId ,p.professor_name as ProfessorName from students s,professors p where s.professor_id=p.professor_id and p.professor_id=:pid", nativeQuery = true)
    List<StudentDTOIntf> getStudentProfDetails(@Param("pid") int pid);

}
