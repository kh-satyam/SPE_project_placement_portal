package spe.placement_portal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spe.placement_portal.entity.Company;
import spe.placement_portal.entity.Experience;
import spe.placement_portal.entity.Student;
import spe.placement_portal.repository.CompanyRepository;
import spe.placement_portal.repository.ExperienceRepository;
import spe.placement_portal.repository.StudentRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	public boolean addCompany(Company company) {
		boolean res=true;
		try {
			companyRepository.save(company);
		}catch(Exception e) {
			res=false;
			System.out.println(e);
		}
		return res;
	}
	

	public ArrayList<Company> getAllCompanies()
	{
		ArrayList<Company> companies=new ArrayList<Company>();
		Iterable<Company> iterable=companyRepository.findAll();
		Iterator<Company> iterator=iterable.iterator();
		while(iterator.hasNext()) {
			companies.add(iterator.next());
		}
		return companies;
	}
	public String greetingMessage() {
		return "greetingmessage";
	}

}
