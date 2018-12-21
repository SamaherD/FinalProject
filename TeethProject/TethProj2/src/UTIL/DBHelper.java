package UTIL;

import java.awt.Color;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author SamaherD
 */
public class DBHelper {

    private static String ADMIN_ID;

    //Connect to database
    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            return conn;
        } catch (ClassNotFoundException ex) {
            System.err.println("Class Not Found");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;

    }

    //check credentials login users ( as admin or secretary ) 
    public static HashMap Login(String name, String pass) {
        HashMap result = new HashMap();

        Connection connection = connectDB();
        String sql = null;
        PreparedStatement login_credentials;
        ResultSet rs;
        result.put("success", false);
        result.put("type", 0);

        try {
            sql = "select name ,password ,type from users where name =? and password=?;";

            /*following statements to supply the two question mark placeholders in the PreparedStatement :
    1 to specify the first placeholder(name),2 to specify the second placeholder(pasword)*/
            login_credentials = connection.prepareStatement(sql);
            login_credentials.setString(1, name);
            login_credentials.setString(2, pass);
            rs = login_credentials.executeQuery();
            if (rs.next()) {
                result.put("success", true);
                result.put("type", rs.getInt("type"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "ERROE CLOSE !");
            }
        }
        return result;
    }

    // This function called in 'Add Admin',"Add Secretary" classes to verify that new user ( admin or secretary ) name doesn't exist before 
    public static boolean isValidUserName(String name) {

        Boolean result = true;
        Connection connection = connectDB();
        String sql = null;
        PreparedStatement valid_name;
        ResultSet rs;

        try {
            sql = "select name from users where name=?;";
            valid_name = connection.prepareStatement(sql);
            valid_name.setString(1, name);

            rs = valid_name.executeQuery();
            if (rs.next()) {
                result = false; // name is not valid (Exists in data base)
            }

            valid_name.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return result;

    }

    // To add Users (admin or secretary )
    public static Boolean addUser(int type, String name, String password) {

        Connection connection = connectDB();
        String sql;
        PreparedStatement new_user;
        int rs;
        Boolean result = false;

        try {
            sql = "insert into users (name, password,type) values(?,?,?);";
            new_user = connection.prepareStatement(sql);
            new_user.setString(1, name);
            new_user.setString(2, password);
            new_user.setInt(3, type);
            rs = new_user.executeUpdate();
            if (rs != 0) {
                result = true;
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "ERROE CLOSE !");
            }

        }

        return result;
    }

// Add new patient and return his id 
    public static int addPatients(String patientName, String address, String phone,
            int total_amount, int total_paid, String addedBy) throws SQLException {

        Connection connection = connectDB();
        String sql;
        PreparedStatement new_patient;
        ResultSet rs;
        int result = 0;

        try {
            sql = "insert into patients(patient_name, address, phone, total_amount, total_paid, added_by) Values(?,?,?,?,?,?);";
            new_patient = connection.prepareStatement(sql);
            new_patient.setString(1, patientName);
            new_patient.setString(2, address);
            new_patient.setString(3, phone);
            new_patient.setInt(4, total_amount);
            new_patient.setInt(5, total_paid);
            new_patient.setString(6, addedBy);
            new_patient.executeUpdate();

            sql = "Select patient_id from patients where phone=?;";
            new_patient = connection.prepareStatement(sql);
            new_patient.setString(1, phone);
            rs = new_patient.executeQuery();
            rs.next();
            result = rs.getInt("patient_id");

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            connection.close();
        }

        return result;

    }

    // To return all patient names 
    public static ArrayList<Object> getPatientsNames() {
        ArrayList<Object> arr_patient_names = new ArrayList<>();
        Connection conn = connectDB();

        try {
            PreparedStatement patients = conn.prepareStatement("SELECT patient_name FROM patients ;");
            ResultSet rs = patients.executeQuery();
            while (rs.next()) {
                String name = rs.getString("patient_name");
                arr_patient_names.add((Object) name);

            }
            conn.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.print("Error while bringing patients names" + ex.toString());

        }

        return arr_patient_names;
    }

    // To return all patient phones     
    public static ArrayList<Object> getPatientsPhones() {
        ArrayList<Object> arr_patients_phones = new ArrayList<>();
        Connection conn = connectDB();

        try {
            PreparedStatement phones = conn.prepareStatement("SELECT phone FROM patients;");
            ResultSet rs1 = phones.executeQuery();
            while (rs1.next()) {
                String phone = rs1.getString("phone");
                arr_patients_phones.add((Object) phone);

            }
            conn.close();
            rs1.close();
        } catch (SQLException ex) {
            System.out.print("Error while bringing patients names" + ex.toString());

        }

        return arr_patients_phones;
    }
    // To check if password logged by admin and secretary is correct 

    public static Boolean checkPassword(String username, String password) {
        Connection connection = connectDB();
        String sql = null;
        PreparedStatement correct_pass;
        ResultSet rs;
        Boolean is_correct_pass = false;

        try {
            sql = "select password from users where name=?;";
            correct_pass = connection.prepareStatement(sql);
            correct_pass.setString(1, username);
            rs = correct_pass.executeQuery();
            if (rs.next() && password.equals(rs.getString("password"))) {
                is_correct_pass = true;
            }
            correct_pass.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return is_correct_pass;
    }

    // To change password 
    public static Boolean changePassword(String userName, String newPassword) {
        Connection connection = connectDB();
        String sql = null;
        PreparedStatement update_pass;
        ResultSet rs;
        Boolean result = false;

        try {
            sql = "update users set password=? where name=?;";
            update_pass = connection.prepareStatement(sql);
            update_pass.setString(1, newPassword);
            update_pass.setString(2, userName);
            update_pass.executeUpdate();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {
                // errlbl.setText("");
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "ERROE CLOSE !");
            }

        }

        return result;
    }

    public static int getPatientId(int findBy, String string) {
        int id = 0;
        Connection conn = connectDB();
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            if (findBy == 1) {
                ps = conn.prepareStatement("SELECT patient_id FROM patients where patient_name = '" + string + "';");
            } else if (findBy == 2) {
                ps = conn.prepareStatement("SELECT patient_id FROM patients where phone = '" + string + "';");
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("patient_id");
            }

            rs.close();
            conn.close();
        } catch (SQLException ex) {
        }
        return id;
    }

    // To add  patient vist information 
    public static Boolean addVisit(java.sql.Date date, int patientID, String medicen, String comments, int amount, int paid, String teeth) {
        Connection conn = connectDB();
        Boolean result = false;
        String sql = "INSERT INTO `doctor`.`visits` ( `date`, `pacient_id`, `medicen`, `comments`, `amount`, `paid`, `teeth`) VALUES ('" + date + "',  '" + patientID + "' , '" + medicen + "', '" + comments + "', '" + amount + "' , '" + paid + "' , '" + teeth + "');";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            result = true;

        } catch (SQLException ex) {
            System.out.printf("Error while  adding new visit" + ex.toString());
        }
        return result;
    }

// to get patient phone from his name 
    public static String getPatiantPhone(String name) {
        String result = null;
        String sql = "SELECT phone FROM patients where patient_name='" + name + "'";
        Connection conn = connectDB();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getString("phone");
        } catch (SQLException ex) {

        }
        return result;
    }

    // to get patient name from his phone 
    public static String getPatiantName(String phone) {
        String result = null;
        String sql = "SELECT patient_name FROM patients where phone='" + phone + "'";
        Connection conn = connectDB();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getString("patient_name");
        } catch (SQLException ex) {

        }
        return result;
    }

    // get patient information by phone number or name (phone =2 ,name =1)
    public static HashMap getPatientInformation(int searchBy , String string) {
        HashMap result = new HashMap();
        String sql_1=null ,sql_2 =null, sql_3 =null;
        result.put("Foreground", Color.red);
        result.put("msg", "No Data found !");
        result.put("id", "");
        result.put("name", "");
        result.put("phone", "");
        result.put("address", "");
        result.put("totalAmount", "");
        result.put("paidAmount", "");
        result.put("remaind", "");
        result.put("haseTableData", false);
        result.put("tableData", "");
        try {
            Connection conn = connectDB();
            if (searchBy == 1) {
                
                sql_1 = "SELECT * FROM patients WHERE patient_name =?";
                sql_2 = "SELECT visit_id,date,medicen,comments,amount,paid,amount-paid FROM visits WHERE pacient_id =(select patient_id from patients where patient_name=?)";
                sql_3 = "select sum(amount) ,sum(paid),sum(amount-paid) from visits WHERE pacient_id =(SELECT patient_id from patients where patient_name = ?)";
           
            } else if (searchBy == 2) {
                
                sql_1 = "SELECT * FROM patients WHERE phone =?";
                sql_2 = "SELECT visit_id,date,medicen,comments,amount,paid,amount-paid FROM visits WHERE pacient_id =(select patient_id from patients where phone=?)";
                sql_3 = "select sum(amount) ,sum(paid),sum(amount-paid) from visits WHERE pacient_id =(SELECT patient_id from patients where phone = ?)";
           
            }
            PreparedStatement ps_1 = conn.prepareStatement(sql_1);
            PreparedStatement ps_2 = conn.prepareStatement(sql_2);
            PreparedStatement ps_3 = conn.prepareStatement(sql_3);

            ps_1.setString(1, string);
            ps_2.setString(1, string);
            ps_3.setString(1, string);
            
            ResultSet rs_1 = ps_1.executeQuery();
            ResultSet rs_2 = ps_2.executeQuery();
            ResultSet rs_3 = ps_3.executeQuery();


            if (rs_1.next()) {
                
                result.put("success", false);
                result.put("Foreground", Color.BLACK);
                result.put("msg", "Done !");
                result.put("searchId", rs_1.getString("patient_id"));
                result.put("searchName", rs_1.getString("patient_name"));
                result.put("searchPhone", rs_1.getString("phone"));
                result.put("address", rs_1.getString("address"));

                if (rs_2.next()) {
                    rs_2.previous();
                    result.put("haseTableData", true);
                    result.put("tableData", rs_2);
                }
                 if (rs_3.next()) {
                    result.put("totalAmount", rs_3.getInt(1) + "");
                    result.put("paidAmount", rs_3.getInt(2) + "");
                    result.put("remaind", rs_3.getInt(3) + "");
                }
            }
        } catch (SQLException ex) {

        }
        return result;
    }
}
