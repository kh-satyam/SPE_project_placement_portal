package spe.placement_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spe.placement_portal.entity.Student;
import spe.placement_portal.services.StudentService;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	

	
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		if(studentService.registerStudent(student)==true) {
			return new ResponseEntity<>("registration successfull",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("registration denied",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public ResponseEntity<String> authenticateStudent(@RequestBody Student student){
		if(studentService.authenticateStudent(student)==true)
		{
			return new ResponseEntity<>("login success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("login denied",HttpStatus.UNAUTHORIZED);
		}
	}

}
