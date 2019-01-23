package servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SegmentDAOImpl implements SegmentDAO
{
@Autowired
HibernateTemplate template;



	@Override
	public List getSegment() {
		// TODO Auto-generated method stub
		List list=template.find("select distinct s.segmentName from Segment s");
		return list;
	}
	@Override
	public List getManufacturer(String segment) {
		String query="select s.manufacturer from Segment s where  segmentName = ?";
		Object[] prm={segment};
		List list=template.find(query,prm);	
		return list;
	}
	@Override
	public List getModelNVariant(String manufactureName) {
		String query="select s.modelNVarient from Segment s where manufacturer = ?";
		Object[] prm={manufactureName};
		List list=template.find(query,prm);
		
		return list;
	}
	

}
