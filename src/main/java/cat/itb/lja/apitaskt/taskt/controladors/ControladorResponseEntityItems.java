package cat.itb.lja.apitaskt.taskt.controladors;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import cat.itb.lja.apitaskt.taskt.model.entitats.Llista;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiItem;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiLlista;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ControladorResponseEntityItems {
    private final ServeiItem serveiItem;
    private final ServeiLlista serveiLlista;

    //LLISTES

    @GetMapping("/todolists")
    public ResponseEntity<?> llistarLlistes() {
        if (serveiLlista.llistarLlistes() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(serveiLlista.llistarLlistes());
    }

    @PostMapping("/todolists")
    public ResponseEntity<?> crearLlista(@RequestBody Llista nou){
        Llista res = serveiLlista.afegirLlista(nou);
        return new ResponseEntity<Llista>(res, HttpStatus.CREATED);
    }

    @GetMapping("/todolists/{idLlista}")
    public ResponseEntity<?> consultarLlista(@PathVariable int idLlista) {
        Llista res = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @DeleteMapping("/todolists/{idLlista}")
    public ResponseEntity<?> eliminarLlista(@PathVariable int idLlista) {
        Llista res = serveiLlista.eliminarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    @PutMapping("/todolists")
    public ResponseEntity<?> modificarLlista(@RequestBody Llista mod) {
        Llista res = serveiLlista.modificarLlista(mod);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //ITEMS

    //si l'id de l'Item no existeix es retorna 404 Not Found
    @GetMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> llistarItems(@PathVariable int idLlista) {
        Llista res = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            if (serveiItem.llistarItemsByIdLlista(idLlista) == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(serveiItem.llistarItemsByIdLlista(idLlista));
        }
    }

    //si l'id de l'Item no existeix es retorna 404 Not Found
    @GetMapping("/todoitems/{idItem}")
    public ResponseEntity<?> consultarItem(@PathVariable int idItem) {
        Item res = serveiItem.consultarItem(idItem);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/todoitems")
    public ResponseEntity<?> crearItem(@RequestBody Item nou){
        Item res=serveiItem.afegirItem(nou);
        return new ResponseEntity<Item>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/todoitems/{idItem}")
    public ResponseEntity<?> eliminarItem(@PathVariable int idItem) {
        Item res = serveiItem.eliminarItem(idItem);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    @PutMapping("/todoitems")
    public ResponseEntity<?> modificarItem(@RequestBody Item mod) {
        Item res = serveiItem.modificarItem(mod);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }
}
