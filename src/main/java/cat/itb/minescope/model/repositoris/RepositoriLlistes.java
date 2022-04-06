package cat.itb.minescope.model.repositoris;

import cat.itb.minescope.model.entitats.Llista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriLlistes extends JpaRepository<Llista, Integer> {
}