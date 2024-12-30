package com.example.gestionhotel.repository;

import com.example.gestionhotel.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
