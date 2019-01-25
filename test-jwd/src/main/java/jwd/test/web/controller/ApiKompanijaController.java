package jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.test.model.Automobil;
import jwd.test.model.Kompanija;
import jwd.test.service.AutomobilService;
import jwd.test.service.KompanijaService;
import jwd.test.support.AutomobilToAutomobilDTO;
import jwd.test.support.KompanijaToKompanijaDTO;
import jwd.test.web.dto.AutomobilDTO;
import jwd.test.web.dto.KompanijaDTO;

@RestController
@RequestMapping(value = "/api/kompanije")
public class ApiKompanijaController {

	@Autowired
	KompanijaService kompanijaService;
	
	@Autowired
	AutomobilService automobilService;

	@Autowired
	KompanijaToKompanijaDTO toKompanijaDto;
	
	@Autowired
	AutomobilToAutomobilDTO toAutomobilDto;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KompanijaDTO>> get() {
		return new ResponseEntity<>(toKompanijaDto.convert(kompanijaService.findAll()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<KompanijaDTO> get(@PathVariable Long id){
		
		Kompanija kompanija = kompanijaService.findOne(id);
		
		if(kompanija==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toKompanijaDto.convert(kompanijaService.findOne(id)), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{kompanijaId}/automobili")
	public ResponseEntity<List<AutomobilDTO>> getAutomobiliByKompanijaId(
			@PathVariable Long kompanijaId,
			@RequestParam(defaultValue="0") int pageNum){
		
		Page<Automobil> automobili = automobilService.findByKompanijaId(pageNum, kompanijaId);
		
		return new ResponseEntity<>(toAutomobilDto.convert(automobili.getContent()), HttpStatus.OK);
		
	}

}
