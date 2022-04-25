package cat.itb.minescope.controladors;

import cat.itb.minescope.model.entitats.*;
import cat.itb.minescope.model.serveis.*;
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
    private final MineralOpaqueService mineralOpaque;
    private final MineralSampleOpaqueService mineralSampleOpaque;
    private final MineralTransparentService mineralTransparentService;
    private final MineralSampleTransparentService mineralSampleTransparentService;

    //OPAQUE MINERALS
    @GetMapping("/opaqueminerals")
    public ResponseEntity<?> listOpaqueMinerals() {
        if (mineralOpaque.listOpaqueMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralOpaque.listOpaqueMinerals());
    }

    @PostMapping("/opaqueminerals")
    public ResponseEntity<?> createOpaqueMineral(@RequestBody MineralOpaque mo){
        MineralOpaque res = mineralOpaque.addOpaqueMineral(mo);
        return new ResponseEntity<MineralOpaque>(res, HttpStatus.CREATED);
    }

    @GetMapping("/opaqueminerals/{idMineral}")
    public ResponseEntity<?> checkOpaqueMineral(@PathVariable int idMineral) {
        MineralOpaque res = mineralOpaque.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @DeleteMapping("/opaqueminerals/{idMineral}")
    public ResponseEntity<?> deleteOpaqueMineral(@PathVariable int idMineral) {
        MineralOpaque res = mineralOpaque.deleteOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //OPAQUE MINERAL SAMPLES
    @GetMapping("/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> listOpaqueSamples(@PathVariable int idMineral) {
        MineralOpaque res = mineralOpaque.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getOpaqueSamplesList());
        }
    }

    @GetMapping("/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> checkOpaqueSample(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaque res1 = mineralOpaque.checkOpaqueMineral(idMineral);
        MineralSampleOpaque res2 = mineralSampleOpaque.checkOpaqueSample(idSample);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> createOpaqueSample(@PathVariable int idMineral, @RequestBody MineralSampleOpaque mso){
        MineralOpaque res2 = mineralOpaque.checkOpaqueMineral(idMineral);
        if (res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mso.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaque res3 = mineralSampleOpaque.addOpaqueSample(mso);
                return new ResponseEntity<MineralSampleOpaque>(res3, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> modifyOpaqueSample(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaque res = mineralOpaque.checkOpaqueMineral(idMineral);
        MineralSampleOpaque res2 = mineralSampleOpaque.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaque res3 = mineralSampleOpaque.modifyOpaqueSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> deleteOpaqueSample(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaque res = mineralOpaque.checkOpaqueMineral(idMineral);
        MineralSampleOpaque res2 = mineralSampleOpaque.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mineralSampleOpaque.deleteOpaqueSample(idSample) == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
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
