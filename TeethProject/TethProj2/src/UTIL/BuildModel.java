/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SamaherD
 */
public class BuildModel {
      public static DefaultTableModel buildTableModel(ResultSet rs, JTable table)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();
        //names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = table.getColumnCount();
        for (int column = 0; column < columnCount; column++) {
            columnNames.add(table.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
  
}
