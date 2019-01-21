package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import jwd.test.model.Kompanija;
import jwd.test.web.dto.KompanijaDTO;

public class KompanijaDTOtoKompanija implements Converter<KompanijaDTO, Kompanija>{

	@Override
	public Kompanija convert(KompanijaDTO dto) {
		Kompanija kompanija = new Kompanija();
		kompanija.setNaziv(dto.getNaziv());
		kompanija.setAdresa(dto.getAdresa());
		kompanija.setTelefon(dto.getTelefon());
		return kompanija;
	}
	
	
	public List<Kompanija> convert(List<KompanijaDTO> dtos) {
		List<Kompanija> ret = new ArrayList<>();
		
		for(KompanijaDTO dto: dtos){
			ret.add(convert(dto));
		}
		
		return ret;
	}


}
