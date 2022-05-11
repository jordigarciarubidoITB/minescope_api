package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralOpaqueSp;
import cat.itb.minescope.model.repositoris.MineralOpaqueRepositorySp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralOpaqueServiceSp {
    private final MineralOpaqueRepositorySp repository;
    private final MineralSampleOpaqueServiceSp sampleOpaqueService;

    public List<MineralOpaqueSp> listOpaqueMinerals(){
        return repository.findAll();
    }

    public MineralOpaqueSp checkOpaqueMineral(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralOpaqueSp addOpaqueMineral(MineralOpaqueSp mo){
        return repository.save(mo);
    }

    public MineralOpaqueSp modifyOpaqueMineral(MineralOpaqueSp mo){
        MineralOpaqueSp aux = null;
        if(repository.existsById(mo.getIdMineral())){
            aux= repository.save(mo);
        }
        return aux;
    }

    public MineralOpaqueSp deleteOpaqueMineral(int id){
        MineralOpaqueSp res= repository.findById(id).orElse(null);
        if(res!=null) {
            if (res.getOpaqueSamplesList() != null) {
                for (int i = 0; i < res.getOpaqueSamplesList().size(); i++) {
                    sampleOpaqueService.deleteOpaqueSample(res.getOpaqueSamplesList().get(i).getIdSample());
                }
            }
            repository.deleteById(id);
        }
        return res;
    }
}
