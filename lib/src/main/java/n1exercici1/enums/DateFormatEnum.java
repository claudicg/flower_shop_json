package n1exercici1.enums;

public enum DateFormatEnum {

	TIMESTAMP("yyyy-MM-dd HH:mm:ss");
	
	private String format;

	private DateFormatEnum(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}
	
}
