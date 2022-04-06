package cat.itb.minescope.model.serveis;

import cat.itb.minescope.model.entitats.Llista;
import cat.itb.minescope.model.repositoris.RepositoriLlistes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiLlista {
    private final RepositoriLlistes repositoriLlistes;
    private final ServeiItem serveiItem;

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
        if(repositoriLlistes.existsById(ll.getIdLlista())){
            ll.setLlistaItem(consultarLlista(ll.getIdLlista()).getLlistaItem());
            aux= repositoriLlistes.save(ll);
        }
        return aux;
    }

    public Llista eliminarLlista(int id){
        Llista res= repositoriLlistes.findById(id).orElse(null);
        if(res!=null) {
            if (res.getLlistaItem() != null) {
                for (int i = 0; i < res.getLlistaItem().size(); i++) {
                    serveiItem.eliminarItem(res.getLlistaItem().get(i).getIdItem());
                }
            }
            repositoriLlistes.deleteById(id);
        }
        return res;
    }
}
