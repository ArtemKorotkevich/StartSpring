package by.andersen.service;

import by.andersen.dao.DictionaryDao;
import by.andersen.model.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryDao dictionaryDao;

    @Autowired
    public void setDictionaryDao(DictionaryDao dictionaryDao) {
        this.dictionaryDao = dictionaryDao;
    }

    public int save(Dictionary dictionary) {
        return dictionaryDao.save(dictionary);
    }

    public Dictionary getDictionary(int id) {
        return dictionaryDao.getDictionary(id);
    }

    public List<Dictionary> list() {
        return dictionaryDao.list();
    }

    public void update(Dictionary dictionary) {
        dictionaryDao.update(dictionary);
    }

    public void delete(int id) {
        dictionaryDao.delete(id);
    }
}
