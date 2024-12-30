package com.example.gestionhotel.repository;

import com.example.gestionhotel.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
