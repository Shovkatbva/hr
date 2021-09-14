package az.nakhInternet.hr.dao.impl;

import az.nakhInternet.hr.dao.DbHelper;
import az.nakhInternet.hr.dao.LoginDao;
import az.nakhInternet.hr.model.Login;
import az.nakhInternet.hr.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        String sql = "select l.id,r.role_name,l.username,l.password,l.name,l.surname from login l\n" +
                "inner join role r on r.id = l.role_id\n" +
                "where l.active =1 and l.username =?  and l.password =?";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login.setId(rs.getLong("ID"));
                Role role = new Role();
                role.setRole_name(rs.getString("ROLE_NAME"));
                login.setRole(role);
                login.setUsername(rs.getString("USERNAME"));
                login.setPassword(rs.getString("PASSWORD"));
                login.setName(rs.getString("NAME"));
                login.setSurname(rs.getString("SURNAME"));
            } else {
                login = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return login;
    }
}
