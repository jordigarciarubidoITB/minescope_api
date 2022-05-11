package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleTransparentCa;
import cat.itb.minescope.model.repositoris.MineralSampleTransparentRepositoryCa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleTransparentServiceCa {
    private final MineralSampleTransparentRepositoryCa repository;

    public List<MineralSampleTransparentCa> listTransparentSample(){
        return repository.findAll();
    }

    public MineralSampleTransparentCa checkTransparentSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleTransparentCa addTransparentSample(MineralSampleTransparentCa mineral){
        return repository.save(mineral);
    }

    public MineralSampleTransparentCa modifyTransparentSample(MineralSampleTransparentCa mineral){
        MineralSampleTransparentCa aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralSampleTransparentCa deleteTransparentSample(int id){
        MineralSampleTransparentCa res = repository.findById(id).orElse(null);
        if (res != null) {
            repository.deleteById(id);
        }
        return res;
    }
}
