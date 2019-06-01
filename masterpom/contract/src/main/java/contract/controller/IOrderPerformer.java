package contract.controller;

import java.io.IOException;

public interface IOrderPerformer {

	void orderPerform(UserOrder userOrder) throws IOException;

}
