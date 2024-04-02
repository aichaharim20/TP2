package emsi.tp2.repository;

import emsi.tp2.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
Medecin findByNom(String name);
}
