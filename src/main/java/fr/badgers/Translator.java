package fr.badgers;

import java.util.HashMap;

public class Translator {
	// Dictionnary
	HashMap<String, HashMap<String, String>> dict = new HashMap<String, HashMap<String, String>>();
	
	// Locale
	private String locale;
	
	public Translator(String locale) {
		this.locale = locale;
		populateDict();
	}
	
	public String translate(String s) {
		if(!dict.containsKey(s)) return "!MissingTranslation!";
		if(!dict.get(s).containsKey(locale)) return "!MissingTranslation!";
		return (String) dict.get(s).get(locale);
	}
	
	/**
	 * Populate the translator dictionnary
	 */
	private void populateDict() {
		HashMap<String, String> t;
				
		t = new HashMap<String, String>();
		t.put("fr_FR", "Gestion Portuaire");
		dict.put("MainWindow.title", t);
	}
	
	/**
	 * Return the defined locale
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Set the locale in which the string will be translated
	 * @param locale the locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
}