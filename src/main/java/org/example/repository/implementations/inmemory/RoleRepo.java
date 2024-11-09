package org.example.repository.implementations.inmemory;

import org.example.entities.Role;
import org.example.repository.interfaces.IRoleRepo;

import java.util.List;

public class RoleRepo implements IRoleRepo {
    private List<Role> roles;
    public RoleRepo(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Role getRole(Long roleId) {
        for (Role role : roles) {
            if (role.getRoleId().equals(roleId)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public void updateRole(Role role) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getRoleId().equals(role.getRoleId())) {
                roles.set(i, role);
            }
        }
    }

    @Override
    public void deleteRole(Long roleId) {
        roles.removeIf(role -> role.getRoleId().equals(roleId));
    }

    @Override
    public List<Role> getAllRoles() {
        return roles;
    }
}
