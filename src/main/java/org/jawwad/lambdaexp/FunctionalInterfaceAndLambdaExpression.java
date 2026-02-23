package org.jawwad.lambdaexp;

@FunctionalInterface
interface Runner{
    void run(int speed);
}

@FunctionalInterface
interface Adder{
    int add(int a, int b);
}

public class FunctionalInterfaceAndLambdaExpression {

    public static void main(String[] args){

        Runner x = (a)-> System.out.println("Running with speed " + a);
        Adder y = ( a,  b) -> 5;

        System.out.println(y.add(4, 5));


        x.run(5);
    }
}
