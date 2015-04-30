/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.Keys;
import mx.ihsa.videoclub.model.Public;
import mx.ihsa.videoclub.model.tables.records.ActorRecord;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Actor extends TableImpl<ActorRecord> {

	private static final long serialVersionUID = -556602252;

	/**
	 * The reference instance of <code>public.actor</code>
	 */
	public static final Actor ACTOR = new Actor();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ActorRecord> getRecordType() {
		return ActorRecord.class;
	}

	/**
	 * The column <code>public.actor.actor_id</code>.
	 */
	public final TableField<ActorRecord, Integer> ACTOR_ID = createField("actor_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.actor.first_name</code>.
	 */
	public final TableField<ActorRecord, String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>public.actor.last_name</code>.
	 */
	public final TableField<ActorRecord, String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>public.actor.last_update</code>.
	 */
	public final TableField<ActorRecord, Timestamp> LAST_UPDATE = createField("last_update", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>public.actor</code> table reference
	 */
	public Actor() {
		this("actor", null);
	}

	/**
	 * Create an aliased <code>public.actor</code> table reference
	 */
	public Actor(String alias) {
		this(alias, ACTOR);
	}

	private Actor(String alias, Table<ActorRecord> aliased) {
		this(alias, aliased, null);
	}

	private Actor(String alias, Table<ActorRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ActorRecord, Integer> getIdentity() {
		return Keys.IDENTITY_ACTOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ActorRecord> getPrimaryKey() {
		return Keys.ACTOR_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ActorRecord>> getKeys() {
		return Arrays.<UniqueKey<ActorRecord>>asList(Keys.ACTOR_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Actor as(String alias) {
		return new Actor(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Actor rename(String name) {
		return new Actor(name, null);
	}
}
