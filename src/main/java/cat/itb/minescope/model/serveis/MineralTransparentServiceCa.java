package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralTransparentCa;
import cat.itb.minescope.model.repositoris.MineralTransparentRepositoryCa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralTransparentServiceCa {
    private final MineralTransparentRepositoryCa repository;
    private final MineralSampleTransparentServiceCa service;

    public List<MineralTransparentCa> listTransparentMinerals(){
        return repository.findAll();
    }

    public MineralTransparentCa checkTransparentMinerals(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralTransparentCa addTransparentMinerals(MineralTransparentCa mineral){
        return repository.save(mineral);
    }

    public MineralTransparentCa modifyTransparentMineral(MineralTransparentCa mineral){
        MineralTransparentCa aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralTransparentCa deleteTransparentMineral(int id){
        MineralTransparentCa res = repository.findById(id).orElse(null);
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
