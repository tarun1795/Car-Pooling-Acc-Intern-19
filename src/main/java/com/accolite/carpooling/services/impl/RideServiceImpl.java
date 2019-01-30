package com.accolite.carpooling.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.dto.RideDto;
import com.accolite.carpooling.services.interfaces.RideService;
@Service
public class RideServiceImpl implements RideService {

	@Autowired
	RideDao rideDao;
	public List<RideDto> getRides(String source, String destination) {
		return rideDao.getRides(source, destination);
	}

}
