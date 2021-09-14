package az.nakhInternet.hr.service;

import az.nakhInternet.hr.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoleList() throws Exception;

    public void addRole(Role role) throws Exception;

    public Role getRoleById(Long roleId) throws Exception;

    public void updateRole(Role role) throws Exception;

    public void deleteRole(Long roleId) throws Exception;

    public List<Role> searchRoleData(String keyword) throws Exception;
}
