/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package application;

import java.util.Date;
import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

/**
 *
 * @author gueel
 */
public class DemoDaoJdbc {

    public static void main(String[] args) {
        SellerDao seller = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById");
        Seller s = seller.fidById(3);
        System.out.println(s);

    }
}
