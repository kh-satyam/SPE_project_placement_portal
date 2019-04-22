package spe.placement_portal.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String rollNumber;
	private String firstName;
	private String lastName;
	private String dob;
	private String personalEmail;
	private String officialEmail;
	private float cgpa;
	private String cvUrl;
	private String courseType;
	private String courseStream;
	private String batch;
	private String password;
	private String contactNumber;
	public Student() {
		super();
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseStream() {
		return courseStream;
	}
	public void setCourseStream(String courseStream) {
		this.courseStream = courseStream;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getOfficialEmail() {
		return officialEmail;
	}
	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}
	public String getCvUrl() {
		return cvUrl;
	}
	public void setCvUrl(String cvUrl) {
		this.cvUrl = cvUrl;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", personalEmail=" + personalEmail + ", officialEmail=" + officialEmail
				+ ", cgpa=" + cgpa + ", cvUrl=" + cvUrl + ", courseType=" + courseType + ", courseStream="
				+ courseStream + ", batch=" + batch + ", password=" + password + ", contactNumber=" + contactNumber
				+ "]";
	}

	
	
}
