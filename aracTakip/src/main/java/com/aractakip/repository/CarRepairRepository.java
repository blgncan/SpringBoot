package com.aractakip.repository;
import com.aractakip.entity.CarRepair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CarRepairRepository extends JpaRepository<CarRepair,Long> {
}