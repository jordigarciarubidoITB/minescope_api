package cat.itb.minescope.controladors;

import cat.itb.minescope.model.entitats.*;
import cat.itb.minescope.model.serveis.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //TRANSPARENT MINERALS
    @GetMapping("/transparentminerals")
    public ResponseEntity<?> listTransparentMinerals() {
        if (mineralTransparentService.listTransparentMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralTransparentService.listTransparentMinerals());
    }

    @GetMapping("/transparentminerals/{id}")
    public ResponseEntity<?> checkTransparentMineral(@PathVariable int id) {
        MineralTransparent res = mineralTransparentService.checkTransparentMinerals(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("/transparentminerals")
    public ResponseEntity<?> createTransparentMineral(@RequestBody MineralTransparent newMineral){
        MineralTransparent res = mineralTransparentService.addTransparentMinerals(newMineral);
        return new ResponseEntity<MineralTransparent>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/transparentminerals/{id}")
    public ResponseEntity<?> deleteTransparentMineral(@PathVariable int id) {
        MineralTransparent res = mineralTransparentService.deleteTransparentMineral(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //TRANSPARENT MINERALS SAMPLES
    @GetMapping("/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> listTransparentSamples(@PathVariable int idMineral) {
        MineralTransparent res = mineralTransparentService.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getSampleList());
        }
    }

    @GetMapping("/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> checkTransparentSample(@PathVariable int idMineral, @PathVariable int id) {
        MineralTransparent res1 = mineralTransparentService.checkTransparentMinerals(idMineral);
        MineralSampleTransparent res2 = mineralSampleTransparentService.checkTransparentSample(id);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> createTransparentSample(@PathVariable int idMineral, @RequestBody MineralSampleTransparent newSample){
        MineralTransparent res = mineralTransparentService.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            if (newSample.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparent res2 = mineralSampleTransparentService.addTransparentSample(newSample);
                return new ResponseEntity<MineralSampleTransparent>(res2, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> modifyTransparentSample(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparent res = mineralTransparentService.checkTransparentMinerals(idMineral);
        MineralSampleTransparent res2 = mineralSampleTransparentService.checkTransparentSample(id);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparent res3 = mineralSampleTransparentService.modifyTransparentSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> deleteTransparentSample(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparent res = mineralTransparentService.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            MineralSampleTransparent res2 = mineralSampleTransparentService.deleteTransparentSample(id);
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }
}
