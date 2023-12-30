package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database.JDBCUtil;
import model.Province;
import model.Student;

public class StudentManagerDao implements DAOInterface<Student> {

	private static final String INSERT_STUDENT_SQL = "INSERT INTO Student (Id, Name, Place, DateOfBirth, sex, subject1, subject2, subject3, average) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_STUDENTS = "SELECT * FROM Student";

	public static StudentManagerDao getInstance() {
		return new StudentManagerDao();
	}

	@Override
	public int insert(Student t) {
		int result = 0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

			preparedStatement.setInt(1, t.getStudentId());
			preparedStatement.setString(2, t.getStudentName());
			preparedStatement.setString(3, t.getBirthPlace().getProvinceName());
			// Directly use the java.util.Date to create java.sql.Date
			java.sql.Date sqlDateOfBirth = new java.sql.Date(t.getDateOfBirth().getTime());
			preparedStatement.setDate(4, sqlDateOfBirth);

			preparedStatement.setInt(5, t.isSex() ? 1 : 0);
			preparedStatement.setFloat(6, t.getSubject1());
			preparedStatement.setFloat(7, t.getSubject2());
			preparedStatement.setFloat(8, t.getSubject3());
			preparedStatement.setDouble(9, t.getAvgMark());

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Student t) {
		int result = 0;
		String sql = "UPDATE Student SET Name = ?, Place = ?, DateOfBirth = ?, sex = ?, subject1 = ?, subject2 = ?, subject3 = ? WHERE Id = ?";

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, t.getStudentName());
			preparedStatement.setString(2, t.getBirthPlace().getProvinceName());
			java.sql.Date sqlDateOfBirth = new java.sql.Date(t.getDateOfBirth().getTime());
			preparedStatement.setDate(3, sqlDateOfBirth);
			preparedStatement.setInt(4, t.isSex() ? 1 : 0);
			preparedStatement.setFloat(5, t.getSubject1());
			preparedStatement.setFloat(6, t.getSubject2());
			preparedStatement.setFloat(7, t.getSubject3());
			preparedStatement.setInt(8, t.getStudentId());

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Student t) {
		int rowsAffected = 0;
		String sql = "DELETE FROM Student WHERE Id = ?";

		try (Connection con = JDBCUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, t.getStudentId());

			rowsAffected = pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public ArrayList<Student> selectAll() {
		ArrayList<Student> students = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("Name");
				String place = rs.getString("Place");
				Date dateOfBirth = rs.getDate("DateOfBirth");
				boolean isSex = rs.getInt("sex") == 1;
				float subject1 = rs.getFloat("subject1");
				float subject2 = rs.getFloat("subject2");
				float subject3 = rs.getFloat("subject3");
				Province birthPlace = new Province(place);

				Student student = new Student(id, name, birthPlace, dateOfBirth, isSex, subject1, subject2, subject3);
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student selectById(Student t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAll() {
		int rowsAffected = 0;
		String sql = "DELETE FROM Student";

		try (Connection con = JDBCUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			rowsAffected = pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
