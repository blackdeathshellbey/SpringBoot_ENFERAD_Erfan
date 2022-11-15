package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Window> findWindowInBuilding(Long id) {

        String jpql = "select w from Window w where w.room.id = :id";

        return entityManager.createQuery(jpql, Window.class)

                .setParameter("id", id)

                .getResultList();
    }

}
