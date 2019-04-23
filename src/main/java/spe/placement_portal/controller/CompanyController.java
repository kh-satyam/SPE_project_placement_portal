package spe.placement_portal.controller;

import java.util.ArrayList;
import java.util.List;

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

import spe.placement_portal.entity.Company;
import spe.placement_portal.entity.Experience;
import spe.placement_portal.entity.Student;
import spe.placement_portal.services.CompanyService;
import spe.placement_portal.services.ExperienceService;
import spe.placement_portal.services.StorageService;
import spe.placement_portal.services.StudentService;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(method=RequestMethod.GET,value="")
	public ResponseEntity<ArrayList<Company>> getAllCompanies(){
		return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCompany")
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		if(companyService.addCompany(company)==true) {
			return new ResponseEntity<>("company added",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
		}
	}


}
