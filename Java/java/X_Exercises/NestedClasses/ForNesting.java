package X_Exercises.NestedClasses;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public class ForNesting {

    private static final String PRIVATE_STATIC_FINAL = "P_S_F";
    public static final String PUBLIC_STATIC_FINAL = "PU_S_F";

    private int privateNumber;
    String packagePrivateString;
    private static int privateStaticInt;

    public float publicFloat;
    public static double publicStaticDouble;

    /**
     * Regular nested class,
     * as a member of ForNesting.
     */

    private class NestedMember extends ForNesting implements ShutterInterface{

        private static final String PSF_NESTED = "P_S_F_NESTED";
        public static final String PUSF_NESTED = "PU_S_F_NESTED";

        private int privateINT;

        //INNER CLASS CANNOT HAVE STATIC DECLARATIONS UNLESS THEY ARE ALSO FINAL AND INITIALIZED:
//        private static int privateStaticINT; //WRONG

        public NestedMember(int privateINT) {
            this.privateINT = privateINT;
        }

        public String getPsfNested() {
            return PSF_NESTED;
        }

        public int getPrivateINT() {
            return privateINT;
        }

        public void setPrivateINT(int privateINT) {
            this.privateINT = privateINT;
        }

        @Override
        public void soutEverything(int number, String string) {
            System.out.println(privateINT + " " + NestedMember.PUSF_NESTED);
        }

        @Override
        public void soutEverything() {
            System.out.println(ShutterInterface.number + " " +
                    ShutterInterface.STRING + " " +
                    NestedMember.STRING + " " +
                    NestedMember.number + " " +
                    NestedMember.PSF_NESTED + " " +
                    NestedMember.PUSF_NESTED);
        }

        @Override
        public int returnNumber(int number) {
            return ShutterInterface.number;
        }

        @Override
        public String returnString(String string) {
            return ShutterInterface.STRING;
        }

        /**
         * Regular nested class for nested class.
         */
        private class NestedForNested {
            void call(){
                System.out.println("I'm nested for nested");
            }
        }
    }

    public ForNesting() {}

    public ForNesting(int privateNumber, String packagePrivateString, float publicFloat) {
        this.privateNumber = privateNumber;
        this.packagePrivateString = packagePrivateString;
        this.publicFloat = publicFloat;
    }

    /**
     * Getters & Setters
     */
    public int getPrivateNumber() {
        return privateNumber;
    }

    public static int getPrivateStaticInt() {
        return privateStaticInt;
    }

    public void setPrivateNumber(int privateNumber) {
        this.privateNumber = privateNumber;
    }

    public static void setPrivateStaticInt(int privateStaticInt) {
        ForNesting.privateStaticInt = privateStaticInt;
    }

    /**
     * More methods:
     */

    private int regularPrivateMethod(){
        return privateNumber + privateStaticInt;
    }

    public double regularPublicMethod(){
        return publicFloat + publicStaticDouble;
    }

    public static String getPrivateStaticFinal() {
        return PRIVATE_STATIC_FINAL;
    }

    /**
     * Methods with nested classes:
     */

    public boolean callMethodWithNesteds(){
        //Anonymous class constructed as an ShutterInterface instance;
        methodWithNesteds(5, new ShutterInterface() {

            @Override
            public void soutEverything(int number, String string) {
                System.out.println(number + string);
            }

            @Override
            public void soutEverything() {

            }

            @Override
            public int returnNumber(int number) {
                return 10;
            }

            @Override
            public String returnString(String string) {
                return null;
            }
        });

        return true;
    }

    public void methodWithNesteds(int number, ShutterInterface shutterInterface){
        abstract class DivideNumbers{
           abstract public int sum(int number1, int number2);
           public int substract(int number1, int number2){
               return number1 - number2;
           }

           public void changeMembersOfOuterClass(){
               ForNesting.privateStaticInt = 10;
               ForNesting.publicStaticDouble = 500;
           }
        }

        DivideNumbers newDivideNumbers = new DivideNumbers() {
            @Override
            public int sum(int number1, int number2) {
                return number1 + number2;
            }

            int number = 30;
            private static final String NEW_DIVIDE_NUMBERS ="NEW_DIVIDE_NUMBERS";
        };

        ForNesting newForNesting = new ForNesting(){

            /**
             * Cannot use this field nor the method as the class is anonymous and instantiated to ForNesting object;
             */
            public int[] numbers = new int[10];

            public void putNumber(int number, int position){
                numbers[position] = number;
            }
        };

        newDivideNumbers.changeMembersOfOuterClass();
        newDivideNumbers.sum(10, 5);

        newForNesting.setPrivateNumber(10);

        ShutterInterface shutterInterface2 = new ShutterInterface() {

            /**
             * Cannot have access to those fields as class is anonymous...
             */
            int NUMBER_INTERFACE = 20;
            String STRING_INTERFACE = "STRING_INTERFACE";

            @Override
            public void soutEverything(int number, String string) {
                System.out.println(10);
            }

            @Override
            public void soutEverything() {
                System.out.println(20);
            }

            @Override
            public int returnNumber(int number) {
                return 0;
            }

            @Override
            public String returnString(String string) {
                return null;
            }

            /**
             * Cannot ever get to those two methods as the class is anonymous...
             */
            public int returnNumberInterface(){
                return NUMBER_INTERFACE;
            }

            public String returnStringInterface(){
                return STRING_INTERFACE;
            }
        };
    }
}
