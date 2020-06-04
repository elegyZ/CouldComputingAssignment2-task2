package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil 
{
	static final String jdbcUrl = "jdbc:mysql://database1.crmee8qdomfc.us-east-2.rds.amazonaws.com/data_base?useSSL=false";
	static final String jdbcUsername = "root";
	static final String jdbcPassword = "1998sophie";
	
	static public List<Wolf> getWolfList(String question)
	{
		List<Wolf> wolf_list = new ArrayList<>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM QA WHERE question = ?");
				ps.setString(1, question);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) 
				{
					wolf_list.add(extractRow(rs));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return wolf_list;
	}
	
	static public void insertWolf(Wolf wolf)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
				PreparedStatement ps = conn.prepareStatement("INSERT INTO QA (question, answer) VALUES (?, ?)");
				ps.setString(1, wolf.getQuestion());
				ps.setString(2, wolf.getAnswer());
				int n = ps.executeUpdate();		
				if (n == 1) 
				{
					System.out.println("Insert one record");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (ClassNotFoundException e1) {
				e1.printStackTrace();
		}
	}

	static public Wolf extractRow(ResultSet rs) throws SQLException 
	{
		Wolf wolf = new Wolf();
		wolf.setQuestion(rs.getString("question"));
		wolf.setAnswer(rs.getString("answer"));
		return wolf;
	}
}
