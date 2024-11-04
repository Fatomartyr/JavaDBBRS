package org.example.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    private Long userId;
    private Long roleId;
    private String roleName;

    public Role(Long userId, Long roleId, String roleName) {
        this.userId = userId;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role {userId = " + userId + ", roleId = " + roleId + ", roleName = " + roleName + "}";
    }
}
