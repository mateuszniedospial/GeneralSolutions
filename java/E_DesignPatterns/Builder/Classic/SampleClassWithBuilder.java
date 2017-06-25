package E_DesignPatterns.Builder.Classic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import E_DesignPatterns.Builder.StepBuilder.PizzaStepBuilder;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * This is simple implementation example of the Builder design pattern.
 * Builder is implemented as a nested public static class named Builder
 * that has the all the same fields that Immutable representation class SampleClassWithBuilder
 * but those are not marked final. This means that a nested class Builder is in fact
 * a mutable class which is supposed to prepare all creation of the SampleClassWithBuilder instance.
 * There is no other possibility to do the instantiating since SampleClassWithBuilder has only one constructor
 * and it is private.
 *
 * This way the code is far more maintainable and reusable if the SampleClassWithBuilder is going to
 * grow in means of fields. If, for example, SampleClassWithBuilder is to have 60 fields in the future then
 * basic constructor is not practical at all. What is more every one field added makes
 * constructor change, so all classes using this constructor are next to refactor.
 * The Builder class makes it more simple and more flexible to use.
 *
 * Downsides of using the most simple approach to a Builder Design Patterns are as follows:
 * 1. It does not really guide through steps.
 * 2. Maintain no ordering (which sometimes could be important).
 * 3. Makes all set functions available right away which throws all responsibility onto user.
 * 4. There is always a risk that object will be inconsistent after creation.
 * 5. Ending 'build()' method can be used at any moment (sometimes preferred sometimes not at all).
 *
 * For example in this case SampleClassWithBuilder is designed as immutable.
 * This makes calling 'build()' method on a Builder too soon kinda useless.
 * Especially if the need is to obtain a fully specified instance.
 * In such situations the modified version of the class Builder called
 * StepBuilder is more appropriate and better designed.
 *
 * @see PizzaStepBuilder
 */
public final class SampleClassWithBuilder {

    private final String FIELD_1;
    private final String FIELD_2;

    private final Integer FIELD_3;
    private final Integer FIELD_4;

    private final List<String> LIST;
    private final Set<Integer> SET;

    private SampleClassWithBuilder(String FIELD_1, String FIELD_2, Integer FIELD_3, Integer FIELD_4, List<String> LIST, Set<Integer> SET) {
        this.FIELD_1 = FIELD_1;
        this.FIELD_2 = FIELD_2;
        this.FIELD_3 = FIELD_3;
        this.FIELD_4 = FIELD_4;
        this.LIST = new ArrayList<>(LIST);
        this.SET = new HashSet<>(SET);
    }

    public String getFIELD_1() {
        return FIELD_1;
    }

    public String getFIELD_2() {
        return FIELD_2;
    }

    public Integer getFIELD_3() {
        return FIELD_3;
    }

    public Integer getFIELD_4() {
        return FIELD_4;
    }

    public String getFromLIST(int position) {
        return LIST.get(position);
    }

    public Integer getFromSET() {
        return SET.iterator().next();
    }

    /**
     * Builder nested static class.
     * Since the regular SampleClassWithBuilder constructor is private,
     * this is the only way to create instance of the SampleClassWithBuilder.
     */
    public static class Builder{

        private String FIELD_1;
        private String FIELD_2;

        private Integer FIELD_3;
        private Integer FIELD_4;

        private List<String> LIST;
        private Set<Integer> SET;

        public Builder() {}

        /**
         * Builder is really a bunch of setter methods which return the
         * reference to the object Builder itself. This makes it easier to use
         * since we can use methods after each one in any order
         * necessary and use build() at the end to create a final instance.
         */
        public Builder setFIELD_1(String FIELD_1){
            this.FIELD_1 = FIELD_1;
            return this;
        }

        public Builder setFIELD_2(String FIELD_2){
            this.FIELD_2 = FIELD_2;
            return this;
        }

        public Builder setFIELD_3(Integer FIELD_3){
            this.FIELD_3 = FIELD_3;
            return this;
        }

        public Builder setFIELD_4(Integer FIELD_4){
            this.FIELD_4 = FIELD_4;
            return this;
        }

        public Builder setLIST(List<String> LIST){
            this.LIST = LIST;
            return this;
        }

        public Builder setSET(Set<Integer> SET){
            this.SET = SET;
            return this;
        }

        public SampleClassWithBuilder build(){
            return new SampleClassWithBuilder(FIELD_1, FIELD_2, FIELD_3, FIELD_4, LIST, SET);
        }
    }
}
