import java.util.List;

public class User {
	private String name;
	private String password;
	private int id;
	private List<Number> phoneNumber;
	private List<User> friend;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Number> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<Number> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<User> getFriend() {
		return friend;
	}

	public void setFriend(List<User> friend) {
		this.friend = friend;
	}

	public User(String name, String password, int id, List<Number> phoneNumber, List<User> friend) {
		super();
		this.name = name;
		this.password = password;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.friend = friend;
	}

}
