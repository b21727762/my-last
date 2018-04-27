import java.util.ArrayList;

public interface OrderDAO {
    public void addOrder(Order obj,ArrayList<Order> orderArray);/*orderDAO methods created abstarcly*/

    public void getAllOrder(ArrayList<Customer> orderArray);

    public void getOrder(String ID);

    public void deleteOrder(String ID,ArrayList<Order> orderArray);
}
