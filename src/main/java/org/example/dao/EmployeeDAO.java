package org.example.dao;

import org.example.connection.ConnectionUtil;
import org.example.model.Employee;
import org.example.model.Qualification;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class EmployeeDAO {
    Connection con;
    private PreparedStatement ps;

    public int addEmployee(Employee employee){
        con= ConnectionUtil.getConnection();
        try {
            ps=con.prepareStatement("INSERT INTO `employee`" +
                    "(`name`," +
                    "`isWomen`," +
                    "`age`," +
                    "`bloodGroup`," +
                    "`phoneNumber`," +
                    "qualification," +
                    "`startDate`," +
                    "`address`" +
                    ",`imageIcon`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1,employee.getName());
            ps.setBoolean(2,employee.isWomen());
            ps.setInt(3,employee.getAge());
            ps.setString(4,employee.getBloodGroup());
            ps.setString(5,employee.getPhoneNumber());
            ps.setObject(6,employee.getQualification());
            ps.setDate(7, (Date) employee.getStartDate());
            ps.setString(8,employee.getAddress());
            ps.setObject(9,employee.getImageIcon());
            int n=ps.executeUpdate();
            con.close();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteEmployee(int id){
        con=ConnectionUtil.getConnection();
        try{
            ps=con.prepareStatement("DELETE FROM `employee` WHERE id=?");
            ps.setInt(1,id);
            int n=ps.executeUpdate();
            con.close();
            return n;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    public Employee searchEmployee(int id) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("SELECT * FROM `employee` WHERE id=?");
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();
            Employee employee = null;
            if (result.first()) {
                employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setWomen(result.getBoolean("isWomen"));
                employee.setAge(result.getInt("age"));
                employee.setBloodGroup(result.getString("bloodGroup"));
                employee.setPhoneNumber(result.getString("phoneNumber"));
                employee.setQualification((Qualification) result.getObject("qualification"));
                employee.setStartDate(result.getDate("startDate"));
                employee.setAddress(result.getString("address"));
                employee.setImageIcon((ImageIcon) result.getObject("imageIcon"));
            }
            con.close();
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int updateEmployee(Employee employee)
    {
        con=ConnectionUtil.getConnection();
        try {
            ps=con.prepareStatement("UPDATE `employee` SET " +
                    "`name`=?, " +
                    "`isWomen`=?, " +
                    "`age`=?, " +
                    "`bloodGroup`=?, " +
                    "`phoneNumber`=?," +
                    "`qualification`=?," +
                    "`startDate`=?," +
                    "`address`=?," +
                    "`imageIcon`=? WHERE id=?");
            ps.setString(1,employee.getName());
            ps.setBoolean(2,employee.isWomen());
            ps.setInt(3,employee.getAge());
            ps.setString(4,employee.getBloodGroup());
            ps.setString(5,employee.getPhoneNumber());
            ps.setObject(6,employee.getQualification());
            ps.setDate(7, (Date) employee.getStartDate());
            ps.setString(8,employee.getAddress());
            ps.setObject(9,employee.getImageIcon());
            int n=ps.executeUpdate();
            con.close();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public void loadData(DefaultTableModel tableModel){
        try(Connection conn = ConnectionUtil.getConnection();
            Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
            ResultSetMetaData metaData = rs.getMetaData();
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }
            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
        }
    }
}
