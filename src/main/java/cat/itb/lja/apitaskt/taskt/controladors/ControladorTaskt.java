package cat.itb.lja.apitaskt.taskt.controladors;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import cat.itb.lja.apitaskt.taskt.model.entitats.Llista;
import cat.itb.lja.apitaskt.taskt.model.entitats.Usuari;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiItem;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiLlista;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiUsuari;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ControladorTaskt {
    private final ServeiItem serveiItem;
    private final ServeiLlista serveiLlista;
    private final ServeiUsuari serveiUsuari;

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

    @GetMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> llistarItemsLlista(@PathVariable int idLlista) {
        Llista res = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            return ResponseEntity.ok(res.getLlistaItem());
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> consultarItemLlista(@PathVariable int idLlista, @PathVariable int idItem) {
        Llista res = serveiLlista.consultarLlista(idLlista);
        Item res2 = serveiItem.consultarItem(idItem);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> crearItem(@PathVariable int idLlista, @RequestBody Item nou){
        Llista res = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            if (nou.getIdLlista() != idLlista) return ResponseEntity.notFound().build();
            else {
                Item res2 = serveiItem.afegirItem(nou);
                return new ResponseEntity<Item>(res2, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> modificarItem(@PathVariable int idLlista,@PathVariable int idItem) {
        Llista res = serveiLlista.consultarLlista(idLlista);
        Item res2 = serveiItem.consultarItem(idItem);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getIdLlista() != idLlista) return ResponseEntity.notFound().build();
            else {
                Item res3 = serveiItem.modificarItem(idItem);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> eliminarItem(@PathVariable int idLlista,@PathVariable int idItem) {
        Llista res = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            Item res2 = serveiItem.eliminarItem(idItem);
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //ITEMS

    @GetMapping("/todoitems")
    public ResponseEntity<?> llistarAllItems() {
        if (serveiItem.llistarItems() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(serveiItem.llistarItems());
    }

    //USUARIS

    @GetMapping("/todousers")
    public ResponseEntity<?> llistarAllUsers() {
        if (serveiUsuari.llistarUsuaris() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(serveiUsuari.llistarUsuaris());
    }

    @PostMapping("/todousers")
    public ResponseEntity<?> crearUsuari(@RequestBody Usuari nou){
        Usuari res = serveiUsuari.afegirUsuari(nou);
        return new ResponseEntity<Usuari>(res, HttpStatus.CREATED);
    }
    //
}
