/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbBaglantisi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class MariaDBCommand extends Command {

    @Override
    public ResultSet Read(Statement st, String query) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);

        } catch (SQLException ex) {
            Logger.getLogger(MariaDBCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    @Override
    public void Create(String query) {
    }

    @Override
    public void Update(String query) {
    }

    @Override
    public void Delete(String query) {
    }

}
