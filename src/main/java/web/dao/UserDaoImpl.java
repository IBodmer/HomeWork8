package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }


    @Override
    public void update(Long id, User user) {
        User user1 = entityManager.find(User.class, id);
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setLast_name(user.getLast_name());
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
        entityManager.merge(user1);
    }


    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

}