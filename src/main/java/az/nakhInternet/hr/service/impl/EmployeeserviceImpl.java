package az.nakhInternet.hr.service.impl;

import az.nakhInternet.hr.dao.EmployeeDao;
import az.nakhInternet.hr.model.Employee;
import az.nakhInternet.hr.service.EmployeeService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EmployeeserviceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }
}
