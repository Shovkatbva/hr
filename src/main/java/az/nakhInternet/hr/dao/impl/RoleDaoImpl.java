package az.nakhInternet.hr.dao.impl;

import az.nakhInternet.hr.dao.DbHelper;
import az.nakhInternet.hr.dao.RoleDao;
import az.nakhInternet.hr.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    public List<Role> getRoleList() throws Exception {
        List<Role> roleList = new ArrayList<Role>();
        String sql = "select id,role_name,description from role where active = 1";
        try (Connection con = DbHelper.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong("ID"));
                role.setRole_name(rs.getString("ROLE"));
                role.setDescription(rs.getString("DESCRIPTION"));
                roleList.add(role);
            }
        }
        return roleList;
    }

    @Override
    public void addRole(Role role) throws Exception {
        String sql = "insert into role (role_name,description) values(?,?)";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, role.getRole_name());
            ps.setString(2, role.getDescription());
            ps.executeQuery();
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Role getRoleById(Long roleId) throws Exception {
        Role role = new Role();
        String sql = "select id,role_name,description from role where active = 1 and id=?";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setLong(1, roleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role.setId(rs.getLong("ID"));
                role.setRole_name(rs.getString("ROLE"));
                role.setDescription(rs.getString("DESCRIPTION"));
            } else {
                role = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return role;
    }

    @Override
    public void updateRole(Role role) throws Exception {
        String sql = "update role set role_name =? ,description =? where id =?";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, role.getRole_name());
            ps.setString(2, role.getDescription());
            ps.setLong(3, role.getId());
            ps.execute();
            con.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteRole(Long roleId) throws Exception {
        String sql = "update role set active =0  where id=?";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, roleId);
            ps.execute();
            con.commit();
        }
    }

    @Override
    public List<Role> searchRoleData(String keyword) throws Exception {
        List<Role> roleList = new ArrayList<Role>();
        String sql = "select id,role_name,description from role "
                + " where active = 1 and (lower (role_name) like lower(?) or lower(description) like lower(?))";
        try (Connection con = DbHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setR(rs.getLong("r"));
                role.setId(rs.getLong("ID"));
                role.setRole_name(rs.getString("ROLE"));
                role.setDescription(rs.getString("DESCRIPTION"));
                roleList.add(role);
            }
            return roleList;
        }
    }
}
