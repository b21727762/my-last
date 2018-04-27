import java.util.ArrayList;

public class OrderDAOImp implements OrderDAO {

    @Override
    public void addOrder(Order obj, ArrayList<Order> orderArray) {
        orderArray.add(obj);
    }

    @Override
    public void getAllOrder(ArrayList<Customer> orderArray) {

    }

    @Override
    public void getOrder(String ID) {

    }


    @Override
    public void deleteOrder(String ID, ArrayList<Order> orderArray) {
        String searchingID = ID;
        for(int a = 0; a<orderArray.size();a++) {
            if(orderArray.get(a).getOrderID().equals(searchingID)) {
                System.out.println(orderArray.get(a).getOrderID()+" removed");
                orderArray.remove(a);

            }
        }
    }
}
