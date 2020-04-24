package teszt;

class Student {
	private int Id;
	private String Name;
	private double Cgpa;
	
	
	
	public Student(String name,double cgpa,int id) {
		Id = id;
		Name = name;
		Cgpa = cgpa;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public double getCgpa() {
		return Cgpa;
	}

	
}
