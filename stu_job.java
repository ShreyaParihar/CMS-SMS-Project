package ShreyaSinghParihar_Section002_Project2;

import ShreyaSinghParihar_Section002_Project2.Student;

	public class stu_job extends Student {
	    String job_type;
	    String job;
	
	    public stu_job(String job_type, String job) {
	        this.job_type = job_type;
	        this.job = job;
	    }
	
	    public stu_job(int studentID, String firstName, String lastName, String level, String empType, String job) {
	        super(studentID, firstName, lastName, level);
	        this.job_type = empType;
	        this.job = job;
	    }
	
	    public String getEmpType() {
	        return job_type;
	    }
	
	    public void setEmpType(String empType) {
	        this.job_type = empType;
	    }
	
	    public String getJob() {
	        return job;
	    }
	
	    public void setJob(String job) {
	        this.job = job;
	    }
	
	    public String toString() {
	        return "Student_Employee{" +
	                "studentID=" + studentID +
	                ", firstName='" + f_name + '\'' +
	                ", lastName='" + l_name + '\'' +
	                ", empType='" + job_type + '\'' +
	                ", job='" + job + '\'' +
	                '}';
	    }
	}