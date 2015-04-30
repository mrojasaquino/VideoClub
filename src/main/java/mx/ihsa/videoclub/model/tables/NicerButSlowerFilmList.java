/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables;


import java.math.BigDecimal;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.Public;
import mx.ihsa.videoclub.model.enums.MpaaRating;
import mx.ihsa.videoclub.model.tables.records.NicerButSlowerFilmListRecord;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class NicerButSlowerFilmList extends TableImpl<NicerButSlowerFilmListRecord> {

	private static final long serialVersionUID = -2036659825;

	/**
	 * The reference instance of <code>public.nicer_but_slower_film_list</code>
	 */
	public static final NicerButSlowerFilmList NICER_BUT_SLOWER_FILM_LIST = new NicerButSlowerFilmList();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<NicerButSlowerFilmListRecord> getRecordType() {
		return NicerButSlowerFilmListRecord.class;
	}

	/**
	 * The column <code>public.nicer_but_slower_film_list.fid</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, Integer> FID = createField("fid", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.title</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.description</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.category</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, String> CATEGORY = createField("category", org.jooq.impl.SQLDataType.VARCHAR.length(25), this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.price</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, BigDecimal> PRICE = createField("price", org.jooq.impl.SQLDataType.NUMERIC.precision(4, 2), this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.length</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, Short> LENGTH = createField("length", org.jooq.impl.SQLDataType.SMALLINT, this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.rating</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, MpaaRating> RATING = createField("rating", org.jooq.util.postgres.PostgresDataType.VARCHAR.asEnumDataType(mx.ihsa.videoclub.model.enums.MpaaRating.class), this, "");

	/**
	 * The column <code>public.nicer_but_slower_film_list.actors</code>.
	 */
	public final TableField<NicerButSlowerFilmListRecord, String> ACTORS = createField("actors", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>public.nicer_but_slower_film_list</code> table reference
	 */
	public NicerButSlowerFilmList() {
		this("nicer_but_slower_film_list", null);
	}

	/**
	 * Create an aliased <code>public.nicer_but_slower_film_list</code> table reference
	 */
	public NicerButSlowerFilmList(String alias) {
		this(alias, NICER_BUT_SLOWER_FILM_LIST);
	}

	private NicerButSlowerFilmList(String alias, Table<NicerButSlowerFilmListRecord> aliased) {
		this(alias, aliased, null);
	}

	private NicerButSlowerFilmList(String alias, Table<NicerButSlowerFilmListRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NicerButSlowerFilmList as(String alias) {
		return new NicerButSlowerFilmList(alias, this);
	}

	/**
	 * Rename this table
	 */
	public NicerButSlowerFilmList rename(String name) {
		return new NicerButSlowerFilmList(name, null);
	}
}