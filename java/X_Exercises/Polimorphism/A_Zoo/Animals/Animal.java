package X_Exercises.Polimorphism.A_Zoo.Animals;

import X_Exercises.Polimorphism.A_Zoo.Species.Specie;

import java.time.LocalDate;

/**
 * Created by Mateusz Niedośpiał on 23.04.2017.
 */
public abstract class Animal implements Specie {

    private LocalDate arrivalDate;
    private Integer keepCosts;
    private String specie;

    Animal(LocalDate arrivalDate, Integer keepCosts, String specie) {
        this.arrivalDate = arrivalDate;
        this.keepCosts = keepCosts;
        this.specie = specie;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Integer getKeepCosts() {
        return keepCosts;
    }

    public String getSpecie() {
        return specie;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setKeepCosts(Integer keepCosts) {
        this.keepCosts = keepCosts;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String occupiedCage(){
        return "No cages yet implemented";
    }

    @Override
    public void move() {
        System.out.println("The " + getSpecie() + " that name is: " + "ANIMAL" + " is MOVING now.");
    }

    @Override
    public void eat() {
        System.out.println("The " + getSpecie() + " that name is: " + "ANIMAL" + " is EATING now.");
    }

    @Override
    public void sleep() {
        System.out.println("The " + getSpecie() + " that name is: " + "ANIMAL" + " is SLEEPING now.");
    }

    @Override
    public void talk() {
        System.out.println("The " + getSpecie() + " that name is: " + "ANIMAL" + " is MAKING A SOUND now.");
    }
}
