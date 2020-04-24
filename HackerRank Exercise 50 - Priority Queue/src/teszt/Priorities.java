package teszt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Priorities {

	public List<Student> getStudents(List<String> events) {
		
		String event;
		String[] students = new String[3];
		StudentSort sort = new StudentSort();
		List<Student> studentsarray= new ArrayList<Student>();
		
		for (int i = 0; i< events.size(); i++) {
			 event = events.get(i); 
			 students = event.split(" ");
			 if(students[0].equals("ENTER"))  {
			 Student student = new Student(students[1],Double.valueOf(students[2]),Integer.valueOf(students[3]));
			 studentsarray.add(student);
			 }
			 if(students[0].equals("SERVED")) {
			 Collections.sort(studentsarray,sort);
			 if(!studentsarray.isEmpty())
			 studentsarray.remove(0);
			 
			 }
		}
		return studentsarray;
	}
	
	
}
