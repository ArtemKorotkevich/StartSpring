package by.andersen.service;

import by.andersen.model.Dictionary;

import java.util.List;

public interface DictionaryService {

    int save (Dictionary dictionary);
    Dictionary getDictionary(int id);
    List<Dictionary> list();
    void update(Dictionary dictionary);
    void delete(int id);
}
