/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class FromDelete {

    private JFrame frameTable;
    private Vector tableTitle;
    private Vector tableRecords;
    private JTable tableList;

    public FromDelete() {

        frameTable = new JFrame("Student List");
        frameTable.setSize(800, 500);
        frameTable.setLocationRelativeTo(null);

        tableTitle = new Vector();
        tableRecords = new Vector();

        tableTitle.add("ID");
        tableTitle.add("NAME");
        tableTitle.add("BRITHDAY");
        tableTitle.add("PHONE");
        tableTitle.add("EMAIL");
        tableTitle.add("CLASS");

        StudentModel studentModel = new StudentModel();
        ArrayList<Student> list = studentModel.getListStudent();
        for (Student student : list) {
            Vector records = new Vector();
            records.add(student.getId());
            records.add(student.getName());
            records.add(student.getBrithday());
            records.add(student.getPhone());
            records.add(student.getEmail());
            records.add(student.getClassNumber());

            tableRecords.add(records);
        }
        tableList = new JTable();
        tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));

        tableList.addMouseListener(new TableHadle());

        frameTable.add(new JScrollPane(tableList));
        frameTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTable.setVisible(true);

    }

    class TableHadle implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            int d = tableList.getSelectedRow();

            Vector vector = (Vector) tableRecords.get(d);
            Integer id = vector.get(0).hashCode();
            String name = vector.get(1).toString();
            String brithday = vector.get(2).toString();
            String phone = vector.get(3).toString();
            String email = vector.get(4).toString();
            String classNumber = vector.get(5).toString();

            Student student = new Student();

            student.setId(id);
            student.setName(name);
            student.setBrithday(brithday);
            student.setPhone(phone);
            student.setEmail(email);
            student.setClassNumber(classNumber);

            int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sinh viên có thông tin bên dưới ?"
                    + "\nID :       " + id
                    + "\nName :     " + name
                    + "\nBrithday : " + brithday
                    + "\nPhone :    " + phone
                    + "\nEmail :    " + email
                    + "\nClassNB :  " + classNumber);
            if (i == 0) {

                StudentModel model = new StudentModel();
                tableRecords.remove(d);

                model.delete(student);
                tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        FromDelete tm = new FromDelete();
    }
}
