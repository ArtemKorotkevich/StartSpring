package by.andersen.service;

import by.andersen.dao.RoleDao;
import by.andersen.model.Dictionary;
import by.andersen.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Transactional
    public int save(Role role) {
        return roleDao.save(role);
    }

    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    public List<Role> list() {
        return roleDao.list();
    }
    @Transactional
    public void update(Role role) {
        roleDao.update(role);
    }
    @Transactional
    public void delete(int id) {
        roleDao.delete(id);
    }
}