package az.nakhInternet.hr.service.impl;

import az.nakhInternet.hr.dao.RoleDao;
import az.nakhInternet.hr.model.Role;
import az.nakhInternet.hr.service.RoleService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Override
    public List<Role> getRoleList() throws Exception {
        return roleDao.getRoleList();
    }

    @Override
    public void addRole(Role role) throws Exception {
        roleDao.addRole(role);
    }

    @Override
    public Role getRoleById(Long roleId) throws Exception {
        return roleDao.getRoleById(roleId);
    }

    @Override
    public void updateRole(Role role) throws Exception {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Long roleId) throws Exception {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Role> searchRoleData(String keyword) throws Exception {
        return roleDao.searchRoleData(keyword);
    }
}
