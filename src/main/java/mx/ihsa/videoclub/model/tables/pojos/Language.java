/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class Language implements Serializable {

	private static final long serialVersionUID = 531229068;

	private Integer   languageId;
	private String    name;
	private Timestamp lastUpdate;

	public Language() {}

	public Language(Language value) {
		this.languageId = value.languageId;
		this.name = value.name;
		this.lastUpdate = value.lastUpdate;
	}

	public Language(
		Integer   languageId,
		String    name,
		Timestamp lastUpdate
	) {
		this.languageId = languageId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
