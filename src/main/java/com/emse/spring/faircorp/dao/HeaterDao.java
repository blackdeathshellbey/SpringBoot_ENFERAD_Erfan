package com.emse.spring.faircorp.dao;

import org.springframework.data.repository.Repository;
import com.emse.spring.faircorp.model.Heater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@org.springframework.stereotype.Repository
public interface HeaterDao extends JpaRepository<Heater, Long>, HeaterDaoCustom {

    Heater getHeaterById(Long id);
    @Query("select h from Heater h where h.name=:name")
    Heater findByName(@Param("name") String name);

}
