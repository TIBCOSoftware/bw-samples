

package com.tibco.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * CreditScore
 */

@XmlRootElement
public class CreditScore {
	private Integer fiCOScore = null;

	private String rating = "Excellent";

	private Integer noOfInquiries = null;

	public CreditScore fiCOScore(Integer fiCOScore) {
		this.fiCOScore = fiCOScore;
		return this;
	}

	/**
	 * Get fiCOScore
	 * 
	 * @return fiCOScore
	 **/
	public Integer getFiCOScore() {
		return fiCOScore;
	}

	public void setFiCOScore(Integer fiCOScore) {
		this.fiCOScore = fiCOScore;
	}

	public CreditScore rating(String rating) {
		this.rating = rating;
		return this;
	}

	/**
	 * Get rating
	 * 
	 * @return rating
	 **/
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public CreditScore noOfInquiries(Integer noOfInquiries) {
		this.noOfInquiries = noOfInquiries;
		return this;
	}

	/**
	 * Get noOfInquiries
	 * 
	 * @return noOfInquiries
	 **/
	public Integer getNoOfInquiries() {
		return noOfInquiries;
	}

	public void setNoOfInquiries(Integer noOfInquiries) {
		this.noOfInquiries = noOfInquiries;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CreditScore creditScore = (CreditScore) o;
		return Objects.equals(this.fiCOScore, creditScore.fiCOScore)
				&& Objects.equals(this.rating, creditScore.rating)
				&& Objects
						.equals(this.noOfInquiries, creditScore.noOfInquiries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fiCOScore, rating, noOfInquiries);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CreditScore {\n");

		sb.append("    fiCOScore: ").append(toIndentedString(fiCOScore))
				.append("\n");
		sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
		sb.append("    noOfInquiries: ")
				.append(toIndentedString(noOfInquiries)).append("\n");
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
