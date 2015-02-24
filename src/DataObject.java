import java.util.ArrayList;
import java.util.List;
 
public class DataObject {
 
	private Paper paper;
	private List<Paper> list = new ArrayList<Paper>();
	
	//getter and setter methods
	public void addList(Paper citingPaper){
		list.add(citingPaper);
	}
	@Override
	public String toString() {
	   return "DataObject [paper=" + paper + ", list=" + list + "]";
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
 
}