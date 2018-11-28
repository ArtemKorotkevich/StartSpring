package by.andersen.dao;

import by.andersen.model.Role;

import java.util.List;

public interface RoleDao {
    int save(Role role);
    Role getRole(int id);
    List<Role> list();
    void update(Role role);
    void delete (int id);
}
