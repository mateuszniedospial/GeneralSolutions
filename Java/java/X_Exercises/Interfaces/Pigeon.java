package X_Exercises.Interfaces;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public class Pigeon implements Run {

    private static final boolean HAS_FEATHERS = true;

    private String name;
    private String personality;
    private String skills;

    public Pigeon() {}

    public Pigeon(String name, String personality, String skills) {
        this.name = name;
        this.personality = personality;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getPersonality() {
        return personality;
    }

    public String getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public void isWalking() {
        System.out.println("Pigeon is walking.");
    }

    @Override
    public void run(){
        System.out.println(name + " is running.");
    }

    @Override
    public double maxSpeed() {
        return 50;
    }

    @Override
    public boolean canHuntWhileWalking() {
        return false;
    }

    @Override
    public boolean canHuntWhileRunning() {
        return true;
    }

    @Override
    public boolean canRunOnTwoLegs() {
        return true;
    }
}
