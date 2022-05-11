package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleTransparentSp;
import cat.itb.minescope.model.repositoris.MineralSampleTransparentRepositorySp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleTransparentServiceSp {
    private final MineralSampleTransparentRepositorySp repository;

    public List<MineralSampleTransparentSp> listTransparentSample(){
        return repository.findAll();
    }

    public MineralSampleTransparentSp checkTransparentSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleTransparentSp addTransparentSample(MineralSampleTransparentSp mineral){
        return repository.save(mineral);
    }

    public MineralSampleTransparentSp modifyTransparentSample(MineralSampleTransparentSp mineral){
        MineralSampleTransparentSp aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralSampleTransparentSp deleteTransparentSample(int id){
        MineralSampleTransparentSp res = repository.findById(id).orElse(null);
        if (res != null) {
            repository.deleteById(id);
        }
        return res;
    }
}
