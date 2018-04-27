import java.util.ArrayList;

public class Order {
   private String orderID ;
   private String whospizza ;
   public String deneme;

   public ArrayList<String> pizzaList = new ArrayList<String >();
   public ArrayList<Integer> costList = new ArrayList<Integer>( );

   public Order(String orderID,String whospizza,ArrayList<String> pizzaList,ArrayList<Integer> costList){
      this.orderID = orderID;
      this.whospizza = whospizza;
      this.pizzaList = pizzaList;
      this.costList = costList;

   }

   public String getOrderID() {
      return orderID;
   }

   public void setOrderID(String orderID) {
      this.orderID = orderID;
   }

   public String getWhospizza() {
      return whospizza;
   }

   public void setWhospizza(String whospizza) {
      this.whospizza = whospizza;
   }

   /*public ArrayList<Object> getPizzaList() {
      return this.pizzaList;
   }

   public void pizaaa(Object newPizza){
      pizzaList.add(newPizza);

   }*/

}
