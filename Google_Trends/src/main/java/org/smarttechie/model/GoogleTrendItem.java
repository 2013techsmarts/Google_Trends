package org.smarttechie.model;

/**
 * This model holds the attributes of google trending item.
 * @author Siva Janapati
 * @version 1.0
 *
 */
public class GoogleTrendItem {
	
	/**
	 * This contains the title
	 */
	private String title;
	
	/**
	 * This contains the description
	 */
	private String description;
	
	/**
	 * This contains the news link
	 */
	private String link;
	
	/**
	 * This contains the picture
	 */
	private String picture;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

}
