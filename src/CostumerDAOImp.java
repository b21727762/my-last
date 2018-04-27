

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CostumerDAOImp implements CustomerDAO {

    @Override
    public void addCustomer(Customer obj,ArrayList<Customer> customerArray){
        customerArray.add(obj);
    }

    @Override
    public ArrayList<Customer> getAllCustomer(ArrayList<Customer> customerArray) {
      return customerArray;
    }

    @Override
    public void getCostumer(String  ID) {
    }

    @Override
    public void deleteCustomer(String ID,ArrayList<Customer> customerArray) {
        String searchingID = ID;
        for(int a = 0; a<customerArray.size();a++) {
            if(customerArray.get(a).getID().equals(searchingID)) {
                customerArray.remove(a);
            }
        }
    }

}
