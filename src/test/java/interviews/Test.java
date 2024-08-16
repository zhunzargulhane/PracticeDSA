package interviews;

import java.sql.SQLOutput;
class Dummy {
    int i;
    int j;

    Dummy(int i,int j){
        this.i=i;
        this.j=j;
    }
    public Dummy(){

    }
}
class Dog implements Cloneable{
    Dummy dummy;
    int k;
    public Dog(){

    }
    Dog(Dummy dummy,int k){
        this.dummy=dummy;
        this.k=k;
    }

    protected Object clone() {
        Dummy dummy1 = new Dummy(dummy.i,dummy.j);
        Dog dog = new Dog(dummy1,k);
        return dog;
    }
}
public class Test{
    public static void main(String[] args) throws CloneNotSupportedException {
        Dummy dummy = new Dummy(10,20);
        Dog d1 = new Dog(dummy,50);
        Dog d2 = (Dog)d1.clone();
        System.out.println(d1.k+" "+d1.dummy.i);
        d1.k=500;
        d1.dummy.i=100;
        System.out.println(d2.k+" "+d2.dummy.i);

        String s1=new String("you cannot change me!");
        String s2=new String("you cannot change me!");
        System.out.println(s1==s2);//false
        String s3="you cannot change me!";
        System.out.println(s1==s3);//false
    }
}
