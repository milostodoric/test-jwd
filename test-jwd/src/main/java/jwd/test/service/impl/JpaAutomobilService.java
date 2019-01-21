package jwd.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.test.model.Automobil;
import jwd.test.repository.AutomobilRepository;
import jwd.test.service.AutomobilService;

@Service
@Transactional
public class JpaAutomobilService implements AutomobilService {

	@Autowired
	private AutomobilRepository automobilRepository;

	@Override
	public Automobil findOne(Long id) {
		return automobilRepository.findOne(id);
	}

	@Override
	public Page<Automobil> findAll(int pageNum) {
		return automobilRepository.findAll(
				new PageRequest(pageNum, 5));
	}
	
	@Override
	public Automobil save(Automobil kompanija) {
		return automobilRepository.save(kompanija);
	}

	@Override
	public Automobil delete(Long id) {
		Automobil automobil = automobilRepository.findOne(id);
		if (automobil != null) {
			automobilRepository.delete(automobil);
		}

		return automobil;
	}

	@Override
	public Page<Automobil> pretraga(String model, Integer godiste, Double potrosnja, int page) {
		
		return automobilRepository.pretraga(model, godiste, potrosnja, new PageRequest(page, 10));
	}



}
