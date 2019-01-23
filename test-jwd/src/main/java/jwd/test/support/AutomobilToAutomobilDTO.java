package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Automobil;
import jwd.test.web.dto.AutomobilDTO;

@Component
public class AutomobilToAutomobilDTO implements Converter<Automobil, AutomobilDTO> {

	@Override
	public AutomobilDTO convert(Automobil automobil) {
		AutomobilDTO dto = new AutomobilDTO();
		dto.setId(automobil.getId());
		dto.setModel(automobil.getModel());
		dto.setRegistracija(automobil.getRegistracija());
		dto.setGodiste(automobil.getGodiste());
		dto.setPotrosnja(automobil.getPotrosnja());
		dto.setKompanijaId(automobil.getKompanija().getId());
		dto.setKompanijaNaziv(automobil.getKompanija().getNaziv());
		return dto;
	}

	public List<AutomobilDTO> convert(List<Automobil> automobili) {
		List<AutomobilDTO> ret = new ArrayList<>();
		for (Automobil automobil : automobili) {
			ret.add(convert(automobil));
		}
		return ret;
	}

}
