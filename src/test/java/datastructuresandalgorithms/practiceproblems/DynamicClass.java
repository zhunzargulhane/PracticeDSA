package datastructuresandalgorithms.practiceproblems;

public class DynamicClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class abc=Class.forName("datastructuresandalgorithms.practiceproblems.Stacks");
        Stacks object=(Stacks) abc.newInstance();

        Class driver=Class.forName("org.postgresql.Driver");
        System.out.println(driver.getClass().getName());
    }
}
