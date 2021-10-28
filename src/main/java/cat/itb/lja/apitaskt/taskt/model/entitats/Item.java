package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    private int idItem;
    private String nomItem;
    private boolean isChecked;

}
