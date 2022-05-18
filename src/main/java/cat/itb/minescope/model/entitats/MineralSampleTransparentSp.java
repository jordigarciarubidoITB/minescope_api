package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MineralSampleTransparentSp {
    @Id
    @GeneratedValue(generator = "mineral_sample_transparent_sequence")
    @SequenceGenerator(name="mineral_sample_transparent_sequence", sequenceName = "db_mineral_sample_transparent_sequence", allocationSize = 1)
    private int id;
    private int id_mineral;

    @Column(unique = true)
    private String lpna;
    private String lpa;
    private String nom;
    private String forma_cristalls;
    private String relleu;
    private String color;
    private String pleocroisme;
    private String exfoliacio;
    private String alteracio;
    private String colors_interferencia;
    private String extincio;
    private String maclat;
    private String zonacio;
    private String abundancia;
    private String altres_minerals;
}
