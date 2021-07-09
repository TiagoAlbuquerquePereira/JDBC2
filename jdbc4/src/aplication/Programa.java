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
			st = conn.prepareStatement("UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " + "(DepartmentId = ?)");

			st.setDouble(1, 200);
			st.setInt(2, 2);

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
