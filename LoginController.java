package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/Login_Controller")
public class LoginController
{
	@Autowired
	LoginDAO ldao;
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView LogCheck()
	{
		Register r = new Register();
		
		return new ModelAndView("LogIn","logObj",r);		
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView check(Register reg, HttpServletResponse response) throws IOException
	{
		boolean b = ldao.checkLogin(reg);
		if(b)
			return new ModelAndView("redirect:/first.do");
		else
			return null;
	}
	
	
}
