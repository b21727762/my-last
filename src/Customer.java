import java.util.ArrayList;
import java.util.Comparator;

public class Customer{
    private String ID ;
    private String name ;/*customers features */
    private String surname;
    private String tphone ;
    private  String Adress ;

    public Customer(String ID,String name,String surname,String tphone,String adress) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.tphone = tphone;
        this.Adress =adress;
    }


    public  String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }


}
