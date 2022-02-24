package fr.eni.tpServlets.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class JdbcTools {

	public static Connection getConnection() throws SQLException {			
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			return dataSource.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SQLException("Properties probleme :" + e);
		}
	}
	
	public static void seDeconnecter(Connection cnx) throws UtilException {
        if (cnx != null)
            try {
                cnx.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new UtilException("Probl�me fermeture de Connection" + e);
            }
    }

    public static void seDeconnecter(Statement stmt, Connection cnx) throws UtilException {
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new UtilException("Probl�me fermeture de Statement" + e);
            }
        seDeconnecter(cnx);
    }

    public static void seDeconnecter(PreparedStatement pstmt, Connection cnx) throws UtilException {
        if (pstmt != null)
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new UtilException("Probl�me fermeture de PreparedStatement" + e);
            }
        seDeconnecter(cnx);
    }


}
