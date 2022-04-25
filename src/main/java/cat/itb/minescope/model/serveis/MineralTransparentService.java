package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralTransparent;
import cat.itb.minescope.model.repositoris.MineralTransparentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralTransparentService {
    private final MineralTransparentRepository repository;
    private final MineralSampleTransparentService service;

    public List<MineralTransparent> listTransparentMinerals(){
        return repository.findAll();
    }

    public MineralTransparent checkTransparentMinerals(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralTransparent addTransparentMinerals(MineralTransparent mineral){
        return repository.save(mineral);
    }

    public MineralTransparent modifyTransparentMineral(MineralTransparent mineral){
        MineralTransparent aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralTransparent deleteTransparentMineral(int id){
        MineralTransparent res = repository.findById(id).orElse(null);
        if (res != null) {
            if (res.getSampleList() != null) {
                for (int i = 0; i < res.getSampleList().size(); i++) {
                    service.deleteTransparentSample(res.getSampleList().get(i).getId());
                }
            }
            repository.deleteById(id);
        }
        return res;
    }
}
