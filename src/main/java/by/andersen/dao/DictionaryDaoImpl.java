package by.andersen.dao;

import by.andersen.model.Dictionary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DictionaryDaoImpl implements DictionaryDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public int save(Dictionary dictionary) {
        sessionFactory.getCurrentSession().save(dictionary);
        return dictionary.getId();
    }

    public Dictionary getDictionary(int id) {
        return sessionFactory.getCurrentSession().get(Dictionary.class,id);
    }
//check
    public List<Dictionary> list() {
        List list = sessionFactory.getCurrentSession().createQuery("from Dictionary").list();
        return list;
    }

    public void update(Dictionary dictionary) {
        sessionFactory.getCurrentSession().update(dictionary);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Dictionary.class, id));

    }
}
