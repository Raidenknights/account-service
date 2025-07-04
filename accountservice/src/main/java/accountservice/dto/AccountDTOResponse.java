package accountservice.dto;

public class AccountDTOResponse {

	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public AccountDTOResponse(Long id, String username, String firstName, String lastName, String number) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
	}

	public AccountDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
