package org.computate.smartaeronautics.model.contract;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.measure.BinaryPrefix;
import javax.measure.Quantity;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartaeronautics.config.ConfigKeys;
import org.computate.smartaeronautics.model.MapModel;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;
import systems.uom.common.USCustomary;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;
import org.computate.smartaeronautics.model.BaseModel;
import org.computate.smartaeronautics.request.SiteRequest;
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
import org.computate.search.serialize.ComputateBigDecimalDeserializer;
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
import java.lang.Integer;
import io.vertx.core.json.JsonArray;
import java.math.BigDecimal;
import org.computate.vertx.serialize.vertx.JsonArrayDeserializer;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
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
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ContractGen into the class Contract. 
 * </li>
 * <h3>About the Contract class and it's generated class ContractGen&lt;BaseModel&gt;: </h3>extends ContractGen
 * <p>
 * This Java class extends a generated Java class ContractGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract">Find the class Contract in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ContractGen<BaseModel>
 * <p>This <code>class Contract extends ContractGen&lt;BaseModel&gt;</code>, which means it extends a newly generated ContractGen. 
 * The generated <code>class ContractGen extends BaseModel</code> which means that Contract extends ContractGen which extends BaseModel. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Api: true</b></kbd>, which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <h2>ApiTag.enUS: true</h2>
 * <p>This class contains a comment <kbd><b>ApiTag: contracts</b></kbd>, which groups all of the OpenAPIs for Contract objects under the tag "contracts". 
 * </p>
 * <h2>ApiUri.enUS: /en-us/api/contract</h2>
 * <p>This class contains a comment <kbd><b>ApiUri: /en-us/api/contract</b></kbd>, which defines the base API URI for Contract objects as "/en-us/api/contract" in the OpenAPI spec. 
 * </p>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <p>This class contains a comment <kbd><b>Indexed: true</b></kbd>, which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Contract class will inherit the helpful inherited class comments from the super class ContractGen. 
 * </p>
 * <h2>
 *   Rows: 100
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the contract API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>This class contains a comment <kbd><b>Rows: 100</b></kbd>, which means the contract API will return a default of 100 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 8
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 8</b></kbd>, 
 *   which means this class will be sorted by the given number 8 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <h2>SqlOrder: 8</h2>
 * <p>This class contains a comment <kbd><b>SqlOrder: 8</b></kbd>, which means this class will be sorted by the given number 8 ascending when SQL code to create and drop the tables is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <p>This class contains a comment <kbd><b>Model: true</b></kbd>, which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <h2>Page: true</h2>
 * <p>This class contains a comment <kbd><b>Page: true</b></kbd>, which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.computate.smartaeronautics.model.contract.ContractPage. 
 * </p>
 * <h2>SuperPage.enUS: PageLayout</h2>
 * <p>This class contains a comment <kbd><b>SuperPage.enUS: PageLayout</b></kbd>, which identifies the Java super class of the page code by it's class simple name "PageLayout". 
 * This means that the newly created class org.computate.smartaeronautics.model.contract.ContractPage extends org.computate.smartaeronautics.page.PageLayout. 
 * </p>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <kbd><b>Promise: true</b></kbd>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the Contract Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: a contract</h2>
 * <p>This class contains a comment <kbd><b>AName.enUS: a contract</b></kbd>, which identifies the language context to describe a Contract as "a contract". 
 * </p>
 * <p>
 * Delete the class Contract in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.smartaeronautics.model.contract in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.smartaeronautics.model.contract&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class ContractGen<DEV> extends BaseModel {
  protected static final Logger LOG = LoggerFactory.getLogger(Contract.class);

  public static final String Description_enUS = "A work contract";
  public static final String AName_enUS = "a contract";
  public static final String This_enUS = "this ";
  public static final String ThisName_enUS = "this contract";
  public static final String A_enUS = "a ";
  public static final String TheName_enUS = "the contract";
  public static final String SingularName_enUS = "contract";
  public static final String PluralName_enUS = "contracts";
  public static final String NameActual_enUS = "current contract";
  public static final String AllName_enUS = "all contracts";
  public static final String SearchAllNameBy_enUS = "search contracts by ";
  public static final String SearchAllName_enUS = "search contracts";
  public static final String Title_enUS = "contracts";
  public static final String ThePluralName_enUS = "the contracts";
  public static final String NoNameFound_enUS = "no contract found";
  public static final String ApiUri_enUS = "/en-us/api/contract";
  public static final String ApiUriSearchPage_enUS = "/en-us/search/contract";
  public static final String ApiUriEditPage_enUS = "/en-us/edit/contract/{contractId}";
  public static final String OfName_enUS = "of contract";
  public static final String ANameAdjective_enUS = "a contract";
  public static final String NameAdjectiveSingular_enUS = "contract";
  public static final String NameAdjectivePlural_enUS = "contracts";
  public static final String Search_enUS_OpenApiUri = "/en-us/api/contract";
  public static final String Search_enUS_StringFormatUri = "/en-us/api/contract";
  public static final String Search_enUS_StringFormatUrl = "%s/en-us/api/contract";
  public static final String GET_enUS_OpenApiUri = "/en-us/api/contract/{contractId}";
  public static final String GET_enUS_StringFormatUri = "/en-us/api/contract/%s";
  public static final String GET_enUS_StringFormatUrl = "%s/en-us/api/contract/%s";
  public static final String PATCH_enUS_OpenApiUri = "/en-us/api/contract";
  public static final String PATCH_enUS_StringFormatUri = "/en-us/api/contract";
  public static final String PATCH_enUS_StringFormatUrl = "%s/en-us/api/contract";
  public static final String POST_enUS_OpenApiUri = "/en-us/api/contract";
  public static final String POST_enUS_StringFormatUri = "/en-us/api/contract";
  public static final String POST_enUS_StringFormatUrl = "%s/en-us/api/contract";
  public static final String DELETE_enUS_OpenApiUri = "/en-us/api/contract/{contractId}";
  public static final String DELETE_enUS_StringFormatUri = "/en-us/api/contract/%s";
  public static final String DELETE_enUS_StringFormatUrl = "%s/en-us/api/contract/%s";
  public static final String PUTImport_enUS_OpenApiUri = "/en-us/api/contract-import";
  public static final String PUTImport_enUS_StringFormatUri = "/en-us/api/contract-import";
  public static final String PUTImport_enUS_StringFormatUrl = "%s/en-us/api/contract-import";
  public static final String SearchPage_enUS_OpenApiUri = "/en-us/search/contract";
  public static final String SearchPage_enUS_StringFormatUri = "/en-us/search/contract";
  public static final String SearchPage_enUS_StringFormatUrl = "%s/en-us/search/contract";
  public static final String EditPage_enUS_OpenApiUri = "/en-us/edit/contract/{contractId}";
  public static final String EditPage_enUS_StringFormatUri = "/en-us/edit/contract/%s";
  public static final String EditPage_enUS_StringFormatUrl = "%s/en-us/edit/contract/%s";
  public static final String DELETEFilter_enUS_OpenApiUri = "/en-us/api/contract";
  public static final String DELETEFilter_enUS_StringFormatUri = "/en-us/api/contract";
  public static final String DELETEFilter_enUS_StringFormatUrl = "%s/en-us/api/contract";

  public static final String Icon = "<i class=\"fa-duotone fa-regular  fa-conveyor-belt\"></i>";
  public static final Integer Rows = 100;

	////////////
  // region //
	////////////


  /**
   *  The entity region
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String region;

  /**
   * <br> The entity region
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:region">Find the entity region in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _region(Wrap<String> w);

  public String getRegion() {
    return region;
  }
  public void setRegion(String o) {
    this.region = Contract.staticSetRegion(siteRequest_, o);
  }
  public static String staticSetRegion(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Contract regionInit() {
    Wrap<String> regionWrap = new Wrap<String>().var("region");
    if(region == null) {
      _region(regionWrap);
      Optional.ofNullable(regionWrap.getO()).ifPresent(o -> {
        setRegion(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchRegion(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrRegion(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRegion(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchRegion(siteRequest_, Contract.staticSetRegion(siteRequest_, o)).toString();
  }

  public String sqlRegion() {
    return region;
  }

  public static String staticJsonRegion(String region) {
    return region;
  }

	//////////
  // name //
	//////////


  /**
   *  The entity name
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String name;

  /**
   * <br> The entity name
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:name">Find the entity name in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _name(Wrap<String> w);

  public String getName() {
    return name;
  }
  public void setName(String o) {
    this.name = Contract.staticSetName(siteRequest_, o);
  }
  public static String staticSetName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Contract nameInit() {
    Wrap<String> nameWrap = new Wrap<String>().var("name");
    if(name == null) {
      _name(nameWrap);
      Optional.ofNullable(nameWrap.getO()).ifPresent(o -> {
        setName(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqName(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchName(siteRequest_, Contract.staticSetName(siteRequest_, o)).toString();
  }

  public String sqlName() {
    return name;
  }

  public static String staticJsonName(String name) {
    return name;
  }

	//////////////////
  // abbreviation //
	//////////////////


  /**
   *  The entity abbreviation
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String abbreviation;

  /**
   * <br> The entity abbreviation
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:abbreviation">Find the entity abbreviation in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _abbreviation(Wrap<String> w);

  public String getAbbreviation() {
    return abbreviation;
  }
  public void setAbbreviation(String o) {
    this.abbreviation = Contract.staticSetAbbreviation(siteRequest_, o);
  }
  public static String staticSetAbbreviation(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Contract abbreviationInit() {
    Wrap<String> abbreviationWrap = new Wrap<String>().var("abbreviation");
    if(abbreviation == null) {
      _abbreviation(abbreviationWrap);
      Optional.ofNullable(abbreviationWrap.getO()).ifPresent(o -> {
        setAbbreviation(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchAbbreviation(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAbbreviation(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAbbreviation(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchAbbreviation(siteRequest_, Contract.staticSetAbbreviation(siteRequest_, o)).toString();
  }

  public String sqlAbbreviation() {
    return abbreviation;
  }

  public static String staticJsonAbbreviation(String abbreviation) {
    return abbreviation;
  }

	/////////////////
  // displayName //
	/////////////////


  /**
   *  The entity displayName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String displayName;

  /**
   * <br> The entity displayName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:displayName">Find the entity displayName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _displayName(Wrap<String> w);

  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String o) {
    this.displayName = Contract.staticSetDisplayName(siteRequest_, o);
  }
  public static String staticSetDisplayName(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Contract displayNameInit() {
    Wrap<String> displayNameWrap = new Wrap<String>().var("displayName");
    if(displayName == null) {
      _displayName(displayNameWrap);
      Optional.ofNullable(displayNameWrap.getO()).ifPresent(o -> {
        setDisplayName(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchDisplayName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDisplayName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDisplayName(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchDisplayName(siteRequest_, Contract.staticSetDisplayName(siteRequest_, o)).toString();
  }

  public String sqlDisplayName() {
    return displayName;
  }

  public static String staticJsonDisplayName(String displayName) {
    return displayName;
  }

	////////////////
  // contractId //
	////////////////


  /**
   *  The entity contractId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contractId;

  /**
   * <br> The entity contractId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:contractId">Find the entity contractId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contractId(Wrap<String> w);

  public String getContractId() {
    return contractId;
  }
  public void setContractId(String o) {
    this.contractId = Contract.staticSetContractId(siteRequest_, o);
  }
  public static String staticSetContractId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected Contract contractIdInit() {
    Wrap<String> contractIdWrap = new Wrap<String>().var("contractId");
    if(contractId == null) {
      _contractId(contractIdWrap);
      Optional.ofNullable(contractIdWrap.getO()).ifPresent(o -> {
        setContractId(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchContractId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContractId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContractId(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchContractId(siteRequest_, Contract.staticSetContractId(siteRequest_, o)).toString();
  }

  public String sqlContractId() {
    return contractId;
  }

  public static String staticJsonContractId(String contractId) {
    return contractId;
  }

	///////////////
  // startDate //
	///////////////


  /**
   *  The entity startDate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime startDate;

  /**
   * <br> The entity startDate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:startDate">Find the entity startDate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _startDate(Wrap<ZonedDateTime> w);

  public ZonedDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(ZonedDateTime startDate) {
    this.startDate = Optional.ofNullable(startDate).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setStartDate(Instant o) {
    this.startDate = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setStartDate(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.startDate = Contract.staticSetStartDate(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setStartDate(Date o) {
    this.startDate = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetStartDate(SiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected Contract startDateInit() {
    Wrap<ZonedDateTime> startDateWrap = new Wrap<ZonedDateTime>().var("startDate");
    if(startDate == null) {
      _startDate(startDateWrap);
      Optional.ofNullable(startDateWrap.getO()).ifPresent(o -> {
        setStartDate(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchStartDate(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrStartDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return Contract.staticSearchStartDate(siteRequest_, Contract.staticSetStartDate(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqStartDate(SiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return Contract.staticSearchStartDate(siteRequest_, Contract.staticSetStartDate(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlStartDate() {
    return startDate == null ? null : startDate.toOffsetDateTime();
  }

  public static String staticJsonStartDate(ZonedDateTime startDate) {
    return Optional.ofNullable(startDate).map(v -> v.format(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER)).orElse(null);
  }

	//////////////////////////
  // investmentYearsTotal //
	//////////////////////////


  /**
   *  The entity investmentYearsTotal
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer investmentYearsTotal;

  /**
   * <br> The entity investmentYearsTotal
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:investmentYearsTotal">Find the entity investmentYearsTotal in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _investmentYearsTotal(Wrap<Integer> w);

  public Integer getInvestmentYearsTotal() {
    return investmentYearsTotal;
  }

  public void setInvestmentYearsTotal(Integer investmentYearsTotal) {
    this.investmentYearsTotal = investmentYearsTotal;
  }
  @JsonIgnore
  public void setInvestmentYearsTotal(String o) {
    this.investmentYearsTotal = Contract.staticSetInvestmentYearsTotal(siteRequest_, o);
  }
  public static Integer staticSetInvestmentYearsTotal(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract investmentYearsTotalInit() {
    Wrap<Integer> investmentYearsTotalWrap = new Wrap<Integer>().var("investmentYearsTotal");
    if(investmentYearsTotal == null) {
      _investmentYearsTotal(investmentYearsTotalWrap);
      Optional.ofNullable(investmentYearsTotalWrap.getO()).ifPresent(o -> {
        setInvestmentYearsTotal(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchInvestmentYearsTotal(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrInvestmentYearsTotal(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInvestmentYearsTotal(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchInvestmentYearsTotal(siteRequest_, Contract.staticSetInvestmentYearsTotal(siteRequest_, o)).toString();
  }

  public Integer sqlInvestmentYearsTotal() {
    return investmentYearsTotal;
  }

  public static String staticJsonInvestmentYearsTotal(Integer investmentYearsTotal) {
    return Optional.ofNullable(investmentYearsTotal).map(v -> v.toString()).orElse(null);
  }

	/////////////////////
  // investmentYears //
	/////////////////////


  /**
   *  The entity investmentYears
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<Integer> investmentYears = new ArrayList<Integer>();

  /**
   * <br> The entity investmentYears
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:investmentYears">Find the entity investmentYears in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _investmentYears(List<Integer> l);

  public List<Integer> getInvestmentYears() {
    return investmentYears;
  }

  public void setInvestmentYears(List<Integer> investmentYears) {
    this.investmentYears = investmentYears;
  }
  @JsonIgnore
  public void setInvestmentYears(String o) {
    Integer l = Contract.staticSetInvestmentYears(siteRequest_, o);
    if(l != null)
      addInvestmentYears(l);
  }
  public static Integer staticSetInvestmentYears(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  public Contract addInvestmentYears(Integer...objects) {
    for(Integer o : objects) {
      addInvestmentYears(o);
    }
    return (Contract)this;
  }
  public Contract addInvestmentYears(Integer o) {
    if(o != null)
      this.investmentYears.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setInvestmentYears(JsonArray objects) {
    investmentYears.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      setInvestmentYears(o);
    }
  }
  public Contract addInvestmentYears(String o) {
    if(NumberUtils.isParsable(o)) {
      Integer p = Integer.parseInt(o);
      addInvestmentYears(p);
      }
    return (Contract)this;
  }
  protected Contract investmentYearsInit() {
    _investmentYears(investmentYears);
    return (Contract)this;
  }

  public static Integer staticSearchInvestmentYears(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrInvestmentYears(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInvestmentYears(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchInvestmentYears(siteRequest_, Contract.staticSetInvestmentYears(siteRequest_, o)).toString();
  }

  public Number[] sqlInvestmentYears() {
    return investmentYears.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonInvestmentYears(List<Integer> investmentYears) {
    JsonArray a = new JsonArray();
    investmentYears.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////////
  // investmentsPerYear //
	////////////////////////


  /**
   *  The entity investmentsPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,16,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> investmentsPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity investmentsPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:investmentsPerYear">Find the entity investmentsPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _investmentsPerYear(List<BigDecimal> l);

  public List<BigDecimal> getInvestmentsPerYear() {
    return investmentsPerYear;
  }

  public void setInvestmentsPerYear(List<BigDecimal> investmentsPerYear) {
    this.investmentsPerYear = investmentsPerYear;
  }
  @JsonIgnore
  public void setInvestmentsPerYear(String o) {
    BigDecimal l = Contract.staticSetInvestmentsPerYear(siteRequest_, o);
    if(l != null)
      addInvestmentsPerYear(l);
  }
  public static Integer staticScaleInvestmentsPerYear() {
    return 2;
  }
  public static MathContext staticMathContextInvestmentsPerYear() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetInvestmentsPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextInvestmentsPerYear()).setScale(staticScaleInvestmentsPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setInvestmentsPerYear(Double o) {
    addInvestmentsPerYear(new BigDecimal(o, staticMathContextInvestmentsPerYear()).setScale(staticScaleInvestmentsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInvestmentsPerYear(Integer o) {
    addInvestmentsPerYear(new BigDecimal(o, staticMathContextInvestmentsPerYear()).setScale(staticScaleInvestmentsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInvestmentsPerYear(Number o) {
    addInvestmentsPerYear(new BigDecimal(o.doubleValue(), staticMathContextInvestmentsPerYear()).setScale(staticScaleInvestmentsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addInvestmentsPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addInvestmentsPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addInvestmentsPerYear(BigDecimal o) {
    if(o != null)
      this.investmentsPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setInvestmentsPerYear(JsonArray objects) {
    investmentsPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addInvestmentsPerYear(new BigDecimal(o, staticMathContextInvestmentsPerYear()).setScale(staticScaleInvestmentsPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addInvestmentsPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextInvestmentsPerYear()).setScale(staticScaleInvestmentsPerYear(), RoundingMode.valueOf("HALF_UP"));
      addInvestmentsPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract investmentsPerYearInit() {
    _investmentsPerYear(investmentsPerYear);
    return (Contract)this;
  }

  public static String staticSearchInvestmentsPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrInvestmentsPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInvestmentsPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchInvestmentsPerYear(siteRequest_, Contract.staticSetInvestmentsPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlInvestmentsPerYear() {
    return investmentsPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonInvestmentsPerYear(List<BigDecimal> investmentsPerYear) {
    JsonArray a = new JsonArray();
    investmentsPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	//////////////////////////////////
  // investmentsPerYearCumulative //
	//////////////////////////////////


  /**
   *  The entity investmentsPerYearCumulative
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,16,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> investmentsPerYearCumulative = new ArrayList<BigDecimal>();

  /**
   * <br> The entity investmentsPerYearCumulative
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:investmentsPerYearCumulative">Find the entity investmentsPerYearCumulative in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _investmentsPerYearCumulative(List<BigDecimal> l);

  public List<BigDecimal> getInvestmentsPerYearCumulative() {
    return investmentsPerYearCumulative;
  }

  public void setInvestmentsPerYearCumulative(List<BigDecimal> investmentsPerYearCumulative) {
    this.investmentsPerYearCumulative = investmentsPerYearCumulative;
  }
  @JsonIgnore
  public void setInvestmentsPerYearCumulative(String o) {
    BigDecimal l = Contract.staticSetInvestmentsPerYearCumulative(siteRequest_, o);
    if(l != null)
      addInvestmentsPerYearCumulative(l);
  }
  public static Integer staticScaleInvestmentsPerYearCumulative() {
    return 2;
  }
  public static MathContext staticMathContextInvestmentsPerYearCumulative() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetInvestmentsPerYearCumulative(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextInvestmentsPerYearCumulative()).setScale(staticScaleInvestmentsPerYearCumulative(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setInvestmentsPerYearCumulative(Double o) {
    addInvestmentsPerYearCumulative(new BigDecimal(o, staticMathContextInvestmentsPerYearCumulative()).setScale(staticScaleInvestmentsPerYearCumulative(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInvestmentsPerYearCumulative(Integer o) {
    addInvestmentsPerYearCumulative(new BigDecimal(o, staticMathContextInvestmentsPerYearCumulative()).setScale(staticScaleInvestmentsPerYearCumulative(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInvestmentsPerYearCumulative(Number o) {
    addInvestmentsPerYearCumulative(new BigDecimal(o.doubleValue(), staticMathContextInvestmentsPerYearCumulative()).setScale(staticScaleInvestmentsPerYearCumulative(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addInvestmentsPerYearCumulative(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addInvestmentsPerYearCumulative(o);
    }
    return (Contract)this;
  }
  public Contract addInvestmentsPerYearCumulative(BigDecimal o) {
    if(o != null)
      this.investmentsPerYearCumulative.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setInvestmentsPerYearCumulative(JsonArray objects) {
    investmentsPerYearCumulative.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addInvestmentsPerYearCumulative(new BigDecimal(o, staticMathContextInvestmentsPerYearCumulative()).setScale(staticScaleInvestmentsPerYearCumulative(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addInvestmentsPerYearCumulative(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextInvestmentsPerYearCumulative()).setScale(staticScaleInvestmentsPerYearCumulative(), RoundingMode.valueOf("HALF_UP"));
      addInvestmentsPerYearCumulative(p);
    }
    return (Contract)this;
  }
  protected Contract investmentsPerYearCumulativeInit() {
    _investmentsPerYearCumulative(investmentsPerYearCumulative);
    return (Contract)this;
  }

  public static String staticSearchInvestmentsPerYearCumulative(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrInvestmentsPerYearCumulative(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInvestmentsPerYearCumulative(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchInvestmentsPerYearCumulative(siteRequest_, Contract.staticSetInvestmentsPerYearCumulative(siteRequest_, o)).toString();
  }

  public Number[] sqlInvestmentsPerYearCumulative() {
    return investmentsPerYearCumulative.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonInvestmentsPerYearCumulative(List<BigDecimal> investmentsPerYearCumulative) {
    JsonArray a = new JsonArray();
    investmentsPerYearCumulative.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	//////////////////
  // assetClasses //
	//////////////////


  /**
   *  The entity assetClasses
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> assetClasses = new ArrayList<String>();

  /**
   * <br> The entity assetClasses
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:assetClasses">Find the entity assetClasses in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _assetClasses(List<String> l);

  public List<String> getAssetClasses() {
    return assetClasses;
  }

  public void setAssetClasses(List<String> assetClasses) {
    this.assetClasses = assetClasses;
  }
  @JsonIgnore
  public void setAssetClasses(String o) {
    String l = Contract.staticSetAssetClasses(siteRequest_, o);
    if(l != null)
      addAssetClasses(l);
  }
  public static String staticSetAssetClasses(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Contract addAssetClasses(String...objects) {
    for(String o : objects) {
      addAssetClasses(o);
    }
    return (Contract)this;
  }
  public Contract addAssetClasses(String o) {
    if(o != null)
      this.assetClasses.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setAssetClasses(JsonArray objects) {
    assetClasses.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addAssetClasses(o);
    }
  }
  protected Contract assetClassesInit() {
    _assetClasses(assetClasses);
    return (Contract)this;
  }

  public static String staticSearchAssetClasses(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAssetClasses(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAssetClasses(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchAssetClasses(siteRequest_, Contract.staticSetAssetClasses(siteRequest_, o)).toString();
  }

  public String[] sqlAssetClasses() {
    return assetClasses.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonAssetClasses(List<String> assetClasses) {
    JsonArray a = new JsonArray();
    assetClasses.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	///////////////////////////
  // assetClassesTargetIrr //
	///////////////////////////


  /**
   *  The entity assetClassesTargetIrr
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,16,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> assetClassesTargetIrr = new ArrayList<BigDecimal>();

  /**
   * <br> The entity assetClassesTargetIrr
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:assetClassesTargetIrr">Find the entity assetClassesTargetIrr in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _assetClassesTargetIrr(List<BigDecimal> l);

  public List<BigDecimal> getAssetClassesTargetIrr() {
    return assetClassesTargetIrr;
  }

  public void setAssetClassesTargetIrr(List<BigDecimal> assetClassesTargetIrr) {
    this.assetClassesTargetIrr = assetClassesTargetIrr;
  }
  @JsonIgnore
  public void setAssetClassesTargetIrr(String o) {
    BigDecimal l = Contract.staticSetAssetClassesTargetIrr(siteRequest_, o);
    if(l != null)
      addAssetClassesTargetIrr(l);
  }
  public static Integer staticScaleAssetClassesTargetIrr() {
    return 2;
  }
  public static MathContext staticMathContextAssetClassesTargetIrr() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetAssetClassesTargetIrr(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextAssetClassesTargetIrr()).setScale(staticScaleAssetClassesTargetIrr(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setAssetClassesTargetIrr(Double o) {
    addAssetClassesTargetIrr(new BigDecimal(o, staticMathContextAssetClassesTargetIrr()).setScale(staticScaleAssetClassesTargetIrr(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setAssetClassesTargetIrr(Integer o) {
    addAssetClassesTargetIrr(new BigDecimal(o, staticMathContextAssetClassesTargetIrr()).setScale(staticScaleAssetClassesTargetIrr(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setAssetClassesTargetIrr(Number o) {
    addAssetClassesTargetIrr(new BigDecimal(o.doubleValue(), staticMathContextAssetClassesTargetIrr()).setScale(staticScaleAssetClassesTargetIrr(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addAssetClassesTargetIrr(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addAssetClassesTargetIrr(o);
    }
    return (Contract)this;
  }
  public Contract addAssetClassesTargetIrr(BigDecimal o) {
    if(o != null)
      this.assetClassesTargetIrr.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setAssetClassesTargetIrr(JsonArray objects) {
    assetClassesTargetIrr.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addAssetClassesTargetIrr(new BigDecimal(o, staticMathContextAssetClassesTargetIrr()).setScale(staticScaleAssetClassesTargetIrr(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addAssetClassesTargetIrr(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextAssetClassesTargetIrr()).setScale(staticScaleAssetClassesTargetIrr(), RoundingMode.valueOf("HALF_UP"));
      addAssetClassesTargetIrr(p);
    }
    return (Contract)this;
  }
  protected Contract assetClassesTargetIrrInit() {
    _assetClassesTargetIrr(assetClassesTargetIrr);
    return (Contract)this;
  }

  public static String staticSearchAssetClassesTargetIrr(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrAssetClassesTargetIrr(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAssetClassesTargetIrr(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchAssetClassesTargetIrr(siteRequest_, Contract.staticSetAssetClassesTargetIrr(siteRequest_, o)).toString();
  }

  public Number[] sqlAssetClassesTargetIrr() {
    return assetClassesTargetIrr.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonAssetClassesTargetIrr(List<BigDecimal> assetClassesTargetIrr) {
    JsonArray a = new JsonArray();
    assetClassesTargetIrr.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////
  // revenueStreams //
	////////////////////


  /**
   *  The entity revenueStreams
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> revenueStreams = new ArrayList<String>();

  /**
   * <br> The entity revenueStreams
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:revenueStreams">Find the entity revenueStreams in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _revenueStreams(List<String> l);

  public List<String> getRevenueStreams() {
    return revenueStreams;
  }

  public void setRevenueStreams(List<String> revenueStreams) {
    this.revenueStreams = revenueStreams;
  }
  @JsonIgnore
  public void setRevenueStreams(String o) {
    String l = Contract.staticSetRevenueStreams(siteRequest_, o);
    if(l != null)
      addRevenueStreams(l);
  }
  public static String staticSetRevenueStreams(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Contract addRevenueStreams(String...objects) {
    for(String o : objects) {
      addRevenueStreams(o);
    }
    return (Contract)this;
  }
  public Contract addRevenueStreams(String o) {
    if(o != null)
      this.revenueStreams.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setRevenueStreams(JsonArray objects) {
    revenueStreams.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addRevenueStreams(o);
    }
  }
  protected Contract revenueStreamsInit() {
    _revenueStreams(revenueStreams);
    return (Contract)this;
  }

  public static String staticSearchRevenueStreams(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrRevenueStreams(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRevenueStreams(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchRevenueStreams(siteRequest_, Contract.staticSetRevenueStreams(siteRequest_, o)).toString();
  }

  public String[] sqlRevenueStreams() {
    return revenueStreams.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonRevenueStreams(List<String> revenueStreams) {
    JsonArray a = new JsonArray();
    revenueStreams.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	///////////////////////////////
  // economicOutputProjections //
	///////////////////////////////


  /**
   *  The entity economicOutputProjections
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,16,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> economicOutputProjections = new ArrayList<BigDecimal>();

  /**
   * <br> The entity economicOutputProjections
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:economicOutputProjections">Find the entity economicOutputProjections in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _economicOutputProjections(List<BigDecimal> l);

  public List<BigDecimal> getEconomicOutputProjections() {
    return economicOutputProjections;
  }

  public void setEconomicOutputProjections(List<BigDecimal> economicOutputProjections) {
    this.economicOutputProjections = economicOutputProjections;
  }
  @JsonIgnore
  public void setEconomicOutputProjections(String o) {
    BigDecimal l = Contract.staticSetEconomicOutputProjections(siteRequest_, o);
    if(l != null)
      addEconomicOutputProjections(l);
  }
  public static Integer staticScaleEconomicOutputProjections() {
    return 2;
  }
  public static MathContext staticMathContextEconomicOutputProjections() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetEconomicOutputProjections(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextEconomicOutputProjections()).setScale(staticScaleEconomicOutputProjections(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setEconomicOutputProjections(Double o) {
    addEconomicOutputProjections(new BigDecimal(o, staticMathContextEconomicOutputProjections()).setScale(staticScaleEconomicOutputProjections(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setEconomicOutputProjections(Integer o) {
    addEconomicOutputProjections(new BigDecimal(o, staticMathContextEconomicOutputProjections()).setScale(staticScaleEconomicOutputProjections(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setEconomicOutputProjections(Number o) {
    addEconomicOutputProjections(new BigDecimal(o.doubleValue(), staticMathContextEconomicOutputProjections()).setScale(staticScaleEconomicOutputProjections(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addEconomicOutputProjections(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addEconomicOutputProjections(o);
    }
    return (Contract)this;
  }
  public Contract addEconomicOutputProjections(BigDecimal o) {
    if(o != null)
      this.economicOutputProjections.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setEconomicOutputProjections(JsonArray objects) {
    economicOutputProjections.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addEconomicOutputProjections(new BigDecimal(o, staticMathContextEconomicOutputProjections()).setScale(staticScaleEconomicOutputProjections(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addEconomicOutputProjections(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextEconomicOutputProjections()).setScale(staticScaleEconomicOutputProjections(), RoundingMode.valueOf("HALF_UP"));
      addEconomicOutputProjections(p);
    }
    return (Contract)this;
  }
  protected Contract economicOutputProjectionsInit() {
    _economicOutputProjections(economicOutputProjections);
    return (Contract)this;
  }

  public static String staticSearchEconomicOutputProjections(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrEconomicOutputProjections(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEconomicOutputProjections(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchEconomicOutputProjections(siteRequest_, Contract.staticSetEconomicOutputProjections(siteRequest_, o)).toString();
  }

  public Number[] sqlEconomicOutputProjections() {
    return economicOutputProjections.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonEconomicOutputProjections(List<BigDecimal> economicOutputProjections) {
    JsonArray a = new JsonArray();
    economicOutputProjections.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////
  // totalGdpImpact //
	////////////////////


  /**
   *  The entity totalGdpImpact
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal totalGdpImpact;

  /**
   * <br> The entity totalGdpImpact
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:totalGdpImpact">Find the entity totalGdpImpact in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _totalGdpImpact(Wrap<BigDecimal> w);

  public BigDecimal getTotalGdpImpact() {
    return totalGdpImpact;
  }

  public void setTotalGdpImpact(BigDecimal totalGdpImpact) {
    this.totalGdpImpact = totalGdpImpact;
  }
  @JsonIgnore
  public void setTotalGdpImpact(String o) {
    this.totalGdpImpact = Contract.staticSetTotalGdpImpact(siteRequest_, o);
  }
  public static Integer staticScaleTotalGdpImpact() {
    return 2;
  }
  public static MathContext staticMathContextTotalGdpImpact() {
    return new MathContext(16, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetTotalGdpImpact(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextTotalGdpImpact()).setScale(staticScaleTotalGdpImpact(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setTotalGdpImpact(Double o) {
    setTotalGdpImpact(new BigDecimal(o, staticMathContextTotalGdpImpact()).setScale(staticScaleTotalGdpImpact(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setTotalGdpImpact(Integer o) {
    setTotalGdpImpact(new BigDecimal(o, staticMathContextTotalGdpImpact()).setScale(staticScaleTotalGdpImpact(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setTotalGdpImpact(Number o) {
    setTotalGdpImpact(new BigDecimal(o.doubleValue(), staticMathContextTotalGdpImpact()).setScale(staticScaleTotalGdpImpact(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract totalGdpImpactInit() {
    Wrap<BigDecimal> totalGdpImpactWrap = new Wrap<BigDecimal>().var("totalGdpImpact");
    if(totalGdpImpact == null) {
      _totalGdpImpact(totalGdpImpactWrap);
      Optional.ofNullable(totalGdpImpactWrap.getO()).ifPresent(o -> {
        setTotalGdpImpact(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchTotalGdpImpact(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrTotalGdpImpact(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTotalGdpImpact(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchTotalGdpImpact(siteRequest_, Contract.staticSetTotalGdpImpact(siteRequest_, o)).toString();
  }

  public BigDecimal sqlTotalGdpImpact() {
    return totalGdpImpact;
  }

  public static String staticJsonTotalGdpImpact(BigDecimal totalGdpImpact) {
    return Optional.ofNullable(totalGdpImpact).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////////////
  // economicOutputProjectionsDataset //
	//////////////////////////////////////


  /**
   *  The entity economicOutputProjectionsDataset
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray economicOutputProjectionsDataset;

  /**
   * <br> The entity economicOutputProjectionsDataset
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:economicOutputProjectionsDataset">Find the entity economicOutputProjectionsDataset in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _economicOutputProjectionsDataset(Wrap<JsonArray> w);

  public JsonArray getEconomicOutputProjectionsDataset() {
    return economicOutputProjectionsDataset;
  }

  public void setEconomicOutputProjectionsDataset(JsonArray economicOutputProjectionsDataset) {
    this.economicOutputProjectionsDataset = economicOutputProjectionsDataset;
  }
  @JsonIgnore
  public void setEconomicOutputProjectionsDataset(String o) {
    this.economicOutputProjectionsDataset = Contract.staticSetEconomicOutputProjectionsDataset(siteRequest_, o);
  }
  public static JsonArray staticSetEconomicOutputProjectionsDataset(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected Contract economicOutputProjectionsDatasetInit() {
    Wrap<JsonArray> economicOutputProjectionsDatasetWrap = new Wrap<JsonArray>().var("economicOutputProjectionsDataset");
    if(economicOutputProjectionsDataset == null) {
      _economicOutputProjectionsDataset(economicOutputProjectionsDatasetWrap);
      Optional.ofNullable(economicOutputProjectionsDatasetWrap.getO()).ifPresent(o -> {
        setEconomicOutputProjectionsDataset(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchEconomicOutputProjectionsDataset(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrEconomicOutputProjectionsDataset(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEconomicOutputProjectionsDataset(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchEconomicOutputProjectionsDataset(siteRequest_, Contract.staticSetEconomicOutputProjectionsDataset(siteRequest_, o)).toString();
  }

  public JsonArray sqlEconomicOutputProjectionsDataset() {
    return economicOutputProjectionsDataset;
  }

  public static JsonArray staticJsonEconomicOutputProjectionsDataset(JsonArray economicOutputProjectionsDataset) {
    return economicOutputProjectionsDataset;
  }

	///////////////////////////////
  // cumulativeInvestmentChart //
	///////////////////////////////


  /**
   *  The entity cumulativeInvestmentChart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject cumulativeInvestmentChart;

  /**
   * <br> The entity cumulativeInvestmentChart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:cumulativeInvestmentChart">Find the entity cumulativeInvestmentChart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _cumulativeInvestmentChart(Wrap<JsonObject> w);

  public JsonObject getCumulativeInvestmentChart() {
    return cumulativeInvestmentChart;
  }

  public void setCumulativeInvestmentChart(JsonObject cumulativeInvestmentChart) {
    this.cumulativeInvestmentChart = cumulativeInvestmentChart;
  }
  @JsonIgnore
  public void setCumulativeInvestmentChart(String o) {
    this.cumulativeInvestmentChart = Contract.staticSetCumulativeInvestmentChart(siteRequest_, o);
  }
  public static JsonObject staticSetCumulativeInvestmentChart(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Contract cumulativeInvestmentChartInit() {
    Wrap<JsonObject> cumulativeInvestmentChartWrap = new Wrap<JsonObject>().var("cumulativeInvestmentChart");
    if(cumulativeInvestmentChart == null) {
      _cumulativeInvestmentChart(cumulativeInvestmentChartWrap);
      Optional.ofNullable(cumulativeInvestmentChartWrap.getO()).ifPresent(o -> {
        setCumulativeInvestmentChart(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchCumulativeInvestmentChart(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrCumulativeInvestmentChart(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqCumulativeInvestmentChart(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchCumulativeInvestmentChart(siteRequest_, Contract.staticSetCumulativeInvestmentChart(siteRequest_, o)).toString();
  }

	///////////////////////
  // architectsPerYear //
	///////////////////////


  /**
   *  The entity architectsPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,1")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> architectsPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity architectsPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:architectsPerYear">Find the entity architectsPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _architectsPerYear(List<BigDecimal> l);

  public List<BigDecimal> getArchitectsPerYear() {
    return architectsPerYear;
  }

  public void setArchitectsPerYear(List<BigDecimal> architectsPerYear) {
    this.architectsPerYear = architectsPerYear;
  }
  @JsonIgnore
  public void setArchitectsPerYear(String o) {
    BigDecimal l = Contract.staticSetArchitectsPerYear(siteRequest_, o);
    if(l != null)
      addArchitectsPerYear(l);
  }
  public static Integer staticScaleArchitectsPerYear() {
    return 1;
  }
  public static MathContext staticMathContextArchitectsPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetArchitectsPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextArchitectsPerYear()).setScale(staticScaleArchitectsPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setArchitectsPerYear(Double o) {
    addArchitectsPerYear(new BigDecimal(o, staticMathContextArchitectsPerYear()).setScale(staticScaleArchitectsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setArchitectsPerYear(Integer o) {
    addArchitectsPerYear(new BigDecimal(o, staticMathContextArchitectsPerYear()).setScale(staticScaleArchitectsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setArchitectsPerYear(Number o) {
    addArchitectsPerYear(new BigDecimal(o.doubleValue(), staticMathContextArchitectsPerYear()).setScale(staticScaleArchitectsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addArchitectsPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addArchitectsPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addArchitectsPerYear(BigDecimal o) {
    if(o != null)
      this.architectsPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setArchitectsPerYear(JsonArray objects) {
    architectsPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addArchitectsPerYear(new BigDecimal(o, staticMathContextArchitectsPerYear()).setScale(staticScaleArchitectsPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addArchitectsPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextArchitectsPerYear()).setScale(staticScaleArchitectsPerYear(), RoundingMode.valueOf("HALF_UP"));
      addArchitectsPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract architectsPerYearInit() {
    _architectsPerYear(architectsPerYear);
    return (Contract)this;
  }

  public static String staticSearchArchitectsPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrArchitectsPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqArchitectsPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchArchitectsPerYear(siteRequest_, Contract.staticSetArchitectsPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlArchitectsPerYear() {
    return architectsPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonArchitectsPerYear(List<BigDecimal> architectsPerYear) {
    JsonArray a = new JsonArray();
    architectsPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	/////////////////////////////
  // remoteDevelopersPerYear //
	/////////////////////////////


  /**
   *  The entity remoteDevelopersPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,1")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> remoteDevelopersPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity remoteDevelopersPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:remoteDevelopersPerYear">Find the entity remoteDevelopersPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _remoteDevelopersPerYear(List<BigDecimal> l);

  public List<BigDecimal> getRemoteDevelopersPerYear() {
    return remoteDevelopersPerYear;
  }

  public void setRemoteDevelopersPerYear(List<BigDecimal> remoteDevelopersPerYear) {
    this.remoteDevelopersPerYear = remoteDevelopersPerYear;
  }
  @JsonIgnore
  public void setRemoteDevelopersPerYear(String o) {
    BigDecimal l = Contract.staticSetRemoteDevelopersPerYear(siteRequest_, o);
    if(l != null)
      addRemoteDevelopersPerYear(l);
  }
  public static Integer staticScaleRemoteDevelopersPerYear() {
    return 1;
  }
  public static MathContext staticMathContextRemoteDevelopersPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetRemoteDevelopersPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextRemoteDevelopersPerYear()).setScale(staticScaleRemoteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setRemoteDevelopersPerYear(Double o) {
    addRemoteDevelopersPerYear(new BigDecimal(o, staticMathContextRemoteDevelopersPerYear()).setScale(staticScaleRemoteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setRemoteDevelopersPerYear(Integer o) {
    addRemoteDevelopersPerYear(new BigDecimal(o, staticMathContextRemoteDevelopersPerYear()).setScale(staticScaleRemoteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setRemoteDevelopersPerYear(Number o) {
    addRemoteDevelopersPerYear(new BigDecimal(o.doubleValue(), staticMathContextRemoteDevelopersPerYear()).setScale(staticScaleRemoteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addRemoteDevelopersPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addRemoteDevelopersPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addRemoteDevelopersPerYear(BigDecimal o) {
    if(o != null)
      this.remoteDevelopersPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setRemoteDevelopersPerYear(JsonArray objects) {
    remoteDevelopersPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addRemoteDevelopersPerYear(new BigDecimal(o, staticMathContextRemoteDevelopersPerYear()).setScale(staticScaleRemoteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addRemoteDevelopersPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextRemoteDevelopersPerYear()).setScale(staticScaleRemoteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP"));
      addRemoteDevelopersPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract remoteDevelopersPerYearInit() {
    _remoteDevelopersPerYear(remoteDevelopersPerYear);
    return (Contract)this;
  }

  public static String staticSearchRemoteDevelopersPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrRemoteDevelopersPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRemoteDevelopersPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchRemoteDevelopersPerYear(siteRequest_, Contract.staticSetRemoteDevelopersPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlRemoteDevelopersPerYear() {
    return remoteDevelopersPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonRemoteDevelopersPerYear(List<BigDecimal> remoteDevelopersPerYear) {
    JsonArray a = new JsonArray();
    remoteDevelopersPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	/////////////////////////////
  // onsiteDevelopersPerYear //
	/////////////////////////////


  /**
   *  The entity onsiteDevelopersPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,1")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> onsiteDevelopersPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity onsiteDevelopersPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:onsiteDevelopersPerYear">Find the entity onsiteDevelopersPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _onsiteDevelopersPerYear(List<BigDecimal> l);

  public List<BigDecimal> getOnsiteDevelopersPerYear() {
    return onsiteDevelopersPerYear;
  }

  public void setOnsiteDevelopersPerYear(List<BigDecimal> onsiteDevelopersPerYear) {
    this.onsiteDevelopersPerYear = onsiteDevelopersPerYear;
  }
  @JsonIgnore
  public void setOnsiteDevelopersPerYear(String o) {
    BigDecimal l = Contract.staticSetOnsiteDevelopersPerYear(siteRequest_, o);
    if(l != null)
      addOnsiteDevelopersPerYear(l);
  }
  public static Integer staticScaleOnsiteDevelopersPerYear() {
    return 1;
  }
  public static MathContext staticMathContextOnsiteDevelopersPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOnsiteDevelopersPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOnsiteDevelopersPerYear()).setScale(staticScaleOnsiteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOnsiteDevelopersPerYear(Double o) {
    addOnsiteDevelopersPerYear(new BigDecimal(o, staticMathContextOnsiteDevelopersPerYear()).setScale(staticScaleOnsiteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOnsiteDevelopersPerYear(Integer o) {
    addOnsiteDevelopersPerYear(new BigDecimal(o, staticMathContextOnsiteDevelopersPerYear()).setScale(staticScaleOnsiteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOnsiteDevelopersPerYear(Number o) {
    addOnsiteDevelopersPerYear(new BigDecimal(o.doubleValue(), staticMathContextOnsiteDevelopersPerYear()).setScale(staticScaleOnsiteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addOnsiteDevelopersPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addOnsiteDevelopersPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addOnsiteDevelopersPerYear(BigDecimal o) {
    if(o != null)
      this.onsiteDevelopersPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setOnsiteDevelopersPerYear(JsonArray objects) {
    onsiteDevelopersPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addOnsiteDevelopersPerYear(new BigDecimal(o, staticMathContextOnsiteDevelopersPerYear()).setScale(staticScaleOnsiteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addOnsiteDevelopersPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextOnsiteDevelopersPerYear()).setScale(staticScaleOnsiteDevelopersPerYear(), RoundingMode.valueOf("HALF_UP"));
      addOnsiteDevelopersPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract onsiteDevelopersPerYearInit() {
    _onsiteDevelopersPerYear(onsiteDevelopersPerYear);
    return (Contract)this;
  }

  public static String staticSearchOnsiteDevelopersPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOnsiteDevelopersPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOnsiteDevelopersPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOnsiteDevelopersPerYear(siteRequest_, Contract.staticSetOnsiteDevelopersPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlOnsiteDevelopersPerYear() {
    return onsiteDevelopersPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonOnsiteDevelopersPerYear(List<BigDecimal> onsiteDevelopersPerYear) {
    JsonArray a = new JsonArray();
    onsiteDevelopersPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////////
  // instructorsPerYear //
	////////////////////////


  /**
   *  The entity instructorsPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,1")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> instructorsPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity instructorsPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:instructorsPerYear">Find the entity instructorsPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _instructorsPerYear(List<BigDecimal> l);

  public List<BigDecimal> getInstructorsPerYear() {
    return instructorsPerYear;
  }

  public void setInstructorsPerYear(List<BigDecimal> instructorsPerYear) {
    this.instructorsPerYear = instructorsPerYear;
  }
  @JsonIgnore
  public void setInstructorsPerYear(String o) {
    BigDecimal l = Contract.staticSetInstructorsPerYear(siteRequest_, o);
    if(l != null)
      addInstructorsPerYear(l);
  }
  public static Integer staticScaleInstructorsPerYear() {
    return 1;
  }
  public static MathContext staticMathContextInstructorsPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetInstructorsPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextInstructorsPerYear()).setScale(staticScaleInstructorsPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setInstructorsPerYear(Double o) {
    addInstructorsPerYear(new BigDecimal(o, staticMathContextInstructorsPerYear()).setScale(staticScaleInstructorsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInstructorsPerYear(Integer o) {
    addInstructorsPerYear(new BigDecimal(o, staticMathContextInstructorsPerYear()).setScale(staticScaleInstructorsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInstructorsPerYear(Number o) {
    addInstructorsPerYear(new BigDecimal(o.doubleValue(), staticMathContextInstructorsPerYear()).setScale(staticScaleInstructorsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addInstructorsPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addInstructorsPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addInstructorsPerYear(BigDecimal o) {
    if(o != null)
      this.instructorsPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setInstructorsPerYear(JsonArray objects) {
    instructorsPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addInstructorsPerYear(new BigDecimal(o, staticMathContextInstructorsPerYear()).setScale(staticScaleInstructorsPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addInstructorsPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextInstructorsPerYear()).setScale(staticScaleInstructorsPerYear(), RoundingMode.valueOf("HALF_UP"));
      addInstructorsPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract instructorsPerYearInit() {
    _instructorsPerYear(instructorsPerYear);
    return (Contract)this;
  }

  public static String staticSearchInstructorsPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrInstructorsPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInstructorsPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchInstructorsPerYear(siteRequest_, Contract.staticSetInstructorsPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlInstructorsPerYear() {
    return instructorsPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonInstructorsPerYear(List<BigDecimal> instructorsPerYear) {
    JsonArray a = new JsonArray();
    instructorsPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	///////////////////////////////
  // remoteDeveloperPayPerYear //
	///////////////////////////////


  /**
   *  The entity remoteDeveloperPayPerYear
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal remoteDeveloperPayPerYear;

  /**
   * <br> The entity remoteDeveloperPayPerYear
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:remoteDeveloperPayPerYear">Find the entity remoteDeveloperPayPerYear in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _remoteDeveloperPayPerYear(Wrap<BigDecimal> w);

  public BigDecimal getRemoteDeveloperPayPerYear() {
    return remoteDeveloperPayPerYear;
  }

  public void setRemoteDeveloperPayPerYear(BigDecimal remoteDeveloperPayPerYear) {
    this.remoteDeveloperPayPerYear = remoteDeveloperPayPerYear;
  }
  @JsonIgnore
  public void setRemoteDeveloperPayPerYear(String o) {
    this.remoteDeveloperPayPerYear = Contract.staticSetRemoteDeveloperPayPerYear(siteRequest_, o);
  }
  public static Integer staticScaleRemoteDeveloperPayPerYear() {
    return 2;
  }
  public static MathContext staticMathContextRemoteDeveloperPayPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetRemoteDeveloperPayPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextRemoteDeveloperPayPerYear()).setScale(staticScaleRemoteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setRemoteDeveloperPayPerYear(Double o) {
    setRemoteDeveloperPayPerYear(new BigDecimal(o, staticMathContextRemoteDeveloperPayPerYear()).setScale(staticScaleRemoteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setRemoteDeveloperPayPerYear(Integer o) {
    setRemoteDeveloperPayPerYear(new BigDecimal(o, staticMathContextRemoteDeveloperPayPerYear()).setScale(staticScaleRemoteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setRemoteDeveloperPayPerYear(Number o) {
    setRemoteDeveloperPayPerYear(new BigDecimal(o.doubleValue(), staticMathContextRemoteDeveloperPayPerYear()).setScale(staticScaleRemoteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract remoteDeveloperPayPerYearInit() {
    Wrap<BigDecimal> remoteDeveloperPayPerYearWrap = new Wrap<BigDecimal>().var("remoteDeveloperPayPerYear");
    if(remoteDeveloperPayPerYear == null) {
      _remoteDeveloperPayPerYear(remoteDeveloperPayPerYearWrap);
      Optional.ofNullable(remoteDeveloperPayPerYearWrap.getO()).ifPresent(o -> {
        setRemoteDeveloperPayPerYear(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchRemoteDeveloperPayPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrRemoteDeveloperPayPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRemoteDeveloperPayPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchRemoteDeveloperPayPerYear(siteRequest_, Contract.staticSetRemoteDeveloperPayPerYear(siteRequest_, o)).toString();
  }

  public BigDecimal sqlRemoteDeveloperPayPerYear() {
    return remoteDeveloperPayPerYear;
  }

  public static String staticJsonRemoteDeveloperPayPerYear(BigDecimal remoteDeveloperPayPerYear) {
    return Optional.ofNullable(remoteDeveloperPayPerYear).map(v -> v.toString()).orElse(null);
  }

	///////////////////////////////
  // onsiteDeveloperPayPerYear //
	///////////////////////////////


  /**
   *  The entity onsiteDeveloperPayPerYear
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal onsiteDeveloperPayPerYear;

  /**
   * <br> The entity onsiteDeveloperPayPerYear
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:onsiteDeveloperPayPerYear">Find the entity onsiteDeveloperPayPerYear in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _onsiteDeveloperPayPerYear(Wrap<BigDecimal> w);

  public BigDecimal getOnsiteDeveloperPayPerYear() {
    return onsiteDeveloperPayPerYear;
  }

  public void setOnsiteDeveloperPayPerYear(BigDecimal onsiteDeveloperPayPerYear) {
    this.onsiteDeveloperPayPerYear = onsiteDeveloperPayPerYear;
  }
  @JsonIgnore
  public void setOnsiteDeveloperPayPerYear(String o) {
    this.onsiteDeveloperPayPerYear = Contract.staticSetOnsiteDeveloperPayPerYear(siteRequest_, o);
  }
  public static Integer staticScaleOnsiteDeveloperPayPerYear() {
    return 2;
  }
  public static MathContext staticMathContextOnsiteDeveloperPayPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOnsiteDeveloperPayPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOnsiteDeveloperPayPerYear()).setScale(staticScaleOnsiteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOnsiteDeveloperPayPerYear(Double o) {
    setOnsiteDeveloperPayPerYear(new BigDecimal(o, staticMathContextOnsiteDeveloperPayPerYear()).setScale(staticScaleOnsiteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOnsiteDeveloperPayPerYear(Integer o) {
    setOnsiteDeveloperPayPerYear(new BigDecimal(o, staticMathContextOnsiteDeveloperPayPerYear()).setScale(staticScaleOnsiteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOnsiteDeveloperPayPerYear(Number o) {
    setOnsiteDeveloperPayPerYear(new BigDecimal(o.doubleValue(), staticMathContextOnsiteDeveloperPayPerYear()).setScale(staticScaleOnsiteDeveloperPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract onsiteDeveloperPayPerYearInit() {
    Wrap<BigDecimal> onsiteDeveloperPayPerYearWrap = new Wrap<BigDecimal>().var("onsiteDeveloperPayPerYear");
    if(onsiteDeveloperPayPerYear == null) {
      _onsiteDeveloperPayPerYear(onsiteDeveloperPayPerYearWrap);
      Optional.ofNullable(onsiteDeveloperPayPerYearWrap.getO()).ifPresent(o -> {
        setOnsiteDeveloperPayPerYear(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOnsiteDeveloperPayPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOnsiteDeveloperPayPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOnsiteDeveloperPayPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOnsiteDeveloperPayPerYear(siteRequest_, Contract.staticSetOnsiteDeveloperPayPerYear(siteRequest_, o)).toString();
  }

  public BigDecimal sqlOnsiteDeveloperPayPerYear() {
    return onsiteDeveloperPayPerYear;
  }

  public static String staticJsonOnsiteDeveloperPayPerYear(BigDecimal onsiteDeveloperPayPerYear) {
    return Optional.ofNullable(onsiteDeveloperPayPerYear).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////
  // architectPayPerYear //
	/////////////////////////


  /**
   *  The entity architectPayPerYear
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal architectPayPerYear;

  /**
   * <br> The entity architectPayPerYear
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:architectPayPerYear">Find the entity architectPayPerYear in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _architectPayPerYear(Wrap<BigDecimal> w);

  public BigDecimal getArchitectPayPerYear() {
    return architectPayPerYear;
  }

  public void setArchitectPayPerYear(BigDecimal architectPayPerYear) {
    this.architectPayPerYear = architectPayPerYear;
  }
  @JsonIgnore
  public void setArchitectPayPerYear(String o) {
    this.architectPayPerYear = Contract.staticSetArchitectPayPerYear(siteRequest_, o);
  }
  public static Integer staticScaleArchitectPayPerYear() {
    return 2;
  }
  public static MathContext staticMathContextArchitectPayPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetArchitectPayPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextArchitectPayPerYear()).setScale(staticScaleArchitectPayPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setArchitectPayPerYear(Double o) {
    setArchitectPayPerYear(new BigDecimal(o, staticMathContextArchitectPayPerYear()).setScale(staticScaleArchitectPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setArchitectPayPerYear(Integer o) {
    setArchitectPayPerYear(new BigDecimal(o, staticMathContextArchitectPayPerYear()).setScale(staticScaleArchitectPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setArchitectPayPerYear(Number o) {
    setArchitectPayPerYear(new BigDecimal(o.doubleValue(), staticMathContextArchitectPayPerYear()).setScale(staticScaleArchitectPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract architectPayPerYearInit() {
    Wrap<BigDecimal> architectPayPerYearWrap = new Wrap<BigDecimal>().var("architectPayPerYear");
    if(architectPayPerYear == null) {
      _architectPayPerYear(architectPayPerYearWrap);
      Optional.ofNullable(architectPayPerYearWrap.getO()).ifPresent(o -> {
        setArchitectPayPerYear(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchArchitectPayPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrArchitectPayPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqArchitectPayPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchArchitectPayPerYear(siteRequest_, Contract.staticSetArchitectPayPerYear(siteRequest_, o)).toString();
  }

  public BigDecimal sqlArchitectPayPerYear() {
    return architectPayPerYear;
  }

  public static String staticJsonArchitectPayPerYear(BigDecimal architectPayPerYear) {
    return Optional.ofNullable(architectPayPerYear).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////
  // instructorPayPerYear //
	//////////////////////////


  /**
   *  The entity instructorPayPerYear
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal instructorPayPerYear;

  /**
   * <br> The entity instructorPayPerYear
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:instructorPayPerYear">Find the entity instructorPayPerYear in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _instructorPayPerYear(Wrap<BigDecimal> w);

  public BigDecimal getInstructorPayPerYear() {
    return instructorPayPerYear;
  }

  public void setInstructorPayPerYear(BigDecimal instructorPayPerYear) {
    this.instructorPayPerYear = instructorPayPerYear;
  }
  @JsonIgnore
  public void setInstructorPayPerYear(String o) {
    this.instructorPayPerYear = Contract.staticSetInstructorPayPerYear(siteRequest_, o);
  }
  public static Integer staticScaleInstructorPayPerYear() {
    return 2;
  }
  public static MathContext staticMathContextInstructorPayPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetInstructorPayPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextInstructorPayPerYear()).setScale(staticScaleInstructorPayPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setInstructorPayPerYear(Double o) {
    setInstructorPayPerYear(new BigDecimal(o, staticMathContextInstructorPayPerYear()).setScale(staticScaleInstructorPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInstructorPayPerYear(Integer o) {
    setInstructorPayPerYear(new BigDecimal(o, staticMathContextInstructorPayPerYear()).setScale(staticScaleInstructorPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setInstructorPayPerYear(Number o) {
    setInstructorPayPerYear(new BigDecimal(o.doubleValue(), staticMathContextInstructorPayPerYear()).setScale(staticScaleInstructorPayPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract instructorPayPerYearInit() {
    Wrap<BigDecimal> instructorPayPerYearWrap = new Wrap<BigDecimal>().var("instructorPayPerYear");
    if(instructorPayPerYear == null) {
      _instructorPayPerYear(instructorPayPerYearWrap);
      Optional.ofNullable(instructorPayPerYearWrap.getO()).ifPresent(o -> {
        setInstructorPayPerYear(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchInstructorPayPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrInstructorPayPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInstructorPayPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchInstructorPayPerYear(siteRequest_, Contract.staticSetInstructorPayPerYear(siteRequest_, o)).toString();
  }

  public BigDecimal sqlInstructorPayPerYear() {
    return instructorPayPerYear;
  }

  public static String staticJsonInstructorPayPerYear(BigDecimal instructorPayPerYear) {
    return Optional.ofNullable(instructorPayPerYear).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////
  // subscriptionsPerYear //
	//////////////////////////


  /**
   *  The entity subscriptionsPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> subscriptionsPerYear = new ArrayList<String>();

  /**
   * <br> The entity subscriptionsPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:subscriptionsPerYear">Find the entity subscriptionsPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _subscriptionsPerYear(List<String> l);

  public List<String> getSubscriptionsPerYear() {
    return subscriptionsPerYear;
  }

  public void setSubscriptionsPerYear(List<String> subscriptionsPerYear) {
    this.subscriptionsPerYear = subscriptionsPerYear;
  }
  @JsonIgnore
  public void setSubscriptionsPerYear(String o) {
    String l = Contract.staticSetSubscriptionsPerYear(siteRequest_, o);
    if(l != null)
      addSubscriptionsPerYear(l);
  }
  public static String staticSetSubscriptionsPerYear(SiteRequest siteRequest_, String o) {
    return o;
  }
  public Contract addSubscriptionsPerYear(String...objects) {
    for(String o : objects) {
      addSubscriptionsPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addSubscriptionsPerYear(String o) {
    if(o != null)
      this.subscriptionsPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setSubscriptionsPerYear(JsonArray objects) {
    subscriptionsPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addSubscriptionsPerYear(o);
    }
  }
  protected Contract subscriptionsPerYearInit() {
    _subscriptionsPerYear(subscriptionsPerYear);
    return (Contract)this;
  }

  public static String staticSearchSubscriptionsPerYear(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSubscriptionsPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSubscriptionsPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchSubscriptionsPerYear(siteRequest_, Contract.staticSetSubscriptionsPerYear(siteRequest_, o)).toString();
  }

  public String[] sqlSubscriptionsPerYear() {
    return subscriptionsPerYear.stream().map(v -> (String)v).toArray(String[]::new);
  }

  public static JsonArray staticJsonSubscriptionsPerYear(List<String> subscriptionsPerYear) {
    JsonArray a = new JsonArray();
    subscriptionsPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	//////////////////////////////
  // subscriptionCostsPerYear //
	//////////////////////////////


  /**
   *  The entity subscriptionCostsPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> subscriptionCostsPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity subscriptionCostsPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:subscriptionCostsPerYear">Find the entity subscriptionCostsPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _subscriptionCostsPerYear(List<BigDecimal> l);

  public List<BigDecimal> getSubscriptionCostsPerYear() {
    return subscriptionCostsPerYear;
  }

  public void setSubscriptionCostsPerYear(List<BigDecimal> subscriptionCostsPerYear) {
    this.subscriptionCostsPerYear = subscriptionCostsPerYear;
  }
  @JsonIgnore
  public void setSubscriptionCostsPerYear(String o) {
    BigDecimal l = Contract.staticSetSubscriptionCostsPerYear(siteRequest_, o);
    if(l != null)
      addSubscriptionCostsPerYear(l);
  }
  public static Integer staticScaleSubscriptionCostsPerYear() {
    return 2;
  }
  public static MathContext staticMathContextSubscriptionCostsPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetSubscriptionCostsPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextSubscriptionCostsPerYear()).setScale(staticScaleSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setSubscriptionCostsPerYear(Double o) {
    addSubscriptionCostsPerYear(new BigDecimal(o, staticMathContextSubscriptionCostsPerYear()).setScale(staticScaleSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setSubscriptionCostsPerYear(Integer o) {
    addSubscriptionCostsPerYear(new BigDecimal(o, staticMathContextSubscriptionCostsPerYear()).setScale(staticScaleSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setSubscriptionCostsPerYear(Number o) {
    addSubscriptionCostsPerYear(new BigDecimal(o.doubleValue(), staticMathContextSubscriptionCostsPerYear()).setScale(staticScaleSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addSubscriptionCostsPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addSubscriptionCostsPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addSubscriptionCostsPerYear(BigDecimal o) {
    if(o != null)
      this.subscriptionCostsPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setSubscriptionCostsPerYear(JsonArray objects) {
    subscriptionCostsPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addSubscriptionCostsPerYear(new BigDecimal(o, staticMathContextSubscriptionCostsPerYear()).setScale(staticScaleSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addSubscriptionCostsPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextSubscriptionCostsPerYear()).setScale(staticScaleSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP"));
      addSubscriptionCostsPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract subscriptionCostsPerYearInit() {
    _subscriptionCostsPerYear(subscriptionCostsPerYear);
    return (Contract)this;
  }

  public static String staticSearchSubscriptionCostsPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrSubscriptionCostsPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSubscriptionCostsPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchSubscriptionCostsPerYear(siteRequest_, Contract.staticSetSubscriptionCostsPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlSubscriptionCostsPerYear() {
    return subscriptionCostsPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonSubscriptionCostsPerYear(List<BigDecimal> subscriptionCostsPerYear) {
    JsonArray a = new JsonArray();
    subscriptionCostsPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	//////////////////////////////////
  // totalSubscriptionCostPerYear //
	//////////////////////////////////


  /**
   *  The entity totalSubscriptionCostPerYear
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal totalSubscriptionCostPerYear;

  /**
   * <br> The entity totalSubscriptionCostPerYear
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:totalSubscriptionCostPerYear">Find the entity totalSubscriptionCostPerYear in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _totalSubscriptionCostPerYear(Wrap<BigDecimal> w);

  public BigDecimal getTotalSubscriptionCostPerYear() {
    return totalSubscriptionCostPerYear;
  }

  public void setTotalSubscriptionCostPerYear(BigDecimal totalSubscriptionCostPerYear) {
    this.totalSubscriptionCostPerYear = totalSubscriptionCostPerYear;
  }
  @JsonIgnore
  public void setTotalSubscriptionCostPerYear(String o) {
    this.totalSubscriptionCostPerYear = Contract.staticSetTotalSubscriptionCostPerYear(siteRequest_, o);
  }
  public static Integer staticScaleTotalSubscriptionCostPerYear() {
    return 2;
  }
  public static MathContext staticMathContextTotalSubscriptionCostPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetTotalSubscriptionCostPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextTotalSubscriptionCostPerYear()).setScale(staticScaleTotalSubscriptionCostPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setTotalSubscriptionCostPerYear(Double o) {
    setTotalSubscriptionCostPerYear(new BigDecimal(o, staticMathContextTotalSubscriptionCostPerYear()).setScale(staticScaleTotalSubscriptionCostPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setTotalSubscriptionCostPerYear(Integer o) {
    setTotalSubscriptionCostPerYear(new BigDecimal(o, staticMathContextTotalSubscriptionCostPerYear()).setScale(staticScaleTotalSubscriptionCostPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setTotalSubscriptionCostPerYear(Number o) {
    setTotalSubscriptionCostPerYear(new BigDecimal(o.doubleValue(), staticMathContextTotalSubscriptionCostPerYear()).setScale(staticScaleTotalSubscriptionCostPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract totalSubscriptionCostPerYearInit() {
    Wrap<BigDecimal> totalSubscriptionCostPerYearWrap = new Wrap<BigDecimal>().var("totalSubscriptionCostPerYear");
    if(totalSubscriptionCostPerYear == null) {
      _totalSubscriptionCostPerYear(totalSubscriptionCostPerYearWrap);
      Optional.ofNullable(totalSubscriptionCostPerYearWrap.getO()).ifPresent(o -> {
        setTotalSubscriptionCostPerYear(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchTotalSubscriptionCostPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrTotalSubscriptionCostPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTotalSubscriptionCostPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchTotalSubscriptionCostPerYear(siteRequest_, Contract.staticSetTotalSubscriptionCostPerYear(siteRequest_, o)).toString();
  }

  public BigDecimal sqlTotalSubscriptionCostPerYear() {
    return totalSubscriptionCostPerYear;
  }

  public static String staticJsonTotalSubscriptionCostPerYear(BigDecimal totalSubscriptionCostPerYear) {
    return Optional.ofNullable(totalSubscriptionCostPerYear).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////////////
  // employeeSubscriptionCostsPerYear //
	//////////////////////////////////////


  /**
   *  The entity employeeSubscriptionCostsPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> employeeSubscriptionCostsPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity employeeSubscriptionCostsPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:employeeSubscriptionCostsPerYear">Find the entity employeeSubscriptionCostsPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _employeeSubscriptionCostsPerYear(List<BigDecimal> l);

  public List<BigDecimal> getEmployeeSubscriptionCostsPerYear() {
    return employeeSubscriptionCostsPerYear;
  }

  public void setEmployeeSubscriptionCostsPerYear(List<BigDecimal> employeeSubscriptionCostsPerYear) {
    this.employeeSubscriptionCostsPerYear = employeeSubscriptionCostsPerYear;
  }
  @JsonIgnore
  public void setEmployeeSubscriptionCostsPerYear(String o) {
    BigDecimal l = Contract.staticSetEmployeeSubscriptionCostsPerYear(siteRequest_, o);
    if(l != null)
      addEmployeeSubscriptionCostsPerYear(l);
  }
  public static Integer staticScaleEmployeeSubscriptionCostsPerYear() {
    return 2;
  }
  public static MathContext staticMathContextEmployeeSubscriptionCostsPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetEmployeeSubscriptionCostsPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextEmployeeSubscriptionCostsPerYear()).setScale(staticScaleEmployeeSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setEmployeeSubscriptionCostsPerYear(Double o) {
    addEmployeeSubscriptionCostsPerYear(new BigDecimal(o, staticMathContextEmployeeSubscriptionCostsPerYear()).setScale(staticScaleEmployeeSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setEmployeeSubscriptionCostsPerYear(Integer o) {
    addEmployeeSubscriptionCostsPerYear(new BigDecimal(o, staticMathContextEmployeeSubscriptionCostsPerYear()).setScale(staticScaleEmployeeSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setEmployeeSubscriptionCostsPerYear(Number o) {
    addEmployeeSubscriptionCostsPerYear(new BigDecimal(o.doubleValue(), staticMathContextEmployeeSubscriptionCostsPerYear()).setScale(staticScaleEmployeeSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addEmployeeSubscriptionCostsPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addEmployeeSubscriptionCostsPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addEmployeeSubscriptionCostsPerYear(BigDecimal o) {
    if(o != null)
      this.employeeSubscriptionCostsPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setEmployeeSubscriptionCostsPerYear(JsonArray objects) {
    employeeSubscriptionCostsPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addEmployeeSubscriptionCostsPerYear(new BigDecimal(o, staticMathContextEmployeeSubscriptionCostsPerYear()).setScale(staticScaleEmployeeSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addEmployeeSubscriptionCostsPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextEmployeeSubscriptionCostsPerYear()).setScale(staticScaleEmployeeSubscriptionCostsPerYear(), RoundingMode.valueOf("HALF_UP"));
      addEmployeeSubscriptionCostsPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract employeeSubscriptionCostsPerYearInit() {
    _employeeSubscriptionCostsPerYear(employeeSubscriptionCostsPerYear);
    return (Contract)this;
  }

  public static String staticSearchEmployeeSubscriptionCostsPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrEmployeeSubscriptionCostsPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEmployeeSubscriptionCostsPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchEmployeeSubscriptionCostsPerYear(siteRequest_, Contract.staticSetEmployeeSubscriptionCostsPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlEmployeeSubscriptionCostsPerYear() {
    return employeeSubscriptionCostsPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonEmployeeSubscriptionCostsPerYear(List<BigDecimal> employeeSubscriptionCostsPerYear) {
    JsonArray a = new JsonArray();
    employeeSubscriptionCostsPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	/////////////////////////////
  // employeesPerYearDataset //
	/////////////////////////////


  /**
   *  The entity employeesPerYearDataset
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray employeesPerYearDataset;

  /**
   * <br> The entity employeesPerYearDataset
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:employeesPerYearDataset">Find the entity employeesPerYearDataset in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _employeesPerYearDataset(Wrap<JsonArray> w);

  public JsonArray getEmployeesPerYearDataset() {
    return employeesPerYearDataset;
  }

  public void setEmployeesPerYearDataset(JsonArray employeesPerYearDataset) {
    this.employeesPerYearDataset = employeesPerYearDataset;
  }
  @JsonIgnore
  public void setEmployeesPerYearDataset(String o) {
    this.employeesPerYearDataset = Contract.staticSetEmployeesPerYearDataset(siteRequest_, o);
  }
  public static JsonArray staticSetEmployeesPerYearDataset(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected Contract employeesPerYearDatasetInit() {
    Wrap<JsonArray> employeesPerYearDatasetWrap = new Wrap<JsonArray>().var("employeesPerYearDataset");
    if(employeesPerYearDataset == null) {
      _employeesPerYearDataset(employeesPerYearDatasetWrap);
      Optional.ofNullable(employeesPerYearDatasetWrap.getO()).ifPresent(o -> {
        setEmployeesPerYearDataset(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchEmployeesPerYearDataset(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrEmployeesPerYearDataset(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEmployeesPerYearDataset(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchEmployeesPerYearDataset(siteRequest_, Contract.staticSetEmployeesPerYearDataset(siteRequest_, o)).toString();
  }

  public JsonArray sqlEmployeesPerYearDataset() {
    return employeesPerYearDataset;
  }

  public static JsonArray staticJsonEmployeesPerYearDataset(JsonArray employeesPerYearDataset) {
    return employeesPerYearDataset;
  }

	/////////////////////////////////////
  // subscriptionCostsPerYearDataset //
	/////////////////////////////////////


  /**
   *  The entity subscriptionCostsPerYearDataset
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray subscriptionCostsPerYearDataset;

  /**
   * <br> The entity subscriptionCostsPerYearDataset
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:subscriptionCostsPerYearDataset">Find the entity subscriptionCostsPerYearDataset in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _subscriptionCostsPerYearDataset(Wrap<JsonArray> w);

  public JsonArray getSubscriptionCostsPerYearDataset() {
    return subscriptionCostsPerYearDataset;
  }

  public void setSubscriptionCostsPerYearDataset(JsonArray subscriptionCostsPerYearDataset) {
    this.subscriptionCostsPerYearDataset = subscriptionCostsPerYearDataset;
  }
  @JsonIgnore
  public void setSubscriptionCostsPerYearDataset(String o) {
    this.subscriptionCostsPerYearDataset = Contract.staticSetSubscriptionCostsPerYearDataset(siteRequest_, o);
  }
  public static JsonArray staticSetSubscriptionCostsPerYearDataset(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected Contract subscriptionCostsPerYearDatasetInit() {
    Wrap<JsonArray> subscriptionCostsPerYearDatasetWrap = new Wrap<JsonArray>().var("subscriptionCostsPerYearDataset");
    if(subscriptionCostsPerYearDataset == null) {
      _subscriptionCostsPerYearDataset(subscriptionCostsPerYearDatasetWrap);
      Optional.ofNullable(subscriptionCostsPerYearDatasetWrap.getO()).ifPresent(o -> {
        setSubscriptionCostsPerYearDataset(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchSubscriptionCostsPerYearDataset(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrSubscriptionCostsPerYearDataset(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSubscriptionCostsPerYearDataset(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchSubscriptionCostsPerYearDataset(siteRequest_, Contract.staticSetSubscriptionCostsPerYearDataset(siteRequest_, o)).toString();
  }

  public JsonArray sqlSubscriptionCostsPerYearDataset() {
    return subscriptionCostsPerYearDataset;
  }

  public static JsonArray staticJsonSubscriptionCostsPerYearDataset(JsonArray subscriptionCostsPerYearDataset) {
    return subscriptionCostsPerYearDataset;
  }

	///////////////////////////
  // employeesPerYearChart //
	///////////////////////////


  /**
   *  The entity employeesPerYearChart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject employeesPerYearChart;

  /**
   * <br> The entity employeesPerYearChart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:employeesPerYearChart">Find the entity employeesPerYearChart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _employeesPerYearChart(Wrap<JsonObject> w);

  public JsonObject getEmployeesPerYearChart() {
    return employeesPerYearChart;
  }

  public void setEmployeesPerYearChart(JsonObject employeesPerYearChart) {
    this.employeesPerYearChart = employeesPerYearChart;
  }
  @JsonIgnore
  public void setEmployeesPerYearChart(String o) {
    this.employeesPerYearChart = Contract.staticSetEmployeesPerYearChart(siteRequest_, o);
  }
  public static JsonObject staticSetEmployeesPerYearChart(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Contract employeesPerYearChartInit() {
    Wrap<JsonObject> employeesPerYearChartWrap = new Wrap<JsonObject>().var("employeesPerYearChart");
    if(employeesPerYearChart == null) {
      _employeesPerYearChart(employeesPerYearChartWrap);
      Optional.ofNullable(employeesPerYearChartWrap.getO()).ifPresent(o -> {
        setEmployeesPerYearChart(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchEmployeesPerYearChart(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrEmployeesPerYearChart(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEmployeesPerYearChart(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchEmployeesPerYearChart(siteRequest_, Contract.staticSetEmployeesPerYearChart(siteRequest_, o)).toString();
  }

	////////////////////////////////
  // openshiftControlPlaneNodes //
	////////////////////////////////


  /**
   *  The entity openshiftControlPlaneNodes
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer openshiftControlPlaneNodes;

  /**
   * <br> The entity openshiftControlPlaneNodes
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftControlPlaneNodes">Find the entity openshiftControlPlaneNodes in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftControlPlaneNodes(Wrap<Integer> w);

  public Integer getOpenshiftControlPlaneNodes() {
    return openshiftControlPlaneNodes;
  }

  public void setOpenshiftControlPlaneNodes(Integer openshiftControlPlaneNodes) {
    this.openshiftControlPlaneNodes = openshiftControlPlaneNodes;
  }
  @JsonIgnore
  public void setOpenshiftControlPlaneNodes(String o) {
    this.openshiftControlPlaneNodes = Contract.staticSetOpenshiftControlPlaneNodes(siteRequest_, o);
  }
  public static Integer staticSetOpenshiftControlPlaneNodes(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract openshiftControlPlaneNodesInit() {
    Wrap<Integer> openshiftControlPlaneNodesWrap = new Wrap<Integer>().var("openshiftControlPlaneNodes");
    if(openshiftControlPlaneNodes == null) {
      _openshiftControlPlaneNodes(openshiftControlPlaneNodesWrap);
      Optional.ofNullable(openshiftControlPlaneNodesWrap.getO()).ifPresent(o -> {
        setOpenshiftControlPlaneNodes(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchOpenshiftControlPlaneNodes(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrOpenshiftControlPlaneNodes(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftControlPlaneNodes(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftControlPlaneNodes(siteRequest_, Contract.staticSetOpenshiftControlPlaneNodes(siteRequest_, o)).toString();
  }

  public Integer sqlOpenshiftControlPlaneNodes() {
    return openshiftControlPlaneNodes;
  }

  public static String staticJsonOpenshiftControlPlaneNodes(Integer openshiftControlPlaneNodes) {
    return Optional.ofNullable(openshiftControlPlaneNodes).map(v -> v.toString()).orElse(null);
  }

	////////////////////////////////
  // openshiftControlPlaneCores //
	////////////////////////////////


  /**
   *  The entity openshiftControlPlaneCores
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer openshiftControlPlaneCores;

  /**
   * <br> The entity openshiftControlPlaneCores
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftControlPlaneCores">Find the entity openshiftControlPlaneCores in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftControlPlaneCores(Wrap<Integer> w);

  public Integer getOpenshiftControlPlaneCores() {
    return openshiftControlPlaneCores;
  }

  public void setOpenshiftControlPlaneCores(Integer openshiftControlPlaneCores) {
    this.openshiftControlPlaneCores = openshiftControlPlaneCores;
  }
  @JsonIgnore
  public void setOpenshiftControlPlaneCores(String o) {
    this.openshiftControlPlaneCores = Contract.staticSetOpenshiftControlPlaneCores(siteRequest_, o);
  }
  public static Integer staticSetOpenshiftControlPlaneCores(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract openshiftControlPlaneCoresInit() {
    Wrap<Integer> openshiftControlPlaneCoresWrap = new Wrap<Integer>().var("openshiftControlPlaneCores");
    if(openshiftControlPlaneCores == null) {
      _openshiftControlPlaneCores(openshiftControlPlaneCoresWrap);
      Optional.ofNullable(openshiftControlPlaneCoresWrap.getO()).ifPresent(o -> {
        setOpenshiftControlPlaneCores(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchOpenshiftControlPlaneCores(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrOpenshiftControlPlaneCores(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftControlPlaneCores(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftControlPlaneCores(siteRequest_, Contract.staticSetOpenshiftControlPlaneCores(siteRequest_, o)).toString();
  }

  public Integer sqlOpenshiftControlPlaneCores() {
    return openshiftControlPlaneCores;
  }

  public static String staticJsonOpenshiftControlPlaneCores(Integer openshiftControlPlaneCores) {
    return Optional.ofNullable(openshiftControlPlaneCores).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////////////////
  // totalOpenshiftControlPlaneCores //
	/////////////////////////////////////


  /**
   *  The entity totalOpenshiftControlPlaneCores
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer totalOpenshiftControlPlaneCores;

  /**
   * <br> The entity totalOpenshiftControlPlaneCores
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:totalOpenshiftControlPlaneCores">Find the entity totalOpenshiftControlPlaneCores in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _totalOpenshiftControlPlaneCores(Wrap<Integer> w);

  public Integer getTotalOpenshiftControlPlaneCores() {
    return totalOpenshiftControlPlaneCores;
  }

  public void setTotalOpenshiftControlPlaneCores(Integer totalOpenshiftControlPlaneCores) {
    this.totalOpenshiftControlPlaneCores = totalOpenshiftControlPlaneCores;
  }
  @JsonIgnore
  public void setTotalOpenshiftControlPlaneCores(String o) {
    this.totalOpenshiftControlPlaneCores = Contract.staticSetTotalOpenshiftControlPlaneCores(siteRequest_, o);
  }
  public static Integer staticSetTotalOpenshiftControlPlaneCores(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract totalOpenshiftControlPlaneCoresInit() {
    Wrap<Integer> totalOpenshiftControlPlaneCoresWrap = new Wrap<Integer>().var("totalOpenshiftControlPlaneCores");
    if(totalOpenshiftControlPlaneCores == null) {
      _totalOpenshiftControlPlaneCores(totalOpenshiftControlPlaneCoresWrap);
      Optional.ofNullable(totalOpenshiftControlPlaneCoresWrap.getO()).ifPresent(o -> {
        setTotalOpenshiftControlPlaneCores(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchTotalOpenshiftControlPlaneCores(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrTotalOpenshiftControlPlaneCores(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTotalOpenshiftControlPlaneCores(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchTotalOpenshiftControlPlaneCores(siteRequest_, Contract.staticSetTotalOpenshiftControlPlaneCores(siteRequest_, o)).toString();
  }

  public Integer sqlTotalOpenshiftControlPlaneCores() {
    return totalOpenshiftControlPlaneCores;
  }

  public static String staticJsonTotalOpenshiftControlPlaneCores(Integer totalOpenshiftControlPlaneCores) {
    return Optional.ofNullable(totalOpenshiftControlPlaneCores).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////////////////////////
  // openshiftControlPlaneHourlyPricePerCore //
	/////////////////////////////////////////////


  /**
   *  The entity openshiftControlPlaneHourlyPricePerCore
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal openshiftControlPlaneHourlyPricePerCore;

  /**
   * <br> The entity openshiftControlPlaneHourlyPricePerCore
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftControlPlaneHourlyPricePerCore">Find the entity openshiftControlPlaneHourlyPricePerCore in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftControlPlaneHourlyPricePerCore(Wrap<BigDecimal> w);

  public BigDecimal getOpenshiftControlPlaneHourlyPricePerCore() {
    return openshiftControlPlaneHourlyPricePerCore;
  }

  public void setOpenshiftControlPlaneHourlyPricePerCore(BigDecimal openshiftControlPlaneHourlyPricePerCore) {
    this.openshiftControlPlaneHourlyPricePerCore = openshiftControlPlaneHourlyPricePerCore;
  }
  @JsonIgnore
  public void setOpenshiftControlPlaneHourlyPricePerCore(String o) {
    this.openshiftControlPlaneHourlyPricePerCore = Contract.staticSetOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, o);
  }
  public static Integer staticScaleOpenshiftControlPlaneHourlyPricePerCore() {
    return 6;
  }
  public static MathContext staticMathContextOpenshiftControlPlaneHourlyPricePerCore() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOpenshiftControlPlaneHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOpenshiftControlPlaneHourlyPricePerCore()).setScale(staticScaleOpenshiftControlPlaneHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOpenshiftControlPlaneHourlyPricePerCore(Double o) {
    setOpenshiftControlPlaneHourlyPricePerCore(new BigDecimal(o, staticMathContextOpenshiftControlPlaneHourlyPricePerCore()).setScale(staticScaleOpenshiftControlPlaneHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftControlPlaneHourlyPricePerCore(Integer o) {
    setOpenshiftControlPlaneHourlyPricePerCore(new BigDecimal(o, staticMathContextOpenshiftControlPlaneHourlyPricePerCore()).setScale(staticScaleOpenshiftControlPlaneHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftControlPlaneHourlyPricePerCore(Number o) {
    setOpenshiftControlPlaneHourlyPricePerCore(new BigDecimal(o.doubleValue(), staticMathContextOpenshiftControlPlaneHourlyPricePerCore()).setScale(staticScaleOpenshiftControlPlaneHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract openshiftControlPlaneHourlyPricePerCoreInit() {
    Wrap<BigDecimal> openshiftControlPlaneHourlyPricePerCoreWrap = new Wrap<BigDecimal>().var("openshiftControlPlaneHourlyPricePerCore");
    if(openshiftControlPlaneHourlyPricePerCore == null) {
      _openshiftControlPlaneHourlyPricePerCore(openshiftControlPlaneHourlyPricePerCoreWrap);
      Optional.ofNullable(openshiftControlPlaneHourlyPricePerCoreWrap.getO()).ifPresent(o -> {
        setOpenshiftControlPlaneHourlyPricePerCore(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOpenshiftControlPlaneHourlyPricePerCore(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOpenshiftControlPlaneHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftControlPlaneHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, Contract.staticSetOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, o)).toString();
  }

  public BigDecimal sqlOpenshiftControlPlaneHourlyPricePerCore() {
    return openshiftControlPlaneHourlyPricePerCore;
  }

  public static String staticJsonOpenshiftControlPlaneHourlyPricePerCore(BigDecimal openshiftControlPlaneHourlyPricePerCore) {
    return Optional.ofNullable(openshiftControlPlaneHourlyPricePerCore).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////
  // openshiftInfraNodes //
	/////////////////////////


  /**
   *  The entity openshiftInfraNodes
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer openshiftInfraNodes;

  /**
   * <br> The entity openshiftInfraNodes
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftInfraNodes">Find the entity openshiftInfraNodes in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftInfraNodes(Wrap<Integer> w);

  public Integer getOpenshiftInfraNodes() {
    return openshiftInfraNodes;
  }

  public void setOpenshiftInfraNodes(Integer openshiftInfraNodes) {
    this.openshiftInfraNodes = openshiftInfraNodes;
  }
  @JsonIgnore
  public void setOpenshiftInfraNodes(String o) {
    this.openshiftInfraNodes = Contract.staticSetOpenshiftInfraNodes(siteRequest_, o);
  }
  public static Integer staticSetOpenshiftInfraNodes(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract openshiftInfraNodesInit() {
    Wrap<Integer> openshiftInfraNodesWrap = new Wrap<Integer>().var("openshiftInfraNodes");
    if(openshiftInfraNodes == null) {
      _openshiftInfraNodes(openshiftInfraNodesWrap);
      Optional.ofNullable(openshiftInfraNodesWrap.getO()).ifPresent(o -> {
        setOpenshiftInfraNodes(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchOpenshiftInfraNodes(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrOpenshiftInfraNodes(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftInfraNodes(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftInfraNodes(siteRequest_, Contract.staticSetOpenshiftInfraNodes(siteRequest_, o)).toString();
  }

  public Integer sqlOpenshiftInfraNodes() {
    return openshiftInfraNodes;
  }

  public static String staticJsonOpenshiftInfraNodes(Integer openshiftInfraNodes) {
    return Optional.ofNullable(openshiftInfraNodes).map(v -> v.toString()).orElse(null);
  }

	/////////////////////////
  // openshiftInfraCores //
	/////////////////////////


  /**
   *  The entity openshiftInfraCores
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer openshiftInfraCores;

  /**
   * <br> The entity openshiftInfraCores
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftInfraCores">Find the entity openshiftInfraCores in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftInfraCores(Wrap<Integer> w);

  public Integer getOpenshiftInfraCores() {
    return openshiftInfraCores;
  }

  public void setOpenshiftInfraCores(Integer openshiftInfraCores) {
    this.openshiftInfraCores = openshiftInfraCores;
  }
  @JsonIgnore
  public void setOpenshiftInfraCores(String o) {
    this.openshiftInfraCores = Contract.staticSetOpenshiftInfraCores(siteRequest_, o);
  }
  public static Integer staticSetOpenshiftInfraCores(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract openshiftInfraCoresInit() {
    Wrap<Integer> openshiftInfraCoresWrap = new Wrap<Integer>().var("openshiftInfraCores");
    if(openshiftInfraCores == null) {
      _openshiftInfraCores(openshiftInfraCoresWrap);
      Optional.ofNullable(openshiftInfraCoresWrap.getO()).ifPresent(o -> {
        setOpenshiftInfraCores(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchOpenshiftInfraCores(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrOpenshiftInfraCores(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftInfraCores(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftInfraCores(siteRequest_, Contract.staticSetOpenshiftInfraCores(siteRequest_, o)).toString();
  }

  public Integer sqlOpenshiftInfraCores() {
    return openshiftInfraCores;
  }

  public static String staticJsonOpenshiftInfraCores(Integer openshiftInfraCores) {
    return Optional.ofNullable(openshiftInfraCores).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////
  // totalOpenshiftInfraCores //
	//////////////////////////////


  /**
   *  The entity totalOpenshiftInfraCores
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer totalOpenshiftInfraCores;

  /**
   * <br> The entity totalOpenshiftInfraCores
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:totalOpenshiftInfraCores">Find the entity totalOpenshiftInfraCores in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _totalOpenshiftInfraCores(Wrap<Integer> w);

  public Integer getTotalOpenshiftInfraCores() {
    return totalOpenshiftInfraCores;
  }

  public void setTotalOpenshiftInfraCores(Integer totalOpenshiftInfraCores) {
    this.totalOpenshiftInfraCores = totalOpenshiftInfraCores;
  }
  @JsonIgnore
  public void setTotalOpenshiftInfraCores(String o) {
    this.totalOpenshiftInfraCores = Contract.staticSetTotalOpenshiftInfraCores(siteRequest_, o);
  }
  public static Integer staticSetTotalOpenshiftInfraCores(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract totalOpenshiftInfraCoresInit() {
    Wrap<Integer> totalOpenshiftInfraCoresWrap = new Wrap<Integer>().var("totalOpenshiftInfraCores");
    if(totalOpenshiftInfraCores == null) {
      _totalOpenshiftInfraCores(totalOpenshiftInfraCoresWrap);
      Optional.ofNullable(totalOpenshiftInfraCoresWrap.getO()).ifPresent(o -> {
        setTotalOpenshiftInfraCores(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchTotalOpenshiftInfraCores(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrTotalOpenshiftInfraCores(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTotalOpenshiftInfraCores(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchTotalOpenshiftInfraCores(siteRequest_, Contract.staticSetTotalOpenshiftInfraCores(siteRequest_, o)).toString();
  }

  public Integer sqlTotalOpenshiftInfraCores() {
    return totalOpenshiftInfraCores;
  }

  public static String staticJsonTotalOpenshiftInfraCores(Integer totalOpenshiftInfraCores) {
    return Optional.ofNullable(totalOpenshiftInfraCores).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////////////
  // openshiftInfraHourlyPricePerCore //
	//////////////////////////////////////


  /**
   *  The entity openshiftInfraHourlyPricePerCore
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal openshiftInfraHourlyPricePerCore;

  /**
   * <br> The entity openshiftInfraHourlyPricePerCore
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftInfraHourlyPricePerCore">Find the entity openshiftInfraHourlyPricePerCore in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftInfraHourlyPricePerCore(Wrap<BigDecimal> w);

  public BigDecimal getOpenshiftInfraHourlyPricePerCore() {
    return openshiftInfraHourlyPricePerCore;
  }

  public void setOpenshiftInfraHourlyPricePerCore(BigDecimal openshiftInfraHourlyPricePerCore) {
    this.openshiftInfraHourlyPricePerCore = openshiftInfraHourlyPricePerCore;
  }
  @JsonIgnore
  public void setOpenshiftInfraHourlyPricePerCore(String o) {
    this.openshiftInfraHourlyPricePerCore = Contract.staticSetOpenshiftInfraHourlyPricePerCore(siteRequest_, o);
  }
  public static Integer staticScaleOpenshiftInfraHourlyPricePerCore() {
    return 6;
  }
  public static MathContext staticMathContextOpenshiftInfraHourlyPricePerCore() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOpenshiftInfraHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOpenshiftInfraHourlyPricePerCore()).setScale(staticScaleOpenshiftInfraHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOpenshiftInfraHourlyPricePerCore(Double o) {
    setOpenshiftInfraHourlyPricePerCore(new BigDecimal(o, staticMathContextOpenshiftInfraHourlyPricePerCore()).setScale(staticScaleOpenshiftInfraHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftInfraHourlyPricePerCore(Integer o) {
    setOpenshiftInfraHourlyPricePerCore(new BigDecimal(o, staticMathContextOpenshiftInfraHourlyPricePerCore()).setScale(staticScaleOpenshiftInfraHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftInfraHourlyPricePerCore(Number o) {
    setOpenshiftInfraHourlyPricePerCore(new BigDecimal(o.doubleValue(), staticMathContextOpenshiftInfraHourlyPricePerCore()).setScale(staticScaleOpenshiftInfraHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract openshiftInfraHourlyPricePerCoreInit() {
    Wrap<BigDecimal> openshiftInfraHourlyPricePerCoreWrap = new Wrap<BigDecimal>().var("openshiftInfraHourlyPricePerCore");
    if(openshiftInfraHourlyPricePerCore == null) {
      _openshiftInfraHourlyPricePerCore(openshiftInfraHourlyPricePerCoreWrap);
      Optional.ofNullable(openshiftInfraHourlyPricePerCoreWrap.getO()).ifPresent(o -> {
        setOpenshiftInfraHourlyPricePerCore(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOpenshiftInfraHourlyPricePerCore(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOpenshiftInfraHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftInfraHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftInfraHourlyPricePerCore(siteRequest_, Contract.staticSetOpenshiftInfraHourlyPricePerCore(siteRequest_, o)).toString();
  }

  public BigDecimal sqlOpenshiftInfraHourlyPricePerCore() {
    return openshiftInfraHourlyPricePerCore;
  }

  public static String staticJsonOpenshiftInfraHourlyPricePerCore(BigDecimal openshiftInfraHourlyPricePerCore) {
    return Optional.ofNullable(openshiftInfraHourlyPricePerCore).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////
  // openshiftWorkerNodes //
	//////////////////////////


  /**
   *  The entity openshiftWorkerNodes
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer openshiftWorkerNodes;

  /**
   * <br> The entity openshiftWorkerNodes
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftWorkerNodes">Find the entity openshiftWorkerNodes in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftWorkerNodes(Wrap<Integer> w);

  public Integer getOpenshiftWorkerNodes() {
    return openshiftWorkerNodes;
  }

  public void setOpenshiftWorkerNodes(Integer openshiftWorkerNodes) {
    this.openshiftWorkerNodes = openshiftWorkerNodes;
  }
  @JsonIgnore
  public void setOpenshiftWorkerNodes(String o) {
    this.openshiftWorkerNodes = Contract.staticSetOpenshiftWorkerNodes(siteRequest_, o);
  }
  public static Integer staticSetOpenshiftWorkerNodes(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract openshiftWorkerNodesInit() {
    Wrap<Integer> openshiftWorkerNodesWrap = new Wrap<Integer>().var("openshiftWorkerNodes");
    if(openshiftWorkerNodes == null) {
      _openshiftWorkerNodes(openshiftWorkerNodesWrap);
      Optional.ofNullable(openshiftWorkerNodesWrap.getO()).ifPresent(o -> {
        setOpenshiftWorkerNodes(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchOpenshiftWorkerNodes(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrOpenshiftWorkerNodes(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftWorkerNodes(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftWorkerNodes(siteRequest_, Contract.staticSetOpenshiftWorkerNodes(siteRequest_, o)).toString();
  }

  public Integer sqlOpenshiftWorkerNodes() {
    return openshiftWorkerNodes;
  }

  public static String staticJsonOpenshiftWorkerNodes(Integer openshiftWorkerNodes) {
    return Optional.ofNullable(openshiftWorkerNodes).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////
  // openshiftWorkerCores //
	//////////////////////////


  /**
   *  The entity openshiftWorkerCores
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer openshiftWorkerCores;

  /**
   * <br> The entity openshiftWorkerCores
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftWorkerCores">Find the entity openshiftWorkerCores in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftWorkerCores(Wrap<Integer> w);

  public Integer getOpenshiftWorkerCores() {
    return openshiftWorkerCores;
  }

  public void setOpenshiftWorkerCores(Integer openshiftWorkerCores) {
    this.openshiftWorkerCores = openshiftWorkerCores;
  }
  @JsonIgnore
  public void setOpenshiftWorkerCores(String o) {
    this.openshiftWorkerCores = Contract.staticSetOpenshiftWorkerCores(siteRequest_, o);
  }
  public static Integer staticSetOpenshiftWorkerCores(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract openshiftWorkerCoresInit() {
    Wrap<Integer> openshiftWorkerCoresWrap = new Wrap<Integer>().var("openshiftWorkerCores");
    if(openshiftWorkerCores == null) {
      _openshiftWorkerCores(openshiftWorkerCoresWrap);
      Optional.ofNullable(openshiftWorkerCoresWrap.getO()).ifPresent(o -> {
        setOpenshiftWorkerCores(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchOpenshiftWorkerCores(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrOpenshiftWorkerCores(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftWorkerCores(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftWorkerCores(siteRequest_, Contract.staticSetOpenshiftWorkerCores(siteRequest_, o)).toString();
  }

  public Integer sqlOpenshiftWorkerCores() {
    return openshiftWorkerCores;
  }

  public static String staticJsonOpenshiftWorkerCores(Integer openshiftWorkerCores) {
    return Optional.ofNullable(openshiftWorkerCores).map(v -> v.toString()).orElse(null);
  }

	///////////////////////////////
  // totalOpenshiftWorkerCores //
	///////////////////////////////


  /**
   *  The entity totalOpenshiftWorkerCores
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer totalOpenshiftWorkerCores;

  /**
   * <br> The entity totalOpenshiftWorkerCores
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:totalOpenshiftWorkerCores">Find the entity totalOpenshiftWorkerCores in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _totalOpenshiftWorkerCores(Wrap<Integer> w);

  public Integer getTotalOpenshiftWorkerCores() {
    return totalOpenshiftWorkerCores;
  }

  public void setTotalOpenshiftWorkerCores(Integer totalOpenshiftWorkerCores) {
    this.totalOpenshiftWorkerCores = totalOpenshiftWorkerCores;
  }
  @JsonIgnore
  public void setTotalOpenshiftWorkerCores(String o) {
    this.totalOpenshiftWorkerCores = Contract.staticSetTotalOpenshiftWorkerCores(siteRequest_, o);
  }
  public static Integer staticSetTotalOpenshiftWorkerCores(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected Contract totalOpenshiftWorkerCoresInit() {
    Wrap<Integer> totalOpenshiftWorkerCoresWrap = new Wrap<Integer>().var("totalOpenshiftWorkerCores");
    if(totalOpenshiftWorkerCores == null) {
      _totalOpenshiftWorkerCores(totalOpenshiftWorkerCoresWrap);
      Optional.ofNullable(totalOpenshiftWorkerCoresWrap.getO()).ifPresent(o -> {
        setTotalOpenshiftWorkerCores(o);
      });
    }
    return (Contract)this;
  }

  public static Integer staticSearchTotalOpenshiftWorkerCores(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrTotalOpenshiftWorkerCores(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTotalOpenshiftWorkerCores(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchTotalOpenshiftWorkerCores(siteRequest_, Contract.staticSetTotalOpenshiftWorkerCores(siteRequest_, o)).toString();
  }

  public Integer sqlTotalOpenshiftWorkerCores() {
    return totalOpenshiftWorkerCores;
  }

  public static String staticJsonTotalOpenshiftWorkerCores(Integer totalOpenshiftWorkerCores) {
    return Optional.ofNullable(totalOpenshiftWorkerCores).map(v -> v.toString()).orElse(null);
  }

	///////////////////////////////////////
  // openshiftWorkerHourlyPricePerCore //
	///////////////////////////////////////


  /**
   *  The entity openshiftWorkerHourlyPricePerCore
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal openshiftWorkerHourlyPricePerCore;

  /**
   * <br> The entity openshiftWorkerHourlyPricePerCore
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftWorkerHourlyPricePerCore">Find the entity openshiftWorkerHourlyPricePerCore in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftWorkerHourlyPricePerCore(Wrap<BigDecimal> w);

  public BigDecimal getOpenshiftWorkerHourlyPricePerCore() {
    return openshiftWorkerHourlyPricePerCore;
  }

  public void setOpenshiftWorkerHourlyPricePerCore(BigDecimal openshiftWorkerHourlyPricePerCore) {
    this.openshiftWorkerHourlyPricePerCore = openshiftWorkerHourlyPricePerCore;
  }
  @JsonIgnore
  public void setOpenshiftWorkerHourlyPricePerCore(String o) {
    this.openshiftWorkerHourlyPricePerCore = Contract.staticSetOpenshiftWorkerHourlyPricePerCore(siteRequest_, o);
  }
  public static Integer staticScaleOpenshiftWorkerHourlyPricePerCore() {
    return 6;
  }
  public static MathContext staticMathContextOpenshiftWorkerHourlyPricePerCore() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOpenshiftWorkerHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOpenshiftWorkerHourlyPricePerCore()).setScale(staticScaleOpenshiftWorkerHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOpenshiftWorkerHourlyPricePerCore(Double o) {
    setOpenshiftWorkerHourlyPricePerCore(new BigDecimal(o, staticMathContextOpenshiftWorkerHourlyPricePerCore()).setScale(staticScaleOpenshiftWorkerHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftWorkerHourlyPricePerCore(Integer o) {
    setOpenshiftWorkerHourlyPricePerCore(new BigDecimal(o, staticMathContextOpenshiftWorkerHourlyPricePerCore()).setScale(staticScaleOpenshiftWorkerHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftWorkerHourlyPricePerCore(Number o) {
    setOpenshiftWorkerHourlyPricePerCore(new BigDecimal(o.doubleValue(), staticMathContextOpenshiftWorkerHourlyPricePerCore()).setScale(staticScaleOpenshiftWorkerHourlyPricePerCore(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract openshiftWorkerHourlyPricePerCoreInit() {
    Wrap<BigDecimal> openshiftWorkerHourlyPricePerCoreWrap = new Wrap<BigDecimal>().var("openshiftWorkerHourlyPricePerCore");
    if(openshiftWorkerHourlyPricePerCore == null) {
      _openshiftWorkerHourlyPricePerCore(openshiftWorkerHourlyPricePerCoreWrap);
      Optional.ofNullable(openshiftWorkerHourlyPricePerCoreWrap.getO()).ifPresent(o -> {
        setOpenshiftWorkerHourlyPricePerCore(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOpenshiftWorkerHourlyPricePerCore(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOpenshiftWorkerHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftWorkerHourlyPricePerCore(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftWorkerHourlyPricePerCore(siteRequest_, Contract.staticSetOpenshiftWorkerHourlyPricePerCore(siteRequest_, o)).toString();
  }

  public BigDecimal sqlOpenshiftWorkerHourlyPricePerCore() {
    return openshiftWorkerHourlyPricePerCore;
  }

  public static String staticJsonOpenshiftWorkerHourlyPricePerCore(BigDecimal openshiftWorkerHourlyPricePerCore) {
    return Optional.ofNullable(openshiftWorkerHourlyPricePerCore).map(v -> v.toString()).orElse(null);
  }

	///////////////////////////////////
  // openshiftSSDStorageTiBPerYear //
	///////////////////////////////////


  /**
   *  The entity openshiftSSDStorageTiBPerYear
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(contentUsing = ComputateBigDecimalDeserializer.class)
  @JsonSerialize(contentUsing = ToStringSerializer.class)
  @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "HALF_UP,0,2")
  @JsonInclude(Include.NON_NULL)
  protected List<BigDecimal> openshiftSSDStorageTiBPerYear = new ArrayList<BigDecimal>();

  /**
   * <br> The entity openshiftSSDStorageTiBPerYear
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftSSDStorageTiBPerYear">Find the entity openshiftSSDStorageTiBPerYear in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _openshiftSSDStorageTiBPerYear(List<BigDecimal> l);

  public List<BigDecimal> getOpenshiftSSDStorageTiBPerYear() {
    return openshiftSSDStorageTiBPerYear;
  }

  public void setOpenshiftSSDStorageTiBPerYear(List<BigDecimal> openshiftSSDStorageTiBPerYear) {
    this.openshiftSSDStorageTiBPerYear = openshiftSSDStorageTiBPerYear;
  }
  @JsonIgnore
  public void setOpenshiftSSDStorageTiBPerYear(String o) {
    BigDecimal l = Contract.staticSetOpenshiftSSDStorageTiBPerYear(siteRequest_, o);
    if(l != null)
      addOpenshiftSSDStorageTiBPerYear(l);
  }
  public static Integer staticScaleOpenshiftSSDStorageTiBPerYear() {
    return 2;
  }
  public static MathContext staticMathContextOpenshiftSSDStorageTiBPerYear() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOpenshiftSSDStorageTiBPerYear(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOpenshiftSSDStorageTiBPerYear()).setScale(staticScaleOpenshiftSSDStorageTiBPerYear(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOpenshiftSSDStorageTiBPerYear(Double o) {
    addOpenshiftSSDStorageTiBPerYear(new BigDecimal(o, staticMathContextOpenshiftSSDStorageTiBPerYear()).setScale(staticScaleOpenshiftSSDStorageTiBPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftSSDStorageTiBPerYear(Integer o) {
    addOpenshiftSSDStorageTiBPerYear(new BigDecimal(o, staticMathContextOpenshiftSSDStorageTiBPerYear()).setScale(staticScaleOpenshiftSSDStorageTiBPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftSSDStorageTiBPerYear(Number o) {
    addOpenshiftSSDStorageTiBPerYear(new BigDecimal(o.doubleValue(), staticMathContextOpenshiftSSDStorageTiBPerYear()).setScale(staticScaleOpenshiftSSDStorageTiBPerYear(), RoundingMode.valueOf("HALF_UP")));
  }
  public Contract addOpenshiftSSDStorageTiBPerYear(BigDecimal...objects) {
    for(BigDecimal o : objects) {
      addOpenshiftSSDStorageTiBPerYear(o);
    }
    return (Contract)this;
  }
  public Contract addOpenshiftSSDStorageTiBPerYear(BigDecimal o) {
    if(o != null)
      this.openshiftSSDStorageTiBPerYear.add(o);
    return (Contract)this;
  }
  @JsonIgnore
  public void setOpenshiftSSDStorageTiBPerYear(JsonArray objects) {
    openshiftSSDStorageTiBPerYear.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addOpenshiftSSDStorageTiBPerYear(new BigDecimal(o, staticMathContextOpenshiftSSDStorageTiBPerYear()).setScale(staticScaleOpenshiftSSDStorageTiBPerYear(), RoundingMode.valueOf("HALF_UP")));
    }
  }
  public Contract addOpenshiftSSDStorageTiBPerYear(String o) {
    if(NumberUtils.isParsable(o)) {
      BigDecimal p = new BigDecimal(o, staticMathContextOpenshiftSSDStorageTiBPerYear()).setScale(staticScaleOpenshiftSSDStorageTiBPerYear(), RoundingMode.valueOf("HALF_UP"));
      addOpenshiftSSDStorageTiBPerYear(p);
    }
    return (Contract)this;
  }
  protected Contract openshiftSSDStorageTiBPerYearInit() {
    _openshiftSSDStorageTiBPerYear(openshiftSSDStorageTiBPerYear);
    return (Contract)this;
  }

  public static String staticSearchOpenshiftSSDStorageTiBPerYear(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOpenshiftSSDStorageTiBPerYear(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftSSDStorageTiBPerYear(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftSSDStorageTiBPerYear(siteRequest_, Contract.staticSetOpenshiftSSDStorageTiBPerYear(siteRequest_, o)).toString();
  }

  public Number[] sqlOpenshiftSSDStorageTiBPerYear() {
    return openshiftSSDStorageTiBPerYear.stream().map(v -> (Number)v).toArray(Number[]::new);
  }

  public static JsonArray staticJsonOpenshiftSSDStorageTiBPerYear(List<BigDecimal> openshiftSSDStorageTiBPerYear) {
    JsonArray a = new JsonArray();
    openshiftSSDStorageTiBPerYear.stream().forEach(v -> a.add(v.toString()));
    return a;
  }

	////////////////////////////////////
  // openshiftSSDStoragePricePerGiB //
	////////////////////////////////////


  /**
   *  The entity openshiftSSDStoragePricePerGiB
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal openshiftSSDStoragePricePerGiB;

  /**
   * <br> The entity openshiftSSDStoragePricePerGiB
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftSSDStoragePricePerGiB">Find the entity openshiftSSDStoragePricePerGiB in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftSSDStoragePricePerGiB(Wrap<BigDecimal> w);

  public BigDecimal getOpenshiftSSDStoragePricePerGiB() {
    return openshiftSSDStoragePricePerGiB;
  }

  public void setOpenshiftSSDStoragePricePerGiB(BigDecimal openshiftSSDStoragePricePerGiB) {
    this.openshiftSSDStoragePricePerGiB = openshiftSSDStoragePricePerGiB;
  }
  @JsonIgnore
  public void setOpenshiftSSDStoragePricePerGiB(String o) {
    this.openshiftSSDStoragePricePerGiB = Contract.staticSetOpenshiftSSDStoragePricePerGiB(siteRequest_, o);
  }
  public static Integer staticScaleOpenshiftSSDStoragePricePerGiB() {
    return 6;
  }
  public static MathContext staticMathContextOpenshiftSSDStoragePricePerGiB() {
    return new MathContext(0, RoundingMode.valueOf("HALF_UP"));
  }
  public static BigDecimal staticSetOpenshiftSSDStoragePricePerGiB(SiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.-]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, staticMathContextOpenshiftSSDStoragePricePerGiB()).setScale(staticScaleOpenshiftSSDStoragePricePerGiB(), RoundingMode.valueOf("HALF_UP"));
    return null;
  }
  @JsonIgnore
  public void setOpenshiftSSDStoragePricePerGiB(Double o) {
    setOpenshiftSSDStoragePricePerGiB(new BigDecimal(o, staticMathContextOpenshiftSSDStoragePricePerGiB()).setScale(staticScaleOpenshiftSSDStoragePricePerGiB(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftSSDStoragePricePerGiB(Integer o) {
    setOpenshiftSSDStoragePricePerGiB(new BigDecimal(o, staticMathContextOpenshiftSSDStoragePricePerGiB()).setScale(staticScaleOpenshiftSSDStoragePricePerGiB(), RoundingMode.valueOf("HALF_UP")));
  }
  @JsonIgnore
  public void setOpenshiftSSDStoragePricePerGiB(Number o) {
    setOpenshiftSSDStoragePricePerGiB(new BigDecimal(o.doubleValue(), staticMathContextOpenshiftSSDStoragePricePerGiB()).setScale(staticScaleOpenshiftSSDStoragePricePerGiB(), RoundingMode.valueOf("HALF_UP")));
  }
  protected Contract openshiftSSDStoragePricePerGiBInit() {
    Wrap<BigDecimal> openshiftSSDStoragePricePerGiBWrap = new Wrap<BigDecimal>().var("openshiftSSDStoragePricePerGiB");
    if(openshiftSSDStoragePricePerGiB == null) {
      _openshiftSSDStoragePricePerGiB(openshiftSSDStoragePricePerGiBWrap);
      Optional.ofNullable(openshiftSSDStoragePricePerGiBWrap.getO()).ifPresent(o -> {
        setOpenshiftSSDStoragePricePerGiB(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOpenshiftSSDStoragePricePerGiB(SiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchStrOpenshiftSSDStoragePricePerGiB(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftSSDStoragePricePerGiB(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftSSDStoragePricePerGiB(siteRequest_, Contract.staticSetOpenshiftSSDStoragePricePerGiB(siteRequest_, o)).toString();
  }

  public BigDecimal sqlOpenshiftSSDStoragePricePerGiB() {
    return openshiftSSDStoragePricePerGiB;
  }

  public static String staticJsonOpenshiftSSDStoragePricePerGiB(BigDecimal openshiftSSDStoragePricePerGiB) {
    return Optional.ofNullable(openshiftSSDStoragePricePerGiB).map(v -> v.toString()).orElse(null);
  }

	//////////////////////////////////
  // openshiftCostsPerYearDataset //
	//////////////////////////////////


  /**
   *  The entity openshiftCostsPerYearDataset
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray openshiftCostsPerYearDataset;

  /**
   * <br> The entity openshiftCostsPerYearDataset
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftCostsPerYearDataset">Find the entity openshiftCostsPerYearDataset in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftCostsPerYearDataset(Wrap<JsonArray> w);

  public JsonArray getOpenshiftCostsPerYearDataset() {
    return openshiftCostsPerYearDataset;
  }

  public void setOpenshiftCostsPerYearDataset(JsonArray openshiftCostsPerYearDataset) {
    this.openshiftCostsPerYearDataset = openshiftCostsPerYearDataset;
  }
  @JsonIgnore
  public void setOpenshiftCostsPerYearDataset(String o) {
    this.openshiftCostsPerYearDataset = Contract.staticSetOpenshiftCostsPerYearDataset(siteRequest_, o);
  }
  public static JsonArray staticSetOpenshiftCostsPerYearDataset(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected Contract openshiftCostsPerYearDatasetInit() {
    Wrap<JsonArray> openshiftCostsPerYearDatasetWrap = new Wrap<JsonArray>().var("openshiftCostsPerYearDataset");
    if(openshiftCostsPerYearDataset == null) {
      _openshiftCostsPerYearDataset(openshiftCostsPerYearDatasetWrap);
      Optional.ofNullable(openshiftCostsPerYearDatasetWrap.getO()).ifPresent(o -> {
        setOpenshiftCostsPerYearDataset(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOpenshiftCostsPerYearDataset(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrOpenshiftCostsPerYearDataset(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftCostsPerYearDataset(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftCostsPerYearDataset(siteRequest_, Contract.staticSetOpenshiftCostsPerYearDataset(siteRequest_, o)).toString();
  }

  public JsonArray sqlOpenshiftCostsPerYearDataset() {
    return openshiftCostsPerYearDataset;
  }

  public static JsonArray staticJsonOpenshiftCostsPerYearDataset(JsonArray openshiftCostsPerYearDataset) {
    return openshiftCostsPerYearDataset;
  }

	////////////////////////////////
  // openshiftCostsPerYearChart //
	////////////////////////////////


  /**
   *  The entity openshiftCostsPerYearChart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject openshiftCostsPerYearChart;

  /**
   * <br> The entity openshiftCostsPerYearChart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:openshiftCostsPerYearChart">Find the entity openshiftCostsPerYearChart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _openshiftCostsPerYearChart(Wrap<JsonObject> w);

  public JsonObject getOpenshiftCostsPerYearChart() {
    return openshiftCostsPerYearChart;
  }

  public void setOpenshiftCostsPerYearChart(JsonObject openshiftCostsPerYearChart) {
    this.openshiftCostsPerYearChart = openshiftCostsPerYearChart;
  }
  @JsonIgnore
  public void setOpenshiftCostsPerYearChart(String o) {
    this.openshiftCostsPerYearChart = Contract.staticSetOpenshiftCostsPerYearChart(siteRequest_, o);
  }
  public static JsonObject staticSetOpenshiftCostsPerYearChart(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Contract openshiftCostsPerYearChartInit() {
    Wrap<JsonObject> openshiftCostsPerYearChartWrap = new Wrap<JsonObject>().var("openshiftCostsPerYearChart");
    if(openshiftCostsPerYearChart == null) {
      _openshiftCostsPerYearChart(openshiftCostsPerYearChartWrap);
      Optional.ofNullable(openshiftCostsPerYearChartWrap.getO()).ifPresent(o -> {
        setOpenshiftCostsPerYearChart(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchOpenshiftCostsPerYearChart(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrOpenshiftCostsPerYearChart(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqOpenshiftCostsPerYearChart(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchOpenshiftCostsPerYearChart(siteRequest_, Contract.staticSetOpenshiftCostsPerYearChart(siteRequest_, o)).toString();
  }

	//////////////////////////
  // projectExpensesChart //
	//////////////////////////


  /**
   *  The entity projectExpensesChart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject projectExpensesChart;

  /**
   * <br> The entity projectExpensesChart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:projectExpensesChart">Find the entity projectExpensesChart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _projectExpensesChart(Wrap<JsonObject> w);

  public JsonObject getProjectExpensesChart() {
    return projectExpensesChart;
  }

  public void setProjectExpensesChart(JsonObject projectExpensesChart) {
    this.projectExpensesChart = projectExpensesChart;
  }
  @JsonIgnore
  public void setProjectExpensesChart(String o) {
    this.projectExpensesChart = Contract.staticSetProjectExpensesChart(siteRequest_, o);
  }
  public static JsonObject staticSetProjectExpensesChart(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Contract projectExpensesChartInit() {
    Wrap<JsonObject> projectExpensesChartWrap = new Wrap<JsonObject>().var("projectExpensesChart");
    if(projectExpensesChart == null) {
      _projectExpensesChart(projectExpensesChartWrap);
      Optional.ofNullable(projectExpensesChartWrap.getO()).ifPresent(o -> {
        setProjectExpensesChart(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchProjectExpensesChart(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrProjectExpensesChart(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqProjectExpensesChart(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchProjectExpensesChart(siteRequest_, Contract.staticSetProjectExpensesChart(siteRequest_, o)).toString();
  }

	/////////////////////////
  // economicOutputChart //
	/////////////////////////


  /**
   *  The entity economicOutputChart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject economicOutputChart;

  /**
   * <br> The entity economicOutputChart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.Contract&fq=entiteVar_enUS_indexed_string:economicOutputChart">Find the entity economicOutputChart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _economicOutputChart(Wrap<JsonObject> w);

  public JsonObject getEconomicOutputChart() {
    return economicOutputChart;
  }

  public void setEconomicOutputChart(JsonObject economicOutputChart) {
    this.economicOutputChart = economicOutputChart;
  }
  @JsonIgnore
  public void setEconomicOutputChart(String o) {
    this.economicOutputChart = Contract.staticSetEconomicOutputChart(siteRequest_, o);
  }
  public static JsonObject staticSetEconomicOutputChart(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected Contract economicOutputChartInit() {
    Wrap<JsonObject> economicOutputChartWrap = new Wrap<JsonObject>().var("economicOutputChart");
    if(economicOutputChart == null) {
      _economicOutputChart(economicOutputChartWrap);
      Optional.ofNullable(economicOutputChartWrap.getO()).ifPresent(o -> {
        setEconomicOutputChart(o);
      });
    }
    return (Contract)this;
  }

  public static String staticSearchEconomicOutputChart(SiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrEconomicOutputChart(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEconomicOutputChart(SiteRequest siteRequest_, String o) {
    return Contract.staticSearchEconomicOutputChart(siteRequest_, Contract.staticSetEconomicOutputChart(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<ContractGen<DEV>> promiseDeepContract(SiteRequest siteRequest_) {
    if(this.siteRequest_ == null)
      setSiteRequest_(siteRequest_);
    return promiseDeepContract();
  }

  public Future<ContractGen<DEV>> promiseDeepContract() {
    Promise<ContractGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseContract(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseContract(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        regionInit();
        nameInit();
        abbreviationInit();
        displayNameInit();
        contractIdInit();
        startDateInit();
        investmentYearsTotalInit();
        investmentYearsInit();
        investmentsPerYearInit();
        investmentsPerYearCumulativeInit();
        assetClassesInit();
        assetClassesTargetIrrInit();
        revenueStreamsInit();
        economicOutputProjectionsInit();
        totalGdpImpactInit();
        economicOutputProjectionsDatasetInit();
        cumulativeInvestmentChartInit();
        architectsPerYearInit();
        remoteDevelopersPerYearInit();
        onsiteDevelopersPerYearInit();
        instructorsPerYearInit();
        remoteDeveloperPayPerYearInit();
        onsiteDeveloperPayPerYearInit();
        architectPayPerYearInit();
        instructorPayPerYearInit();
        subscriptionsPerYearInit();
        subscriptionCostsPerYearInit();
        totalSubscriptionCostPerYearInit();
        employeeSubscriptionCostsPerYearInit();
        employeesPerYearDatasetInit();
        subscriptionCostsPerYearDatasetInit();
        employeesPerYearChartInit();
        openshiftControlPlaneNodesInit();
        openshiftControlPlaneCoresInit();
        totalOpenshiftControlPlaneCoresInit();
        openshiftControlPlaneHourlyPricePerCoreInit();
        openshiftInfraNodesInit();
        openshiftInfraCoresInit();
        totalOpenshiftInfraCoresInit();
        openshiftInfraHourlyPricePerCoreInit();
        openshiftWorkerNodesInit();
        openshiftWorkerCoresInit();
        totalOpenshiftWorkerCoresInit();
        openshiftWorkerHourlyPricePerCoreInit();
        openshiftSSDStorageTiBPerYearInit();
        openshiftSSDStoragePricePerGiBInit();
        openshiftCostsPerYearDatasetInit();
        openshiftCostsPerYearChartInit();
        projectExpensesChartInit();
        economicOutputChartInit();
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

  @Override public Future<? extends ContractGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepContract(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestContract(SiteRequest siteRequest_) {
      super.siteRequestBaseModel(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestContract(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainContract(v);
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
  public Object obtainContract(String var) {
    Contract oContract = (Contract)this;
    switch(var) {
      case "region":
        return oContract.region;
      case "name":
        return oContract.name;
      case "abbreviation":
        return oContract.abbreviation;
      case "displayName":
        return oContract.displayName;
      case "contractId":
        return oContract.contractId;
      case "startDate":
        return oContract.startDate;
      case "investmentYearsTotal":
        return oContract.investmentYearsTotal;
      case "investmentYears":
        return oContract.investmentYears;
      case "investmentsPerYear":
        return oContract.investmentsPerYear;
      case "investmentsPerYearCumulative":
        return oContract.investmentsPerYearCumulative;
      case "assetClasses":
        return oContract.assetClasses;
      case "assetClassesTargetIrr":
        return oContract.assetClassesTargetIrr;
      case "revenueStreams":
        return oContract.revenueStreams;
      case "economicOutputProjections":
        return oContract.economicOutputProjections;
      case "totalGdpImpact":
        return oContract.totalGdpImpact;
      case "economicOutputProjectionsDataset":
        return oContract.economicOutputProjectionsDataset;
      case "cumulativeInvestmentChart":
        return oContract.cumulativeInvestmentChart;
      case "architectsPerYear":
        return oContract.architectsPerYear;
      case "remoteDevelopersPerYear":
        return oContract.remoteDevelopersPerYear;
      case "onsiteDevelopersPerYear":
        return oContract.onsiteDevelopersPerYear;
      case "instructorsPerYear":
        return oContract.instructorsPerYear;
      case "remoteDeveloperPayPerYear":
        return oContract.remoteDeveloperPayPerYear;
      case "onsiteDeveloperPayPerYear":
        return oContract.onsiteDeveloperPayPerYear;
      case "architectPayPerYear":
        return oContract.architectPayPerYear;
      case "instructorPayPerYear":
        return oContract.instructorPayPerYear;
      case "subscriptionsPerYear":
        return oContract.subscriptionsPerYear;
      case "subscriptionCostsPerYear":
        return oContract.subscriptionCostsPerYear;
      case "totalSubscriptionCostPerYear":
        return oContract.totalSubscriptionCostPerYear;
      case "employeeSubscriptionCostsPerYear":
        return oContract.employeeSubscriptionCostsPerYear;
      case "employeesPerYearDataset":
        return oContract.employeesPerYearDataset;
      case "subscriptionCostsPerYearDataset":
        return oContract.subscriptionCostsPerYearDataset;
      case "employeesPerYearChart":
        return oContract.employeesPerYearChart;
      case "openshiftControlPlaneNodes":
        return oContract.openshiftControlPlaneNodes;
      case "openshiftControlPlaneCores":
        return oContract.openshiftControlPlaneCores;
      case "totalOpenshiftControlPlaneCores":
        return oContract.totalOpenshiftControlPlaneCores;
      case "openshiftControlPlaneHourlyPricePerCore":
        return oContract.openshiftControlPlaneHourlyPricePerCore;
      case "openshiftInfraNodes":
        return oContract.openshiftInfraNodes;
      case "openshiftInfraCores":
        return oContract.openshiftInfraCores;
      case "totalOpenshiftInfraCores":
        return oContract.totalOpenshiftInfraCores;
      case "openshiftInfraHourlyPricePerCore":
        return oContract.openshiftInfraHourlyPricePerCore;
      case "openshiftWorkerNodes":
        return oContract.openshiftWorkerNodes;
      case "openshiftWorkerCores":
        return oContract.openshiftWorkerCores;
      case "totalOpenshiftWorkerCores":
        return oContract.totalOpenshiftWorkerCores;
      case "openshiftWorkerHourlyPricePerCore":
        return oContract.openshiftWorkerHourlyPricePerCore;
      case "openshiftSSDStorageTiBPerYear":
        return oContract.openshiftSSDStorageTiBPerYear;
      case "openshiftSSDStoragePricePerGiB":
        return oContract.openshiftSSDStoragePricePerGiB;
      case "openshiftCostsPerYearDataset":
        return oContract.openshiftCostsPerYearDataset;
      case "openshiftCostsPerYearChart":
        return oContract.openshiftCostsPerYearChart;
      case "projectExpensesChart":
        return oContract.projectExpensesChart;
      case "economicOutputChart":
        return oContract.economicOutputChart;
      default:
        return super.obtainBaseModel(var);
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
        o = relateContract(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateContract(String var, Object val) {
    Contract oContract = (Contract)this;
    switch(var) {
      default:
        return super.relateBaseModel(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, Contract o) {
    return staticSetContract(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetContract(String entityVar, SiteRequest siteRequest_, String v, Contract o) {
    switch(entityVar) {
    case "region":
      return Contract.staticSetRegion(siteRequest_, v);
    case "name":
      return Contract.staticSetName(siteRequest_, v);
    case "abbreviation":
      return Contract.staticSetAbbreviation(siteRequest_, v);
    case "displayName":
      return Contract.staticSetDisplayName(siteRequest_, v);
    case "contractId":
      return Contract.staticSetContractId(siteRequest_, v);
    case "startDate":
    case "investmentYearsTotal":
      return Contract.staticSetInvestmentYearsTotal(siteRequest_, v);
    case "investmentYears":
      return Contract.staticSetInvestmentYears(siteRequest_, v);
    case "investmentsPerYear":
      return Contract.staticSetInvestmentsPerYear(siteRequest_, v);
    case "investmentsPerYearCumulative":
      return Contract.staticSetInvestmentsPerYearCumulative(siteRequest_, v);
    case "assetClasses":
      return Contract.staticSetAssetClasses(siteRequest_, v);
    case "assetClassesTargetIrr":
      return Contract.staticSetAssetClassesTargetIrr(siteRequest_, v);
    case "revenueStreams":
      return Contract.staticSetRevenueStreams(siteRequest_, v);
    case "economicOutputProjections":
      return Contract.staticSetEconomicOutputProjections(siteRequest_, v);
    case "totalGdpImpact":
      return Contract.staticSetTotalGdpImpact(siteRequest_, v);
    case "economicOutputProjectionsDataset":
      return Contract.staticSetEconomicOutputProjectionsDataset(siteRequest_, v);
    case "cumulativeInvestmentChart":
      return Contract.staticSetCumulativeInvestmentChart(siteRequest_, v);
    case "architectsPerYear":
      return Contract.staticSetArchitectsPerYear(siteRequest_, v);
    case "remoteDevelopersPerYear":
      return Contract.staticSetRemoteDevelopersPerYear(siteRequest_, v);
    case "onsiteDevelopersPerYear":
      return Contract.staticSetOnsiteDevelopersPerYear(siteRequest_, v);
    case "instructorsPerYear":
      return Contract.staticSetInstructorsPerYear(siteRequest_, v);
    case "remoteDeveloperPayPerYear":
      return Contract.staticSetRemoteDeveloperPayPerYear(siteRequest_, v);
    case "onsiteDeveloperPayPerYear":
      return Contract.staticSetOnsiteDeveloperPayPerYear(siteRequest_, v);
    case "architectPayPerYear":
      return Contract.staticSetArchitectPayPerYear(siteRequest_, v);
    case "instructorPayPerYear":
      return Contract.staticSetInstructorPayPerYear(siteRequest_, v);
    case "subscriptionsPerYear":
      return Contract.staticSetSubscriptionsPerYear(siteRequest_, v);
    case "subscriptionCostsPerYear":
      return Contract.staticSetSubscriptionCostsPerYear(siteRequest_, v);
    case "totalSubscriptionCostPerYear":
      return Contract.staticSetTotalSubscriptionCostPerYear(siteRequest_, v);
    case "employeeSubscriptionCostsPerYear":
      return Contract.staticSetEmployeeSubscriptionCostsPerYear(siteRequest_, v);
    case "employeesPerYearDataset":
      return Contract.staticSetEmployeesPerYearDataset(siteRequest_, v);
    case "subscriptionCostsPerYearDataset":
      return Contract.staticSetSubscriptionCostsPerYearDataset(siteRequest_, v);
    case "employeesPerYearChart":
      return Contract.staticSetEmployeesPerYearChart(siteRequest_, v);
    case "openshiftControlPlaneNodes":
      return Contract.staticSetOpenshiftControlPlaneNodes(siteRequest_, v);
    case "openshiftControlPlaneCores":
      return Contract.staticSetOpenshiftControlPlaneCores(siteRequest_, v);
    case "totalOpenshiftControlPlaneCores":
      return Contract.staticSetTotalOpenshiftControlPlaneCores(siteRequest_, v);
    case "openshiftControlPlaneHourlyPricePerCore":
      return Contract.staticSetOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, v);
    case "openshiftInfraNodes":
      return Contract.staticSetOpenshiftInfraNodes(siteRequest_, v);
    case "openshiftInfraCores":
      return Contract.staticSetOpenshiftInfraCores(siteRequest_, v);
    case "totalOpenshiftInfraCores":
      return Contract.staticSetTotalOpenshiftInfraCores(siteRequest_, v);
    case "openshiftInfraHourlyPricePerCore":
      return Contract.staticSetOpenshiftInfraHourlyPricePerCore(siteRequest_, v);
    case "openshiftWorkerNodes":
      return Contract.staticSetOpenshiftWorkerNodes(siteRequest_, v);
    case "openshiftWorkerCores":
      return Contract.staticSetOpenshiftWorkerCores(siteRequest_, v);
    case "totalOpenshiftWorkerCores":
      return Contract.staticSetTotalOpenshiftWorkerCores(siteRequest_, v);
    case "openshiftWorkerHourlyPricePerCore":
      return Contract.staticSetOpenshiftWorkerHourlyPricePerCore(siteRequest_, v);
    case "openshiftSSDStorageTiBPerYear":
      return Contract.staticSetOpenshiftSSDStorageTiBPerYear(siteRequest_, v);
    case "openshiftSSDStoragePricePerGiB":
      return Contract.staticSetOpenshiftSSDStoragePricePerGiB(siteRequest_, v);
    case "openshiftCostsPerYearDataset":
      return Contract.staticSetOpenshiftCostsPerYearDataset(siteRequest_, v);
    case "openshiftCostsPerYearChart":
      return Contract.staticSetOpenshiftCostsPerYearChart(siteRequest_, v);
    case "projectExpensesChart":
      return Contract.staticSetProjectExpensesChart(siteRequest_, v);
    case "economicOutputChart":
      return Contract.staticSetEconomicOutputChart(siteRequest_, v);
      default:
        return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Future<Contract> fqContract(SiteRequest siteRequest, String var, Object val) {
    Promise<Contract> promise = Promise.promise();
    try {
      if(val == null) {
        promise.complete();
      } else {
        SearchList<Contract> searchList = new SearchList<Contract>();
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setC(Contract.class);
        searchList.fq(String.format("%s:", Contract.varIndexedContract(var)) + SearchTool.escapeQueryChars(val.toString()));
        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          try {
            promise.complete(searchList.getList().stream().findFirst().orElse(null));
          } catch(Throwable ex) {
            LOG.error("Error while querying the contract", ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error("Error while querying the contract", ex);
          promise.fail(ex);
        });
      }
    } catch(Throwable ex) {
      LOG.error("Error while querying the contract", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchContract(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchContract(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "region":
      return Contract.staticSearchRegion(siteRequest_, (String)o);
    case "name":
      return Contract.staticSearchName(siteRequest_, (String)o);
    case "abbreviation":
      return Contract.staticSearchAbbreviation(siteRequest_, (String)o);
    case "displayName":
      return Contract.staticSearchDisplayName(siteRequest_, (String)o);
    case "contractId":
      return Contract.staticSearchContractId(siteRequest_, (String)o);
    case "startDate":
      return Contract.staticSearchStartDate(siteRequest_, (ZonedDateTime)o);
    case "investmentYearsTotal":
      return Contract.staticSearchInvestmentYearsTotal(siteRequest_, (Integer)o);
    case "investmentYears":
      return Contract.staticSearchInvestmentYears(siteRequest_, (Integer)o);
    case "investmentsPerYear":
      return Contract.staticSearchInvestmentsPerYear(siteRequest_, (BigDecimal)o);
    case "investmentsPerYearCumulative":
      return Contract.staticSearchInvestmentsPerYearCumulative(siteRequest_, (BigDecimal)o);
    case "assetClasses":
      return Contract.staticSearchAssetClasses(siteRequest_, (String)o);
    case "assetClassesTargetIrr":
      return Contract.staticSearchAssetClassesTargetIrr(siteRequest_, (BigDecimal)o);
    case "revenueStreams":
      return Contract.staticSearchRevenueStreams(siteRequest_, (String)o);
    case "economicOutputProjections":
      return Contract.staticSearchEconomicOutputProjections(siteRequest_, (BigDecimal)o);
    case "totalGdpImpact":
      return Contract.staticSearchTotalGdpImpact(siteRequest_, (BigDecimal)o);
    case "economicOutputProjectionsDataset":
      return Contract.staticSearchEconomicOutputProjectionsDataset(siteRequest_, (JsonArray)o);
    case "cumulativeInvestmentChart":
      return Contract.staticSearchCumulativeInvestmentChart(siteRequest_, (JsonObject)o);
    case "architectsPerYear":
      return Contract.staticSearchArchitectsPerYear(siteRequest_, (BigDecimal)o);
    case "remoteDevelopersPerYear":
      return Contract.staticSearchRemoteDevelopersPerYear(siteRequest_, (BigDecimal)o);
    case "onsiteDevelopersPerYear":
      return Contract.staticSearchOnsiteDevelopersPerYear(siteRequest_, (BigDecimal)o);
    case "instructorsPerYear":
      return Contract.staticSearchInstructorsPerYear(siteRequest_, (BigDecimal)o);
    case "remoteDeveloperPayPerYear":
      return Contract.staticSearchRemoteDeveloperPayPerYear(siteRequest_, (BigDecimal)o);
    case "onsiteDeveloperPayPerYear":
      return Contract.staticSearchOnsiteDeveloperPayPerYear(siteRequest_, (BigDecimal)o);
    case "architectPayPerYear":
      return Contract.staticSearchArchitectPayPerYear(siteRequest_, (BigDecimal)o);
    case "instructorPayPerYear":
      return Contract.staticSearchInstructorPayPerYear(siteRequest_, (BigDecimal)o);
    case "subscriptionsPerYear":
      return Contract.staticSearchSubscriptionsPerYear(siteRequest_, (String)o);
    case "subscriptionCostsPerYear":
      return Contract.staticSearchSubscriptionCostsPerYear(siteRequest_, (BigDecimal)o);
    case "totalSubscriptionCostPerYear":
      return Contract.staticSearchTotalSubscriptionCostPerYear(siteRequest_, (BigDecimal)o);
    case "employeeSubscriptionCostsPerYear":
      return Contract.staticSearchEmployeeSubscriptionCostsPerYear(siteRequest_, (BigDecimal)o);
    case "employeesPerYearDataset":
      return Contract.staticSearchEmployeesPerYearDataset(siteRequest_, (JsonArray)o);
    case "subscriptionCostsPerYearDataset":
      return Contract.staticSearchSubscriptionCostsPerYearDataset(siteRequest_, (JsonArray)o);
    case "employeesPerYearChart":
      return Contract.staticSearchEmployeesPerYearChart(siteRequest_, (JsonObject)o);
    case "openshiftControlPlaneNodes":
      return Contract.staticSearchOpenshiftControlPlaneNodes(siteRequest_, (Integer)o);
    case "openshiftControlPlaneCores":
      return Contract.staticSearchOpenshiftControlPlaneCores(siteRequest_, (Integer)o);
    case "totalOpenshiftControlPlaneCores":
      return Contract.staticSearchTotalOpenshiftControlPlaneCores(siteRequest_, (Integer)o);
    case "openshiftControlPlaneHourlyPricePerCore":
      return Contract.staticSearchOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, (BigDecimal)o);
    case "openshiftInfraNodes":
      return Contract.staticSearchOpenshiftInfraNodes(siteRequest_, (Integer)o);
    case "openshiftInfraCores":
      return Contract.staticSearchOpenshiftInfraCores(siteRequest_, (Integer)o);
    case "totalOpenshiftInfraCores":
      return Contract.staticSearchTotalOpenshiftInfraCores(siteRequest_, (Integer)o);
    case "openshiftInfraHourlyPricePerCore":
      return Contract.staticSearchOpenshiftInfraHourlyPricePerCore(siteRequest_, (BigDecimal)o);
    case "openshiftWorkerNodes":
      return Contract.staticSearchOpenshiftWorkerNodes(siteRequest_, (Integer)o);
    case "openshiftWorkerCores":
      return Contract.staticSearchOpenshiftWorkerCores(siteRequest_, (Integer)o);
    case "totalOpenshiftWorkerCores":
      return Contract.staticSearchTotalOpenshiftWorkerCores(siteRequest_, (Integer)o);
    case "openshiftWorkerHourlyPricePerCore":
      return Contract.staticSearchOpenshiftWorkerHourlyPricePerCore(siteRequest_, (BigDecimal)o);
    case "openshiftSSDStorageTiBPerYear":
      return Contract.staticSearchOpenshiftSSDStorageTiBPerYear(siteRequest_, (BigDecimal)o);
    case "openshiftSSDStoragePricePerGiB":
      return Contract.staticSearchOpenshiftSSDStoragePricePerGiB(siteRequest_, (BigDecimal)o);
    case "openshiftCostsPerYearDataset":
      return Contract.staticSearchOpenshiftCostsPerYearDataset(siteRequest_, (JsonArray)o);
    case "openshiftCostsPerYearChart":
      return Contract.staticSearchOpenshiftCostsPerYearChart(siteRequest_, (JsonObject)o);
    case "projectExpensesChart":
      return Contract.staticSearchProjectExpensesChart(siteRequest_, (JsonObject)o);
    case "economicOutputChart":
      return Contract.staticSearchEconomicOutputChart(siteRequest_, (JsonObject)o);
      default:
        return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrContract(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrContract(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "region":
      return Contract.staticSearchStrRegion(siteRequest_, (String)o);
    case "name":
      return Contract.staticSearchStrName(siteRequest_, (String)o);
    case "abbreviation":
      return Contract.staticSearchStrAbbreviation(siteRequest_, (String)o);
    case "displayName":
      return Contract.staticSearchStrDisplayName(siteRequest_, (String)o);
    case "contractId":
      return Contract.staticSearchStrContractId(siteRequest_, (String)o);
    case "startDate":
      return Contract.staticSearchStrStartDate(siteRequest_, (String)o);
    case "investmentYearsTotal":
      return Contract.staticSearchStrInvestmentYearsTotal(siteRequest_, (Integer)o);
    case "investmentYears":
      return Contract.staticSearchStrInvestmentYears(siteRequest_, (Integer)o);
    case "investmentsPerYear":
      return Contract.staticSearchStrInvestmentsPerYear(siteRequest_, (String)o);
    case "investmentsPerYearCumulative":
      return Contract.staticSearchStrInvestmentsPerYearCumulative(siteRequest_, (String)o);
    case "assetClasses":
      return Contract.staticSearchStrAssetClasses(siteRequest_, (String)o);
    case "assetClassesTargetIrr":
      return Contract.staticSearchStrAssetClassesTargetIrr(siteRequest_, (String)o);
    case "revenueStreams":
      return Contract.staticSearchStrRevenueStreams(siteRequest_, (String)o);
    case "economicOutputProjections":
      return Contract.staticSearchStrEconomicOutputProjections(siteRequest_, (String)o);
    case "totalGdpImpact":
      return Contract.staticSearchStrTotalGdpImpact(siteRequest_, (String)o);
    case "economicOutputProjectionsDataset":
      return Contract.staticSearchStrEconomicOutputProjectionsDataset(siteRequest_, (String)o);
    case "cumulativeInvestmentChart":
      return Contract.staticSearchStrCumulativeInvestmentChart(siteRequest_, (String)o);
    case "architectsPerYear":
      return Contract.staticSearchStrArchitectsPerYear(siteRequest_, (String)o);
    case "remoteDevelopersPerYear":
      return Contract.staticSearchStrRemoteDevelopersPerYear(siteRequest_, (String)o);
    case "onsiteDevelopersPerYear":
      return Contract.staticSearchStrOnsiteDevelopersPerYear(siteRequest_, (String)o);
    case "instructorsPerYear":
      return Contract.staticSearchStrInstructorsPerYear(siteRequest_, (String)o);
    case "remoteDeveloperPayPerYear":
      return Contract.staticSearchStrRemoteDeveloperPayPerYear(siteRequest_, (String)o);
    case "onsiteDeveloperPayPerYear":
      return Contract.staticSearchStrOnsiteDeveloperPayPerYear(siteRequest_, (String)o);
    case "architectPayPerYear":
      return Contract.staticSearchStrArchitectPayPerYear(siteRequest_, (String)o);
    case "instructorPayPerYear":
      return Contract.staticSearchStrInstructorPayPerYear(siteRequest_, (String)o);
    case "subscriptionsPerYear":
      return Contract.staticSearchStrSubscriptionsPerYear(siteRequest_, (String)o);
    case "subscriptionCostsPerYear":
      return Contract.staticSearchStrSubscriptionCostsPerYear(siteRequest_, (String)o);
    case "totalSubscriptionCostPerYear":
      return Contract.staticSearchStrTotalSubscriptionCostPerYear(siteRequest_, (String)o);
    case "employeeSubscriptionCostsPerYear":
      return Contract.staticSearchStrEmployeeSubscriptionCostsPerYear(siteRequest_, (String)o);
    case "employeesPerYearDataset":
      return Contract.staticSearchStrEmployeesPerYearDataset(siteRequest_, (String)o);
    case "subscriptionCostsPerYearDataset":
      return Contract.staticSearchStrSubscriptionCostsPerYearDataset(siteRequest_, (String)o);
    case "employeesPerYearChart":
      return Contract.staticSearchStrEmployeesPerYearChart(siteRequest_, (String)o);
    case "openshiftControlPlaneNodes":
      return Contract.staticSearchStrOpenshiftControlPlaneNodes(siteRequest_, (Integer)o);
    case "openshiftControlPlaneCores":
      return Contract.staticSearchStrOpenshiftControlPlaneCores(siteRequest_, (Integer)o);
    case "totalOpenshiftControlPlaneCores":
      return Contract.staticSearchStrTotalOpenshiftControlPlaneCores(siteRequest_, (Integer)o);
    case "openshiftControlPlaneHourlyPricePerCore":
      return Contract.staticSearchStrOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, (String)o);
    case "openshiftInfraNodes":
      return Contract.staticSearchStrOpenshiftInfraNodes(siteRequest_, (Integer)o);
    case "openshiftInfraCores":
      return Contract.staticSearchStrOpenshiftInfraCores(siteRequest_, (Integer)o);
    case "totalOpenshiftInfraCores":
      return Contract.staticSearchStrTotalOpenshiftInfraCores(siteRequest_, (Integer)o);
    case "openshiftInfraHourlyPricePerCore":
      return Contract.staticSearchStrOpenshiftInfraHourlyPricePerCore(siteRequest_, (String)o);
    case "openshiftWorkerNodes":
      return Contract.staticSearchStrOpenshiftWorkerNodes(siteRequest_, (Integer)o);
    case "openshiftWorkerCores":
      return Contract.staticSearchStrOpenshiftWorkerCores(siteRequest_, (Integer)o);
    case "totalOpenshiftWorkerCores":
      return Contract.staticSearchStrTotalOpenshiftWorkerCores(siteRequest_, (Integer)o);
    case "openshiftWorkerHourlyPricePerCore":
      return Contract.staticSearchStrOpenshiftWorkerHourlyPricePerCore(siteRequest_, (String)o);
    case "openshiftSSDStorageTiBPerYear":
      return Contract.staticSearchStrOpenshiftSSDStorageTiBPerYear(siteRequest_, (String)o);
    case "openshiftSSDStoragePricePerGiB":
      return Contract.staticSearchStrOpenshiftSSDStoragePricePerGiB(siteRequest_, (String)o);
    case "openshiftCostsPerYearDataset":
      return Contract.staticSearchStrOpenshiftCostsPerYearDataset(siteRequest_, (String)o);
    case "openshiftCostsPerYearChart":
      return Contract.staticSearchStrOpenshiftCostsPerYearChart(siteRequest_, (String)o);
    case "projectExpensesChart":
      return Contract.staticSearchStrProjectExpensesChart(siteRequest_, (String)o);
    case "economicOutputChart":
      return Contract.staticSearchStrEconomicOutputChart(siteRequest_, (String)o);
      default:
        return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqContract(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqContract(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "region":
      return Contract.staticSearchFqRegion(siteRequest_, o);
    case "name":
      return Contract.staticSearchFqName(siteRequest_, o);
    case "abbreviation":
      return Contract.staticSearchFqAbbreviation(siteRequest_, o);
    case "displayName":
      return Contract.staticSearchFqDisplayName(siteRequest_, o);
    case "contractId":
      return Contract.staticSearchFqContractId(siteRequest_, o);
    case "startDate":
      return Contract.staticSearchFqStartDate(siteRequest_, o);
    case "investmentYearsTotal":
      return Contract.staticSearchFqInvestmentYearsTotal(siteRequest_, o);
    case "investmentYears":
      return Contract.staticSearchFqInvestmentYears(siteRequest_, o);
    case "investmentsPerYear":
      return Contract.staticSearchFqInvestmentsPerYear(siteRequest_, o);
    case "investmentsPerYearCumulative":
      return Contract.staticSearchFqInvestmentsPerYearCumulative(siteRequest_, o);
    case "assetClasses":
      return Contract.staticSearchFqAssetClasses(siteRequest_, o);
    case "assetClassesTargetIrr":
      return Contract.staticSearchFqAssetClassesTargetIrr(siteRequest_, o);
    case "revenueStreams":
      return Contract.staticSearchFqRevenueStreams(siteRequest_, o);
    case "economicOutputProjections":
      return Contract.staticSearchFqEconomicOutputProjections(siteRequest_, o);
    case "totalGdpImpact":
      return Contract.staticSearchFqTotalGdpImpact(siteRequest_, o);
    case "economicOutputProjectionsDataset":
      return Contract.staticSearchFqEconomicOutputProjectionsDataset(siteRequest_, o);
    case "cumulativeInvestmentChart":
      return Contract.staticSearchFqCumulativeInvestmentChart(siteRequest_, o);
    case "architectsPerYear":
      return Contract.staticSearchFqArchitectsPerYear(siteRequest_, o);
    case "remoteDevelopersPerYear":
      return Contract.staticSearchFqRemoteDevelopersPerYear(siteRequest_, o);
    case "onsiteDevelopersPerYear":
      return Contract.staticSearchFqOnsiteDevelopersPerYear(siteRequest_, o);
    case "instructorsPerYear":
      return Contract.staticSearchFqInstructorsPerYear(siteRequest_, o);
    case "remoteDeveloperPayPerYear":
      return Contract.staticSearchFqRemoteDeveloperPayPerYear(siteRequest_, o);
    case "onsiteDeveloperPayPerYear":
      return Contract.staticSearchFqOnsiteDeveloperPayPerYear(siteRequest_, o);
    case "architectPayPerYear":
      return Contract.staticSearchFqArchitectPayPerYear(siteRequest_, o);
    case "instructorPayPerYear":
      return Contract.staticSearchFqInstructorPayPerYear(siteRequest_, o);
    case "subscriptionsPerYear":
      return Contract.staticSearchFqSubscriptionsPerYear(siteRequest_, o);
    case "subscriptionCostsPerYear":
      return Contract.staticSearchFqSubscriptionCostsPerYear(siteRequest_, o);
    case "totalSubscriptionCostPerYear":
      return Contract.staticSearchFqTotalSubscriptionCostPerYear(siteRequest_, o);
    case "employeeSubscriptionCostsPerYear":
      return Contract.staticSearchFqEmployeeSubscriptionCostsPerYear(siteRequest_, o);
    case "employeesPerYearDataset":
      return Contract.staticSearchFqEmployeesPerYearDataset(siteRequest_, o);
    case "subscriptionCostsPerYearDataset":
      return Contract.staticSearchFqSubscriptionCostsPerYearDataset(siteRequest_, o);
    case "employeesPerYearChart":
      return Contract.staticSearchFqEmployeesPerYearChart(siteRequest_, o);
    case "openshiftControlPlaneNodes":
      return Contract.staticSearchFqOpenshiftControlPlaneNodes(siteRequest_, o);
    case "openshiftControlPlaneCores":
      return Contract.staticSearchFqOpenshiftControlPlaneCores(siteRequest_, o);
    case "totalOpenshiftControlPlaneCores":
      return Contract.staticSearchFqTotalOpenshiftControlPlaneCores(siteRequest_, o);
    case "openshiftControlPlaneHourlyPricePerCore":
      return Contract.staticSearchFqOpenshiftControlPlaneHourlyPricePerCore(siteRequest_, o);
    case "openshiftInfraNodes":
      return Contract.staticSearchFqOpenshiftInfraNodes(siteRequest_, o);
    case "openshiftInfraCores":
      return Contract.staticSearchFqOpenshiftInfraCores(siteRequest_, o);
    case "totalOpenshiftInfraCores":
      return Contract.staticSearchFqTotalOpenshiftInfraCores(siteRequest_, o);
    case "openshiftInfraHourlyPricePerCore":
      return Contract.staticSearchFqOpenshiftInfraHourlyPricePerCore(siteRequest_, o);
    case "openshiftWorkerNodes":
      return Contract.staticSearchFqOpenshiftWorkerNodes(siteRequest_, o);
    case "openshiftWorkerCores":
      return Contract.staticSearchFqOpenshiftWorkerCores(siteRequest_, o);
    case "totalOpenshiftWorkerCores":
      return Contract.staticSearchFqTotalOpenshiftWorkerCores(siteRequest_, o);
    case "openshiftWorkerHourlyPricePerCore":
      return Contract.staticSearchFqOpenshiftWorkerHourlyPricePerCore(siteRequest_, o);
    case "openshiftSSDStorageTiBPerYear":
      return Contract.staticSearchFqOpenshiftSSDStorageTiBPerYear(siteRequest_, o);
    case "openshiftSSDStoragePricePerGiB":
      return Contract.staticSearchFqOpenshiftSSDStoragePricePerGiB(siteRequest_, o);
    case "openshiftCostsPerYearDataset":
      return Contract.staticSearchFqOpenshiftCostsPerYearDataset(siteRequest_, o);
    case "openshiftCostsPerYearChart":
      return Contract.staticSearchFqOpenshiftCostsPerYearChart(siteRequest_, o);
    case "projectExpensesChart":
      return Contract.staticSearchFqProjectExpensesChart(siteRequest_, o);
    case "economicOutputChart":
      return Contract.staticSearchFqEconomicOutputChart(siteRequest_, o);
      default:
        return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
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
          o = persistContract(v, val);
        else if(o instanceof BaseModel) {
          BaseModel oBaseModel = (BaseModel)o;
          o = oBaseModel.persistForClass(v, val);
        }
      }
    }
    return o != null;
  }
  public Object persistContract(String var, Object val) {
    String varLower = var.toLowerCase();
      if("region".equals(varLower)) {
        if(val instanceof String) {
          setRegion((String)val);
        }
        saves.add("region");
        return val;
      } else if("name".equals(varLower)) {
        if(val instanceof String) {
          setName((String)val);
        }
        saves.add("name");
        return val;
      } else if("abbreviation".equals(varLower)) {
        if(val instanceof String) {
          setAbbreviation((String)val);
        }
        saves.add("abbreviation");
        return val;
      } else if("displayname".equals(varLower)) {
        if(val instanceof String) {
          setDisplayName((String)val);
        }
        saves.add("displayName");
        return val;
      } else if("contractid".equals(varLower)) {
        if(val instanceof String) {
          setContractId((String)val);
        }
        saves.add("contractId");
        return val;
      } else if("startdate".equals(varLower)) {
        if(val instanceof String) {
          setStartDate((String)val);
        } else if(val instanceof OffsetDateTime) {
          setStartDate(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
        } else if(val instanceof ZonedDateTime) {
          setStartDate((ZonedDateTime)val);
        }
        saves.add("startDate");
        return val;
      } else if("investmentyearstotal".equals(varLower)) {
        if(val instanceof Integer) {
          setInvestmentYearsTotal((Integer)val);
        } else {
          setInvestmentYearsTotal(val == null ? null : val.toString());
        }
        saves.add("investmentYearsTotal");
        return val;
      } else if("investmentyears".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<Integer>)val).stream().forEach(v -> addInvestmentYears(v));
        } else if(val instanceof Integer[]) {
          Arrays.asList((Integer[])val).stream().forEach(v -> addInvestmentYears((Integer)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addInvestmentYears(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addInvestmentYears(staticSetInvestmentYears(siteRequest_, v.toString())));
        }
        if(!saves.contains("investmentYears")) {
          saves.add("investmentYears");
        }
        return val;
      } else if("investmentsperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addInvestmentsPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addInvestmentsPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addInvestmentsPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addInvestmentsPerYear(staticSetInvestmentsPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("investmentsPerYear")) {
          saves.add("investmentsPerYear");
        }
        return val;
      } else if("investmentsperyearcumulative".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addInvestmentsPerYearCumulative(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addInvestmentsPerYearCumulative((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addInvestmentsPerYearCumulative(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addInvestmentsPerYearCumulative(staticSetInvestmentsPerYearCumulative(siteRequest_, v.toString())));
        }
        if(!saves.contains("investmentsPerYearCumulative")) {
          saves.add("investmentsPerYearCumulative");
        }
        return val;
      } else if("assetclasses".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addAssetClasses(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addAssetClasses((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addAssetClasses(staticSetAssetClasses(siteRequest_, v.toString())));
        }
        if(!saves.contains("assetClasses")) {
          saves.add("assetClasses");
        }
        return val;
      } else if("assetclassestargetirr".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addAssetClassesTargetIrr(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addAssetClassesTargetIrr((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addAssetClassesTargetIrr(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addAssetClassesTargetIrr(staticSetAssetClassesTargetIrr(siteRequest_, v.toString())));
        }
        if(!saves.contains("assetClassesTargetIrr")) {
          saves.add("assetClassesTargetIrr");
        }
        return val;
      } else if("revenuestreams".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addRevenueStreams(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addRevenueStreams((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addRevenueStreams(staticSetRevenueStreams(siteRequest_, v.toString())));
        }
        if(!saves.contains("revenueStreams")) {
          saves.add("revenueStreams");
        }
        return val;
      } else if("economicoutputprojections".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addEconomicOutputProjections(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addEconomicOutputProjections((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addEconomicOutputProjections(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addEconomicOutputProjections(staticSetEconomicOutputProjections(siteRequest_, v.toString())));
        }
        if(!saves.contains("economicOutputProjections")) {
          saves.add("economicOutputProjections");
        }
        return val;
      } else if("totalgdpimpact".equals(varLower)) {
        if(val instanceof String) {
          setTotalGdpImpact((String)val);
        } else if(val instanceof Number) {
          setTotalGdpImpact(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setTotalGdpImpact((BigDecimal)val);
        }
        saves.add("totalGdpImpact");
        return val;
      } else if("economicoutputprojectionsdataset".equals(varLower)) {
        if(val instanceof String) {
          setEconomicOutputProjectionsDataset((String)val);
        } else if(val instanceof JsonArray) {
          setEconomicOutputProjectionsDataset((JsonArray)val);
        } else if(val instanceof JsonArray) {
          setEconomicOutputProjectionsDataset((JsonArray)val);
        }
        saves.add("economicOutputProjectionsDataset");
        return val;
      } else if("architectsperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addArchitectsPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addArchitectsPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addArchitectsPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addArchitectsPerYear(staticSetArchitectsPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("architectsPerYear")) {
          saves.add("architectsPerYear");
        }
        return val;
      } else if("remotedevelopersperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addRemoteDevelopersPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addRemoteDevelopersPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addRemoteDevelopersPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addRemoteDevelopersPerYear(staticSetRemoteDevelopersPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("remoteDevelopersPerYear")) {
          saves.add("remoteDevelopersPerYear");
        }
        return val;
      } else if("onsitedevelopersperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addOnsiteDevelopersPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addOnsiteDevelopersPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addOnsiteDevelopersPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addOnsiteDevelopersPerYear(staticSetOnsiteDevelopersPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("onsiteDevelopersPerYear")) {
          saves.add("onsiteDevelopersPerYear");
        }
        return val;
      } else if("instructorsperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addInstructorsPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addInstructorsPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addInstructorsPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addInstructorsPerYear(staticSetInstructorsPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("instructorsPerYear")) {
          saves.add("instructorsPerYear");
        }
        return val;
      } else if("remotedeveloperpayperyear".equals(varLower)) {
        if(val instanceof String) {
          setRemoteDeveloperPayPerYear((String)val);
        } else if(val instanceof Number) {
          setRemoteDeveloperPayPerYear(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setRemoteDeveloperPayPerYear((BigDecimal)val);
        }
        saves.add("remoteDeveloperPayPerYear");
        return val;
      } else if("onsitedeveloperpayperyear".equals(varLower)) {
        if(val instanceof String) {
          setOnsiteDeveloperPayPerYear((String)val);
        } else if(val instanceof Number) {
          setOnsiteDeveloperPayPerYear(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setOnsiteDeveloperPayPerYear((BigDecimal)val);
        }
        saves.add("onsiteDeveloperPayPerYear");
        return val;
      } else if("architectpayperyear".equals(varLower)) {
        if(val instanceof String) {
          setArchitectPayPerYear((String)val);
        } else if(val instanceof Number) {
          setArchitectPayPerYear(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setArchitectPayPerYear((BigDecimal)val);
        }
        saves.add("architectPayPerYear");
        return val;
      } else if("instructorpayperyear".equals(varLower)) {
        if(val instanceof String) {
          setInstructorPayPerYear((String)val);
        } else if(val instanceof Number) {
          setInstructorPayPerYear(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setInstructorPayPerYear((BigDecimal)val);
        }
        saves.add("instructorPayPerYear");
        return val;
      } else if("subscriptionsperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<String>)val).stream().forEach(v -> addSubscriptionsPerYear(v));
        } else if(val instanceof String[]) {
          Arrays.asList((String[])val).stream().forEach(v -> addSubscriptionsPerYear((String)v));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addSubscriptionsPerYear(staticSetSubscriptionsPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("subscriptionsPerYear")) {
          saves.add("subscriptionsPerYear");
        }
        return val;
      } else if("subscriptioncostsperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addSubscriptionCostsPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addSubscriptionCostsPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addSubscriptionCostsPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addSubscriptionCostsPerYear(staticSetSubscriptionCostsPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("subscriptionCostsPerYear")) {
          saves.add("subscriptionCostsPerYear");
        }
        return val;
      } else if("totalsubscriptioncostperyear".equals(varLower)) {
        if(val instanceof String) {
          setTotalSubscriptionCostPerYear((String)val);
        } else if(val instanceof Number) {
          setTotalSubscriptionCostPerYear(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setTotalSubscriptionCostPerYear((BigDecimal)val);
        }
        saves.add("totalSubscriptionCostPerYear");
        return val;
      } else if("employeesubscriptioncostsperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addEmployeeSubscriptionCostsPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addEmployeeSubscriptionCostsPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addEmployeeSubscriptionCostsPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addEmployeeSubscriptionCostsPerYear(staticSetEmployeeSubscriptionCostsPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("employeeSubscriptionCostsPerYear")) {
          saves.add("employeeSubscriptionCostsPerYear");
        }
        return val;
      } else if("employeesperyeardataset".equals(varLower)) {
        if(val instanceof String) {
          setEmployeesPerYearDataset((String)val);
        } else if(val instanceof JsonArray) {
          setEmployeesPerYearDataset((JsonArray)val);
        } else if(val instanceof JsonArray) {
          setEmployeesPerYearDataset((JsonArray)val);
        }
        saves.add("employeesPerYearDataset");
        return val;
      } else if("subscriptioncostsperyeardataset".equals(varLower)) {
        if(val instanceof String) {
          setSubscriptionCostsPerYearDataset((String)val);
        } else if(val instanceof JsonArray) {
          setSubscriptionCostsPerYearDataset((JsonArray)val);
        } else if(val instanceof JsonArray) {
          setSubscriptionCostsPerYearDataset((JsonArray)val);
        }
        saves.add("subscriptionCostsPerYearDataset");
        return val;
      } else if("openshiftcontrolplanenodes".equals(varLower)) {
        if(val instanceof Integer) {
          setOpenshiftControlPlaneNodes((Integer)val);
        } else {
          setOpenshiftControlPlaneNodes(val == null ? null : val.toString());
        }
        saves.add("openshiftControlPlaneNodes");
        return val;
      } else if("openshiftcontrolplanecores".equals(varLower)) {
        if(val instanceof Integer) {
          setOpenshiftControlPlaneCores((Integer)val);
        } else {
          setOpenshiftControlPlaneCores(val == null ? null : val.toString());
        }
        saves.add("openshiftControlPlaneCores");
        return val;
      } else if("totalopenshiftcontrolplanecores".equals(varLower)) {
        if(val instanceof Integer) {
          setTotalOpenshiftControlPlaneCores((Integer)val);
        } else {
          setTotalOpenshiftControlPlaneCores(val == null ? null : val.toString());
        }
        saves.add("totalOpenshiftControlPlaneCores");
        return val;
      } else if("openshiftcontrolplanehourlypricepercore".equals(varLower)) {
        if(val instanceof String) {
          setOpenshiftControlPlaneHourlyPricePerCore((String)val);
        } else if(val instanceof Number) {
          setOpenshiftControlPlaneHourlyPricePerCore(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setOpenshiftControlPlaneHourlyPricePerCore((BigDecimal)val);
        }
        saves.add("openshiftControlPlaneHourlyPricePerCore");
        return val;
      } else if("openshiftinfranodes".equals(varLower)) {
        if(val instanceof Integer) {
          setOpenshiftInfraNodes((Integer)val);
        } else {
          setOpenshiftInfraNodes(val == null ? null : val.toString());
        }
        saves.add("openshiftInfraNodes");
        return val;
      } else if("openshiftinfracores".equals(varLower)) {
        if(val instanceof Integer) {
          setOpenshiftInfraCores((Integer)val);
        } else {
          setOpenshiftInfraCores(val == null ? null : val.toString());
        }
        saves.add("openshiftInfraCores");
        return val;
      } else if("totalopenshiftinfracores".equals(varLower)) {
        if(val instanceof Integer) {
          setTotalOpenshiftInfraCores((Integer)val);
        } else {
          setTotalOpenshiftInfraCores(val == null ? null : val.toString());
        }
        saves.add("totalOpenshiftInfraCores");
        return val;
      } else if("openshiftinfrahourlypricepercore".equals(varLower)) {
        if(val instanceof String) {
          setOpenshiftInfraHourlyPricePerCore((String)val);
        } else if(val instanceof Number) {
          setOpenshiftInfraHourlyPricePerCore(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setOpenshiftInfraHourlyPricePerCore((BigDecimal)val);
        }
        saves.add("openshiftInfraHourlyPricePerCore");
        return val;
      } else if("openshiftworkernodes".equals(varLower)) {
        if(val instanceof Integer) {
          setOpenshiftWorkerNodes((Integer)val);
        } else {
          setOpenshiftWorkerNodes(val == null ? null : val.toString());
        }
        saves.add("openshiftWorkerNodes");
        return val;
      } else if("openshiftworkercores".equals(varLower)) {
        if(val instanceof Integer) {
          setOpenshiftWorkerCores((Integer)val);
        } else {
          setOpenshiftWorkerCores(val == null ? null : val.toString());
        }
        saves.add("openshiftWorkerCores");
        return val;
      } else if("totalopenshiftworkercores".equals(varLower)) {
        if(val instanceof Integer) {
          setTotalOpenshiftWorkerCores((Integer)val);
        } else {
          setTotalOpenshiftWorkerCores(val == null ? null : val.toString());
        }
        saves.add("totalOpenshiftWorkerCores");
        return val;
      } else if("openshiftworkerhourlypricepercore".equals(varLower)) {
        if(val instanceof String) {
          setOpenshiftWorkerHourlyPricePerCore((String)val);
        } else if(val instanceof Number) {
          setOpenshiftWorkerHourlyPricePerCore(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setOpenshiftWorkerHourlyPricePerCore((BigDecimal)val);
        }
        saves.add("openshiftWorkerHourlyPricePerCore");
        return val;
      } else if("openshiftssdstoragetibperyear".equals(varLower)) {
        if(val instanceof List<?>) {
          ((List<BigDecimal>)val).stream().forEach(v -> addOpenshiftSSDStorageTiBPerYear(v));
        } else if(val instanceof BigDecimal[]) {
          Arrays.asList((BigDecimal[])val).stream().forEach(v -> addOpenshiftSSDStorageTiBPerYear((BigDecimal)v));
        } else if(val instanceof Number[]) {
          Arrays.asList((Number[])val).stream().forEach(v -> addOpenshiftSSDStorageTiBPerYear(((Number)v).toString()));
        } else if(val instanceof JsonArray) {
          ((JsonArray)val).stream().forEach(v -> addOpenshiftSSDStorageTiBPerYear(staticSetOpenshiftSSDStorageTiBPerYear(siteRequest_, v.toString())));
        }
        if(!saves.contains("openshiftSSDStorageTiBPerYear")) {
          saves.add("openshiftSSDStorageTiBPerYear");
        }
        return val;
      } else if("openshiftssdstoragepricepergib".equals(varLower)) {
        if(val instanceof String) {
          setOpenshiftSSDStoragePricePerGiB((String)val);
        } else if(val instanceof Number) {
          setOpenshiftSSDStoragePricePerGiB(new BigDecimal(((Number)val).doubleValue()));
        } else if(val instanceof BigDecimal) {
          setOpenshiftSSDStoragePricePerGiB((BigDecimal)val);
        }
        saves.add("openshiftSSDStoragePricePerGiB");
        return val;
      } else if("openshiftcostsperyeardataset".equals(varLower)) {
        if(val instanceof String) {
          setOpenshiftCostsPerYearDataset((String)val);
        } else if(val instanceof JsonArray) {
          setOpenshiftCostsPerYearDataset((JsonArray)val);
        } else if(val instanceof JsonArray) {
          setOpenshiftCostsPerYearDataset((JsonArray)val);
        }
        saves.add("openshiftCostsPerYearDataset");
        return val;
    } else {
      return super.persistBaseModel(var, val);
    }
  }

  /////////////
  // populate //
  /////////////

  @Override public void populateForClass(SolrResponse.Doc doc) {
    populateContract(doc);
  }
  public void populateContract(SolrResponse.Doc doc) {
    Contract oContract = (Contract)this;
    saves = Optional.ofNullable((ArrayList<String>)doc.get("saves_docvalues_strings")).orElse(new ArrayList<String>());
    if(saves != null) {

      if(saves.contains("region")) {
        String region = (String)doc.get("region_docvalues_string");
        if(region != null)
          oContract.setRegion(region);
      }

      if(saves.contains("name")) {
        String name = (String)doc.get("name_docvalues_string");
        if(name != null)
          oContract.setName(name);
      }

      if(saves.contains("abbreviation")) {
        String abbreviation = (String)doc.get("abbreviation_docvalues_string");
        if(abbreviation != null)
          oContract.setAbbreviation(abbreviation);
      }

      if(saves.contains("displayName")) {
        String displayName = (String)doc.get("displayName_docvalues_string");
        if(displayName != null)
          oContract.setDisplayName(displayName);
      }

      if(saves.contains("contractId")) {
        String contractId = (String)doc.get("contractId_docvalues_string");
        if(contractId != null)
          oContract.setContractId(contractId);
      }

      if(saves.contains("startDate")) {
        String startDate = (String)doc.get("startDate_docvalues_date");
        if(startDate != null)
          oContract.setStartDate(startDate);
      }

      if(saves.contains("investmentYearsTotal")) {
        Integer investmentYearsTotal = (Integer)doc.get("investmentYearsTotal_docvalues_int");
        if(investmentYearsTotal != null)
          oContract.setInvestmentYearsTotal(investmentYearsTotal);
      }

      if(saves.contains("investmentYears")) {
        List<Integer> investmentYears = (List<Integer>)doc.get("investmentYears_docvalues_ints");
        if(investmentYears != null) {
          investmentYears.stream().forEach( v -> {
            oContract.investmentYears.add(v);
          });
        }
      }

      if(saves.contains("investmentsPerYear")) {
        List<String> investmentsPerYear = (List<String>)doc.get("investmentsPerYear_docvalues_strings");
        if(investmentsPerYear != null) {
          investmentsPerYear.stream().forEach( v -> {
            oContract.investmentsPerYear.add(Contract.staticSetInvestmentsPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("investmentsPerYearCumulative")) {
        List<String> investmentsPerYearCumulative = (List<String>)doc.get("investmentsPerYearCumulative_docvalues_strings");
        if(investmentsPerYearCumulative != null) {
          investmentsPerYearCumulative.stream().forEach( v -> {
            oContract.investmentsPerYearCumulative.add(Contract.staticSetInvestmentsPerYearCumulative(siteRequest_, v));
          });
        }
      }

      if(saves.contains("assetClasses")) {
        List<String> assetClasses = (List<String>)doc.get("assetClasses_docvalues_strings");
        if(assetClasses != null) {
          assetClasses.stream().forEach( v -> {
            oContract.assetClasses.add(Contract.staticSetAssetClasses(siteRequest_, v));
          });
        }
      }

      if(saves.contains("assetClassesTargetIrr")) {
        List<String> assetClassesTargetIrr = (List<String>)doc.get("assetClassesTargetIrr_docvalues_strings");
        if(assetClassesTargetIrr != null) {
          assetClassesTargetIrr.stream().forEach( v -> {
            oContract.assetClassesTargetIrr.add(Contract.staticSetAssetClassesTargetIrr(siteRequest_, v));
          });
        }
      }

      if(saves.contains("revenueStreams")) {
        List<String> revenueStreams = (List<String>)doc.get("revenueStreams_docvalues_strings");
        if(revenueStreams != null) {
          revenueStreams.stream().forEach( v -> {
            oContract.revenueStreams.add(Contract.staticSetRevenueStreams(siteRequest_, v));
          });
        }
      }

      if(saves.contains("economicOutputProjections")) {
        List<String> economicOutputProjections = (List<String>)doc.get("economicOutputProjections_docvalues_strings");
        if(economicOutputProjections != null) {
          economicOutputProjections.stream().forEach( v -> {
            oContract.economicOutputProjections.add(Contract.staticSetEconomicOutputProjections(siteRequest_, v));
          });
        }
      }

      if(saves.contains("totalGdpImpact")) {
        String totalGdpImpact = (String)doc.get("totalGdpImpact_docvalues_string");
        if(totalGdpImpact != null)
          oContract.setTotalGdpImpact(totalGdpImpact);
      }

      if(saves.contains("economicOutputProjectionsDataset")) {
        String economicOutputProjectionsDataset = (String)doc.get("economicOutputProjectionsDataset_docvalues_string");
        if(economicOutputProjectionsDataset != null)
          oContract.setEconomicOutputProjectionsDataset(economicOutputProjectionsDataset);
      }

      if(saves.contains("cumulativeInvestmentChart")) {
        String cumulativeInvestmentChart = (String)doc.get("cumulativeInvestmentChart_stored_string");
        if(cumulativeInvestmentChart != null)
          oContract.setCumulativeInvestmentChart(cumulativeInvestmentChart);
      }

      if(saves.contains("architectsPerYear")) {
        List<String> architectsPerYear = (List<String>)doc.get("architectsPerYear_docvalues_strings");
        if(architectsPerYear != null) {
          architectsPerYear.stream().forEach( v -> {
            oContract.architectsPerYear.add(Contract.staticSetArchitectsPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("remoteDevelopersPerYear")) {
        List<String> remoteDevelopersPerYear = (List<String>)doc.get("remoteDevelopersPerYear_docvalues_strings");
        if(remoteDevelopersPerYear != null) {
          remoteDevelopersPerYear.stream().forEach( v -> {
            oContract.remoteDevelopersPerYear.add(Contract.staticSetRemoteDevelopersPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("onsiteDevelopersPerYear")) {
        List<String> onsiteDevelopersPerYear = (List<String>)doc.get("onsiteDevelopersPerYear_docvalues_strings");
        if(onsiteDevelopersPerYear != null) {
          onsiteDevelopersPerYear.stream().forEach( v -> {
            oContract.onsiteDevelopersPerYear.add(Contract.staticSetOnsiteDevelopersPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("instructorsPerYear")) {
        List<String> instructorsPerYear = (List<String>)doc.get("instructorsPerYear_docvalues_strings");
        if(instructorsPerYear != null) {
          instructorsPerYear.stream().forEach( v -> {
            oContract.instructorsPerYear.add(Contract.staticSetInstructorsPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("remoteDeveloperPayPerYear")) {
        String remoteDeveloperPayPerYear = (String)doc.get("remoteDeveloperPayPerYear_docvalues_string");
        if(remoteDeveloperPayPerYear != null)
          oContract.setRemoteDeveloperPayPerYear(remoteDeveloperPayPerYear);
      }

      if(saves.contains("onsiteDeveloperPayPerYear")) {
        String onsiteDeveloperPayPerYear = (String)doc.get("onsiteDeveloperPayPerYear_docvalues_string");
        if(onsiteDeveloperPayPerYear != null)
          oContract.setOnsiteDeveloperPayPerYear(onsiteDeveloperPayPerYear);
      }

      if(saves.contains("architectPayPerYear")) {
        String architectPayPerYear = (String)doc.get("architectPayPerYear_docvalues_string");
        if(architectPayPerYear != null)
          oContract.setArchitectPayPerYear(architectPayPerYear);
      }

      if(saves.contains("instructorPayPerYear")) {
        String instructorPayPerYear = (String)doc.get("instructorPayPerYear_docvalues_string");
        if(instructorPayPerYear != null)
          oContract.setInstructorPayPerYear(instructorPayPerYear);
      }

      if(saves.contains("subscriptionsPerYear")) {
        List<String> subscriptionsPerYear = (List<String>)doc.get("subscriptionsPerYear_docvalues_strings");
        if(subscriptionsPerYear != null) {
          subscriptionsPerYear.stream().forEach( v -> {
            oContract.subscriptionsPerYear.add(Contract.staticSetSubscriptionsPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("subscriptionCostsPerYear")) {
        List<String> subscriptionCostsPerYear = (List<String>)doc.get("subscriptionCostsPerYear_docvalues_strings");
        if(subscriptionCostsPerYear != null) {
          subscriptionCostsPerYear.stream().forEach( v -> {
            oContract.subscriptionCostsPerYear.add(Contract.staticSetSubscriptionCostsPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("totalSubscriptionCostPerYear")) {
        String totalSubscriptionCostPerYear = (String)doc.get("totalSubscriptionCostPerYear_docvalues_string");
        if(totalSubscriptionCostPerYear != null)
          oContract.setTotalSubscriptionCostPerYear(totalSubscriptionCostPerYear);
      }

      if(saves.contains("employeeSubscriptionCostsPerYear")) {
        List<String> employeeSubscriptionCostsPerYear = (List<String>)doc.get("employeeSubscriptionCostsPerYear_docvalues_strings");
        if(employeeSubscriptionCostsPerYear != null) {
          employeeSubscriptionCostsPerYear.stream().forEach( v -> {
            oContract.employeeSubscriptionCostsPerYear.add(Contract.staticSetEmployeeSubscriptionCostsPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("employeesPerYearDataset")) {
        String employeesPerYearDataset = (String)doc.get("employeesPerYearDataset_docvalues_string");
        if(employeesPerYearDataset != null)
          oContract.setEmployeesPerYearDataset(employeesPerYearDataset);
      }

      if(saves.contains("subscriptionCostsPerYearDataset")) {
        String subscriptionCostsPerYearDataset = (String)doc.get("subscriptionCostsPerYearDataset_docvalues_string");
        if(subscriptionCostsPerYearDataset != null)
          oContract.setSubscriptionCostsPerYearDataset(subscriptionCostsPerYearDataset);
      }

      if(saves.contains("employeesPerYearChart")) {
        String employeesPerYearChart = (String)doc.get("employeesPerYearChart_stored_string");
        if(employeesPerYearChart != null)
          oContract.setEmployeesPerYearChart(employeesPerYearChart);
      }

      if(saves.contains("openshiftControlPlaneNodes")) {
        Integer openshiftControlPlaneNodes = (Integer)doc.get("openshiftControlPlaneNodes_docvalues_int");
        if(openshiftControlPlaneNodes != null)
          oContract.setOpenshiftControlPlaneNodes(openshiftControlPlaneNodes);
      }

      if(saves.contains("openshiftControlPlaneCores")) {
        Integer openshiftControlPlaneCores = (Integer)doc.get("openshiftControlPlaneCores_docvalues_int");
        if(openshiftControlPlaneCores != null)
          oContract.setOpenshiftControlPlaneCores(openshiftControlPlaneCores);
      }

      if(saves.contains("totalOpenshiftControlPlaneCores")) {
        Integer totalOpenshiftControlPlaneCores = (Integer)doc.get("totalOpenshiftControlPlaneCores_docvalues_int");
        if(totalOpenshiftControlPlaneCores != null)
          oContract.setTotalOpenshiftControlPlaneCores(totalOpenshiftControlPlaneCores);
      }

      if(saves.contains("openshiftControlPlaneHourlyPricePerCore")) {
        String openshiftControlPlaneHourlyPricePerCore = (String)doc.get("openshiftControlPlaneHourlyPricePerCore_docvalues_string");
        if(openshiftControlPlaneHourlyPricePerCore != null)
          oContract.setOpenshiftControlPlaneHourlyPricePerCore(openshiftControlPlaneHourlyPricePerCore);
      }

      if(saves.contains("openshiftInfraNodes")) {
        Integer openshiftInfraNodes = (Integer)doc.get("openshiftInfraNodes_docvalues_int");
        if(openshiftInfraNodes != null)
          oContract.setOpenshiftInfraNodes(openshiftInfraNodes);
      }

      if(saves.contains("openshiftInfraCores")) {
        Integer openshiftInfraCores = (Integer)doc.get("openshiftInfraCores_docvalues_int");
        if(openshiftInfraCores != null)
          oContract.setOpenshiftInfraCores(openshiftInfraCores);
      }

      if(saves.contains("totalOpenshiftInfraCores")) {
        Integer totalOpenshiftInfraCores = (Integer)doc.get("totalOpenshiftInfraCores_docvalues_int");
        if(totalOpenshiftInfraCores != null)
          oContract.setTotalOpenshiftInfraCores(totalOpenshiftInfraCores);
      }

      if(saves.contains("openshiftInfraHourlyPricePerCore")) {
        String openshiftInfraHourlyPricePerCore = (String)doc.get("openshiftInfraHourlyPricePerCore_docvalues_string");
        if(openshiftInfraHourlyPricePerCore != null)
          oContract.setOpenshiftInfraHourlyPricePerCore(openshiftInfraHourlyPricePerCore);
      }

      if(saves.contains("openshiftWorkerNodes")) {
        Integer openshiftWorkerNodes = (Integer)doc.get("openshiftWorkerNodes_docvalues_int");
        if(openshiftWorkerNodes != null)
          oContract.setOpenshiftWorkerNodes(openshiftWorkerNodes);
      }

      if(saves.contains("openshiftWorkerCores")) {
        Integer openshiftWorkerCores = (Integer)doc.get("openshiftWorkerCores_docvalues_int");
        if(openshiftWorkerCores != null)
          oContract.setOpenshiftWorkerCores(openshiftWorkerCores);
      }

      if(saves.contains("totalOpenshiftWorkerCores")) {
        Integer totalOpenshiftWorkerCores = (Integer)doc.get("totalOpenshiftWorkerCores_docvalues_int");
        if(totalOpenshiftWorkerCores != null)
          oContract.setTotalOpenshiftWorkerCores(totalOpenshiftWorkerCores);
      }

      if(saves.contains("openshiftWorkerHourlyPricePerCore")) {
        String openshiftWorkerHourlyPricePerCore = (String)doc.get("openshiftWorkerHourlyPricePerCore_docvalues_string");
        if(openshiftWorkerHourlyPricePerCore != null)
          oContract.setOpenshiftWorkerHourlyPricePerCore(openshiftWorkerHourlyPricePerCore);
      }

      if(saves.contains("openshiftSSDStorageTiBPerYear")) {
        List<String> openshiftSSDStorageTiBPerYear = (List<String>)doc.get("openshiftSSDStorageTiBPerYear_docvalues_strings");
        if(openshiftSSDStorageTiBPerYear != null) {
          openshiftSSDStorageTiBPerYear.stream().forEach( v -> {
            oContract.openshiftSSDStorageTiBPerYear.add(Contract.staticSetOpenshiftSSDStorageTiBPerYear(siteRequest_, v));
          });
        }
      }

      if(saves.contains("openshiftSSDStoragePricePerGiB")) {
        String openshiftSSDStoragePricePerGiB = (String)doc.get("openshiftSSDStoragePricePerGiB_docvalues_string");
        if(openshiftSSDStoragePricePerGiB != null)
          oContract.setOpenshiftSSDStoragePricePerGiB(openshiftSSDStoragePricePerGiB);
      }

      if(saves.contains("openshiftCostsPerYearDataset")) {
        String openshiftCostsPerYearDataset = (String)doc.get("openshiftCostsPerYearDataset_docvalues_string");
        if(openshiftCostsPerYearDataset != null)
          oContract.setOpenshiftCostsPerYearDataset(openshiftCostsPerYearDataset);
      }

      if(saves.contains("openshiftCostsPerYearChart")) {
        String openshiftCostsPerYearChart = (String)doc.get("openshiftCostsPerYearChart_stored_string");
        if(openshiftCostsPerYearChart != null)
          oContract.setOpenshiftCostsPerYearChart(openshiftCostsPerYearChart);
      }

      if(saves.contains("projectExpensesChart")) {
        String projectExpensesChart = (String)doc.get("projectExpensesChart_stored_string");
        if(projectExpensesChart != null)
          oContract.setProjectExpensesChart(projectExpensesChart);
      }

      if(saves.contains("economicOutputChart")) {
        String economicOutputChart = (String)doc.get("economicOutputChart_stored_string");
        if(economicOutputChart != null)
          oContract.setEconomicOutputChart(economicOutputChart);
      }
    }

    super.populateBaseModel(doc);
  }

  public void indexContract(JsonObject doc) {
    if(region != null) {
      doc.put("region_docvalues_string", region);
    }
    if(name != null) {
      doc.put("name_docvalues_string", name);
    }
    if(abbreviation != null) {
      doc.put("abbreviation_docvalues_string", abbreviation);
    }
    if(displayName != null) {
      doc.put("displayName_docvalues_string", displayName);
    }
    if(contractId != null) {
      doc.put("contractId_docvalues_string", contractId);
    }
    if(startDate != null) {
      doc.put("startDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(startDate.toInstant(), ZoneId.of("UTC"))));
    }
    if(investmentYearsTotal != null) {
      doc.put("investmentYearsTotal_docvalues_int", investmentYearsTotal);
    }
    if(investmentYears != null) {
      JsonArray l = new JsonArray();
      doc.put("investmentYears_docvalues_ints", l);
      for(Integer o : investmentYears) {
        l.add(Contract.staticSearchInvestmentYears(siteRequest_, o));
      }
    }
    if(investmentsPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("investmentsPerYear_docvalues_strings", l);
      for(BigDecimal o : investmentsPerYear) {
        l.add(Contract.staticSearchInvestmentsPerYear(siteRequest_, o));
      }
    }
    if(investmentsPerYearCumulative != null) {
      JsonArray l = new JsonArray();
      doc.put("investmentsPerYearCumulative_docvalues_strings", l);
      for(BigDecimal o : investmentsPerYearCumulative) {
        l.add(Contract.staticSearchInvestmentsPerYearCumulative(siteRequest_, o));
      }
    }
    if(assetClasses != null) {
      JsonArray l = new JsonArray();
      doc.put("assetClasses_docvalues_strings", l);
      for(String o : assetClasses) {
        l.add(Contract.staticSearchAssetClasses(siteRequest_, o));
      }
    }
    if(assetClassesTargetIrr != null) {
      JsonArray l = new JsonArray();
      doc.put("assetClassesTargetIrr_docvalues_strings", l);
      for(BigDecimal o : assetClassesTargetIrr) {
        l.add(Contract.staticSearchAssetClassesTargetIrr(siteRequest_, o));
      }
    }
    if(revenueStreams != null) {
      JsonArray l = new JsonArray();
      doc.put("revenueStreams_docvalues_strings", l);
      for(String o : revenueStreams) {
        l.add(Contract.staticSearchRevenueStreams(siteRequest_, o));
      }
    }
    if(economicOutputProjections != null) {
      JsonArray l = new JsonArray();
      doc.put("economicOutputProjections_docvalues_strings", l);
      for(BigDecimal o : economicOutputProjections) {
        l.add(Contract.staticSearchEconomicOutputProjections(siteRequest_, o));
      }
    }
    if(totalGdpImpact != null) {
      doc.put("totalGdpImpact_docvalues_string", totalGdpImpact.toPlainString());
      doc.put("totalGdpImpact_docvalues_double", totalGdpImpact.doubleValue());
    }
    if(economicOutputProjectionsDataset != null) {
      doc.put("economicOutputProjectionsDataset_docvalues_string", economicOutputProjectionsDataset.encode());
    }
    if(cumulativeInvestmentChart != null) {
      doc.put("cumulativeInvestmentChart_stored_string", cumulativeInvestmentChart.toString());
    }
    if(architectsPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("architectsPerYear_docvalues_strings", l);
      for(BigDecimal o : architectsPerYear) {
        l.add(Contract.staticSearchArchitectsPerYear(siteRequest_, o));
      }
    }
    if(remoteDevelopersPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("remoteDevelopersPerYear_docvalues_strings", l);
      for(BigDecimal o : remoteDevelopersPerYear) {
        l.add(Contract.staticSearchRemoteDevelopersPerYear(siteRequest_, o));
      }
    }
    if(onsiteDevelopersPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("onsiteDevelopersPerYear_docvalues_strings", l);
      for(BigDecimal o : onsiteDevelopersPerYear) {
        l.add(Contract.staticSearchOnsiteDevelopersPerYear(siteRequest_, o));
      }
    }
    if(instructorsPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("instructorsPerYear_docvalues_strings", l);
      for(BigDecimal o : instructorsPerYear) {
        l.add(Contract.staticSearchInstructorsPerYear(siteRequest_, o));
      }
    }
    if(remoteDeveloperPayPerYear != null) {
      doc.put("remoteDeveloperPayPerYear_docvalues_string", remoteDeveloperPayPerYear.toPlainString());
      doc.put("remoteDeveloperPayPerYear_docvalues_double", remoteDeveloperPayPerYear.doubleValue());
    }
    if(onsiteDeveloperPayPerYear != null) {
      doc.put("onsiteDeveloperPayPerYear_docvalues_string", onsiteDeveloperPayPerYear.toPlainString());
      doc.put("onsiteDeveloperPayPerYear_docvalues_double", onsiteDeveloperPayPerYear.doubleValue());
    }
    if(architectPayPerYear != null) {
      doc.put("architectPayPerYear_docvalues_string", architectPayPerYear.toPlainString());
      doc.put("architectPayPerYear_docvalues_double", architectPayPerYear.doubleValue());
    }
    if(instructorPayPerYear != null) {
      doc.put("instructorPayPerYear_docvalues_string", instructorPayPerYear.toPlainString());
      doc.put("instructorPayPerYear_docvalues_double", instructorPayPerYear.doubleValue());
    }
    if(subscriptionsPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("subscriptionsPerYear_docvalues_strings", l);
      for(String o : subscriptionsPerYear) {
        l.add(Contract.staticSearchSubscriptionsPerYear(siteRequest_, o));
      }
    }
    if(subscriptionCostsPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("subscriptionCostsPerYear_docvalues_strings", l);
      for(BigDecimal o : subscriptionCostsPerYear) {
        l.add(Contract.staticSearchSubscriptionCostsPerYear(siteRequest_, o));
      }
    }
    if(totalSubscriptionCostPerYear != null) {
      doc.put("totalSubscriptionCostPerYear_docvalues_string", totalSubscriptionCostPerYear.toPlainString());
      doc.put("totalSubscriptionCostPerYear_docvalues_double", totalSubscriptionCostPerYear.doubleValue());
    }
    if(employeeSubscriptionCostsPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("employeeSubscriptionCostsPerYear_docvalues_strings", l);
      for(BigDecimal o : employeeSubscriptionCostsPerYear) {
        l.add(Contract.staticSearchEmployeeSubscriptionCostsPerYear(siteRequest_, o));
      }
    }
    if(employeesPerYearDataset != null) {
      doc.put("employeesPerYearDataset_docvalues_string", employeesPerYearDataset.encode());
    }
    if(subscriptionCostsPerYearDataset != null) {
      doc.put("subscriptionCostsPerYearDataset_docvalues_string", subscriptionCostsPerYearDataset.encode());
    }
    if(employeesPerYearChart != null) {
      doc.put("employeesPerYearChart_stored_string", employeesPerYearChart.toString());
    }
    if(openshiftControlPlaneNodes != null) {
      doc.put("openshiftControlPlaneNodes_docvalues_int", openshiftControlPlaneNodes);
    }
    if(openshiftControlPlaneCores != null) {
      doc.put("openshiftControlPlaneCores_docvalues_int", openshiftControlPlaneCores);
    }
    if(totalOpenshiftControlPlaneCores != null) {
      doc.put("totalOpenshiftControlPlaneCores_docvalues_int", totalOpenshiftControlPlaneCores);
    }
    if(openshiftControlPlaneHourlyPricePerCore != null) {
      doc.put("openshiftControlPlaneHourlyPricePerCore_docvalues_string", openshiftControlPlaneHourlyPricePerCore.toPlainString());
      doc.put("openshiftControlPlaneHourlyPricePerCore_docvalues_double", openshiftControlPlaneHourlyPricePerCore.doubleValue());
    }
    if(openshiftInfraNodes != null) {
      doc.put("openshiftInfraNodes_docvalues_int", openshiftInfraNodes);
    }
    if(openshiftInfraCores != null) {
      doc.put("openshiftInfraCores_docvalues_int", openshiftInfraCores);
    }
    if(totalOpenshiftInfraCores != null) {
      doc.put("totalOpenshiftInfraCores_docvalues_int", totalOpenshiftInfraCores);
    }
    if(openshiftInfraHourlyPricePerCore != null) {
      doc.put("openshiftInfraHourlyPricePerCore_docvalues_string", openshiftInfraHourlyPricePerCore.toPlainString());
      doc.put("openshiftInfraHourlyPricePerCore_docvalues_double", openshiftInfraHourlyPricePerCore.doubleValue());
    }
    if(openshiftWorkerNodes != null) {
      doc.put("openshiftWorkerNodes_docvalues_int", openshiftWorkerNodes);
    }
    if(openshiftWorkerCores != null) {
      doc.put("openshiftWorkerCores_docvalues_int", openshiftWorkerCores);
    }
    if(totalOpenshiftWorkerCores != null) {
      doc.put("totalOpenshiftWorkerCores_docvalues_int", totalOpenshiftWorkerCores);
    }
    if(openshiftWorkerHourlyPricePerCore != null) {
      doc.put("openshiftWorkerHourlyPricePerCore_docvalues_string", openshiftWorkerHourlyPricePerCore.toPlainString());
      doc.put("openshiftWorkerHourlyPricePerCore_docvalues_double", openshiftWorkerHourlyPricePerCore.doubleValue());
    }
    if(openshiftSSDStorageTiBPerYear != null) {
      JsonArray l = new JsonArray();
      doc.put("openshiftSSDStorageTiBPerYear_docvalues_strings", l);
      for(BigDecimal o : openshiftSSDStorageTiBPerYear) {
        l.add(Contract.staticSearchOpenshiftSSDStorageTiBPerYear(siteRequest_, o));
      }
    }
    if(openshiftSSDStoragePricePerGiB != null) {
      doc.put("openshiftSSDStoragePricePerGiB_docvalues_string", openshiftSSDStoragePricePerGiB.toPlainString());
      doc.put("openshiftSSDStoragePricePerGiB_docvalues_double", openshiftSSDStoragePricePerGiB.doubleValue());
    }
    if(openshiftCostsPerYearDataset != null) {
      doc.put("openshiftCostsPerYearDataset_docvalues_string", openshiftCostsPerYearDataset.encode());
    }
    if(openshiftCostsPerYearChart != null) {
      doc.put("openshiftCostsPerYearChart_stored_string", openshiftCostsPerYearChart.toString());
    }
    if(projectExpensesChart != null) {
      doc.put("projectExpensesChart_stored_string", projectExpensesChart.toString());
    }
    if(economicOutputChart != null) {
      doc.put("economicOutputChart_stored_string", economicOutputChart.toString());
    }
    super.indexBaseModel(doc);

	}

  public static String varStoredContract(String entityVar) {
    switch(entityVar) {
      case "region":
        return "region_docvalues_string";
      case "name":
        return "name_docvalues_string";
      case "abbreviation":
        return "abbreviation_docvalues_string";
      case "displayName":
        return "displayName_docvalues_string";
      case "contractId":
        return "contractId_docvalues_string";
      case "startDate":
        return "startDate_docvalues_date";
      case "investmentYearsTotal":
        return "investmentYearsTotal_docvalues_int";
      case "investmentYears":
        return "investmentYears_docvalues_ints";
      case "investmentsPerYear":
        return "investmentsPerYear_docvalues_strings";
      case "investmentsPerYearCumulative":
        return "investmentsPerYearCumulative_docvalues_strings";
      case "assetClasses":
        return "assetClasses_docvalues_strings";
      case "assetClassesTargetIrr":
        return "assetClassesTargetIrr_docvalues_strings";
      case "revenueStreams":
        return "revenueStreams_docvalues_strings";
      case "economicOutputProjections":
        return "economicOutputProjections_docvalues_strings";
      case "totalGdpImpact":
        return "totalGdpImpact_docvalues_string";
      case "economicOutputProjectionsDataset":
        return "economicOutputProjectionsDataset_docvalues_string";
      case "cumulativeInvestmentChart":
        return "cumulativeInvestmentChart_stored_string";
      case "architectsPerYear":
        return "architectsPerYear_docvalues_strings";
      case "remoteDevelopersPerYear":
        return "remoteDevelopersPerYear_docvalues_strings";
      case "onsiteDevelopersPerYear":
        return "onsiteDevelopersPerYear_docvalues_strings";
      case "instructorsPerYear":
        return "instructorsPerYear_docvalues_strings";
      case "remoteDeveloperPayPerYear":
        return "remoteDeveloperPayPerYear_docvalues_string";
      case "onsiteDeveloperPayPerYear":
        return "onsiteDeveloperPayPerYear_docvalues_string";
      case "architectPayPerYear":
        return "architectPayPerYear_docvalues_string";
      case "instructorPayPerYear":
        return "instructorPayPerYear_docvalues_string";
      case "subscriptionsPerYear":
        return "subscriptionsPerYear_docvalues_strings";
      case "subscriptionCostsPerYear":
        return "subscriptionCostsPerYear_docvalues_strings";
      case "totalSubscriptionCostPerYear":
        return "totalSubscriptionCostPerYear_docvalues_string";
      case "employeeSubscriptionCostsPerYear":
        return "employeeSubscriptionCostsPerYear_docvalues_strings";
      case "employeesPerYearDataset":
        return "employeesPerYearDataset_docvalues_string";
      case "subscriptionCostsPerYearDataset":
        return "subscriptionCostsPerYearDataset_docvalues_string";
      case "employeesPerYearChart":
        return "employeesPerYearChart_stored_string";
      case "openshiftControlPlaneNodes":
        return "openshiftControlPlaneNodes_docvalues_int";
      case "openshiftControlPlaneCores":
        return "openshiftControlPlaneCores_docvalues_int";
      case "totalOpenshiftControlPlaneCores":
        return "totalOpenshiftControlPlaneCores_docvalues_int";
      case "openshiftControlPlaneHourlyPricePerCore":
        return "openshiftControlPlaneHourlyPricePerCore_docvalues_string";
      case "openshiftInfraNodes":
        return "openshiftInfraNodes_docvalues_int";
      case "openshiftInfraCores":
        return "openshiftInfraCores_docvalues_int";
      case "totalOpenshiftInfraCores":
        return "totalOpenshiftInfraCores_docvalues_int";
      case "openshiftInfraHourlyPricePerCore":
        return "openshiftInfraHourlyPricePerCore_docvalues_string";
      case "openshiftWorkerNodes":
        return "openshiftWorkerNodes_docvalues_int";
      case "openshiftWorkerCores":
        return "openshiftWorkerCores_docvalues_int";
      case "totalOpenshiftWorkerCores":
        return "totalOpenshiftWorkerCores_docvalues_int";
      case "openshiftWorkerHourlyPricePerCore":
        return "openshiftWorkerHourlyPricePerCore_docvalues_string";
      case "openshiftSSDStorageTiBPerYear":
        return "openshiftSSDStorageTiBPerYear_docvalues_strings";
      case "openshiftSSDStoragePricePerGiB":
        return "openshiftSSDStoragePricePerGiB_docvalues_string";
      case "openshiftCostsPerYearDataset":
        return "openshiftCostsPerYearDataset_docvalues_string";
      case "openshiftCostsPerYearChart":
        return "openshiftCostsPerYearChart_stored_string";
      case "projectExpensesChart":
        return "projectExpensesChart_stored_string";
      case "economicOutputChart":
        return "economicOutputChart_stored_string";
      default:
        return BaseModel.varStoredBaseModel(entityVar);
    }
  }

  public static String varIndexedContract(String entityVar) {
    switch(entityVar) {
      case "region":
        return "region_docvalues_string";
      case "name":
        return "name_docvalues_string";
      case "abbreviation":
        return "abbreviation_docvalues_string";
      case "displayName":
        return "displayName_docvalues_string";
      case "contractId":
        return "contractId_docvalues_string";
      case "startDate":
        return "startDate_docvalues_date";
      case "investmentYearsTotal":
        return "investmentYearsTotal_docvalues_int";
      case "investmentYears":
        return "investmentYears_docvalues_ints";
      case "investmentsPerYear":
        return "investmentsPerYear_docvalues_strings";
      case "investmentsPerYearCumulative":
        return "investmentsPerYearCumulative_docvalues_strings";
      case "assetClasses":
        return "assetClasses_docvalues_strings";
      case "assetClassesTargetIrr":
        return "assetClassesTargetIrr_docvalues_strings";
      case "revenueStreams":
        return "revenueStreams_docvalues_strings";
      case "economicOutputProjections":
        return "economicOutputProjections_docvalues_strings";
      case "totalGdpImpact":
        return "totalGdpImpact_docvalues_string";
      case "economicOutputProjectionsDataset":
        return "economicOutputProjectionsDataset_docvalues_string";
      case "architectsPerYear":
        return "architectsPerYear_docvalues_strings";
      case "remoteDevelopersPerYear":
        return "remoteDevelopersPerYear_docvalues_strings";
      case "onsiteDevelopersPerYear":
        return "onsiteDevelopersPerYear_docvalues_strings";
      case "instructorsPerYear":
        return "instructorsPerYear_docvalues_strings";
      case "remoteDeveloperPayPerYear":
        return "remoteDeveloperPayPerYear_docvalues_string";
      case "onsiteDeveloperPayPerYear":
        return "onsiteDeveloperPayPerYear_docvalues_string";
      case "architectPayPerYear":
        return "architectPayPerYear_docvalues_string";
      case "instructorPayPerYear":
        return "instructorPayPerYear_docvalues_string";
      case "subscriptionsPerYear":
        return "subscriptionsPerYear_docvalues_strings";
      case "subscriptionCostsPerYear":
        return "subscriptionCostsPerYear_docvalues_strings";
      case "totalSubscriptionCostPerYear":
        return "totalSubscriptionCostPerYear_docvalues_string";
      case "employeeSubscriptionCostsPerYear":
        return "employeeSubscriptionCostsPerYear_docvalues_strings";
      case "employeesPerYearDataset":
        return "employeesPerYearDataset_docvalues_string";
      case "subscriptionCostsPerYearDataset":
        return "subscriptionCostsPerYearDataset_docvalues_string";
      case "openshiftControlPlaneNodes":
        return "openshiftControlPlaneNodes_docvalues_int";
      case "openshiftControlPlaneCores":
        return "openshiftControlPlaneCores_docvalues_int";
      case "totalOpenshiftControlPlaneCores":
        return "totalOpenshiftControlPlaneCores_docvalues_int";
      case "openshiftControlPlaneHourlyPricePerCore":
        return "openshiftControlPlaneHourlyPricePerCore_docvalues_string";
      case "openshiftInfraNodes":
        return "openshiftInfraNodes_docvalues_int";
      case "openshiftInfraCores":
        return "openshiftInfraCores_docvalues_int";
      case "totalOpenshiftInfraCores":
        return "totalOpenshiftInfraCores_docvalues_int";
      case "openshiftInfraHourlyPricePerCore":
        return "openshiftInfraHourlyPricePerCore_docvalues_string";
      case "openshiftWorkerNodes":
        return "openshiftWorkerNodes_docvalues_int";
      case "openshiftWorkerCores":
        return "openshiftWorkerCores_docvalues_int";
      case "totalOpenshiftWorkerCores":
        return "totalOpenshiftWorkerCores_docvalues_int";
      case "openshiftWorkerHourlyPricePerCore":
        return "openshiftWorkerHourlyPricePerCore_docvalues_string";
      case "openshiftSSDStorageTiBPerYear":
        return "openshiftSSDStorageTiBPerYear_docvalues_strings";
      case "openshiftSSDStoragePricePerGiB":
        return "openshiftSSDStoragePricePerGiB_docvalues_string";
      case "openshiftCostsPerYearDataset":
        return "openshiftCostsPerYearDataset_docvalues_string";
      default:
        return BaseModel.varIndexedBaseModel(entityVar);
    }
  }

  public static String searchVarContract(String searchVar) {
    switch(searchVar) {
      case "region_docvalues_string":
        return "region";
      case "name_docvalues_string":
        return "name";
      case "abbreviation_docvalues_string":
        return "abbreviation";
      case "displayName_docvalues_string":
        return "displayName";
      case "contractId_docvalues_string":
        return "contractId";
      case "startDate_docvalues_date":
        return "startDate";
      case "investmentYearsTotal_docvalues_int":
        return "investmentYearsTotal";
      case "investmentYears_docvalues_ints":
        return "investmentYears";
      case "investmentsPerYear_docvalues_strings":
        return "investmentsPerYear";
      case "investmentsPerYearCumulative_docvalues_strings":
        return "investmentsPerYearCumulative";
      case "assetClasses_docvalues_strings":
        return "assetClasses";
      case "assetClassesTargetIrr_docvalues_strings":
        return "assetClassesTargetIrr";
      case "revenueStreams_docvalues_strings":
        return "revenueStreams";
      case "economicOutputProjections_docvalues_strings":
        return "economicOutputProjections";
      case "totalGdpImpact_docvalues_string":
        return "totalGdpImpact";
      case "economicOutputProjectionsDataset_docvalues_string":
        return "economicOutputProjectionsDataset";
      case "architectsPerYear_docvalues_strings":
        return "architectsPerYear";
      case "remoteDevelopersPerYear_docvalues_strings":
        return "remoteDevelopersPerYear";
      case "onsiteDevelopersPerYear_docvalues_strings":
        return "onsiteDevelopersPerYear";
      case "instructorsPerYear_docvalues_strings":
        return "instructorsPerYear";
      case "remoteDeveloperPayPerYear_docvalues_string":
        return "remoteDeveloperPayPerYear";
      case "onsiteDeveloperPayPerYear_docvalues_string":
        return "onsiteDeveloperPayPerYear";
      case "architectPayPerYear_docvalues_string":
        return "architectPayPerYear";
      case "instructorPayPerYear_docvalues_string":
        return "instructorPayPerYear";
      case "subscriptionsPerYear_docvalues_strings":
        return "subscriptionsPerYear";
      case "subscriptionCostsPerYear_docvalues_strings":
        return "subscriptionCostsPerYear";
      case "totalSubscriptionCostPerYear_docvalues_string":
        return "totalSubscriptionCostPerYear";
      case "employeeSubscriptionCostsPerYear_docvalues_strings":
        return "employeeSubscriptionCostsPerYear";
      case "employeesPerYearDataset_docvalues_string":
        return "employeesPerYearDataset";
      case "subscriptionCostsPerYearDataset_docvalues_string":
        return "subscriptionCostsPerYearDataset";
      case "openshiftControlPlaneNodes_docvalues_int":
        return "openshiftControlPlaneNodes";
      case "openshiftControlPlaneCores_docvalues_int":
        return "openshiftControlPlaneCores";
      case "totalOpenshiftControlPlaneCores_docvalues_int":
        return "totalOpenshiftControlPlaneCores";
      case "openshiftControlPlaneHourlyPricePerCore_docvalues_string":
        return "openshiftControlPlaneHourlyPricePerCore";
      case "openshiftInfraNodes_docvalues_int":
        return "openshiftInfraNodes";
      case "openshiftInfraCores_docvalues_int":
        return "openshiftInfraCores";
      case "totalOpenshiftInfraCores_docvalues_int":
        return "totalOpenshiftInfraCores";
      case "openshiftInfraHourlyPricePerCore_docvalues_string":
        return "openshiftInfraHourlyPricePerCore";
      case "openshiftWorkerNodes_docvalues_int":
        return "openshiftWorkerNodes";
      case "openshiftWorkerCores_docvalues_int":
        return "openshiftWorkerCores";
      case "totalOpenshiftWorkerCores_docvalues_int":
        return "totalOpenshiftWorkerCores";
      case "openshiftWorkerHourlyPricePerCore_docvalues_string":
        return "openshiftWorkerHourlyPricePerCore";
      case "openshiftSSDStorageTiBPerYear_docvalues_strings":
        return "openshiftSSDStorageTiBPerYear";
      case "openshiftSSDStoragePricePerGiB_docvalues_string":
        return "openshiftSSDStoragePricePerGiB";
      case "openshiftCostsPerYearDataset_docvalues_string":
        return "openshiftCostsPerYearDataset";
      default:
        return BaseModel.searchVarBaseModel(searchVar);
    }
  }

  public static String varSearchContract(String entityVar) {
    switch(entityVar) {
      default:
        return BaseModel.varSearchBaseModel(entityVar);
    }
  }

  public static String varSuggestedContract(String entityVar) {
    switch(entityVar) {
      default:
        return BaseModel.varSuggestedBaseModel(entityVar);
    }
  }

  /////////////
  // store //
  /////////////

  @Override public void storeForClass(SolrResponse.Doc doc) {
    storeContract(doc);
  }
  public void storeContract(SolrResponse.Doc doc) {
    Contract oContract = (Contract)this;
    SiteRequest siteRequest = oContract.getSiteRequest_();

    oContract.setRegion(Optional.ofNullable(doc.get("region_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setName(Optional.ofNullable(doc.get("name_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setAbbreviation(Optional.ofNullable(doc.get("abbreviation_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setDisplayName(Optional.ofNullable(doc.get("displayName_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setContractId(Optional.ofNullable(doc.get("contractId_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setStartDate(Optional.ofNullable(doc.get("startDate_docvalues_date")).map(v -> v.toString()).orElse(null));
    oContract.setInvestmentYearsTotal(Optional.ofNullable(doc.get("investmentYearsTotal_docvalues_int")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("investmentYears_docvalues_ints")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addInvestmentYears(Contract.staticSetInvestmentYears(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("investmentsPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addInvestmentsPerYear(Contract.staticSetInvestmentsPerYear(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("investmentsPerYearCumulative_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addInvestmentsPerYearCumulative(Contract.staticSetInvestmentsPerYearCumulative(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("assetClasses_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addAssetClasses(Contract.staticSetAssetClasses(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("assetClassesTargetIrr_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addAssetClassesTargetIrr(Contract.staticSetAssetClassesTargetIrr(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("revenueStreams_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addRevenueStreams(Contract.staticSetRevenueStreams(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("economicOutputProjections_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addEconomicOutputProjections(Contract.staticSetEconomicOutputProjections(siteRequest, v.toString()));
    });
    oContract.setTotalGdpImpact(Optional.ofNullable(doc.get("totalGdpImpact_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setEconomicOutputProjectionsDataset(Optional.ofNullable(doc.get("economicOutputProjectionsDataset_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setCumulativeInvestmentChart(Optional.ofNullable(doc.get("cumulativeInvestmentChart_stored_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("architectsPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addArchitectsPerYear(Contract.staticSetArchitectsPerYear(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("remoteDevelopersPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addRemoteDevelopersPerYear(Contract.staticSetRemoteDevelopersPerYear(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("onsiteDevelopersPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addOnsiteDevelopersPerYear(Contract.staticSetOnsiteDevelopersPerYear(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("instructorsPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addInstructorsPerYear(Contract.staticSetInstructorsPerYear(siteRequest, v.toString()));
    });
    oContract.setRemoteDeveloperPayPerYear(Optional.ofNullable(doc.get("remoteDeveloperPayPerYear_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setOnsiteDeveloperPayPerYear(Optional.ofNullable(doc.get("onsiteDeveloperPayPerYear_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setArchitectPayPerYear(Optional.ofNullable(doc.get("architectPayPerYear_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setInstructorPayPerYear(Optional.ofNullable(doc.get("instructorPayPerYear_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("subscriptionsPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addSubscriptionsPerYear(Contract.staticSetSubscriptionsPerYear(siteRequest, v.toString()));
    });
    Optional.ofNullable((List<?>)doc.get("subscriptionCostsPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addSubscriptionCostsPerYear(Contract.staticSetSubscriptionCostsPerYear(siteRequest, v.toString()));
    });
    oContract.setTotalSubscriptionCostPerYear(Optional.ofNullable(doc.get("totalSubscriptionCostPerYear_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("employeeSubscriptionCostsPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addEmployeeSubscriptionCostsPerYear(Contract.staticSetEmployeeSubscriptionCostsPerYear(siteRequest, v.toString()));
    });
    oContract.setEmployeesPerYearDataset(Optional.ofNullable(doc.get("employeesPerYearDataset_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setSubscriptionCostsPerYearDataset(Optional.ofNullable(doc.get("subscriptionCostsPerYearDataset_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setEmployeesPerYearChart(Optional.ofNullable(doc.get("employeesPerYearChart_stored_string")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftControlPlaneNodes(Optional.ofNullable(doc.get("openshiftControlPlaneNodes_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftControlPlaneCores(Optional.ofNullable(doc.get("openshiftControlPlaneCores_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setTotalOpenshiftControlPlaneCores(Optional.ofNullable(doc.get("totalOpenshiftControlPlaneCores_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftControlPlaneHourlyPricePerCore(Optional.ofNullable(doc.get("openshiftControlPlaneHourlyPricePerCore_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftInfraNodes(Optional.ofNullable(doc.get("openshiftInfraNodes_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftInfraCores(Optional.ofNullable(doc.get("openshiftInfraCores_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setTotalOpenshiftInfraCores(Optional.ofNullable(doc.get("totalOpenshiftInfraCores_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftInfraHourlyPricePerCore(Optional.ofNullable(doc.get("openshiftInfraHourlyPricePerCore_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftWorkerNodes(Optional.ofNullable(doc.get("openshiftWorkerNodes_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftWorkerCores(Optional.ofNullable(doc.get("openshiftWorkerCores_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setTotalOpenshiftWorkerCores(Optional.ofNullable(doc.get("totalOpenshiftWorkerCores_docvalues_int")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftWorkerHourlyPricePerCore(Optional.ofNullable(doc.get("openshiftWorkerHourlyPricePerCore_docvalues_string")).map(v -> v.toString()).orElse(null));
    Optional.ofNullable((List<?>)doc.get("openshiftSSDStorageTiBPerYear_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
      oContract.addOpenshiftSSDStorageTiBPerYear(Contract.staticSetOpenshiftSSDStorageTiBPerYear(siteRequest, v.toString()));
    });
    oContract.setOpenshiftSSDStoragePricePerGiB(Optional.ofNullable(doc.get("openshiftSSDStoragePricePerGiB_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftCostsPerYearDataset(Optional.ofNullable(doc.get("openshiftCostsPerYearDataset_docvalues_string")).map(v -> v.toString()).orElse(null));
    oContract.setOpenshiftCostsPerYearChart(Optional.ofNullable(doc.get("openshiftCostsPerYearChart_stored_string")).map(v -> v.toString()).orElse(null));
    oContract.setProjectExpensesChart(Optional.ofNullable(doc.get("projectExpensesChart_stored_string")).map(v -> v.toString()).orElse(null));
    oContract.setEconomicOutputChart(Optional.ofNullable(doc.get("economicOutputChart_stored_string")).map(v -> v.toString()).orElse(null));

    super.storeBaseModel(doc);
  }

  //////////////////
  // apiRequest //
  //////////////////

  public void apiRequestContract() {
    ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
    Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
    if(o != null && o instanceof Contract) {
      Contract original = (Contract)o;
      if(!Objects.equals(region, original.getRegion()))
        apiRequest.addVars("region");
      if(!Objects.equals(name, original.getName()))
        apiRequest.addVars("name");
      if(!Objects.equals(abbreviation, original.getAbbreviation()))
        apiRequest.addVars("abbreviation");
      if(!Objects.equals(displayName, original.getDisplayName()))
        apiRequest.addVars("displayName");
      if(!Objects.equals(contractId, original.getContractId()))
        apiRequest.addVars("contractId");
      if(!Objects.equals(startDate, original.getStartDate()))
        apiRequest.addVars("startDate");
      if(!Objects.equals(investmentYearsTotal, original.getInvestmentYearsTotal()))
        apiRequest.addVars("investmentYearsTotal");
      if(!Objects.equals(investmentYears, original.getInvestmentYears()))
        apiRequest.addVars("investmentYears");
      if(!Objects.equals(investmentsPerYear, original.getInvestmentsPerYear()))
        apiRequest.addVars("investmentsPerYear");
      if(!Objects.equals(investmentsPerYearCumulative, original.getInvestmentsPerYearCumulative()))
        apiRequest.addVars("investmentsPerYearCumulative");
      if(!Objects.equals(assetClasses, original.getAssetClasses()))
        apiRequest.addVars("assetClasses");
      if(!Objects.equals(assetClassesTargetIrr, original.getAssetClassesTargetIrr()))
        apiRequest.addVars("assetClassesTargetIrr");
      if(!Objects.equals(revenueStreams, original.getRevenueStreams()))
        apiRequest.addVars("revenueStreams");
      if(!Objects.equals(economicOutputProjections, original.getEconomicOutputProjections()))
        apiRequest.addVars("economicOutputProjections");
      if(!Objects.equals(totalGdpImpact, original.getTotalGdpImpact()) && totalGdpImpact != null && original.getTotalGdpImpact() != null && totalGdpImpact.compareTo(original.getTotalGdpImpact()) != 0)
        apiRequest.addVars("totalGdpImpact");
      if(!Objects.equals(economicOutputProjectionsDataset, original.getEconomicOutputProjectionsDataset()))
        apiRequest.addVars("economicOutputProjectionsDataset");
      if(!Objects.equals(cumulativeInvestmentChart, original.getCumulativeInvestmentChart()))
        apiRequest.addVars("cumulativeInvestmentChart");
      if(!Objects.equals(architectsPerYear, original.getArchitectsPerYear()))
        apiRequest.addVars("architectsPerYear");
      if(!Objects.equals(remoteDevelopersPerYear, original.getRemoteDevelopersPerYear()))
        apiRequest.addVars("remoteDevelopersPerYear");
      if(!Objects.equals(onsiteDevelopersPerYear, original.getOnsiteDevelopersPerYear()))
        apiRequest.addVars("onsiteDevelopersPerYear");
      if(!Objects.equals(instructorsPerYear, original.getInstructorsPerYear()))
        apiRequest.addVars("instructorsPerYear");
      if(!Objects.equals(remoteDeveloperPayPerYear, original.getRemoteDeveloperPayPerYear()) && remoteDeveloperPayPerYear != null && original.getRemoteDeveloperPayPerYear() != null && remoteDeveloperPayPerYear.compareTo(original.getRemoteDeveloperPayPerYear()) != 0)
        apiRequest.addVars("remoteDeveloperPayPerYear");
      if(!Objects.equals(onsiteDeveloperPayPerYear, original.getOnsiteDeveloperPayPerYear()) && onsiteDeveloperPayPerYear != null && original.getOnsiteDeveloperPayPerYear() != null && onsiteDeveloperPayPerYear.compareTo(original.getOnsiteDeveloperPayPerYear()) != 0)
        apiRequest.addVars("onsiteDeveloperPayPerYear");
      if(!Objects.equals(architectPayPerYear, original.getArchitectPayPerYear()) && architectPayPerYear != null && original.getArchitectPayPerYear() != null && architectPayPerYear.compareTo(original.getArchitectPayPerYear()) != 0)
        apiRequest.addVars("architectPayPerYear");
      if(!Objects.equals(instructorPayPerYear, original.getInstructorPayPerYear()) && instructorPayPerYear != null && original.getInstructorPayPerYear() != null && instructorPayPerYear.compareTo(original.getInstructorPayPerYear()) != 0)
        apiRequest.addVars("instructorPayPerYear");
      if(!Objects.equals(subscriptionsPerYear, original.getSubscriptionsPerYear()))
        apiRequest.addVars("subscriptionsPerYear");
      if(!Objects.equals(subscriptionCostsPerYear, original.getSubscriptionCostsPerYear()))
        apiRequest.addVars("subscriptionCostsPerYear");
      if(!Objects.equals(totalSubscriptionCostPerYear, original.getTotalSubscriptionCostPerYear()) && totalSubscriptionCostPerYear != null && original.getTotalSubscriptionCostPerYear() != null && totalSubscriptionCostPerYear.compareTo(original.getTotalSubscriptionCostPerYear()) != 0)
        apiRequest.addVars("totalSubscriptionCostPerYear");
      if(!Objects.equals(employeeSubscriptionCostsPerYear, original.getEmployeeSubscriptionCostsPerYear()))
        apiRequest.addVars("employeeSubscriptionCostsPerYear");
      if(!Objects.equals(employeesPerYearDataset, original.getEmployeesPerYearDataset()))
        apiRequest.addVars("employeesPerYearDataset");
      if(!Objects.equals(subscriptionCostsPerYearDataset, original.getSubscriptionCostsPerYearDataset()))
        apiRequest.addVars("subscriptionCostsPerYearDataset");
      if(!Objects.equals(employeesPerYearChart, original.getEmployeesPerYearChart()))
        apiRequest.addVars("employeesPerYearChart");
      if(!Objects.equals(openshiftControlPlaneNodes, original.getOpenshiftControlPlaneNodes()))
        apiRequest.addVars("openshiftControlPlaneNodes");
      if(!Objects.equals(openshiftControlPlaneCores, original.getOpenshiftControlPlaneCores()))
        apiRequest.addVars("openshiftControlPlaneCores");
      if(!Objects.equals(totalOpenshiftControlPlaneCores, original.getTotalOpenshiftControlPlaneCores()))
        apiRequest.addVars("totalOpenshiftControlPlaneCores");
      if(!Objects.equals(openshiftControlPlaneHourlyPricePerCore, original.getOpenshiftControlPlaneHourlyPricePerCore()) && openshiftControlPlaneHourlyPricePerCore != null && original.getOpenshiftControlPlaneHourlyPricePerCore() != null && openshiftControlPlaneHourlyPricePerCore.compareTo(original.getOpenshiftControlPlaneHourlyPricePerCore()) != 0)
        apiRequest.addVars("openshiftControlPlaneHourlyPricePerCore");
      if(!Objects.equals(openshiftInfraNodes, original.getOpenshiftInfraNodes()))
        apiRequest.addVars("openshiftInfraNodes");
      if(!Objects.equals(openshiftInfraCores, original.getOpenshiftInfraCores()))
        apiRequest.addVars("openshiftInfraCores");
      if(!Objects.equals(totalOpenshiftInfraCores, original.getTotalOpenshiftInfraCores()))
        apiRequest.addVars("totalOpenshiftInfraCores");
      if(!Objects.equals(openshiftInfraHourlyPricePerCore, original.getOpenshiftInfraHourlyPricePerCore()) && openshiftInfraHourlyPricePerCore != null && original.getOpenshiftInfraHourlyPricePerCore() != null && openshiftInfraHourlyPricePerCore.compareTo(original.getOpenshiftInfraHourlyPricePerCore()) != 0)
        apiRequest.addVars("openshiftInfraHourlyPricePerCore");
      if(!Objects.equals(openshiftWorkerNodes, original.getOpenshiftWorkerNodes()))
        apiRequest.addVars("openshiftWorkerNodes");
      if(!Objects.equals(openshiftWorkerCores, original.getOpenshiftWorkerCores()))
        apiRequest.addVars("openshiftWorkerCores");
      if(!Objects.equals(totalOpenshiftWorkerCores, original.getTotalOpenshiftWorkerCores()))
        apiRequest.addVars("totalOpenshiftWorkerCores");
      if(!Objects.equals(openshiftWorkerHourlyPricePerCore, original.getOpenshiftWorkerHourlyPricePerCore()) && openshiftWorkerHourlyPricePerCore != null && original.getOpenshiftWorkerHourlyPricePerCore() != null && openshiftWorkerHourlyPricePerCore.compareTo(original.getOpenshiftWorkerHourlyPricePerCore()) != 0)
        apiRequest.addVars("openshiftWorkerHourlyPricePerCore");
      if(!Objects.equals(openshiftSSDStorageTiBPerYear, original.getOpenshiftSSDStorageTiBPerYear()))
        apiRequest.addVars("openshiftSSDStorageTiBPerYear");
      if(!Objects.equals(openshiftSSDStoragePricePerGiB, original.getOpenshiftSSDStoragePricePerGiB()) && openshiftSSDStoragePricePerGiB != null && original.getOpenshiftSSDStoragePricePerGiB() != null && openshiftSSDStoragePricePerGiB.compareTo(original.getOpenshiftSSDStoragePricePerGiB()) != 0)
        apiRequest.addVars("openshiftSSDStoragePricePerGiB");
      if(!Objects.equals(openshiftCostsPerYearDataset, original.getOpenshiftCostsPerYearDataset()))
        apiRequest.addVars("openshiftCostsPerYearDataset");
      if(!Objects.equals(openshiftCostsPerYearChart, original.getOpenshiftCostsPerYearChart()))
        apiRequest.addVars("openshiftCostsPerYearChart");
      if(!Objects.equals(projectExpensesChart, original.getProjectExpensesChart()))
        apiRequest.addVars("projectExpensesChart");
      if(!Objects.equals(economicOutputChart, original.getEconomicOutputChart()))
        apiRequest.addVars("economicOutputChart");
      super.apiRequestBaseModel();
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(Optional.ofNullable(region).map(v -> "region: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(name).map(v -> "name: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(abbreviation).map(v -> "abbreviation: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(displayName).map(v -> "displayName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(contractId).map(v -> "contractId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(startDate).map(v -> "startDate: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(investmentYearsTotal).map(v -> "investmentYearsTotal: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(investmentYears).map(v -> "investmentYears: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(investmentsPerYear).map(v -> "investmentsPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(investmentsPerYearCumulative).map(v -> "investmentsPerYearCumulative: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(assetClasses).map(v -> "assetClasses: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(assetClassesTargetIrr).map(v -> "assetClassesTargetIrr: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(revenueStreams).map(v -> "revenueStreams: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(economicOutputProjections).map(v -> "economicOutputProjections: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(totalGdpImpact).map(v -> "totalGdpImpact: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(economicOutputProjectionsDataset).map(v -> "economicOutputProjectionsDataset: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(cumulativeInvestmentChart).map(v -> "cumulativeInvestmentChart: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(architectsPerYear).map(v -> "architectsPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(remoteDevelopersPerYear).map(v -> "remoteDevelopersPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(onsiteDevelopersPerYear).map(v -> "onsiteDevelopersPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(instructorsPerYear).map(v -> "instructorsPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(remoteDeveloperPayPerYear).map(v -> "remoteDeveloperPayPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(onsiteDeveloperPayPerYear).map(v -> "onsiteDeveloperPayPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(architectPayPerYear).map(v -> "architectPayPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(instructorPayPerYear).map(v -> "instructorPayPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(subscriptionsPerYear).map(v -> "subscriptionsPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(subscriptionCostsPerYear).map(v -> "subscriptionCostsPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(totalSubscriptionCostPerYear).map(v -> "totalSubscriptionCostPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(employeeSubscriptionCostsPerYear).map(v -> "employeeSubscriptionCostsPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(employeesPerYearDataset).map(v -> "employeesPerYearDataset: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(subscriptionCostsPerYearDataset).map(v -> "subscriptionCostsPerYearDataset: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(employeesPerYearChart).map(v -> "employeesPerYearChart: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftControlPlaneNodes).map(v -> "openshiftControlPlaneNodes: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftControlPlaneCores).map(v -> "openshiftControlPlaneCores: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(totalOpenshiftControlPlaneCores).map(v -> "totalOpenshiftControlPlaneCores: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftControlPlaneHourlyPricePerCore).map(v -> "openshiftControlPlaneHourlyPricePerCore: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftInfraNodes).map(v -> "openshiftInfraNodes: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftInfraCores).map(v -> "openshiftInfraCores: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(totalOpenshiftInfraCores).map(v -> "totalOpenshiftInfraCores: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftInfraHourlyPricePerCore).map(v -> "openshiftInfraHourlyPricePerCore: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftWorkerNodes).map(v -> "openshiftWorkerNodes: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftWorkerCores).map(v -> "openshiftWorkerCores: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(totalOpenshiftWorkerCores).map(v -> "totalOpenshiftWorkerCores: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftWorkerHourlyPricePerCore).map(v -> "openshiftWorkerHourlyPricePerCore: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftSSDStorageTiBPerYear).map(v -> "openshiftSSDStorageTiBPerYear: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftSSDStoragePricePerGiB).map(v -> "openshiftSSDStoragePricePerGiB: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftCostsPerYearDataset).map(v -> "openshiftCostsPerYearDataset: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(openshiftCostsPerYearChart).map(v -> "openshiftCostsPerYearChart: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(projectExpensesChart).map(v -> "projectExpensesChart: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(economicOutputChart).map(v -> "economicOutputChart: " + v + "\n").orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "Contract";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaeronautics.model.contract.Contract";
  public static final String CLASS_AUTH_RESOURCE = "CONTRACT";
  public static final String CLASS_API_ADDRESS_Contract = "smart-aeronautics-enUS-Contract";
  public static String getClassApiAddress() {
    return CLASS_API_ADDRESS_Contract;
  }
  public static final String VAR_region = "region";
  public static final String SET_region = "setRegion";
  public static final String VAR_name = "name";
  public static final String SET_name = "setName";
  public static final String VAR_abbreviation = "abbreviation";
  public static final String SET_abbreviation = "setAbbreviation";
  public static final String VAR_displayName = "displayName";
  public static final String SET_displayName = "setDisplayName";
  public static final String VAR_contractId = "contractId";
  public static final String SET_contractId = "setContractId";
  public static final String VAR_startDate = "startDate";
  public static final String SET_startDate = "setStartDate";
  public static final String VAR_investmentYearsTotal = "investmentYearsTotal";
  public static final String SET_investmentYearsTotal = "setInvestmentYearsTotal";
  public static final String VAR_investmentYears = "investmentYears";
  public static final String SET_investmentYears = "setInvestmentYears";
  public static final String VAR_investmentsPerYear = "investmentsPerYear";
  public static final String SET_investmentsPerYear = "setInvestmentsPerYear";
  public static final String VAR_investmentsPerYearCumulative = "investmentsPerYearCumulative";
  public static final String SET_investmentsPerYearCumulative = "setInvestmentsPerYearCumulative";
  public static final String VAR_assetClasses = "assetClasses";
  public static final String SET_assetClasses = "setAssetClasses";
  public static final String VAR_assetClassesTargetIrr = "assetClassesTargetIrr";
  public static final String SET_assetClassesTargetIrr = "setAssetClassesTargetIrr";
  public static final String VAR_revenueStreams = "revenueStreams";
  public static final String SET_revenueStreams = "setRevenueStreams";
  public static final String VAR_economicOutputProjections = "economicOutputProjections";
  public static final String SET_economicOutputProjections = "setEconomicOutputProjections";
  public static final String VAR_totalGdpImpact = "totalGdpImpact";
  public static final String SET_totalGdpImpact = "setTotalGdpImpact";
  public static final String VAR_economicOutputProjectionsDataset = "economicOutputProjectionsDataset";
  public static final String SET_economicOutputProjectionsDataset = "setEconomicOutputProjectionsDataset";
  public static final String VAR_cumulativeInvestmentChart = "cumulativeInvestmentChart";
  public static final String SET_cumulativeInvestmentChart = "setCumulativeInvestmentChart";
  public static final String VAR_architectsPerYear = "architectsPerYear";
  public static final String SET_architectsPerYear = "setArchitectsPerYear";
  public static final String VAR_remoteDevelopersPerYear = "remoteDevelopersPerYear";
  public static final String SET_remoteDevelopersPerYear = "setRemoteDevelopersPerYear";
  public static final String VAR_onsiteDevelopersPerYear = "onsiteDevelopersPerYear";
  public static final String SET_onsiteDevelopersPerYear = "setOnsiteDevelopersPerYear";
  public static final String VAR_instructorsPerYear = "instructorsPerYear";
  public static final String SET_instructorsPerYear = "setInstructorsPerYear";
  public static final String VAR_remoteDeveloperPayPerYear = "remoteDeveloperPayPerYear";
  public static final String SET_remoteDeveloperPayPerYear = "setRemoteDeveloperPayPerYear";
  public static final String VAR_onsiteDeveloperPayPerYear = "onsiteDeveloperPayPerYear";
  public static final String SET_onsiteDeveloperPayPerYear = "setOnsiteDeveloperPayPerYear";
  public static final String VAR_architectPayPerYear = "architectPayPerYear";
  public static final String SET_architectPayPerYear = "setArchitectPayPerYear";
  public static final String VAR_instructorPayPerYear = "instructorPayPerYear";
  public static final String SET_instructorPayPerYear = "setInstructorPayPerYear";
  public static final String VAR_subscriptionsPerYear = "subscriptionsPerYear";
  public static final String SET_subscriptionsPerYear = "setSubscriptionsPerYear";
  public static final String VAR_subscriptionCostsPerYear = "subscriptionCostsPerYear";
  public static final String SET_subscriptionCostsPerYear = "setSubscriptionCostsPerYear";
  public static final String VAR_totalSubscriptionCostPerYear = "totalSubscriptionCostPerYear";
  public static final String SET_totalSubscriptionCostPerYear = "setTotalSubscriptionCostPerYear";
  public static final String VAR_employeeSubscriptionCostsPerYear = "employeeSubscriptionCostsPerYear";
  public static final String SET_employeeSubscriptionCostsPerYear = "setEmployeeSubscriptionCostsPerYear";
  public static final String VAR_employeesPerYearDataset = "employeesPerYearDataset";
  public static final String SET_employeesPerYearDataset = "setEmployeesPerYearDataset";
  public static final String VAR_subscriptionCostsPerYearDataset = "subscriptionCostsPerYearDataset";
  public static final String SET_subscriptionCostsPerYearDataset = "setSubscriptionCostsPerYearDataset";
  public static final String VAR_employeesPerYearChart = "employeesPerYearChart";
  public static final String SET_employeesPerYearChart = "setEmployeesPerYearChart";
  public static final String VAR_openshiftControlPlaneNodes = "openshiftControlPlaneNodes";
  public static final String SET_openshiftControlPlaneNodes = "setOpenshiftControlPlaneNodes";
  public static final String VAR_openshiftControlPlaneCores = "openshiftControlPlaneCores";
  public static final String SET_openshiftControlPlaneCores = "setOpenshiftControlPlaneCores";
  public static final String VAR_totalOpenshiftControlPlaneCores = "totalOpenshiftControlPlaneCores";
  public static final String SET_totalOpenshiftControlPlaneCores = "setTotalOpenshiftControlPlaneCores";
  public static final String VAR_openshiftControlPlaneHourlyPricePerCore = "openshiftControlPlaneHourlyPricePerCore";
  public static final String SET_openshiftControlPlaneHourlyPricePerCore = "setOpenshiftControlPlaneHourlyPricePerCore";
  public static final String VAR_openshiftInfraNodes = "openshiftInfraNodes";
  public static final String SET_openshiftInfraNodes = "setOpenshiftInfraNodes";
  public static final String VAR_openshiftInfraCores = "openshiftInfraCores";
  public static final String SET_openshiftInfraCores = "setOpenshiftInfraCores";
  public static final String VAR_totalOpenshiftInfraCores = "totalOpenshiftInfraCores";
  public static final String SET_totalOpenshiftInfraCores = "setTotalOpenshiftInfraCores";
  public static final String VAR_openshiftInfraHourlyPricePerCore = "openshiftInfraHourlyPricePerCore";
  public static final String SET_openshiftInfraHourlyPricePerCore = "setOpenshiftInfraHourlyPricePerCore";
  public static final String VAR_openshiftWorkerNodes = "openshiftWorkerNodes";
  public static final String SET_openshiftWorkerNodes = "setOpenshiftWorkerNodes";
  public static final String VAR_openshiftWorkerCores = "openshiftWorkerCores";
  public static final String SET_openshiftWorkerCores = "setOpenshiftWorkerCores";
  public static final String VAR_totalOpenshiftWorkerCores = "totalOpenshiftWorkerCores";
  public static final String SET_totalOpenshiftWorkerCores = "setTotalOpenshiftWorkerCores";
  public static final String VAR_openshiftWorkerHourlyPricePerCore = "openshiftWorkerHourlyPricePerCore";
  public static final String SET_openshiftWorkerHourlyPricePerCore = "setOpenshiftWorkerHourlyPricePerCore";
  public static final String VAR_openshiftSSDStorageTiBPerYear = "openshiftSSDStorageTiBPerYear";
  public static final String SET_openshiftSSDStorageTiBPerYear = "setOpenshiftSSDStorageTiBPerYear";
  public static final String VAR_openshiftSSDStoragePricePerGiB = "openshiftSSDStoragePricePerGiB";
  public static final String SET_openshiftSSDStoragePricePerGiB = "setOpenshiftSSDStoragePricePerGiB";
  public static final String VAR_openshiftCostsPerYearDataset = "openshiftCostsPerYearDataset";
  public static final String SET_openshiftCostsPerYearDataset = "setOpenshiftCostsPerYearDataset";
  public static final String VAR_openshiftCostsPerYearChart = "openshiftCostsPerYearChart";
  public static final String SET_openshiftCostsPerYearChart = "setOpenshiftCostsPerYearChart";
  public static final String VAR_projectExpensesChart = "projectExpensesChart";
  public static final String SET_projectExpensesChart = "setProjectExpensesChart";
  public static final String VAR_economicOutputChart = "economicOutputChart";
  public static final String SET_economicOutputChart = "setEconomicOutputChart";

  public static List<String> varsQForClass() {
    return Contract.varsQContract(new ArrayList<String>());
  }
  public static List<String> varsQContract(List<String> vars) {
    BaseModel.varsQBaseModel(vars);
    return vars;
  }

  public static List<String> varsFqForClass() {
    return Contract.varsFqContract(new ArrayList<String>());
  }
  public static List<String> varsFqContract(List<String> vars) {
    vars.add(VAR_region);
    vars.add(VAR_name);
    vars.add(VAR_abbreviation);
    vars.add(VAR_contractId);
    BaseModel.varsFqBaseModel(vars);
    return vars;
  }

  public static List<String> varsRangeForClass() {
    return Contract.varsRangeContract(new ArrayList<String>());
  }
  public static List<String> varsRangeContract(List<String> vars) {
    BaseModel.varsRangeBaseModel(vars);
    return vars;
  }

  public static final String DISPLAY_NAME_region = "contract region";
  public static final String DISPLAY_NAME_name = "contract name";
  public static final String DISPLAY_NAME_abbreviation = "contract abbreviation";
  public static final String DISPLAY_NAME_displayName = "contract ID";
  public static final String DISPLAY_NAME_contractId = "contract ID";
  public static final String DISPLAY_NAME_startDate = "start date";
  public static final String DISPLAY_NAME_investmentYearsTotal = "investment years total";
  public static final String DISPLAY_NAME_investmentYears = "investment years";
  public static final String DISPLAY_NAME_investmentsPerYear = "investments per year";
  public static final String DISPLAY_NAME_investmentsPerYearCumulative = "cumulative investments per year";
  public static final String DISPLAY_NAME_assetClasses = "asset classes";
  public static final String DISPLAY_NAME_assetClassesTargetIrr = "target IRR";
  public static final String DISPLAY_NAME_revenueStreams = "revenue streams";
  public static final String DISPLAY_NAME_economicOutputProjections = "economic output projections";
  public static final String DISPLAY_NAME_totalGdpImpact = "total GDP impact";
  public static final String DISPLAY_NAME_economicOutputProjectionsDataset = "economic output projections";
  public static final String DISPLAY_NAME_cumulativeInvestmentChart = "cumulative investment per year";
  public static final String DISPLAY_NAME_architectsPerYear = "architects per year";
  public static final String DISPLAY_NAME_remoteDevelopersPerYear = "remote developers per year";
  public static final String DISPLAY_NAME_onsiteDevelopersPerYear = "onsite developers per year";
  public static final String DISPLAY_NAME_instructorsPerYear = "instructors per year";
  public static final String DISPLAY_NAME_remoteDeveloperPayPerYear = "remote developer pay per year";
  public static final String DISPLAY_NAME_onsiteDeveloperPayPerYear = "onsite developer pay per year";
  public static final String DISPLAY_NAME_architectPayPerYear = "architect pay per year";
  public static final String DISPLAY_NAME_instructorPayPerYear = "instructor pay per year";
  public static final String DISPLAY_NAME_subscriptionsPerYear = "employee subscriptions per year";
  public static final String DISPLAY_NAME_subscriptionCostsPerYear = "subscription costs per year";
  public static final String DISPLAY_NAME_totalSubscriptionCostPerYear = "subscription costs per year";
  public static final String DISPLAY_NAME_employeeSubscriptionCostsPerYear = "subscription costs per year";
  public static final String DISPLAY_NAME_employeesPerYearDataset = "employees per year dataset";
  public static final String DISPLAY_NAME_subscriptionCostsPerYearDataset = "subscription costs per year dataset";
  public static final String DISPLAY_NAME_employeesPerYearChart = "employees per year";
  public static final String DISPLAY_NAME_openshiftControlPlaneNodes = "OpenShift control plane nodes";
  public static final String DISPLAY_NAME_openshiftControlPlaneCores = "OpenShift control plane cores";
  public static final String DISPLAY_NAME_totalOpenshiftControlPlaneCores = "OpenShift control plane cores";
  public static final String DISPLAY_NAME_openshiftControlPlaneHourlyPricePerCore = "OpenShift control plane hourly price";
  public static final String DISPLAY_NAME_openshiftInfraNodes = "OpenShift infra nodes";
  public static final String DISPLAY_NAME_openshiftInfraCores = "OpenShift infra cores";
  public static final String DISPLAY_NAME_totalOpenshiftInfraCores = "Total OpenShift infra cores";
  public static final String DISPLAY_NAME_openshiftInfraHourlyPricePerCore = "OpenShift infra node hourly price";
  public static final String DISPLAY_NAME_openshiftWorkerNodes = "OpenShift worker nodes";
  public static final String DISPLAY_NAME_openshiftWorkerCores = "OpenShift worker cores";
  public static final String DISPLAY_NAME_totalOpenshiftWorkerCores = "OpenShift worker cores";
  public static final String DISPLAY_NAME_openshiftWorkerHourlyPricePerCore = "OpenShift worker node hourly price";
  public static final String DISPLAY_NAME_openshiftSSDStorageTiBPerYear = "OpenShift storage per year";
  public static final String DISPLAY_NAME_openshiftSSDStoragePricePerGiB = "OpenShift SSD storage price";
  public static final String DISPLAY_NAME_openshiftCostsPerYearDataset = "OpenShift costs per year dataset";
  public static final String DISPLAY_NAME_openshiftCostsPerYearChart = "OpenShift costs per year";
  public static final String DISPLAY_NAME_projectExpensesChart = "project expenses";
  public static final String DISPLAY_NAME_economicOutputChart = "economic output projections";

  @Override
  public String idForClass() {
    return contractId;
  }

  @Override
  public String titleForClass() {
    return objectTitle;
  }

  @Override
  public String nameForClass() {
    return displayName;
  }

  @Override
  public String classNameAdjectiveSingularForClass() {
    return Contract.NameAdjectiveSingular_enUS;
  }

  @Override
  public String enUSStringFormatUrlEditPageForClass() {
    return "%s/en-us/edit/contract/%s";
  }

  public static String varJson(String var, Boolean patch) {
    return Contract.varJsonContract(var, patch);
  }
  public static String varJsonContract(String var, Boolean patch) {
    switch(var) {
    case VAR_region:
      return patch ? SET_region : VAR_region;
    case VAR_name:
      return patch ? SET_name : VAR_name;
    case VAR_abbreviation:
      return patch ? SET_abbreviation : VAR_abbreviation;
    case VAR_displayName:
      return patch ? SET_displayName : VAR_displayName;
    case VAR_contractId:
      return patch ? SET_contractId : VAR_contractId;
    case VAR_startDate:
      return patch ? SET_startDate : VAR_startDate;
    case VAR_investmentYearsTotal:
      return patch ? SET_investmentYearsTotal : VAR_investmentYearsTotal;
    case VAR_investmentYears:
      return patch ? SET_investmentYears : VAR_investmentYears;
    case VAR_investmentsPerYear:
      return patch ? SET_investmentsPerYear : VAR_investmentsPerYear;
    case VAR_investmentsPerYearCumulative:
      return patch ? SET_investmentsPerYearCumulative : VAR_investmentsPerYearCumulative;
    case VAR_assetClasses:
      return patch ? SET_assetClasses : VAR_assetClasses;
    case VAR_assetClassesTargetIrr:
      return patch ? SET_assetClassesTargetIrr : VAR_assetClassesTargetIrr;
    case VAR_revenueStreams:
      return patch ? SET_revenueStreams : VAR_revenueStreams;
    case VAR_economicOutputProjections:
      return patch ? SET_economicOutputProjections : VAR_economicOutputProjections;
    case VAR_totalGdpImpact:
      return patch ? SET_totalGdpImpact : VAR_totalGdpImpact;
    case VAR_economicOutputProjectionsDataset:
      return patch ? SET_economicOutputProjectionsDataset : VAR_economicOutputProjectionsDataset;
    case VAR_cumulativeInvestmentChart:
      return patch ? SET_cumulativeInvestmentChart : VAR_cumulativeInvestmentChart;
    case VAR_architectsPerYear:
      return patch ? SET_architectsPerYear : VAR_architectsPerYear;
    case VAR_remoteDevelopersPerYear:
      return patch ? SET_remoteDevelopersPerYear : VAR_remoteDevelopersPerYear;
    case VAR_onsiteDevelopersPerYear:
      return patch ? SET_onsiteDevelopersPerYear : VAR_onsiteDevelopersPerYear;
    case VAR_instructorsPerYear:
      return patch ? SET_instructorsPerYear : VAR_instructorsPerYear;
    case VAR_remoteDeveloperPayPerYear:
      return patch ? SET_remoteDeveloperPayPerYear : VAR_remoteDeveloperPayPerYear;
    case VAR_onsiteDeveloperPayPerYear:
      return patch ? SET_onsiteDeveloperPayPerYear : VAR_onsiteDeveloperPayPerYear;
    case VAR_architectPayPerYear:
      return patch ? SET_architectPayPerYear : VAR_architectPayPerYear;
    case VAR_instructorPayPerYear:
      return patch ? SET_instructorPayPerYear : VAR_instructorPayPerYear;
    case VAR_subscriptionsPerYear:
      return patch ? SET_subscriptionsPerYear : VAR_subscriptionsPerYear;
    case VAR_subscriptionCostsPerYear:
      return patch ? SET_subscriptionCostsPerYear : VAR_subscriptionCostsPerYear;
    case VAR_totalSubscriptionCostPerYear:
      return patch ? SET_totalSubscriptionCostPerYear : VAR_totalSubscriptionCostPerYear;
    case VAR_employeeSubscriptionCostsPerYear:
      return patch ? SET_employeeSubscriptionCostsPerYear : VAR_employeeSubscriptionCostsPerYear;
    case VAR_employeesPerYearDataset:
      return patch ? SET_employeesPerYearDataset : VAR_employeesPerYearDataset;
    case VAR_subscriptionCostsPerYearDataset:
      return patch ? SET_subscriptionCostsPerYearDataset : VAR_subscriptionCostsPerYearDataset;
    case VAR_employeesPerYearChart:
      return patch ? SET_employeesPerYearChart : VAR_employeesPerYearChart;
    case VAR_openshiftControlPlaneNodes:
      return patch ? SET_openshiftControlPlaneNodes : VAR_openshiftControlPlaneNodes;
    case VAR_openshiftControlPlaneCores:
      return patch ? SET_openshiftControlPlaneCores : VAR_openshiftControlPlaneCores;
    case VAR_totalOpenshiftControlPlaneCores:
      return patch ? SET_totalOpenshiftControlPlaneCores : VAR_totalOpenshiftControlPlaneCores;
    case VAR_openshiftControlPlaneHourlyPricePerCore:
      return patch ? SET_openshiftControlPlaneHourlyPricePerCore : VAR_openshiftControlPlaneHourlyPricePerCore;
    case VAR_openshiftInfraNodes:
      return patch ? SET_openshiftInfraNodes : VAR_openshiftInfraNodes;
    case VAR_openshiftInfraCores:
      return patch ? SET_openshiftInfraCores : VAR_openshiftInfraCores;
    case VAR_totalOpenshiftInfraCores:
      return patch ? SET_totalOpenshiftInfraCores : VAR_totalOpenshiftInfraCores;
    case VAR_openshiftInfraHourlyPricePerCore:
      return patch ? SET_openshiftInfraHourlyPricePerCore : VAR_openshiftInfraHourlyPricePerCore;
    case VAR_openshiftWorkerNodes:
      return patch ? SET_openshiftWorkerNodes : VAR_openshiftWorkerNodes;
    case VAR_openshiftWorkerCores:
      return patch ? SET_openshiftWorkerCores : VAR_openshiftWorkerCores;
    case VAR_totalOpenshiftWorkerCores:
      return patch ? SET_totalOpenshiftWorkerCores : VAR_totalOpenshiftWorkerCores;
    case VAR_openshiftWorkerHourlyPricePerCore:
      return patch ? SET_openshiftWorkerHourlyPricePerCore : VAR_openshiftWorkerHourlyPricePerCore;
    case VAR_openshiftSSDStorageTiBPerYear:
      return patch ? SET_openshiftSSDStorageTiBPerYear : VAR_openshiftSSDStorageTiBPerYear;
    case VAR_openshiftSSDStoragePricePerGiB:
      return patch ? SET_openshiftSSDStoragePricePerGiB : VAR_openshiftSSDStoragePricePerGiB;
    case VAR_openshiftCostsPerYearDataset:
      return patch ? SET_openshiftCostsPerYearDataset : VAR_openshiftCostsPerYearDataset;
    case VAR_openshiftCostsPerYearChart:
      return patch ? SET_openshiftCostsPerYearChart : VAR_openshiftCostsPerYearChart;
    case VAR_projectExpensesChart:
      return patch ? SET_projectExpensesChart : VAR_projectExpensesChart;
    case VAR_economicOutputChart:
      return patch ? SET_economicOutputChart : VAR_economicOutputChart;
    default:
      return BaseModel.varJsonBaseModel(var, patch);
    }
  }

  public static String displayNameForClass(String var) {
    return Contract.displayNameContract(var);
  }
  public static String displayNameContract(String var) {
    switch(var) {
    case VAR_region:
      return DISPLAY_NAME_region;
    case VAR_name:
      return DISPLAY_NAME_name;
    case VAR_abbreviation:
      return DISPLAY_NAME_abbreviation;
    case VAR_displayName:
      return DISPLAY_NAME_displayName;
    case VAR_contractId:
      return DISPLAY_NAME_contractId;
    case VAR_startDate:
      return DISPLAY_NAME_startDate;
    case VAR_investmentYearsTotal:
      return DISPLAY_NAME_investmentYearsTotal;
    case VAR_investmentYears:
      return DISPLAY_NAME_investmentYears;
    case VAR_investmentsPerYear:
      return DISPLAY_NAME_investmentsPerYear;
    case VAR_investmentsPerYearCumulative:
      return DISPLAY_NAME_investmentsPerYearCumulative;
    case VAR_assetClasses:
      return DISPLAY_NAME_assetClasses;
    case VAR_assetClassesTargetIrr:
      return DISPLAY_NAME_assetClassesTargetIrr;
    case VAR_revenueStreams:
      return DISPLAY_NAME_revenueStreams;
    case VAR_economicOutputProjections:
      return DISPLAY_NAME_economicOutputProjections;
    case VAR_totalGdpImpact:
      return DISPLAY_NAME_totalGdpImpact;
    case VAR_economicOutputProjectionsDataset:
      return DISPLAY_NAME_economicOutputProjectionsDataset;
    case VAR_cumulativeInvestmentChart:
      return DISPLAY_NAME_cumulativeInvestmentChart;
    case VAR_architectsPerYear:
      return DISPLAY_NAME_architectsPerYear;
    case VAR_remoteDevelopersPerYear:
      return DISPLAY_NAME_remoteDevelopersPerYear;
    case VAR_onsiteDevelopersPerYear:
      return DISPLAY_NAME_onsiteDevelopersPerYear;
    case VAR_instructorsPerYear:
      return DISPLAY_NAME_instructorsPerYear;
    case VAR_remoteDeveloperPayPerYear:
      return DISPLAY_NAME_remoteDeveloperPayPerYear;
    case VAR_onsiteDeveloperPayPerYear:
      return DISPLAY_NAME_onsiteDeveloperPayPerYear;
    case VAR_architectPayPerYear:
      return DISPLAY_NAME_architectPayPerYear;
    case VAR_instructorPayPerYear:
      return DISPLAY_NAME_instructorPayPerYear;
    case VAR_subscriptionsPerYear:
      return DISPLAY_NAME_subscriptionsPerYear;
    case VAR_subscriptionCostsPerYear:
      return DISPLAY_NAME_subscriptionCostsPerYear;
    case VAR_totalSubscriptionCostPerYear:
      return DISPLAY_NAME_totalSubscriptionCostPerYear;
    case VAR_employeeSubscriptionCostsPerYear:
      return DISPLAY_NAME_employeeSubscriptionCostsPerYear;
    case VAR_employeesPerYearDataset:
      return DISPLAY_NAME_employeesPerYearDataset;
    case VAR_subscriptionCostsPerYearDataset:
      return DISPLAY_NAME_subscriptionCostsPerYearDataset;
    case VAR_employeesPerYearChart:
      return DISPLAY_NAME_employeesPerYearChart;
    case VAR_openshiftControlPlaneNodes:
      return DISPLAY_NAME_openshiftControlPlaneNodes;
    case VAR_openshiftControlPlaneCores:
      return DISPLAY_NAME_openshiftControlPlaneCores;
    case VAR_totalOpenshiftControlPlaneCores:
      return DISPLAY_NAME_totalOpenshiftControlPlaneCores;
    case VAR_openshiftControlPlaneHourlyPricePerCore:
      return DISPLAY_NAME_openshiftControlPlaneHourlyPricePerCore;
    case VAR_openshiftInfraNodes:
      return DISPLAY_NAME_openshiftInfraNodes;
    case VAR_openshiftInfraCores:
      return DISPLAY_NAME_openshiftInfraCores;
    case VAR_totalOpenshiftInfraCores:
      return DISPLAY_NAME_totalOpenshiftInfraCores;
    case VAR_openshiftInfraHourlyPricePerCore:
      return DISPLAY_NAME_openshiftInfraHourlyPricePerCore;
    case VAR_openshiftWorkerNodes:
      return DISPLAY_NAME_openshiftWorkerNodes;
    case VAR_openshiftWorkerCores:
      return DISPLAY_NAME_openshiftWorkerCores;
    case VAR_totalOpenshiftWorkerCores:
      return DISPLAY_NAME_totalOpenshiftWorkerCores;
    case VAR_openshiftWorkerHourlyPricePerCore:
      return DISPLAY_NAME_openshiftWorkerHourlyPricePerCore;
    case VAR_openshiftSSDStorageTiBPerYear:
      return DISPLAY_NAME_openshiftSSDStorageTiBPerYear;
    case VAR_openshiftSSDStoragePricePerGiB:
      return DISPLAY_NAME_openshiftSSDStoragePricePerGiB;
    case VAR_openshiftCostsPerYearDataset:
      return DISPLAY_NAME_openshiftCostsPerYearDataset;
    case VAR_openshiftCostsPerYearChart:
      return DISPLAY_NAME_openshiftCostsPerYearChart;
    case VAR_projectExpensesChart:
      return DISPLAY_NAME_projectExpensesChart;
    case VAR_economicOutputChart:
      return DISPLAY_NAME_economicOutputChart;
    default:
      return BaseModel.displayNameBaseModel(var);
    }
  }

  public static String descriptionContract(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_region:
      return "The region of this contract";
    case VAR_name:
      return "The name of this contract";
    case VAR_abbreviation:
      return "The abbreviation of this contract";
    case VAR_displayName:
      return "The ID of this contract";
    case VAR_contractId:
      return "The ID of this contract";
    case VAR_startDate:
      return "The start date of the contract";
    case VAR_investmentYearsTotal:
      return "The number of years of investment in the contract. ";
    case VAR_investmentYears:
      return "The years of investment in the contract. ";
    case VAR_investmentsPerYear:
      return "The amount of investment per year. ";
    case VAR_investmentsPerYearCumulative:
      return "The cumulative investment per year. ";
    case VAR_assetClasses:
      return "The asset classes of investment. ";
    case VAR_assetClassesTargetIrr:
      return "The targeted Internal Rate of Return per asset class. ";
    case VAR_revenueStreams:
      return "The revenue streams of investment. ";
    case VAR_economicOutputProjections:
      return "The economic output projections per revenue stream. ";
    case VAR_totalGdpImpact:
      return "The total GDP impact based on output projections per revenue stream. ";
    case VAR_economicOutputProjectionsDataset:
      return "The economic output projections per revenue stream. ";
    case VAR_cumulativeInvestmentChart:
      return "A chart of the cumulative investment per year. ";
    case VAR_architectsPerYear:
      return "The number of architects on the project per year. ";
    case VAR_remoteDevelopersPerYear:
      return "The number of remote developers on the project per year. ";
    case VAR_onsiteDevelopersPerYear:
      return "The number of onsite developers on the project per year. ";
    case VAR_instructorsPerYear:
      return "The number of instructors on the project per year. ";
    case VAR_remoteDeveloperPayPerYear:
      return "The total costs for paying a SPINE software developer on the project per year. ";
    case VAR_onsiteDeveloperPayPerYear:
      return "The total costs for paying a SPINE software developer on the project per year. ";
    case VAR_architectPayPerYear:
      return "The total costs for paying a SPINE software architect on the project per year. ";
    case VAR_instructorPayPerYear:
      return "The total costs for paying a SPINE instructor on the project per year. ";
    case VAR_subscriptionsPerYear:
      return "The software subscriptions for each employee per year. ";
    case VAR_subscriptionCostsPerYear:
      return "The individual software subscription costs per year. ";
    case VAR_totalSubscriptionCostPerYear:
      return "The individual software subscription costs per year. ";
    case VAR_employeeSubscriptionCostsPerYear:
      return "The individual software subscription costs per year. ";
    case VAR_employeesPerYearDataset:
      return "The chart data for employees per year. ";
    case VAR_subscriptionCostsPerYearDataset:
      return "The chart data for subscription costs per year. ";
    case VAR_employeesPerYearChart:
      return "A chart of the number of employees per year. ";
    case VAR_openshiftControlPlaneNodes:
      return "The total OpenShift control plane nodes";
    case VAR_openshiftControlPlaneCores:
      return "The number of OpenShift control plane cores per node";
    case VAR_totalOpenshiftControlPlaneCores:
      return "The total OpenShift control plane cores for all nodes";
    case VAR_openshiftControlPlaneHourlyPricePerCore:
      return "The hourly price of OpenShift control plane cores";
    case VAR_openshiftInfraNodes:
      return "The total OpenShift infra nodes";
    case VAR_openshiftInfraCores:
      return "The number of OpenShift infra cores per node";
    case VAR_totalOpenshiftInfraCores:
      return "The total OpenShift infra cores for all nodes";
    case VAR_openshiftInfraHourlyPricePerCore:
      return "The hourly price of OpenShift infra node cores";
    case VAR_openshiftWorkerNodes:
      return "The total OpenShift worker nodes";
    case VAR_openshiftWorkerCores:
      return "The number of OpenShift worker cores per node";
    case VAR_totalOpenshiftWorkerCores:
      return "The total OpenShift worker cores for all nodes";
    case VAR_openshiftWorkerHourlyPricePerCore:
      return "The hourly price of OpenShift worker node cores";
    case VAR_openshiftSSDStorageTiBPerYear:
      return "The amount of storage required for the OpenShift cluster in TiB. ";
    case VAR_openshiftSSDStoragePricePerGiB:
      return "The OpenShift SSD storage price per GiB. ";
    case VAR_openshiftCostsPerYearDataset:
      return "The chart data for OpenShift costs per year. ";
    case VAR_openshiftCostsPerYearChart:
      return "A chart of the OpenShift costs per year. ";
    case VAR_projectExpensesChart:
      return "A chart of the project expenses per year. ";
    case VAR_economicOutputChart:
      return "A chart of the economic output projections per year. ";
      default:
        return BaseModel.descriptionBaseModel(var);
    }
  }

  public static String classSimpleNameContract(String var) {
    switch(var) {
    case VAR_region:
      return "String";
    case VAR_name:
      return "String";
    case VAR_abbreviation:
      return "String";
    case VAR_displayName:
      return "String";
    case VAR_contractId:
      return "String";
    case VAR_startDate:
      return "ZonedDateTime";
    case VAR_investmentYearsTotal:
      return "Integer";
    case VAR_investmentYears:
      return "List";
    case VAR_investmentsPerYear:
      return "List";
    case VAR_investmentsPerYearCumulative:
      return "List";
    case VAR_assetClasses:
      return "List";
    case VAR_assetClassesTargetIrr:
      return "List";
    case VAR_revenueStreams:
      return "List";
    case VAR_economicOutputProjections:
      return "List";
    case VAR_totalGdpImpact:
      return "BigDecimal";
    case VAR_economicOutputProjectionsDataset:
      return "JsonArray";
    case VAR_cumulativeInvestmentChart:
      return "JsonObject";
    case VAR_architectsPerYear:
      return "List";
    case VAR_remoteDevelopersPerYear:
      return "List";
    case VAR_onsiteDevelopersPerYear:
      return "List";
    case VAR_instructorsPerYear:
      return "List";
    case VAR_remoteDeveloperPayPerYear:
      return "BigDecimal";
    case VAR_onsiteDeveloperPayPerYear:
      return "BigDecimal";
    case VAR_architectPayPerYear:
      return "BigDecimal";
    case VAR_instructorPayPerYear:
      return "BigDecimal";
    case VAR_subscriptionsPerYear:
      return "List";
    case VAR_subscriptionCostsPerYear:
      return "List";
    case VAR_totalSubscriptionCostPerYear:
      return "BigDecimal";
    case VAR_employeeSubscriptionCostsPerYear:
      return "List";
    case VAR_employeesPerYearDataset:
      return "JsonArray";
    case VAR_subscriptionCostsPerYearDataset:
      return "JsonArray";
    case VAR_employeesPerYearChart:
      return "JsonObject";
    case VAR_openshiftControlPlaneNodes:
      return "Integer";
    case VAR_openshiftControlPlaneCores:
      return "Integer";
    case VAR_totalOpenshiftControlPlaneCores:
      return "Integer";
    case VAR_openshiftControlPlaneHourlyPricePerCore:
      return "BigDecimal";
    case VAR_openshiftInfraNodes:
      return "Integer";
    case VAR_openshiftInfraCores:
      return "Integer";
    case VAR_totalOpenshiftInfraCores:
      return "Integer";
    case VAR_openshiftInfraHourlyPricePerCore:
      return "BigDecimal";
    case VAR_openshiftWorkerNodes:
      return "Integer";
    case VAR_openshiftWorkerCores:
      return "Integer";
    case VAR_totalOpenshiftWorkerCores:
      return "Integer";
    case VAR_openshiftWorkerHourlyPricePerCore:
      return "BigDecimal";
    case VAR_openshiftSSDStorageTiBPerYear:
      return "List";
    case VAR_openshiftSSDStoragePricePerGiB:
      return "BigDecimal";
    case VAR_openshiftCostsPerYearDataset:
      return "JsonArray";
    case VAR_openshiftCostsPerYearChart:
      return "JsonObject";
    case VAR_projectExpensesChart:
      return "JsonObject";
    case VAR_economicOutputChart:
      return "JsonObject";
      default:
        return BaseModel.classSimpleNameBaseModel(var);
    }
  }

  public static Integer htmColumnContract(String var) {
    switch(var) {
    case VAR_region:
      return 1;
    case VAR_name:
      return 2;
    case VAR_abbreviation:
      return 3;
    case VAR_startDate:
      return 1;
      default:
        return BaseModel.htmColumnBaseModel(var);
    }
  }

  public static Integer htmRowContract(String var) {
    switch(var) {
    case VAR_region:
      return 3;
    case VAR_name:
      return 3;
    case VAR_abbreviation:
      return 3;
    case VAR_startDate:
      return 3;
    case VAR_investmentYearsTotal:
      return 4;
    case VAR_investmentYears:
      return 4;
    case VAR_investmentsPerYear:
      return 4;
    case VAR_investmentsPerYearCumulative:
      return 4;
    case VAR_assetClasses:
      return 4;
    case VAR_assetClassesTargetIrr:
      return 4;
    case VAR_revenueStreams:
      return 4;
    case VAR_economicOutputProjections:
      return 4;
    case VAR_totalGdpImpact:
      return 4;
    case VAR_economicOutputProjectionsDataset:
      return 4;
    case VAR_cumulativeInvestmentChart:
      return 5;
    case VAR_architectsPerYear:
      return 6;
    case VAR_remoteDevelopersPerYear:
      return 6;
    case VAR_onsiteDevelopersPerYear:
      return 6;
    case VAR_instructorsPerYear:
      return 6;
    case VAR_remoteDeveloperPayPerYear:
      return 6;
    case VAR_onsiteDeveloperPayPerYear:
      return 6;
    case VAR_architectPayPerYear:
      return 6;
    case VAR_instructorPayPerYear:
      return 6;
    case VAR_subscriptionsPerYear:
      return 6;
    case VAR_subscriptionCostsPerYear:
      return 6;
    case VAR_totalSubscriptionCostPerYear:
      return 6;
    case VAR_employeeSubscriptionCostsPerYear:
      return 6;
    case VAR_employeesPerYearChart:
      return 7;
    case VAR_openshiftControlPlaneNodes:
      return 8;
    case VAR_openshiftControlPlaneCores:
      return 8;
    case VAR_openshiftControlPlaneHourlyPricePerCore:
      return 8;
    case VAR_openshiftInfraNodes:
      return 8;
    case VAR_openshiftInfraCores:
      return 8;
    case VAR_openshiftInfraHourlyPricePerCore:
      return 8;
    case VAR_openshiftWorkerNodes:
      return 8;
    case VAR_openshiftWorkerCores:
      return 8;
    case VAR_openshiftWorkerHourlyPricePerCore:
      return 8;
    case VAR_openshiftSSDStorageTiBPerYear:
      return 8;
    case VAR_openshiftSSDStoragePricePerGiB:
      return 8;
    case VAR_openshiftCostsPerYearChart:
      return 9;
    case VAR_projectExpensesChart:
      return 10;
    case VAR_economicOutputChart:
      return 11;
      default:
        return BaseModel.htmRowBaseModel(var);
    }
  }

  public static Integer htmCellContract(String var) {
    switch(var) {
    case VAR_region:
      return 1;
    case VAR_name:
      return 2;
    case VAR_abbreviation:
      return 3;
    case VAR_startDate:
      return 1;
    case VAR_investmentYearsTotal:
      return 0;
    case VAR_investmentYears:
      return 0;
    case VAR_investmentsPerYear:
      return 0;
    case VAR_investmentsPerYearCumulative:
      return 0;
    case VAR_assetClasses:
      return 0;
    case VAR_assetClassesTargetIrr:
      return 0;
    case VAR_revenueStreams:
      return 0;
    case VAR_economicOutputProjections:
      return 0;
    case VAR_totalGdpImpact:
      return 0;
    case VAR_economicOutputProjectionsDataset:
      return 0;
    case VAR_cumulativeInvestmentChart:
      return 0;
    case VAR_architectsPerYear:
      return 0;
    case VAR_remoteDevelopersPerYear:
      return 0;
    case VAR_onsiteDevelopersPerYear:
      return 0;
    case VAR_instructorsPerYear:
      return 0;
    case VAR_remoteDeveloperPayPerYear:
      return 0;
    case VAR_onsiteDeveloperPayPerYear:
      return 0;
    case VAR_architectPayPerYear:
      return 0;
    case VAR_instructorPayPerYear:
      return 0;
    case VAR_subscriptionsPerYear:
      return 0;
    case VAR_subscriptionCostsPerYear:
      return 0;
    case VAR_totalSubscriptionCostPerYear:
      return 0;
    case VAR_employeeSubscriptionCostsPerYear:
      return 0;
    case VAR_employeesPerYearChart:
      return 0;
    case VAR_openshiftControlPlaneNodes:
      return 0;
    case VAR_openshiftControlPlaneCores:
      return 0;
    case VAR_openshiftControlPlaneHourlyPricePerCore:
      return 0;
    case VAR_openshiftInfraNodes:
      return 0;
    case VAR_openshiftInfraCores:
      return 0;
    case VAR_openshiftInfraHourlyPricePerCore:
      return 0;
    case VAR_openshiftWorkerNodes:
      return 0;
    case VAR_openshiftWorkerCores:
      return 0;
    case VAR_openshiftWorkerHourlyPricePerCore:
      return 0;
    case VAR_openshiftSSDStorageTiBPerYear:
      return 0;
    case VAR_openshiftSSDStoragePricePerGiB:
      return 0;
    case VAR_openshiftCostsPerYearChart:
      return 0;
    case VAR_projectExpensesChart:
      return 0;
    case VAR_economicOutputChart:
      return 0;
      default:
        return BaseModel.htmCellBaseModel(var);
    }
  }

  public static Integer lengthMinContract(String var) {
    switch(var) {
      default:
        return BaseModel.lengthMinBaseModel(var);
    }
  }

  public static Integer lengthMaxContract(String var) {
    switch(var) {
      default:
        return BaseModel.lengthMaxBaseModel(var);
    }
  }

  public static Integer maxContract(String var) {
    switch(var) {
      default:
        return BaseModel.maxBaseModel(var);
    }
  }

  public static Integer minContract(String var) {
    switch(var) {
      default:
        return BaseModel.minBaseModel(var);
    }
  }
}
