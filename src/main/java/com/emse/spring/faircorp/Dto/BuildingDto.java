package com.emse.spring.faircorp.Dto;

import com.emse.spring.faircorp.model.Building;

public class BuildingDto {
    private Long id;
    private String name;
    private String city;
    private Integer zip_code;




    public BuildingDto() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.city = building.getCity();
        this.zip_code= building.getZip_code();

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip_code() {
        return zip_code;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
