package cat.itb.minescope.model.repositoris;

import cat.itb.minescope.model.entitats.MineralSampleTransparent;
import cat.itb.minescope.model.entitats.MineralTransparent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MineralSampleTransparentRepository extends JpaRepository<MineralSampleTransparent, Integer> {
}
