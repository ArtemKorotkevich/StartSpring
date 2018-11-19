package by.andersen.dao;

import by.andersen.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory (SessionFactory sessionFactory ){
        this.sessionFactory = sessionFactory;
    }

    public int save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    public User get(int id) {
       return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }

    public void update(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
        user1.setLogin(user.getLogin());
        user1.setPass(user.getPass());
        session.flush();

    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);

    }
}
