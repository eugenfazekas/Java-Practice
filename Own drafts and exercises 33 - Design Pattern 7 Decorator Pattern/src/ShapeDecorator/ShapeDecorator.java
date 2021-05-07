package ShapeDecorator;

import shape.Shape;

public abstract class ShapeDecorator implements Shape {
	
	protected Shape decoratedType;

	public ShapeDecorator(Shape decoratedType) {
		this.decoratedType = decoratedType;
	}

	public void draw() {
		decoratedType.draw();
	}

}
