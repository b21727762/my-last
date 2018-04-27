import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Neapolitan implements ToppingDecorator   {
    String nameOfNapolitan = "Neapolitan";/*toppings features*/
    double costofNapolitan = 10;
    public Neapolitan(){

    }
    public Neapolitan(ToppingDecorator topping){
        costofNapolitan += topping.getCost();
        nameOfNapolitan += " "+topping.getTopping();
    }
    public void addTopping(ToppingDecorator object) {
        costofNapolitan += object.getCost();/*adding all the toppings*/
        nameOfNapolitan += " "+object.getTopping();
    }

    public String getTopping(){
        return nameOfNapolitan;
    }

    public double getCost(){
        return  costofNapolitan;
    }
}
