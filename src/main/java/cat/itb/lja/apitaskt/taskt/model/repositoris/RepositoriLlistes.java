package cat.itb.lja.apitaskt.taskt.model.repositoris;

import cat.itb.lja.apitaskt.taskt.model.entitats.Llista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriLlistes extends JpaRepository<Llista, Integer> {
}