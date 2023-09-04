package com.spring.reckathon.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.spring.reckathon.model.Company;
import com.spring.reckathon.model.Education;
import com.spring.reckathon.model.Internships;
import com.spring.reckathon.model.MyInterns;
import com.spring.reckathon.model.User;

@Repository
public class ExeQuery {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private DataSource dataSource;
	private Connection connection = null;

	ExeQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int addUser(String email, String name, String password, String phoneno) {
		try {
			return jdbcTemplate.update("INSERT INTO User VALUES (?, ?, ?, ?)", email, name, password, phoneno);
		} catch (Exception e) {

			return 0;
		}
	}

	public User getUser(String email) {
		String query = "select * from user where email = " + "'" + email + "'";
		try {
			return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
				@Override
				public User extractData(ResultSet rs) throws SQLException {
					User user = new User();
					rs.next();
					user.setEmail(rs.getString("email"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPhoneNo(rs.getString("phoneno"));
					return user;
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	public User getUserBasedOnName(String name) throws SQLException {
		String query = "select * from user where name = ?";
		User user = new User();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneno"));
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			return null;
		} finally {
			connection.close();
		}
		return user;
	}

	public int updatePassword(String password, String email) {
		String query = "UPDATE User SET password = ? where email = ?";
		return jdbcTemplate.update(query, password, email);
	}

	public int updateName(String name, String email) {
		String query = "UPDATE User SET name = ? where email = ?";

		return jdbcTemplate.update(query, name, email);
	}

	public int updatePhoneno(String phoneno, String email) {
		String query = "UPDATE User SET phoneno = ? where email = ?";

		return jdbcTemplate.update(query, phoneno, email);
	}

	public int addSchedule(int bus_id, Date date, int seat) {
		try {
			return jdbcTemplate.update("INSERT INTO Schedule (bus_id,date,seats) VALUES (?, ?, ?)", bus_id,
					date.toString(), seat);
		} catch (Exception e) {

			return 0;
		}
	}

	public int addBus(String name, String source, String destination, int price) {
		try {
			return jdbcTemplate.update("INSERT INTO Buses (name,source,destination,price) VALUES (?, ?, ?, ?)", name,
					source, destination, price);
		} catch (Exception e) {

			return 0;
		}
	}

	public List<User> getAllUser() {
		String query = "select * from user";
		List<User> userList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNo(rs.getString("phoneno"));
				userList.add(user);
			}

			return userList;
		} catch (Exception e) {
			return null;
		}
	}

	public String getName(String email) {
		String query = "SELECT destination FROM buses " + "WHERE Id = " + email;
		return jdbcTemplate.queryForObject(query, String.class);
	}

	public int addEducation(String email, String name, String password, String phoneno) {
		try {
			return jdbcTemplate.update("INSERT INTO Education VALUES (?, ?, ?, ?)", email, name, password, phoneno);
		} catch (Exception e) {

			return 0;
		}
	}

	public List<Education> getEducationList(String email) throws SQLException {
		List<Education> educationList = new ArrayList<>();
		String query = "SELECT * FROM education WHERE email = ?";

		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Education education = new Education();
				education.setCourseId(Integer.parseInt(rs.getString("courseid")));
				education.setDegree(rs.getString("degree"));
				education.setFieldOfStudy(rs.getString("field_of_study"));
				education.setInstitute(rs.getString("institute"));
				education.setStartDate(rs.getString("start_date"));
				education.setEndDate(rs.getString("end_date"));
				education.setPercentage(rs.getString("percentage"));

				educationList.add(education);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return educationList;
	}

	public void addEducation(String email, String degree, String fieldOfStudy, String institute, String startDate,
			String endDate, String percentage) {

		String sql = "INSERT INTO education (email, degree, field_of_study, institute, start_date, end_date, percentage) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {

			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			// Set the parameter values
			statement.setString(1, email);
			statement.setString(2, degree);
			statement.setString(3, fieldOfStudy);
			statement.setString(4, institute);
			statement.setString(5, startDate);
			statement.setString(6, endDate);
			statement.setString(7, percentage);

			// Execute the query
			statement.executeUpdate();

			// Close the statement and connection
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// Handle any exceptions
			e.printStackTrace();
		}
	}

	public void updatedegree(String degree, int courseid, String email) {
		String query = "UPDATE education SET degree = ? WHERE courseid = ? AND email = ?";
		jdbcTemplate.update(query, degree, courseid, email);
	}

	public void updateFieldOfStudy(String fieldOfStudy, int courseid, String email) {
		String query = "UPDATE education SET fieldOfStudy = ? WHERE courseid = ? AND email = ?";
		jdbcTemplate.update(query, fieldOfStudy, courseid, email);
	}

	public void updateInstitute(String institute, int courseid, String email) {
		String query = "UPDATE education SET institute = ? WHERE courseid = ? AND email = ?";
		jdbcTemplate.update(query, institute, courseid, email);
	}

	public void updateStartDate(String startDate, int courseid, String email) {
		String query = "UPDATE education SET start_date = ? WHERE courseid = ? AND email = ?";
		jdbcTemplate.update(query, startDate, courseid, email);
	}

	public void updateEndDate(String endDate, int courseid, String email) {
		String query = "UPDATE education SET end_date = ? WHERE courseid = ? AND email = ?";
		jdbcTemplate.update(query, endDate, courseid, email);
	}

	public void updatePercentage(String percentage, int courseid, String email) {
		String query = "UPDATE education SET percentage = ? WHERE courseid = ? AND email = ?";
		jdbcTemplate.update(query, percentage, courseid, email);
	}

	public List<Company> getAllCompanies() throws SQLException {
		String query = "select * from companies";
		List<Company> companies = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Company company = new Company();
				company.setCompanyID(rs.getString("company_id"));
				company.setCompanyName(rs.getString("company_name"));
				company.setWebsite(rs.getString("website"));
				company.setContactEmail(rs.getString("contact_email"));

				companies.add(company);
			}

			rs.close();
			stmt.close();

			return companies;
		} catch (Exception e) {
			return null;
		} finally {
			connection.close();
		}
	}

	public List<Internships> getInternshipsByLocation(String location) throws SQLException {
		String query = "select * from internships where location = ?";
		List<Internships> internships = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, location);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Internships internship = new Internships();
				internship.setCompanyID(rs.getString("company_id"));
				internship.setTitle(rs.getString("title"));
				internship.setDescription(rs.getString("description"));
				internship.setRequirements(rs.getString("requirements"));
				internship.setStipend(Integer.parseInt(rs.getString("stipend")));
				internship.setLocation(rs.getString("location"));

				internships.add(internship);
			}

			rs.close();
			stmt.close();

			return internships;
		} catch (Exception e) {
			return null;
		} finally {
			connection.close();
		}
	}

	public String getCompanyName(String companyID) {
		String query = "select company_name from companies where company_id = ?";
		String name = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, companyID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				name = rs.getString("company_name");
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	public String getCompanyID(String companyName) {
		String query = "select company_id from companies where company_name = ?";
		String id = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, companyName);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("company_id");
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public List<Internships> getInternshipsByCompany(String companyID) throws SQLException {
		String query = "SELECT * FROM internships WHERE company_id = ?";
		List<Internships> internships = new ArrayList<>();

		try (Connection connection = dataSource.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, companyID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Internships internship = new Internships();
				internship.setCompanyID(rs.getString("company_id"));
				internship.setTitle(rs.getString("title"));
				internship.setDescription(rs.getString("description"));
				internship.setRequirements(rs.getString("requirements"));
				internship.setStipend(Integer.parseInt(rs.getString("stipend")));
				internship.setLocation(rs.getString("location"));

				internships.add(internship);
			}
		} catch (SQLException e) {
			// Handle the exception appropriately, e.g., log the error or throw a custom
			// exception
			e.printStackTrace();
		}

		return internships;
	}

	public Internships getInternshipsByTitle(String title) throws SQLException {
		String query = "select * from internships where title = ?";
		Internships internship = new Internships();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, title);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				internship.setCompanyID(rs.getString("company_id"));
				internship.setTitle(rs.getString("title"));
				internship.setDescription(rs.getString("description"));
				internship.setRequirements(rs.getString("requirements"));
				internship.setStipend(Integer.parseInt(rs.getString("stipend")));
				internship.setLocation(rs.getString("location"));
			}

			rs.close();
			stmt.close();

			return internship;
		} catch (Exception e) {
			return null;
		} finally {
			connection.close();
		}
	}

	public void saveMyIntern(String email, String title) {
		String sql = "INSERT INTO my_interns (user_email, title) VALUES (?, ?)";

		jdbcTemplate.update(sql, email, title);
	}

	public List<MyInterns> getMyInternsByEmail(String email) throws SQLException {
		String query = "select * from my_interns where user_email = ?";
		List<MyInterns> myInternsList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MyInterns intern = new MyInterns();
				intern.setEmail(rs.getString("user_email"));
				intern.setTitle(rs.getString("title"));
				myInternsList.add(intern);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			return null;
		} finally {
			connection.close();
		}
		return myInternsList;
	}

	public void deleteIntern(String email, String title) {
		String sql = "DELETE FROM my_interns WHERE user_email = ? AND title = ?";

		jdbcTemplate.update(sql, email, title);
	}

	public void addMyIntern(String title, String email) throws SQLException {
		String query = "INSERT INTO my_interns (user_email, title) VALUES (?, ?)";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, email);
			statement.setString(2, title);
			statement.executeUpdate();

			System.out.println("MyIntern added successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public List<MyInterns> getAllInterns() throws SQLException {
		String query = "select * from my_interns";
		List<MyInterns> myInternsList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MyInterns intern = new MyInterns();
				intern.setEmail(rs.getString("user_email"));
				intern.setTitle(rs.getString("title"));
				myInternsList.add(intern);
			}

			rs.close();
			stmt.close();

		} catch (Exception e) {
			return null;
		} finally {
			connection.close();
		}
		return myInternsList;
	}

	public void addCompany(Map<String, String> companyData) {
		String companyId = companyData.get("companyid");
		String companyName = companyData.get("companyname");
		String website = companyData.get("website");
		String contactEmail = companyData.get("contactemail");

		String sql = "INSERT INTO companies (company_id, company_name, website, contact_email) "
				+ "VALUES (?, ?, ?, ?)";

		jdbcTemplate.update(sql, companyId, companyName, website, contactEmail);
	}
}
