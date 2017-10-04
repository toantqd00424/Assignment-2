/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.util.ArrayList;
import java.util.Vector;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class TableStudent {

    private JFrame frameTable;
    private Vector title;
    private Vector records;
    private JTable list;

    public TableStudent() {

        frameTable = new JFrame("Student List");
        frameTable.setSize(1000, 500);
        frameTable.setLocationRelativeTo(null);

        title = new Vector();
        records = new Vector();

        title.add("ID");
        title.add("NAME");
        title.add("BRITHDAY");
        title.add("PHONE");
        title.add("EMAIL");
        title.add("CLASS");

        StudentModel studentModel = new StudentModel();
        ArrayList<Student> studentList = studentModel.getListStudent();
        for (Student student : studentList) {
            Vector records = new Vector();
            records.add(student.getId());
            records.add(student.getName());
            records.add(student.getBrithday());
            records.add(student.getPhone());
            records.add(student.getEmail());
            records.add(student.getClassNumber());

            this.records.add(records);
        }
        this.list = new JTable();
        this.list.setModel(new DefaultTableModel(records, title));

        frameTable.add(new JScrollPane(this.list));
        frameTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTable.setVisible(true);

    }
}
