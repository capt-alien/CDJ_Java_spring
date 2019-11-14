package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.models.Language;
import com.repositories.LanguageRepository;


@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language findLanguage(long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
	
	public Language addLanguage(Language l) {
		return languageRepository.save(l);
	}
	public void deleteLanguage(long id) {
    	languageRepository.deleteById(id);
	}
	
//END LANG SERVICE
}
