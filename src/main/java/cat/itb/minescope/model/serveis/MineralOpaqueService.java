package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralOpaque;
import cat.itb.minescope.model.entitats.Usuari;
import cat.itb.minescope.model.repositoris.MineralOpaqueRepository;
import cat.itb.minescope.model.repositoris.RepositoriUsuaris;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralOpaqueService {
    private final MineralOpaqueRepository repository;
    private final MineralSampleOpaqueService sampleOpaqueService;

    public List<MineralOpaque> listOpaqueMinerals(){
        return repository.findAll();
    }

    public MineralOpaque checkOpaqueMineral(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralOpaque addOpaqueMineral(MineralOpaque mo){
        return repository.save(mo);
    }

    public MineralOpaque modifyOpaqueMineral(MineralOpaque mo){
        MineralOpaque aux = null;
        if(repository.existsById(mo.getIdMineral())){
            aux= repository.save(mo);
        }
        return aux;
    }

    public MineralOpaque deleteOpaqueMineral(int id){
        MineralOpaque res= repository.findById(id).orElse(null);
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
