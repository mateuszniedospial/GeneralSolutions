package E_DesignPatterns.Immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * This is a simple implementation example of Immutable design pattern.
 * The idea is to create a class which all fields are private and final
 * and are initialized during constructor call. Moreover, there cannot be
 * any setters implemented. Getters or other methods cannot provide
 * any direct access to the references to the mutable type of object held
 * internally.
 *
 * The class is final to prevent possibility of being extended and
 * methods from being overriden so all immutable class properties
 * are preserved.
 *
 * This makes immutable objects not possible to change internally in any way,
 * and force construction of new object with changed data if alteration is
 * desired.
 *
 * Additional information is available above all of the implementation's
 * segments.
 */
public final class Immutable {
    /**
     * All fields are marked private and final to
     * prevent changes.
     */
    private final String name;
    private final String password;

    /**
     * If one of the fields are of type that is mutable
     * then it is necessary to take every precautions not to
     * make it possible for another class to make modifications.
     */
    private final List<String> tokens;

    /**
     * All fields are supposed to be initialized in the constructor.
     * Note that if any field is of a mutable type object like e.g List<String>
     * then it is absolutely necessary to create new instance of the specific implementation
     * (like ArrayList<> in this case) not to use the same reference as the caller of the constructor.
     */
    public Immutable(String name, String password, List<String> tokens) {
        this.name = name;
        this.password = password;

        if(tokens == null){
            throw new RuntimeException("You cannot construct Immutable with null instead of a List<E>");
        }
        this.tokens = new ArrayList<>(tokens);
    }

    /**
     * Only getters available and there is no direct access to the reference
     * 'tokens' which points to a List<String>.
     */
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getToken(int position) {
        return tokens.get(position);
    }

    public int numberOfTokens(){
        return tokens.size();
    }
}
