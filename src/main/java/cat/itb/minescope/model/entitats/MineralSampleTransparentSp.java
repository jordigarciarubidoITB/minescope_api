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
    private int mineralId;

    @Column(unique = true)
    private String imageLpna;
    private String imageLpa;
    private String name;
    private String crystalShape;
    private String relief;
    private String color;
    private String pleochroism;
    private String cleavage;
    private String alteration;
    private String interferenceColorOrder;
    private String extinction;
    private String twinning;
    private String zonation;
    private String abundance;
    private String otherMinerals;
}
