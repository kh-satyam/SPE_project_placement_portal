package spe.placement_portal.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spe.placement_portal.entity.Company;
import spe.placement_portal.entity.Student;
import spe.placement_portal.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StorageService storageService;
	
	
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
	
	public boolean updateStudentProfile(Student student)
	{
		boolean result=true;
		try {
			Student studentObj=studentRepository.findByRollNumber(student.getRollNumber());
			student.setCvUrl(studentObj.getCvUrl());
			student.setPassword(studentObj.getPassword());
			student.setId(studentObj.getId());
			System.out.println(student);
			studentRepository.save(student);
		}
		catch(Exception e)
		{
			result=false;
			System.out.println(e);
		}
		return result;
	}
	
	public Student getStudentByRollNumber(String rollNumber)
	{
		Student student=null;
		try {
			
			student=studentRepository.findByRollNumber(rollNumber);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return student;
	}
	
	public ArrayList<Student> getAllStudents()
	{
		ArrayList<Student> students =new ArrayList<Student>();
		Iterable<Student> iterable=studentRepository.findAll();
		Iterator<Student> iterator=iterable.iterator();
		while(iterator.hasNext()) {
			students.add(iterator.next());
		}
		return students;
	}
	
	public String greetingMessage() {
		return "Hello Student";
	}
	
	public boolean updateCv(String rollNumber,MultipartFile cv)
	{
		Boolean res=true;
		try {
			Student student=studentRepository.findByRollNumber(rollNumber);
			res=storageService.updateCv(rollNumber, cv);
			student.setCvUrl(rollNumber);
			System.out.println("cv " + student);
			studentRepository.save(student);
		}catch(Exception e)
		{
			res=false;
			System.out.println(e);
		}
		return res;
	}
	
	public boolean canRegisterStudent(Student student)
	{
		boolean result=true;
		try
		{
			Student found = studentRepository.findByRollNumber(student.getRollNumber());
			if(found.getRollNumber().equals(student.getRollNumber())==false)
			{
				result=false;
			}
			if(found.getOfficialEmail().equals(student.getOfficialEmail())==false)
			{
				result=false;
			}
		}catch(Exception e)
		{
			result=false;
			System.out.println(e);
		}
		return result;
	}
}
