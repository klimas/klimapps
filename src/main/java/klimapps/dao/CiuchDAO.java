package klimapps.dao;

import klimapps.entity.Ciuch;

import java.util.List;

public interface CiuchDAO {

    List<Ciuch> getCiuchy();

    List<Ciuch> getPrzygotowaneCiuchy();

    void saveCiuch(Ciuch ciuch);

    void deleteCiuch(Integer ciuchId);

    Ciuch getCiuch(int ciuchId);
}
