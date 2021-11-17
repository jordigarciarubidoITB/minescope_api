package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue (generator = "item_sequence")
    @SequenceGenerator(name="item_sequence", sequenceName = "db_item_sequence", allocationSize = 1)
    private int idItem;
    private int idLlista;
    private String nomItem;
    private int position;
    private boolean isChecked;
}
