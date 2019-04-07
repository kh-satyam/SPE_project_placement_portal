package spe.placement_portal.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spe.placement_portal.entity.Student;
import spe.placement_portal.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public boolean registerStudent(Student student) {
		boolean res=true;
		try {
			studentRepository.save(student);
		}catch(Exception e) {
			res=false;
			System.out.println(e);
		}
		return res;
	}
	
	public boolean authenticateStudent(Student student) {
		boolean res=false;
		try {
			ArrayList<Student> students=studentRepository.findAllByRollNumber(student.getRollNumber());
			for(Student obj:students) {
				if(obj.getPassword().equals(student.getPassword())) {
					res=true;
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}

}
