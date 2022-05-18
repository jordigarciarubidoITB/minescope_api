package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MineralSampleOpaqueSp {
    @Id
    @GeneratedValue (generator = "mineralsampleopaque_sequence")
    @SequenceGenerator(name="mineralsampleopaque_sequence", sequenceName = "db_user_sequence", allocationSize = 1)
    private int id;
    private int id_mineral;
    private String lpna;
    private String lpa;
    @Column(unique = true)
    private String nom;
    private String coloracio;
    private String pleocroisme;
    private String abundancia;
    private String altres_minerals;
    private String forma;
    private String exfoliacio_polit;
    private String reflectivitat;
    private String resistencia_polit;
    private String anisotropia;
    private String colors_interferencia;
    private String reflexions_internes;
}
