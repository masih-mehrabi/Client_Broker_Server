package client_broker_server.broker;

import client_broker_server.common.DictionaryService;

public class DictionaryClientSideProxy extends ClientSideProxy implements DictionaryService {

	public DictionaryClientSideProxy(Broker broker) {
		super(broker);
	}

	public String lookupWord(String word) {
		return this.sendRequest(DictionaryService.SERVICE_NAME_DICTIONARY, word);
	}

}
