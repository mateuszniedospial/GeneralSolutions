package E_DesignPatterns.Singleton;

import C_DataStructures.Maps.RedBlackMap;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * Simple Singleton Design Pattern implementation example using static block to
 * instantiate the only instance allowed. This example differs from the
 * regular Singleton approach since using static block allows more
 * operations to be handled than just an instantiation.
 *
 * The rest is the same and has the same features as 'Singleton' class.
 *
 * Note that this implementation is not thread-safe.
 *
 * @see Singleton
 * @see SingletonLazy
 */
public class SingletonStaticBlock {

    /**
     * Regular fields.
     */

    private String name;
    private Integer number;

    private RedBlackMap<String, Integer> nameToNumber;

    private static String bestFeature;
    private static String worstFeature;

    //etc.


    /**
     * Instance that is final, built once with private constructor.
     * This is a fundamental feature of the Singleton Design Pattern.
     * No more instances are allowed to be constructed,
     * all operations are done on the INSTANCE.
     */
    private static final SingletonStaticBlock INSTANCE;


    static {

        //Static instantiation of the only SingletonStaticBlock object.
        INSTANCE = new SingletonStaticBlock();

        //MORE OPERATIONS POSSIBLE THANKS TO STATIC BLOCK.
        bestFeature = "RELIABILITY";
        worstFeature = "PUNCTUALITY";
    }

    /**
     * Private constructor to prohibit instantiating.
     * Effectively it makes Singleton class to be final,
     * as every class that could have possibly extend Singleton
     * are supposed to use super() constructor in their own constructors.
     * That is not an option since the only constructor Singleton has is private one.
     */
    private SingletonStaticBlock(){}

    /**
     * Getting the instance to work over the Singleton object.
     */
    public static SingletonStaticBlock getInstance(){
        return INSTANCE;
    }


    /**
     * Regular methods.
     */
    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public RedBlackMap<String, Integer> getNameToNumber() {
        return nameToNumber;
    }

    public static String getBestFeature() {
        return bestFeature;
    }

    public static String getWorstFeature() {
        return worstFeature;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setNameToNumber(RedBlackMap<String, Integer> nameToNumber) {
        this.nameToNumber = nameToNumber;
    }

    public static void setBestFeature(String bestFeature) {
        SingletonStaticBlock.bestFeature = bestFeature;
    }

    public static void setWorstFeature(String worstFeature) {
        SingletonStaticBlock.worstFeature = worstFeature;
    }
}
