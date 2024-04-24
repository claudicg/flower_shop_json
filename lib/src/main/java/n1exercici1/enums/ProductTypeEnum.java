package n1exercici1.enums;

public enum ProductTypeEnum {

	TREE("Tree"),
	FLOWER("Flower"),
	DECORATION("Decoration");
	
	private String type;
	
	private ProductTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
