

import java.util.ArrayList;

public interface CustomerDAO {
    public void addCustomer(Customer obj,ArrayList<Customer> customerArray);/*customer decorator methods created abstarcly*/

    public ArrayList<Customer> getAllCustomer(ArrayList<Customer> customerArray);

    public void getCostumer(String ID);

    public void deleteCustomer(String ID,ArrayList<Customer> customerArray);

}
