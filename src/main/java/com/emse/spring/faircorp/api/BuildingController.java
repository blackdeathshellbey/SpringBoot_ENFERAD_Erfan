package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.Dto.BuildingDto;
import com.emse.spring.faircorp.Dto.RoomDto;
import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Building;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin

@RestController

@RequestMapping("/api/buildings")

@Transactional

public class BuildingController {
    private final BuildingDao buildingDao;

    private final HeaterDao heaterDao;

    private final WindowDao windowDao;

    private final RoomDao roomDao;


    public BuildingController(RoomDao roomDao, HeaterDao heaterDao, WindowDao windowDao, BuildingDao buildingDao) {

        this.windowDao = windowDao;
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {

        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());

    }

    @GetMapping(path = "/{building_id}")

    public BuildingDto findById(@PathVariable Long building_id) {

        return buildingDao.findById(building_id).map(BuildingDto::new).orElse(null); // (7)

    }

    @DeleteMapping(path = "/{building_id}")
    public void delete(@PathVariable Long building_id) {

        List<RoomDto> listRoomDto = roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());

        for (RoomDto dto : listRoomDto) {
            if (dto.getBuilding().getId().equals(building_id)) {
                heaterDao.deleteHeaters(dto.getId());
                windowDao.deleteWindows(dto.getId());
                roomDao.deleteById(dto.getId());
            }
        }
        buildingDao.deleteById(building_id);
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName()));
        } else {     //building = buildingDao.getBuildingById(dto.getId());

            building = buildingDao.getOne(dto.getId());
            building.setName(dto.getName());
        }
        return new BuildingDto(building);
    }


}
