package com.accolite.carpooling.services.interfaces;

import java.util.List;

import com.accolite.carpooling.dto.RideDto;

public interface RideService {

	public List<RideDto> getRides(String source,String destination);
}
