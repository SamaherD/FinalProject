/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import UTIL.AESCrypt;
import UTIL.DBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import tethproj.Login;

/**
 *
 * @author SamaherD
 */
public class DBHelperTest extends TestCase {

    @Test
    public void testConnection() throws Exception {
        DBHelper.connectDB();
    }

    @Test
    public void testLogin() throws Exception {
        HashMap result = DBHelper.Login("safaa", AESCrypt.encrypt("1234"));
        assertEquals(true, result.get("success"));
    }

    @Test
    public void testIsValidUserName() {
        Object result = DBHelper.isValidUserName("karam");
        assertEquals(false, result);
    }

    @Test
    public void testAddUser() {
        Object result = DBHelper.addUser(1, "alla", "123");
        assertEquals(false, result);
    }

    @Test
    public void testAddPatients() throws SQLException {
        int id = DBHelper.addPatients("testName", "testAddress", "123", 300, 100, "safaa");
        Object result = id != 0 ? true : false;
        assertEquals(true, result);
    }
    
    @Test
    public void testGetPatientsNames() {
        ArrayList<Object> result = DBHelper.getPatientsNames();
        assertEquals(true, result.size() != 0 ? true : false);

    }
    
    @Test
    public void testGetPatientsPhones() {
        ArrayList<Object> result = DBHelper.getPatientsPhones();
        assertEquals(true, result.size() != 0 ? true : false);

    }
    
    @Test
    public void testCheckPassword() throws Exception {
        Object result = DBHelper.checkPassword("safaa", AESCrypt.encrypt("1234"));
        assertEquals(true, result);
    }

    @Test
    public void testChangePassword() throws Exception {
        Object result = DBHelper.changePassword("test", AESCrypt.encrypt("123"));
        assertEquals(false, result);
    }
    @Test
    public void testGetPatientId() {
        int result = DBHelper.getPatientId(1, "test");
        assertEquals(true, result != 0 ? true : false);
    }
    
     // @Test
 //   public void testAddVisit() {
   //     int result = DBHelper.addVisit(new Date(), 0, "tst", "test", 0, 0, teeth);
     //   assertEquals(true, result != 0 ? true : false);
   // 
    
     @Test
    public void testGetPatientName() {
        String result = DBHelper.getPatiantName("059");
        assertEquals("rahaf", result);
    }
    
     @Test
    public void testGetPatientPhone() {
        String result = DBHelper.getPatiantPhone("rahaf");
        assertEquals("059", result);

    }
    
    @Test
    public void testGetPatientDetials() {
        HashMap result = DBHelper.getPatientInformation(1,"rahaf");
        assertEquals(true, result.get("haseTableData"));

    }
    
}
