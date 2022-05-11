package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralTransparentEn;
import cat.itb.minescope.model.repositoris.MineralTransparentRepositoryEn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralTransparentServiceEn {
    private final MineralTransparentRepositoryEn repository;
    private final MineralSampleTransparentServiceEn service;

    public List<MineralTransparentEn> listTransparentMinerals(){
        return repository.findAll();
    }

    public MineralTransparentEn checkTransparentMinerals(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralTransparentEn addTransparentMinerals(MineralTransparentEn mineral){
        return repository.save(mineral);
    }

    public MineralTransparentEn modifyTransparentMineral(MineralTransparentEn mineral){
        MineralTransparentEn aux = null;
        if(repository.existsById(mineral.getId())){
            aux= repository.save(mineral);
        }
        return aux;
    }

    public MineralTransparentEn deleteTransparentMineral(int id){
        MineralTransparentEn res = repository.findById(id).orElse(null);
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
