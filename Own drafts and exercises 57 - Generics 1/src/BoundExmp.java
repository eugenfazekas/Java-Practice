
public class BoundExmp <T extends X>{

	private T objRef;
    
    public BoundExmp(T obj){
        this.objRef = obj;
    }
     
    public void doRunTest(){
        this.objRef.printClass();
    }
}
