package klimapps.entity;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "status", schema = "jetpack_klimapps")
public class Status {

    public static final int PRZYGOTOWANY = 1;
    public static final int WYSLANO_NA_MAGAZYN = 2;
    public static final int MAGAZYN = 3;
    public static final int SPRZEDANE = 4;
    public static final int WYSLANE = 5;

    @Id
    @Column(name = "statusid")
    @GeneratedValue(strategy = IDENTITY)
    private Integer statusid;

    @Column(name = "nazwa")
    private String nazwa;

    @OneToMany(targetEntity = Ciuch.class, mappedBy = "status")
    private List<Ciuch> ciuches;

    public Status() {
    }

    public Status(String storageName) {
        this.nazwa = storageName;

    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

}
