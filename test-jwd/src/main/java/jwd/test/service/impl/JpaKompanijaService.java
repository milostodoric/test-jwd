package jwd.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.test.model.Kompanija;
import jwd.test.repository.KompanijaRepository;
import jwd.test.service.KompanijaService;

@Service
@Transactional
public class JpaKompanijaService implements KompanijaService {

	@Autowired
	private KompanijaRepository kompanijaRepository;

	@Override
	public Kompanija findOne(Long id) {
		return kompanijaRepository.findOne(id);
	}

	@Override
	public List<Kompanija> findAll() {
		return kompanijaRepository.findAll();
	}

	@Override
	public Kompanija save(Kompanija kompanija) {
		return kompanijaRepository.save(kompanija);
	}

	@Override
	public Kompanija delete(Long id) {
		Kompanija kompanija = kompanijaRepository.findOne(id);
		if (kompanija != null) {
			kompanijaRepository.delete(kompanija);
		}

		return kompanija;
	}

}
