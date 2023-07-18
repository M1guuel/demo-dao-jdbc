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
import java.util.List;
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
            pst = conn.prepareStatement("SELECT seller.*, department.name AS DName \n" +
"                   FROM seller INNER JOIN Department\n" +
"                    ON seller.DepartmentId = department.Id \n" +
"                    where seller.Id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                Departament dep = new Departament();
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setDepartaement(dep);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new db.DbExeption(e.getMessage());
        } finally {
            db.Conexao.closeConnection(conn, pst, rs);
        }

    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
