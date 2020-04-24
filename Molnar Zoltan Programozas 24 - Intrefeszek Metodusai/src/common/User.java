package common;

public class User implements Comparable<User>,Cloneable {
	
	private String name;
	
	private int age;
	
	public User(String name , int age) {
		this.name =name;
		this.age =age;
		}

	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name +" vagyok "+ age+" eves ";
	}
	
	public int compareTo(User other) {
		return name.compareToIgnoreCase(other.name);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return new User(name,age);
	}
}
