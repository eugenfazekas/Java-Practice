
public class FrontControllerPatternDemo {

	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		frontController.dispacthRequest("Home");
		frontController.dispacthRequest("Student");
	}
}
