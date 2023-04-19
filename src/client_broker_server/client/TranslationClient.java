package client_broker_server.client;

import client_broker_server.common.Service;
import client_broker_server.common.TranslationService;

public class TranslationClient extends Client {

	private static final String WORD_TO_TRANSLATE = "Dog";

	private TranslationService translationService;


	@Override
	public void callServer() {
		translateWord(WORD_TO_TRANSLATE, TranslationService.LANGUAGE_GERMAN);
		translateWord(WORD_TO_TRANSLATE, TranslationService.LANGUAGE_FRENCH);
	}

	public void translateWord(String word, String language) {
		configureTranslator(language);
		System.out.println();
		System.out.println("Translating " + word + " to " + language);
		String translation = translationService.translate(word, language);
		System.out.println(word + " in " + language + " translates to: " + translation);
	}

	private void configureTranslator(String language) {
		String serviceName = switch (language) {
			case TranslationService.LANGUAGE_GERMAN -> TranslationService.SERVICE_NAME_TRANSLATION_GERMAN;
			case TranslationService.LANGUAGE_FRENCH -> TranslationService.SERVICE_NAME_TRANSLATION_FRENCH;
			default -> throw new IllegalArgumentException(language + " is an unsupported language");
		};

		Service service = getBroker().getService(serviceName);
		if (service instanceof TranslationService) {
			this.translationService = (TranslationService) service;
		} else {
			throw new IllegalStateException("Broker returned incorrect proxy for service.");
		}
	}

}
