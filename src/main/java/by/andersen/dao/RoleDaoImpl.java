package by.andersen.dao;

import by.andersen.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
@Transactional
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
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        cq.select(root);
        Query<Role> query = session.createQuery(cq);
        return query.getResultList();
    }

    public void update(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    public void delete(int id) {
       Session session = sessionFactory.getCurrentSession();
       session.delete(session.get(Role.class, id));
    }
}
