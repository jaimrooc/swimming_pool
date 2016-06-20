package co.com.jrojas.test.springRestAngular.model.exceptions;

import java.util.ArrayList;
import java.util.List;

public class BussinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<BussinessMessage> bussinessMessages = new ArrayList<>();

	public BussinessException(List<BussinessMessage> bussinessMessages) {
		this.bussinessMessages.addAll(bussinessMessages);
	}

	public BussinessException(BussinessMessage bussinessMessage) {
		this.bussinessMessages.add(bussinessMessage);
	}

	public List<BussinessMessage> getBussinessMessages() {
		return bussinessMessages;
	}
}