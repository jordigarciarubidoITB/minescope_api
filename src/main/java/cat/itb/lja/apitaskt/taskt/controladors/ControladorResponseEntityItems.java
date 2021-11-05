package cat.itb.lja.apitaskt.taskt.controladors;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ControladorResponseEntityItems {
    private final ServeiItem serveiItem;

    //si l'id de l'Item no existeix es retorna 404 Not Found
    @GetMapping("/todoitems")
    public ResponseEntity<?> llistarItems() {
        if (serveiItem.llistarItems() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(serveiItem.llistarItems());
    }

    //si l'id de l'Item no existeix es retorna 404 Not Found
    @GetMapping("/todoitems/{idItem}")
    public ResponseEntity<?> consultarItem(@PathVariable int id) {
        Item res = serveiItem.consultarItem(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/todoitems")
    public ResponseEntity<?> crearItem(@RequestBody Item nou){
        Item res=serveiItem.afegirItem(nou);
        return new ResponseEntity<Item>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/todoitems/{id}")
    public ResponseEntity<?> eliminarItem(@PathVariable int id) {
        Item res = serveiItem.eliminarItem(id);
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
