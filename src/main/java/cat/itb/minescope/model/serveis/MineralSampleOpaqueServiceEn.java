package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.MineralSampleOpaqueEn;
import cat.itb.minescope.model.repositoris.MineralSampleOpaqueRepositoryEn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleOpaqueServiceEn {
    private final MineralSampleOpaqueRepositoryEn repository;

    public List<MineralSampleOpaqueEn> listOpaqueSamples(){
        return repository.findAll();
    }

    public MineralSampleOpaqueEn checkOpaqueSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleOpaqueEn addOpaqueSample(MineralSampleOpaqueEn mso){
        return repository.save(mso);
    }

    public MineralSampleOpaqueEn modifyOpaqueSample(MineralSampleOpaqueEn mso){
        MineralSampleOpaqueEn aux = null;
        if(repository.existsById(mso.getId())){
            aux= repository.save(mso);
        }
        return aux;
    }

    public MineralSampleOpaqueEn deleteOpaqueSample(int id){
        MineralSampleOpaqueEn res= repository.findById(id).orElse(null);
        if(res!=null) {
            repository.deleteById(id);
        }
        return res;
    }
}
