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

    public Item modificarItem(int id_item){
        Item aux = repoItems.getById(id_item);
        Item auxMod = null;
        aux.setChecked(!aux.isChecked());
        if(repoItems.existsById(id_item)) auxMod= repoItems.save(aux);
        return auxMod;
    }

    public Item eliminarItem(int id){
        Item res= repoItems.findById(id).orElse(null);
        if(res!=null) repoItems.deleteById(id);
        return res;
    }
}
