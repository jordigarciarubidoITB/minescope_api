package cat.itb.lja.apitaskt.taskt.model.serveis;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import cat.itb.lja.apitaskt.taskt.model.repositoris.RepositoriItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiItem {
    private final RepositoriItems repoItems;

    public List<Item> llistarItems(){
        return repoItems.findAll();
    }

    public Item consultarItem(int id){
        return repoItems.findById(id).orElse(null);
    }

    public Item afegirItem(Item it){
        return repoItems.save(it);
    }

    public Item modificarItem(Item it){
        Item aux = null;
        if(repoItems.existsById(it.getIdItem())) aux= repoItems.save(it);
        return aux;
    }

    public Item eliminarItem(int id){
        Item res= repoItems.findById(id).orElse(null);
        if(res!=null) repoItems.deleteById(id);
        return res;
    }
}
