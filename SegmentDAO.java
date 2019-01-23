package servlet;

import java.util.List;

public interface SegmentDAO 
{
	List getSegment();
	List getManufacturer(String segment);
	List getModelNVariant(String Manufacturer);
}
