package spe.placement_portal.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spe.placement_portal.controller.StudentController;
import spe.placement_portal.entity.Student;
import spe.placement_portal.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class StudentRepositoryUnitTests {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
    private StudentRepository  studentRepository;
	
	@Test
	public void whenFindByRollNumber_thenReturnStudent()
	{
		Student student=new Student();
		student.setRollNumber("MT0000000");
		entityManager.persist(student);
		entityManager.flush();
		
		System.out.println("whenFindByRollNumber_thenReturnStudent");
		Student found=studentRepository.findByRollNumber(student.getRollNumber());
		
		assertThat(found.getRollNumber()).isEqualTo(student.getRollNumber());
		
	}

}
