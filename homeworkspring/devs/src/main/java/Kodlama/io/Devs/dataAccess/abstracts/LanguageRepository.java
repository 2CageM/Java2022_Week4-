package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;



import Kodlama.io.Devs.entities.concretes.Language;


public interface LanguageRepository {
	
	
	
	List<Language> getAll();
	Language getById(int id);
	void add(Language language);
	void delete(int id);
	void update(int id,Language language);
	boolean isValid(Language language);
	

}
