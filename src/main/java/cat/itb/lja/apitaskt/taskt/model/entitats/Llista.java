package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Llista {
    @Id
    private int idLlista;
    private String nomLlista;

    @OneToMany(mappedBy = "llista")
    @JoinTable(name = "item")
    private List<Item> items;
}
