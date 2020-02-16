package sample;

import java.util.UUID;

public class Employee implements Worker {
    public String firstName;
    public String lastName;
    public UUID id;
    public boolean isActive;

    public Employee() {

    }

    //Constructor for adding new employees to list view:
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void hire(){
        isActive = true;
    }

    @Override
    public void fire(){
        isActive = false;
    }
}
