package klimapps.dao;

import klimapps.entity.Storage;

import java.util.List;

public interface StorageDAO {

    List<Storage> getStorages();

    void saveStorage(Storage storage);

    void deleteStorage(Integer storageId);

    Storage getStorage(int storageId);
}
