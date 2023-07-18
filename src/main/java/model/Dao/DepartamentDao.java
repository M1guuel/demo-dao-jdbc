
package model.Dao;

import java.util.List;

/**
 *
 * @author gueel
 */
public interface DepartamentDao {
    void insert(DepartamentDao obj);
    void update(DepartamentDao obj);
    void deleteById(Integer id);
    DepartamentDao fidById(Integer id);
    List<DepartamentDao> findAll();
}
