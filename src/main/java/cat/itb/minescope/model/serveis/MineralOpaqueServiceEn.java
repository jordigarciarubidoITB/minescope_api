package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralOpaqueEn;
import cat.itb.minescope.model.repositoris.MineralOpaqueRepositoryEn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralOpaqueServiceEn {
    private final MineralOpaqueRepositoryEn repository;
    private final MineralSampleOpaqueServiceEn sampleOpaqueService;

    public List<MineralOpaqueEn> listOpaqueMinerals(){
        return repository.findAll();
    }

    public MineralOpaqueEn checkOpaqueMineral(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralOpaqueEn addOpaqueMineral(MineralOpaqueEn mo){
        return repository.save(mo);
    }

    public MineralOpaqueEn modifyOpaqueMineral(MineralOpaqueEn mo){
        MineralOpaqueEn aux = null;
        if(repository.existsById(mo.getId())){
            aux= repository.save(mo);
        }
        return aux;
    }

    public MineralOpaqueEn deleteOpaqueMineral(int id){
        MineralOpaqueEn res= repository.findById(id).orElse(null);
        if(res!=null) {
            if (res.getOpaqueSamplesList() != null) {
                for (int i = 0; i < res.getOpaqueSamplesList().size(); i++) {
                    sampleOpaqueService.deleteOpaqueSample(res.getOpaqueSamplesList().get(i).getId());
                }
            }
            repository.deleteById(id);
        }
        return res;
    }
}
