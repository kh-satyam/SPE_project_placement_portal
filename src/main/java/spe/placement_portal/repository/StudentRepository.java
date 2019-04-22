package spe.placement_portal.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import spe.placement_portal.entity.Student;



public interface StudentRepository extends CrudRepository<Student, Integer> {
	public ArrayList<Student> findAllByRollNumber(String rollNumber);
	public Student findByRollNumber(String rollNumber);
}
