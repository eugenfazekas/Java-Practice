package v36.bridge;

public class Node<T> {

	public T data;

	public Node(T data) {
		System.out.println("Node.setData invoked!");
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
