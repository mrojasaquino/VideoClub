/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables;


import java.sql.Timestamp;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.Public;
import mx.ihsa.videoclub.model.tables.records.HistoricoRentasRecord;

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
public class HistoricoRentas extends TableImpl<HistoricoRentasRecord> {

	private static final long serialVersionUID = -1066606479;

	/**
	 * The reference instance of <code>public.historico_rentas</code>
	 */
	public static final HistoricoRentas HISTORICO_RENTAS = new HistoricoRentas();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<HistoricoRentasRecord> getRecordType() {
		return HistoricoRentasRecord.class;
	}

	/**
	 * The column <code>public.historico_rentas.customer_id</code>.
	 */
	public final TableField<HistoricoRentasRecord, Short> CUSTOMER_ID = createField("customer_id", org.jooq.impl.SQLDataType.SMALLINT, this, "");

	/**
	 * The column <code>public.historico_rentas.previous_date</code>.
	 */
	public final TableField<HistoricoRentasRecord, Timestamp> PREVIOUS_DATE = createField("previous_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>public.historico_rentas.rental_date</code>.
	 */
	public final TableField<HistoricoRentasRecord, Timestamp> RENTAL_DATE = createField("rental_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>public.historico_rentas.how_many</code>.
	 */
	public final TableField<HistoricoRentasRecord, Long> HOW_MANY = createField("how_many", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>public.historico_rentas.next_date</code>.
	 */
	public final TableField<HistoricoRentasRecord, Timestamp> NEXT_DATE = createField("next_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * Create a <code>public.historico_rentas</code> table reference
	 */
	public HistoricoRentas() {
		this("historico_rentas", null);
	}

	/**
	 * Create an aliased <code>public.historico_rentas</code> table reference
	 */
	public HistoricoRentas(String alias) {
		this(alias, HISTORICO_RENTAS);
	}

	private HistoricoRentas(String alias, Table<HistoricoRentasRecord> aliased) {
		this(alias, aliased, null);
	}

	private HistoricoRentas(String alias, Table<HistoricoRentasRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentas as(String alias) {
		return new HistoricoRentas(alias, this);
	}

	/**
	 * Rename this table
	 */
	public HistoricoRentas rename(String name) {
		return new HistoricoRentas(name, null);
	}
}