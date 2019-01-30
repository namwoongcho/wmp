package wmp.homework.form;

public class RequestData {

	private String url;
	private String type;
	private int division = 1;
	private String quotient;
	private String remainder;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public String getQuotient() {
		return quotient;
	}

	public void setQuotient(String quotient) {
		this.quotient = quotient;
	}

	public String getRemainder() {
		return remainder;
	}

	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
}
