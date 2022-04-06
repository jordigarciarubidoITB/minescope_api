package cat.itb.minescope.model.repositoris;

import cat.itb.minescope.model.entitats.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriItems extends JpaRepository<Item, Integer> {
}