package com.aractakip.entity;

import com.aractakip.entity.enums.RoleType;
import lombok.*;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRole {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private String id;

   @Enumerated(EnumType.STRING)
   @Column(length = 20)
   private RoleType roleType;

   private String rolename;
}
