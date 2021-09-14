package az.nakhInternet.hr.dao;

import az.nakhInternet.hr.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getEmployeeList() throws Exception;
}
