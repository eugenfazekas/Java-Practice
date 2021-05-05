
public class RoundedShapeFactory extends AbstractFactory{

	@Override
	Shape getShape(String shapeType) {
		
		if(shapeType.equals("RECTANGLE")) {
			return new RoundedRectangle();
			
		}else if(shapeType.equals("SQUARE")) {
			return new RoundedSquare();
		}
		return null;
	}
}
