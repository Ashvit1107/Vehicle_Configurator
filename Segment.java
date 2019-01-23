package servlet;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Segment implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private static final long serialVersionUID = 1L;
	
	private String segmentName;
	private String manufacturer;
	private String modelNVarient;
	
	public Segment() {
	}
//	
//	public Segment(int id) {
//		this.segmentId = id;
//	}
//	
//	public Segment(int id, String name) {
//		this.segmentId = id;
//		this.segmentName = name;
//	}
//	
//	public Segment(int id, String name, String mname) {
//		this.segmentId = id;
//		this.segmentName = name;
//		this.manufacturer = mname;
////	}
//	
//	public Segment(int id, String name, String mname, String mvname) {
//		this.segmentId = id;
//		this.segmentName = name;
//		this.manufacturer = mname;
//		this.modelNVarient = mvname;
//	}
	
	

	@Column(name = "name", length = 30)
	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	@Column(name = "name", length = 30)
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModelNVarient() {
		return modelNVarient;
	}

	@Column(name = "name", length = 30)
	public void setModelNVarient(String modelNVarient) {
		this.modelNVarient = modelNVarient;
	}
	
	/*
	public Segment() {
	}

	public Segment(int id) {
		this.SegmentId = id;
	}

	public Segment(int id, String name) {
		this.SegmentId = id;
		this.SegmentName = name;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.SegmentId;
	}

	public void setId(int id) {
		this.SegmentId = id;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.SegmentName;
	}

	public void setName(String name) {
		this.SegmentName = SegmentName;
	} */
	
	

}
