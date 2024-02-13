package com.aractakip.repository;
import com.aractakip.entity.UserRole;
import com.aractakip.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
