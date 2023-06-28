package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.AirplaneType;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.AirplaneTypeRepository;
import com.laba.solvd.database.persistence.impl.AirplaneTypeRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirplaneTypeMapperImpl;
import com.laba.solvd.database.services.AirplaneTypeService;

import java.util.List;

public class AirplaneTypeServiceImpl implements AirplaneTypeService {
    private final AirplaneTypeRepository airplaneTypeRepository;

    public AirplaneTypeServiceImpl() {
        if (ConnectionMethodFactory.isPool())
            this.airplaneTypeRepository = new AirplaneTypeRepositoryImpl();
        else
            this.airplaneTypeRepository = new AirplaneTypeMapperImpl();
    }

    @Override
    public AirplaneType create(AirplaneType airplaneType) {
        airplaneType.setId(null);
        airplaneTypeRepository.create(airplaneType);
        return airplaneType;
    }

    @Override
    public List<AirplaneType> getAll() {
        return airplaneTypeRepository.getAll();
    }
}
