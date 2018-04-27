import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<Customer> customerList = new ArrayList<Customer>();/*customerList created*/
        ArrayList<Order> orderList = new ArrayList<Order>();/*orderList created*/
        ManagerofSystem.ReadFile(customerList,orderList);/*ReadFile() method calling*/
    }
}
