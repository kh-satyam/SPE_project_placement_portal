package spe.placement_portal.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import spe.placement_portal.entity.Company;
import spe.placement_portal.entity.Experience;
import spe.placement_portal.entity.Student;



public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
