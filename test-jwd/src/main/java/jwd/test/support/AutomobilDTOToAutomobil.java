package jwd.test.support;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Automobil;
import jwd.test.service.AutomobilService;
import jwd.test.service.KompanijaService;
import jwd.test.web.dto.AutomobilDTO;

@Component
public class AutomobilDTOToAutomobil implements Converter<AutomobilDTO, Automobil> {

	@Autowired
	private AutomobilService automobilService;
	@Autowired
	private KompanijaService kompanijaService;
	
	
	@Override
	public Automobil convert(AutomobilDTO dto) {
		Automobil automobil;
		if(dto.getId()==null){
			automobil = new Automobil();
			automobil.setKompanija(
					kompanijaService.findOne(
							dto.getKompanijaId()));
		}else{
			automobil = automobilService.findOne(dto.getId());
		}
		
		
		automobil.setModel(dto.getModel());
		automobil.setRegistracija(dto.getRegistracija());
		automobil.setGodiste(dto.getGodiste());
		automobil.setPotrosnja(dto.getPotrosnja());
		automobil.setIznajmljen(dto.getIznajmljen());
		
		return automobil;
	}
	
	
	
}
