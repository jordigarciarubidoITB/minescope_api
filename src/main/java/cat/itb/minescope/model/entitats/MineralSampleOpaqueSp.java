package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MineralSampleOpaqueSp {
    @Id
    @GeneratedValue (generator = "mineralsampleopaque_sequence")
    @SequenceGenerator(name="mineralsampleopaque_sequence", sequenceName = "db_user_sequence", allocationSize = 1)
    private int idSample;
    private int idMineral;
    @Column(unique = true)
    private String name;
    private String imageLpna;
    private String imageLpa;
    private String coloration;
    private String pleochroism;
    private String abundance;
    private String reflectance;
    private String otherMinerals;
    private String shape;
    private String polishingCleavage;
    private String reflectivity;
    private String polishingHardness;
    private String anisotropism;
    private String interferenceColors;
    private String internalReflections;
}
