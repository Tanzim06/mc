package com.bz.mc.model.security;


import com.bz.mc.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: SHI
 * Date: 2019-12-08
 * Time: 23:26
 */
//
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BG_ROLE")
public class Role extends BaseEntity {

    @Column(name = "ROLE")
    private String role;


}