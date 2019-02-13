package klimapps.dao;

import klimapps.entity.StoredArticle;

import java.util.List;

public interface StoredarticleDAO {

    List<StoredArticle> getStoredarticles();

    void saveStoredarticle(StoredArticle storedarticle);

    void deleteStoredarticle(Integer storedarticleId);

    StoredArticle getStoredarticle(int storedarticleId);
}
