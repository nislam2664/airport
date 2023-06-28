package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.AirplaneType;
import com.laba.solvd.database.factory.ConnectionMethodFactory;
import com.laba.solvd.database.persistence.AirplaneTypeRepository;
import com.laba.solvd.database.persistence.impl.AirlineRepositoryImpl;
import com.laba.solvd.database.persistence.impl.AirplaneTypeRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirlineMapperImpl;
import com.laba.solvd.database.persistence.mapper.AirplaneTypeMapperImpl;
import com.laba.solvd.database.services.AirplaneTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.laba.solvd.database.Main.connectionFactory;

public class AirplaneTypeServiceImpl implements AirplaneTypeService {
    private static final Logger logger = LogManager.getLogger(AirplaneTypeServiceImpl.class.getName());
    private final AirplaneTypeRepository airplaneTypeRepository;

    public AirplaneTypeServiceImpl() {
        if (!connectionFactory.isMyBatis()) {
            this.airplaneTypeRepository = new AirplaneTypeRepositoryImpl();
            logger.info("Using JDBC AirplaneType repository");
        }
        else {
            this.airplaneTypeRepository = new AirplaneTypeMapperImpl();
            logger.info("Using MyBatis AirplaneType mapper");
        }
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
