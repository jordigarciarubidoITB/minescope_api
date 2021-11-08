package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Llista {
    @Id
    private int idLlista;
    private String nomLlista;

    //@OneToMany(cascade = CascadeType.REMOVE)
    //@JoinColumn(name = "idLLista")
    //private Set<Item> items;
}
