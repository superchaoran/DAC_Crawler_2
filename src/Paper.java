
public class Paper {
	private String title;
	private String link;
	private boolean isASME;
	private boolean isDAC;
	public Paper(String title, String link, boolean isDAC){
		this.title = title;
		this.link = link;
		this.isASME = link.contains("asme");
		this.isDAC=isDAC;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
		isASME = link.contains("asme");
	}
	@Override
	public String toString() {
		return "DataObject [title=" + title + ", link=" + link + ", isASME="+ isASME +"]";
	}
	public boolean isASME() {
		return isASME;
	}
	public void setASME(boolean isASME) {
		this.isASME = isASME;
	}
	public boolean isDAC() {
		return isDAC;
	}
	public void setDAC(boolean isDAC) {
		this.isDAC = isDAC;
	}
}
