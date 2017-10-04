/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.entity.Student;

/**
 *
 * @author MSI
 */
public class StudentModel {

    public void insert(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("INSERT INTO dssv"
                    + " (name, birthday, phone, email, class_name) "
                    + "VALUES (?, ?, ?, ?, ?)");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getBrithday());
            preStt.setString(3, student.getPhone());
            preStt.setString(4, student.getEmail());
            preStt.setString(5, student.getClassNumber());
            preStt.execute();
        } catch (SQLException e) {
            System.err.println("Loi" + e.getMessage());
        }
    }

    public static ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM dssv");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setBrithday(rs.getString("birthday"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                student.setClassNumber(rs.getString("class_name"));

                listStudent.add(student);
            }

        } catch (SQLException e) {
            System.err.println("Loi trong qua trinh lay danh sach" + e.getMessage());
        }
        return listStudent;

    }

    public Student getByid(int id) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM dssv WHERE id=?;");
            preStt.setInt(1, id);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setBrithday(rs.getString("birthday"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                student.setClassNumber(rs.getString("class_name"));
                return student;
            }
        } catch (SQLException e) {
            System.err.println("loi" + e.getMessage());
        }

        return null;

    }

    public void update(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("UPDATE dssv SET name = ?, birthday = ?, phone = ?, email = ? WHERE class_name = ?");

            preStt.setString(1, student.getName());
            preStt.setString(2, student.getBrithday());
            preStt.setString(3, student.getPhone());
            preStt.setString(4, student.getEmail());
            preStt.setString(5, student.getClassNumber());

            preStt.execute();
        } catch (SQLException e) {
            System.err.println("Loi lenh databe" + e.getMessage());
        }
    }

    public void delete(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("DELETE FROM dssv WHERE id=?");
            preStt.setInt(1, student.getId());

            preStt.execute();
        } catch (SQLException e) {
            System.err.println("Loi lenh databe" + e.getMessage());

        }

    }

}
