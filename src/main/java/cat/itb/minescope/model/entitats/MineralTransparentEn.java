package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MineralTransparentEn {
    @Id
    @GeneratedValue(generator = "mineral_transparent_sequence")
    @SequenceGenerator(name="mineral_transparent_sequence", sequenceName = "db_transparent_mineral_sequence", allocationSize = 1)
    private int id;

    @Column(unique = true)
    private String nom;
    private String relleu;
    private String colors;
    private String pleocroisme;
    private String nom_dir_exfoliacio;
    private String angle_dir_exfoliacio;
    private String colors_interferencia;
    private String extincio;
    private String maclat;
    private String figura_interferencia;
    private String signe_optic;
    private String formula;
    private String forma_cristalls;
    private String alteracio;
    private String zonacio;
    private String exfoliacio;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mineral")
    private List<MineralSampleTransparentEn> sampleList;
}
