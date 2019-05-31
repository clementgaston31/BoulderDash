package contract.controller;

import java.io.IOException;

import controller.UserOrder;

public interface IOrderPerformer {

	void orderPerform(UserOrder userOrder) throws IOException;

}
