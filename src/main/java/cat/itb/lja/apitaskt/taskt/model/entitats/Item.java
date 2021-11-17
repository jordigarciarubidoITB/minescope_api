package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue
    private int idItem;
    private int idLlista;
    private String nomItem;
    private int position;
    private boolean isChecked;
}
