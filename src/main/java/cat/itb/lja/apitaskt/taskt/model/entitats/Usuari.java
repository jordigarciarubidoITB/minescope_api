package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Usuari{
    @Id
    @GeneratedValue (generator = "item_sequence")
    @SequenceGenerator(name="item_sequence", sequenceName = "db_item_sequence", allocationSize = 1)
    private int idUsuari;
    private String nomUsuari;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuari")
    private List<Llista> llistaLlista;
}
