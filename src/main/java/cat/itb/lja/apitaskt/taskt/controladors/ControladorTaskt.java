package cat.itb.lja.apitaskt.taskt.controladors;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorTaskt {
    private final ServeiItem serveiItem;

    @GetMapping("/items")
    public List<Item> llistarItems() {
        return serveiItem.llistarItems();
    }

    @GetMapping("/items/{id}")
    public Item consultarItem(@PathVariable int id)
    {
        return serveiItem.consultarItem(id);
    }

    @PostMapping("/items")
    public Item crearItem(@RequestBody Item nou){
        return serveiItem.afegirItem(nou);
    }

    @DeleteMapping("/items/{id}")
    public Item eliminarItem(@PathVariable int id){
        return serveiItem.eliminarItem(id);
    }

    //per modificar un usuari existent
    @PutMapping("/items")
    public Item modificarItem(@RequestBody Item mod){
        return serveiItem.modificarItem(mod);
    }
}
