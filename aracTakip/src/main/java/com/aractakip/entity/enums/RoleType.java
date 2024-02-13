package com.aractakip.entity.enums;

public enum RoleType {
ADMİN("Admin"),
   DRIVER("Driver");

public final String name;

   public String getName() {
      return name;
   }

   RoleType(String name) {
      this.name = name;
   }
}
