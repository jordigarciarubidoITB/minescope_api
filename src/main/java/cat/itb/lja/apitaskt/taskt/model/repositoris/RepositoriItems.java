package cat.itb.lja.apitaskt.taskt.model.repositoris;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriItems extends JpaRepository<Item, Integer> {
}