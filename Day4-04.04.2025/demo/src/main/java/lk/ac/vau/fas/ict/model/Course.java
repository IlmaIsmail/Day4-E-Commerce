package lk.ac.vau.fas.ict.model;

public class Course {

		private String courseNo;
		private String courseName;  
		private String courseDept;
		
		
		public Course(String courseNo , String courseName, String courseDept) {
			super();
			this.courseNo = courseNo;
			this.courseName = courseName;
			this.courseDept = courseDept;
		}


		public String getCourseNo() {
			return courseNo;
		}


		public void setCourseNo(String courseNo) {
			this.courseNo = courseNo;
		}


		public String getCourseName() {
			return courseName;
		}


		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}


		public String getCourseDept() {
			return courseDept;
		}


		public void setCourseDept(String courseDept) {
			this.courseDept = courseDept;
		}
		
		@Override
		public String toString() {
			return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseDept=" + courseDept +  "]";
		}
		 
		
			
	}

	

