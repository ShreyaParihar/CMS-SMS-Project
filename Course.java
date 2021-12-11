package ShreyaSinghParihar_Section002_Project2;

public class Course {
	int courseid;
    String name;

    public Course(int courseid, String name) {
        this.courseid = courseid;
        this.name = name;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
    }
}
