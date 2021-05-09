
public class FactoryPatternDemo {

	public static void main(String[] args) {

		ShapeMaker maker = new ShapeMaker();
		
		maker.drawCircle();
		maker.drawRectangle();
		maker.drawSquare();
	}
}
