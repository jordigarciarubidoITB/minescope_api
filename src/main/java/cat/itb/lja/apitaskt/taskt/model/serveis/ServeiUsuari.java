package cat.itb.lja.apitaskt.taskt.model.serveis;

import cat.itb.lja.apitaskt.taskt.model.entitats.Usuari;
import cat.itb.lja.apitaskt.taskt.model.repositoris.RepositoriUsuaris;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiUsuari {
    private final RepositoriUsuaris repositoriUsuaris;
    private final ServeiLlista serveiLlista;

    public List<Usuari> llistarUsuaris(){
        return repositoriUsuaris.findAll();
    }

    public Usuari consultarUsuari(int id){
        return repositoriUsuaris.findById(id).orElse(null);
    }

    public Usuari afegirUsuari(Usuari us){
        return repositoriUsuaris.save(us);
    }

    public Usuari modificarUsuari(Usuari us){
        Usuari aux = null;
        if(repositoriUsuaris.existsById(us.getIdUsuari())){
            us.setPassword(consultarUsuari(us.getIdUsuari()).getPassword());
            aux= repositoriUsuaris.save(us);
        }
        return aux;
    }

    public Usuari eliminarUsuari(int id){
        Usuari res= repositoriUsuaris.findById(id).orElse(null);
        if(res!=null) {
            if (res.getLlistaLlista() != null) {
                for (int i = 0; i < res.getLlistaLlista().size(); i++) {
                    serveiLlista.eliminarLlista(res.getLlistaLlista().get(i).getIdLlista());
                }
            }
            repositoriUsuaris.deleteById(id);
        }
        return res;
    }
}
