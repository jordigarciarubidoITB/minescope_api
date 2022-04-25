package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleTransparent;
import cat.itb.minescope.model.repositoris.MineralSampleTransparentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleTransparentService {
    private final MineralSampleTransparentRepository repository;

    public List<MineralSampleTransparent> listTransparentSample(){
        return repository.findAll();
    }

    public MineralSampleTransparent checkTransparentSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleTransparent addTransparentSample(MineralSampleTransparent mineral){
        return repository.save(mineral);
    }

    public MineralSampleTransparent modifyTransparentSample(MineralSampleTransparent mineral){
        MineralSampleTransparent aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralSampleTransparent deleteTransparentSample(int id){
        MineralSampleTransparent res = repository.findById(id).orElse(null);
        if (res != null) {
            repository.deleteById(id);
        }
        return res;
    }
}
