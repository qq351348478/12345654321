package com.yjh.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    Long id;
    String roleCode;
    String roleName;
    String roleDesn;
}
