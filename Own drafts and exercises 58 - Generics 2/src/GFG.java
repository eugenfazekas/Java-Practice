
class GFG {
    // Main driver method
    public static void main(String[] args)
    {
        Integer arr[] = { 3, 6, 2, 8, 6 };

        MyClass<Integer> obj1 = new MyClass<Integer>(arr);

        System.out.println("Minimum value: " + obj1.min());

        System.out.println("Maximum value: " + obj1.max());
    }
}
