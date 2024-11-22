package com.example.gs_spring_energy.repositories;

import com.example.gs_spring_energy.models.Ventilador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VentiladorRepository extends JpaRepository<Ventilador, Long> {
    @Modifying
    @Transactional
    @Query(value = "CALL inserir_ventilador(:QUANTIDADE_PAS, :QUANTIDADE_VELOCIDADES, :TEM_INCLINACAO_REGULAVEL, :TIPO_VENTILADOR, :VOLTAGEM, :MARCA, :MODELO, :EFICIENCIA_ENERGETICA, :COR, :PESO, :LINK_COMPRA)", nativeQuery = true)
    void inserirVentilador(
            @Param("QUANTIDADE_PAS") Integer quantidadePas,
            @Param("QUANTIDADE_VELOCIDADES") Integer quantidadeVelocidades,
            @Param("TEM_INCLINACAO_REGULAVEL") String temInclinacaoRegulavel,
            @Param("TIPO_VENTILADOR") String tipoVentilador,
            @Param("VOLTAGEM") String voltagem,
            @Param("MARCA") String marca,
            @Param("MODELO") String modelo,
            @Param("EFICIENCIA_ENERGETICA") String eficienciaEnergetica,
            @Param("COR") String cor,
            @Param("PESO") Double peso,
            @Param("LINK_COMPRA") String linkCompra
    );
}
