package n1exercici1.enums;

public enum MaterialsEnum {

	WOOD("wood"),
	PLASTIC("plastic");
	
	private String name;
	
	private MaterialsEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
