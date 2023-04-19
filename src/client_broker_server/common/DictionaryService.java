package client_broker_server.common;

public interface DictionaryService extends Service {

	String SERVICE_NAME_DICTIONARY = "Dictionary service";

	String lookupWord(String word);

}
