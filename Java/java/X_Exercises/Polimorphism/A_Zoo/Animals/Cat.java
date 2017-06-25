package X_Exercises.Polimorphism.A_Zoo.Animals;

import X_Exercises.Polimorphism.A_Zoo.Species.Mammal;

import java.time.LocalDate;

/**
 * Created by Mateusz Niedośpiał on 23.04.2017.
 */
public class Cat extends Animal implements Mammal {
    private String name;
    private AnimalSex sex;
    private int age;

    public Cat(LocalDate arrivalDate, Integer keepCosts, String specie) {
        super(arrivalDate, keepCosts, specie);
    }

    public Cat(LocalDate arrivalDate, Integer keepCosts, String specie, String name, AnimalSex sex, int age) {
        super(arrivalDate, keepCosts, specie);
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    private String getName() {
        return name;
    }

    private AnimalSex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(AnimalSex sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getSpecie() {
        return super.getSpecie();
    }

    @Override
    public void move() {
        System.out.println("The " + getSpecie() + " that name is: " + getName() + " is MOVING now.");
    }

    @Override
    public void eat() {
        System.out.println("The " + getSpecie() + " that name is: " + getName() + " is EATING now.");
    }

    @Override
    public void sleep() {
        System.out.println("The " + getSpecie() + " that name is: " + getName() + " is SLEEPING now.");
    }

    @Override
    public void talk() {
        System.out.println("The " + getSpecie() + " that name is: " + getName() + " MEOWS now.");
    }

    @Override
    public boolean canProduceMilk(AnimalSex animalSex) {
        return getSex().canAdjust;
    }

    @Override
    public void furDrop() {
        System.out.println("The " + getSpecie() + " that name is: " + getName() + " DROPS FUR often.");
    }

    @Override
    public void teethUse() {
        System.out.println("The " + getSpecie() + " that name is: " + getName() + " is BITING WITH TEETH.");
    }

    private void run(){
        System.out.println("This cat whose name is: "+ getName() + " is RUNNING AWAY ON ITS OWN!");
    }
}
