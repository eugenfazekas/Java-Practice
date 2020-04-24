
public class Main {

	public static void main(String[] args) {
	
		Person kati = new Person("Katalin",25);
		
		Employee misi =  new Employee("Munkas Misi",36,5000);
	
		Director artur =  new Director("Fonok Artur",40);
		
		System.out.println("Artur fizetese: " + artur.getMonthlySalary());
		
		Person[] emberek = {kati,misi,artur};
		
		for(int i = 0 ; i < emberek.length; i++) {
			System.out.println(emberek[i]);
		}
		System.out.println("E: "+ Employee.TAX_RATE_PERCENT);
		System.out.println("D: "+ Director.TAX_RATE_PERCENT);
	}

}
