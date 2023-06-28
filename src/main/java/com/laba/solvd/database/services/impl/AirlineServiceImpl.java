package com.laba.solvd.database.services.impl;

import com.laba.solvd.database.domain.Airline;
import com.laba.solvd.database.persistence.AirlineRepository;
import com.laba.solvd.database.persistence.impl.AirlineRepositoryImpl;
import com.laba.solvd.database.persistence.mapper.AirlineMapperImpl;
import com.laba.solvd.database.services.AirlineService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.laba.solvd.database.Main.connectionFactory;

public class AirlineServiceImpl implements AirlineService {
    private static final Logger logger = LogManager.getLogger(AirlineServiceImpl.class.getName());
    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl() {
        if (!connectionFactory.isMyBatis()) {
            this.airlineRepository = new AirlineRepositoryImpl();
            logger.info("Using JDBC Airline repository");
        }
        else {
            this.airlineRepository = new AirlineMapperImpl();
            logger.info("Using MyBatis Airline mapper");
        }
    }

    @Override
    public Airline create(Airline airline) {
        airline.setId(null);
        airlineRepository.create(airline);
        return airline;
    }

    @Override
    public List<Airline> getAll() {
        return airlineRepository.getAll();
    }
}
