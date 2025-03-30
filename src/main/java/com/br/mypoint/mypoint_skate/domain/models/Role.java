package com.br.mypoint.mypoint_skate.domain.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {
    

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "role_id")
    private Integer  id;


    @Column(nullable = false, length = 50, unique=true)
    private String role;


    public enum RoleEnum {
        ROLE_USER(1),
        ROLE_ADMIN(2),
        ROLE_POINT_MAKER(3);

        private final int roleId;

        RoleEnum(int roleId) {
            this.roleId = roleId;
        }

        public int getRoleId() {
            return roleId;
        }

    }
}
