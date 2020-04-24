
public class Main {

	public static void main(String[] args) {
	
		Person kati = new Person();
		kati.setName("Katalin");
		kati.setAge(25);
		
		Employee misi =  new Employee();
		misi.setName("Munkas Misi");
		misi.setAge(36);
		misi.setMonthlySalary(5000);
		

		Director artur =  new Director();
		artur.setName("Artur");
		artur.setAge(36);
		artur.setMonthlySalary(12000);

		Person[] emberek = {kati,misi,artur};
		
		for(int i = 0 ; i < emberek.length; i++) {
			System.out.println(emberek[i]);
		}
		System.out.println("E: "+ Employee.TAX_RATE_PERCENT);
		System.out.println("D: "+ Director.TAX_RATE_PERCENT);
	}

}
