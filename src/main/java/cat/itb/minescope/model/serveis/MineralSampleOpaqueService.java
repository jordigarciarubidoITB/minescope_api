package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.Llista;
import cat.itb.minescope.model.entitats.MineralSampleOpaque;
import cat.itb.minescope.model.repositoris.MineralOpaqueRepository;
import cat.itb.minescope.model.repositoris.MineralSampleOpaqueRepository;
import cat.itb.minescope.model.repositoris.RepositoriLlistes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MineralSampleOpaqueService {
    private final MineralSampleOpaqueRepository repository;

    public List<MineralSampleOpaque> listOpaqueSamples(){
        return repository.findAll();
    }

    public MineralSampleOpaque checkOpaqueSample(int id){
        return repository.findById(id).orElse(null);
    }

    public MineralSampleOpaque addOpaqueSample(MineralSampleOpaque mso){
        return repository.save(mso);
    }

    public MineralSampleOpaque modifyOpaqueSample(MineralSampleOpaque mso){
        MineralSampleOpaque aux = null;
        if(repository.existsById(mso.getIdSample())){
            aux= repository.save(mso);
        }
        return aux;
    }

    public MineralSampleOpaque deleteOpaqueSample(int id){
        MineralSampleOpaque res= repository.findById(id).orElse(null);
        if(res!=null) {
            repository.deleteById(id);
        }
        return res;
    }
}
