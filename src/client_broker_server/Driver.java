package client_broker_server;

import client_broker_server.broker.Broker;
import client_broker_server.client.DictionaryClient;
import client_broker_server.client.TranslationClient;
import client_broker_server.server.DictionaryServer;
import client_broker_server.server.TranslationServer;

public final class Driver {

	private Driver() {
	}

	public static void main(String[] args) {

		Broker broker = new Broker();

		DictionaryClient dictionaryClient = new DictionaryClient();
		TranslationClient translationClient = new TranslationClient();
		translationClient.setBroker(broker);
		dictionaryClient.setBroker(broker);
		
		DictionaryServer dictionaryServer = new DictionaryServer(Broker.SERVER_NAME_DICTIONARY);
		TranslationServer translationServer = new TranslationServer(Broker.SERVER_NAME_TRANSLATION);
		dictionaryServer.setBroker(broker);
		translationServer.setBroker(broker);
		
		translationClient.callServer();
		dictionaryClient.callServer();
		
	}
}
