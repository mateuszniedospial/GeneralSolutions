package X_Exercises.Generics;

import java.util.*;

/**
 * Created by Mateusz Niedośpiał on 25.04.2017.
 */
public class Backpack<T>{

    private HashMap<T, Object> backpack = new HashMap<>();
    private static final Object VALUE = new Object();

    public Backpack() {}

    public boolean add(T item){
        if(item != null){
            backpack.put(item, VALUE);
            return true;
        }
        throw new UnsupportedOperationException("One simply cannot add to backpack an item which has not been initialised.");
    }

    public boolean remove(T item){
        if(backpack.containsKey(item)){
            backpack.remove(item);
            return true;
        }
        throw new UnsupportedOperationException("One simply cannot remove from backpack an item which are not there.");
    }

    public T get(){
        if(search().hasNext()){
            return search().next();
        }
        throw new UnsupportedOperationException("No items left in backpack.");
    }

    public List<T> retrieveAll(){
        List<T> content = new ArrayList<>();
        while(search().hasNext()){
            content.add(search().next());
            backpack.remove(search().next());
        }
        return content;
    }

    private Iterator<T> search(){
        return backpack.keySet().iterator();
    }

    public int size(){
        return backpack.size();
    }

    public boolean isEmpty(){
        return backpack.isEmpty();
    }

    public boolean contains(T item){
       return backpack.containsKey(item);
    }
}
