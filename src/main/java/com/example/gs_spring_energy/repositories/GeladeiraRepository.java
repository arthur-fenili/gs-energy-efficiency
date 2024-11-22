package com.example.gs_spring_energy.repositories;

import com.example.gs_spring_energy.models.Geladeira;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeladeiraRepository extends JpaRepository<Geladeira, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL inserir_geladeira(:CAPACIDADE_FREEZER_LITROS, :CONSUMO_KWH, :QUANTIDADE_PORTAS, :TIPO_DISPLAY, :TEM_PORTA_LATAS, :VOLTAGEM, :MARCA, :MODELO, :EFICIENCIA_ENERGETICA, :COR, :PESO, :LINK_COMPRA)", nativeQuery = true)
    void inserirGeladeira(
            @Param("CAPACIDADE_FREEZER_LITROS") Double capacidadeFreezerLitros,
            @Param("CONSUMO_KWH") Double consumoKwh,
            @Param("QUANTIDADE_PORTAS") Integer quantidadePortas,
            @Param("TIPO_DISPLAY") String tipoDisplay,
            @Param("TEM_PORTA_LATAS") String temPortaLatas,
            @Param("VOLTAGEM") String voltagem,
            @Param("MARCA") String marca,
            @Param("MODELO") String modelo,
            @Param("EFICIENCIA_ENERGETICA") String eficienciaEnergetica,
            @Param("COR") String cor,
            @Param("PESO") Double peso,
            @Param("LINK_COMPRA") String linkCompra
    );
}
