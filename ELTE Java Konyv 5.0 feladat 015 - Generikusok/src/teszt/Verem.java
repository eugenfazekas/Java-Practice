package teszt;

public class Verem <T> {
	
	private static int max_size =1000;
	
	private Object[] v ;
	private int sz;
	
	public Verem() {
		v = new Object[max_size];
		sz = 0;
	}
	
	public void push(Object x) throws Exception {
		if(sz < max_size) v[sz++]=x;
		else throw new Exception ("full");
	}
	
	public Object pop() throws Exception{
		if(sz>0) return v[--sz];
		throw new Exception("Empty");
	}
	
	public int size() {
		return sz;
	}
	
	public void tomblista() {
		for(int i = 0; i< v.length ;i++)
			//while(v[i] != null) {
			System.out.println(v[i]);
		//i++;
			//}
	} 
}

