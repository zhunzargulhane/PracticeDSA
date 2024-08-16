package datastructuresandalgorithms.practiceproblems;

public class DeleteClass {
    DeleteClass deleteClass;
    Integer alpha;

    public void display(){
       Integer current = alpha;
        while(current!=null){
            System.out.println("hello");
            break;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DeleteClass deleteClass = new DeleteClass();
        deleteClass.alpha=12;
        deleteClass.display();
    }
}
