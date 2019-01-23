package servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class RegisterDAOImplementation implements RegisterDAO
{

	@Autowired
	HibernateTemplate template;
	
	@Override
	public void register(Register ref) {
		template.save(ref);
		
	}

	@Override
	public List<Register> viewAll() {
		
		@SuppressWarnings("unchecked")
		List<Register> mylist=(List<Register>) template.find("from Register");
		return mylist;		
	}

	

}
