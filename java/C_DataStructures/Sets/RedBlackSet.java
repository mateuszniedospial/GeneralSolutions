package C_DataStructures.Sets;

import C_DataStructures.Lists.ArrayList;
import C_DataStructures.Maps.RedBlackMap;

import java.util.Collection;

/**
 * Created by Mateusz Niedośpiał on 17.05.2017.
 *
 * All data structures written under C_DataStructure package are
 * for educational purposes only. That is why there is no architecture
 * behind them i.e neither interfaces are implemented nor abstract classes extended.
 * There are also no Serializable & Cloneable interfaces implemented.
 *
 * This is simple RedBlackSet implementation that is not synchronized and does not permit null key due to sorting.
 * Internally, it has the RedBlackMap (C_DataStructures.Maps.RedBlackMap), in which
 * set elements are held with DUMMY 'DUMMY' object as values.
 * The 'DUMMY' object is created for optimization of memory allocation,
 * as it is created once and is both static & final.
 *
 * This implementation since it uses RedBlackMap guarantee that elements are sorted.
 * By default sorting priority is from the least priority to the highest, and that
 * is how entryList() method order elements within.
 * Obviously, like in RedBlackMap there cannot be multiple instances of the same element.
 * Null element is allowed.
 *
 * Note that Sets are simplified Maps as there is no mapping key -> value and all we refer to
 * are keys.
 *
 * @see HashSet
 *
 * @param <T> is the type of elements held in the RedBlackSet;
 */
public class RedBlackSet<T> {


    /**
     * Underneath RedBlackMap.
     */
    private RedBlackMap<T, Object> redBlackMap;

    /**
     * Final object used as a value in RedBlackMap for every RedBlackSet entry.
     */
    private static final Object DUMMY = new Object();

    public RedBlackSet() {
        redBlackMap = new RedBlackMap<>();
    }

    public RedBlackSet(RedBlackMap<T, Object> redBlackMap) {
        this.redBlackMap = redBlackMap;
    }

    public RedBlackSet(Collection<? extends T> collection){
        this.redBlackMap = new RedBlackMap<>();
        collection.forEach(this::add);
    }

    public boolean isEmpty(){
        return redBlackMap.isEmpty();
    }

    public int size(){
        return redBlackMap.size();
    }

    public boolean add(T entry){
        return redBlackMap.put(entry, DUMMY) == null;
    }

    public boolean contains(T entry){
        return redBlackMap.containsKey(entry);
    }

    public boolean remove(T entry){
        return redBlackMap.remove(entry) != null;
    }

    public void addAll(Collection<? extends T> collection){
        collection.forEach(this::add);
    }

    public void addAll(RedBlackSet<T> redBlackSet){
        ArrayList<T> entryList = redBlackSet.entryList();
        for(int i = 0; i < entryList.size(); i++){
            add(entryList.get(i));
        }
    }

    public void addAll(RedBlackMap<? extends T, ?> map){
        @SuppressWarnings("unchecked")
        ArrayList<T> entryList = (ArrayList<T>) map.keyList();
        for(int i = 0; i < entryList.size(); i++){
            add(entryList.get(i));
        }
    }

    public void clear(){
        redBlackMap.clear();
    }

    public ArrayList<T> entryList(){
       return redBlackMap.keyList();
    }

    public RedBlackSet<T> clone(){
        RedBlackSet<T> clone = new RedBlackSet<>();
        ArrayList<T> setEntryList = entryList();
        for(int i = 0; i < setEntryList.size(); i++){
            clone.add(setEntryList.get(i));
        }
        return clone;
    }
}
