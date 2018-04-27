import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public  class Onion implements ToppingDecorator {
    String nameOfOnion = "Onion";/*toppings features*/
    double costofOnion = 2;
    public Onion(){

    }
    public Onion(ToppingDecorator topping){
        costofOnion += topping.getCost();
        nameOfOnion +=" "+ topping.getTopping();
    }


    public void addTopping(ToppingDecorator object) {
        costofOnion += object.getCost();/*adding all the toppings*/
        nameOfOnion += " "+object.getTopping();
    }

    public String getTopping(){
        return nameOfOnion;
    }

    public double getCost(){
        return  costofOnion;
    }
}
