package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralOpaqueCa;
import cat.itb.minescope.model.repositoris.MineralOpaqueRepositoryCa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralOpaqueServiceCa {
    private final MineralOpaqueRepositoryCa repository;
    private final MineralSampleOpaqueServiceCa sampleOpaqueService;

    public List<MineralOpaqueCa> listOpaqueMinerals(){
        return repository.findAll();
    }

    public MineralOpaqueCa checkOpaqueMineral(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralOpaqueCa addOpaqueMineral(MineralOpaqueCa mo){
        return repository.save(mo);
    }

    public MineralOpaqueCa modifyOpaqueMineral(MineralOpaqueCa mo){
        MineralOpaqueCa aux = null;
        if(repository.existsById(mo.getIdMineral())){
            aux= repository.save(mo);
        }
        return aux;
    }

    public MineralOpaqueCa deleteOpaqueMineral(int id){
        MineralOpaqueCa res= repository.findById(id).orElse(null);
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
