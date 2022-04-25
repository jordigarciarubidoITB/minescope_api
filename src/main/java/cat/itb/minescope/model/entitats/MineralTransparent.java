package cat.itb.minescope.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MineralTransparent {
    @Id
    @GeneratedValue(generator = "mineral_transparent_sequence")
    @SequenceGenerator(name="mineral_transparent_sequence", sequenceName = "db_transparent_mineral_sequence", allocationSize = 1)
    private int id;

    @Column(unique = true)
    private String name;
    private String relief;
    private String color;
    private String pleochroism;
    private String numberOfCleavageDirections;
    private String angleOfCleavage;
    private String interferenceColorOrder;
    private String extinction;
    private String twinning;
    private String interferenceFigure;
    private String opticalSign;
    private String chemicalFormula;
    private String crystalShape;
    private String alteration;
    private String zonation;
    private String cleavage;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "mineralId")
    private List<MineralSampleTransparent> sampleList;
}
