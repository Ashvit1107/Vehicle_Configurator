package servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RegisterController {

	@Autowired
	RegisterDAO sdao;
	@Transactional
	@RequestMapping(value="/RegisterController", method = RequestMethod.GET)
	public ModelAndView AddRecord()
	{
		Register r = new Register();
		return new ModelAndView("RegisterStu","registerRef",r);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String add(Register reg)
	{
		sdao.register(reg);
		return "Success";		
	}
	
	
	@RequestMapping(value="/ViewController", method = RequestMethod.GET)
	public ModelAndView ViewRecord()
	{
		@SuppressWarnings("rawtypes")
		List MyList = sdao.viewAll();
		
		return new ModelAndView("View","mylst",MyList);
	}
}
