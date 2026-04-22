package org.computate.smartaeronautics.model.fiware.airline;

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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.tool.SearchTool;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class AirlineGen into the class Airline. 
 * </li>
 * <h3>About the Airline class and it's generated class AirlineGen&lt;MapModel&gt;: </h3>extends AirlineGen
 * <p>
 * This Java class extends a generated Java class AirlineGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline">Find the class Airline in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends AirlineGen<MapModel>
 * <p>This <code>class Airline extends AirlineGen&lt;MapModel&gt;</code>, which means it extends a newly generated AirlineGen. 
 * The generated <code>class AirlineGen extends MapModel</code> which means that Airline extends AirlineGen which extends MapModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Api: true</b></kbd>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <kbd><b>ApiTag: Airlines</b></kbd>, which groups all of the OpenAPIs for Airline objects under the tag "Airlines". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/airline</h2>
 * <p>This class contains a comment <kbd><b>ApiUri: /en-us/api/airline</b></kbd>, which defines the base API URI for Airline objects as "/en-us/api/airline" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <kbd><b>Indexed: true</b></kbd>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Airline class will inherit the helpful inherited class comments from the super class AirlineGen. 
 * </p>
 * <h2>
 *   Rows: 100
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the Airline API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the Airline API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 6
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 6</b></kbd>, 
 *   which means this class will be sorted by the given number 6 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 6</h2>
 * <p>This class contains a comment <kbd><b>SqlOrder: 6</b></kbd>, which means this class will be sorted by the given number 6 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <kbd><b>Model: true</b></kbd>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <kbd><b>Page: true</b></kbd>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaeronautics.model.fiware.airline.AirlinePage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <kbd><b>SuperPage.enUS: PageLayout</b></kbd>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaeronautics.model.fiware.airline.AirlinePage extends org.computate.smartaeronautics.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <kbd><b>Promise: true</b></kbd>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the Airline Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: an Airline</h2>
 * <p>This class contains a comment <kbd><b>AName.enUS: an Airline</b></kbd>, which identifies the language context to describe a Airline as "an Airline". 
 * </p>
 * <p>
 * Delete the class Airline in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaeronautics.model.fiware.airline in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class AirlineGen<DEV> extends MapModel {
  protected static final Logger LOG = LoggerFactory.getLogger(Airline.class);

  public static final String Description_enUS = "A description of a generic airline";
  public static final String AName_enUS = "an Airline";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this Airline";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "theAirline";
  public static final String SingularName_enUS = "Airline";
  public static final String PluralName_enUS = "Airlines";
  public static final String NameActual_enUS = "current Airline";
  public static final String AllName_enUS = "all Airlines";
  public static final String SearchAllNameBy_enUS = "search Airlines by ";
  public static final String SearchAllName_enUS = "search Airlines";
  public static final String Title_enUS = "Airlines";
  public static final String ThePluralName_enUS = "the Airlines";
  public static final String NoNameFound_enUS = "no Airline found";
  public static final String ApiUri_enUS = "/en-us/api/airline";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/airline";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/airline/{entityShortId}";
  public static final String OfName_enUS = "of Airline";
  public static final String ANameAdjective_enUS = "an Airline";
  public static final String NameAdjectiveSingular_enUS = "Airline";
  public static final String NameAdjectivePlural_enUS = "Airlines";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/airline";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/airline";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/airline";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/airline/{entityShortId}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/airline/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/airline/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/airline";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/airline";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/airline";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/airline";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/airline";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/airline";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/airline/{entityShortId}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/airline/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/airline/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/airline-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/airline-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/airline-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/airline";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/airline";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/airline";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/airline/{entityShortId}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/airline/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/airline/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/airline";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/airline";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/airline";

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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:address">Find the entity address in Solr</a>
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
    this.address = Airline.staticSetAddress(siteRequest_, o);
  }
  public static JsonObject staticSetAddress(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Airline addressInit() {
    Wrap<JsonObject> addressWrap = new Wrap<JsonObject>().var("address");
    if(address == null) {
      _address(addressWrap);
      Optional.ofNullable(addressWrap.getO()).ifPresent(o -> {
        setAddress(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchAddress(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrAddress(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAddress(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchAddress(siteRequest_, Airline.staticSetAddress(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:alternateName">Find the entity alternateName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _alternateName(Wrap<String> w);

  public String getAlternateName() {
    return alternateName;
  }
  public void setAlternateName(String o) {
    this.alternateName = Airline.staticSetAlternateName(siteRequest_, o);
  }
  public static String staticSetAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline alternateNameInit() {
    Wrap<String> alternateNameWrap = new Wrap<String>().var("alternateName");
    if(alternateName == null) {
      _alternateName(alternateNameWrap);
      Optional.ofNullable(alternateNameWrap.getO()).ifPresent(o -> {
        setAlternateName(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchAlternateName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAlternateName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAlternateName(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchAlternateName(siteRequest_, Airline.staticSetAlternateName(siteRequest_, o)).toString();
  }

  public String sqlAlternateName() {
    return alternateName;
  }

  public static String staticJsonAlternateName(String alternateName) {
    return alternateName;
  }

	//////////////
  // callSign //
	//////////////


  /**
   *  The entity callSign
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String callSign;

  /**
   * <br> The entity callSign
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:callSign">Find the entity callSign in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _callSign(Wrap<String> w);

  public String getCallSign() {
    return callSign;
  }
  public void setCallSign(String o) {
    this.callSign = Airline.staticSetCallSign(siteRequest_, o);
  }
  public static String staticSetCallSign(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline callSignInit() {
    Wrap<String> callSignWrap = new Wrap<String>().var("callSign");
    if(callSign == null) {
      _callSign(callSignWrap);
      Optional.ofNullable(callSignWrap.getO()).ifPresent(o -> {
        setCallSign(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchCallSign(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrCallSign(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCallSign(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchCallSign(siteRequest_, Airline.staticSetCallSign(siteRequest_, o)).toString();
  }

  public String sqlCallSign() {
    return callSign;
  }

  public static String staticJsonCallSign(String callSign) {
    return callSign;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:codeIATA">Find the entity codeIATA in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _codeIATA(Wrap<String> w);

  public String getCodeIATA() {
    return codeIATA;
  }
  public void setCodeIATA(String o) {
    this.codeIATA = Airline.staticSetCodeIATA(siteRequest_, o);
  }
  public static String staticSetCodeIATA(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline codeIATAInit() {
    Wrap<String> codeIATAWrap = new Wrap<String>().var("codeIATA");
    if(codeIATA == null) {
      _codeIATA(codeIATAWrap);
      Optional.ofNullable(codeIATAWrap.getO()).ifPresent(o -> {
        setCodeIATA(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchCodeIATA(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrCodeIATA(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCodeIATA(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchCodeIATA(siteRequest_, Airline.staticSetCodeIATA(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:codeICAO">Find the entity codeICAO in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _codeICAO(Wrap<String> w);

  public String getCodeICAO() {
    return codeICAO;
  }
  public void setCodeICAO(String o) {
    this.codeICAO = Airline.staticSetCodeICAO(siteRequest_, o);
  }
  public static String staticSetCodeICAO(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline codeICAOInit() {
    Wrap<String> codeICAOWrap = new Wrap<String>().var("codeICAO");
    if(codeICAO == null) {
      _codeICAO(codeICAOWrap);
      Optional.ofNullable(codeICAOWrap.getO()).ifPresent(o -> {
        setCodeICAO(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchCodeICAO(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrCodeICAO(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCodeICAO(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchCodeICAO(siteRequest_, Airline.staticSetCodeICAO(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:dataProvider">Find the entity dataProvider in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dataProvider(Wrap<String> w);

  public String getDataProvider() {
    return dataProvider;
  }
  public void setDataProvider(String o) {
    this.dataProvider = Airline.staticSetDataProvider(siteRequest_, o);
  }
  public static String staticSetDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline dataProviderInit() {
    Wrap<String> dataProviderWrap = new Wrap<String>().var("dataProvider");
    if(dataProvider == null) {
      _dataProvider(dataProviderWrap);
      Optional.ofNullable(dataProviderWrap.getO()).ifPresent(o -> {
        setDataProvider(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchDataProvider(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDataProvider(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDataProvider(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchDataProvider(siteRequest_, Airline.staticSetDataProvider(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:dateCreated">Find the entity dateCreated in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateCreated(Wrap<String> w);

  public String getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(String o) {
    this.dateCreated = Airline.staticSetDateCreated(siteRequest_, o);
  }
  public static String staticSetDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline dateCreatedInit() {
    Wrap<String> dateCreatedWrap = new Wrap<String>().var("dateCreated");
    if(dateCreated == null) {
      _dateCreated(dateCreatedWrap);
      Optional.ofNullable(dateCreatedWrap.getO()).ifPresent(o -> {
        setDateCreated(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchDateCreated(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateCreated(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateCreated(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchDateCreated(siteRequest_, Airline.staticSetDateCreated(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:dateModified">Find the entity dateModified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _dateModified(Wrap<String> w);

  public String getDateModified() {
    return dateModified;
  }
  public void setDateModified(String o) {
    this.dateModified = Airline.staticSetDateModified(siteRequest_, o);
  }
  public static String staticSetDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline dateModifiedInit() {
    Wrap<String> dateModifiedWrap = new Wrap<String>().var("dateModified");
    if(dateModified == null) {
      _dateModified(dateModifiedWrap);
      Optional.ofNullable(dateModifiedWrap.getO()).ifPresent(o -> {
        setDateModified(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchDateModified(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDateModified(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDateModified(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchDateModified(siteRequest_, Airline.staticSetDateModified(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:owner">Find the entity owner in Solr</a>
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
    this.owner = Airline.staticSetOwner(siteRequest_, o);
  }
  public static JsonObject staticSetOwner(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Airline ownerInit() {
    Wrap<JsonObject> ownerWrap = new Wrap<JsonObject>().var("owner");
    if(owner == null) {
      _owner(ownerWrap);
      Optional.ofNullable(ownerWrap.getO()).ifPresent(o -> {
        setOwner(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchOwner(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrOwner(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOwner(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchOwner(siteRequest_, Airline.staticSetOwner(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:seeAlso">Find the entity seeAlso in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _seeAlso(Wrap<String> w);

  public String getSeeAlso() {
    return seeAlso;
  }
  public void setSeeAlso(String o) {
    this.seeAlso = Airline.staticSetSeeAlso(siteRequest_, o);
  }
  public static String staticSetSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline seeAlsoInit() {
    Wrap<String> seeAlsoWrap = new Wrap<String>().var("seeAlso");
    if(seeAlso == null) {
      _seeAlso(seeAlsoWrap);
      Optional.ofNullable(seeAlsoWrap.getO()).ifPresent(o -> {
        setSeeAlso(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchSeeAlso(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSeeAlso(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSeeAlso(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchSeeAlso(siteRequest_, Airline.staticSetSeeAlso(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airline.Airline&fq=entiteVar_enUS_indexed_string:source">Find the entity source in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _source(Wrap<String> w);

  public String getSource() {
    return source;
  }
  public void setSource(String o) {
    this.source = Airline.staticSetSource(siteRequest_, o);
  }
  public static String staticSetSource(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Airline sourceInit() {
    Wrap<String> sourceWrap = new Wrap<String>().var("source");
    if(source == null) {
      _source(sourceWrap);
      Optional.ofNullable(sourceWrap.getO()).ifPresent(o -> {
        setSource(o);
      });
    }
    return (Airline)this;
  }

  public static String staticSearchSource(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSource(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSource(SiteRequest siteRequest_, String o) {
    return Airline.staticSearchSource(siteRequest_, Airline.staticSetSource(siteRequest_, o)).toString();
  }

  public String sqlSource() {
    return source;
  }

  public static String staticJsonSource(String source) {
    return source;
  }

  //////////////
  // initDeep //
  //////////////

  public Future<AirlineGen<DEV>> promiseDeepAirline(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepAirline();
  }

  public Future<AirlineGen<DEV>> promiseDeepAirline() {
    Promise<AirlineGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseAirline(promise2);
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

  public Future<Void> promiseAirline(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        addressInit();
        alternateNameInit();
        callSignInit();
        codeIATAInit();
        codeICAOInit();
        dataProviderInit();
        dateCreatedInit();
        dateModifiedInit();
        ownerInit();
        seeAlsoInit();
        sourceInit();
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

  @Override public Future<? extends AirlineGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepAirline(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestAirline(SiteRequest siteRequest_) {
      super.siteRequestMapModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestAirline(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainAirline(v);
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
  public Object obtainAirline(String var) {
    Airline oAirline = (Airline)this;
    switch(var) {
      case "address":
        return oAirline.address;
      case "alternateName":
        return oAirline.alternateName;
      case "callSign":
        return oAirline.callSign;
      case "codeIATA":
        return oAirline.codeIATA;
      case "codeICAO":
        return oAirline.codeICAO;
      case "dataProvider":
        return oAirline.dataProvider;
      case "dateCreated":
        return oAirline.dateCreated;
      case "dateModified":
        return oAirline.dateModified;
      case "owner":
        return oAirline.owner;
      case "seeAlso":
        return oAirline.seeAlso;
      case "source":
        return oAirline.source;
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
        o = relateAirline(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateAirline(String var, Object val) {
    Airline oAirline = (Airline)this;
    switch(var) {
      default:
        return super.relateMapModel(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, Airline o) {
    return staticSetAirline(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetAirline(String entityVar, SiteRequest siteRequest_, String v, Airline o) {
    switch(entityVar) {
    case "address":
      return Airline.staticSetAddress(siteRequest_, v);
    case "alternateName":
      return Airline.staticSetAlternateName(siteRequest_, v);
    case "callSign":
      return Airline.staticSetCallSign(siteRequest_, v);
    case "codeIATA":
      return Airline.staticSetCodeIATA(siteRequest_, v);
    case "codeICAO":
      return Airline.staticSetCodeICAO(siteRequest_, v);
    case "dataProvider":
      return Airline.staticSetDataProvider(siteRequest_, v);
    case "dateCreated":
      return Airline.staticSetDateCreated(siteRequest_, v);
    case "dateModified":
      return Airline.staticSetDateModified(siteRequest_, v);
    case "owner":
      return Airline.staticSetOwner(siteRequest_, v);
    case "seeAlso":
      return Airline.staticSetSeeAlso(siteRequest_, v);
    case "source":
      return Airline.staticSetSource(siteRequest_, v);
      default:
        return MapModel.staticSetMapModel(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Future<Airline> fqAirline(SiteRequest siteRequest, String var, Object val) {
    Promise<Airline> promise = Promise.promise();
    try {
      if(val == null) {
        promise.complete();
      } else {
        SearchList<Airline> searchList = new SearchList<Airline>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(Airline.class);
        searchList.fq(String.format("%s:", Airline.varIndexedAirline(var)) + SearchTool.escapeQueryChars(val.toString()));
        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          try {
            promise.complete(searchList.getList().stream().findFirst().orElse(null));
          } catch(Throwable ex) {
            LOG.error("Error while querying theAirline", ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error("Error while querying theAirline", ex);
          promise.fail(ex);
        });
      }
    } catch(Throwable ex) {
      LOG.error("Error while querying theAirline", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchAirline(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchAirline(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "address":
      return Airline.staticSearchAddress(siteRequest_, (JsonObject)o);
    case "alternateName":
      return Airline.staticSearchAlternateName(siteRequest_, (String)o);
    case "callSign":
      return Airline.staticSearchCallSign(siteRequest_, (String)o);
    case "codeIATA":
      return Airline.staticSearchCodeIATA(siteRequest_, (String)o);
    case "codeICAO":
      return Airline.staticSearchCodeICAO(siteRequest_, (String)o);
    case "dataProvider":
      return Airline.staticSearchDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return Airline.staticSearchDateCreated(siteRequest_, (String)o);
    case "dateModified":
      return Airline.staticSearchDateModified(siteRequest_, (String)o);
    case "owner":
      return Airline.staticSearchOwner(siteRequest_, (JsonObject)o);
    case "seeAlso":
      return Airline.staticSearchSeeAlso(siteRequest_, (String)o);
    case "source":
      return Airline.staticSearchSource(siteRequest_, (String)o);
      default:
        return MapModel.staticSearchMapModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrAirline(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrAirline(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "address":
      return Airline.staticSearchStrAddress(siteRequest_, (String)o);
    case "alternateName":
      return Airline.staticSearchStrAlternateName(siteRequest_, (String)o);
    case "callSign":
      return Airline.staticSearchStrCallSign(siteRequest_, (String)o);
    case "codeIATA":
      return Airline.staticSearchStrCodeIATA(siteRequest_, (String)o);
    case "codeICAO":
      return Airline.staticSearchStrCodeICAO(siteRequest_, (String)o);
    case "dataProvider":
      return Airline.staticSearchStrDataProvider(siteRequest_, (String)o);
    case "dateCreated":
      return Airline.staticSearchStrDateCreated(siteRequest_, (String)o);
    case "dateModified":
      return Airline.staticSearchStrDateModified(siteRequest_, (String)o);
    case "owner":
      return Airline.staticSearchStrOwner(siteRequest_, (String)o);
    case "seeAlso":
      return Airline.staticSearchStrSeeAlso(siteRequest_, (String)o);
    case "source":
      return Airline.staticSearchStrSource(siteRequest_, (String)o);
      default:
        return MapModel.staticSearchStrMapModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqAirline(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqAirline(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "address":
      return Airline.staticSearchFqAddress(siteRequest_, o);
    case "alternateName":
      return Airline.staticSearchFqAlternateName(siteRequest_, o);
    case "callSign":
      return Airline.staticSearchFqCallSign(siteRequest_, o);
    case "codeIATA":
      return Airline.staticSearchFqCodeIATA(siteRequest_, o);
    case "codeICAO":
      return Airline.staticSearchFqCodeICAO(siteRequest_, o);
    case "dataProvider":
      return Airline.staticSearchFqDataProvider(siteRequest_, o);
    case "dateCreated":
      return Airline.staticSearchFqDateCreated(siteRequest_, o);
    case "dateModified":
      return Airline.staticSearchFqDateModified(siteRequest_, o);
    case "owner":
      return Airline.staticSearchFqOwner(siteRequest_, o);
    case "seeAlso":
      return Airline.staticSearchFqSeeAlso(siteRequest_, o);
    case "source":
      return Airline.staticSearchFqSource(siteRequest_, o);
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
          o = persistAirline(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistAirline(String var, Object val) {
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
      } else if("callsign".equals(varLower)) {
        if(val instanceof String) {
          setCallSign((String)val);
        }
        saves.add("callSign");
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
    } else {
      return super.persistMapModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateAirline(doc);
  }
  public void populateAirline(SolrResponse.Doc doc) {
    Airline oAirline = (Airline)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      if(saves.contains("address")) {
        String address = (String)doc.get("address_docvalues_string");
        if(address != null)
          oAirline.setAddress(address);
      }

      if(saves.contains("alternateName")) {
        String alternateName = (String)doc.get("alternateName_docvalues_string");
        if(alternateName != null)
          oAirline.setAlternateName(alternateName);
      }

      if(saves.contains("callSign")) {
        String callSign = (String)doc.get("callSign_docvalues_string");
        if(callSign != null)
          oAirline.setCallSign(callSign);
      }

      if(saves.contains("codeIATA")) {
        String codeIATA = (String)doc.get("codeIATA_docvalues_string");
        if(codeIATA != null)
          oAirline.setCodeIATA(codeIATA);
      }

      if(saves.contains("codeICAO")) {
        String codeICAO = (String)doc.get("codeICAO_docvalues_string");
        if(codeICAO != null)
          oAirline.setCodeICAO(codeICAO);
      }

      if(saves.contains("dataProvider")) {
        String dataProvider = (String)doc.get("dataProvider_docvalues_string");
        if(dataProvider != null)
          oAirline.setDataProvider(dataProvider);
      }

      if(saves.contains("dateCreated")) {
        String dateCreated = (String)doc.get("dateCreated_docvalues_string");
        if(dateCreated != null)
          oAirline.setDateCreated(dateCreated);
      }

      if(saves.contains("dateModified")) {
        String dateModified = (String)doc.get("dateModified_docvalues_string");
        if(dateModified != null)
          oAirline.setDateModified(dateModified);
      }

      if(saves.contains("owner")) {
        String owner = (String)doc.get("owner_docvalues_string");
        if(owner != null)
          oAirline.setOwner(owner);
      }

      if(saves.contains("seeAlso")) {
        String seeAlso = (String)doc.get("seeAlso_docvalues_string");
        if(seeAlso != null)
          oAirline.setSeeAlso(seeAlso);
      }

      if(saves.contains("source")) {
        String source = (String)doc.get("source_docvalues_string");
        if(source != null)
          oAirline.setSource(source);
      }
    }

    super.populateMapModel(doc);
  }

  public void indexAirline(JsonObject doc) {
    if(address != null) {
      doc.put("address_docvalues_string", address.encode());
    }
    if(alternateName != null) {
      doc.put("alternateName_docvalues_string", alternateName);
    }
    if(callSign != null) {
      doc.put("callSign_docvalues_string", callSign);
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
    super.indexMapModel(doc);

	}

  public static String varStoredAirline(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "callSign":
        return "callSign_docvalues_string";
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
      default:
        return MapModel.varStoredMapModel(entityVar);
    }
  }

  public static String varIndexedAirline(String entityVar) {
    switch(entityVar) {
      case "address":
        return "address_docvalues_string";
      case "alternateName":
        return "alternateName_docvalues_string";
      case "callSign":
        return "callSign_docvalues_string";
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
      default:
        return MapModel.varIndexedMapModel(entityVar);
    }
  }

  public static String searchVarAirline(String searchVar) {
    switch(searchVar) {
      case "address_docvalues_string":
        return "address";
      case "alternateName_docvalues_string":
        return "alternateName";
      case "callSign_docvalues_string":
        return "callSign";
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
      default:
        return MapModel.searchVarMapModel(searchVar);
    }
  }

  public static String varSearchAirline(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSearchMapModel(entityVar);
    }
  }

  public static String varSuggestedAirline(String entityVar) {
    switch(entityVar) {
      default:
        return MapModel.varSuggestedMapModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeAirline(doc);
  }
  public void storeAirline(SolrResponse.Doc doc) {
    Airline oAirline = (Airline)this;
    SiteRequest siteRequest = oAirline.getSiteRequest_();

    oAirline.setAddress(Optional.ofNullable(doc.get("address_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setAlternateName(Optional.ofNullable(doc.get("alternateName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setCallSign(Optional.ofNullable(doc.get("callSign_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setCodeIATA(Optional.ofNullable(doc.get("codeIATA_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setCodeICAO(Optional.ofNullable(doc.get("codeICAO_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setDataProvider(Optional.ofNullable(doc.get("dataProvider_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setDateCreated(Optional.ofNullable(doc.get("dateCreated_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setDateModified(Optional.ofNullable(doc.get("dateModified_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setOwner(Optional.ofNullable(doc.get("owner_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setSeeAlso(Optional.ofNullable(doc.get("seeAlso_docvalues_string")).map(v -> v.toString()).orElse(null));
    oAirline.setSource(Optional.ofNullable(doc.get("source_docvalues_string")).map(v -> v.toString()).orElse(null));

    super.storeMapModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestAirline() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof Airline) {
      Airline original = (Airline)o;
      if(!Objects.equals(address, original.getAddress()))
        apiRequest.addVars("address");
      if(!Objects.equals(alternateName, original.getAlternateName()))
        apiRequest.addVars("alternateName");
      if(!Objects.equals(callSign, original.getCallSign()))
        apiRequest.addVars("callSign");
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
    sb.append(Optional.ofNullable(callSign).map(v -> "callSign: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(codeIATA).map(v -> "codeIATA: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(codeICAO).map(v -> "codeICAO: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dataProvider).map(v -> "dataProvider: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateCreated).map(v -> "dateCreated: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(dateModified).map(v -> "dateModified: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(owner).map(v -> "owner: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(seeAlso).map(v -> "seeAlso: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(source).map(v -> "source: \"" + v + "\"\n" ).orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "Airline";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaeronautics.model.fiware.airline.Airline";
  public static final String CLASS_AUTH_RESOURCE = "AIRLINE";
  public static final String CLASS_API_ADDRESS_Airline = "smart-aeronautics-enUS-Airline";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_Airline;
  }
  public static final String VAR_address = "address";
  public static final String SET_address = "setAddress";
  public static final String VAR_alternateName = "alternateName";
  public static final String SET_alternateName = "setAlternateName";
  public static final String VAR_callSign = "callSign";
  public static final String SET_callSign = "setCallSign";
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

  public static List<String> varsQForClass() {
    return Airline.varsQAirline(new ArrayList<String>());
  }
  public static List<String> varsQAirline(List<String> vars) {
    MapModel.varsQMapModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return Airline.varsFqAirline(new ArrayList<String>());
  }
  public static List<String> varsFqAirline(List<String> vars) {
    vars.add(VAR_address);
    vars.add(VAR_alternateName);
    vars.add(VAR_callSign);
    vars.add(VAR_codeIATA);
    vars.add(VAR_codeICAO);
    vars.add(VAR_dataProvider);
    vars.add(VAR_dateCreated);
    vars.add(VAR_dateModified);
    vars.add(VAR_owner);
    vars.add(VAR_seeAlso);
    vars.add(VAR_source);
    MapModel.varsFqMapModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return Airline.varsRangeAirline(new ArrayList<String>());
  }
  public static List<String> varsRangeAirline(List<String> vars) {
    vars.add(VAR_address);
    vars.add(VAR_owner);
    MapModel.varsRangeMapModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_address = "address";
  public static final String DISPLAY_NAME_alternateName = "alternate name";
  public static final String DISPLAY_NAME_callSign = "call sign";
  public static final String DISPLAY_NAME_codeIATA = "code iata";
  public static final String DISPLAY_NAME_codeICAO = "code icao";
  public static final String DISPLAY_NAME_dataProvider = "data provider";
  public static final String DISPLAY_NAME_dateCreated = "date created";
  public static final String DISPLAY_NAME_dateModified = "date modified";
  public static final String DISPLAY_NAME_owner = "owner";
  public static final String DISPLAY_NAME_seeAlso = "see also";
  public static final String DISPLAY_NAME_source = "source";

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
    return Airline.NameAdjectiveSingular_enUS;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/airline/%s";
  }

  public static String varJsonForClass(String var, Boolean patch) {
    return Airline.varJsonAirline(var, patch);
  }
  public static String varJsonAirline(String var, Boolean patch) {
    switch(var) {
    case VAR_address:
      return patch ? SET_address : VAR_address;
    case VAR_alternateName:
      return patch ? SET_alternateName : VAR_alternateName;
    case VAR_callSign:
      return patch ? SET_callSign : VAR_callSign;
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
    default:
      return MapModel.varJsonMapModel(var, patch);
    }
  }

  public static String displayNameForClass(String var) {
    return Airline.displayNameAirline(var);
  }
  public static String displayNameAirline(String var) {
    switch(var) {
    case VAR_address:
      return DISPLAY_NAME_address;
    case VAR_alternateName:
      return DISPLAY_NAME_alternateName;
    case VAR_callSign:
      return DISPLAY_NAME_callSign;
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
    default:
      return MapModel.displayNameMapModel(var);
    }
  }

  public static String descriptionAirline(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return MapModel.descriptionMapModel(var);
    }
  }

  public static String classSimpleNameAirline(String var) {
    switch(var) {
    case VAR_address:
      return "JsonObject";
    case VAR_alternateName:
      return "String";
    case VAR_callSign:
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
    case VAR_callSign:
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
      default:
        return MapModel.ngsiType(var);
    }
  }

  public static Object ngsiAirline(String var, Airline o) {
    switch(var) {
    case VAR_address:
      return o.getAddress();
    case VAR_alternateName:
      return o.getAlternateName();
    case VAR_callSign:
      return o.getCallSign();
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
      default:
        return ngsiMapModel(var, o);
    }
  }

  public static Integer htmColumnAirline(String var) {
    switch(var) {
      default:
        return MapModel.htmColumnMapModel(var);
    }
  }

  public static Integer htmRowAirline(String var) {
    switch(var) {
    case VAR_address:
      return 3;
    case VAR_alternateName:
      return 3;
    case VAR_callSign:
      return 3;
    case VAR_codeIATA:
      return 3;
    case VAR_codeICAO:
      return 3;
    case VAR_dataProvider:
      return 3;
    case VAR_dateCreated:
      return 3;
    case VAR_dateModified:
      return 3;
    case VAR_owner:
      return 3;
    case VAR_seeAlso:
      return 3;
    case VAR_source:
      return 3;
      default:
        return MapModel.htmRowMapModel(var);
    }
  }

  public static Integer htmCellAirline(String var) {
    switch(var) {
    case VAR_address:
      return 0;
    case VAR_alternateName:
      return 1;
    case VAR_callSign:
      return 2;
    case VAR_codeIATA:
      return 3;
    case VAR_codeICAO:
      return 4;
    case VAR_dataProvider:
      return 5;
    case VAR_dateCreated:
      return 6;
    case VAR_dateModified:
      return 7;
    case VAR_owner:
      return 8;
    case VAR_seeAlso:
      return 9;
    case VAR_source:
      return 10;
      default:
        return MapModel.htmCellMapModel(var);
    }
  }

  public static Integer lengthMinAirline(String var) {
    switch(var) {
      default:
        return MapModel.lengthMinMapModel(var);
    }
  }

  public static Integer lengthMaxAirline(String var) {
    switch(var) {
      default:
        return MapModel.lengthMaxMapModel(var);
    }
  }

  public static Integer maxAirline(String var) {
    switch(var) {
      default:
        return MapModel.maxMapModel(var);
    }
  }

  public static Integer minAirline(String var) {
    switch(var) {
      default:
        return MapModel.minMapModel(var);
    }
  }
}
