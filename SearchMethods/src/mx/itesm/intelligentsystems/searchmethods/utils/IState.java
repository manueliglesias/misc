package mx.itesm.intelligentsystems.searchmethods.utils;

import java.util.List;

public interface IState {

	public List<IState> expand();

	public boolean isValid();

}
