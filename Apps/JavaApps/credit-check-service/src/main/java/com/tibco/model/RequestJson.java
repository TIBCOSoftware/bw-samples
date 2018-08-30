package com.tibco.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * RequestJson
 */

@XmlRootElement
public class RequestJson {
	private String SSN = "123-45-6789";

	private String firstName = "Tony";

	private String lastName = "Stark";

	private String DOB = "01/01/1999";

	public RequestJson SSN(String SSN) {
		this.SSN = SSN;
		return this;
	}

	/**
	 * Get SSN
	 * 
	 * @return SSN
	 **/
	public String getSSN() {
		return SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public RequestJson firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public RequestJson lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RequestJson DOB(String DOB) {
		this.DOB = DOB;
		return this;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestJson requestJson = (RequestJson) o;
		return Objects.equals(this.SSN, requestJson.SSN)
				&& Objects.equals(this.firstName, requestJson.firstName)
				&& Objects.equals(this.lastName, requestJson.lastName)
				&& Objects.equals(this.DOB, requestJson.DOB);
	}

	@Override
	public int hashCode() {
		return Objects.hash(SSN, firstName, lastName, DOB);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestJson {\n");

		sb.append("    SSN: ").append(toIndentedString(SSN)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName))
				.append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName))
				.append("\n");
		sb.append("    DOB: ").append(toIndentedString(DOB)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
