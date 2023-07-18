/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Dao.impl;

import db.Conexao;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

/**
 *
 * @author gueel
 */
public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
    }

    @Override
    public void update(Seller obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Seller fidById(Integer id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("SELECT seller.*, department.name AS DName \n"
                    + "FROM seller INNER JOIN Department\n"
                    + "ON seller.DepartmentId = department.Id \n"
                    + "where seller.Id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                Departament dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new db.DbExeption(e.getMessage());
        } finally {
        }

    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("SELECT seller.*, department.name AS DName \n"
                    + "FROM seller INNER JOIN Department\n"
                    + "ON seller.DepartmentId = department.Id order by name");
            rs = pst.executeQuery();
            
            List<Seller> list = new ArrayList<>();
            Map<Integer,Departament> map = new HashMap<>();
            
            while(rs.next()) {
                Departament dep = map.get(rs.getInt("DepartmentId"));
                
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId" ), dep);
                }
                
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
            
        } catch (SQLException e) {
            throw new db.DbExeption(e.getMessage());
        } finally {
        }
    }

    private Departament instantiateDepartment(ResultSet rs) throws SQLException {
        Departament dep = new Departament();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DName"));
        return dep;
    }

    private Seller instantiateSeller(ResultSet rs, Departament dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setDepartaement(dep);
        return obj;
    }

    @Override
    public List<Seller> findByDepartment(Departament departament) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("SELECT seller.*, department.name AS DName \n"
                    + "FROM seller INNER JOIN Department\n"
                    + "ON seller.DepartmentId = department.Id \n"
                    + "where DepartmentId = ? order by name");

            pst.setInt(1, departament.getId());
            rs = pst.executeQuery();
            
            List<Seller> list = new ArrayList<>();
            Map<Integer,Departament> map = new HashMap<>();
            
            while(rs.next()) {
                Departament dep = map.get(rs.getInt("DepartmentId"));
                
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId" ), dep);
                }
                
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
            
        } catch (SQLException e) {
            throw new db.DbExeption(e.getMessage());
        } finally {
        }
    }

}
