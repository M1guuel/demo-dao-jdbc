/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package application;

import java.util.Date;
import java.util.List;
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

        System.out.println("\n === TEST 2: seller findByDepartment");
        Departament dp = new Departament(2, null);
        List<Seller> list = seller.findByDepartment(dp);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println("\n === TEST 3: seller findByDepartment");
        list = seller.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
           System.out.println("\n === TEST 4: seller Insert =======");
        Seller newSeller = new Seller( null,"miguel","exemp@gmail.com", new Date(), 4000.0, new Departament(2, null));
        seller.insert(newSeller);
        System.out.println(   "NOVO ID: " + newSeller.getId());
        }


    }

