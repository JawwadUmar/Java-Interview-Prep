package org.jawwad.models;

import java.util.ArrayList;
import java.util.List;

public class User{
    private String name;
    List<Car> cars;

    public User(String name) {
        this.name = name;
//        this.cars = (ArrayList<Car>)(List.of(new Car("Brown", "Bugatti")));
        this.cars = (new ArrayList<>(List.of(new Car("Brown", "Bugatti"))));
    }

    public void addCar(Car c){
        cars.add(c);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}

