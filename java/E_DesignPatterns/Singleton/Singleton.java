package E_DesignPatterns.Singleton;

import C_DataStructures.Maps.RedBlackMap;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * This is a simple Singleton Design Patterns example.
 * The onlye instance of the Singleton class is basically a
 * private static final field called INSTANCE, and is created
 * only once. The only one constructor is private.
 *
 * Note that this approach does require more memory allocation right away,
 * since instantiation of INSTANCE is done in the definition of the reference.
 *
 * Note that this implementation is not thread-safe.
 *
 * There are two more ways to make a Singleton Design Patterns.
 * @see SingletonStaticBlock
 * @see SingletonLazy
 */
public class Singleton {

    /**
     * Some regular fields of the class.
     */

    private String name;
    private Integer value;

    private RedBlackMap<String, Integer> allNamesToValues;
    //etc.

    /**
     * Instance that is final, built once with private constructor.
     * This is a fundamental feature of the Singleton Design Pattern.
     * No more instances are allowed to be constructed,
     * all operations are done on the INSTANCE.
     */
    private static final Singleton INSTANCE = new Singleton();

    /**
     * Private constructor to prohibit instantiating.
     * Effectively it makes Singleton class to be final,
     * as every class that could have possibly extend Singleton
     * are supposed to use super() constructor in their own constructors.
     * That is not an option since the only constructor Singleton has is private one.
     */
    private Singleton() {}

    /**
     * Getting the instance to work over the Singleton object.
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }

    /**
     * Some regular methods.
     */
    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public RedBlackMap<String, Integer> getAllNamesToValues() {
        return allNamesToValues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setAllNamesToValues(RedBlackMap<String, Integer> allNamesToValues) {
        this.allNamesToValues = allNamesToValues;
    }
}
