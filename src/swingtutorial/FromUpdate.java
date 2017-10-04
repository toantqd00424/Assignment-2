/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JButton;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MSI
 */
public class FromUpdate {

    private JFrame frameUpdate;
    private JPanel panelUpdate;
    private JTextField txtNameUpdate;
    private JTextField txtBirthdayUpdate;
    private JTextField txtPhoneUpdate;
    private JTextField txtEmailUpdate;
    private JTextField txtClassUpdate;
    private JFormattedTextField txtSearch;
    private JLabel lblSearch;
    private JLabel lblNameUp;
    private JLabel lblBirthdayUp;
    private JLabel lblPhoneUp;
    private JLabel lblEmailUp;
    private JLabel lblClassUp;
    private JButton btnUpdate;
    private JButton btnSearch;

    public FromUpdate() {

        frameUpdate = new JFrame("Update Student");
        frameUpdate.setSize(600, 500);
        frameUpdate.setLayout(null);
        frameUpdate.setLocationRelativeTo(null);

        panelUpdate = new JPanel();
        panelUpdate.setBounds(0, 0, 600, 500);
        panelUpdate.setBackground(Color.decode("#3B5998"));
        panelUpdate.setLayout(null);
        frameUpdate.add(panelUpdate);

        lblSearch = new JLabel("Nhập ID SV CẦN SỬA");
        lblSearch.setBounds(10, 20, 190, 40);
        lblSearch.setFont(new Font("Times New Roman", 1, 15));
        lblSearch.setForeground(Color.red);
        panelUpdate.add(lblSearch);

        lblNameUp = new JLabel("Name");
        lblNameUp.setBounds(20, 100, 100, 40);
        lblNameUp.setFont(new Font("Times New Roman", 1, 20));
        lblNameUp.setForeground(Color.white);
        panelUpdate.add(lblNameUp);

        lblBirthdayUp = new JLabel("Birthday");
        lblBirthdayUp.setBounds(20, 145, 100, 40);
        lblBirthdayUp.setFont(new Font("Times New Roman", 1, 20));
        lblBirthdayUp.setForeground(Color.white);
        panelUpdate.add(lblBirthdayUp);

        lblPhoneUp = new JLabel("Phone");
        lblPhoneUp.setBounds(20, 190, 100, 40);
        lblPhoneUp.setFont(new Font("Times New Roman", 1, 20));
        lblPhoneUp.setForeground(Color.white);
        panelUpdate.add(lblPhoneUp);

        lblEmailUp = new JLabel("Email");
        lblEmailUp.setBounds(20, 235, 100, 40);
        lblEmailUp.setFont(new Font("Times New Roman", 1, 20));
        lblEmailUp.setForeground(Color.white);
        panelUpdate.add(lblEmailUp);

        lblClassUp = new JLabel("Class");
        lblClassUp.setBounds(20, 280, 100, 40);
        lblClassUp.setFont(new Font("Times New Roman", 1, 20));
        lblClassUp.setForeground(Color.white);
        panelUpdate.add(lblClassUp);

        txtSearch = new JFormattedTextField();
        txtSearch.setBounds(200, 20, 220, 40);
        panelUpdate.add(txtSearch);

        txtNameUpdate = new JTextField();
        txtNameUpdate.setBounds(125, 100, 300, 40);
        panelUpdate.add(txtNameUpdate);

        txtBirthdayUpdate = new JTextField();
        txtBirthdayUpdate.setBounds(125, 145, 300, 40);
        panelUpdate.add(txtBirthdayUpdate);

        txtPhoneUpdate = new JTextField();
        txtPhoneUpdate.setBounds(125, 190, 300, 40);
        panelUpdate.add(txtPhoneUpdate);

        txtEmailUpdate = new JTextField();
        txtEmailUpdate.setBounds(125, 235, 300, 40);
        panelUpdate.add(txtEmailUpdate);

        txtClassUpdate = new JTextField();
        txtClassUpdate.setBounds(125, 280, 300, 40);
        panelUpdate.add(txtClassUpdate);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(150, 330, 100, 40);
        btnUpdate.setForeground(Color.white);
        btnUpdate.setBackground(Color.decode("#2A9E23"));
        panelUpdate.add(btnUpdate);

        btnUpdate.addActionListener(new UpdateHadle());

        btnSearch = new JButton("Search");
        btnSearch.setBounds(320, 65, 100, 30);
        panelUpdate.add(btnSearch);

        btnSearch.addActionListener(new SearchHadle());

        frameUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUpdate.setVisible(true);

    }

    class SearchHadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentModel studentModel = new StudentModel();

            int i = Integer.parseInt(txtSearch.getText());
            Student student = studentModel.getByid(i);

            txtNameUpdate.setText(student.getName());
            txtBirthdayUpdate.setText(student.getBrithday());
            txtPhoneUpdate.setText(student.getPhone());
            txtEmailUpdate.setText(student.getEmail());
            txtClassUpdate.setText(student.getClassNumber());

        }
    }

    class UpdateHadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Student s = new Student();

            String name = txtNameUpdate.getText();
            String birthday = txtBirthdayUpdate.getText();
            String phone = txtPhoneUpdate.getText();
            String email = txtEmailUpdate.getText();
            String classNumber = txtClassUpdate.getText();

            s.setName(name);
            s.setBrithday(birthday);
            s.setPhone(phone);
            s.setEmail(email);
            s.setClassNumber(classNumber);

            int i = JOptionPane.showConfirmDialog(null, "Bạn muốn lưu những thông tin đã thay đổi không???"
                    + "\nNAME : " + txtNameUpdate.getText()
                    + "\nBRITHDAY : " + txtBirthdayUpdate.getText()
                    + "\nPHONE : " + txtPhoneUpdate.getText()
                    + "\nEMAIL : " + txtEmailUpdate.getText()
                    + "\nCLASSNUMBER : " + txtClassUpdate.getText());
            if (i == 0) {
                StudentModel model = new StudentModel();
                model.update(s);
                JOptionPane.showMessageDialog(null, "Lưu dữ liệu sau khi thay đổi thành công");
            }

        }
    }

    public static void main(String[] args) {
        FromUpdate fu = new FromUpdate();
    }
}
