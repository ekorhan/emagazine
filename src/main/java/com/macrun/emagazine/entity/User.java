package com.macrun.emagazine.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity {
    @Column(name = "member_type")
    private int memberType;
    @Column(name = "email", length = 100, unique = true)
    private String email;
    @Column(name = "password", length = 32)
    private String password;
}
