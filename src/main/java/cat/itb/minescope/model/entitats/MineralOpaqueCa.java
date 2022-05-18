package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MineralOpaqueCa {
    @Id
    @GeneratedValue (generator = "mineralopaque_sequence")
    @SequenceGenerator(name="mineralopaque_sequence", sequenceName = "db_user_sequence", allocationSize = 1)
    private int id;
    @Column(unique = true)
    private String nom;
    private String colors;
    private String reflectivitat;
    private String pleocroisme;
    private String resistencia_polit;
    private String anisotropia;
    private String colors_interferencia;
    private String reflexions_internes;
    private String formula;
    private String exfoliacio_polit;
    private String minerals_associats;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mineral")
    private List<MineralSampleOpaqueCa> opaqueSamplesList;
}
