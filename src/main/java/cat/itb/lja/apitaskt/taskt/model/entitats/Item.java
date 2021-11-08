package cat.itb.lja.apitaskt.taskt.model.entitats;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    private int idItem;
    @ManyToOne
    @JoinColumn(name="idLlista", insertable = false, updatable = false)
    private int idLlista;
    private String nomItem;
    private boolean isChecked;


}
