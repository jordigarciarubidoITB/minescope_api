package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleOpaqueCa;
import cat.itb.minescope.model.repositoris.MineralSampleOpaqueRepositoryCa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleOpaqueServiceCa {
    private final MineralSampleOpaqueRepositoryCa repository;

    public List<MineralSampleOpaqueCa> listOpaqueSamples(){
        return repository.findAll();
    }

    public MineralSampleOpaqueCa checkOpaqueSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleOpaqueCa addOpaqueSample(MineralSampleOpaqueCa mso){
        return repository.save(mso);
    }

    public MineralSampleOpaqueCa modifyOpaqueSample(MineralSampleOpaqueCa mso){
        MineralSampleOpaqueCa aux = null;
        if(repository.existsById(mso.getId())){
            aux= repository.save(mso);
        }
        return aux;
    }

    public MineralSampleOpaqueCa deleteOpaqueSample(int id){
        MineralSampleOpaqueCa res= repository.findById(id).orElse(null);
        if(res!=null) {
            repository.deleteById(id);
        }
        return res;
    }
}
