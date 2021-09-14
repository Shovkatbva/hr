package az.nakhInternet.hr.service;

import az.nakhInternet.hr.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList() throws Exception;
}
