package accountservice.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AccountDTO {

	@NotNull
	private Long id;

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public AccountDTO(@NotNull Long id, @NotEmpty String username, @NotEmpty String password,
			@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String number) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
	}

}
