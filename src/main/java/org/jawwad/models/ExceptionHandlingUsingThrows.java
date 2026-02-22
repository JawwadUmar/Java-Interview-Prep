package org.jawwad.models;


// TODO: Define custom exception InvalidAgeException extending Exception
class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

public class ExceptionHandlingUsingThrows {

    public static void checkAge(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Age must be 18 or older");
        }
        else{
            System.out.println("Access granted");
        }

    }

    public static void main(String[] args) {

        try {
            checkAge(16);

        } catch(Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            checkAge(21);

        } catch(Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }




    }

}


