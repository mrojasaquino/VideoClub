/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.Sequences;
import mx.ihsa.videoclub.model.tables.Actor;
import mx.ihsa.videoclub.model.tables.ActorInfo;
import mx.ihsa.videoclub.model.tables.Address;
import mx.ihsa.videoclub.model.tables.Category;
import mx.ihsa.videoclub.model.tables.City;
import mx.ihsa.videoclub.model.tables.Country;
import mx.ihsa.videoclub.model.tables.Customer;
import mx.ihsa.videoclub.model.tables.CustomerList;
import mx.ihsa.videoclub.model.tables.Film;
import mx.ihsa.videoclub.model.tables.FilmActor;
import mx.ihsa.videoclub.model.tables.FilmCategory;
import mx.ihsa.videoclub.model.tables.FilmInStock;
import mx.ihsa.videoclub.model.tables.FilmList;
import mx.ihsa.videoclub.model.tables.FilmNotInStock;
import mx.ihsa.videoclub.model.tables.HistoricoRentas;
import mx.ihsa.videoclub.model.tables.Inventory;
import mx.ihsa.videoclub.model.tables.Language;
import mx.ihsa.videoclub.model.tables.NicerButSlowerFilmList;
import mx.ihsa.videoclub.model.tables.Payment;
import mx.ihsa.videoclub.model.tables.PaymentP2007_01;
import mx.ihsa.videoclub.model.tables.PaymentP2007_02;
import mx.ihsa.videoclub.model.tables.PaymentP2007_03;
import mx.ihsa.videoclub.model.tables.PaymentP2007_04;
import mx.ihsa.videoclub.model.tables.PaymentP2007_05;
import mx.ihsa.videoclub.model.tables.PaymentP2007_06;
import mx.ihsa.videoclub.model.tables.Rental;
import mx.ihsa.videoclub.model.tables.RewardsReport;
import mx.ihsa.videoclub.model.tables.SalesByFilmCategory;
import mx.ihsa.videoclub.model.tables.SalesByStore;
import mx.ihsa.videoclub.model.tables.Staff;
import mx.ihsa.videoclub.model.tables.StaffList;
import mx.ihsa.videoclub.model.tables.Store;

import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

	private static final long serialVersionUID = 1322516198;

	/**
	 * The reference instance of <code>public</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("public");
	}

	@Override
	public final List<Sequence<?>> getSequences() {
		List result = new ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final List<Sequence<?>> getSequences0() {
		return Arrays.<Sequence<?>>asList(
			Sequences.ACTOR_ACTOR_ID_SEQ,
			Sequences.ADDRESS_ADDRESS_ID_SEQ,
			Sequences.CATEGORY_CATEGORY_ID_SEQ,
			Sequences.CITY_CITY_ID_SEQ,
			Sequences.COUNTRY_COUNTRY_ID_SEQ,
			Sequences.CUSTOMER_CUSTOMER_ID_SEQ,
			Sequences.FILM_FILM_ID_SEQ,
			Sequences.INVENTORY_INVENTORY_ID_SEQ,
			Sequences.LANGUAGE_LANGUAGE_ID_SEQ,
			Sequences.PAYMENT_PAYMENT_ID_SEQ,
			Sequences.RENTAL_RENTAL_ID_SEQ,
			Sequences.STAFF_STAFF_ID_SEQ,
			Sequences.STORE_STORE_ID_SEQ);
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Actor.ACTOR,
			ActorInfo.ACTOR_INFO,
			Address.ADDRESS,
			Category.CATEGORY,
			City.CITY,
			Country.COUNTRY,
			Customer.CUSTOMER,
			CustomerList.CUSTOMER_LIST,
			Film.FILM,
			FilmActor.FILM_ACTOR,
			FilmCategory.FILM_CATEGORY,
			FilmInStock.FILM_IN_STOCK,
			FilmList.FILM_LIST,
			FilmNotInStock.FILM_NOT_IN_STOCK,
			HistoricoRentas.HISTORICO_RENTAS,
			Inventory.INVENTORY,
			Language.LANGUAGE,
			NicerButSlowerFilmList.NICER_BUT_SLOWER_FILM_LIST,
			Payment.PAYMENT,
			PaymentP2007_01.PAYMENT_P2007_01,
			PaymentP2007_02.PAYMENT_P2007_02,
			PaymentP2007_03.PAYMENT_P2007_03,
			PaymentP2007_04.PAYMENT_P2007_04,
			PaymentP2007_05.PAYMENT_P2007_05,
			PaymentP2007_06.PAYMENT_P2007_06,
			Rental.RENTAL,
			RewardsReport.REWARDS_REPORT,
			SalesByFilmCategory.SALES_BY_FILM_CATEGORY,
			SalesByStore.SALES_BY_STORE,
			Staff.STAFF,
			StaffList.STAFF_LIST,
			Store.STORE);
	}
}
