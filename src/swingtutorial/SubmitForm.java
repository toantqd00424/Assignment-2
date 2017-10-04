/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author MSI
 */
public class SubmitForm {

    private JFrame frameSubmit;

    private JLabel lblName;
    private JLabel lblBrithday;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JLabel lblClassNumber;

    private JTextField txtName;
    private JFormattedTextField txtBrithday;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtClassNumber;

    private JButton btnSubmit;
    private JButton btnReset;
    private JButton btn1;

    private JPanel panel;
    private JPanel panel_1;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemDelete;
    private JMenuItem menuItemUpdate;

    private JLabel lb;
    private JLabel lblNameMesage;
    private JLabel lblEmailMesage;
    private JLabel lblBrithdayMesage;
    private JLabel lblPhoneMesage;
    private JLabel lblClassNumberMesagge;

    public SubmitForm() {
        try {
            frameSubmit = new JFrame("Student Menager");
            frameSubmit.setSize(1000, 800);
            frameSubmit.setLocationRelativeTo(null);

            panel = new JPanel();
            panel = new ImagePanel(new ImageIcon("E:\\JAVA\\Demo tren lop\\New Folder\\Assignment\\src\\swingtutorial\\18.jpg").getImage());
            panel.setBounds(0, 0, 1000, 800);

//            panel_1 = new JPanel();
//            
//            panel_1.setBounds(0, 0, 1000, 800);
//            panel_1.setBackground(new Color(0, 0, 0, 0));
            lb = new JLabel();
            lb = new ImageLabel(new ImageIcon("E:\\JAVA\\Demo tren lop\\New Folder\\Assignment\\src\\swingtutorial\\14.png").getImage());
            lb.setBounds(505, 130, 400, 140);

            menuBar = new JMenuBar();
            frameSubmit.setJMenuBar(menuBar);

            menu = new JMenu("Student Managers");
            menu.setForeground(Color.red);
            menuBar.add(menu);

            menuItemDelete = new JMenuItem("Student Delete");
            menu.add(menuItemDelete);
            menuItemDelete.addActionListener(new MenuDeleteHadle());

            menuItemUpdate = new JMenuItem("Student Update");
            menu.add(menuItemUpdate);
            menuItemUpdate.addActionListener(new MenuUpdateHadle());

            lblName = new JLabel("NAME");
            lblName.setForeground(Color.red);
            lblName.setFont(new java.awt.Font("Times New Roman", 2, 20));
            lblName.setBounds(400, 290, 100, 40);

            lblBrithday = new JLabel("BRITHDAY");
            lblBrithday.setForeground(Color.red);
            lblBrithday.setFont(new java.awt.Font("Times New Roman", 2, 20));
            lblBrithday.setBounds(400, 340, 100, 40);

            lblPhone = new JLabel("PHONE");
            lblPhone.setForeground(Color.red);
            lblPhone.setFont(new java.awt.Font("Times New Roman", 2, 20));
            lblPhone.setBounds(400, 390, 100, 40);

            lblEmail = new JLabel("EMAIL");
            lblEmail.setForeground(Color.red);
            lblEmail.setFont(new java.awt.Font("Times New Roman", 2, 20));
            lblEmail.setBounds(400, 440, 100, 40);

            lblClassNumber = new JLabel("CLASS");
            lblClassNumber.setForeground(Color.red);
            lblClassNumber.setFont(new java.awt.Font("Times New Roman", 2, 20));
            lblClassNumber.setBounds(400, 490, 100, 40);

            txtName = new JTextField();
            txtName.setForeground(Color.BLACK);
            txtName.setFont(new java.awt.Font("Times New Roman", 1, 20));
            txtName.setBounds(505, 290, 300, 40);

            txtBrithday = new JFormattedTextField(new MaskFormatter("##/##/####"));
            txtBrithday.setForeground(Color.BLACK);
            txtBrithday.setFont(new java.awt.Font("Times New Roman", 1, 20));
            txtBrithday.setBounds(505, 340, 300, 40);

            txtPhone = new JTextField();
            txtPhone.setForeground(Color.BLACK);
            txtPhone.setFont(new java.awt.Font("Times New Roman", 1, 20));
            txtPhone.setBounds(505, 390, 300, 40);

            txtEmail = new JTextField();
            txtEmail.setForeground(Color.BLACK);
            txtEmail.setFont(new java.awt.Font("Times New Roman", 1, 20));
            txtEmail.setBounds(505, 440, 300, 40);

            txtClassNumber = new JTextField();
            txtClassNumber.setForeground(Color.BLACK);
            txtClassNumber.setFont(new java.awt.Font("Times New Roman", 1, 20));
            txtClassNumber.setBounds(505, 490, 300, 40);

            btnSubmit = new JButton("SUBMIT");
            btnSubmit.setBackground(Color.decode("#3B5998"));
            btnSubmit.setForeground(Color.WHITE);
            btnSubmit.setBounds(505, 540, 80, 30);

            btnReset = new JButton("RESET");
            btnReset.setBackground(Color.decode("#3B5998"));
            btnReset.setForeground(Color.WHITE);
            btnReset.setBounds(590, 540, 80, 30);

            lblNameMesage = new JLabel();
            lblNameMesage.setBounds(810, 290, 150, 40);

            lblPhoneMesage = new JLabel();
            lblPhoneMesage.setBounds(810, 390, 150, 40);

            lblEmailMesage = new JLabel();
            lblEmailMesage.setBounds(810, 440, 150, 40);

            lblBrithdayMesage = new JLabel();
            lblBrithdayMesage.setBounds(810, 340, 150, 40);

            lblClassNumberMesagge = new JLabel();
            lblClassNumberMesagge.setBounds(810, 490, 150, 40);

            btn1 = new JButton("Print student list");
            btn1.setBackground(Color.decode("#2A9E23"));
            btn1.setForeground(Color.WHITE);
            btn1.setBounds(675, 540, 130, 30);
            btn1.addActionListener(new Btn1Hadle());

            btnSubmit.addActionListener(new SubmitHadel());
            btnReset.addActionListener(new ResetHadle());

            panel.add(this.btn1);
            panel.add(this.lb);
            panel.add(this.lblName);
            panel.add(this.lblPhone);
            panel.add(this.lblEmail);
            panel.add(this.lblBrithday);
            panel.add(this.lblClassNumber);
            panel.add(this.txtName);
            panel.add(this.txtBrithday);
            panel.add(this.txtEmail);
            panel.add(this.txtPhone);
            panel.add(this.txtClassNumber);
            panel.add(this.btnSubmit);
            panel.add(this.btnReset);
            panel.add(this.lblNameMesage);
            panel.add(this.lblBrithdayMesage);
            panel.add(this.lblEmailMesage);
            panel.add(this.lblClassNumberMesagge);
            panel.add(this.lblPhoneMesage);

            frameSubmit.getContentPane().add(this.panel);
            frameSubmit.setLayout(null);
            frameSubmit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameSubmit.setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(SubmitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class SubmitHadel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = new Student();

            String name = txtName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            String brithday = txtBrithday.getText();
            String classNuber = txtClassNumber.getText();

            student.setName(name);
            student.setBrithday(brithday);
            student.setPhone(phone);
            student.setEmail(email);
            student.setClassNumber(classNuber);

            HashMap<String, String> errors = new FromHandle().validateSubmit(student);
            if (errors.size() == 0) {
                resetMesage();
                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn nhập thông tin bên dưới?"
                        + "\nNAME : " + txtName.getText()
                        + "\nBRITHDAY : " + txtBrithday.getText()
                        + "\nPHONE : " + txtPhone.getText()
                        + "\nEMAIL : " + txtEmail.getText()
                        + "\nCLASSNUMBER : " + txtClassNumber.getText());

                if (result == 0) {
                    StudentModel studentModel = new StudentModel();
                    studentModel.insert(student);
                    JOptionPane.showMessageDialog(null, "Them du lieu thanh cong");
                    txtName.setText("");
                    txtPhone.setText("");
                    txtBrithday.setText("");
                    txtEmail.setText("");
                    txtClassNumber.setText("");

                }
                if (result == 1) {

                    txtName.setText("");
                    txtPhone.setText("");
                    txtBrithday.setText("");
                    txtEmail.setText("");
                    txtClassNumber.setText("");

                }

            } else {
                showError(errors);
            }
        }

        private void resetMesage() {
            lblPhoneMesage.setText("");
            lblNameMesage.setText("");
            lblEmailMesage.setText("");
            lblBrithdayMesage.setText("");
            lblClassNumberMesagge.setText("");
        }

        private void showError(HashMap<String, String> errors) {

            if (errors.containsKey("txtName")) {
                lblNameMesage.setForeground(Color.red);
                lblNameMesage.setText(errors.get("txtName"));
            } else {
                lblNameMesage.setForeground(Color.green);
                lblNameMesage.setText("ok");
            }
            if (errors.containsKey("txtBrithday")) {
                lblBrithdayMesage.setForeground(Color.red);
                lblBrithdayMesage.setText(errors.get("txtBrithday"));
            } else {
                lblBrithdayMesage.setForeground(Color.green);
                lblBrithdayMesage.setText("ok");
            }
            if (errors.containsKey("txtEmail")) {
                lblEmailMesage.setForeground(Color.red);
                lblEmailMesage.setText(errors.get("txtEmail"));
            } else {
                lblEmailMesage.setForeground(Color.green);
                lblEmailMesage.setText("ok");
            }
            if (errors.containsKey("txtClassNumber")) {
                lblClassNumberMesagge.setForeground(Color.red);
                lblClassNumberMesagge.setText(errors.get("txtClassNumber"));
            } else {
                lblClassNumberMesagge.setForeground(Color.green);
                lblClassNumberMesagge.setText("ok");
            }
            if (errors.containsKey("txtPhone")) {
                lblPhoneMesage.setForeground(Color.red);
                lblPhoneMesage.setText(errors.get("txtPhone"));
            } else {
                lblPhoneMesage.setForeground(Color.green);
                lblPhoneMesage.setText("ok");
            }
        }

    }

    class ResetHadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            txtName.setText("");
            txtPhone.setText("");
            txtBrithday.setText("");
            txtEmail.setText("");
            txtClassNumber.setText("");
        }
    }

    class MenuDeleteHadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FromDelete tableModel = new FromDelete();
        }
    }

    class MenuUpdateHadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FromUpdate fromUpdate = new FromUpdate();
        }
    }

    class Btn1Hadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TableStudent tableStudent = new TableStudent();
        }
    }

}
