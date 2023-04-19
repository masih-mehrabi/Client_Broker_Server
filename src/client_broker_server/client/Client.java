package client_broker_server.client;

import client_broker_server.broker.Broker;

public abstract class Client {

	private Broker broker;

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public abstract void callServer();

	protected Broker getBroker() {
		return broker;
	}
}
