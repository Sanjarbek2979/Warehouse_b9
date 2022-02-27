package uz.pdp.warehouse_app.service;

/**
 * @author Sanjarbek Allayev, вс 15:07. 27.02.2022
 */
public class Services {

    public static String getRandomNumber(){
        int i = (int) (Math.random() * 100) + 1000;
return ""+i;
    }
}
