package org.example.repository.interfaces;

import org.example.entities.Role;

import java.util.List;

public interface IRoleRepo {
    Role getRole(Long roleId);
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Long roleId);
    List<Role> getAllRoles();
}
