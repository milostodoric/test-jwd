package jwd.test.service;

import java.util.List;

import jwd.test.model.Kompanija;

public interface KompanijaService {

	Kompanija findOne(Long id);

	List<Kompanija> findAll();

	Kompanija save(Kompanija kompanija);

	Kompanija delete(Long id);

}
