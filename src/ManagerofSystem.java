

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerofSystem extends CostumerDAOImp{
    public static void ReadFile(ArrayList<Customer> customerList,ArrayList<Order> orderlist) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Scanner scanner = null;
        FileOutputStream customerout =null;
        try {
             customerout = new FileOutputStream("output.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*input file reading*/
        CustomerDAO customerDAO = new CostumerDAOImp(); /* created an object for reach the DAO*/
        OrderDAO orderDAO=new OrderDAOImp();
        FileInputStream customer = null;
        try {
            scanner = new Scanner(new FileReader("input.txt"));/*input.txt openning*/
            int counter = 0;
            while (scanner.hasNextLine()) {
                String customerInformation = scanner.nextLine();
                String[] customerArray = customerInformation.split(" ",6);


                if (customerArray[0].equalsIgnoreCase("AddCustomer")){
                    Customer customerobj = new Customer(customerArray[1],customerArray[2],customerArray[3],customerArray[4],customerArray[5]);
                    customerDAO.addCustomer(customerobj,customerList);/*customer object added to customerList with DAO*/
                    System.out.println("Costumer "+customerobj.getName()+" created");
                    String s = "Costumer "  + customerobj.getName()+" created"+"\n";
                    byte[] yaz = s.getBytes();
                    customerout.write(yaz);
                }

                else if(customerArray[0].equalsIgnoreCase("RemoveCustomer")){
                    String searchingID = customerArray[1];
                    for(int a = 0; a<customerList.size();a++) {
                        if(customerList.get(a).getID().equals(searchingID)) {
                            System.out.println("Customer "+customerList.get(a).getID()+" "+customerList.get(a).getName()+" removed");
                            String s = "Customer "+customerList.get(a).getID()+" "+customerList.get(a).getName()+" removed\n";
                            byte[] yaz = s.getBytes();
                            customerout.write(yaz);
                        }
                    }
                    customerDAO.deleteCustomer(customerArray[1],customerList);/*customer object removed to customerList with DAO*/
                }
                else if(customerArray[0].equalsIgnoreCase("CreateOrder")){
                    ArrayList<String > currentList = new ArrayList<String>();
                    ArrayList<Integer > costList = new ArrayList<Integer>();
                    Order orderobj = new Order(customerArray[1],customerArray[2],currentList,costList);
                    orderDAO.addOrder(orderobj,orderlist);/*order created with orderDAO*/
                }
                /*remove oorder cmmand*/
                else if(customerArray[0].equalsIgnoreCase("RemoveOrder")){
                   orderDAO.deleteOrder(customerArray[1],orderlist);/*order removed with orderDAO*/
                }
                else if(customerArray[0].equalsIgnoreCase("ListCustomers")){
                    customerList.sort(Comparator.comparing(Customer::getName));/*customerList sorted*/
                    System.out.println("Costumer List:");
                    String s = "Costumer List:\n";
                    byte[] yaz = s.getBytes();
                    customerout.write(yaz);
                    for(int a = 0; a<customerList.size();a++) {
                        System.out.println(customerList.get(a).getID()+" "+customerList.get(a).getName()+" "+customerList.get(a).getSurname()+" "+customerList.get(a).getTphone());
                        String s1 =(customerList.get(a).getID()+" "+customerList.get(a).getName()+" "+customerList.get(a).getSurname()+" "+customerList.get(a).getTphone()+"\n");
                        byte[] yaz1 = s1.getBytes();
                        customerout.write(yaz1);

                    }
                    customerDAO.getAllCustomer(customerList);
                }
                else if(customerArray[0].equalsIgnoreCase("AddPizza")) {
                    String orderID = customerArray[1];
                    int lineLenght = customerArray.length;
                    for (int a = 0; a < orderlist.size(); a++) {
                        if (orderlist.get(a).getOrderID().equals(orderID)) {
                            if (lineLenght > 6) {
                                System.out.println("Unacceptable Order!!");/*too many topping for pizza*/
                                String s = "Unacceptable Order!!\n";
                                byte[] yaz = s.getBytes();
                                customerout.write(yaz);
                            } else {
                                boolean control = true;
                                for (int i = 2; i < lineLenght; i++) {
                                    if (!(customerArray[i].equalsIgnoreCase("AmericanPan") || customerArray[i].equalsIgnoreCase("Neapolitan") || customerArray[i].equalsIgnoreCase("Onion") || customerArray[i].equalsIgnoreCase("Salami") || customerArray[i].equalsIgnoreCase("Soudjouk") || customerArray[i].equalsIgnoreCase("HotPepper"))) {
                                        System.out.println("Unacceptabe Topping");/*wrong topping for pizza*/
                                        String s = ("Unacceptabe Topping\n");
                                        byte[] yaz = s.getBytes();
                                        customerout.write(yaz);
                                        control = false;
                                    }
                                }
                                if (control) {
                                    PlainPizza newPizza = new PlainPizza();/*pizza dough creted*/

                                    for (int w = 2; w < lineLenght; w++) {
                                        Class<ToppingDecorator> classA = (Class<ToppingDecorator>) Class.forName(customerArray[w]);
                                        Constructor AConst = classA.getConstructor();
                                        newPizza.addTopping((ToppingDecorator) AConst.newInstance());/*toppings added with addTopping method()*/
                                    }
                                    orderlist.get(a).pizzaList.add(newPizza.getTopping());
                                    orderlist.get(a).costList.add((int)newPizza.getCost());
                                    if (customerArray[2].equalsIgnoreCase("AmericanPan")) {
                                        System.out.println("AmericianPan pizza added to order " + orderID);
                                        String s = ("AmericianPan pizza added to order " + orderID+"\n");
                                        byte[] yaz = s.getBytes();
                                        customerout.write(yaz);
                                    }
                                    else{
                                        System.out.println("Neapolitan pizza added to order " + orderID);
                                        String s =("Neapolitan pizza added to order " + orderID+"\n");
                                        byte[] yaz = s.getBytes();
                                        customerout.write(yaz);
                                    }
                                }

                            }
                        }

                    }

                }else if(customerArray[0].equalsIgnoreCase("AddDrink")){
                    String orderID = customerArray[1];
                    for(int a = 0;a<orderlist.size();a++){
                        if(orderlist.get(a).getOrderID().equals(orderID)){
                            System.out.println("Drink added to "+customerArray[1]);
                            String s = "Drink added to "+customerArray[1]+"\n";
                            byte[] yaz = s.getBytes();
                            customerout.write(yaz);
                            orderlist.get(a).pizzaList.add(" softdrink");/*softdrink added*/
                            orderlist.get(a).costList.add(1);
                          }
                    }
                }
                else if(customerArray[0].equalsIgnoreCase("PayCheck")){
                    System.out.println("PayCheck for order "+customerArray[1]);
                    String s ="PayCheck for order "+customerArray[1]+"\n";
                    byte[] yaz = s.getBytes();
                    customerout.write(yaz);
                    int sum = 0;
                    for(int a=0 ; a<orderlist.size();a++){
                        if((orderlist.get(a).getOrderID()).equalsIgnoreCase(customerArray[1])){
                            for (int i=0;i<orderlist.get(a).pizzaList.size(); i++){
                                System.out.println("   "+orderlist.get(a).pizzaList.get(i)+" "+orderlist.get(a).costList.get(i)+"$");
                                String s1 = "   "+orderlist.get(a).pizzaList.get(i)+" "+orderlist.get(a).costList.get(i)+"$"+"\n";
                                byte[] yaz1 = s1.getBytes();
                                customerout.write(yaz1);
                                sum += orderlist.get(a).costList.get(i);/*sum calculated*/
                            }
                            System.out.println("    Total: "+sum);
                            String s2 = ("    Total: "+sum)+"\n";
                            byte[] yaz1 = s2.getBytes();
                            customerout.write(yaz1);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileOutputStream cusout =null;
        try {
            cusout = new FileOutputStream("customer.txt");
            customerList.sort(Comparator.comparing(Customer::getName));/*customerList sorted*/
            System.out.println("******************************");
            for (int count = 0;count<customerList.size();count++){/*updated list printed*/
                System.out.println(customerList.get(count).getID()+" "+customerList.get(count).getName()+" "+customerList.get(count).getSurname()+" "+customerList.get(count).getTphone()+" "+customerList.get(count).getAdress());
                String s =    (customerList.get(count).getID()+" "+customerList.get(count).getName()+" "+customerList.get(count).getSurname()+" "+customerList.get(count).getTphone()+" "+customerList.get(count).getAdress()+"\n");
                byte[] yaz1 = s.getBytes();
                cusout.write(yaz1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream orderout =null;
        try {
            orderout = new FileOutputStream("order.txt");
            for (int counter = 0;counter<orderlist.size();counter++){/*updated list printed*/
                System.out.println(orderlist.get(counter).getOrderID()+" "+orderlist.get(counter).getWhospizza());
                String s = orderlist.get(counter).getOrderID()+" "+orderlist.get(counter).getWhospizza()+"\n";
                byte[] yaz1 = s.getBytes();
                orderout.write(yaz1);
                for (int a =0;a<orderlist.get(counter).pizzaList.size();a++){
                    System.out.println(orderlist.get(counter).pizzaList.get(a).toString());
                    String s1 = orderlist.get(counter).pizzaList.get(a).toString()+"\n";
                    byte[] yaz = s1.getBytes();
                    orderout.write(yaz);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
