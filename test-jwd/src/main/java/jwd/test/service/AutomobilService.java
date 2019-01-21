package jwd.test.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.test.model.Automobil;

public interface AutomobilService {

	Automobil findOne(Long id);

	Page<Automobil> findAll(int pageNum);

	Automobil save(Automobil automobil);

	Automobil delete(Long id);

	Page<Automobil> pretraga(
			@Param("model") String model, 
			@Param("godiste") Integer godiste, 
			@Param("potrosnja") Double potrosnja, 
			int page);
	
}
