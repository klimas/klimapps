package klimapps.entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "storedarticle", schema = "klimapps")
public class StoredArticle {

    @Id
    @Column(name = "storedarticleid")
    @GeneratedValue(strategy = IDENTITY)
    private Integer storedarticleid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    private Article article;


    @Column(name = "purchase_price")
    private Double purchasePrice;


    @Column(name = "sell_date")
    private Date sellDate;


    @Column(name = "amount")
    private Integer amount;


    @Column(name = "date_in")
    private Date dateIn;


    @Column(name = "date_out")
    private Date dateOut;


    public Integer getStoredarticleid() {
        return storedarticleid;
    }

    public void setStoredarticleid(Integer storedarticleid) {
        this.storedarticleid = storedarticleid;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

}
