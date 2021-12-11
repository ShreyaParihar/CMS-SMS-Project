package ShreyaSinghParihar_Section002_Project2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

	// The main class declared
	class ShreyaSinghParihar_Section002_Project2 {
	    private static int num_stu;
	    private static ArrayList<Course> crse = new ArrayList<>();
	    private static ArrayList<stu_job> emp = new ArrayList<>();
	    private static int count = 0;
	    private static Student[] stu;
	    private static final Scanner s = new Scanner(System.in);
	
	    // Welcomes the uses to CMS and SMS and prompts them to enter number of students
	    public static void main(String[] args) throws IOException {

	    	new FileWriter("CourseAssignment.txt");
	        System.out.print("\n\t\t\t\tWelcome to Student and Course Management System!\n\n" +
	                "This system will allow you to manage students and courses." +
	                " Let's start with the number of students this system will have: \n");
	        num_stu = s.nextInt();
	        int decision;
	        do {
	            System.out.print("***Welcome to Student and Course Management System***\n");
	            System.out.println("\nPress '1' for Student Management System (SMS)" +
	                    "\nPress '2' for Course Management System (CMS)" +
	                    "\nPress '0' to exit\n");
	            decision = s.nextInt();
	            
	            //Using switch statements to make cases for SMS, CMS, and good bye message
	            switch (decision) {
	                case 1:
	                    StudentManagementSystem();
	                    break;
	                case 2:
	                    CourseManagementSystem();
	                    break;
	                case 0:
	                    System.out.println("Good Bye!!!");
	                    break;
	            }           
	        } while (decision != 3);
	    }
	
	    // SMS shown and the user is prompted to enter the numbers ranging 0-6 to perform the tasks they wish to
	    private static void StudentManagementSystem() throws IOException {
	        int choice;
	        stu = new Student[num_stu];
	        do {
	            System.out.println("***Welcome to SMS***\n" +
	                    "\nPress '1' to add a student\n" +
	                    "Press '2' to deactivate a student\n" +
	                    "Press '3' to display all students\n" +
	                    "Press '4' to search for a student by ID\n" +
	                    "Press '5' to assign job on campus\n" +
	                    "Press '6' to display all students with jobs on campus\n" +
	                    "Press '0' to exit SMS\n");
	            choice = s.nextInt();
	            
	         // Using the switch statement and including the 5 different cases the user can choose from to exit system, add student, activate/deactivate student, display students, and search student//
	            switch (choice) {
	                case 1:
	                    addStudent();
	                    break;
	                case 2:
	                    deactivateStudent();
	                    break;
	                case 3:
	                    printStudent();
	                    break;
	                case 4:
	                    searchStudent();
	                    break;
	                case 5:
	                    assignJob();
	                    break;
	                case 6:
	                    displayStudentsJobs();
	                    break;
	            }
	        } while (choice != 0);
	    }
	    
	    // assignJob is being used to assign on campus job as TA or RA
	    private static void assignJob() {
	        int id;
	        String job, type;
	        System.out.print("Enter student ID: ");
	        id = s.nextInt();
	        do {
	            System.out.print("Enter job: ");
	            job = s.next();
	        } while (!(job.equalsIgnoreCase("TA") || job.equalsIgnoreCase("RA")));
	        System.out.print("Enter job type: ");
	        s.nextLine();
	        type = s.nextLine();
	        for (int i = 0; i < count; i++) {
	            Student student = stu[i];
	            if (student.getStudentID() == id) {
	                emp.add(new stu_job(student.getStudentID(), student.getFirstName(),
	                        student.getLastName(), student.getLevel(), job, type));
	                System.out.println(student.getFirstName() + " " + student.getLastName() +
	                        " has been assigned " + type + " " + job + " job");
	            }
	        }
	    }
	    
	    // displays students with jobs on campus
	    private static void displayStudentsJobs() {
	        for (stu_job emp : emp) {
	            System.out.println(emp.getFirstName() + " " + emp.getLastName());
	            System.out.println("ID - " + emp.getStudentID());
	            System.out.println(emp.getEmpType() + " " + emp.getJob());
	        }
	    }
	
	    // finding number of students to add a new student and enter student level
	    private static void addStudent() {
	        if (count >= num_stu) {
	            System.out.println("Can't add more than " + num_stu + " students!");
	            return;
	        }
	        int currentID;
	        Student currentStudent;
	        String currentLevel, currentFstName, currentSndName;
	        String[] levels = {"Freshman", "Sophomore", "Junior", "Senior"};
	        boolean isFound = false;
	
	        System.out.print("Enter first name: \n");
	        currentFstName = s.next();
	        System.out.print("Enter last name: \n");
	        currentSndName = s.next();
	        do {
	            System.out.print("Enter level of the student: \n");
	            currentLevel = s.next();
	            for (String level : levels) {
	                if (currentLevel.equalsIgnoreCase(level)) {
	                    isFound = true;
	                    break;
	                }
	            }
	        } 
	        while (!isFound);
	        isFound = false;
	        do {
	            currentID = 7;
	            for (int i = 0; i < count; i++) {
	                if (stu[i].getStudentID() == currentID) {
	                    isFound = true;
	                    break;
	                }
	            }
	        } while (isFound);
	        currentStudent = new Student(currentID, currentFstName, currentSndName, currentLevel);
	        stu[count] = currentStudent;
	        System.out.println("\n" + currentFstName + " " + currentSndName + " has been added as a " +
	                currentLevel + " with ID " + currentID);
	        count++;
	        }
	    	
	    // deactivateStudent method sets active as false
	    private static void deactivateStudent() {
	        int currentID;
	        System.out.print("Enter the ID for the student you want to deactivate: \n");
	        currentID = s.nextInt();
	        for (int i = 0; i < count; i++) {
	            if (stu[i].getStudentID() == currentID) {
	                stu[i].setActive(false);
	                System.out.println("\nMary Cane has been deactivated");
	                return;
	            }
	        }
	        System.out.println("Student with ID " + currentID + " was not found!\n");
	    }
	
	    // printStudent method reads StudentReport.txt to find the name, ID, level, and status as activate or inactivate of a student with exception handling implemented
	    private static void printStudent() throws IOException {
	        new FileWriter("StudentReport.txt");
	        for (int i = 0; i < count; i++) {
	            System.out.println("\n" + stu[i].getFirstName() + " " + stu[i].getLastName());
	            System.out.println("ID: " + stu[i].getStudentID());
	            System.out.println("Level: " + stu[i].getLevel());
	            System.out.println("Status: " + (stu[i].getActive() ? "Active" : "Inactive"));
	            Files.write(Paths.get("StudentReport.txt"), ("\n" + stu[i].getFirstName() + " " + stu[i].getLastName() + "\n"
	                    + "ID: " + stu[i].getStudentID() + "\n"
	                    + "Level: " + stu[i].getLevel() + "\n"
	                    + "Status: " + (stu[i].getActive() ? "Active" : "Inactive") + "\n..."
	            ).getBytes(), StandardOpenOption.APPEND);
	        }
	    }
	
	    // searchStudent method searches the ID of a student
	    private static void searchStudent() {
	        int currentID;
	        System.out.print("Enter the student ID: ");
	        currentID = s.nextInt();
	        for (int i = 0; i < count; i++) {
	            if (stu[i].getStudentID() == currentID) {
	                System.out.println("\n" + stu[i].getFirstName() + " " + stu[i].getLastName());
	                System.out.println("ID: " + stu[i].getStudentID());
	                System.out.println("Level: " + stu[i].getLevel());
	                System.out.println("Status: " + (stu[i].getActive() ? "Active" : "Inactive"));
	                return;
	            }
	        }
	        System.out.println("Student with ID " + currentID + " was not found!");
	    }
	
	    // CourseManagementSystem (CMS) exception handling implemented as the second interface
	    private static void CourseManagementSystem() throws IOException {
	        int choice;
	        do {
	            System.out.println("\n***Welcome to CMS***\n" +
	                    "\nPress '1' to add a new course\n" +
	                    "Press '2' to assign student a new course\n" +
	                    "Press '3' to display students with their courses\n" +
	                    "Press '0' to exit CMS\n");
	            choice = s.nextInt();
	            switch (choice) {
	                case 1:
	                    addCourse();
	                    break;
	                case 2:
	                    assignCourse();
	                    break;
	                case 3:
	                    printCourses();
	                    break;
	            }
	        } while (choice != 0);
	    }
	
	    // addCourse method adds a new course
	    private static void addCourse() {
	        int courseID;
	        String name;
	        System.out.print("Enter course ID: \n");
	        courseID = s.nextInt();
	        System.out.print("Enter course name: \n");
	        s.next();
	        name = s.nextLine();
	        Course course = new Course(courseID, name);
	        crse.add(course);
	        System.out.println("Confirmation: New course " + courseID + " has been added");
	    }
	
	    // assignCourse assigns student a new course after entering student ID and course ID with exception handling implemented
	    private static void assignCourse() throws IOException {
	        int studentID, courseID;
	        System.out.print("Enter student ID: \n");
	        studentID = s.nextInt();
	        System.out.print("Enter course ID: \n");
	        courseID = s.nextInt();
	        for (int i = 0; i < stu.length; i++) {
	            if (stu[i].getStudentID() == studentID)
	                break;
	            if (i == stu.length - 1) {
	                System.out.println("Not a valid student ID!");
	                return;
	            }
	        }
	        for (int i = 0; i < crse.size(); i++) {
	            if (crse.get(i).getCourseid() == courseID)
	                break;
	            if (i == crse.size() - 1) {
	                System.out.println("This is not a valid course ID");
	                return;
	            }
	        }
	
	        for (int i = 0; i < count; i++) {
	            Student student = stu[i];
	            if (student.getStudentID() == studentID) {
	                Files.write(Paths.get("CourseAssignment.txt"),
	                        (courseID + " " + studentID + "\n").getBytes());
	                System.out.println("Confirmation: " + student.getFirstName() + " " +
	                        student.getLastName() + " has been assigned course " + courseID);
	            }
	        }
	    }
	    
	    // printCourses method reads CourseAssignment.txt to display students with assigned courses with exception handling implemented
	    private static void printCourses() throws IOException {
	        String txt = new String(Files.readAllBytes(Paths.get("CourseAssignment.txt")));
	        String[] lines = txt.split("\n");
	        for (String line : lines) {
	            String[] parts = line.split(" ");
	            for (int i = 0; i < count; i++) {
	                Student student = stu[i];
	                if (student.getStudentID() == Integer.parseInt(parts[1]))
	                    System.out.println(student.getFirstName() + " " + student.getLastName());
	                System.out.println("ID - " + student.getStudentID());
	                System.out.println("Courses: " + parts[0]);
	            }
	        }
	    }    
	}