package cat.itb.minescope.model.entitats;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Llista {
    @Id
    @GeneratedValue (generator = "list_sequence")
    @SequenceGenerator(name="list_sequence", sequenceName = "db_list_sequence", allocationSize = 1)
    private int idLlista;
    private int idUsuari;
    private String nomLlista;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLlista")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Item> llistaItem;
}
