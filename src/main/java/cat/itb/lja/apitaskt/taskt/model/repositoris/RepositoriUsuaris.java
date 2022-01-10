package cat.itb.lja.apitaskt.taskt.model.repositoris;

import cat.itb.lja.apitaskt.taskt.model.entitats.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriUsuaris extends JpaRepository<Usuari, Integer> {
}