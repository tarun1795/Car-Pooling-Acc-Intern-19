package com.accolite.carpooling.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.dto.RideDto;
import com.accolite.carpooling.rowmappers.RideDtoMapper;
@Repository
public class RideDaoImpl implements RideDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<RideDto> getRides(String source, String destination) {
		return jdbcTemplate.query(Query.SQL_SELECT_RIDE_JOIN_USER_JOIN_VEHICLE,new Object[] {},new RideDtoMapper());
	}

}
