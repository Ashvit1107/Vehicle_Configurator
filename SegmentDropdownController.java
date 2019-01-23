package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
@Controller
public class SegmentDropdownController
{
	@Autowired
	SegmentDAO Segmentd;
	
	
	@RequestMapping(value="/first",method = RequestMethod.GET)
	public ModelAndView before()	
	{
		Segment segmentObj=new Segment();
		List list=Segmentd.getSegment();
		ModelAndView mv=new ModelAndView("LogedIn");
		mv.addObject("segmenttran",segmentObj);
 		mv.addObject("mylist",list);
		return mv;
	}
	
	
	@RequestMapping(value="/second",method=RequestMethod.POST)
	public ModelAndView afterFirst(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		Segment manufacturerObj=new Segment();
		String segmentsname=request.getParameter("segments");
		//session.setAttribute("segments",segmentsname);
		List list=Segmentd.getManufacturer(segmentsname);
		ModelAndView mv=new ModelAndView("LogedIn");
		mv.addObject("segmenttran",manufacturerObj);
 		mv.addObject("mlist",list);
		return mv;
		
//		String json = new Gson().toJson(list);
//        response.setContentType("application/json");
//        try {
//			response.getWriter().write(json);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@RequestMapping(value="/third",method=RequestMethod.POST)
	public void afterSecond(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		String ManufacturerName=request.getParameter("ManufacturerName");
		session.setAttribute("Manufacturer",ManufacturerName);
		
		System.out.println("manufacturer name " +ManufacturerName);
		List list=Segmentd.getModelNVariant(ManufacturerName);
		System.out.println("list in after is\t"+list);
		String json = new Gson().toJson(list);
        response.setContentType("application/json");
        try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/fourth",method=RequestMethod.POST)
	public String afterThird(HttpServletRequest request,HttpSession session)
	{
		System.out.println("in After third");
		String modelNvariantName=request.getParameter("modelNvariantName");
		session.setAttribute("modelNvariant",modelNvariantName);
		return "Success";
	}
	@RequestMapping(params="final",method=RequestMethod.POST)
	public String afterSubmit(@ModelAttribute ("segmenttran")Segment segmentObj,HttpSession session)
	{
		System.out.println("in After submit");
		segmentObj.setSegmentName((String) session.getAttribute("segments"));
		segmentObj.setManufacturer((String) session.getAttribute("manufacturer"));
		segmentObj.setModelNVarient((String) session.getAttribute("modelNvariant"));
		System.out.println("SegmentTran is\t"+segmentObj);
		return "Success";
	}
}

