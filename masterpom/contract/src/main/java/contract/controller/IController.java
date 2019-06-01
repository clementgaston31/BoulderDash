package contract.controller;

public interface IController {

	void play() throws InterruptedException;
	
	IOrderPerformer getOrderPerformer();
}
