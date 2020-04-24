package teszt;

import java.util.Comparator;

public class StudentSort implements Comparator <Student>{

	@Override
	public int compare(Student St1, Student St2) {
		double cgpa1 = St1.getCgpa();
		double cgpa2 = St2.getCgpa();
		String fname1 = St1.getName();
		String fname2 = St2.getName();
		int id1 = St1.getId();
		int id2 = St2.getId();
		
		if(cgpa1<cgpa2)
			return 1 ;
		else if(cgpa1>cgpa2)
			return -1;
		if(cgpa1 == cgpa2)
			return fname1.compareTo(fname2);
		if(cgpa1 == cgpa2 && fname1 == fname2 && id1>id2)
			return  1;
		else
			return 0;
		}
}
