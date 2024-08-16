package datastructuresandalgorithms.binaryTree;

public class Sample {
    public static void main(String[] args) {
    String s1="140235";
    String s2="142";
    if(s1.contains(s2))
        System.out.println("true");


    }

    public void printNumber(int i){
        if(i>1000)
            return;
        System.out.println(i);
        i++;
        printNumber(i);
    }
}
