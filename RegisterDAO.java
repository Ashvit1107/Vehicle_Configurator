package servlet;

import java.util.List;


public interface RegisterDAO
{
	void register(Register ref);
	List<Register> viewAll();
	
}
