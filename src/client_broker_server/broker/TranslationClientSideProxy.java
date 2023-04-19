package client_broker_server.broker;

import client_broker_server.common.TranslationService;

public class TranslationClientSideProxy extends ClientSideProxy implements TranslationService {

	public TranslationClientSideProxy(Broker broker) {
		super(broker);
	}

	public String translate(String word, String language) {
		if (language.equals(TranslationService.LANGUAGE_GERMAN)) {
			return this.sendRequest(TranslationService.SERVICE_NAME_TRANSLATION_GERMAN, word);
		} else if (language.equals(TranslationService.LANGUAGE_FRENCH)) {
			return this.sendRequest(TranslationService.SERVICE_NAME_TRANSLATION_FRENCH, word);
		} else {
			return "@#+*!�";
		}
	}

}
