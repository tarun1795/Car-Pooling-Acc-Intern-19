package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.dto.RideDto;

public interface RideDao {
	public List<RideDto> getRides(String source,String destination);
}
