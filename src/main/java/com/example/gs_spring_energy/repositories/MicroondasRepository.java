package com.example.gs_spring_energy.repositories;

import com.example.gs_spring_energy.models.Microondas;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroondasRepository extends JpaRepository<Microondas, Long> {
    @Modifying
    @Transactional
    @Query(value = "CALL inserir_microondas(:DIAMETRO_PRATO, :FREQUENCIA, :POTENCIA_WATTS, :QUANTIDADE_PROGRAMAS, :TEM_DESCONGELAMENTO, :VOLTAGEM, :MARCA, :MODELO, :EFICIENCIA_ENERGETICA, :COR, :PESO, :LINK_COMPRA)", nativeQuery = true)
    void inserirMicroondas(
            @Param("DIAMETRO_PRATO") Double diametroPrato,
            @Param("FREQUENCIA") Integer frequencia,
            @Param("POTENCIA_WATTS") Integer potenciaWatts,
            @Param("QUANTIDADE_PROGRAMAS") Integer quantidadeProgramas,
            @Param("TEM_DESCONGELAMENTO") String temDescongelamento,
            @Param("VOLTAGEM") String voltagem,
            @Param("MARCA") String marca,
            @Param("MODELO") String modelo,
            @Param("EFICIENCIA_ENERGETICA") String eficienciaEnergetica,
            @Param("COR") String cor,
            @Param("PESO") Double peso,
            @Param("LINK_COMPRA") String linkCompra
    );
}
