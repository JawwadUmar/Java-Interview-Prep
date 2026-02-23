package org.jawwad.threads;


class C1 implements Runnable{

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

class C2 implements Runnable{

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
public class ThreadUsingRunnable {

    public static void main(String[] args) throws InterruptedException {
        Runnable obj1 = new C1();
        Runnable obj2 = new C2();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        //main waits for the threads to finish their working
        t1.join();
        t2.join();
    }

}
