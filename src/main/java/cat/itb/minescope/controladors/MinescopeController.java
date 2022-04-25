package cat.itb.minescope.controladors;

import cat.itb.minescope.model.entitats.Item;
import cat.itb.minescope.model.entitats.Llista;
import cat.itb.minescope.model.serveis.ServeiItem;
import cat.itb.minescope.model.serveis.ServeiLlista;
import cat.itb.minescope.model.serveis.ServeiUsuari;
import cat.itb.minescope.model.entitats.Usuari;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MinescopeController {
    private final ServeiItem serveiItem;
    private final ServeiLlista serveiLlista;
    private final ServeiUsuari serveiUsuari;

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

    @GetMapping("/todousers/{idUsuari}")
    public ResponseEntity<?> consultarUsuari(@PathVariable int idUsuari) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @DeleteMapping("/todousers/{idUsuari}")
    public ResponseEntity<?> eliminarUsuari(@PathVariable int idUsuari) {
        Usuari res = serveiUsuari.eliminarUsuari(idUsuari);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //LLISTES

    @GetMapping("/todousers/{idUsuari}/todolists")
    public ResponseEntity<?> llistarLlista(@PathVariable int idUsuari) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            return ResponseEntity.ok(res.getLlistaLlista());
        }
    }

    @GetMapping("/todousers/{idUsuari}/todolists/{idLlista}")
    public ResponseEntity<?> consultarLlista(@PathVariable int idUsuari, @PathVariable int idLlista) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        Llista res2 = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(res2);
        }
    }

    @PostMapping("/todousers/{idUsuari}/todolists")
    public ResponseEntity<?> crearLlista(@PathVariable int idUsuari, @RequestBody Llista nou){
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            nou.setIdUsuari(idUsuari);
            Llista res2 = serveiLlista.afegirLlista(nou);
            return new ResponseEntity<Llista>(res2, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/todousers/{idUsuari}/todolists/{idLlista}")
    public ResponseEntity<?> eliminarLlista(@PathVariable int idUsuari,@PathVariable int idLlista) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            Llista res2 = serveiLlista.eliminarLlista(idLlista);
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //@PutMapping("/todolists")
    //public ResponseEntity<?> modificarLlista(@RequestBody Llista mod) {
    //    Llista res = serveiLlista.modificarLlista(mod);
    //    if (res == null) return ResponseEntity.notFound().build();
    //    else return ResponseEntity.ok(res);
    //}

    @GetMapping("/todousers/{idUsuari}/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> llistarItemsLlista(@PathVariable int idUsuari, @PathVariable int idLlista) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        Llista res2 = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            if (res2 == null) return ResponseEntity.notFound().build();
            else {
                return ResponseEntity.ok(res2.getLlistaItem());
            }
        }
    }

    @GetMapping("/todousers/{idUsuari}/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> consultarItemLlista(@PathVariable int idUsuari,@PathVariable int idLlista, @PathVariable int idItem) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        Llista res2 = serveiLlista.consultarLlista(idLlista);
        Item res3 = serveiItem.consultarItem(idItem);
        if (res == null) return ResponseEntity.notFound().build();
        else{
            if (res2 == null) return ResponseEntity.notFound().build();
            else {
                if (res3 == null) return ResponseEntity.notFound().build();
                return ResponseEntity.ok(res3);
            }
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/todousers/{idUsuari}/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> crearItem(@PathVariable int idUsuari, @PathVariable int idLlista, @RequestBody Item nou){
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        Llista res2 = serveiLlista.consultarLlista(idLlista);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            else {
                if (nou.getIdLlista() != idLlista) return ResponseEntity.notFound().build();
                else {
                    Item res3 = serveiItem.afegirItem(nou);
                    return new ResponseEntity<Item>(res3, HttpStatus.CREATED);
                }
            }
        }
    }

    @PutMapping("/todousers/{idUsuari}/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> modificarItem(@PathVariable int idUsuari,@PathVariable int idLlista,@PathVariable int idItem) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        Llista res2 = serveiLlista.consultarLlista(idLlista);
        Item res3 = serveiItem.consultarItem(idItem);
        if (res == null || res2 == null || res3 == null) return ResponseEntity.notFound().build();
        else {
            if (res3.getIdLlista() != idLlista) return ResponseEntity.notFound().build();
            else {
                Item res4 = serveiItem.modificarItem(idItem);
                return ResponseEntity.ok(res4);}
        }
    }

    @DeleteMapping("/todousers/{idUsuari}/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> eliminarItem(@PathVariable int idUsuari, @PathVariable int idLlista,@PathVariable int idItem) {
        Usuari res = serveiUsuari.consultarUsuari(idUsuari);
        Llista res2 = serveiLlista.consultarLlista(idLlista);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            Item res3 = serveiItem.eliminarItem(idItem);
            if (res3 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }


}
