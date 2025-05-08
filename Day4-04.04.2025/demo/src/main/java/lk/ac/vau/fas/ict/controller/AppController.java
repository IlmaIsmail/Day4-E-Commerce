package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;


@RestController
@RequestMapping("/app")
public class AppController {
	
	//create some student objects
	
	Student s1 = new Student("2020ICT48","Ilma",23,"IT",3.7);
	Student s2 = new Student("2020ICT56","Pabo",24,"AMC",3.5);
	Student s3 = new Student("2020ICT88","Nimna",22,"Bio",3.4);
	Student s4 = new Student("2020ICT47","Malee",23,"IT",3.6);
	Student s5 = new Student("2020ICT31","Ruwi",24,"IT",3.8);
	
	List<Student> students = new ArrayList<Student>();
	List<Student> studentsAge = new ArrayList<Student>();
	List<Student> sortedStudents = new ArrayList<>(students);
	
	private Map<String,Student> mstudents = new HashMap<String,Student>();
	
	public AppController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);	
		
		mstudents.put(s1.getRegNo(),s1);
		mstudents.put(s2.getRegNo(),s2);
		mstudents.put(s3.getRegNo(),s3);
		mstudents.put(s4.getRegNo(),s4);
		mstudents.put(s5.getRegNo(),s5);
		
	}

	@GetMapping("/msg")
	public String myMessage() {
		return "Hello Springboot!";
	}
	
	@GetMapping("/name")
	public String myName() {
		return "My name is Springboot!";
	}
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "My age is " +age;
	}
	
	
	//Method to return the object	
	@GetMapping("/student")
	public Student getStudent() {			 
		return s1;
	}
	
	//Method to return multiple students
	@GetMapping("/students")	
	public List<Student> getStudents(){
		return students;
	}
	
	//Method to return multiple students using mapping
	@GetMapping("/studentsMap")	
	public Map<String,Student> getStudentsMap(){
		return mstudents;
	}
	
	//Find a student from the list by regNo
	@GetMapping("/students/regno/{regNo}")	
	public Student getRegNo(@PathVariable("regNo") String regno) {
		/*for (Student student: students) {
			if(student.getRegNo().equals(regno)) {
				return student;
			}
		}*/
		return mstudents.get(regno);
		
		//return null;
	}
	
	
	
	//Find the students who's age is between 20 and 23
	
	  @GetMapping("/ages")
	   public List<Student> getStudentAge()
	   {
		  for(Student stu:students)
		  {
			  if(stu.getAge() > 19 && stu.getAge() < 24)
			  {
				  studentsAge.add(stu);
			  }
		  }
		  return studentsAge;
	   }
	//sort the students by their GPAs
	  
	  @GetMapping("/students/gpa")
	   public List<Student> getstudentGpa()
	   {
		   for (int i = 0; i < sortedStudents.size() - 1; i++) 
		   {
		        for (int j = 0; j < sortedStudents.size() - i - 1; j++)
		        {
		            if (sortedStudents.get(j).getGpa() > sortedStudents.get(j + 1).getGpa())
		            {
		                Student temp = sortedStudents.get(j);
		                sortedStudents.set(j, sortedStudents.get(j + 1));
		                sortedStudents.set(j + 1, temp);
		            }
		        }
		    }
		    
		    return sortedStudents;
	   }
	//Create CRUD operation for students	  
	
	//Add a new Student
	  
	  
	  
	  @PostMapping("/add")
		public String addStudent(@RequestBody Student student) {
		  mstudents.put(student.getRegNo(),student);
		  return "New Student Added!";
		 
		}
		
	//Delete a student by registration number
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") String regno) {
		if(mstudents.get(regno) != null) {
			mstudents.remove(regno);
			return "The student Removed!";
			
		}
		return "404 Couldn't find the student!";
	}
	
	//Update the student
	@PutMapping("/student/{id}")
	public String updateStudent(@PathVariable("id") String regno,@RequestBody Student student) {
		if(mstudents.get(regno) != null) {
			mstudents.put(student.getRegNo(),student);
			return "The student details are updated!";
			
		}
		return "404 Couldn't find the student!";
	}
}
