package org.computate.smartaeronautics.model.fiware.aircraft;

import org.computate.smartaeronautics.request.SiteRequest;
import org.computate.smartaeronautics.model.MapModel;
import org.computate.smartaeronautics.model.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
import org.computate.vertx.api.ApiRequest;
import org.computate.smartaeronautics.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import java.lang.String;
import org.computate.smartaeronautics.timezone.TimeZone;
import org.computate.smartaeronautics.model.fiware.airport.Airport;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.Boolean;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Path;
import org.computate.vertx.tool.VertxTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import io.vertx.pgclient.data.Point;
import org.computate.vertx.serialize.pgclient.PgClientPathSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPathDeserializer;
import java.lang.Long;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.tool.SearchTool;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class AircraftGen into the class Aircraft. 
 * </li>
 * <h3>About the Aircraft class and it's generated class AircraftGen&lt;MapModel&gt;: </h3>extends AircraftGen
 * <p>
 * This Java class extends a generated Java class AircraftGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft">Find the class Aircraft in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends AircraftGen<MapModel>
 * <p>This <code>class Aircraft extends AircraftGen&lt;MapModel&gt;</code>, which means it extends a newly generated AircraftGen. 
 * The generated <code>class AircraftGen extends MapModel</code> which means that Aircraft extends AircraftGen which extends MapModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Api: true</b></kbd>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <kbd><b>ApiTag: Aircrafts</b></kbd>, which groups all of the OpenAPIs for Aircraft objects under the tag "Aircrafts". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/aircraft</h2>
 * <p>This class contains a comment <kbd><b>ApiUri: /en-us/api/aircraft</b></kbd>, which defines the base API URI for Aircraft objects as "/en-us/api/aircraft" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <kbd><b>Indexed: true</b></kbd>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Aircraft class will inherit the helpful inherited class comments from the super class AircraftGen. 
 * </p>
 * <h2>
 *   Rows: 100
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the Aircraft API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the Aircraft API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 7
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 7</b></kbd>, 
 *   which means this class will be sorted by the given number 7 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 7</h2>
 * <p>This class contains a comment <kbd><b>SqlOrder: 7</b></kbd>, which means this class will be sorted by the given number 7 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <kbd><b>Model: true</b></kbd>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <kbd><b>Page: true</b></kbd>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaeronautics.model.fiware.aircraft.AircraftPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <kbd><b>SuperPage.enUS: PageLayout</b></kbd>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaeronautics.model.fiware.aircraft.AircraftPage extends org.computate.smartaeronautics.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <kbd><b>Promise: true</b></kbd>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the Aircraft Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
 * </p>
 * <p>
 *   Adding protected void methods beginning with an underscore with a Promise as the only parameter will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   <pre>
 *   
 *   	protected void _promiseBefore(Promise&lt;Void&gt; promise) {
 *   		promise.complete();
 *   	}
 *   </pre>
 * </p>
 * <p>
 *   Java classes with the `Model: true` will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   If a super class of this Java class with `Model: true`, then the child class will also inherit `Promise: true`. 
 * </p>
 * <h2>AName.enUS: an Aircraft</h2>
 * <p>This class contains a comment <kbd><b>AName.enUS: an Aircraft</b></kbd>, which identifies the language context to describe a Aircraft as "an Aircraft". 
 * </p>
 * <p>
 * Delete the class Aircraft in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaeronautics.model.fiware.aircraft in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the project smart-aeronautics in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:smart\-aeronautics&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * Generated: true
 **/
public abstract class AircraftGen<DEV> extends MapModel {
  protected static final Logger LOG = LoggerFactory.getLogger(Aircraft.class);

  public static final String Description_enUS = "Represent a generic aircraft";
  public static final String AName_enUS = "an Aircraft";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this Aircraft";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "theAircraft";
  public static final String SingularName_enUS = "Aircraft";
  public static final String PluralName_enUS = "Aircrafts";
  public static final String NameActual_enUS = "current Aircraft";
  public static final String AllName_enUS = "all Aircrafts";
  public static final String SearchAllNameBy_enUS = "search Aircrafts by ";
  public static final String SearchAllName_enUS = "search Aircrafts";
  public static final String Title_enUS = "Aircrafts";
  public static final String ThePluralName_enUS = "the Aircrafts";
  public static final String NoNameFound_enUS = "no Aircraft found";
  public static final String ApiUri_enUS = "/en-us/api/aircraft";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/aircraft";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/aircraft/{entityShortId}";
  public static final String OfName_enUS = "of Aircraft";
  public static final String ANameAdjective_enUS = "an Aircraft";
  public static final String NameAdjectiveSingular_enUS = "Aircraft";
  public static final String NameAdjectivePlural_enUS = "Aircrafts";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/aircraft";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/aircraft";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/aircraft";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/aircraft/{entityShortId}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/aircraft/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/aircraft/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/aircraft";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/aircraft";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/aircraft";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/aircraft";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/aircraft";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/aircraft";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/aircraft/{entityShortId}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/aircraft/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/aircraft/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/aircraft-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/aircraft-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/aircraft-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/aircraft";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/aircraft";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/aircraft";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/aircraft/{entityShortId}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/aircraft/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/aircraft/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/aircraft";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/aircraft";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/aircraft";

  public static final String Icon = "<i class=\"fa-duotone fa-regular  fa-conveyor-belt\"></i>";
  public static final Integer Rows = 100;

	//////////////
  // timeZone //
	//////////////


  /**
   *  The entity timeZone
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String timeZone;

  /**
   * <br> The entity timeZone
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:timeZone">Find the entity timeZone in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _timeZone(Wrap<String> w);

  public String getTimeZone() {
    return timeZone;
  }
  public void setTimeZone(String o) {
    this.timeZone = Aircraft.staticSetTimeZone(siteRequest_, o);
  }
  public static String staticSetTimeZone(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft timeZoneInit() {
    Wrap<String> timeZoneWrap = new Wrap<String>().var("timeZone");
    if(timeZone == null) {
      _timeZone(timeZoneWrap);
      Optional.ofNullable(timeZoneWrap.getO()).ifPresent(o -> {
        setTimeZone(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchTimeZone(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrTimeZone(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTimeZone(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchTimeZone(siteRequest_, Aircraft.staticSetTimeZone(siteRequest_, o)).toString();
  }

  public String sqlTimeZone() {
    return timeZone;
  }

  public static String staticJsonTimeZone(String timeZone) {
    return timeZone;
  }

	///////////////
  // airportId //
	///////////////


  /**
   *  The entity airportId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String airportId;

  /**
   * <br> The entity airportId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:airportId">Find the entity airportId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _airportId(Wrap<String> w);

  public String getAirportId() {
    return airportId;
  }
  public void setAirportId(String o) {
    this.airportId = Aircraft.staticSetAirportId(siteRequest_, o);
  }
  public static String staticSetAirportId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft airportIdInit() {
    Wrap<String> airportIdWrap = new Wrap<String>().var("airportId");
    if(airportId == null) {
      _airportId(airportIdWrap);
      Optional.ofNullable(airportIdWrap.getO()).ifPresent(o -> {
        setAirportId(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchAirportId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAirportId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAirportId(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAirportId(siteRequest_, Aircraft.staticSetAirportId(siteRequest_, o)).toString();
  }

  public String sqlAirportId() {
    return airportId;
  }

  public static String staticJsonAirportId(String airportId) {
    return airportId;
  }

	///////////////////
  // departureDate //
	///////////////////


  /**
   *  The entity departureDate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime departureDate;

  /**
   * <br> The entity departureDate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:departureDate">Find the entity departureDate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _departureDate(Wrap<ZonedDateTime> w);

  public ZonedDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(ZonedDateTime departureDate) {
    this.departureDate = Optional.ofNullable(departureDate).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setDepartureDate(Instant o) {
    this.departureDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setDepartureDate(String o) {
    ZoneId zoneId = Optional.ofNullable(timeZone).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")));
    this.departureDate = Aircraft.staticSetDepartureDate(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setDepartureDate(Date o) {
    this.departureDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetDepartureDate(SiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected Aircraft departureDateInit() {
    Wrap<ZonedDateTime> departureDateWrap = new Wrap<ZonedDateTime>().var("departureDate");
    if(departureDate == null) {
      _departureDate(departureDateWrap);
      Optional.ofNullable(departureDateWrap.getO()).ifPresent(o -> {
        setDepartureDate(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchDepartureDate(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrDepartureDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return Aircraft.staticSearchDepartureDate(siteRequest_, Aircraft.staticSetDepartureDate(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqDepartureDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return Aircraft.staticSearchDepartureDate(siteRequest_, Aircraft.staticSetDepartureDate(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlDepartureDate() {
    return departureDate == null ? null : departureDate.toOffsetDateTime();
  }

  public static String staticJsonDepartureDate(ZonedDateTime departureDate) {
    return Optional.ofNullable(departureDate).map(v -> v.format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null);
  }

	/////////////////
  // arrivalDate //
	/////////////////


  /**
   *  The entity arrivalDate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime arrivalDate;

  /**
   * <br> The entity arrivalDate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:arrivalDate">Find the entity arrivalDate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _arrivalDate(Wrap<ZonedDateTime> w);

  public ZonedDateTime getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(ZonedDateTime arrivalDate) {
    this.arrivalDate = Optional.ofNullable(arrivalDate).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setArrivalDate(Instant o) {
    this.arrivalDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setArrivalDate(String o) {
    ZoneId zoneId = Optional.ofNullable(timeZone).map(v -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC")));
    this.arrivalDate = Aircraft.staticSetArrivalDate(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setArrivalDate(Date o) {
    this.arrivalDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetArrivalDate(SiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected Aircraft arrivalDateInit() {
    Wrap<ZonedDateTime> arrivalDateWrap = new Wrap<ZonedDateTime>().var("arrivalDate");
    if(arrivalDate == null) {
      _arrivalDate(arrivalDateWrap);
      Optional.ofNullable(arrivalDateWrap.getO()).ifPresent(o -> {
        setArrivalDate(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchArrivalDate(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrArrivalDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return Aircraft.staticSearchArrivalDate(siteRequest_, Aircraft.staticSetArrivalDate(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqArrivalDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return Aircraft.staticSearchArrivalDate(siteRequest_, Aircraft.staticSetArrivalDate(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlArrivalDate() {
    return arrivalDate == null ? null : arrivalDate.toOffsetDateTime();
  }

  public static String staticJsonArrivalDate(ZonedDateTime arrivalDate) {
    return Optional.ofNullable(arrivalDate).map(v -> v.format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null);
  }

	///////////////////
  // avgSpeedInMph //
	///////////////////


  /**
   *  The entity avgSpeedInMph
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal avgSpeedInMph;

  /**
   * <br> The entity avgSpeedInMph
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:avgSpeedInMph">Find the entity avgSpeedInMph in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _avgSpeedInMph(Wrap<BigDecimal> w);

  public BigDecimal getAvgSpeedInMph() {
    return avgSpeedInMph;
  }

  public void setAvgSpeedInMph(BigDecimal avgSpeedInMph) {
    this.avgSpeedInMph = avgSpeedInMph;
  }
  @JsonIgnore
  public void setAvgSpeedInMph(String o) {
    this.avgSpeedInMph = Aircraft.staticSetAvgSpeedInMph(siteRequest_, o);
  }
  public static Integer staticScaleAvgSpeedInMph() {
    return 2;
  }
  public static MathContext staticMathContextAvgSpeedInMph() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetAvgSpeedInMph(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextAvgSpeedInMph()).setScale(staticScaleAvgSpeedInMph(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setAvgSpeedInMph(Double o) {
    setAvgSpeedInMph(new BigDecimal(o, staticMathContextAvgSpeedInMph()).setScale(staticScaleAvgSpeedInMph(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setAvgSpeedInMph(Integer o) {
    setAvgSpeedInMph(new BigDecimal(o, staticMathContextAvgSpeedInMph()).setScale(staticScaleAvgSpeedInMph(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setAvgSpeedInMph(Number o) {
    setAvgSpeedInMph(new BigDecimal(o.doubleValue(), staticMathContextAvgSpeedInMph()).setScale(staticScaleAvgSpeedInMph(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Aircraft avgSpeedInMphInit() {
    Wrap<BigDecimal> avgSpeedInMphWrap = new Wrap<BigDecimal>().var("avgSpeedInMph");
    if(avgSpeedInMph == null) {
      _avgSpeedInMph(avgSpeedInMphWrap);
      Optional.ofNullable(avgSpeedInMphWrap.getO()).ifPresent(o -> {
        setAvgSpeedInMph(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchAvgSpeedInMph(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrAvgSpeedInMph(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAvgSpeedInMph(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAvgSpeedInMph(siteRequest_, Aircraft.staticSetAvgSpeedInMph(siteRequest_, o)).toString();
  }

  public BigDecimal sqlAvgSpeedInMph() {
    return avgSpeedInMph;
  }

  public static String staticJsonAvgSpeedInMph(BigDecimal avgSpeedInMph) {
    return Optional.ofNullable(avgSpeedInMph).map(v -> v.toString()).orElse(null);
  }

	/////////////
  // address //
	/////////////


  /**
   *  The entity address
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject address;

  /**
   * <br> The entity address
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _address(Wrap<JsonObject> w);

  public JsonObject getAddress() {
    return address;
  }

  public void setAddress(JsonObject address) {
    this.address = address;
  }
  @JsonIgnore
  public void setAddress(String o) {
    this.address = Aircraft.staticSetAddress(siteRequest_, o);
  }
  public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Aircraft addressInit() {
    Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
    if(address == null) {
      _address(addressWrap);
      Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
        setAddress(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAddress(siteRequest_, Aircraft.staticSetAddress(siteRequest_, o)).toString();
  }

  public JsonObject sqlAddress() {
    return address;
  }

  public static JsonObject staticJsonAddress(JsonObject address) {
    return address;
  }

	///////////////////
  // alternateName //
	///////////////////


  /**
   *  The entity alternateName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String alternateName;

  /**
   * <br> The entity alternateName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _alternateName(Wrap<String> w);

  public String getAlternateName() {
    return alternateName;
  }
  public void setAlternateName(String o) {
    this.alternateName = Aircraft.staticSetAlternateName(siteRequest_, o);
  }
  public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft alternateNameInit() {
    Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
    if(alternateName == null) {
      _alternateName(alternateNameWrap);
      Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
        setAlternateName(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAlternateName(siteRequest_, Aircraft.staticSetAlternateName(siteRequest_, o)).toString();
  }

  public String sqlAlternateName() {
    return alternateName;
  }

  public static String staticJsonAlternateName(String alternateName) {
    return alternateName;
  }

	////////////////////////////
  // belongsToAircraftModel //
	////////////////////////////


  /**
   *  The entity belongsToAircraftModel
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String belongsToAircraftModel;

  /**
   * <br> The entity belongsToAircraftModel
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:belongsToAircraftModel">Find the entity belongsToAircraftModel in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _belongsToAircraftModel(Wrap<String> w);

  public String getBelongsToAircraftModel() {
    return belongsToAircraftModel;
  }
  public void setBelongsToAircraftModel(String o) {
    this.belongsToAircraftModel = Aircraft.staticSetBelongsToAircraftModel(siteRequest_, o);
  }
  public static String staticSetBelongsToAircraftModel(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft belongsToAircraftModelInit() {
    Wrap<String> belongsToAircraftModelWrap = new Wrap<String>().var("belongsToAircraftModel");
    if(belongsToAircraftModel == null) {
      _belongsToAircraftModel(belongsToAircraftModelWrap);
      Optional.ofNullable(belongsToAircraftModelWrap.getO()).ifPresent(o -> {
        setBelongsToAircraftModel(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchBelongsToAircraftModel(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrBelongsToAircraftModel(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqBelongsToAircraftModel(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchBelongsToAircraftModel(siteRequest_, Aircraft.staticSetBelongsToAircraftModel(siteRequest_, o)).toString();
  }

  public String sqlBelongsToAircraftModel() {
    return belongsToAircraftModel;
  }

  public static String staticJsonBelongsToAircraftModel(String belongsToAircraftModel) {
    return belongsToAircraftModel;
  }

	//////////////////
  // dataProvider //
	//////////////////


  /**
   *  The entity dataProvider
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dataProvider;

  /**
   * <br> The entity dataProvider
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dataProvider(Wrap<String> w);

  public String getDataProvider() {
    return dataProvider;
  }
  public void setDataProvider(String o) {
    this.dataProvider = Aircraft.staticSetDataProvider(siteRequest_, o);
  }
  public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft dataProviderInit() {
    Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
    if(dataProvider == null) {
      _dataProvider(dataProviderWrap);
      Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
        setDataProvider(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchDataProvider(siteRequest_, Aircraft.staticSetDataProvider(siteRequest_, o)).toString();
  }

  public String sqlDataProvider() {
    return dataProvider;
  }

  public static String staticJsonDataProvider(String dataProvider) {
    return dataProvider;
  }

	/////////////////
  // dateCreated //
	/////////////////


  /**
   *  The entity dateCreated
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dateCreated;

  /**
   * <br> The entity dateCreated
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateCreated(Wrap<String> w);

  public String getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(String o) {
    this.dateCreated = Aircraft.staticSetDateCreated(siteRequest_, o);
  }
  public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft dateCreatedInit() {
    Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
    if(dateCreated == null) {
      _dateCreated(dateCreatedWrap);
      Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
        setDateCreated(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchDateCreated(siteRequest_, Aircraft.staticSetDateCreated(siteRequest_, o)).toString();
  }

  public String sqlDateCreated() {
    return dateCreated;
  }

  public static String staticJsonDateCreated(String dateCreated) {
    return dateCreated;
  }

	////////////////
  // dateIssued //
	////////////////


  /**
   *  The entity dateIssued
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dateIssued;

  /**
   * <br> The entity dateIssued
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:dateIssued">Find the entity dateIssued in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateIssued(Wrap<String> w);

  public String getDateIssued() {
    return dateIssued;
  }
  public void setDateIssued(String o) {
    this.dateIssued = Aircraft.staticSetDateIssued(siteRequest_, o);
  }
  public static String staticSetDateIssued(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft dateIssuedInit() {
    Wrap<String> dateIssuedWrap = new Wrap<String>().var("dateIssued");
    if(dateIssued == null) {
      _dateIssued(dateIssuedWrap);
      Optional.ofNullable(dateIssuedWrap.getO()).ifPresent(o -> {
        setDateIssued(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchDateIssued(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateIssued(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateIssued(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchDateIssued(siteRequest_, Aircraft.staticSetDateIssued(siteRequest_, o)).toString();
  }

  public String sqlDateIssued() {
    return dateIssued;
  }

  public static String staticJsonDateIssued(String dateIssued) {
    return dateIssued;
  }

	//////////////////
  // dateModified //
	//////////////////


  /**
   *  The entity dateModified
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String dateModified;

  /**
   * <br> The entity dateModified
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateModified(Wrap<String> w);

  public String getDateModified() {
    return dateModified;
  }
  public void setDateModified(String o) {
    this.dateModified = Aircraft.staticSetDateModified(siteRequest_, o);
  }
  public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft dateModifiedInit() {
    Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
    if(dateModified == null) {
      _dateModified(dateModifiedWrap);
      Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
        setDateModified(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchDateModified(siteRequest_, Aircraft.staticSetDateModified(siteRequest_, o)).toString();
  }

  public String sqlDateModified() {
    return dateModified;
  }

  public static String staticJsonDateModified(String dateModified) {
    return dateModified;
  }

	/////////////
  // heading //
	/////////////


  /**
   *  The entity heading
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal heading;

  /**
   * <br> The entity heading
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:heading">Find the entity heading in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _heading(Wrap<BigDecimal> w);

  public BigDecimal getHeading() {
    return heading;
  }

  public void setHeading(BigDecimal heading) {
    this.heading = heading;
  }
  @JsonIgnore
  public void setHeading(String o) {
    this.heading = Aircraft.staticSetHeading(siteRequest_, o);
  }
  public static Integer staticScaleHeading() {
    return 2;
  }
  public static MathContext staticMathContextHeading() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetHeading(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextHeading()).setScale(staticScaleHeading(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setHeading(Double o) {
    setHeading(new BigDecimal(o, staticMathContextHeading()).setScale(staticScaleHeading(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setHeading(Integer o) {
    setHeading(new BigDecimal(o, staticMathContextHeading()).setScale(staticScaleHeading(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setHeading(Number o) {
    setHeading(new BigDecimal(o.doubleValue(), staticMathContextHeading()).setScale(staticScaleHeading(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Aircraft headingInit() {
    Wrap<BigDecimal> headingWrap = new Wrap<BigDecimal>().var("heading");
    if(heading == null) {
      _heading(headingWrap);
      Optional.ofNullable(headingWrap.getO()).ifPresent(o -> {
        setHeading(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchHeading(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrHeading(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqHeading(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchHeading(siteRequest_, Aircraft.staticSetHeading(siteRequest_, o)).toString();
  }

  public BigDecimal sqlHeading() {
    return heading;
  }

  public static String staticJsonHeading(BigDecimal heading) {
    return Optional.ofNullable(heading).map(v -> v.toString()).orElse(null);
  }

	////////////////
  // isOnGround //
	////////////////


  /**
   *  The entity isOnGround
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean isOnGround;

  /**
   * <br> The entity isOnGround
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:isOnGround">Find the entity isOnGround in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _isOnGround(Wrap<Boolean> w);

  public Boolean getIsOnGround() {
    return isOnGround;
  }

  public void setIsOnGround(Boolean isOnGround) {
    this.isOnGround = isOnGround;
  }
  @JsonIgnore
  public void setIsOnGround(String o) {
    this.isOnGround = Aircraft.staticSetIsOnGround(siteRequest_, o);
  }
  public static Boolean staticSetIsOnGround(SiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected Aircraft isOnGroundInit() {
    Wrap<Boolean> isOnGroundWrap = new Wrap<Boolean>().var("isOnGround");
    if(isOnGround == null) {
      _isOnGround(isOnGroundWrap);
      Optional.ofNullable(isOnGroundWrap.getO()).ifPresent(o -> {
        setIsOnGround(o);
      });
    }
    return (Aircraft)this;
  }

  public static Boolean staticSearchIsOnGround(SiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrIsOnGround(SiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIsOnGround(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchIsOnGround(siteRequest_, Aircraft.staticSetIsOnGround(siteRequest_, o)).toString();
  }

  public Boolean sqlIsOnGround() {
    return isOnGround;
  }

  public static Boolean staticJsonIsOnGround(Boolean isOnGround) {
    return isOnGround;
  }

	///////////
  // owner //
	///////////


  /**
   *  The entity owner
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject owner;

  /**
   * <br> The entity owner
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _owner(Wrap<JsonObject> w);

  public JsonObject getOwner() {
    return owner;
  }

  public void setOwner(JsonObject owner) {
    this.owner = owner;
  }
  @JsonIgnore
  public void setOwner(String o) {
    this.owner = Aircraft.staticSetOwner(siteRequest_, o);
  }
  public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Aircraft ownerInit() {
    Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
    if(owner == null) {
      _owner(ownerWrap);
      Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
        setOwner(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchOwner(siteRequest_, Aircraft.staticSetOwner(siteRequest_, o)).toString();
  }

  public JsonObject sqlOwner() {
    return owner;
  }

  public static JsonObject staticJsonOwner(JsonObject owner) {
    return owner;
  }

	//////////////////
  // registration //
	//////////////////


  /**
   *  The entity registration
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String registration;

  /**
   * <br> The entity registration
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:registration">Find the entity registration in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _registration(Wrap<String> w);

  public String getRegistration() {
    return registration;
  }
  public void setRegistration(String o) {
    this.registration = Aircraft.staticSetRegistration(siteRequest_, o);
  }
  public static String staticSetRegistration(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft registrationInit() {
    Wrap<String> registrationWrap = new Wrap<String>().var("registration");
    if(registration == null) {
      _registration(registrationWrap);
      Optional.ofNullable(registrationWrap.getO()).ifPresent(o -> {
        setRegistration(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchRegistration(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrRegistration(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRegistration(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchRegistration(siteRequest_, Aircraft.staticSetRegistration(siteRequest_, o)).toString();
  }

  public String sqlRegistration() {
    return registration;
  }

  public static String staticJsonRegistration(String registration) {
    return registration;
  }

	/////////////
  // seeAlso //
	/////////////


  /**
   *  The entity seeAlso
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String seeAlso;

  /**
   * <br> The entity seeAlso
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _seeAlso(Wrap<String> w);

  public String getSeeAlso() {
    return seeAlso;
  }
  public void setSeeAlso(String o) {
    this.seeAlso = Aircraft.staticSetSeeAlso(siteRequest_, o);
  }
  public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft seeAlsoInit() {
    Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
    if(seeAlso == null) {
      _seeAlso(seeAlsoWrap);
      Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
        setSeeAlso(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchSeeAlso(siteRequest_, Aircraft.staticSetSeeAlso(siteRequest_, o)).toString();
  }

  public String sqlSeeAlso() {
    return seeAlso;
  }

  public static String staticJsonSeeAlso(String seeAlso) {
    return seeAlso;
  }

	////////////
  // source //
	////////////


  /**
   *  The entity source
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String source;

  /**
   * <br> The entity source
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _source(Wrap<String> w);

  public String getSource() {
    return source;
  }
  public void setSource(String o) {
    this.source = Aircraft.staticSetSource(siteRequest_, o);
  }
  public static String staticSetSource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Aircraft sourceInit() {
    Wrap<String> sourceWrap = new Wrap<String>().var("source");
    if(source == null) {
      _source(sourceWrap);
      Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
        setSource(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchSource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchSource(siteRequest_, Aircraft.staticSetSource(siteRequest_, o)).toString();
  }

  public String sqlSource() {
    return source;
  }

  public static String staticJsonSource(String source) {
    return source;
  }

	///////////
  // speed //
	///////////


  /**
   *  The entity speed
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal speed;

  /**
   * <br> The entity speed
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:speed">Find the entity speed in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _speed(Wrap<BigDecimal> w);

  public BigDecimal getSpeed() {
    return speed;
  }

  public void setSpeed(BigDecimal speed) {
    this.speed = speed;
  }
  @JsonIgnore
  public void setSpeed(String o) {
    this.speed = Aircraft.staticSetSpeed(siteRequest_, o);
  }
  public static Integer staticScaleSpeed() {
    return 2;
  }
  public static MathContext staticMathContextSpeed() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetSpeed(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextSpeed()).setScale(staticScaleSpeed(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setSpeed(Double o) {
    setSpeed(new BigDecimal(o, staticMathContextSpeed()).setScale(staticScaleSpeed(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setSpeed(Integer o) {
    setSpeed(new BigDecimal(o, staticMathContextSpeed()).setScale(staticScaleSpeed(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setSpeed(Number o) {
    setSpeed(new BigDecimal(o.doubleValue(), staticMathContextSpeed()).setScale(staticScaleSpeed(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Aircraft speedInit() {
    Wrap<BigDecimal> speedWrap = new Wrap<BigDecimal>().var("speed");
    if(speed == null) {
      _speed(speedWrap);
      Optional.ofNullable(speedWrap.getO()).ifPresent(o -> {
        setSpeed(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchSpeed(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrSpeed(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSpeed(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchSpeed(siteRequest_, Aircraft.staticSetSpeed(siteRequest_, o)).toString();
  }

  public BigDecimal sqlSpeed() {
    return speed;
  }

  public static String staticJsonSpeed(BigDecimal speed) {
    return Optional.ofNullable(speed).map(v -> v.toString()).orElse(null);
  }

	///////////////////
  // verticalSpeed //
	///////////////////


  /**
   *  The entity verticalSpeed
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal verticalSpeed;

  /**
   * <br> The entity verticalSpeed
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:verticalSpeed">Find the entity verticalSpeed in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _verticalSpeed(Wrap<BigDecimal> w);

  public BigDecimal getVerticalSpeed() {
    return verticalSpeed;
  }

  public void setVerticalSpeed(BigDecimal verticalSpeed) {
    this.verticalSpeed = verticalSpeed;
  }
  @JsonIgnore
  public void setVerticalSpeed(String o) {
    this.verticalSpeed = Aircraft.staticSetVerticalSpeed(siteRequest_, o);
  }
  public static Integer staticScaleVerticalSpeed() {
    return 2;
  }
  public static MathContext staticMathContextVerticalSpeed() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetVerticalSpeed(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextVerticalSpeed()).setScale(staticScaleVerticalSpeed(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setVerticalSpeed(Double o) {
    setVerticalSpeed(new BigDecimal(o, staticMathContextVerticalSpeed()).setScale(staticScaleVerticalSpeed(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setVerticalSpeed(Integer o) {
    setVerticalSpeed(new BigDecimal(o, staticMathContextVerticalSpeed()).setScale(staticScaleVerticalSpeed(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setVerticalSpeed(Number o) {
    setVerticalSpeed(new BigDecimal(o.doubleValue(), staticMathContextVerticalSpeed()).setScale(staticScaleVerticalSpeed(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Aircraft verticalSpeedInit() {
    Wrap<BigDecimal> verticalSpeedWrap = new Wrap<BigDecimal>().var("verticalSpeed");
    if(verticalSpeed == null) {
      _verticalSpeed(verticalSpeedWrap);
      Optional.ofNullable(verticalSpeedWrap.getO()).ifPresent(o -> {
        setVerticalSpeed(o);
      });
    }
    return (Aircraft)this;
  }

  public static String staticSearchVerticalSpeed(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrVerticalSpeed(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVerticalSpeed(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchVerticalSpeed(siteRequest_, Aircraft.staticSetVerticalSpeed(siteRequest_, o)).toString();
  }

  public BigDecimal sqlVerticalSpeed() {
    return verticalSpeed;
  }

  public static String staticJsonVerticalSpeed(BigDecimal verticalSpeed) {
    return Optional.ofNullable(verticalSpeed).map(v -> v.toString()).orElse(null);
  }

	//////////////////////
  // areaServedColors //
	//////////////////////


  /**
   *  The entity areaServedColors
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> areaServedColors = new ArrayList<String>();

  /**
   * <br> The entity areaServedColors
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _areaServedColors(List<String> l);

  public List<String> getAreaServedColors() {
    return areaServedColors;
  }

  public void setAreaServedColors(List<String> areaServedColors) {
    this.areaServedColors = areaServedColors;
  }
  @JsonIgnore
  public void setAreaServedColors(String o) {
    String l = Aircraft.staticSetAreaServedColors(siteRequest_, o);
    if(l != null)
      addAreaServedColors(l);
  }
  public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Aircraft addAreaServedColors(String...objects) {
    for(String o : objects) {
      addAreaServedColors(o);
    }
    return (Aircraft)this;
  }
  public Aircraft addAreaServedColors(String o) {
    if(o != null)
      this.areaServedColors.add(o);
    return (Aircraft)this;
  }
  @JsonIgnore
  public void setAreaServedColors(JsonArray objects) {
    areaServedColors.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addAreaServedColors(o);
    }
  }
  protected Aircraft areaServedColorsInit() {
    _areaServedColors(areaServedColors);
    return (Aircraft)this;
  }

  public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAreaServedColors(siteRequest_, Aircraft.staticSetAreaServedColors(siteRequest_, o)).toString();
  }

	//////////////////////
  // areaServedTitles //
	//////////////////////


  /**
   *  The entity areaServedTitles
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> areaServedTitles = new ArrayList<String>();

  /**
   * <br> The entity areaServedTitles
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _areaServedTitles(List<String> l);

  public List<String> getAreaServedTitles() {
    return areaServedTitles;
  }

  public void setAreaServedTitles(List<String> areaServedTitles) {
    this.areaServedTitles = areaServedTitles;
  }
  @JsonIgnore
  public void setAreaServedTitles(String o) {
    String l = Aircraft.staticSetAreaServedTitles(siteRequest_, o);
    if(l != null)
      addAreaServedTitles(l);
  }
  public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Aircraft addAreaServedTitles(String...objects) {
    for(String o : objects) {
      addAreaServedTitles(o);
    }
    return (Aircraft)this;
  }
  public Aircraft addAreaServedTitles(String o) {
    if(o != null)
      this.areaServedTitles.add(o);
    return (Aircraft)this;
  }
  @JsonIgnore
  public void setAreaServedTitles(JsonArray objects) {
    areaServedTitles.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addAreaServedTitles(o);
    }
  }
  protected Aircraft areaServedTitlesInit() {
    _areaServedTitles(areaServedTitles);
    return (Aircraft)this;
  }

  public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAreaServedTitles(siteRequest_, Aircraft.staticSetAreaServedTitles(siteRequest_, o)).toString();
  }

	/////////////////////
  // areaServedLinks //
	/////////////////////


  /**
   *  The entity areaServedLinks
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> areaServedLinks = new ArrayList<String>();

  /**
   * <br> The entity areaServedLinks
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _areaServedLinks(List<String> l);

  public List<String> getAreaServedLinks() {
    return areaServedLinks;
  }

  public void setAreaServedLinks(List<String> areaServedLinks) {
    this.areaServedLinks = areaServedLinks;
  }
  @JsonIgnore
  public void setAreaServedLinks(String o) {
    String l = Aircraft.staticSetAreaServedLinks(siteRequest_, o);
    if(l != null)
      addAreaServedLinks(l);
  }
  public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Aircraft addAreaServedLinks(String...objects) {
    for(String o : objects) {
      addAreaServedLinks(o);
    }
    return (Aircraft)this;
  }
  public Aircraft addAreaServedLinks(String o) {
    if(o != null)
      this.areaServedLinks.add(o);
    return (Aircraft)this;
  }
  @JsonIgnore
  public void setAreaServedLinks(JsonArray objects) {
    areaServedLinks.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addAreaServedLinks(o);
    }
  }
  protected Aircraft areaServedLinksInit() {
    _areaServedLinks(areaServedLinks);
    return (Aircraft)this;
  }

  public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchAreaServedLinks(siteRequest_, Aircraft.staticSetAreaServedLinks(siteRequest_, o)).toString();
  }

	//////////
  // path //
	//////////


  /**
   *  The entity path
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = PgClientPathDeserializer.class)
  @JsonSerialize(using = PgClientPathSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Path path;

  /**
   * <br> The entity path
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:path">Find the entity path in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _path(Wrap<Path> w);

  public Path getPath() {
    return path;
  }

  public void setPath(Path path) {
    this.path = path;
  }
  @JsonIgnore
  public void setPath(String o) {
    this.path = Aircraft.staticSetPath(siteRequest_, o);
  }
  public static Path staticSetPath(SiteRequest siteRequest_, String o) {
    if(o != null) {
      try {
        Path shape = null;
        if(StringUtils.isNotBlank(o)) {
          SimpleModule module = new SimpleModule();
          module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
              if (beanDesc.getBeanClass() == Path.class) {
                return new PgClientPathDeserializer();
              }
              return deserializer;
            }
          });
          ObjectMapper objectMapper = JsonMapper.builder().addModule(module).build();
          shape = objectMapper.readValue(Json.encode(o), Path.class);
        }
        return shape;
      } catch(Exception ex) {
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
      }
    }
    return null;
  }
  @JsonIgnore
  public void setPath(JsonObject o) {
    this.path = Aircraft.staticSetPath(siteRequest_, o);
  }
  public static Path staticSetPath(SiteRequest siteRequest_, JsonObject o) {
    if(o != null) {
      try {
        Path shape = new Path();
        o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(points -> {
          shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
        });
        return shape;
      } catch(Exception ex) {
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
      }
    }
    return null;
  }
  protected Aircraft pathInit() {
    Wrap<Path> pathWrap = new Wrap<Path>().var("path");
    if(path == null) {
      _path(pathWrap);
      Optional.ofNullable(pathWrap.getO()).ifPresent(o -> {
        setPath(o);
      });
    }
    return (Aircraft)this;
  }

  public static Path staticSearchPath(SiteRequest siteRequest_, Path o) {
    return o;
  }

  public static String staticSearchStrPath(SiteRequest siteRequest_, Path o) {
    JsonArray pointsArray = new JsonArray();
    o.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
    return new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString();
  }

  public static String staticSearchFqPath(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchPath(siteRequest_, Aircraft.staticSetPath(siteRequest_, o)).toString();
  }

  public Path sqlPath() {
    return path;
  }

  public static JsonObject staticJsonPath(Path path) {
    return Optional.ofNullable(path).map(v -> VertxTool.toGeoJson(v)).orElse(null);
  }

	////////////////
  // simulation //
	////////////////


  /**
   *  The entity simulation
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean simulation;

  /**
   * <br> The entity simulation
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:simulation">Find the entity simulation in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _simulation(Wrap<Boolean> w);

  public Boolean getSimulation() {
    return simulation;
  }

  public void setSimulation(Boolean simulation) {
    this.simulation = simulation;
  }
  @JsonIgnore
  public void setSimulation(String o) {
    this.simulation = Aircraft.staticSetSimulation(siteRequest_, o);
  }
  public static Boolean staticSetSimulation(SiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected Aircraft simulationInit() {
    Wrap<Boolean> simulationWrap = new Wrap<Boolean>().var("simulation");
    if(simulation == null) {
      _simulation(simulationWrap);
      Optional.ofNullable(simulationWrap.getO()).ifPresent(o -> {
        setSimulation(o);
      });
    }
    return (Aircraft)this;
  }

  public static Boolean staticSearchSimulation(SiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrSimulation(SiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSimulation(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchSimulation(siteRequest_, Aircraft.staticSetSimulation(siteRequest_, o)).toString();
  }

  public Boolean sqlSimulation() {
    return simulation;
  }

  public static Boolean staticJsonSimulation(Boolean simulation) {
    return simulation;
  }

	///////////////////////////
  // simulationDelayMillis //
	///////////////////////////


  /**
   *  The entity simulationDelayMillis
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long simulationDelayMillis;

  /**
   * <br> The entity simulationDelayMillis
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.aircraft.Aircraft&fq=entiteVar_enUS_indexed_string:simulationDelayMillis">Find the entity simulationDelayMillis in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _simulationDelayMillis(Wrap<Long> w);

  public Long getSimulationDelayMillis() {
    return simulationDelayMillis;
  }

  public void setSimulationDelayMillis(Long simulationDelayMillis) {
    this.simulationDelayMillis = simulationDelayMillis;
  }
  @JsonIgnore
  public void setSimulationDelayMillis(String o) {
    this.simulationDelayMillis = Aircraft.staticSetSimulationDelayMillis(siteRequest_, o);
  }
  public static Long staticSetSimulationDelayMillis(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected Aircraft simulationDelayMillisInit() {
    Wrap<Long> simulationDelayMillisWrap = new Wrap<Long>().var("simulationDelayMillis");
    if(simulationDelayMillis == null) {
      _simulationDelayMillis(simulationDelayMillisWrap);
      Optional.ofNullable(simulationDelayMillisWrap.getO()).ifPresent(o -> {
        setSimulationDelayMillis(o);
      });
    }
    return (Aircraft)this;
  }

  public static Long staticSearchSimulationDelayMillis(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrSimulationDelayMillis(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSimulationDelayMillis(SiteRequest siteRequest_, String o) {
    return Aircraft.staticSearchSimulationDelayMillis(siteRequest_, Aircraft.staticSetSimulationDelayMillis(siteRequest_, o)).toString();
  }

  public Long sqlSimulationDelayMillis() {
    return simulationDelayMillis;
  }

  public static String staticJsonSimulationDelayMillis(Long simulationDelayMillis) {
    return Optional.ofNullable(simulationDelayMillis).map(v -> v.toString()).orElse(null);
  }

  //////////////
  // initDeep //
  //////////////

  public Future<AircraftGen<DEV>> promiseDeepAircraft(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepAircraft();
  }

  public Future<AircraftGen<DEV>> promiseDeepAircraft() {
    Promise<AircraftGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseAircraft(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepMapModel(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseAircraft(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        timeZoneInit();
        airportIdInit();
        departureDateInit();
        arrivalDateInit();
        avgSpeedInMphInit();
        addressInit();
        alternateNameInit();
        belongsToAircraftModelInit();
        dataProviderInit();
        dateCreatedInit();
        dateIssuedInit();
        dateModifiedInit();
        headingInit();
        isOnGroundInit();
        ownerInit();
        registrationInit();
        seeAlsoInit();
        sourceInit();
        speedInit();
        verticalSpeedInit();
        areaServedColorsInit();
        areaServedTitlesInit();
        areaServedLinksInit();
        pathInit();
        simulationInit();
        simulationDelayMillisInit();
        promise2.complete();
      } catch(Exception ex) {
        promise2.fail(ex);
      }
      return promise2.future();
    }).onSuccess(a -> {
      promise.complete();
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  @Override public Future<? extends AircraftGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepAircraft(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestAircraft(SiteRequest siteRequest_) {
      super.siteRequestMapModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestAircraft(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainAircraft(v);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.obtainForClass(v);
      }
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainAircraft(String var) {
    Aircraft oAircraft = (Aircraft)this;
    switch(var) {
      case "timeZone":
        return oAircraft.timeZone;
      case "airportId":
        return oAircraft.airportId;
      case "departureDate":
        return oAircraft.departureDate;
      case "arrivalDate":
        return oAircraft.arrivalDate;
      case "avgSpeedInMph":
        return oAircraft.avgSpeedInMph;
      case "address":
        return oAircraft.address;
      case "alternateName":
        return oAircraft.alternateName;
      case "belongsToAircraftModel":
        return oAircraft.belongsToAircraftModel;
      case "dataProvider":
        return oAircraft.dataProvider;
      case "dateCreated":
        return oAircraft.dateCreated;
      case "dateIssued":
        return oAircraft.dateIssued;
      case "dateModified":
        return oAircraft.dateModified;
      case "heading":
        return oAircraft.heading;
      case "isOnGround":
        return oAircraft.isOnGround;
      case "owner":
        return oAircraft.owner;
      case "registration":
        return oAircraft.registration;
      case "seeAlso":
        return oAircraft.seeAlso;
      case "source":
        return oAircraft.source;
      case "speed":
        return oAircraft.speed;
      case "verticalSpeed":
        return oAircraft.verticalSpeed;
      case "areaServedColors":
        return oAircraft.areaServedColors;
      case "areaServedTitles":
        return oAircraft.areaServedTitles;
      case "areaServedLinks":
        return oAircraft.areaServedLinks;
      case "path":
        return oAircraft.path;
      case "simulation":
        return oAircraft.simulation;
      case "simulationDelayMillis":
        return oAircraft.simulationDelayMillis;
      default:
        return super.obtainMapModel(var);
    }
  }

  ///////////////
  // relate //
  ///////////////

  @Override public boolean relateForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = relateAircraft(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateAircraft(String var, Object val) {
    Aircraft oAircraft = (Aircraft)this;
    switch(var) {
      case "timeZone":
        if(oAircraft.getTimeZone() == null)
          oAircraft.setTimeZone(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
        if(!saves.contains("timeZone"))
          saves.add("timeZone");
        return val;
      case "airportId":
        if(oAircraft.getAirportId() == null)
          oAircraft.setAirportId(Optional.ofNullable(val).map(v -> v.toString()).orElse(null));
        if(!saves.contains("airportId"))
          saves.add("airportId");
        return val;
      default:
        return super.relateMapModel(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, Aircraft o) {
    return staticSetAircraft(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetAircraft(String entityVar, SiteRequest siteRequest_, String v, Aircraft o) {
    switch(entityVar) {
    case "timeZone":
      return Aircraft.staticSetTimeZone(siteRequest_, v);
    case "airportId":
      return Aircraft.staticSetAirportId(siteRequest_, v);
    case "departureDate":
      return Aircraft.staticSetDepartureDate(siteRequest_, v, Optional.ofNullable(o.getTimeZone()).map(zoneId -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
    case "arrivalDate":
      return Aircraft.staticSetArrivalDate(siteRequest_, v, Optional.ofNullable(o.getTimeZone()).map(zoneId -> ZoneId.of(v)).orElse(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
    case "avgSpeedInMph":
      return Aircraft.staticSetAvgSpeedInMph(siteRequest_, v);
    case "address":
      return Aircraft.staticSetAddress(siteRequest_, v);
    case "alternateName":
      return Aircraft.staticSetAlternateName(siteRequest_, v);
    case "belongsToAircraftModel":
      return Aircraft.staticSetBelongsToAircraftModel(siteRequest_, v);
    case "dataProvider":
      return Aircraft.staticSetDataProvider(siteRequest_, v);
    case "dateCreated":
      return Aircraft.staticSetDateCreated(siteRequest_, v);
    case "dateIssued":
      return Aircraft.staticSetDateIssued(siteRequest_, v);
    case "dateModified":
      return Aircraft.staticSetDateModified(siteRequest_, v);
    case "heading":
      return Aircraft.staticSetHeading(siteRequest_, v);
    case "isOnGround":
      return Aircraft.staticSetIsOnGround(siteRequest_, v);
    case "owner":
      return Aircraft.staticSetOwner(siteRequest_, v);
    case "registration":
      return Aircraft.staticSetRegistration(siteRequest_, v);
    case "seeAlso":
      return Aircraft.staticSetSeeAlso(siteRequest_, v);
    case "source":
      return Aircraft.staticSetSource(siteRequest_, v);
    case "speed":
      return Aircraft.staticSetSpeed(siteRequest_, v);
    case "verticalSpeed":
      return Aircraft.staticSetVerticalSpeed(siteRequest_, v);
    case "areaServedColors":
      return Aircraft.staticSetAreaServedColors(siteRequest_, v);
    case "areaServedTitles":
      return Aircraft.staticSetAreaServedTitles(siteRequest_, v);
    case "areaServedLinks":
      return Aircraft.staticSetAreaServedLinks(siteRequest_, v);
    case "path":
      return Aircraft.staticSetPath(siteRequest_, v);
    case "simulation":
      return Aircraft.staticSetSimulation(siteRequest_, v);
    case "simulationDelayMillis":
      return Aircraft.staticSetSimulationDelayMillis(siteRequest_, v);
      default:
        return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Future<Aircraft> fqAircraft(SiteRequest siteRequest, String var, Object val) {
    Promise<Aircraft> promise = Promise.promise();
    try {
      if(val == null) {
        promise.complete();
      } else {
        SearchList<Aircraft> searchList = new SearchList<Aircraft>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(Aircraft.class);
        searchList.fq(String.format("%s:", Aircraft.varIndexedAircraft(var)) + SearchTool.escapeQueryChars(val.toString()));
        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          try {
            promise.complete(searchList.getList().stream().findFirst().orElse(null));
          } catch(Throwable ex) {
            LOG.error("Error while querying theAircraft", ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error("Error while querying theAircraft", ex);
          promise.fail(ex);
        });
      }
    } catch(Throwable ex) {
      LOG.error("Error while querying theAircraft", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchAircraft(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchAircraft(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "timeZone":
      return Aircraft.staticSearchTimeZone(siteRequest_, (String)o);
    case "airportId":
      return Aircraft.staticSearchAirportId(siteRequest_, (String)o);
    case "departureDate":
      return Aircraft.staticSearchDepartureDate(siteRequest_, (ZonedDateTime)o);
    case "arrivalDate":
      return Aircraft.staticSearchArrivalDate(siteRequest_, (ZonedDateTime)o);
    case "avgSpeedInMph":
      return Aircraft.staticSearchAvgSpeedInMph(siteRequest_, (BigDecimal)o);
    case "address":
      return Aircraft.staticSearchAddress(siteRequest_, (JsonObject)o);
    case "alternateName":
      return Aircraft.staticSearchAlternateName(siteRequest_, (String)o);
    case "belongsToAircraftModel":
      return Aircraft.staticSearchBelongsToAircraftModel(siteRequest_, (String)o);
    case "dataProvider":
      return Aircraft.staticSearchDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return Aircraft.staticSearchDateCreated(siteRequest_, (String)o);
    case "dateIssued":
      return Aircraft.staticSearchDateIssued(siteRequest_, (String)o);
    case "dateModified":
      return Aircraft.staticSearchDateModified(siteRequest_, (String)o);
    case "heading":
      return Aircraft.staticSearchHeading(siteRequest_, (BigDecimal)o);
    case "isOnGround":
      return Aircraft.staticSearchIsOnGround(siteRequest_, (Boolean)o);
    case "owner":
      return Aircraft.staticSearchOwner(siteRequest_, (JsonObject)o);
    case "registration":
      return Aircraft.staticSearchRegistration(siteRequest_, (String)o);
    case "seeAlso":
      return Aircraft.staticSearchSeeAlso(siteRequest_, (String)o);
    case "source":
      return Aircraft.staticSearchSource(siteRequest_, (String)o);
    case "speed":
      return Aircraft.staticSearchSpeed(siteRequest_, (BigDecimal)o);
    case "verticalSpeed":
      return Aircraft.staticSearchVerticalSpeed(siteRequest_, (BigDecimal)o);
    case "areaServedColors":
      return Aircraft.staticSearchAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return Aircraft.staticSearchAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return Aircraft.staticSearchAreaServedLinks(siteRequest_, (String)o);
    case "path":
      return Aircraft.staticSearchPath(siteRequest_, (Path)o);
    case "simulation":
      return Aircraft.staticSearchSimulation(siteRequest_, (Boolean)o);
    case "simulationDelayMillis":
      return Aircraft.staticSearchSimulationDelayMillis(siteRequest_, (Long)o);
      default:
        return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrAircraft(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrAircraft(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "timeZone":
      return Aircraft.staticSearchStrTimeZone(siteRequest_, (String)o);
    case "airportId":
      return Aircraft.staticSearchStrAirportId(siteRequest_, (String)o);
    case "departureDate":
      return Aircraft.staticSearchStrDepartureDate(siteRequest_, (String)o);
    case "arrivalDate":
      return Aircraft.staticSearchStrArrivalDate(siteRequest_, (String)o);
    case "avgSpeedInMph":
      return Aircraft.staticSearchStrAvgSpeedInMph(siteRequest_, (String)o);
    case "address":
      return Aircraft.staticSearchStrAddress(siteRequest_, (String)o);
    case "alternateName":
      return Aircraft.staticSearchStrAlternateName(siteRequest_, (String)o);
    case "belongsToAircraftModel":
      return Aircraft.staticSearchStrBelongsToAircraftModel(siteRequest_, (String)o);
    case "dataProvider":
      return Aircraft.staticSearchStrDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return Aircraft.staticSearchStrDateCreated(siteRequest_, (String)o);
    case "dateIssued":
      return Aircraft.staticSearchStrDateIssued(siteRequest_, (String)o);
    case "dateModified":
      return Aircraft.staticSearchStrDateModified(siteRequest_, (String)o);
    case "heading":
      return Aircraft.staticSearchStrHeading(siteRequest_, (String)o);
    case "isOnGround":
      return Aircraft.staticSearchStrIsOnGround(siteRequest_, (Boolean)o);
    case "owner":
      return Aircraft.staticSearchStrOwner(siteRequest_, (String)o);
    case "registration":
      return Aircraft.staticSearchStrRegistration(siteRequest_, (String)o);
    case "seeAlso":
      return Aircraft.staticSearchStrSeeAlso(siteRequest_, (String)o);
    case "source":
      return Aircraft.staticSearchStrSource(siteRequest_, (String)o);
    case "speed":
      return Aircraft.staticSearchStrSpeed(siteRequest_, (String)o);
    case "verticalSpeed":
      return Aircraft.staticSearchStrVerticalSpeed(siteRequest_, (String)o);
    case "areaServedColors":
      return Aircraft.staticSearchStrAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return Aircraft.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return Aircraft.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
    case "path":
      return Aircraft.staticSearchStrPath(siteRequest_, (Path)o);
    case "simulation":
      return Aircraft.staticSearchStrSimulation(siteRequest_, (Boolean)o);
    case "simulationDelayMillis":
      return Aircraft.staticSearchStrSimulationDelayMillis(siteRequest_, (Long)o);
      default:
        return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqAircraft(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqAircraft(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "timeZone":
      return Aircraft.staticSearchFqTimeZone(siteRequest_, o);
    case "airportId":
      return Aircraft.staticSearchFqAirportId(siteRequest_, o);
    case "departureDate":
      return Aircraft.staticSearchFqDepartureDate(siteRequest_, o);
    case "arrivalDate":
      return Aircraft.staticSearchFqArrivalDate(siteRequest_, o);
    case "avgSpeedInMph":
      return Aircraft.staticSearchFqAvgSpeedInMph(siteRequest_, o);
    case "address":
      return Aircraft.staticSearchFqAddress(siteRequest_, o);
    case "alternateName":
      return Aircraft.staticSearchFqAlternateName(siteRequest_, o);
    case "belongsToAircraftModel":
      return Aircraft.staticSearchFqBelongsToAircraftModel(siteRequest_, o);
    case "dataProvider":
      return Aircraft.staticSearchFqDataProvider(siteRequest_, o);
    case "dateCreated":
      return Aircraft.staticSearchFqDateCreated(siteRequest_, o);
    case "dateIssued":
      return Aircraft.staticSearchFqDateIssued(siteRequest_, o);
    case "dateModified":
      return Aircraft.staticSearchFqDateModified(siteRequest_, o);
    case "heading":
      return Aircraft.staticSearchFqHeading(siteRequest_, o);
    case "isOnGround":
      return Aircraft.staticSearchFqIsOnGround(siteRequest_, o);
    case "owner":
      return Aircraft.staticSearchFqOwner(siteRequest_, o);
    case "registration":
      return Aircraft.staticSearchFqRegistration(siteRequest_, o);
    case "seeAlso":
      return Aircraft.staticSearchFqSeeAlso(siteRequest_, o);
    case "source":
      return Aircraft.staticSearchFqSource(siteRequest_, o);
    case "speed":
      return Aircraft.staticSearchFqSpeed(siteRequest_, o);
    case "verticalSpeed":
      return Aircraft.staticSearchFqVerticalSpeed(siteRequest_, o);
    case "areaServedColors":
      return Aircraft.staticSearchFqAreaServedColors(siteRequest_, o);
    case "areaServedTitles":
      return Aircraft.staticSearchFqAreaServedTitles(siteRequest_, o);
    case "areaServedLinks":
      return Aircraft.staticSearchFqAreaServedLinks(siteRequest_, o);
    case "path":
      return Aircraft.staticSearchFqPath(siteRequest_, o);
    case "simulation":
      return Aircraft.staticSearchFqSimulation(siteRequest_, o);
    case "simulationDelayMillis":
      return Aircraft.staticSearchFqSimulationDelayMillis(siteRequest_, o);
      default:
        return MapModel.staticSearchFqMapModel(entityVar,  siteRequest_, o);
    }
  }

  /////////////
  // persist //
  /////////////

  @Override public boolean persistForClass(String var, Object val) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    if(val != null) {
      for(String v : vars) {
        if(o == null)
          o = persistAircraft(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistAircraft(String var, Object val) {
    String varLower = var.toLowerCase();
      if("timezone".equals(varLower)) {
        if(val instanceof String) {
          setTimeZone((String)val);
        }
        saves.add("timeZone");
        return val;
      } else if("airportid".equals(varLower)) {
        if(val instanceof String) {
          setAirportId((String)val);
        }
        saves.add("airportId");
        return val;
      } else if("departuredate".equals(varLower)) {
        if(val instanceof String) {
          setDepartureDate((String)val);
        } else if(val instanceof OffsetDateTime) {
          setDepartureDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        } else if(val instanceof ZonedDateTime) {
          setDepartureDate((ZonedDateTime)val);
        }
        saves.add("departureDate");
        return val;
      } else if("arrivaldate".equals(varLower)) {
        if(val instanceof String) {
          setArrivalDate((String)val);
        } else if(val instanceof OffsetDateTime) {
          setArrivalDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        } else if(val instanceof ZonedDateTime) {
          setArrivalDate((ZonedDateTime)val);
        }
        saves.add("arrivalDate");
        return val;
      } else if("avgspeedinmph".equals(varLower)) {
        if(val instanceof String) {
          setAvgSpeedInMph((String)val);
        } else if(val instanceof Number) {
          setAvgSpeedInMph(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setAvgSpeedInMph((BigDecimal)val);
        }
        saves.add("avgSpeedInMph");
        return val;
      } else if("address".equals(varLower)) {
        if(val instanceof String) {
          setAddress((String)val);
        } else if(val instanceof JsonObject) {
          setAddress((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setAddress((JsonObject)val);
        }
        saves.add("address");
        return val;
      } else if("alternatename".equals(varLower)) {
        if(val instanceof String) {
          setAlternateName((String)val);
        }
        saves.add("alternateName");
        return val;
      } else if("belongstoaircraftmodel".equals(varLower)) {
        if(val instanceof String) {
          setBelongsToAircraftModel((String)val);
        }
        saves.add("belongsToAircraftModel");
        return val;
      } else if("dataprovider".equals(varLower)) {
        if(val instanceof String) {
          setDataProvider((String)val);
        }
        saves.add("dataProvider");
        return val;
      } else if("datecreated".equals(varLower)) {
        if(val instanceof String) {
          setDateCreated((String)val);
        }
        saves.add("dateCreated");
        return val;
      } else if("dateissued".equals(varLower)) {
        if(val instanceof String) {
          setDateIssued((String)val);
        }
        saves.add("dateIssued");
        return val;
      } else if("datemodified".equals(varLower)) {
        if(val instanceof String) {
          setDateModified((String)val);
        }
        saves.add("dateModified");
        return val;
      } else if("heading".equals(varLower)) {
        if(val instanceof String) {
          setHeading((String)val);
        } else if(val instanceof Number) {
          setHeading(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setHeading((BigDecimal)val);
        }
        saves.add("heading");
        return val;
      } else if("isonground".equals(varLower)) {
        if(val instanceof Boolean) {
          setIsOnGround((Boolean)val);
        } else {
          setIsOnGround(val == null ? null : val.toString());
        }
        saves.add("isOnGround");
        return val;
      } else if("owner".equals(varLower)) {
        if(val instanceof String) {
          setOwner((String)val);
        } else if(val instanceof JsonObject) {
          setOwner((JsonObject)val);
        } else if(val instanceof JsonObject) {
          setOwner((JsonObject)val);
        }
        saves.add("owner");
        return val;
      } else if("registration".equals(varLower)) {
        if(val instanceof String) {
          setRegistration((String)val);
        }
        saves.add("registration");
        return val;
      } else if("seealso".equals(varLower)) {
        if(val instanceof String) {
          setSeeAlso((String)val);
        }
        saves.add("seeAlso");
        return val;
      } else if("source".equals(varLower)) {
        if(val instanceof String) {
          setSource((String)val);
        }
        saves.add("source");
        return val;
      } else if("speed".equals(varLower)) {
        if(val instanceof String) {
          setSpeed((String)val);
        } else if(val instanceof Number) {
          setSpeed(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setSpeed((BigDecimal)val);
        }
        saves.add("speed");
        return val;
      } else if("verticalspeed".equals(varLower)) {
        if(val instanceof String) {
          setVerticalSpeed((String)val);
        } else if(val instanceof Number) {
          setVerticalSpeed(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setVerticalSpeed((BigDecimal)val);
        }
        saves.add("verticalSpeed");
        return val;
      } else if("path".equals(varLower)) {
        if(val instanceof Path) {
          setPath((Path)val);
        } else {
          setPath(val == null ? null : val.toString());
        }
        saves.add("path");
        return val;
      } else if("simulation".equals(varLower)) {
        if(val instanceof Boolean) {
          setSimulation((Boolean)val);
        } else {
          setSimulation(val == null ? null : val.toString());
        }
        saves.add("simulation");
        return val;
      } else if("simulationdelaymillis".equals(varLower)) {
        if(val instanceof Long) {
          setSimulationDelayMillis((Long)val);
        } else {
          setSimulationDelayMillis(val == null ? null : val.toString());
        }
        saves.add("simulationDelayMillis");
        return val;
    } else {
      return super.persistMapModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateAircraft(doc);
  }
  public void populateAircraft(SolrResponse.Doc doc) {
    Aircraft oAircraft = (Aircraft)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      String timeZone = (String)doc.get("timeZone_docvalues_string");
      if(timeZone != null)
        oAircraft.setTimeZone(timeZone);

      String airportId = (String)doc.get("airportId_docvalues_string");
      if(airportId != null)
        oAircraft.setAirportId(airportId);

      if(saves.contains("departureDate")) {
        String departureDate = (String)doc.get("departureDate_docvalues_date");
        if(departureDate != null)
          oAircraft.setDepartureDate(departureDate);
      }

      if(saves.contains("arrivalDate")) {
        String arrivalDate = (String)doc.get("arrivalDate_docvalues_date");
        if(arrivalDate != null)
          oAircraft.setArrivalDate(arrivalDate);
      }

      if(saves.contains("avgSpeedInMph")) {
        String avgSpeedInMph = (String)doc.get("avgSpeedInMph_docvalues_string");
        if(avgSpeedInMph != null)
          oAircraft.setAvgSpeedInMph(avgSpeedInMph);
      }

      if(saves.contains("address")) {
        String address = (String)doc.get("address_docvalues_string");
        if(address != null)
          oAircraft.setAddress(address);
      }

      if(saves.contains("alternateName")) {
        String alternateName = (String)doc.get("alternateName_docvalues_string");
        if(alternateName != null)
          oAircraft.setAlternateName(alternateName);
      }

      if(saves.contains("belongsToAircraftModel")) {
        String belongsToAircraftModel = (String)doc.get("belongsToAircraftModel_docvalues_string");
        if(belongsToAircraftModel != null)
          oAircraft.setBelongsToAircraftModel(belongsToAircraftModel);
      }

      if(saves.contains("dataProvider")) {
        String dataProvider = (String)doc.get("dataProvider_docvalues_string");
        if(dataProvider != null)
          oAircraft.setDataProvider(dataProvider);
      }

      if(saves.contains("dateCreated")) {
        String dateCreated = (String)doc.get("dateCreated_docvalues_string");
        if(dateCreated != null)
          oAircraft.setDateCreated(dateCreated);
      }

      if(saves.contains("dateIssued")) {
        String dateIssued = (String)doc.get("dateIssued_docvalues_string");
        if(dateIssued != null)
          oAircraft.setDateIssued(dateIssued);
      }

      if(saves.contains("dateModified")) {
        String dateModified = (String)doc.get("dateModified_docvalues_string");
        if(dateModified != null)
          oAircraft.setDateModified(dateModified);
      }

      if(saves.contains("heading")) {
        String heading = (String)doc.get("heading_docvalues_string");
        if(heading != null)
          oAircraft.setHeading(heading);
      }

      if(saves.contains("isOnGround")) {
        Boolean isOnGround = (Boolean)doc.get("isOnGround_docvalues_boolean");
        if(isOnGround != null)
          oAircraft.setIsOnGround(isOnGround);
      }

      if(saves.contains("owner")) {
        String owner = (String)doc.get("owner_docvalues_string");
        if(owner != null)
          oAircraft.setOwner(owner);
      }

      if(saves.contains("registration")) {
        String registration = (String)doc.get("registration_docvalues_string");
        if(registration != null)
          oAircraft.setRegistration(registration);
      }

      if(saves.contains("seeAlso")) {
        String seeAlso = (String)doc.get("seeAlso_docvalues_string");
        if(seeAlso != null)
          oAircraft.setSeeAlso(seeAlso);
      }

      if(saves.contains("source")) {
        String source = (String)doc.get("source_docvalues_string");
        if(source != null)
          oAircraft.setSource(source);
      }

      if(saves.contains("speed")) {
        String speed = (String)doc.get("speed_docvalues_string");
        if(speed != null)
          oAircraft.setSpeed(speed);
      }

      if(saves.contains("verticalSpeed")) {
        String verticalSpeed = (String)doc.get("verticalSpeed_docvalues_string");
        if(verticalSpeed != null)
          oAircraft.setVerticalSpeed(verticalSpeed);
      }

      if(saves.contains("areaServedColors")) {
        List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
        if(areaServedColors != null) {
          areaServedColors.stream().forEach( v -> {
            oAircraft.areaServedColors.add(Aircraft.staticSetAreaServedColors(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedTitles")) {
        List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
        if(areaServedTitles != null) {
          areaServedTitles.stream().forEach( v -> {
            oAircraft.areaServedTitles.add(Aircraft.staticSetAreaServedTitles(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedLinks")) {
        List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
        if(areaServedLinks != null) {
          areaServedLinks.stream().forEach( v -> {
            oAircraft.areaServedLinks.add(Aircraft.staticSetAreaServedLinks(siteRequest_, v));
          });
        }
      }

      if(saves.contains("path")) {
        Path path = (Path)doc.get("path_docvalues_location");
        if(path != null)
          oAircraft.setPath(path);
      }

      if(saves.contains("simulation")) {
        Boolean simulation = (Boolean)doc.get("simulation_docvalues_boolean");
        if(simulation != null)
          oAircraft.setSimulation(simulation);
      }

      if(saves.contains("simulationDelayMillis")) {
        Long simulationDelayMillis = (Long)doc.get("simulationDelayMillis_docvalues_long");
        if(simulationDelayMillis != null)
          oAircraft.setSimulationDelayMillis(simulationDelayMillis);
      }
    }

    super.populateMapModel(doc);
  }

  public void indexAircraft(JsonObject doc) {
    if(timeZone != null) {
      doc.put("timeZone_docvalues_string", timeZone);
    }
    if(airportId != null) {
      doc.put("airportId_docvalues_string", airportId);
    }
    if(departureDate != null) {
      doc.put("departureDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(departureDate.toInstant(), ZoneId.of("UTC"))));
    }
    if(arrivalDate != null) {
      doc.put("arrivalDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(arrivalDate.toInstant(), ZoneId.of("UTC"))));
    }
    if(avgSpeedInMph != null) {
      doc.put("avgSpeedInMph_docvalues_string", avgSpeedInMph.toPlainString());
      doc.put("avgSpeedInMph_docvalues_double", avgSpeedInMph.doubleValue());
    }
    if(address != null) {
      doc.put("address_docvalues_string", address.encode());
    }
    if(alternateName != null) {
      doc.put("alternateName_docvalues_string", alternateName);
    }
    if(belongsToAircraftModel != null) {
      doc.put("belongsToAircraftModel_docvalues_string", belongsToAircraftModel);
    }
    if(dataProvider != null) {
      doc.put("dataProvider_docvalues_string", dataProvider);
    }
    if(dateCreated != null) {
      doc.put("dateCreated_docvalues_string", dateCreated);
    }
    if(dateIssued != null) {
      doc.put("dateIssued_docvalues_string", dateIssued);
    }
    if(dateModified != null) {
      doc.put("dateModified_docvalues_string", dateModified);
    }
    if(heading != null) {
      doc.put("heading_docvalues_string", heading.toPlainString());
      doc.put("heading_docvalues_double", heading.doubleValue());
    }
    if(isOnGround != null) {
      doc.put("isOnGround_docvalues_boolean", isOnGround);
    }
    if(owner != null) {
      doc.put("owner_docvalues_string", owner.encode());
    }
    if(registration != null) {
      doc.put("registration_docvalues_string", registration);
    }
    if(seeAlso != null) {
      doc.put("seeAlso_docvalues_string", seeAlso);
    }
    if(source != null) {
      doc.put("source_docvalues_string", source);
    }
    if(speed != null) {
      doc.put("speed_docvalues_string", speed.toPlainString());
      doc.put("speed_docvalues_double", speed.doubleValue());
    }
    if(verticalSpeed != null) {
      doc.put("verticalSpeed_docvalues_string", verticalSpeed.toPlainString());
      doc.put("verticalSpeed_docvalues_double", verticalSpeed.doubleValue());
    }
    if(areaServedColors != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedColors_indexedstored_strings", l);
      for(String o : areaServedColors) {
        l.add(Aircraft.staticSearchAreaServedColors(siteRequest_, o));
      }
    }
    if(areaServedTitles != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedTitles_indexedstored_strings", l);
      for(String o : areaServedTitles) {
        l.add(Aircraft.staticSearchAreaServedTitles(siteRequest_, o));
      }
    }
    if(areaServedLinks != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedLinks_indexedstored_strings", l);
      for(String o : areaServedLinks) {
        l.add(Aircraft.staticSearchAreaServedLinks(siteRequest_, o));
      }
    }
    if(path != null) {
      JsonArray pointsArray = new JsonArray();
      path.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
      doc.put("path_docvalues_location", new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString());
    }
    if(simulation != null) {
      doc.put("simulation_docvalues_boolean", simulation);
    }
    if(simulationDelayMillis != null) {
      doc.put("simulationDelayMillis_docvalues_long", simulationDelayMillis);
    }
    super.indexMapModel(doc);

	}

  public static String varStoredAircraft(String entityVar) {
    switch(entityVar) {
      case "timeZone":
        return "timeZone_docvalues_string";
      case "airportId":
        return "airportId_docvalues_string";
      case "departureDate":
        return "departureDate_docvalues_date";
      case "arrivalDate":
        return "arrivalDate_docvalues_date";
      case "avgSpeedInMph":
        return "avgSpeedInMph_docvalues_string";
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "belongsToAircraftModel":
        return "belongsToAircraftModel_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateIssued":
        return "dateIssued_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "heading":
        return "heading_docvalues_string";
      case "isOnGround":
        return "isOnGround_docvalues_boolean";
      case "owner":
        return "owner_docvalues_string";
      case "registration":
        return "registration_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "speed":
        return "speed_docvalues_string";
      case "verticalSpeed":
        return "verticalSpeed_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "path":
        return "path_docvalues_location";
      case "simulation":
        return "simulation_docvalues_boolean";
      case "simulationDelayMillis":
        return "simulationDelayMillis_docvalues_long";
      default:
        return MapModel.varStoredMapModel(entityVar);
    }
  }

  public static String varIndexedAircraft(String entityVar) {
    switch(entityVar) {
      case "timeZone":
        return "timeZone_docvalues_string";
      case "airportId":
        return "airportId_docvalues_string";
      case "departureDate":
        return "departureDate_docvalues_date";
      case "arrivalDate":
        return "arrivalDate_docvalues_date";
      case "avgSpeedInMph":
        return "avgSpeedInMph_docvalues_string";
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "belongsToAircraftModel":
        return "belongsToAircraftModel_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateIssued":
        return "dateIssued_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "heading":
        return "heading_docvalues_string";
      case "isOnGround":
        return "isOnGround_docvalues_boolean";
      case "owner":
        return "owner_docvalues_string";
      case "registration":
        return "registration_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "speed":
        return "speed_docvalues_string";
      case "verticalSpeed":
        return "verticalSpeed_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "path":
        return "path_docvalues_location";
      case "simulation":
        return "simulation_docvalues_boolean";
      case "simulationDelayMillis":
        return "simulationDelayMillis_docvalues_long";
      default:
        return MapModel.varIndexedMapModel(entityVar);
    }
  }

  public static String searchVarAircraft(String searchVar) {
    switch(searchVar) {
      case "timeZone_docvalues_string":
        return "timeZone";
      case "airportId_docvalues_string":
        return "airportId";
      case "departureDate_docvalues_date":
        return "departureDate";
      case "arrivalDate_docvalues_date":
        return "arrivalDate";
      case "avgSpeedInMph_docvalues_string":
        return "avgSpeedInMph";
      case "address_docvalues_string":
        return "address";
      case "alternateName_docvalues_string":
        return "alternateName";
      case "belongsToAircraftModel_docvalues_string":
        return "belongsToAircraftModel";
      case "dataProvider_docvalues_string":
        return "dataProvider";
      case "dateCreated_docvalues_string":
        return "dateCreated";
      case "dateIssued_docvalues_string":
        return "dateIssued";
      case "dateModified_docvalues_string":
        return "dateModified";
      case "heading_docvalues_string":
        return "heading";
      case "isOnGround_docvalues_boolean":
        return "isOnGround";
      case "owner_docvalues_string":
        return "owner";
      case "registration_docvalues_string":
        return "registration";
      case "seeAlso_docvalues_string":
        return "seeAlso";
      case "source_docvalues_string":
        return "source";
      case "speed_docvalues_string":
        return "speed";
      case "verticalSpeed_docvalues_string":
        return "verticalSpeed";
      case "areaServedColors_indexedstored_strings":
        return "areaServedColors";
      case "areaServedTitles_indexedstored_strings":
        return "areaServedTitles";
      case "areaServedLinks_indexedstored_strings":
        return "areaServedLinks";
      case "path_docvalues_location":
        return "path";
      case "simulation_docvalues_boolean":
        return "simulation";
      case "simulationDelayMillis_docvalues_long":
        return "simulationDelayMillis";
      default:
        return MapModel.searchVarMapModel(searchVar);
    }
  }

  public static String varSearchAircraft(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSearchMapModel(entityVar);
    }
  }

  public static String varSuggestedAircraft(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSuggestedMapModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeAircraft(doc);
  }
  public void storeAircraft(SolrResponse.Doc doc) {
    Aircraft oAircraft = (Aircraft)this;
    SiteRequest siteRequest = oAircraft.getSiteRequest_();

    oAircraft.setTimeZone(Optional.ofNullable(doc.get("timeZone_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setAirportId(Optional.ofNullable(doc.get("airportId_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setDepartureDate(Optional.ofNullable(doc.get("departureDate_docvalues_date")).map(v -> v.toString()).orElse(null));
    oAircraft.setArrivalDate(Optional.ofNullable(doc.get("arrivalDate_docvalues_date")).map(v -> v.toString()).orElse(null));
    oAircraft.setAvgSpeedInMph(Optional.ofNullable(doc.get("avgSpeedInMph_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setBelongsToAircraftModel(Optional.ofNullable(doc.get("belongsToAircraftModel_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setDateIssued(Optional.ofNullable(doc.get("dateIssued_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setHeading(Optional.ofNullable(doc.get("heading_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setIsOnGround(Optional.ofNullable(doc.get("isOnGround_docvalues_boolean")).map(v -> v.toString()).orElse(null));
    oAircraft.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setRegistration(Optional.ofNullable(doc.get("registration_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setSpeed(Optional.ofNullable(doc.get("speed_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAircraft.setVerticalSpeed(Optional.ofNullable(doc.get("verticalSpeed_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oAircraft.addAreaServedColors(Aircraft.staticSetAreaServedColors(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oAircraft.addAreaServedTitles(Aircraft.staticSetAreaServedTitles(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oAircraft.addAreaServedLinks(Aircraft.staticSetAreaServedLinks(siteRequest, v.toString()));
    });
    oAircraft.setPath(Optional.ofNullable(doc.get("path_docvalues_location")).map(v -> v.toString()).orElse(null));
    oAircraft.setSimulation(Optional.ofNullable(doc.get("simulation_docvalues_boolean")).map(v -> v.toString()).orElse(null));
    oAircraft.setSimulationDelayMillis(Optional.ofNullable(doc.get("simulationDelayMillis_docvalues_long")).map(v -> v.toString()).orElse(null));

    super.storeMapModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestAircraft() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof Aircraft) {
      Aircraft original = (Aircraft)o;
      if(!Objects.equals(timeZone, original.getTimeZone()))
        apiRequest.addVars("timeZone");
      if(!Objects.equals(airportId, original.getAirportId()))
        apiRequest.addVars("airportId");
      if(!Objects.equals(departureDate, original.getDepartureDate()))
        apiRequest.addVars("departureDate");
      if(!Objects.equals(arrivalDate, original.getArrivalDate()))
        apiRequest.addVars("arrivalDate");
      if(!Objects.equals(avgSpeedInMph, original.getAvgSpeedInMph()) && avgSpeedInMph != null && original.getAvgSpeedInMph() != null && avgSpeedInMph.compareTo(original.getAvgSpeedInMph()) != 0)
        apiRequest.addVars("avgSpeedInMph");
      if(!Objects.equals(address, original.getAddress()))
        apiRequest.addVars("address");
      if(!Objects.equals(alternateName, original.getAlternateName()))
        apiRequest.addVars("alternateName");
      if(!Objects.equals(belongsToAircraftModel, original.getBelongsToAircraftModel()))
        apiRequest.addVars("belongsToAircraftModel");
      if(!Objects.equals(dataProvider, original.getDataProvider()))
        apiRequest.addVars("dataProvider");
      if(!Objects.equals(dateCreated, original.getDateCreated()))
        apiRequest.addVars("dateCreated");
      if(!Objects.equals(dateIssued, original.getDateIssued()))
        apiRequest.addVars("dateIssued");
      if(!Objects.equals(dateModified, original.getDateModified()))
        apiRequest.addVars("dateModified");
      if(!Objects.equals(heading, original.getHeading()) && heading != null && original.getHeading() != null && heading.compareTo(original.getHeading()) != 0)
        apiRequest.addVars("heading");
      if(!Objects.equals(isOnGround, original.getIsOnGround()))
        apiRequest.addVars("isOnGround");
      if(!Objects.equals(owner, original.getOwner()))
        apiRequest.addVars("owner");
      if(!Objects.equals(registration, original.getRegistration()))
        apiRequest.addVars("registration");
      if(!Objects.equals(seeAlso, original.getSeeAlso()))
        apiRequest.addVars("seeAlso");
      if(!Objects.equals(source, original.getSource()))
        apiRequest.addVars("source");
      if(!Objects.equals(speed, original.getSpeed()) && speed != null && original.getSpeed() != null && speed.compareTo(original.getSpeed()) != 0)
        apiRequest.addVars("speed");
      if(!Objects.equals(verticalSpeed, original.getVerticalSpeed()) && verticalSpeed != null && original.getVerticalSpeed() != null && verticalSpeed.compareTo(original.getVerticalSpeed()) != 0)
        apiRequest.addVars("verticalSpeed");
      if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
        apiRequest.addVars("areaServedColors");
      if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
        apiRequest.addVars("areaServedTitles");
      if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
        apiRequest.addVars("areaServedLinks");
      if(!Objects.equals(path, original.getPath()))
        apiRequest.addVars("path");
      if(!Objects.equals(simulation, original.getSimulation()))
        apiRequest.addVars("simulation");
      if(!Objects.equals(simulationDelayMillis, original.getSimulationDelayMillis()))
        apiRequest.addVars("simulationDelayMillis");
      super.apiRequestMapModel();
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(Optional.ofNullable(timeZone).map(v -> "timeZone: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(airportId).map(v -> "airportId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(departureDate).map(v -> "departureDate: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(arrivalDate).map(v -> "arrivalDate: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(avgSpeedInMph).map(v -> "avgSpeedInMph: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(belongsToAircraftModel).map(v -> "belongsToAircraftModel: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateIssued).map(v -> "dateIssued: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(heading).map(v -> "heading: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(isOnGround).map(v -> "isOnGround: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(registration).map(v -> "registration: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(speed).map(v -> "speed: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(verticalSpeed).map(v -> "verticalSpeed: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(path).map(v -> "path: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(simulation).map(v -> "simulation: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(simulationDelayMillis).map(v -> "simulationDelayMillis: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "Aircraft";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaeronautics.model.fiware.aircraft.Aircraft";
  public static final String CLASS_AUTH_RESOURCE = "AIRCRAFT";
  public static final String CLASS_API_ADDRESS_Aircraft = "smart-aeronautics-enUS-Aircraft";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_Aircraft;
  }
  public static final String VAR_timeZone = "timeZone";
  public static final String SET_timeZone = "setTimeZone";
  public static final String VAR_airportId = "airportId";
  public static final String SET_airportId = "setAirportId";
  public static final String VAR_departureDate = "departureDate";
  public static final String SET_departureDate = "setDepartureDate";
  public static final String VAR_arrivalDate = "arrivalDate";
  public static final String SET_arrivalDate = "setArrivalDate";
  public static final String VAR_avgSpeedInMph = "avgSpeedInMph";
  public static final String SET_avgSpeedInMph = "setAvgSpeedInMph";
  public static final String VAR_address = "address";
  public static final String SET_address = "setAddress";
  public static final String VAR_alternateName = "alternateName";
  public static final String SET_alternateName = "setAlternateName";
  public static final String VAR_belongsToAircraftModel = "belongsToAircraftModel";
  public static final String SET_belongsToAircraftModel = "setBelongsToAircraftModel";
  public static final String VAR_dataProvider = "dataProvider";
  public static final String SET_dataProvider = "setDataProvider";
  public static final String VAR_dateCreated = "dateCreated";
  public static final String SET_dateCreated = "setDateCreated";
  public static final String VAR_dateIssued = "dateIssued";
  public static final String SET_dateIssued = "setDateIssued";
  public static final String VAR_dateModified = "dateModified";
  public static final String SET_dateModified = "setDateModified";
  public static final String VAR_heading = "heading";
  public static final String SET_heading = "setHeading";
  public static final String VAR_isOnGround = "isOnGround";
  public static final String SET_isOnGround = "setIsOnGround";
  public static final String VAR_owner = "owner";
  public static final String SET_owner = "setOwner";
  public static final String VAR_registration = "registration";
  public static final String SET_registration = "setRegistration";
  public static final String VAR_seeAlso = "seeAlso";
  public static final String SET_seeAlso = "setSeeAlso";
  public static final String VAR_source = "source";
  public static final String SET_source = "setSource";
  public static final String VAR_speed = "speed";
  public static final String SET_speed = "setSpeed";
  public static final String VAR_verticalSpeed = "verticalSpeed";
  public static final String SET_verticalSpeed = "setVerticalSpeed";
  public static final String VAR_areaServedColors = "areaServedColors";
  public static final String SET_areaServedColors = "setAreaServedColors";
  public static final String VAR_areaServedTitles = "areaServedTitles";
  public static final String SET_areaServedTitles = "setAreaServedTitles";
  public static final String VAR_areaServedLinks = "areaServedLinks";
  public static final String SET_areaServedLinks = "setAreaServedLinks";
  public static final String VAR_path = "path";
  public static final String SET_path = "setPath";
  public static final String VAR_simulation = "simulation";
  public static final String SET_simulation = "setSimulation";
  public static final String VAR_simulationDelayMillis = "simulationDelayMillis";
  public static final String SET_simulationDelayMillis = "setSimulationDelayMillis";

  public static List<String> varsQForClass() {
    return Aircraft.varsQAircraft(new ArrayList<String>());
  }
  public static List<String> varsQAircraft(List<String> vars) {
    MapModel.varsQMapModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return Aircraft.varsFqAircraft(new ArrayList<String>());
  }
  public static List<String> varsFqAircraft(List<String> vars) {
    vars.add(VAR_timeZone);
    vars.add(VAR_airportId);
    vars.add(VAR_departureDate);
    vars.add(VAR_arrivalDate);
    vars.add(VAR_avgSpeedInMph);
    vars.add(VAR_address);
    vars.add(VAR_alternateName);
    vars.add(VAR_belongsToAircraftModel);
    vars.add(VAR_dataProvider);
    vars.add(VAR_dateCreated);
    vars.add(VAR_dateIssued);
    vars.add(VAR_dateModified);
    vars.add(VAR_heading);
    vars.add(VAR_isOnGround);
    vars.add(VAR_owner);
    vars.add(VAR_registration);
    vars.add(VAR_seeAlso);
    vars.add(VAR_source);
    vars.add(VAR_speed);
    vars.add(VAR_verticalSpeed);
    vars.add(VAR_path);
    MapModel.varsFqMapModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return Aircraft.varsRangeAircraft(new ArrayList<String>());
  }
  public static List<String> varsRangeAircraft(List<String> vars) {
    vars.add(VAR_departureDate);
    vars.add(VAR_arrivalDate);
    vars.add(VAR_avgSpeedInMph);
    vars.add(VAR_address);
    vars.add(VAR_heading);
    vars.add(VAR_owner);
    vars.add(VAR_speed);
    vars.add(VAR_verticalSpeed);
    MapModel.varsRangeMapModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_timeZone = "time zone";
  public static final String DISPLAY_NAME_airportId = "airport ID";
  public static final String DISPLAY_NAME_departureDate = "departure date";
  public static final String DISPLAY_NAME_arrivalDate = "arrival date";
  public static final String DISPLAY_NAME_avgSpeedInMph = "average speed (MPH)";
  public static final String DISPLAY_NAME_address = "address";
  public static final String DISPLAY_NAME_alternateName = "alternate name";
  public static final String DISPLAY_NAME_belongsToAircraftModel = "belongs to aircraft model";
  public static final String DISPLAY_NAME_dataProvider = "data provider";
  public static final String DISPLAY_NAME_dateCreated = "date created";
  public static final String DISPLAY_NAME_dateIssued = "date issued";
  public static final String DISPLAY_NAME_dateModified = "date modified";
  public static final String DISPLAY_NAME_heading = "heading";
  public static final String DISPLAY_NAME_isOnGround = "is on ground";
  public static final String DISPLAY_NAME_owner = "owner";
  public static final String DISPLAY_NAME_registration = "registration";
  public static final String DISPLAY_NAME_seeAlso = "see also";
  public static final String DISPLAY_NAME_source = "source";
  public static final String DISPLAY_NAME_speed = "speed";
  public static final String DISPLAY_NAME_verticalSpeed = "vertical speed";
  public static final String DISPLAY_NAME_areaServedColors = "area served colors";
  public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
  public static final String DISPLAY_NAME_areaServedLinks = "area served links";
  public static final String DISPLAY_NAME_path = "path";
  public static final String DISPLAY_NAME_simulation = "simulation";
  public static final String DISPLAY_NAME_simulationDelayMillis = "simulation delay in milliseconds";

  @Override
  public String idForClass() {
    return entityShortId;
  }

  @Override
  public String titleForClass() {
    return objectTitle;
  }

  @Override
  public String nameForClass() {
    return name;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return Aircraft.NameAdjectiveSingular_enUS;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/aircraft/%s";
  }

  public static String varJsonForClass(String var, Boolean patch) {
    return Aircraft.varJsonAircraft(var, patch);
  }
  public static String varJsonAircraft(String var, Boolean patch) {
    switch(var) {
    case VAR_timeZone:
      return patch ? SET_timeZone : VAR_timeZone;
    case VAR_airportId:
      return patch ? SET_airportId : VAR_airportId;
    case VAR_departureDate:
      return patch ? SET_departureDate : VAR_departureDate;
    case VAR_arrivalDate:
      return patch ? SET_arrivalDate : VAR_arrivalDate;
    case VAR_avgSpeedInMph:
      return patch ? SET_avgSpeedInMph : VAR_avgSpeedInMph;
    case VAR_address:
      return patch ? SET_address : VAR_address;
    case VAR_alternateName:
      return patch ? SET_alternateName : VAR_alternateName;
    case VAR_belongsToAircraftModel:
      return patch ? SET_belongsToAircraftModel : VAR_belongsToAircraftModel;
    case VAR_dataProvider:
      return patch ? SET_dataProvider : VAR_dataProvider;
    case VAR_dateCreated:
      return patch ? SET_dateCreated : VAR_dateCreated;
    case VAR_dateIssued:
      return patch ? SET_dateIssued : VAR_dateIssued;
    case VAR_dateModified:
      return patch ? SET_dateModified : VAR_dateModified;
    case VAR_heading:
      return patch ? SET_heading : VAR_heading;
    case VAR_isOnGround:
      return patch ? SET_isOnGround : VAR_isOnGround;
    case VAR_owner:
      return patch ? SET_owner : VAR_owner;
    case VAR_registration:
      return patch ? SET_registration : VAR_registration;
    case VAR_seeAlso:
      return patch ? SET_seeAlso : VAR_seeAlso;
    case VAR_source:
      return patch ? SET_source : VAR_source;
    case VAR_speed:
      return patch ? SET_speed : VAR_speed;
    case VAR_verticalSpeed:
      return patch ? SET_verticalSpeed : VAR_verticalSpeed;
    case VAR_areaServedColors:
      return patch ? SET_areaServedColors : VAR_areaServedColors;
    case VAR_areaServedTitles:
      return patch ? SET_areaServedTitles : VAR_areaServedTitles;
    case VAR_areaServedLinks:
      return patch ? SET_areaServedLinks : VAR_areaServedLinks;
    case VAR_path:
      return patch ? SET_path : VAR_path;
    case VAR_simulation:
      return patch ? SET_simulation : VAR_simulation;
    case VAR_simulationDelayMillis:
      return patch ? SET_simulationDelayMillis : VAR_simulationDelayMillis;
    default:
      return MapModel.varJsonMapModel(var, patch);
    }
  }

  public static String displayNameForClass(String var) {
    return Aircraft.displayNameAircraft(var);
  }
  public static String displayNameAircraft(String var) {
    switch(var) {
    case VAR_timeZone:
      return DISPLAY_NAME_timeZone;
    case VAR_airportId:
      return DISPLAY_NAME_airportId;
    case VAR_departureDate:
      return DISPLAY_NAME_departureDate;
    case VAR_arrivalDate:
      return DISPLAY_NAME_arrivalDate;
    case VAR_avgSpeedInMph:
      return DISPLAY_NAME_avgSpeedInMph;
    case VAR_address:
      return DISPLAY_NAME_address;
    case VAR_alternateName:
      return DISPLAY_NAME_alternateName;
    case VAR_belongsToAircraftModel:
      return DISPLAY_NAME_belongsToAircraftModel;
    case VAR_dataProvider:
      return DISPLAY_NAME_dataProvider;
    case VAR_dateCreated:
      return DISPLAY_NAME_dateCreated;
    case VAR_dateIssued:
      return DISPLAY_NAME_dateIssued;
    case VAR_dateModified:
      return DISPLAY_NAME_dateModified;
    case VAR_heading:
      return DISPLAY_NAME_heading;
    case VAR_isOnGround:
      return DISPLAY_NAME_isOnGround;
    case VAR_owner:
      return DISPLAY_NAME_owner;
    case VAR_registration:
      return DISPLAY_NAME_registration;
    case VAR_seeAlso:
      return DISPLAY_NAME_seeAlso;
    case VAR_source:
      return DISPLAY_NAME_source;
    case VAR_speed:
      return DISPLAY_NAME_speed;
    case VAR_verticalSpeed:
      return DISPLAY_NAME_verticalSpeed;
    case VAR_areaServedColors:
      return DISPLAY_NAME_areaServedColors;
    case VAR_areaServedTitles:
      return DISPLAY_NAME_areaServedTitles;
    case VAR_areaServedLinks:
      return DISPLAY_NAME_areaServedLinks;
    case VAR_path:
      return DISPLAY_NAME_path;
    case VAR_simulation:
      return DISPLAY_NAME_simulation;
    case VAR_simulationDelayMillis:
      return DISPLAY_NAME_simulationDelayMillis;
    default:
      return MapModel.displayNameMapModel(var);
    }
  }

  public static String descriptionAircraft(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_timeZone:
      return "The local time zone the fishing trip departure and arrival dates are based on. ";
    case VAR_airportId:
      return "The primary airport of this aircraft. ";
    case VAR_departureDate:
      return "The date and time the fishing trip departed. ";
    case VAR_arrivalDate:
      return "The date and time the fishing trip returned. ";
    case VAR_avgSpeedInMph:
      return "The average speed of the boat in miles per hour. ";
    case VAR_areaServedColors:
      return "The colors of each areaServed Paths. ";
    case VAR_areaServedTitles:
      return "The titles of each areaServed Paths. ";
    case VAR_areaServedLinks:
      return "The links of each areaServed Paths. ";
    case VAR_path:
      return "The geographic area where the boat goes fishing. ";
    case VAR_simulation:
      return "Toggle the digital twin simulation";
    case VAR_simulationDelayMillis:
      return "The number of milliseconds to asynchronously wait before the next update event is sent. ";
      default:
        return MapModel.descriptionMapModel(var);
    }
  }

  public static String classSimpleNameAircraft(String var) {
    switch(var) {
    case VAR_timeZone:
      return "String";
    case VAR_airportId:
      return "String";
    case VAR_departureDate:
      return "ZonedDateTime";
    case VAR_arrivalDate:
      return "ZonedDateTime";
    case VAR_avgSpeedInMph:
      return "BigDecimal";
    case VAR_address:
      return "JsonObject";
    case VAR_alternateName:
      return "String";
    case VAR_belongsToAircraftModel:
      return "String";
    case VAR_dataProvider:
      return "String";
    case VAR_dateCreated:
      return "String";
    case VAR_dateIssued:
      return "String";
    case VAR_dateModified:
      return "String";
    case VAR_heading:
      return "BigDecimal";
    case VAR_isOnGround:
      return "Boolean";
    case VAR_owner:
      return "JsonObject";
    case VAR_registration:
      return "String";
    case VAR_seeAlso:
      return "String";
    case VAR_source:
      return "String";
    case VAR_speed:
      return "BigDecimal";
    case VAR_verticalSpeed:
      return "BigDecimal";
    case VAR_areaServedColors:
      return "List";
    case VAR_areaServedTitles:
      return "List";
    case VAR_areaServedLinks:
      return "List";
    case VAR_path:
      return "Path";
    case VAR_simulation:
      return "Boolean";
    case VAR_simulationDelayMillis:
      return "Long";
      default:
        return MapModel.classSimpleNameMapModel(var);
    }
  }

  public static String ngsiType(String var) {
    switch(var) {
    case VAR_timeZone:
      return "Property";
    case VAR_airportId:
      return "Property";
    case VAR_departureDate:
      return "Property";
    case VAR_arrivalDate:
      return "Property";
    case VAR_avgSpeedInMph:
      return "Property";
    case VAR_address:
      return "Property";
    case VAR_alternateName:
      return "Property";
    case VAR_belongsToAircraftModel:
      return "Property";
    case VAR_dataProvider:
      return "Property";
    case VAR_dateCreated:
      return "Property";
    case VAR_dateIssued:
      return "Property";
    case VAR_dateModified:
      return "Property";
    case VAR_heading:
      return "Property";
    case VAR_isOnGround:
      return "Property";
    case VAR_owner:
      return "Property";
    case VAR_registration:
      return "Property";
    case VAR_seeAlso:
      return "Property";
    case VAR_source:
      return "Property";
    case VAR_speed:
      return "Property";
    case VAR_verticalSpeed:
      return "Property";
    case VAR_areaServedColors:
      return "Property";
    case VAR_areaServedTitles:
      return "Property";
    case VAR_areaServedLinks:
      return "Property";
    case VAR_path:
      return "GeoProperty";
    case VAR_simulation:
      return "Property";
    case VAR_simulationDelayMillis:
      return "Property";
      default:
        return MapModel.ngsiType(var);
    }
  }

  public static Object ngsiAircraft(String var, Aircraft o) {
    switch(var) {
    case VAR_timeZone:
      return o.getTimeZone();
    case VAR_airportId:
      return o.getAirportId();
    case VAR_departureDate:
      return o.getDepartureDate();
    case VAR_arrivalDate:
      return o.getArrivalDate();
    case VAR_avgSpeedInMph:
      return o.getAvgSpeedInMph();
    case VAR_address:
      return o.getAddress();
    case VAR_alternateName:
      return o.getAlternateName();
    case VAR_belongsToAircraftModel:
      return o.getBelongsToAircraftModel();
    case VAR_dataProvider:
      return o.getDataProvider();
    case VAR_dateCreated:
      return o.getDateCreated();
    case VAR_dateIssued:
      return o.getDateIssued();
    case VAR_dateModified:
      return o.getDateModified();
    case VAR_heading:
      return o.getHeading();
    case VAR_isOnGround:
      return o.getIsOnGround();
    case VAR_owner:
      return o.getOwner();
    case VAR_registration:
      return o.getRegistration();
    case VAR_seeAlso:
      return o.getSeeAlso();
    case VAR_source:
      return o.getSource();
    case VAR_speed:
      return o.getSpeed();
    case VAR_verticalSpeed:
      return o.getVerticalSpeed();
    case VAR_areaServedColors:
      return o.getAreaServedColors();
    case VAR_areaServedTitles:
      return o.getAreaServedTitles();
    case VAR_areaServedLinks:
      return o.getAreaServedLinks();
    case VAR_path:
      JsonArray pointsArrayPath = new JsonArray();
      o.getPath().getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArrayPath.add(pointArray));
      return new JsonObject().put("type", "LineString").put("coordinates", pointsArrayPath);
    case VAR_simulation:
      return o.getSimulation();
    case VAR_simulationDelayMillis:
      return o.getSimulationDelayMillis();
      default:
        return ngsiMapModel(var, o);
    }
  }

  public static Integer htmColumnAircraft(String var) {
    switch(var) {
    case VAR_departureDate:
      return 1;
    case VAR_arrivalDate:
      return 2;
    case VAR_avgSpeedInMph:
      return 2;
      default:
        return MapModel.htmColumnMapModel(var);
    }
  }

  public static Integer htmRowAircraft(String var) {
    switch(var) {
    case VAR_timeZone:
      return 3;
    case VAR_airportId:
      return 3;
    case VAR_departureDate:
      return 3;
    case VAR_arrivalDate:
      return 3;
    case VAR_avgSpeedInMph:
      return 3;
    case VAR_address:
      return 3;
    case VAR_alternateName:
      return 3;
    case VAR_belongsToAircraftModel:
      return 3;
    case VAR_dataProvider:
      return 3;
    case VAR_dateCreated:
      return 3;
    case VAR_dateIssued:
      return 3;
    case VAR_dateModified:
      return 3;
    case VAR_heading:
      return 3;
    case VAR_isOnGround:
      return 3;
    case VAR_owner:
      return 3;
    case VAR_registration:
      return 3;
    case VAR_seeAlso:
      return 3;
    case VAR_source:
      return 3;
    case VAR_speed:
      return 3;
    case VAR_verticalSpeed:
      return 3;
    case VAR_path:
      return 3;
    case VAR_simulation:
      return 3;
    case VAR_simulationDelayMillis:
      return 3;
      default:
        return MapModel.htmRowMapModel(var);
    }
  }

  public static Integer htmCellAircraft(String var) {
    switch(var) {
    case VAR_timeZone:
      return 0;
    case VAR_airportId:
      return 0;
    case VAR_departureDate:
      return 1;
    case VAR_arrivalDate:
      return 2;
    case VAR_avgSpeedInMph:
      return 2;
    case VAR_address:
      return 0;
    case VAR_alternateName:
      return 1;
    case VAR_belongsToAircraftModel:
      return 2;
    case VAR_dataProvider:
      return 3;
    case VAR_dateCreated:
      return 4;
    case VAR_dateIssued:
      return 5;
    case VAR_dateModified:
      return 6;
    case VAR_heading:
      return 7;
    case VAR_isOnGround:
      return 8;
    case VAR_owner:
      return 9;
    case VAR_registration:
      return 10;
    case VAR_seeAlso:
      return 11;
    case VAR_source:
      return 12;
    case VAR_speed:
      return 13;
    case VAR_verticalSpeed:
      return 14;
    case VAR_path:
      return 0;
    case VAR_simulation:
      return 1;
    case VAR_simulationDelayMillis:
      return 2;
      default:
        return MapModel.htmCellMapModel(var);
    }
  }

  public static Integer lengthMinAircraft(String var) {
    switch(var) {
      default:
        return MapModel.lengthMinMapModel(var);
    }
  }

  public static Integer lengthMaxAircraft(String var) {
    switch(var) {
      default:
        return MapModel.lengthMaxMapModel(var);
    }
  }

  public static Integer maxAircraft(String var) {
    switch(var) {
      default:
        return MapModel.maxMapModel(var);
    }
  }

  public static Integer minAircraft(String var) {
    switch(var) {
      default:
        return MapModel.minMapModel(var);
    }
  }
}
