package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleOpaqueSp;
import cat.itb.minescope.model.repositoris.MineralSampleOpaqueRepositorySp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleOpaqueServiceSp {
    private final MineralSampleOpaqueRepositorySp repository;

    public List<MineralSampleOpaqueSp> listOpaqueSamples(){
        return repository.findAll();
    }

    public MineralSampleOpaqueSp checkOpaqueSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleOpaqueSp addOpaqueSample(MineralSampleOpaqueSp mso){
        return repository.save(mso);
    }

    public MineralSampleOpaqueSp modifyOpaqueSample(MineralSampleOpaqueSp mso){
        MineralSampleOpaqueSp aux = null;
        if(repository.existsById(mso.getId())){
            aux= repository.save(mso);
        }
        return aux;
    }

    public MineralSampleOpaqueSp deleteOpaqueSample(int id){
        MineralSampleOpaqueSp res= repository.findById(id).orElse(null);
        if(res!=null) {
            repository.deleteById(id);
        }
        return res;
    }
}
