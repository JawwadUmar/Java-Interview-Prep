package org.jawwad.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //ExecutorService working with Runnable object
        for(int i =0; i<10; i++){
            int taskID = i;
            executorService.execute(()-> System.out.println("Task " + taskID + " is getting executed by thread " + Thread.currentThread().getName()));
        }

        //ExecutorService working with Callable object
        for(int i =0; i<10; i++){
            int taskID = i;
            Future<Integer> f = executorService.submit(()->5);

            try{
                int x = f.get();
                System.out.println(x);
            }catch (Exception e){}

        }

        executorService.shutdown();


    }
}
