package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Item {
    @Id
    private int idItem;
    @Id
    private int idLlista;
    private String nomItem;
    private boolean isChecked;
}
