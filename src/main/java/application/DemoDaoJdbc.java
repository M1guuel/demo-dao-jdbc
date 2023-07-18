/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package application;

import java.util.Date;
import model.entities.Departament;
import model.entities.Seller;

/**
 *
 * @author gueel
 */
public class DemoDaoJdbc {

    public static void main(String[] args) {
       Seller seller = new Seller(1,"Miguel","Exempl@gmail.com", new Date() , 4000.0, new Departament(1, "Adm"));
        
        System.out.println(seller);
        
        
    }
}
