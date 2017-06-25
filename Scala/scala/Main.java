/**
 * Created by Mateusz Niedośpiał on 18.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld(10, 10);
        Nowa obiektNowy = new Nowa("10", "10", 5, 5);

        System.out.println(helloWorld.returnSecond() + obiektNowy.getFirstNumber());
    }
}
