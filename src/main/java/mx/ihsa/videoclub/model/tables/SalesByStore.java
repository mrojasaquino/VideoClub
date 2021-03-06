/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables;


import java.math.BigDecimal;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.Public;
import mx.ihsa.videoclub.model.tables.records.SalesByStoreRecord;

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
public class SalesByStore extends TableImpl<SalesByStoreRecord> {

	private static final long serialVersionUID = 1452955825;

	/**
	 * The reference instance of <code>public.sales_by_store</code>
	 */
	public static final SalesByStore SALES_BY_STORE = new SalesByStore();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<SalesByStoreRecord> getRecordType() {
		return SalesByStoreRecord.class;
	}

	/**
	 * The column <code>public.sales_by_store.store</code>.
	 */
	public final TableField<SalesByStoreRecord, String> STORE = createField("store", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>public.sales_by_store.manager</code>.
	 */
	public final TableField<SalesByStoreRecord, String> MANAGER = createField("manager", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>public.sales_by_store.total_sales</code>.
	 */
	public final TableField<SalesByStoreRecord, BigDecimal> TOTAL_SALES = createField("total_sales", org.jooq.impl.SQLDataType.NUMERIC, this, "");

	/**
	 * Create a <code>public.sales_by_store</code> table reference
	 */
	public SalesByStore() {
		this("sales_by_store", null);
	}

	/**
	 * Create an aliased <code>public.sales_by_store</code> table reference
	 */
	public SalesByStore(String alias) {
		this(alias, SALES_BY_STORE);
	}

	private SalesByStore(String alias, Table<SalesByStoreRecord> aliased) {
		this(alias, aliased, null);
	}

	private SalesByStore(String alias, Table<SalesByStoreRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalesByStore as(String alias) {
		return new SalesByStore(alias, this);
	}

	/**
	 * Rename this table
	 */
	public SalesByStore rename(String name) {
		return new SalesByStore(name, null);
	}
}
