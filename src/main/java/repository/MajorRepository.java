package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DbConnection;
import model.MajorBean;

public class MajorRepository {
	public int insertMajor(MajorBean obj) {// why int cuz effected row return

		int i = 0;

		String sql = "insert into major(major_name, marks) values (?, ?)";

		try (Connection con = DbConnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, obj.getMajorName());
			ps.setInt(2, obj.getMarks());

			// run query
			i = ps.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Insert error." + e.getMessage());
		}

		return i;
	}

	public List<MajorBean> getAllMajor() {
		// to store unknown numbers of objects
		List<MajorBean> list = new ArrayList<MajorBean>();

		// write query
		String sql = "select * from major where delete_flag=1";

		try (
				// get connection
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				// return result set
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				System.out.println();

				MajorBean obj = new MajorBean();
				obj.setId(rs.getInt("id"));
				obj.setMajorName(rs.getString("major_name"));
				obj.setMarks(rs.getInt("marks"));

				list.add(obj);

			}
		} catch (SQLException e) {

			System.out.println("Select error: " + e.getMessage());
		}

		return list;

	}

	public MajorBean getbyMajorId(int majorId) {

		MajorBean majorObj = null;
		Connection con = DbConnection.getConnection();
		String sql = "select * from major where id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, majorId);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					majorObj = new MajorBean();
					majorObj.setId(rs.getInt("id"));
					majorObj.setMajorName(rs.getString("major_name"));
					majorObj.setMarks(rs.getInt("marks"));

				}
			}
		} catch (SQLException e) {

			System.out.println("getbyid error." + e.getMessage());

		}

		return majorObj;

	}

	public int updateMajor(MajorBean obj) {
		int i = 0;

		// write query
		String sql = "update major set major_name=? , marks=? where id=?";

		try (
				// get connection
				Connection con = DbConnection.getConnection();
				// declare this is query
				PreparedStatement ps = con.prepareStatement(sql)) {
			// input data

			ps.setString(1, obj.getMajorName());
			ps.setInt(2, obj.getMarks());
			ps.setInt(3, obj.getId());
			// run query
			i = ps.executeUpdate();
		} catch (SQLException e) {

			System.out.println("Update error: " + e.getMessage());
		}

		return i;
	}

	public int deleteMajor(int id) {
		int i = 0;

		// write query
		String sql = "update major set delete_flag=0 where id=?";

		try (
				// get connection
				Connection con = DbConnection.getConnection();
				// declare this is query
				PreparedStatement ps = con.prepareStatement(sql)) {
			// input data

			ps.setInt(1, id);

			// run query
			i = ps.executeUpdate();
		} catch (SQLException e) {

			System.out.println("Delete error: " + e.getMessage());
		}

		return i;
	}

}
