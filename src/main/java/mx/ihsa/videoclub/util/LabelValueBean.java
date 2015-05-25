package mx.ihsa.videoclub.util;

public class LabelValueBean {

	private int value;
	private String label;
	
	
	public LabelValueBean(String label, int value) {
		this.label = label;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	@Override
	public String toString() {
		return "[Label : " + label + " | Value : " + value + " ]";
	}
	
}
