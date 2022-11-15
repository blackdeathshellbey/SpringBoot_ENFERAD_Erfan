package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class BuildingDaoTest {
@Autowired
    private BuildingDao buildingDao;
    @Test
    public void shouldFindABuilding() {
        Building building = buildingDao.getOne(1L);
        Assertions.assertThat(building.getName()).isEqualTo("Ecole Des Mines");
    }
    @Test
    public void shouldFindABuildingWithCityInfo() {
        Building building = buildingDao.getOne(1L);
        Assertions.assertThat(building.getCity()).isEqualTo("Saint Etienne");
    }
    @Test
    public void shouldFailOnBuildingZipCode() {
        Building building = buildingDao.getOne(2L);
        Assertions.assertThat(building.getZip_code()).isEqualTo(79000);
    }
    @Test
    public void shouldFailOnFindingBuildingId() {
        Building building = buildingDao.getOne(10L);
        Assertions.assertThat(building.getId()).isEqualTo(85);
    }
}