package teszt;

import java.util.*;

class Student  {
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
	
	
}
class StudentSort implements Comparator <Student>{

	@Override
	public int compare(Student St1, Student St2) {
		double cgpa1 = St1.getCgpa();
		double cgpa2 = St2.getCgpa();
		String fname1 = St1.getFname();
		String fname2 = St2.getFname();
		int id1 = St1.getId();
		int id2 = St2.getId();
		
		if(cgpa1>cgpa2)
			return 1 ;
		else if(cgpa1<cgpa2)
			return -1;
		if(cgpa1 == cgpa2)
			return fname1.compareTo(fname2);
		if(cgpa1 == cgpa2 && fname1 == fname2 && id1>id2)
			return  1;
		else
			return 0;
		}
	
}

  

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		StudentSort sort = new StudentSort();
		
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
      
		Collections.sort(studentList ,sort );
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
