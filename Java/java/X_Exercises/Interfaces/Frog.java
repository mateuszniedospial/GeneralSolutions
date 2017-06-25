package X_Exercises.Interfaces;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public class Frog implements Swim, Run {

    private static final boolean IS_REPTILE = true;

    private String name;
    private String personality;
    private String skills;

    public Frog() {}

    public Frog(String name, String personality, String skills) {
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
    public boolean canHuntWhileRunning() {
        return false;
    }

    @Override
    public boolean canRunOnTwoLegs() {
        return false;
    }

    @Override
    public void run() {
        System.out.println((name != null) ? name + "is jumping." : "Frog is jumping.");
    }

    @Override
    public void isSwimming() {
        System.out.println((name != null) ? name + "is swimming." : "Frog is swimming.");
    }

    @Override
    public void swim(){
        System.out.println((name != null) ? name + "is swimming." : "Frog is swimming.");
    }

    @Override
    public double maxSpeed() {
        return 70;
    }

    @Override
    public boolean canHuntWhileSwimming() {
        return true;
    }

    @Override
    public boolean canHuntWhileWalking() {
        return true;
    }

    @Override
    public void isWalking() {
        System.out.println((name != null) ? name + "is walking." : "Frog is walking.");
    }


   public static class Tadpole implements Swim{

        String howManyDaysToBecomeFrog;

        public Tadpole() {
            howManyDaysToBecomeFrog = "UNKNOWN";
        }

        public Tadpole(int howManyDaysToBecomeFrog) {
            this.howManyDaysToBecomeFrog = String.valueOf(howManyDaysToBecomeFrog);
        }


        @Override
        public void isSwimming() {
            System.out.println("Tadpole is swimming.");
        }

        @Override
        public double maxSpeed() {
            return 30;
        }

        @Override
        public boolean canHuntWhileSwimming() {
            return false;
        }
    }
}
