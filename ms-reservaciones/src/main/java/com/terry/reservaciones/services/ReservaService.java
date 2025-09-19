package com.terry.reservaciones.services;

import com.terry.commons.dto.ReservaRequest;
import com.terry.commons.dto.ReservaResponse;
import com.terry.commons.services.CommonService;

public interface ReservaService extends CommonService<ReservaRequest, ReservaResponse>{
	boolean habitacionIsPresent(Long id);
	boolean huespedIsPresent(Long id);
	
}
