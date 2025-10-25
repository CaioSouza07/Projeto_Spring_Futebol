package com.caio.futebol.repository;

import com.caio.futebol.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeRepository extends JpaRepository<Time, Long> {
    @Query(value = "select distinct liga from time order by TRANSLATE(liga, 'ÁÉÍÓÚÂÊÎÔÛÃÕÀÈÌÒÙÇáéíóúâêîôûãõàèìòùç', 'AEIOUAEIOUAEOUCaeiouaeiouaoaeiouc')", nativeQuery = true)
    List<String> findAllLigas();

    List<Time> findAllByLigaOrderByNome(String liga);
}
