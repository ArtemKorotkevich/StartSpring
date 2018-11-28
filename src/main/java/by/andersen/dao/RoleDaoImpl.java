package by.andersen.dao;

import by.andersen.model.Dictionary;
import by.andersen.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public int save(Role role) {
        sessionFactory.getCurrentSession().save(role);
        return role.getId();
    }

    public Role getRole(int id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }
// check this method!
    public List<Role> list() {
        List list = sessionFactory.getCurrentSession().createQuery("from Role").list();
        return list;
    }

    public void update(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    public void delete(int id) {
       Session session = sessionFactory.getCurrentSession();
       session.delete(session.get(Role.class, id));
    }
}
