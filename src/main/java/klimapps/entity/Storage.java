package klimapps.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "storage", schema = "klimapps")
public class Storage {


    @Id
    @Column(name = "storageid")
    @GeneratedValue(strategy = IDENTITY)
    private Integer storageid;

    @Column(name = "storage_name")
    private String storageName;

    @Column(name = "localization")
    private String localization;

    public Storage() {
    }

    public Storage(String storageName, String localization) {
        this.storageName = storageName;
        this.localization = localization;
    }

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

}
