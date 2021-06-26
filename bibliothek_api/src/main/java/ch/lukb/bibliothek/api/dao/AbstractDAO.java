package ch.lukb.bibliothek.api.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class AbstractDAO<T> implements DAOInterface<T>{

    @PersistenceContext
    EntityManager entityManager;

    protected abstract Class<T> getClazz();

    public T findOne(Long id) {
        return getEntityManager().find(getClazz(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + getClazz().getName()).getResultList();
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public void deleteById(Long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}