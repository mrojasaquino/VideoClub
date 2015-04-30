/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.enums.MpaaRating;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FilmList implements Serializable {

	private static final long serialVersionUID = -1405015456;

	private Integer    fid;
	private String     title;
	private String     description;
	private String     category;
	private BigDecimal price;
	private Short      length;
	private MpaaRating rating;
	private String     actors;

	public FilmList() {}

	public FilmList(FilmList value) {
		this.fid = value.fid;
		this.title = value.title;
		this.description = value.description;
		this.category = value.category;
		this.price = value.price;
		this.length = value.length;
		this.rating = value.rating;
		this.actors = value.actors;
	}

	public FilmList(
		Integer    fid,
		String     title,
		String     description,
		String     category,
		BigDecimal price,
		Short      length,
		MpaaRating rating,
		String     actors
	) {
		this.fid = fid;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.length = length;
		this.rating = rating;
		this.actors = actors;
	}

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Short getLength() {
		return this.length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public MpaaRating getRating() {
		return this.rating;
	}

	public void setRating(MpaaRating rating) {
		this.rating = rating;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}
}
