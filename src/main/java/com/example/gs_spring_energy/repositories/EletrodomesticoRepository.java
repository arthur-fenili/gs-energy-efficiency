package com.example.gs_spring_energy.repositories;

import com.example.gs_spring_energy.models.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {
}
