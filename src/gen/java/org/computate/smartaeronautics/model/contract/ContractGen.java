package org.computate.smartaeronautics.model.contract;

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
      return 4;
    case VAR_economicOutputChart:
      return 4;
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
