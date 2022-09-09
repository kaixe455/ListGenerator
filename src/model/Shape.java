package model;

public class Shape {
	
	private String itemIndex;
	
	private String itemShape;
	
	private String cosShape;
	
	public Shape () {
		
	}
	
	
	
	public Shape (String itemIndex, String iteamShape, String cosShape) {
		this.itemIndex = itemIndex;
		
		this.itemShape = iteamShape;
		
		this.cosShape = cosShape;
	}

	public String getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(String iteamIndex) {
		this.itemIndex = iteamIndex;
	}

	public String getItemShape() {
		return itemShape;
	}

	public void setItemShape(String itemShape) {
		this.itemShape = itemShape;
	}

	public String getCosShape() {
		return cosShape;
	}

	public void setCosShape(String cosShape) {
		this.cosShape = cosShape;
	}

}
