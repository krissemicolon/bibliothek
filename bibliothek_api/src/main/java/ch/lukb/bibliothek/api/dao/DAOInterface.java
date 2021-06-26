package ch.lukb.bibliothek.api.dao;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Transactional
public interface DAOInterface<T> {

    public T findOne(Long id);

    public List<T> findAll();

    public T update(T entity);

    public void delete(T entity);

    public void deleteById(Long entityId);

    public EntityManager getEntityManager();

}
