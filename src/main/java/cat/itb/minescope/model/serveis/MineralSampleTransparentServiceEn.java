package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleTransparentEn;
import cat.itb.minescope.model.repositoris.MineralSampleTransparentRepositoryEn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleTransparentServiceEn {
    private final MineralSampleTransparentRepositoryEn repository;

    public List<MineralSampleTransparentEn> listTransparentSample(){
        return repository.findAll();
    }

    public MineralSampleTransparentEn checkTransparentSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleTransparentEn addTransparentSample(MineralSampleTransparentEn mineral){
        return repository.save(mineral);
    }

    public MineralSampleTransparentEn modifyTransparentSample(MineralSampleTransparentEn mineral){
        MineralSampleTransparentEn aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralSampleTransparentEn deleteTransparentSample(int id){
        MineralSampleTransparentEn res = repository.findById(id).orElse(null);
        if (res != null) {
            repository.deleteById(id);
        }
        return res;
    }
}
