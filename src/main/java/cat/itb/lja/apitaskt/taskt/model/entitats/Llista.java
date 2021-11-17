package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
public class Llista {
    @Id
    @GeneratedValue (generator = "list_sequence")
    @SequenceGenerator(name="list_sequence", sequenceName = "db_list_sequence", allocationSize = 1)
    private int idLlista;
    private String nomLlista;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLlista")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Item> llistaItem;
}
