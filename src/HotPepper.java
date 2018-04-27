import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HotPepper implements ToppingDecorator {
    String nameOfpepper = "HotPepper";/*toppings features*/
    double costofpepper = 1;
    public HotPepper(){

    }
    public HotPepper(ToppingDecorator topping){
        costofpepper += topping.getCost();
        nameOfpepper +=" "+ topping.getTopping();
    }

    public void addTopping(ToppingDecorator object) {
        costofpepper += object.getCost();/*adding all the toppings*/
        nameOfpepper += " "+object.getTopping();
    }


    public String getTopping(){
        return nameOfpepper;
    }

    public double getCost(){
        return  costofpepper;
    }
}
