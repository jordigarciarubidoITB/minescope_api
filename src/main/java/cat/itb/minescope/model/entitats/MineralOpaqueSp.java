package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MineralOpaqueSp {
    @Id
    @GeneratedValue (generator = "mineralopaque_sequence")
    @SequenceGenerator(name="mineralopaque_sequence", sequenceName = "db_user_sequence", allocationSize = 1)
    private int idMineral;
    @Column(unique = true)
    private String name;
    private String chemicalFormula;
    private String color;
    private String reflectance;
    private String pleochroism;
    private String polishingHardness;
    private String polishingCleavage;
    private String anisotropism;
    private String interference_colors;
    private String internalReflections;
    private String associatedMinerals;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMineral")
    private List<MineralSampleOpaqueSp> opaqueSamplesList;
}
