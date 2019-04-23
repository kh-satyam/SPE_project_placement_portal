package spe.placement_portal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import spe.placement_portal.entity.Student;
import spe.placement_portal.services.StorageService;
import spe.placement_portal.services.StudentService;


//added for log
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;
import org.apache.logging.log4j.Level;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("/student")
public class StudentController {
	private static final Logger LOG = LogManager.getLogger(StudentController.class.getName());
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StorageService storageService;
	
	@RequestMapping(method=RequestMethod.GET,value="/{rollNumber}")
	public ResponseEntity<Student> registerStudent(@PathVariable("rollNumber") String rollNumber){
		Student student=studentService.getStudentByRollNumber(rollNumber);
		if(student==null)
		{
			return new ResponseEntity<>(studentService.getStudentByRollNumber(rollNumber),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(studentService.getStudentByRollNumber(rollNumber),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		if(studentService.registerStudent(student)==true) {
			String response = student.getRollNumber() +  " registration success " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("registration successfull",HttpStatus.OK);
		}
		else
		{
			String response = student.getRollNumber() +  " registration fail " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("registration denied",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public ResponseEntity<String> authenticateStudent(@RequestBody Student student){
		if(studentService.authenticateStudent(student)==true)
		{
			String response = student.getRollNumber() +  " log in success " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("login success",HttpStatus.OK);
		}
		else
		{
			String response = student.getRollNumber() +  " log in fail " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("login denied",HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update")
	public ResponseEntity<String> updateStudentProfile(@RequestBody Student student){
		if(studentService.updateStudentProfile(student)==true)
		{
			String response = student.getRollNumber() +  " profile update success " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("profile updated",HttpStatus.OK);
		}
		else
		{
			String response = student.getRollNumber() +  " profile update fail " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("error",HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateCv")
	public ResponseEntity<String> addItem(@RequestParam(value = "formData", required = false) String rollNumber,@RequestParam("file") MultipartFile cv) {
		//String res=itemService.addItem(file,formData);
		if(studentService.updateCv(rollNumber, cv)==true)
		{
			String response = rollNumber +  " cv update success  " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("resume updated",HttpStatus.OK);
		}
		else
		{
			String response = rollNumber +  " cv update fail  " + new Date();
			LOG.log(Level.INFO, response);
			return new ResponseEntity<>("error",HttpStatus.OK);
		}
		//storageService.uploadFile(file,formData);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/}")
	public ResponseEntity<ArrayList<Student>> getAllStudents(@PathVariable("rollNumber") String rollNumber){
		return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/greetingmessage")
	public ResponseEntity<String> getGreetingMessage()
	{
		return new ResponseEntity<>(studentService.greetingMessage(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/canRegisterStudent")
	public ResponseEntity<String> canRegisterStudent(@RequestBody Student student)
	{
		if(studentService.canRegisterStudent(student))
		{
			return new ResponseEntity<>("true",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("false",HttpStatus.OK);
		}
		
	}

}
