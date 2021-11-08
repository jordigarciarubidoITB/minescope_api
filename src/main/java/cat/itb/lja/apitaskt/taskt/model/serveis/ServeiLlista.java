package cat.itb.lja.apitaskt.taskt.model.serveis;

import cat.itb.lja.apitaskt.taskt.model.entitats.Llista;
import cat.itb.lja.apitaskt.taskt.model.repositoris.RepositoriLlistes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiLlista {
    private final RepositoriLlistes repositoriLlistes;

    public List<Llista> llistarLlistes(){
        return repositoriLlistes.findAll();
    }

    public Llista consultarLlista(int id){
        return repositoriLlistes.findById(id).orElse(null);
    }

    public Llista afegirLlista(Llista ll){
        return repositoriLlistes.save(ll);
    }

    public Llista modificarLlista(Llista ll){
        Llista aux = null;
        if(repositoriLlistes.existsById(ll.getIdLlista())) aux= repositoriLlistes.save(ll);
        return aux;
    }

    public Llista eliminarLlista(int id){
        Llista res= repositoriLlistes.findById(id).orElse(null);
        if(res!=null) repositoriLlistes.deleteById(id);
        return res;
    }
}
