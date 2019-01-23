package jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.test.model.Automobil;
import jwd.test.service.AutomobilService;
import jwd.test.support.AutomobilDTOToAutomobil;
import jwd.test.support.AutomobilToAutomobilDTO;
import jwd.test.web.dto.AutomobilDTO;

@RestController
@RequestMapping("/api/automobili")
public class ApiAutomobilController {

	@Autowired
	AutomobilService automobilService;

	@Autowired
	AutomobilDTOToAutomobil toAutomobil;

	@Autowired
	AutomobilToAutomobilDTO toDto;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AutomobilDTO>> get(
			@RequestParam(required = false) String model,
			@RequestParam(required = false) Integer godiste,
			@RequestParam(required = false) Double potrosnja,
			@RequestParam(defaultValue = "0") int pageNum) {

		Page<Automobil> automobili;
		
		if(model != null || godiste != null || potrosnja != null) {
			automobili = automobilService.pretraga(model, godiste, potrosnja, pageNum);
		}else {
			automobili = automobilService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(automobili.getTotalPages()) );
		return new ResponseEntity<>(toDto.convert(automobili.getContent()), HttpStatus.OK);
				
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AutomobilDTO> get(@PathVariable Long id) {
		Automobil automobil = automobilService.findOne(id);
		
		if(automobil == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDto.convert(automobil), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AutomobilDTO> add(@Validated @RequestBody AutomobilDTO novAutomobil){
		
		Automobil automobil = toAutomobil.convert(novAutomobil);
		
		automobilService.save(automobil);
		
		return new ResponseEntity<>(toDto.convert(automobil), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<AutomobilDTO> edit (
			@PathVariable Long id,
			@Validated @RequestBody AutomobilDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Automobil automobil = toAutomobil.convert(izmenjen);
		
		automobilService.save(automobil);
		
		return new ResponseEntity<>(toDto.convert(automobil), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<AutomobilDTO> delete(@PathVariable Long id){
		automobilService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
			
}
