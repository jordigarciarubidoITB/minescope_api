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
    @GeneratedValue (generator = "user_sequence")
    @SequenceGenerator(name="user_sequence", sequenceName = "db_user_sequence", allocationSize = 1)
    private int idUsuari;
    private String nomUsuari;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuari")
    private List<Llista> llistaLlista;
}
