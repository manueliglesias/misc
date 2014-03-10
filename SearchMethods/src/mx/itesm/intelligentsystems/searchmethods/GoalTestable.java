package mx.itesm.intelligentsystems.searchmethods;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;

public interface GoalTestable<S extends IState> {

	public boolean goalTest(S testState);

}
