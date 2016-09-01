
public class Number {
	private String type;
	private int number;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Number(String type, int number) {
		super();
		this.type = type;
		this.number = number;
	}

}
