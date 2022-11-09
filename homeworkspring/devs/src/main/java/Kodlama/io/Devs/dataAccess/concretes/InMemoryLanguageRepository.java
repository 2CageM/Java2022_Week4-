package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Repository // bu sınıf bir data access nesnesidir.
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "Phyton"));
		languages.add(new Language(3, "C#"));
	}

	@Override
	public List<Language> getAll() {
		return languages;

	}

	@Override
	public Language getById(int id) {

		for (Language language : languages) {

			if (language.getId() == id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public void add(Language language) {
		languages.add(language);

	}

	@Override
	public void delete(int id) {
		
		for (Language lang1 : languages) {
			if (lang1.getId() == id) {
				languages.remove(id);
			}
		}

	}

	@Override
	public void update(int id, Language language) {

		Language lang1 = getById(language.getId());
		lang1.setName(language.getName());

	}

	@Override
	public boolean isValid(Language language) {

		return false;
	}

}
