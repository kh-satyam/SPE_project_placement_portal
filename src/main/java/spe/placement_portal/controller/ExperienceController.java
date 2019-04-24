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

import spe.placement_portal.DTO.FilterDTO;
import spe.placement_portal.entity.Experience;
import spe.placement_portal.entity.Student;
import spe.placement_portal.services.ExperienceService;
import spe.placement_portal.services.StorageService;
import spe.placement_portal.services.StudentService;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("/experience")
public class ExperienceController {
	
	
	@Autowired
	private ExperienceService experienceService;

	@RequestMapping(method=RequestMethod.GET,value="")
	public ResponseEntity<ArrayList<Experience>> getAllExperiences(){
		return new ResponseEntity<>(experienceService.getAllExperiences(),HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addExperience")
	public ResponseEntity<String> addExperience(@RequestBody Experience experience) {
		if(experienceService.addExperience(experience)==true) {
			return new ResponseEntity<>("experience added",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping("/{id}")
	public ResponseEntity<Experience> getExperienceById(@PathVariable("id") int id){
		return new ResponseEntity<>(experienceService.getExperienceById(id),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST	, value = "/getExperiencesByFilters")
	public ResponseEntity<ArrayList<Experience>> addExperience(@RequestBody FilterDTO filter) {
		return new ResponseEntity<>(experienceService.getExperiencesByFilters(filter),HttpStatus.OK);
	}


}
