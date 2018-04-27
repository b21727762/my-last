import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Soudjouk implements ToppingDecorator {

    String nameOfSoudjouk = "Soudjouk";/*toppings features*/
    double costofSoudjouk = 3;
    public Soudjouk(){

    }
    public Soudjouk(ToppingDecorator topping){
        costofSoudjouk += topping.getCost();
        nameOfSoudjouk +=" "+ topping.getTopping();
    }

    public void addTopping(ToppingDecorator object) {
        costofSoudjouk += object.getCost();/*adding all the toppings*/
        nameOfSoudjouk += " "+object.getTopping();
    }

    public String getTopping(){
        return nameOfSoudjouk;
    }

    public double getCost(){
        return  costofSoudjouk;
    }
}
