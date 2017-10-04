
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtutorial;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaconsole.entity.Student;

/**
 *
 * @author MSI
 */
public class FromHandle {

   

    private static final String BIRTHDAY_REGEX = "^\\d{2}/\\d{2}/\\d{4}"; // bieu thuc regex
    public boolean vaildateBirthday(String txtBrithday) {
        Pattern p = Pattern.compile(BIRTHDAY_REGEX);
        Matcher m = p.matcher(txtBrithday);
        return m.matches();
    }
    
    private static final String PHONE_REGEX = "^0(1\\d{9}|9\\d{8}|8\\d{8})$";
    public boolean vaildatePhone(String txtPhone) {
        Pattern ptn = Pattern.compile(PHONE_REGEX);
        Matcher mcr = ptn.matcher(txtPhone);
        return mcr.matches();
    }

    private static final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,3}$", Pattern.CASE_INSENSITIVE);

    public static boolean valiEmail(String emailStr) {
        Matcher matcher = emailRegex.matcher(emailStr);
        return matcher.matches();
    }

    public HashMap<String, String> validateSubmit(Student student) {

        HashMap<String, String> errors = new HashMap<>();
//        if (student.getId() == 0) {
//            errors.put("txtId", "* Vui long nhap ID");
//        }
        if (student.getName().isEmpty()) {
            errors.put("txtName", "* nhap Name");
        }

        if (student.getEmail().isEmpty()) {
            errors.put("txtEmail", "* nhap Email");
        } else if (valiEmail(student.getEmail()) == false) {
            errors.put("txtEmail", "* nhap dung dinh dang Email");
        }

        if (!vaildateBirthday(student.getBrithday())) {
            errors.put("txtBrithday", "* nhap Brithday");
        }
        if (student.getClassNumber().isEmpty()) {
            errors.put("txtClassNumber", "* nhap Class");
        }
        if (!vaildatePhone(student.getPhone())) {
            errors.put("txtPhone", "* nhap Phone");
        }
        return errors;
    }
}
