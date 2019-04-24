package spe.placement_portal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spe.placement_portal.DTO.FilterDTO;
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
	
	public ArrayList<Experience> getExperiencesByFilters(FilterDTO filter)
	{
		ArrayList<Experience> experiences=new ArrayList<Experience>();
		Iterable<Experience> iterable=experienceRepository.findAll();
		Iterator<Experience> iterator=iterable.iterator();
		while(iterator.hasNext()) {
			experiences.add(iterator.next());
		}
		
		ArrayList<Experience> expCompany=new ArrayList<Experience>();
		if(filter.getCompany()!=null)
		{
			for(Integer i=0;i<experiences.size();i++)
			{
				if(filter.getCompany().equals(experiences.get(i).getCompany()))
				{
					expCompany.add(experiences.get(i));
				}
			}
		}
		else
		{
			expCompany=new ArrayList<Experience>(experiences);
		}
		ArrayList<Experience> expType=new ArrayList<Experience>();
		if(filter.getType()!=null)
		{
			for(Integer i=0;i<expCompany.size();i++)
			{
				if(filter.getType().equals(expCompany.get(i).getType()))
				{
					expType.add(expCompany.get(i));
				}
			}
		}
		else
		{
			expType=new ArrayList<Experience>(expCompany);
		}
		ArrayList<Experience> expYear=new ArrayList<Experience>();
		if(filter.getYear()!=null)
		{
			for(Integer i=0;i<expType.size();i++)
			{
				if(filter.getYear().equals(expType.get(i).getYear())==false)
				{
					expYear.add(expType.get(i));
				}
			}
		}
		else
		{
			expYear=new ArrayList<Experience>(expType);
		}
		return expYear;
	}

	public Experience getExperienceById(Integer id) {
		return experienceRepository.findById(id).get();
	}
		
		




}
