package com.example.gs_spring_energy.repositories;

import com.example.gs_spring_energy.models.Lavadora;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LavadoraRepository extends JpaRepository<Lavadora, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL inserir_lavadora(:CAPACIDADE_KG, :CONSUMO_AGUA, :VELOCIDADE_CENTRIFUGACAO_RPM, :SISTEMA_LAVAGEM, :TEM_AGUA_QUENTE, :VOLTAGEM, :MARCA, :MODELO, :EFICIENCIA_ENERGETICA, :COR, :PESO, :LINK_COMPRA)", nativeQuery = true)
    void inserirLavadora(
            @Param("CAPACIDADE_KG") Double capacidadeKg,
            @Param("CONSUMO_AGUA") Double consumoAgua,
            @Param("VELOCIDADE_CENTRIFUGACAO_RPM") Integer velocidadeCentrifugacaoRpm,
            @Param("SISTEMA_LAVAGEM") String sistemaLavagem,
            @Param("TEM_AGUA_QUENTE") String temAguaQuente,
            @Param("VOLTAGEM") String voltagem,
            @Param("MARCA") String marca,
            @Param("MODELO") String modelo,
            @Param("EFICIENCIA_ENERGETICA") String eficienciaEnergetica,
            @Param("COR") String cor,
            @Param("PESO") Double peso,
            @Param("LINK_COMPRA") String linkCompra
    );
}
