package C_DataStructures.Sets;

import C_DataStructures.Lists.ArrayList;
import C_DataStructures.Maps.HashMap;

import java.util.Collection;

/**
 * Created by Mateusz Niedośpiał on 16.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is a simple HashSet implementation that is not synchronized.
 * Internally, it has the HashMap (C_DataStructures.Maps.HashMap), in which
 * set elements are held with DUMMY 'PRESENT' object as values.
 * The 'PRESENT' object is created for optimization of memory allocation,
 * as it is created once and is both static & final.
 *
 * This implementation since it uses HashMap does not guarantee any ordering of
 * elements that are added. Every element added is placed as a KEY object in HashMap.
 * Obviously, like in HashMap there cannot be multiple instances of the same element.
 *
 * Due to the fact that SETS are kinda wrappers of the MAPS data structures this implementation
 * provides the same time performance for the basic operations as HashMap does.
 * Null element is allowed.
 *
 * Note that Sets are simplified Maps as there is no mapping key -> value and all we refer to
 * are keys.
 *
 * @see RedBlackSet
 *
 * @param <T> is the type of elements held in the HashSet;
 */
public class HashSet<T> {

    /**
     * Underneath HashMap.
     */
    private C_DataStructures.Maps.HashMap<T, Object> map;

    /**
     * Final object used as a value in HashMap for every HashSet entry.
     */
    private static final Object PRESENT = new Object();

    public HashSet() {
        this.map = new C_DataStructures.Maps.HashMap<>();
    }

    public HashSet(C_DataStructures.Maps.HashMap<? extends T,?> map) {
        this.map = new HashMap<>((int) (map.size() + 0.5*map.size()));
        addAll(map);
    }

    public HashSet(C_DataStructures.Sets.HashSet<T> set){
        map = new HashMap<>((int) (set.map.size() + 0.5*set.map.size()));
        addAll(set);
    }

    public HashSet(int initialCapacity){
        map = new HashMap<>(initialCapacity);
    }

    public HashSet(int initialCapacity, float loadFactor){
        map = new HashMap<>(initialCapacity, loadFactor);
    }

    public HashSet(Collection<? extends T> collection){
        map = new HashMap<>((int) (collection.size() + 0.5*collection.size()));
        collection.forEach(this::add);
    }

    public int size(){ return map.size(); }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public boolean contains(T key){
        return map.containsKey(key);
    }

    public void addAll(C_DataStructures.Maps.HashMap<? extends T, ?> map) {
        @SuppressWarnings("unchecked")
        ArrayList<T> keyList = (ArrayList<T>) map.keyList();
        for(int i = 0; i < keyList.size(); i++){
            add(keyList.get(i));
        }
    }

    public void addAll(Collection<? extends T> collection){
        collection.forEach(this::add);
    }

    public void addAll(HashSet<T> set) {
        ArrayList<T> entryList = set.entryList();
        for(int i = 0; i < entryList.size(); i++){
            add(entryList.get(i));
        }
    }

    public boolean add(T entry) {
        return map.put(entry, PRESENT) == null;
    }

    public boolean remove(T entry){
        return map.remove(entry) != null;
    }

    public void clear(){
        map.clear();
    }

    public ArrayList<T> entryList(){
         return map.keyList();
    }

    public HashSet<T> clone(){
        HashSet<T> clone = new HashSet<>();
        ArrayList<T> entryList = entryList();
        for(int i=0; i < entryList.size(); i++){
            clone.add(entryList.get(i));
        }
        return clone;
    }
}
