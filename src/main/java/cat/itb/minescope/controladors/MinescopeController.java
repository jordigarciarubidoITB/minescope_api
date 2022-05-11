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
    private final MineralOpaqueServiceEn mineralOpaqueEn;
    private final MineralSampleOpaqueServiceEn mineralSampleOpaqueEn;
    private final MineralTransparentServiceEn mineralTransparentServiceEn;
    private final MineralSampleTransparentServiceEn mineralSampleTransparentServiceEn;

    private final MineralOpaqueServiceSp mineralOpaqueSp;
    private final MineralSampleOpaqueServiceSp mineralSampleOpaqueSp;
    private final MineralTransparentServiceSp mineralTransparentServiceSp;
    private final MineralSampleTransparentServiceSp mineralSampleTransparentServiceSp;

    private final MineralOpaqueServiceCa mineralOpaqueCa;
    private final MineralSampleOpaqueServiceCa mineralSampleOpaqueCa;
    private final MineralTransparentServiceCa mineralTransparentServiceCa;
    private final MineralSampleTransparentServiceCa mineralSampleTransparentServiceCa;

    //OPAQUE MINERALS EN
    @GetMapping("en/opaqueminerals")
    public ResponseEntity<?> listOpaqueMineralsEn(@PathVariable String language) {
        if (mineralOpaqueEn.listOpaqueMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralOpaqueEn.listOpaqueMinerals());
    }

    @PostMapping("en/opaqueminerals")
    public ResponseEntity<?> createOpaqueMineralEn(@RequestBody MineralOpaqueEn mo){
        MineralOpaqueEn res = mineralOpaqueEn.addOpaqueMineral(mo);
        return new ResponseEntity<MineralOpaqueEn>(res, HttpStatus.CREATED);
    }

    @GetMapping("en/opaqueminerals/{idMineral}")
    public ResponseEntity<?> checkOpaqueMineralEn(@PathVariable int idMineral) {
        MineralOpaqueEn res = mineralOpaqueEn.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @DeleteMapping("en/opaqueminerals/{idMineral}")
    public ResponseEntity<?> deleteOpaqueMineralEn(@PathVariable int idMineral) {
        MineralOpaqueEn res = mineralOpaqueEn.deleteOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //OPAQUE MINERAL SAMPLES EN
    @GetMapping("en/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> listOpaqueSamplesEn(@PathVariable int idMineral) {
        MineralOpaqueEn res = mineralOpaqueEn.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getOpaqueSamplesList());
        }
    }

    @GetMapping("en/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> checkOpaqueSampleEn(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueEn res1 = mineralOpaqueEn.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueEn res2 = mineralSampleOpaqueEn.checkOpaqueSample(idSample);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("en/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> createOpaqueSampleEn(@PathVariable int idMineral, @RequestBody MineralSampleOpaqueEn mso){
        MineralOpaqueEn res2 = mineralOpaqueEn.checkOpaqueMineral(idMineral);
        if (res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mso.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaqueEn res3 = mineralSampleOpaqueEn.addOpaqueSample(mso);
                return new ResponseEntity<MineralSampleOpaqueEn>(res3, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("en/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> modifyOpaqueSampleEn(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueEn res = mineralOpaqueEn.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueEn res2 = mineralSampleOpaqueEn.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaqueEn res3 = mineralSampleOpaqueEn.modifyOpaqueSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("en/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> deleteOpaqueSampleEn(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueEn res = mineralOpaqueEn.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueEn res2 = mineralSampleOpaqueEn.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mineralSampleOpaqueEn.deleteOpaqueSample(idSample) == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //OPAQUE MINERALS SP
    @GetMapping("sp/opaqueminerals")
    public ResponseEntity<?> listOpaqueMineralsSp(@PathVariable String language) {
        if (mineralOpaqueSp.listOpaqueMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralOpaqueSp.listOpaqueMinerals());
    }

    @PostMapping("sp/opaqueminerals")
    public ResponseEntity<?> createOpaqueMineralSp(@RequestBody MineralOpaqueSp mo){
        MineralOpaqueSp res = mineralOpaqueSp.addOpaqueMineral(mo);
        return new ResponseEntity<MineralOpaqueSp>(res, HttpStatus.CREATED);
    }

    @GetMapping("sp/opaqueminerals/{idMineral}")
    public ResponseEntity<?> checkOpaqueMineralSp(@PathVariable int idMineral) {
        MineralOpaqueSp res = mineralOpaqueSp.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @DeleteMapping("sp/opaqueminerals/{idMineral}")
    public ResponseEntity<?> deleteOpaqueMineralSp(@PathVariable int idMineral) {
        MineralOpaqueSp res = mineralOpaqueSp.deleteOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //OPAQUE MINERAL SAMPLES SP
    @GetMapping("sp/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> listOpaqueSamplesSp(@PathVariable int idMineral) {
        MineralOpaqueSp res = mineralOpaqueSp.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getOpaqueSamplesList());
        }
    }

    @GetMapping("sp/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> checkOpaqueSampleSp(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueSp res1 = mineralOpaqueSp.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueSp res2 = mineralSampleOpaqueSp.checkOpaqueSample(idSample);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("sp/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> createOpaqueSampleSp(@PathVariable int idMineral, @RequestBody MineralSampleOpaqueSp mso){
        MineralOpaqueSp res2 = mineralOpaqueSp.checkOpaqueMineral(idMineral);
        if (res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mso.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaqueSp res3 = mineralSampleOpaqueSp.addOpaqueSample(mso);
                return new ResponseEntity<MineralSampleOpaqueSp>(res3, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("sp/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> modifyOpaqueSampleSp(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueSp res = mineralOpaqueSp.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueSp res2 = mineralSampleOpaqueSp.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaqueSp res3 = mineralSampleOpaqueSp.modifyOpaqueSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("sp/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> deleteOpaqueSampleSp(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueSp res = mineralOpaqueSp.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueSp res2 = mineralSampleOpaqueSp.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mineralSampleOpaqueSp.deleteOpaqueSample(idSample) == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //OPAQUE MINERALS CA
    @GetMapping("ca/opaqueminerals")
    public ResponseEntity<?> listOpaqueMineralsCa(@PathVariable String language) {
        if (mineralOpaqueCa.listOpaqueMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralOpaqueCa.listOpaqueMinerals());
    }

    @PostMapping("ca/opaqueminerals")
    public ResponseEntity<?> createOpaqueMineralCa(@RequestBody MineralOpaqueCa mo){
        MineralOpaqueCa res = mineralOpaqueCa.addOpaqueMineral(mo);
        return new ResponseEntity<MineralOpaqueCa>(res, HttpStatus.CREATED);
    }

    @GetMapping("ca/opaqueminerals/{idMineral}")
    public ResponseEntity<?> checkOpaqueMineralCa(@PathVariable int idMineral) {
        MineralOpaqueCa res = mineralOpaqueCa.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @DeleteMapping("ca/opaqueminerals/{idMineral}")
    public ResponseEntity<?> deleteOpaqueMineralCa(@PathVariable int idMineral) {
        MineralOpaqueCa res = mineralOpaqueCa.deleteOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //OPAQUE MINERAL SAMPLES CA
    @GetMapping("ca/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> listOpaqueSamplesCa(@PathVariable int idMineral) {
        MineralOpaqueCa res = mineralOpaqueCa.checkOpaqueMineral(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getOpaqueSamplesList());
        }
    }

    @GetMapping("ca/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> checkOpaqueSampleCa(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueCa res1 = mineralOpaqueCa.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueCa res2 = mineralSampleOpaqueCa.checkOpaqueSample(idSample);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("ca/opaqueminerals/{idMineral}/opaquesamples")
    public ResponseEntity<?> createOpaqueSampleCa(@PathVariable int idMineral, @RequestBody MineralSampleOpaqueCa mso){
        MineralOpaqueCa res2 = mineralOpaqueCa.checkOpaqueMineral(idMineral);
        if (res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mso.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaqueCa res3 = mineralSampleOpaqueCa.addOpaqueSample(mso);
                return new ResponseEntity<MineralSampleOpaqueCa>(res3, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("ca/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> modifyOpaqueSampleCa(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueCa res = mineralOpaqueCa.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueCa res2 = mineralSampleOpaqueCa.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getIdMineral() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleOpaqueCa res3 = mineralSampleOpaqueCa.modifyOpaqueSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("ca/opaqueminerals/{idMineral}/opaquesamples/{idSample}")
    public ResponseEntity<?> deleteOpaqueSampleCa(@PathVariable int idMineral, @PathVariable int idSample) {
        MineralOpaqueCa res = mineralOpaqueCa.checkOpaqueMineral(idMineral);
        MineralSampleOpaqueCa res2 = mineralSampleOpaqueCa.checkOpaqueSample(idSample);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (mineralSampleOpaqueCa.deleteOpaqueSample(idSample) == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //TRANSPARENT MINERALS EN
    @GetMapping("en/transparentminerals")
    public ResponseEntity<?> listTransparentMineralsEn() {
        if (mineralTransparentServiceEn.listTransparentMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralTransparentServiceEn.listTransparentMinerals());
    }

    @GetMapping("en/transparentminerals/{id}")
    public ResponseEntity<?> checkTransparentMineralEn(@PathVariable int id) {
        MineralTransparentEn res = mineralTransparentServiceEn.checkTransparentMinerals(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("en/transparentminerals")
    public ResponseEntity<?> createTransparentMineralEn(@RequestBody MineralTransparentEn newMineral){
        MineralTransparentEn res = mineralTransparentServiceEn.addTransparentMinerals(newMineral);
        return new ResponseEntity<MineralTransparentEn>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("en/transparentminerals/{id}")
    public ResponseEntity<?> deleteTransparentMineralEn(@PathVariable int id) {
        MineralTransparentEn res = mineralTransparentServiceEn.deleteTransparentMineral(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //TRANSPARENT MINERALS SAMPLES EN
    @GetMapping("en/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> listTransparentSamplesEn(@PathVariable int idMineral) {
        MineralTransparentEn res = mineralTransparentServiceEn.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getSampleList());
        }
    }

    @GetMapping("en/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> checkTransparentSampleEn(@PathVariable int idMineral, @PathVariable int id) {
        MineralTransparentEn res1 = mineralTransparentServiceEn.checkTransparentMinerals(idMineral);
        MineralSampleTransparentEn res2 = mineralSampleTransparentServiceEn.checkTransparentSample(id);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("en/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> createTransparentSampleEn(@PathVariable int idMineral, @RequestBody MineralSampleTransparentEn newSample){
        MineralTransparentEn res = mineralTransparentServiceEn.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            if (newSample.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparentEn res2 = mineralSampleTransparentServiceEn.addTransparentSample(newSample);
                return new ResponseEntity<MineralSampleTransparentEn>(res2, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("en/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> modifyTransparentSampleEn(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparentEn res = mineralTransparentServiceEn.checkTransparentMinerals(idMineral);
        MineralSampleTransparentEn res2 = mineralSampleTransparentServiceEn.checkTransparentSample(id);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparentEn res3 = mineralSampleTransparentServiceEn.modifyTransparentSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("en/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> deleteTransparentSampleEn(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparentEn res = mineralTransparentServiceEn.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            MineralSampleTransparentEn res2 = mineralSampleTransparentServiceEn.deleteTransparentSample(id);
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //TRANSPARENT MINERALS SP
    @GetMapping("sp/transparentminerals")
    public ResponseEntity<?> listTransparentMineralsSp() {
        if (mineralTransparentServiceSp.listTransparentMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralTransparentServiceSp.listTransparentMinerals());
    }

    @GetMapping("sp/transparentminerals/{id}")
    public ResponseEntity<?> checkTransparentMineralSp(@PathVariable int id) {
        MineralTransparentSp res = mineralTransparentServiceSp.checkTransparentMinerals(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("sp/transparentminerals")
    public ResponseEntity<?> createTransparentMineralSp(@RequestBody MineralTransparentSp newMineral){
        MineralTransparentSp res = mineralTransparentServiceSp.addTransparentMinerals(newMineral);
        return new ResponseEntity<MineralTransparentSp>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("sp/transparentminerals/{id}")
    public ResponseEntity<?> deleteTransparentMineralSp(@PathVariable int id) {
        MineralTransparentSp res = mineralTransparentServiceSp.deleteTransparentMineral(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //TRANSPARENT MINERALS SAMPLES SP
    @GetMapping("sp/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> listTransparentSamplesSp(@PathVariable int idMineral) {
        MineralTransparentSp res = mineralTransparentServiceSp.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getSampleList());
        }
    }

    @GetMapping("sp/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> checkTransparentSampleSp(@PathVariable int idMineral, @PathVariable int id) {
        MineralTransparentSp res1 = mineralTransparentServiceSp.checkTransparentMinerals(idMineral);
        MineralSampleTransparentSp res2 = mineralSampleTransparentServiceSp.checkTransparentSample(id);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("sp/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> createTransparentSampleSp(@PathVariable int idMineral, @RequestBody MineralSampleTransparentSp newSample){
        MineralTransparentSp res = mineralTransparentServiceSp.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            if (newSample.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparentSp res2 = mineralSampleTransparentServiceSp.addTransparentSample(newSample);
                return new ResponseEntity<MineralSampleTransparentSp>(res2, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("sp/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> modifyTransparentSampleSp(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparentSp res = mineralTransparentServiceSp.checkTransparentMinerals(idMineral);
        MineralSampleTransparentSp res2 = mineralSampleTransparentServiceSp.checkTransparentSample(id);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparentSp res3 = mineralSampleTransparentServiceSp.modifyTransparentSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("sp/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> deleteTransparentSampleSp(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparentSp res = mineralTransparentServiceSp.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            MineralSampleTransparentSp res2 = mineralSampleTransparentServiceSp.deleteTransparentSample(id);
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }

    //TRANSPARENT MINERALS CA
    @GetMapping("ca/transparentminerals")
    public ResponseEntity<?> listTransparentMineralsCa() {
        if (mineralTransparentServiceCa.listTransparentMinerals() == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(mineralTransparentServiceCa.listTransparentMinerals());
    }

    @GetMapping("ca/transparentminerals/{id}")
    public ResponseEntity<?> checkTransparentMineralCa(@PathVariable int id) {
        MineralTransparentCa res = mineralTransparentServiceCa.checkTransparentMinerals(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    @PostMapping("ca/transparentminerals")
    public ResponseEntity<?> createTransparentMineralCa(@RequestBody MineralTransparentCa newMineral){
        MineralTransparentCa res = mineralTransparentServiceCa.addTransparentMinerals(newMineral);
        return new ResponseEntity<MineralTransparentCa>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("ca/transparentminerals/{id}")
    public ResponseEntity<?> deleteTransparentMineralCa(@PathVariable int id) {
        MineralTransparentCa res = mineralTransparentServiceCa.deleteTransparentMineral(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.noContent().build();
    }

    //TRANSPARENT MINERALS SAMPLES CA
    @GetMapping("ca/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> listTransparentSamplesCa(@PathVariable int idMineral) {
        MineralTransparentCa res = mineralTransparentServiceCa.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(res.getSampleList());
        }
    }

    @GetMapping("ca/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> checkTransparentSampleCa(@PathVariable int idMineral, @PathVariable int id) {
        MineralTransparentCa res1 = mineralTransparentServiceCa.checkTransparentMinerals(idMineral);
        MineralSampleTransparentCa res2 = mineralSampleTransparentServiceCa.checkTransparentSample(id);
        if (res1 == null) return ResponseEntity.notFound().build();
        else {
            if (res2 == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res2);
        }
    }

    //si es pot crear es retorna CREATED
    @PostMapping("ca/transparentminerals/{idMineral}/transparentsamples")
    public ResponseEntity<?> createTransparentSampleCa(@PathVariable int idMineral, @RequestBody MineralSampleTransparentCa newSample){
        MineralTransparentCa res = mineralTransparentServiceCa.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            if (newSample.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparentCa res2 = mineralSampleTransparentServiceCa.addTransparentSample(newSample);
                return new ResponseEntity<MineralSampleTransparentCa>(res2, HttpStatus.CREATED);
            }
        }
    }

    @PutMapping("ca/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> modifyTransparentSampleCa(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparentCa res = mineralTransparentServiceCa.checkTransparentMinerals(idMineral);
        MineralSampleTransparentCa res2 = mineralSampleTransparentServiceCa.checkTransparentSample(id);
        if (res == null || res2 == null) return ResponseEntity.notFound().build();
        else {
            if (res2.getMineralId() != idMineral) return ResponseEntity.notFound().build();
            else {
                MineralSampleTransparentCa res3 = mineralSampleTransparentServiceCa.modifyTransparentSample(res2);
                return ResponseEntity.ok(res3);}
        }
    }

    @DeleteMapping("ca/transparentminerals/{idMineral}/transparentsamples/{id}")
    public ResponseEntity<?> deleteTransparentSampleCa(@PathVariable int idMineral,@PathVariable int id) {
        MineralTransparentCa res = mineralTransparentServiceCa.checkTransparentMinerals(idMineral);
        if (res == null) return ResponseEntity.notFound().build();
        else {
            MineralSampleTransparentCa res2 = mineralSampleTransparentServiceCa.deleteTransparentSample(id);
            if (res2 == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.noContent().build();
        }
    }
}