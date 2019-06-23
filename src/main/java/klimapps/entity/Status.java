package klimapps.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "status", schema = "lumpex")
public class Status {


    @Id
    @Column(name = "statusid")
    @GeneratedValue(strategy = IDENTITY)
    private Integer statusid;

    @Column(name = "nazwa")
    private String nazwa;

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
