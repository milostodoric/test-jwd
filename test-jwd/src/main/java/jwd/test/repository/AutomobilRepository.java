package jwd.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.test.model.Automobil;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, Long>{

	Page<Automobil> findByKompanijaId(Long kompanijaId, Pageable pageRequest);
	
	@Query("SELECT a FROM Automobil a WHERE "
			+ "(:model IS NULL OR a.model like :model ) AND "
			+ "(:godiste IS NULL OR a.godiste >= :godiste ) AND " 
			+ "(:potrosnja IS NULL OR a.potrosnja <= :potrosnja)"
			)
	Page<Automobil> pretraga(
			@Param("model")String model, 
			@Param("godiste") Integer godiste,
			@Param("potrosnja") Double potrosnja, 
			PageRequest pageRequest);

}
