package ShapeDecorator;

import shape.Shape;

public class RedShapeDecorator extends ShapeDecorator {
	
	public RedShapeDecorator(Shape decoratedType) {
		super(decoratedType);
	}
	
	@Override
	public void draw() {
		decoratedType.draw();
		setRedBorder(decoratedType);
	}
	
	private void setRedBorder(Shape decoratedShpae) {
		System.out.println("Border Color: Red");
	}
}
