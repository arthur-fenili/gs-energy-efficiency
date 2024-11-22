package com.example.gs_spring_energy.repositories;

import com.example.gs_spring_energy.models.Cafeteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeteiraRepository extends JpaRepository<Cafeteira, Long> {

    @Modifying
    @Query(value = "CALL inserir_cafeteira(:capacidadeAgua, :pressao, :capsulasCompativeis, :tecnologia, :voltagem, :marca, :modelo, :eficienciaEnergetica, :cor, :peso, :linkCompra)", nativeQuery = true)
    void inserirCafeteira(
            @Param("capacidadeAgua") Double capacidadeAgua,
            @Param("pressao") Double pressao,
            @Param("capsulasCompativeis") String capsulasCompativeis,
            @Param("tecnologia") String tecnologia,
            @Param("voltagem") String voltagem,
            @Param("marca") String marca,
            @Param("modelo") String modelo,
            @Param("eficienciaEnergetica") String eficienciaEnergetica,
            @Param("cor") String cor,
            @Param("peso") Double peso,
            @Param("linkCompra") String linkCompra
    );

}
