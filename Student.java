package ShreyaSinghParihar_Section002_Project2;

public class Student {

	//The student class implemented
		    int studentID;
		    String f_name;
		    String l_name;
		    String level;
		    boolean active;
		
		    Student() {
		        studentID = 0;
		        f_name = l_name = level = "";
		        active = true;
		    }
		
		    // Student is object with ID randomly assigned between 0 and 99, first name, last name, and level as freshman, sophomore, junior, or senior
		    public Student(int studentID, String firstName, String lastName, String level) {
		        this.studentID = studentID;
		        this.f_name = firstName;
		        this.l_name = lastName;
		        this.level = level;
		        this.active = true;
		    }
		
		    public int getStudentID() {
		        return studentID;
		    }
		
		    public String getFirstName() {
		        return f_name;
		    }
		
		    public String getLastName() {
		        return l_name;
		    }
		
		    public String getLevel() {
		        return level;
		    }
		
		    public boolean getActive() {
		        return active;
		    }
		
		    public void setStudentID(int studentID) {
		        this.studentID = studentID;
		    }
		
		    public void setFirstName(String firstName) {
		        this.f_name = firstName;
		    }
		
		    public void setLastName(String lastName) {
		        this.l_name = lastName;
		    }
		
		    public void setLevel(String level) {
		        this.level = level;
		    }
		
		    public void setActive(boolean active) {
		        this.active = active;
		    }
		}
