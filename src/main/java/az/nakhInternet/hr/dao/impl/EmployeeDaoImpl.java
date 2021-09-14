package az.nakhInternet.hr.dao.impl;

import az.nakhInternet.hr.dao.DbHelper;
import az.nakhInternet.hr.dao.EmployeeDao;
import az.nakhInternet.hr.model.Employee;
import az.nakhInternet.hr.model.Organization;
import az.nakhInternet.hr.model.Position;
import az.nakhInternet.hr.model.Sector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> getEmployeeList() throws Exception {
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql = "select e.id,e.name,e.surname,e.father_name,org.org_name,s.sector_name,p.position_name from hr.employee e\n" +
                "inner join osp o on e.osp_id=o.id \n" +
                "inner join organization org on o.org_id=org.id\n" +
                "inner join position p on o.position_id=p.id\n" +
                "inner join sector s on o.sector_id=s.id\n" +
                "where e.active =1 ";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setFather_name(rs.getString("father_name"));
                Organization organization = new Organization();
                organization.setOrg_name(rs.getString("org_name"));
                employee.setOrganization(organization);
                Sector sector = new Sector();
                sector.setSector_name(rs.getString("sector_name"));
                employee.setSector(sector);
                Position position = new Position();
                position.setPosition_name(rs.getString("position_name"));
                employee.setPosition(position);
                employeeList.add(employee);
            }
            return employeeList;
        }

    }
}

