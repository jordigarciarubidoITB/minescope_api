package cat.itb.minescope.model.repositoris;

import cat.itb.minescope.model.entitats.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriUsuaris extends JpaRepository<Usuari, Integer> {
}