public class PlainPizza  {
   String nameOfPlain ="";/*toppings features*/
   double costofPlain = 0;
   public PlainPizza(){

   }
   public PlainPizza(ToppingDecorator topping){
      costofPlain += topping.getCost();
      nameOfPlain += " "+topping.getTopping();
   }


   public void addTopping(ToppingDecorator object) {
      costofPlain += object.getCost();/*adding all the toppings*/
      nameOfPlain += " "+object.getTopping();
   }

   public String getTopping(){
      return nameOfPlain;
   }

   public double getCost(){
      return  costofPlain;
   }
}
