package com.emse.spring.faircorp.Dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

public class RoomDto {

    private Integer floor;
    private Building building;

    private Long id;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;



    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.floor = room.getFloor();
        this.building = room.getBuilding();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Integer getFloor() {
        return floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }



}
