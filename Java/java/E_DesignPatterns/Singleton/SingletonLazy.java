package E_DesignPatterns.Singleton;

import C_DataStructures.Maps.RedBlackMap;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * This is a simple Singleton Design Pattern implementation example.
 * In this case the Lazy Instantiation so memory allocation is reduced
 * until the request for the instance is made.
 * That is why INSTANCE object is only declared at first (when the class is loaded),
 * and thus it cannot be marked final as it is in two other example
 * implementation. The downside of this approach is that e.g in the system
 * users can come across noticeable delay when the time that instance is needed
 * comes.
 *
 * Note that even though getInstance() method is marked synchronized the solution is not
 * really optimized since every call of the method will require synchronization management.
 * That is why the method is marked @Deprecated.
 *
 * Better solution is to use double-checked locking, a design pattern in which
 * it is tested if synchronization is needed. Check the 'not-deprecated' method
 * named getInstanceBetterApproach().
 *
 * @see Singleton
 * @see SingletonStaticBlock
 */
public class SingletonLazy {

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
     *
     * (marked ' volatile ' since the getInstanceBetterApproach() was provided, )
     * (it is to make sure that under the INSTANCE reference is always a desired value).
     */
    private static volatile SingletonLazy INSTANCE;

    /**
     * Private constructor to prohibit instantiating.
     * Effectively it makes Singleton class to be final,
     * as every class that could have possibly extend Singleton
     * are supposed to use super() constructor in their own constructors.
     * That is not an option since the only constructor Singleton has is private one.
     */
    private SingletonLazy() {}


    /**
     * In getInstance() method the SingletonLazy is in fact instantiated.
     * It is synchronized to make sure that even if two threads call
     * the function only one will in fact be allowed at a time thus resulting
     * in creating actually single instance of the class.
     */

    @Deprecated
    public static synchronized SingletonLazy getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SingletonLazy();
        }
        return INSTANCE;
    }

    /**
     * Better approach of lazy instantiating an INSTANCE and then returning it.
     * Double-checked locking is used here since the synchronization is needed
     * actually only once. Thanks to this approach classes that will use the SINGLETON
     * will not have to manage synchronization. This implementation requires the INSTANCE
     * to be marked as volatile to prevent compiler from accessing the object before it has
     * been fully constructed for optimization.
     */
    public static SingletonLazy getInstanceBetterApproach(){
        if(INSTANCE == null){
            synchronized (SingletonLazy.class){
                if(INSTANCE == null){
                    INSTANCE = new SingletonLazy();
                }
            }
        }
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
        SingletonLazy.bestFeature = bestFeature;
    }

    public static void setWorstFeature(String worstFeature) {
        SingletonLazy.worstFeature = worstFeature;
    }

}
