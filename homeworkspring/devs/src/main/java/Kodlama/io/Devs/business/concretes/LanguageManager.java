package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service // bu sınıf bir business nesnesidir.
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {

		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {

		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		
		if(language.getName().isEmpty()) {
			
			throw new Exception("The language cant be empty");
		}
		else if(this.isValid(language)) {
			
			throw new Exception("Language already exist");}
		
			else {
				languageRepository.add(language);
			}
			
				
			
		
	}

	@Override
	public void delete(int id) {
	
		languageRepository.delete(id);

	}

	@Override
	public void update(int id, Language language) {
		languageRepository.update(id, language);
		
		

	}

	@Override
	public boolean isValid(Language language) {
		
		for(Language language1:getAll()) {
			
			if(language1.getName().equalsIgnoreCase(language.getName())) {
				return false;
			}
		}
		return true;
	}

}
