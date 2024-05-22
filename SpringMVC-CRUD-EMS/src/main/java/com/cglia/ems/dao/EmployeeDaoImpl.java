package com.cglia.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cglia.ems.dbutil.DatabaseConnection;
import com.cglia.ems.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Integer save(Employee employee) {
		final String query = "INSERT INTO emp (NAME, EMAIL, SALARY) values (?,?,?)";
		Integer id = 0;
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setInt(3, employee.getSalary());

			int count = ps.executeUpdate();
			if (count != 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getInt(1);
						System.out.println("Employee saved with id=" + id);
					}
				}
			} else {
				System.out.println("Failed to add employee!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Employee getById(Integer id) {
		final String query = "SELECT * FROM emp WHERE ID = ?";
		Employee employee = null;
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					employee = new Employee();
					employee.setId(rs.getInt("ID"));
					employee.setName(rs.getString("NAME"));
					employee.setEmail(rs.getString("EMAIL"));
					employee.setSalary(rs.getInt("SALARY"));
					//std.setDept(rs.getString("DEPARTMENT"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public int update(Employee employee) {
		final String query = "UPDATE emp SET NAME = ?,  EMAIL = ?, SALARY = ? WHERE ID = ?";
		int count = 0;
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setInt(3, employee.getSalary());
			stmt.setDouble(4, employee.getId());

			count = stmt.executeUpdate();
			if (count != 0) {
				System.out.println("Employee with ID:" + employee.getId() + " is updated");
			} else {
				System.out.println("Failed to update employee data!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteById(Integer id) {
		final String query = "DELETE FROM emp WHERE id=?";
		int count = 0;
		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setInt(1, id);
			count = stmt.executeUpdate();

			if (count != 0) {
				System.out.println("Employee with ID:" + id + " is deleted");
			} else {
				System.out.println("Failed to delete record!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Employee> getAll() {
		final String query = "SELECT * FROM emp";
		List<Employee> empList = new ArrayList<>();

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			boolean areAnyRecords = stmt.execute(query);
			if (areAnyRecords) {
				try (ResultSet rs = stmt.getResultSet()) {
					if (rs != null) {
						while (rs.next()) {
							Employee emp = new Employee();
							emp.setId(rs.getInt("ID"));
							emp.setName(rs.getString(2));
							emp.setEmail(rs.getString(3));
							//emp.setDept(rs.getString(4));
							emp.setSalary(rs.getInt(4));

							empList.add(emp);
						}
					}
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

}
