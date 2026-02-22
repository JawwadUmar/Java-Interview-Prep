package org.jawwad.models;


class CustomException extends Exception{

    CustomException(String message){
        super(message);
    }
}

public class ExceptionHandling {

    public static void main(String[] args) {
        int numerator = 69;
        int result = Integer.MAX_VALUE;
        int denominator = 78;

        //Exception when you divide by 0
        //Exception when you divide by a bigger number

        try{
            result = numerator/denominator;

            if (result == 0){
                //You are causing an exception manually!!!!
                //basically calling the catch block that catches CustomException
                throw new CustomException("I don't want output result to be zero");
            }
        }

        catch (ArithmeticException e){
            System.out.println("Some problem with division, doing default devision by 3");
            result = numerator/3;

        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.out.println("Some problem with division, doing default devision by 3");
            result = numerator/3;
        }
        catch (Exception e){
            System.out.printf("Some exception caught:" + e.getMessage());
        }

        System.out.println(result);
        System.out.println("This part of the program should be reached even if exception occurred");
    }
}
