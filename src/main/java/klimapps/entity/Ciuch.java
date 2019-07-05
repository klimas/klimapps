package klimapps.entity;

import klimapps.IndexPrefix;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ciuchy", schema = "jetpack_klimapps")
public class Ciuch {


    @Id
    @Column(name = "idciuchy")
    @GeneratedValue(strategy = IDENTITY)
    private Integer ciuchid;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "ciuch_index")
    private String index;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_statusid")
    private Status status;

    @Column(name = "nr_listu")
    private Integer nrListu;


    @Column(name = "wymiary_paczki")
    private String wymiaryPaczki;

    @Column(name = "list_pdf")
    private byte[] listPDF;

    @Column(name = "foto")
    private byte[] foto;

    public Integer getCiuchid() {
        return ciuchid;
    }

    public void setCiuchid(Integer ciuchid) {
        this.ciuchid = ciuchid;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getNrListu() {
        return nrListu;
    }

    public void setNrListu(Integer nrListu) {
        this.nrListu = nrListu;
    }

    public String getWymiaryPaczki() {
        return wymiaryPaczki;
    }

    public void setWymiaryPaczki(String wymiaryPaczki) {
        this.wymiaryPaczki = wymiaryPaczki;
    }

    public byte[] getListPDF() {
        return listPDF;
    }

    public void setListPDF(byte[] listPDF) {
        this.listPDF = listPDF;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Ciuch() {
        this.index= IndexPrefix.dateToIndexPrefix();
    }


}
