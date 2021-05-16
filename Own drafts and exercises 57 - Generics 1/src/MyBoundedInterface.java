
public class MyBoundedInterface {

	public static void main(String[] args) {

        BoundExmp<Y> bey = new BoundExmp<Y>(new Y());
        bey.doRunTest();

        BoundExmp<Z> bez = new BoundExmp<Z>(new Z());
        bez.doRunTest();
	}
}
