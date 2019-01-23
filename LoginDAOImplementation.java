package servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class LoginDAOImplementation implements LoginDAO
{

	@Autowired
	HibernateTemplate template;
	
	@Override
	public boolean checkLogin(Register register) {
		@SuppressWarnings("unchecked")
		List<Register> mylist=(List<Register>) template.find("from Register where userId = ? and password=?", register.getUserId(),register.getPassword());
		int nor = mylist.size();
		if(nor==1)
			return true;
		else
			return false;
	}
}
