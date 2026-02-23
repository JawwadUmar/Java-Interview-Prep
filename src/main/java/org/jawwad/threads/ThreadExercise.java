package org.jawwad.threads;


class A extends Thread{

    @Override
    //must be overridden
    public void run(){
        show();
    }
    public void show(){
        for(int i= 1; i<=100; i++){
            System.out.println("Hii I am A");
        }
    }
}

class B extends Thread{

    @Override
    public void run(){
        show();
    }

    public void show(){
        for(int i = 1; i<=100; i++){
            System.out.println("Hello I am B");
        }
    }
}
public class ThreadExercise {

    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        //start calls the run
        obj1.start();
        obj2.start();

    }
}
