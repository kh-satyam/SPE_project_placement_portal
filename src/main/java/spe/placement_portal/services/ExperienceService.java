package spe.placement_portal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spe.placement_portal.entity.Experience;
import spe.placement_portal.entity.Student;
import spe.placement_portal.repository.ExperienceRepository;
import spe.placement_portal.repository.StudentRepository;

@Service
public class ExperienceService {
	
	@Autowired
	private ExperienceRepository experienceRepository;
	
	
	public boolean addExperience(Experience experience) {
		String date = experience.getDate();
		String year = String.valueOf(date.charAt(0))+date.charAt(1)+date.charAt(2)+date.charAt(3);
		experience.setYear(year);
		boolean res=true;
		try {
			experienceRepository.save(experience);
		}catch(Exception e) {
			res=false;
			System.out.println(e);
		}
		return res;
	}
	

	public ArrayList<Experience> getAllExperiences()
	{
		
		ArrayList<Experience> experiences=new ArrayList<Experience>();
		Iterable<Experience> iterable=experienceRepository.findAll();
		Iterator<Experience> iterator=iterable.iterator();
		while(iterator.hasNext()) {
			experiences.add(iterator.next());
		}
		return experiences;
	}

	public Experience getExperienceById(Integer id) {
		return experienceRepository.findById(id).get();
	}
		
		




}
