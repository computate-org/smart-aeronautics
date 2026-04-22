package org.computate.smartaeronautics.model.fiware.airport;

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
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.String;
import io.vertx.core.json.JsonArray;
import io.vertx.pgclient.data.Polygon;
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
import org.computate.vertx.serialize.pgclient.PgClientPolygonSerializer;
import org.computate.vertx.serialize.pgclient.PgClientPolygonDeserializer;
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
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class AirportGen into the class Airport. 
 * </li>
 * <h3>About the Airport class and it's generated class AirportGen&lt;MapModel&gt;: </h3>extends AirportGen
 * <p>
 * This Java class extends a generated Java class AirportGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport">Find the class Airport in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends AirportGen<MapModel>
 * <p>This <code>class Airport extends AirportGen&lt;MapModel&gt;</code>, which means it extends a newly generated AirportGen. 
 * The generated <code>class AirportGen extends MapModel</code> which means that Airport extends AirportGen which extends MapModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Api: true</b></kbd>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <kbd><b>ApiTag: Airports</b></kbd>, which groups all of the OpenAPIs for Airport objects under the tag "Airports". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/airport</h2>
 * <p>This class contains a comment <kbd><b>ApiUri: /en-us/api/airport</b></kbd>, which defines the base API URI for Airport objects as "/en-us/api/airport" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <kbd><b>Indexed: true</b></kbd>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Airport class will inherit the helpful inherited class comments from the super class AirportGen. 
 * </p>
 * <h2>
 *   Rows: 100
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the Airport API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the Airport API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 5
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 5</b></kbd>, 
 *   which means this class will be sorted by the given number 5 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 5</h2>
 * <p>This class contains a comment <kbd><b>SqlOrder: 5</b></kbd>, which means this class will be sorted by the given number 5 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <kbd><b>Model: true</b></kbd>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <kbd><b>Page: true</b></kbd>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaeronautics.model.fiware.airport.AirportPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <kbd><b>SuperPage.enUS: PageLayout</b></kbd>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaeronautics.model.fiware.airport.AirportPage extends org.computate.smartaeronautics.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <kbd><b>Promise: true</b></kbd>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the Airport Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: an Airport</h2>
 * <p>This class contains a comment <kbd><b>AName.enUS: an Airport</b></kbd>, which identifies the language context to describe a Airport as "an Airport". 
 * </p>
 * <p>
 * Delete the class Airport in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaeronautics.model.fiware.airport in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class AirportGen<DEV> extends MapModel {
  protected static final Logger LOG = LoggerFactory.getLogger(Airport.class);

  public static final String Description_enUS = "A description of a generic airport";
  public static final String AName_enUS = "an Airport";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this Airport";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "theAirport";
  public static final String SingularName_enUS = "Airport";
  public static final String PluralName_enUS = "Airports";
  public static final String NameActual_enUS = "current Airport";
  public static final String AllName_enUS = "all Airports";
  public static final String SearchAllNameBy_enUS = "search Airports by ";
  public static final String SearchAllName_enUS = "search Airports";
  public static final String Title_enUS = "Airports";
  public static final String ThePluralName_enUS = "the Airports";
  public static final String NoNameFound_enUS = "no Airport found";
  public static final String ApiUri_enUS = "/en-us/api/airport";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/airport";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/airport/{entityShortId}";
  public static final String OfName_enUS = "of Airport";
  public static final String ANameAdjective_enUS = "an Airport";
  public static final String NameAdjectiveSingular_enUS = "Airport";
  public static final String NameAdjectivePlural_enUS = "Airports";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/airport";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/airport";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/airport";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/airport/{entityShortId}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/airport/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/airport/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/airport";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/airport";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/airport";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/airport";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/airport";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/airport";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/airport/{entityShortId}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/airport/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/airport/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/airport-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/airport-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/airport-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/airport";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/airport";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/airport";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/airport/{entityShortId}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/airport/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/airport/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/airport";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/airport";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/airport";

  public static final String Icon = "<i class=\"fa-duotone fa-regular  fa-conveyor-belt\"></i>";
  public static final Integer Rows = 100;

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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
    this.address = Airport.staticSetAddress(siteRequest_, o);
  }
  public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Airport addressInit() {
    Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
    if(address == null) {
      _address(addressWrap);
      Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
        setAddress(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchAddress(siteRequest_, Airport.staticSetAddress(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _alternateName(Wrap<String> w);

  public String getAlternateName() {
    return alternateName;
  }
  public void setAlternateName(String o) {
    this.alternateName = Airport.staticSetAlternateName(siteRequest_, o);
  }
  public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport alternateNameInit() {
    Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
    if(alternateName == null) {
      _alternateName(alternateNameWrap);
      Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
        setAlternateName(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchAlternateName(siteRequest_, Airport.staticSetAlternateName(siteRequest_, o)).toString();
  }

  public String sqlAlternateName() {
    return alternateName;
  }

  public static String staticJsonAlternateName(String alternateName) {
    return alternateName;
  }

	//////////////
  // codeIATA //
	//////////////


  /**
   *  The entity codeIATA
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String codeIATA;

  /**
   * <br> The entity codeIATA
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:codeIATA">Find the entity codeIATA in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _codeIATA(Wrap<String> w);

  public String getCodeIATA() {
    return codeIATA;
  }
  public void setCodeIATA(String o) {
    this.codeIATA = Airport.staticSetCodeIATA(siteRequest_, o);
  }
  public static String staticSetCodeIATA(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport codeIATAInit() {
    Wrap<String> codeIATAWrap = new Wrap<String>().var("codeIATA");
    if(codeIATA == null) {
      _codeIATA(codeIATAWrap);
      Optional.ofNullable(codeIATAWrap.getO()).ifPresent(o -> {
        setCodeIATA(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchCodeIATA(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrCodeIATA(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCodeIATA(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchCodeIATA(siteRequest_, Airport.staticSetCodeIATA(siteRequest_, o)).toString();
  }

  public String sqlCodeIATA() {
    return codeIATA;
  }

  public static String staticJsonCodeIATA(String codeIATA) {
    return codeIATA;
  }

	//////////////
  // codeICAO //
	//////////////


  /**
   *  The entity codeICAO
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String codeICAO;

  /**
   * <br> The entity codeICAO
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:codeICAO">Find the entity codeICAO in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _codeICAO(Wrap<String> w);

  public String getCodeICAO() {
    return codeICAO;
  }
  public void setCodeICAO(String o) {
    this.codeICAO = Airport.staticSetCodeICAO(siteRequest_, o);
  }
  public static String staticSetCodeICAO(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport codeICAOInit() {
    Wrap<String> codeICAOWrap = new Wrap<String>().var("codeICAO");
    if(codeICAO == null) {
      _codeICAO(codeICAOWrap);
      Optional.ofNullable(codeICAOWrap.getO()).ifPresent(o -> {
        setCodeICAO(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchCodeICAO(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrCodeICAO(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCodeICAO(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchCodeICAO(siteRequest_, Airport.staticSetCodeICAO(siteRequest_, o)).toString();
  }

  public String sqlCodeICAO() {
    return codeICAO;
  }

  public static String staticJsonCodeICAO(String codeICAO) {
    return codeICAO;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dataProvider(Wrap<String> w);

  public String getDataProvider() {
    return dataProvider;
  }
  public void setDataProvider(String o) {
    this.dataProvider = Airport.staticSetDataProvider(siteRequest_, o);
  }
  public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport dataProviderInit() {
    Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
    if(dataProvider == null) {
      _dataProvider(dataProviderWrap);
      Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
        setDataProvider(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchDataProvider(siteRequest_, Airport.staticSetDataProvider(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateCreated(Wrap<String> w);

  public String getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(String o) {
    this.dateCreated = Airport.staticSetDateCreated(siteRequest_, o);
  }
  public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport dateCreatedInit() {
    Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
    if(dateCreated == null) {
      _dateCreated(dateCreatedWrap);
      Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
        setDateCreated(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchDateCreated(siteRequest_, Airport.staticSetDateCreated(siteRequest_, o)).toString();
  }

  public String sqlDateCreated() {
    return dateCreated;
  }

  public static String staticJsonDateCreated(String dateCreated) {
    return dateCreated;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateModified(Wrap<String> w);

  public String getDateModified() {
    return dateModified;
  }
  public void setDateModified(String o) {
    this.dateModified = Airport.staticSetDateModified(siteRequest_, o);
  }
  public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport dateModifiedInit() {
    Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
    if(dateModified == null) {
      _dateModified(dateModifiedWrap);
      Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
        setDateModified(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchDateModified(siteRequest_, Airport.staticSetDateModified(siteRequest_, o)).toString();
  }

  public String sqlDateModified() {
    return dateModified;
  }

  public static String staticJsonDateModified(String dateModified) {
    return dateModified;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
    this.owner = Airport.staticSetOwner(siteRequest_, o);
  }
  public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Airport ownerInit() {
    Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
    if(owner == null) {
      _owner(ownerWrap);
      Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
        setOwner(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchOwner(siteRequest_, Airport.staticSetOwner(siteRequest_, o)).toString();
  }

  public JsonObject sqlOwner() {
    return owner;
  }

  public static JsonObject staticJsonOwner(JsonObject owner) {
    return owner;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _seeAlso(Wrap<String> w);

  public String getSeeAlso() {
    return seeAlso;
  }
  public void setSeeAlso(String o) {
    this.seeAlso = Airport.staticSetSeeAlso(siteRequest_, o);
  }
  public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport seeAlsoInit() {
    Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
    if(seeAlso == null) {
      _seeAlso(seeAlsoWrap);
      Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
        setSeeAlso(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchSeeAlso(siteRequest_, Airport.staticSetSeeAlso(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _source(Wrap<String> w);

  public String getSource() {
    return source;
  }
  public void setSource(String o) {
    this.source = Airport.staticSetSource(siteRequest_, o);
  }
  public static String staticSetSource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airport sourceInit() {
    Wrap<String> sourceWrap = new Wrap<String>().var("source");
    if(source == null) {
      _source(sourceWrap);
      Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
        setSource(o);
      });
    }
    return (Airport)this;
  }

  public static String staticSearchSource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchSource(siteRequest_, Airport.staticSetSource(siteRequest_, o)).toString();
  }

  public String sqlSource() {
    return source;
  }

  public static String staticJsonSource(String source) {
    return source;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:areaServedColors">Find the entity areaServedColors in Solr</a>
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
    String l = Airport.staticSetAreaServedColors(siteRequest_, o);
    if(l != null)
      addAreaServedColors(l);
  }
  public static String staticSetAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Airport addAreaServedColors(String...objects) {
    for(String o : objects) {
      addAreaServedColors(o);
    }
    return (Airport)this;
  }
  public Airport addAreaServedColors(String o) {
    if(o != null)
      this.areaServedColors.add(o);
    return (Airport)this;
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
  protected Airport areaServedColorsInit() {
    _areaServedColors(areaServedColors);
    return (Airport)this;
  }

  public static String staticSearchAreaServedColors(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedColors(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedColors(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchAreaServedColors(siteRequest_, Airport.staticSetAreaServedColors(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:areaServedTitles">Find the entity areaServedTitles in Solr</a>
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
    String l = Airport.staticSetAreaServedTitles(siteRequest_, o);
    if(l != null)
      addAreaServedTitles(l);
  }
  public static String staticSetAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Airport addAreaServedTitles(String...objects) {
    for(String o : objects) {
      addAreaServedTitles(o);
    }
    return (Airport)this;
  }
  public Airport addAreaServedTitles(String o) {
    if(o != null)
      this.areaServedTitles.add(o);
    return (Airport)this;
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
  protected Airport areaServedTitlesInit() {
    _areaServedTitles(areaServedTitles);
    return (Airport)this;
  }

  public static String staticSearchAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedTitles(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedTitles(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchAreaServedTitles(siteRequest_, Airport.staticSetAreaServedTitles(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:areaServedLinks">Find the entity areaServedLinks in Solr</a>
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
    String l = Airport.staticSetAreaServedLinks(siteRequest_, o);
    if(l != null)
      addAreaServedLinks(l);
  }
  public static String staticSetAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Airport addAreaServedLinks(String...objects) {
    for(String o : objects) {
      addAreaServedLinks(o);
    }
    return (Airport)this;
  }
  public Airport addAreaServedLinks(String o) {
    if(o != null)
      this.areaServedLinks.add(o);
    return (Airport)this;
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
  protected Airport areaServedLinksInit() {
    _areaServedLinks(areaServedLinks);
    return (Airport)this;
  }

  public static String staticSearchAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAreaServedLinks(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAreaServedLinks(SiteRequest siteRequest_, String o) {
    return Airport.staticSearchAreaServedLinks(siteRequest_, Airport.staticSetAreaServedLinks(siteRequest_, o)).toString();
  }

	////////////////
  // areaServed //
	////////////////


  /**
   *  The entity areaServed
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = PgClientPolygonDeserializer.class)
  @JsonSerialize(using = PgClientPolygonSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<Polygon> areaServed = new ArrayList<Polygon>();

  /**
   * <br> The entity areaServed
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.Airport&fq=entiteVar_enUS_indexed_string:areaServed">Find the entity areaServed in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _areaServed(List<Polygon> l);

  public List<Polygon> getAreaServed() {
    return areaServed;
  }
  public JsonObject geojsonAreaServed() {
    if(areaServed == null)
      return null;
    JsonArray coordinates = new JsonArray();
    JsonObject json = new JsonObject().put("type", "Polygon").put("coordinates", coordinates);
    for(Polygon o : areaServed) {
      JsonArray coordinates2 = new JsonArray();
      coordinates.add(coordinates2);
      o.getPoints().forEach(point -> {
        coordinates2.add(new JsonArray().add(point.getX()).add(point.getY()));
      });
    }
    if(coordinates.size() == 0)
      return null;
    else
      return json;
  }

  public void setAreaServed(List<Polygon> areaServed) {
    this.areaServed = areaServed;
  }
  @JsonIgnore
  public static List<Polygon> staticSetAreaServed(SiteRequest siteRequest_, String o) {
    if(o != null) {
      try {
        List<Polygon> shape = null;
        if(StringUtils.isNotBlank(o)) {
          SimpleModule module = new SimpleModule();
          module.setDeserializerModifier(new BeanDeserializerModifier() {
            @Override
            public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
              if (beanDesc.getBeanClass() == Polygon.class) {
                return new PgClientPolygonDeserializer();
              }
              return deserializer;
            }
          });
          ObjectMapper objectMapper = JsonMapper.builder().addModule(module).build();
          shape = (List<Polygon>)objectMapper.readValue(Json.encode(o), Polygon.class);
        }
        return shape;
      } catch(Exception ex) {
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
      }
    }
    return null;
  }
  @JsonIgnore
  public void setAreaServed(JsonObject o) {
    this.areaServed = Airport.staticSetAreaServed(siteRequest_, o);
  }
  public static List<Polygon> staticSetAreaServed(SiteRequest siteRequest_, JsonObject o) {
    if(o != null) {
      try {
        List<Polygon> shapes = new ArrayList<>();
        o.getJsonArray("coordinates").stream().map(a -> (JsonArray)a).forEach(g -> {
          Polygon shape = new Polygon();
          g.stream().map(a -> (JsonArray)a).forEach(points -> {
            shape.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
          });
            shapes.add(shape);
        });
        return shapes;
      } catch(Exception ex) {
        LOG.error(String.format("Could not parse GeoJSON. %s: %s", ex.getMessage(), o));
      }
    }
    return null;
  }
  public Airport addAreaServed(Polygon...objects) {
    for(Polygon o : objects) {
      addAreaServed(o);
    }
    return (Airport)this;
  }
  public Airport addAreaServed(Polygon o) {
    if(o != null)
      this.areaServed.add(o);
    return (Airport)this;
  }
  protected Airport areaServedInit() {
    _areaServed(areaServed);
    return (Airport)this;
  }

  public static Polygon staticSearchAreaServed(SiteRequest siteRequest_, Polygon o) {
    return o;
  }

  public static String staticSearchStrAreaServed(SiteRequest siteRequest_, Polygon o) {
    JsonArray pointsArray = new JsonArray();
    o.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
    return new JsonObject().put("type", "LineString").put("coordinates", pointsArray).toString();
  }

  public static String staticSearchFqAreaServed(SiteRequest siteRequest_, String o) {
    return o;
  }

  public String sqlAreaServed() {
    JsonArray coordinates = new JsonArray();
    JsonObject json = new JsonObject().put("type", "Polygon").put("coordinates", coordinates);
    for(Polygon o : areaServed) {
      JsonArray coordinates2 = new JsonArray();
      coordinates.add(coordinates2);
      o.getPoints().forEach(point -> {
        coordinates2.add(new JsonArray().add(point.getX()).add(point.getY()));
      });
    }
    return json.toString();
  }

  public static JsonObject staticJsonAreaServed(List<Polygon> areaServed) {
    return Optional.ofNullable(areaServed).map(v -> VertxTool.toGeoJson(v)).orElse(null);
  }

  //////////////
  // initDeep //
  //////////////

  public Future<AirportGen<DEV>> promiseDeepAirport(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepAirport();
  }

  public Future<AirportGen<DEV>> promiseDeepAirport() {
    Promise<AirportGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseAirport(promise2);
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

  public Future<Void> promiseAirport(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        addressInit();
        alternateNameInit();
        codeIATAInit();
        codeICAOInit();
        dataProviderInit();
        dateCreatedInit();
        dateModifiedInit();
        ownerInit();
        seeAlsoInit();
        sourceInit();
        areaServedColorsInit();
        areaServedTitlesInit();
        areaServedLinksInit();
        areaServedInit();
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

  @Override public Future<? extends AirportGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepAirport(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestAirport(SiteRequest siteRequest_) {
      super.siteRequestMapModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestAirport(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainAirport(v);
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
  public Object obtainAirport(String var) {
    Airport oAirport = (Airport)this;
    switch(var) {
      case "address":
        return oAirport.address;
      case "alternateName":
        return oAirport.alternateName;
      case "codeIATA":
        return oAirport.codeIATA;
      case "codeICAO":
        return oAirport.codeICAO;
      case "dataProvider":
        return oAirport.dataProvider;
      case "dateCreated":
        return oAirport.dateCreated;
      case "dateModified":
        return oAirport.dateModified;
      case "owner":
        return oAirport.owner;
      case "seeAlso":
        return oAirport.seeAlso;
      case "source":
        return oAirport.source;
      case "areaServedColors":
        return oAirport.areaServedColors;
      case "areaServedTitles":
        return oAirport.areaServedTitles;
      case "areaServedLinks":
        return oAirport.areaServedLinks;
      case "areaServed":
        return oAirport.areaServed;
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
        o = relateAirport(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateAirport(String var, Object val) {
    Airport oAirport = (Airport)this;
    switch(var) {
      default:
        return super.relateMapModel(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, Airport o) {
    return staticSetAirport(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetAirport(String entityVar, SiteRequest siteRequest_, String v, Airport o) {
    switch(entityVar) {
    case "address":
      return Airport.staticSetAddress(siteRequest_, v);
    case "alternateName":
      return Airport.staticSetAlternateName(siteRequest_, v);
    case "codeIATA":
      return Airport.staticSetCodeIATA(siteRequest_, v);
    case "codeICAO":
      return Airport.staticSetCodeICAO(siteRequest_, v);
    case "dataProvider":
      return Airport.staticSetDataProvider(siteRequest_, v);
    case "dateCreated":
      return Airport.staticSetDateCreated(siteRequest_, v);
    case "dateModified":
      return Airport.staticSetDateModified(siteRequest_, v);
    case "owner":
      return Airport.staticSetOwner(siteRequest_, v);
    case "seeAlso":
      return Airport.staticSetSeeAlso(siteRequest_, v);
    case "source":
      return Airport.staticSetSource(siteRequest_, v);
    case "areaServedColors":
      return Airport.staticSetAreaServedColors(siteRequest_, v);
    case "areaServedTitles":
      return Airport.staticSetAreaServedTitles(siteRequest_, v);
    case "areaServedLinks":
      return Airport.staticSetAreaServedLinks(siteRequest_, v);
    case "areaServed":
      return Airport.staticSetAreaServed(siteRequest_, v);
      default:
        return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Future<Airport> fqAirport(SiteRequest siteRequest, String var, Object val) {
    Promise<Airport> promise = Promise.promise();
    try {
      if(val == null) {
        promise.complete();
      } else {
        SearchList<Airport> searchList = new SearchList<Airport>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(Airport.class);
        searchList.fq(String.format("%s:", Airport.varIndexedAirport(var)) + SearchTool.escapeQueryChars(val.toString()));
        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          try {
            promise.complete(searchList.getList().stream().findFirst().orElse(null));
          } catch(Throwable ex) {
            LOG.error("Error while querying theAirport", ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error("Error while querying theAirport", ex);
          promise.fail(ex);
        });
      }
    } catch(Throwable ex) {
      LOG.error("Error while querying theAirport", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchAirport(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchAirport(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "address":
      return Airport.staticSearchAddress(siteRequest_, (JsonObject)o);
    case "alternateName":
      return Airport.staticSearchAlternateName(siteRequest_, (String)o);
    case "codeIATA":
      return Airport.staticSearchCodeIATA(siteRequest_, (String)o);
    case "codeICAO":
      return Airport.staticSearchCodeICAO(siteRequest_, (String)o);
    case "dataProvider":
      return Airport.staticSearchDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return Airport.staticSearchDateCreated(siteRequest_, (String)o);
    case "dateModified":
      return Airport.staticSearchDateModified(siteRequest_, (String)o);
    case "owner":
      return Airport.staticSearchOwner(siteRequest_, (JsonObject)o);
    case "seeAlso":
      return Airport.staticSearchSeeAlso(siteRequest_, (String)o);
    case "source":
      return Airport.staticSearchSource(siteRequest_, (String)o);
    case "areaServedColors":
      return Airport.staticSearchAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return Airport.staticSearchAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return Airport.staticSearchAreaServedLinks(siteRequest_, (String)o);
    case "areaServed":
      return Airport.staticSearchAreaServed(siteRequest_, (Polygon)o);
      default:
        return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrAirport(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrAirport(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "address":
      return Airport.staticSearchStrAddress(siteRequest_, (String)o);
    case "alternateName":
      return Airport.staticSearchStrAlternateName(siteRequest_, (String)o);
    case "codeIATA":
      return Airport.staticSearchStrCodeIATA(siteRequest_, (String)o);
    case "codeICAO":
      return Airport.staticSearchStrCodeICAO(siteRequest_, (String)o);
    case "dataProvider":
      return Airport.staticSearchStrDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return Airport.staticSearchStrDateCreated(siteRequest_, (String)o);
    case "dateModified":
      return Airport.staticSearchStrDateModified(siteRequest_, (String)o);
    case "owner":
      return Airport.staticSearchStrOwner(siteRequest_, (String)o);
    case "seeAlso":
      return Airport.staticSearchStrSeeAlso(siteRequest_, (String)o);
    case "source":
      return Airport.staticSearchStrSource(siteRequest_, (String)o);
    case "areaServedColors":
      return Airport.staticSearchStrAreaServedColors(siteRequest_, (String)o);
    case "areaServedTitles":
      return Airport.staticSearchStrAreaServedTitles(siteRequest_, (String)o);
    case "areaServedLinks":
      return Airport.staticSearchStrAreaServedLinks(siteRequest_, (String)o);
    case "areaServed":
      return Airport.staticSearchStrAreaServed(siteRequest_, (Polygon)o);
      default:
        return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqAirport(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqAirport(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "address":
      return Airport.staticSearchFqAddress(siteRequest_, o);
    case "alternateName":
      return Airport.staticSearchFqAlternateName(siteRequest_, o);
    case "codeIATA":
      return Airport.staticSearchFqCodeIATA(siteRequest_, o);
    case "codeICAO":
      return Airport.staticSearchFqCodeICAO(siteRequest_, o);
    case "dataProvider":
      return Airport.staticSearchFqDataProvider(siteRequest_, o);
    case "dateCreated":
      return Airport.staticSearchFqDateCreated(siteRequest_, o);
    case "dateModified":
      return Airport.staticSearchFqDateModified(siteRequest_, o);
    case "owner":
      return Airport.staticSearchFqOwner(siteRequest_, o);
    case "seeAlso":
      return Airport.staticSearchFqSeeAlso(siteRequest_, o);
    case "source":
      return Airport.staticSearchFqSource(siteRequest_, o);
    case "areaServedColors":
      return Airport.staticSearchFqAreaServedColors(siteRequest_, o);
    case "areaServedTitles":
      return Airport.staticSearchFqAreaServedTitles(siteRequest_, o);
    case "areaServedLinks":
      return Airport.staticSearchFqAreaServedLinks(siteRequest_, o);
    case "areaServed":
      return Airport.staticSearchFqAreaServed(siteRequest_, o);
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
          o = persistAirport(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistAirport(String var, Object val) {
    String varLower = var.toLowerCase();
      if("address".equals(varLower)) {
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
      } else if("codeiata".equals(varLower)) {
        if(val instanceof String) {
          setCodeIATA((String)val);
        }
        saves.add("codeIATA");
        return val;
      } else if("codeicao".equals(varLower)) {
        if(val instanceof String) {
          setCodeICAO((String)val);
        }
        saves.add("codeICAO");
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
      } else if("datemodified".equals(varLower)) {
        if(val instanceof String) {
          setDateModified((String)val);
        }
        saves.add("dateModified");
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
      } else if("areaserved".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<Polygon>)val).stream().forEach(v -> addAreaServed(v));
        } else if(val instanceof Polygon[]) {
          Arrays.asList((Polygon[])val).stream().forEach(v -> addAreaServed((Polygon)v));
        } else if(val instanceof JsonObject) {
          Optional.ofNullable(staticSetAreaServed(siteRequest_, val.toString())).ifPresent(u -> u.stream().forEach(v -> addAreaServed(v)));
        } else if(val instanceof String) {
          Optional.ofNullable(staticSetAreaServed(siteRequest_, (String)val)).ifPresent(u -> u.stream().forEach(v -> addAreaServed(v)));
        }
        if(!saves.contains("areaServed")) {
          saves.add("areaServed");
        }
        return val;
    } else {
      return super.persistMapModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateAirport(doc);
  }
  public void populateAirport(SolrResponse.Doc doc) {
    Airport oAirport = (Airport)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      if(saves.contains("address")) {
        String address = (String)doc.get("address_docvalues_string");
        if(address != null)
          oAirport.setAddress(address);
      }

      if(saves.contains("alternateName")) {
        String alternateName = (String)doc.get("alternateName_docvalues_string");
        if(alternateName != null)
          oAirport.setAlternateName(alternateName);
      }

      if(saves.contains("codeIATA")) {
        String codeIATA = (String)doc.get("codeIATA_docvalues_string");
        if(codeIATA != null)
          oAirport.setCodeIATA(codeIATA);
      }

      if(saves.contains("codeICAO")) {
        String codeICAO = (String)doc.get("codeICAO_docvalues_string");
        if(codeICAO != null)
          oAirport.setCodeICAO(codeICAO);
      }

      if(saves.contains("dataProvider")) {
        String dataProvider = (String)doc.get("dataProvider_docvalues_string");
        if(dataProvider != null)
          oAirport.setDataProvider(dataProvider);
      }

      if(saves.contains("dateCreated")) {
        String dateCreated = (String)doc.get("dateCreated_docvalues_string");
        if(dateCreated != null)
          oAirport.setDateCreated(dateCreated);
      }

      if(saves.contains("dateModified")) {
        String dateModified = (String)doc.get("dateModified_docvalues_string");
        if(dateModified != null)
          oAirport.setDateModified(dateModified);
      }

      if(saves.contains("owner")) {
        String owner = (String)doc.get("owner_docvalues_string");
        if(owner != null)
          oAirport.setOwner(owner);
      }

      if(saves.contains("seeAlso")) {
        String seeAlso = (String)doc.get("seeAlso_docvalues_string");
        if(seeAlso != null)
          oAirport.setSeeAlso(seeAlso);
      }

      if(saves.contains("source")) {
        String source = (String)doc.get("source_docvalues_string");
        if(source != null)
          oAirport.setSource(source);
      }

      if(saves.contains("areaServedColors")) {
        List<String> areaServedColors = (List<String>)doc.get("areaServedColors_indexedstored_strings");
        if(areaServedColors != null) {
          areaServedColors.stream().forEach( v -> {
            oAirport.areaServedColors.add(Airport.staticSetAreaServedColors(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedTitles")) {
        List<String> areaServedTitles = (List<String>)doc.get("areaServedTitles_indexedstored_strings");
        if(areaServedTitles != null) {
          areaServedTitles.stream().forEach( v -> {
            oAirport.areaServedTitles.add(Airport.staticSetAreaServedTitles(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServedLinks")) {
        List<String> areaServedLinks = (List<String>)doc.get("areaServedLinks_indexedstored_strings");
        if(areaServedLinks != null) {
          areaServedLinks.stream().forEach( v -> {
            oAirport.areaServedLinks.add(Airport.staticSetAreaServedLinks(siteRequest_, v));
          });
        }
      }

      if(saves.contains("areaServed")) {
        List<Polygon> areaServed = (List<Polygon>)doc.get("areaServed_docvalues_location");
        if(areaServed != null) {
          areaServed.stream().forEach( v -> {
            oAirport.areaServed.add(v);
          });
        }
      }
    }

    super.populateMapModel(doc);
  }

  public void indexAirport(JsonObject doc) {
    if(address != null) {
      doc.put("address_docvalues_string", address.encode());
    }
    if(alternateName != null) {
      doc.put("alternateName_docvalues_string", alternateName);
    }
    if(codeIATA != null) {
      doc.put("codeIATA_docvalues_string", codeIATA);
    }
    if(codeICAO != null) {
      doc.put("codeICAO_docvalues_string", codeICAO);
    }
    if(dataProvider != null) {
      doc.put("dataProvider_docvalues_string", dataProvider);
    }
    if(dateCreated != null) {
      doc.put("dateCreated_docvalues_string", dateCreated);
    }
    if(dateModified != null) {
      doc.put("dateModified_docvalues_string", dateModified);
    }
    if(owner != null) {
      doc.put("owner_docvalues_string", owner.encode());
    }
    if(seeAlso != null) {
      doc.put("seeAlso_docvalues_string", seeAlso);
    }
    if(source != null) {
      doc.put("source_docvalues_string", source);
    }
    if(areaServedColors != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedColors_indexedstored_strings", l);
      for(String o : areaServedColors) {
        l.add(Airport.staticSearchAreaServedColors(siteRequest_, o));
      }
    }
    if(areaServedTitles != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedTitles_indexedstored_strings", l);
      for(String o : areaServedTitles) {
        l.add(Airport.staticSearchAreaServedTitles(siteRequest_, o));
      }
    }
    if(areaServedLinks != null) {
      JsonArray l = new JsonArray();
      doc.put("areaServedLinks_indexedstored_strings", l);
      for(String o : areaServedLinks) {
        l.add(Airport.staticSearchAreaServedLinks(siteRequest_, o));
      }
    }
    if(areaServed != null) {
      doc.put("areaServed_docvalues_location", Optional.ofNullable(geojsonAreaServed()).map(geojson -> geojson.toString()).orElse(null));
    }
    super.indexMapModel(doc);

	}

  public static String varStoredAirport(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "codeIATA":
        return "codeIATA_docvalues_string";
      case "codeICAO":
        return "codeICAO_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "owner":
        return "owner_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "areaServed":
        return "areaServed_docvalues_location";
      default:
        return MapModel.varStoredMapModel(entityVar);
    }
  }

  public static String varIndexedAirport(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "codeIATA":
        return "codeIATA_docvalues_string";
      case "codeICAO":
        return "codeICAO_docvalues_string";
      case "dataProvider":
        return "dataProvider_docvalues_string";
      case "dateCreated":
        return "dateCreated_docvalues_string";
      case "dateModified":
        return "dateModified_docvalues_string";
      case "owner":
        return "owner_docvalues_string";
      case "seeAlso":
        return "seeAlso_docvalues_string";
      case "source":
        return "source_docvalues_string";
      case "areaServedColors":
        return "areaServedColors_indexedstored_strings";
      case "areaServedTitles":
        return "areaServedTitles_indexedstored_strings";
      case "areaServedLinks":
        return "areaServedLinks_indexedstored_strings";
      case "areaServed":
        return "areaServed_docvalues_location";
      default:
        return MapModel.varIndexedMapModel(entityVar);
    }
  }

  public static String searchVarAirport(String searchVar) {
    switch(searchVar) {
      case "address_docvalues_string":
        return "address";
      case "alternateName_docvalues_string":
        return "alternateName";
      case "codeIATA_docvalues_string":
        return "codeIATA";
      case "codeICAO_docvalues_string":
        return "codeICAO";
      case "dataProvider_docvalues_string":
        return "dataProvider";
      case "dateCreated_docvalues_string":
        return "dateCreated";
      case "dateModified_docvalues_string":
        return "dateModified";
      case "owner_docvalues_string":
        return "owner";
      case "seeAlso_docvalues_string":
        return "seeAlso";
      case "source_docvalues_string":
        return "source";
      case "areaServedColors_indexedstored_strings":
        return "areaServedColors";
      case "areaServedTitles_indexedstored_strings":
        return "areaServedTitles";
      case "areaServedLinks_indexedstored_strings":
        return "areaServedLinks";
      case "areaServed_docvalues_location":
        return "areaServed";
      default:
        return MapModel.searchVarMapModel(searchVar);
    }
  }

  public static String varSearchAirport(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSearchMapModel(entityVar);
    }
  }

  public static String varSuggestedAirport(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSuggestedMapModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeAirport(doc);
  }
  public void storeAirport(SolrResponse.Doc doc) {
    Airport oAirport = (Airport)this;
    SiteRequest siteRequest = oAirport.getSiteRequest_();

    oAirport.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setCodeIATA(Optional.ofNullable(doc.get("codeIATA_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setCodeICAO(Optional.ofNullable(doc.get("codeICAO_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirport.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("areaServedColors_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oAirport.addAreaServedColors(Airport.staticSetAreaServedColors(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedTitles_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oAirport.addAreaServedTitles(Airport.staticSetAreaServedTitles(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("areaServedLinks_indexedstored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oAirport.addAreaServedLinks(Airport.staticSetAreaServedLinks(siteRequest, v.toString()));
    });
    Optional.ofNullable((String)doc.get("areaServed_docvalues_location")).ifPresent(val -> staticSetAreaServed(siteRequest_, val.toString()).stream().forEach(v -> addAreaServed(v)));

    super.storeMapModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestAirport() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof Airport) {
      Airport original = (Airport)o;
      if(!Objects.equals(address, original.getAddress()))
        apiRequest.addVars("address");
      if(!Objects.equals(alternateName, original.getAlternateName()))
        apiRequest.addVars("alternateName");
      if(!Objects.equals(codeIATA, original.getCodeIATA()))
        apiRequest.addVars("codeIATA");
      if(!Objects.equals(codeICAO, original.getCodeICAO()))
        apiRequest.addVars("codeICAO");
      if(!Objects.equals(dataProvider, original.getDataProvider()))
        apiRequest.addVars("dataProvider");
      if(!Objects.equals(dateCreated, original.getDateCreated()))
        apiRequest.addVars("dateCreated");
      if(!Objects.equals(dateModified, original.getDateModified()))
        apiRequest.addVars("dateModified");
      if(!Objects.equals(owner, original.getOwner()))
        apiRequest.addVars("owner");
      if(!Objects.equals(seeAlso, original.getSeeAlso()))
        apiRequest.addVars("seeAlso");
      if(!Objects.equals(source, original.getSource()))
        apiRequest.addVars("source");
      if(!Objects.equals(areaServedColors, original.getAreaServedColors()))
        apiRequest.addVars("areaServedColors");
      if(!Objects.equals(areaServedTitles, original.getAreaServedTitles()))
        apiRequest.addVars("areaServedTitles");
      if(!Objects.equals(areaServedLinks, original.getAreaServedLinks()))
        apiRequest.addVars("areaServedLinks");
      if(!Objects.equals(areaServed, original.getAreaServed()))
        apiRequest.addVars("areaServed");
      super.apiRequestMapModel();
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(Optional.ofNullable(address).map(v -> "address: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(alternateName).map(v -> "alternateName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(codeIATA).map(v -> "codeIATA: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(codeICAO).map(v -> "codeICAO: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(areaServedColors).map(v -> "areaServedColors: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedTitles).map(v -> "areaServedTitles: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServedLinks).map(v -> "areaServedLinks: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(areaServed).map(v -> "areaServed: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "Airport";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaeronautics.model.fiware.airport.Airport";
  public static final String CLASS_AUTH_RESOURCE = "AIRPORT";
  public static final String CLASS_API_ADDRESS_Airport = "smart-aeronautics-enUS-Airport";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_Airport;
  }
  public static final String VAR_address = "address";
  public static final String SET_address = "setAddress";
  public static final String VAR_alternateName = "alternateName";
  public static final String SET_alternateName = "setAlternateName";
  public static final String VAR_codeIATA = "codeIATA";
  public static final String SET_codeIATA = "setCodeIATA";
  public static final String VAR_codeICAO = "codeICAO";
  public static final String SET_codeICAO = "setCodeICAO";
  public static final String VAR_dataProvider = "dataProvider";
  public static final String SET_dataProvider = "setDataProvider";
  public static final String VAR_dateCreated = "dateCreated";
  public static final String SET_dateCreated = "setDateCreated";
  public static final String VAR_dateModified = "dateModified";
  public static final String SET_dateModified = "setDateModified";
  public static final String VAR_owner = "owner";
  public static final String SET_owner = "setOwner";
  public static final String VAR_seeAlso = "seeAlso";
  public static final String SET_seeAlso = "setSeeAlso";
  public static final String VAR_source = "source";
  public static final String SET_source = "setSource";
  public static final String VAR_areaServedColors = "areaServedColors";
  public static final String SET_areaServedColors = "setAreaServedColors";
  public static final String VAR_areaServedTitles = "areaServedTitles";
  public static final String SET_areaServedTitles = "setAreaServedTitles";
  public static final String VAR_areaServedLinks = "areaServedLinks";
  public static final String SET_areaServedLinks = "setAreaServedLinks";
  public static final String VAR_areaServed = "areaServed";
  public static final String SET_areaServed = "setAreaServed";

  public static List<String> varsQForClass() {
    return Airport.varsQAirport(new ArrayList<String>());
  }
  public static List<String> varsQAirport(List<String> vars) {
    MapModel.varsQMapModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return Airport.varsFqAirport(new ArrayList<String>());
  }
  public static List<String> varsFqAirport(List<String> vars) {
    vars.add(VAR_address);
    vars.add(VAR_alternateName);
    vars.add(VAR_codeIATA);
    vars.add(VAR_codeICAO);
    vars.add(VAR_dataProvider);
    vars.add(VAR_dateCreated);
    vars.add(VAR_dateModified);
    vars.add(VAR_owner);
    vars.add(VAR_seeAlso);
    vars.add(VAR_source);
    vars.add(VAR_areaServed);
    MapModel.varsFqMapModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return Airport.varsRangeAirport(new ArrayList<String>());
  }
  public static List<String> varsRangeAirport(List<String> vars) {
    vars.add(VAR_address);
    vars.add(VAR_owner);
    MapModel.varsRangeMapModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_address = "address";
  public static final String DISPLAY_NAME_alternateName = "alternate name";
  public static final String DISPLAY_NAME_codeIATA = "code iata";
  public static final String DISPLAY_NAME_codeICAO = "code icao";
  public static final String DISPLAY_NAME_dataProvider = "data provider";
  public static final String DISPLAY_NAME_dateCreated = "date created";
  public static final String DISPLAY_NAME_dateModified = "date modified";
  public static final String DISPLAY_NAME_owner = "owner";
  public static final String DISPLAY_NAME_seeAlso = "see also";
  public static final String DISPLAY_NAME_source = "source";
  public static final String DISPLAY_NAME_areaServedColors = "area served colors";
  public static final String DISPLAY_NAME_areaServedTitles = "area served titles";
  public static final String DISPLAY_NAME_areaServedLinks = "area served links";
  public static final String DISPLAY_NAME_areaServed = "area served";

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
    return Airport.NameAdjectiveSingular_enUS;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/airport/%s";
  }

  public static String varJsonForClass(String var, Boolean patch) {
    return Airport.varJsonAirport(var, patch);
  }
  public static String varJsonAirport(String var, Boolean patch) {
    switch(var) {
    case VAR_address:
      return patch ? SET_address : VAR_address;
    case VAR_alternateName:
      return patch ? SET_alternateName : VAR_alternateName;
    case VAR_codeIATA:
      return patch ? SET_codeIATA : VAR_codeIATA;
    case VAR_codeICAO:
      return patch ? SET_codeICAO : VAR_codeICAO;
    case VAR_dataProvider:
      return patch ? SET_dataProvider : VAR_dataProvider;
    case VAR_dateCreated:
      return patch ? SET_dateCreated : VAR_dateCreated;
    case VAR_dateModified:
      return patch ? SET_dateModified : VAR_dateModified;
    case VAR_owner:
      return patch ? SET_owner : VAR_owner;
    case VAR_seeAlso:
      return patch ? SET_seeAlso : VAR_seeAlso;
    case VAR_source:
      return patch ? SET_source : VAR_source;
    case VAR_areaServedColors:
      return patch ? SET_areaServedColors : VAR_areaServedColors;
    case VAR_areaServedTitles:
      return patch ? SET_areaServedTitles : VAR_areaServedTitles;
    case VAR_areaServedLinks:
      return patch ? SET_areaServedLinks : VAR_areaServedLinks;
    case VAR_areaServed:
      return patch ? SET_areaServed : VAR_areaServed;
    default:
      return MapModel.varJsonMapModel(var, patch);
    }
  }

  public static String displayNameForClass(String var) {
    return Airport.displayNameAirport(var);
  }
  public static String displayNameAirport(String var) {
    switch(var) {
    case VAR_address:
      return DISPLAY_NAME_address;
    case VAR_alternateName:
      return DISPLAY_NAME_alternateName;
    case VAR_codeIATA:
      return DISPLAY_NAME_codeIATA;
    case VAR_codeICAO:
      return DISPLAY_NAME_codeICAO;
    case VAR_dataProvider:
      return DISPLAY_NAME_dataProvider;
    case VAR_dateCreated:
      return DISPLAY_NAME_dateCreated;
    case VAR_dateModified:
      return DISPLAY_NAME_dateModified;
    case VAR_owner:
      return DISPLAY_NAME_owner;
    case VAR_seeAlso:
      return DISPLAY_NAME_seeAlso;
    case VAR_source:
      return DISPLAY_NAME_source;
    case VAR_areaServedColors:
      return DISPLAY_NAME_areaServedColors;
    case VAR_areaServedTitles:
      return DISPLAY_NAME_areaServedTitles;
    case VAR_areaServedLinks:
      return DISPLAY_NAME_areaServedLinks;
    case VAR_areaServed:
      return DISPLAY_NAME_areaServed;
    default:
      return MapModel.displayNameMapModel(var);
    }
  }

  public static String descriptionAirport(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_areaServedColors:
      return "The colors of each areaServed Paths. ";
    case VAR_areaServedTitles:
      return "The titles of each areaServed Paths. ";
    case VAR_areaServedLinks:
      return "The links of each areaServed Paths. ";
    case VAR_areaServed:
      return "The geographic area where a service or offered item is provided";
      default:
        return MapModel.descriptionMapModel(var);
    }
  }

  public static String classSimpleNameAirport(String var) {
    switch(var) {
    case VAR_address:
      return "JsonObject";
    case VAR_alternateName:
      return "String";
    case VAR_codeIATA:
      return "String";
    case VAR_codeICAO:
      return "String";
    case VAR_dataProvider:
      return "String";
    case VAR_dateCreated:
      return "String";
    case VAR_dateModified:
      return "String";
    case VAR_owner:
      return "JsonObject";
    case VAR_seeAlso:
      return "String";
    case VAR_source:
      return "String";
    case VAR_areaServedColors:
      return "List";
    case VAR_areaServedTitles:
      return "List";
    case VAR_areaServedLinks:
      return "List";
    case VAR_areaServed:
      return "List";
      default:
        return MapModel.classSimpleNameMapModel(var);
    }
  }

  public static String ngsiType(String var) {
    switch(var) {
    case VAR_address:
      return "Property";
    case VAR_alternateName:
      return "Property";
    case VAR_codeIATA:
      return "Property";
    case VAR_codeICAO:
      return "Property";
    case VAR_dataProvider:
      return "Property";
    case VAR_dateCreated:
      return "Property";
    case VAR_dateModified:
      return "Property";
    case VAR_owner:
      return "Property";
    case VAR_seeAlso:
      return "Property";
    case VAR_source:
      return "Property";
    case VAR_areaServedColors:
      return "Property";
    case VAR_areaServedTitles:
      return "Property";
    case VAR_areaServedLinks:
      return "Property";
    case VAR_areaServed:
      return "GeoProperty";
      default:
        return MapModel.ngsiType(var);
    }
  }

  public static Object ngsiAirport(String var, Airport o) {
    switch(var) {
    case VAR_address:
      return o.getAddress();
    case VAR_alternateName:
      return o.getAlternateName();
    case VAR_codeIATA:
      return o.getCodeIATA();
    case VAR_codeICAO:
      return o.getCodeICAO();
    case VAR_dataProvider:
      return o.getDataProvider();
    case VAR_dateCreated:
      return o.getDateCreated();
    case VAR_dateModified:
      return o.getDateModified();
    case VAR_owner:
      return o.getOwner();
    case VAR_seeAlso:
      return o.getSeeAlso();
    case VAR_source:
      return o.getSource();
    case VAR_areaServedColors:
      return o.getAreaServedColors();
    case VAR_areaServedTitles:
      return o.getAreaServedTitles();
    case VAR_areaServedLinks:
      return o.getAreaServedLinks();
    case VAR_areaServed:
      return o.geojsonAreaServed();
      default:
        return ngsiMapModel(var, o);
    }
  }

  public static Integer htmColumnAirport(String var) {
    switch(var) {
      default:
        return MapModel.htmColumnMapModel(var);
    }
  }

  public static Integer htmRowAirport(String var) {
    switch(var) {
    case VAR_address:
      return 6;
    case VAR_alternateName:
      return 6;
    case VAR_codeIATA:
      return 6;
    case VAR_codeICAO:
      return 6;
    case VAR_dataProvider:
      return 6;
    case VAR_dateCreated:
      return 6;
    case VAR_dateModified:
      return 6;
    case VAR_owner:
      return 6;
    case VAR_seeAlso:
      return 6;
    case VAR_source:
      return 6;
    case VAR_areaServed:
      return 4;
      default:
        return MapModel.htmRowMapModel(var);
    }
  }

  public static Integer htmCellAirport(String var) {
    switch(var) {
    case VAR_address:
      return 0;
    case VAR_alternateName:
      return 1;
    case VAR_codeIATA:
      return 2;
    case VAR_codeICAO:
      return 3;
    case VAR_dataProvider:
      return 4;
    case VAR_dateCreated:
      return 5;
    case VAR_dateModified:
      return 6;
    case VAR_owner:
      return 7;
    case VAR_seeAlso:
      return 8;
    case VAR_source:
      return 9;
    case VAR_areaServed:
      return 4;
      default:
        return MapModel.htmCellMapModel(var);
    }
  }

  public static Integer lengthMinAirport(String var) {
    switch(var) {
      default:
        return MapModel.lengthMinMapModel(var);
    }
  }

  public static Integer lengthMaxAirport(String var) {
    switch(var) {
      default:
        return MapModel.lengthMaxMapModel(var);
    }
  }

  public static Integer maxAirport(String var) {
    switch(var) {
      default:
        return MapModel.maxMapModel(var);
    }
  }

  public static Integer minAirport(String var) {
    switch(var) {
      default:
        return MapModel.minMapModel(var);
    }
  }
}
