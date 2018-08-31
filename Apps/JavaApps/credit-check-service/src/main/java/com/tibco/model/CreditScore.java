

package com.tibco.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * CreditScore
 */

@XmlRootElement
public class CreditScore {
	private Integer FICOScore = null;

	private String rating = "Excellent";

	private Integer NoOfInquiries = null;

	public CreditScore fiCOScore(Integer fiCOScore) {
		this.FICOScore = fiCOScore;
		return this;
	}

	/**
	 * Get fiCOScore
	 * 
	 * @return fiCOScore
	 **/
	public Integer getFiCOScore() {
		return FICOScore;
	}

	public void setFiCOScore(Integer fiCOScore) {
		this.FICOScore = fiCOScore;
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
		this.NoOfInquiries = noOfInquiries;
		return this;
	}

	/**
	 * Get noOfInquiries
	 * 
	 * @return noOfInquiries
	 **/
	public Integer getNoOfInquiries() {
		return NoOfInquiries;
	}

	public void setNoOfInquiries(Integer noOfInquiries) {
		this.NoOfInquiries = noOfInquiries;
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
		return Objects.equals(this.FICOScore, creditScore.FICOScore)
				&& Objects.equals(this.rating, creditScore.rating)
				&& Objects
						.equals(this.NoOfInquiries, creditScore.NoOfInquiries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(FICOScore, rating, NoOfInquiries);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CreditScore {\n");

		sb.append("    fiCOScore: ").append(toIndentedString(FICOScore))
				.append("\n");
		sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
		sb.append("    noOfInquiries: ")
				.append(toIndentedString(NoOfInquiries)).append("\n");
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
