package jwd.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.test.model.Kompanija;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Long> {

}
