package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralTransparentSp;
import cat.itb.minescope.model.repositoris.MineralTransparentRepositorySp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralTransparentServiceSp {
    private final MineralTransparentRepositorySp repository;
    private final MineralSampleTransparentServiceSp service;

    public List<MineralTransparentSp> listTransparentMinerals(){
        return repository.findAll();
    }

    public MineralTransparentSp checkTransparentMinerals(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralTransparentSp addTransparentMinerals(MineralTransparentSp mineral){
        return repository.save(mineral);
    }

    public MineralTransparentSp modifyTransparentMineral(MineralTransparentSp mineral){
        MineralTransparentSp aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralTransparentSp deleteTransparentMineral(int id){
        MineralTransparentSp res = repository.findById(id).orElse(null);
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
