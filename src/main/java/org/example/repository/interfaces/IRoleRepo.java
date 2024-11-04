package org.example.repository.interfaces;

import org.example.entities.Role;

public interface IRoleRepo {
    Role getRole(Long roleId);
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Long roleId);
}
