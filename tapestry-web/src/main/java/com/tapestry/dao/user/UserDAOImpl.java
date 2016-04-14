package com.tapestry.dao.user;

import com.tapestry.controllers.exceptions.NonexistentEntityException;
import com.tapestry.entities.User;


import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Home
 */
@Component
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UserDAOImpl.class);

    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public UserDAOImpl() {

        emf = Persistence.createEntityManagerFactory("tapestryPU");
    }

    @Override
    public Long getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult());
        } finally {
            em.close();
        }

    }

    @Override
    public List<User> getList(Integer start, Integer max) {
        EntityManager em = getEntityManager();
        List<User> finalList = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM User c WHERE c.id > 0 ORDER BY c.id DESC");
            if (start != null) {
                query.setFirstResult(start);
            }
            if (max != null) {
                query.setMaxResults(max);
            }
            finalList = query.getResultList();

            if (finalList == null) {
                return null;
            }
            em.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            em.close();
        }

        return finalList;
    }

    @Override
    public Long save(User entity) {
        Date currentDate = new Date(System.currentTimeMillis());
        EntityManager em = getEntityManager();
        Long id = 0L;
        try {
            em.getTransaction().begin();
           
            entity.setRegistereddate(new Date(System.currentTimeMillis()));
            em.persist(entity);
            em.flush();
            id = entity.getId();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User entity = null;
            try {
                entity = em.getReference(User.class, id);
                entity.getId();
            } catch (EntityNotFoundException enfe) {
            }
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean delete(Long id) {
        this.destroy(id);
        return true;
    }

    @Override
    public boolean update(User entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = entity.getId();
                if (getById(id) == null) {
                    try {
                        throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
                    } catch (NonexistentEntityException ex1) {

                    }
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    @Override
    public User getById(Long id) {
        EntityManager em = getEntityManager();
        try {
            User entity = em.find(User.class, id);

            return entity;
        } finally {
            em.close();
        }
    }

    @Override
    public User getByEmail(String email) {
        EntityManager em = getEntityManager();
        User entity = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT c FROM User c WHERE c.email=:email").setParameter("email", email);
            entity = (User) query.getSingleResult();

            em.getTransaction().commit();
            if (entity == null) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return entity;
    }

}
