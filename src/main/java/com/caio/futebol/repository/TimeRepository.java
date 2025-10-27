package com.caio.futebol.repository;

import com.caio.futebol.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
