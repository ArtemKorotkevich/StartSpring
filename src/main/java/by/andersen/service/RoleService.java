package by.andersen.service;

import by.andersen.model.Role;

import java.util.List;

public interface RoleService {

    int save (Role role);
    Role getRole(int id);
    List<Role> list();
    void update(Role role);
    void delete(int id);
}
