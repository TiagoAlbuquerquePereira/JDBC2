package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getconnection();
			st = conn.prepareStatement("DELETE FROM department " + "WHERE " + "Id = ?");
			
			st.setInt(1, 5);

			int rowsAffected = st.executeUpdate();

			System.out.println("Done!   Linhas afetadas: " + "rowsAffected");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DB.closeStatment(st);
			DB.closeConnection();
		}

	}
}
