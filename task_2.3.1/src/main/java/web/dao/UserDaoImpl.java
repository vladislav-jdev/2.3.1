package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository()
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }


    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
