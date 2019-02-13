package klimapps.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "article", schema = "klimapps")
public class Article {


    @Id
    @Column(name = "articleid")
    @GeneratedValue(strategy = IDENTITY)
    private int articleid;

    @Column(name = "name")
    private String name;

    @Column(name = "EAN")
    private Integer ean;

    @Column(name = "internal_name")
    private String internalName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private Set<StoredArticle> storedArticleSet = new HashSet<>(0);


    public Article() {
    }

    public Article(String name, Integer ean, String internalName) {
        this.name = name;
        this.ean = ean;
        this.internalName = internalName;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEan() {
        return ean;
    }

    public void setEan(Integer ean) {
        this.ean = ean;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public Set<StoredArticle> getStoredArticleSet() {
        return storedArticleSet;
    }

    public void setStoredArticleSet(Set<StoredArticle> storedArticleSet) {
        this.storedArticleSet = storedArticleSet;
    }
}
