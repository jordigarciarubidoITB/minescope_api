package cat.itb.lja.apitaskt.taskt.controladors;

import cat.itb.lja.apitaskt.taskt.model.entitats.Item;
import cat.itb.lja.apitaskt.taskt.model.serveis.ServeiItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ControladorResponseEntity {
    private final ServeiItem serveiItem;

    //si l'id de l'Item no existeix es retorna 404 Not Found
    @GetMapping("/item/{id}")
    public ResponseEntity<?> consultarUsuari(@PathVariable int id) {
        Item res = serveiItem.consultarItem(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/user")
    public ResponseEntity<?> crearItem(@RequestBody Item nou){
        Item res=serveiItem.afegirItem(nou);
        return new ResponseEntity<Item>(res, HttpStatus.CREATED);
    }
}
