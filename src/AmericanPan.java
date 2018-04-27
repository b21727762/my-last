import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AmericanPan implements ToppingDecorator{
    String nameofAmericanPan = "AmericanPan";/*toppings features*/
    double costofAmericanPan = 5;
    public AmericanPan(){

    }
    public AmericanPan(ToppingDecorator topping){
        costofAmericanPan += topping.getCost();
        nameofAmericanPan += " "+topping.getTopping();
    }
    public void addTopping(ToppingDecorator object) {
        costofAmericanPan += object.getCost();/*adding all the toppings*/
        nameofAmericanPan += " "+ object.getTopping();
    }

    public String getTopping(){
        return nameofAmericanPan;
    }

    public double getCost(){
        return  costofAmericanPan;
    }
}