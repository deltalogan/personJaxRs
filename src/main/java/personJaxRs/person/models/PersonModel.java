package personJaxRs.person.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)

public class PersonModel {

	@XmlElement(name = "birthday")
	private String birthday;

	@XmlElement(name = "cuil")
	private String cuil;

	@XmlElement(name = "dni")
	private String dni;

	@XmlElement(name = "email")
	private String email;

	@XmlAttribute(name = "id")
	private Long id;

	@XmlElement(name = "lastName")
	private String lastName;

	@XmlElement(name = "name")
	private String name;

	public PersonModel() {

	}

	public PersonModel(String birthday, String cuil, String dni, String email, Long id, String lastName, String name) {

		this.birthday = birthday;
		this.cuil = cuil;
		this.dni = dni;
		this.email = email;
		this.id = id;
		this.lastName = lastName;
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}