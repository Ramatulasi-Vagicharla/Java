package main.java;
//Code to cover static keyword concept in Java
public class staticExample{
    private static int count =0;

    private int instanceNumber;

    public staticExample(){
        count++;
        instanceNumber = count;
    }
    public void display(){
        System.out.println("Instance Number: " + instanceNumber+"\n"+"Count: "+count);
    }
    public static void main(String[] args) {
        staticExample obj1 = new staticExample();
        obj1.display();
        staticExample obj2 = new staticExample();
        obj2.display();
        staticExample obj3 = new staticExample();
        obj3.display();
    }
}