package org.computate.smartaeronautics.model.contract;

import org.computate.smartaeronautics.model.contract.Contract;
import java.lang.String;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.lang.Integer;
import java.util.List;
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.computate.smartaeronautics.page.PageLayout;
import org.computate.smartaeronautics.request.SiteRequest;
import org.computate.smartaeronautics.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.wrap.Wrap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.Instant;
import io.vertx.ext.web.api.service.ServiceRequest;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;
import javax.measure.Quantity;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Objects;
import io.vertx.core.Promise;
import org.computate.smartaeronautics.config.ConfigKeys;
import org.computate.search.response.solr.SolrResponse;
import java.util.HashMap;
import org.computate.search.tool.TimeTool;
import org.computate.search.tool.SearchTool;
import java.time.ZoneId;
import io.vertx.pgclient.data.Point;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.computate.smartaeronautics.request.SiteRequest;
import org.computate.smartaeronautics.page.PageLayout;
import org.computate.smartaeronautics.model.BaseModel;
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
import org.computate.vertx.search.list.SearchList;
import org.computate.smartaeronautics.model.contract.Contract;
import java.lang.String;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import io.vertx.core.json.JsonObject;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.Integer;
import java.time.ZoneId;
import java.util.Locale;
import java.lang.Long;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.math.BigDecimal;
import javax.measure.Quantity;
import javax.measure.quantity.Angle;
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
import tech.units.indriya.format.SimpleUnitFormat;
import org.computate.vertx.tool.GeoTool;
import org.computate.vertx.serialize.unit.QuantitySerializer;
import org.computate.vertx.serialize.unit.QuantityDeserializer;
import io.vertx.core.json.JsonArray;
import org.computate.vertx.serialize.vertx.JsonArrayDeserializer;
import java.lang.Void;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li><p>
 *   You can add a class comment <kbd><b>Api: true</b></kbd> if you wish to GET, POST, PATCH or PUT these  objects in a RESTful API. 
 * </p>
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ContractGenPageGen into the class ContractGenPage. 
 * </li>
 * <h3>About the ContractGenPage class and it's generated class ContractGenPageGen&lt;PageLayout&gt;: </h3>extends ContractGenPageGen
 * <p>
 * This Java class extends a generated Java class ContractGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage">Find the class ContractGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ContractGenPageGen<PageLayout>
 * <p>This <code>class ContractGenPage extends ContractGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated ContractGenPageGen. 
 * The generated <code>class ContractGenPageGen extends PageLayout</code> which means that ContractGenPage extends ContractGenPageGen which extends PageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ContractGenPage class will inherit the helpful inherited class comments from the super class ContractGenPageGen. 
 * </p>
 * <h2>
 *   Rows: 10
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 10</b></kbd>, which means the  API will return a default of 10 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>
 *   You can add a class comment <kbd><b>Rows: 100</b></kbd> if you wish for the  API to return more or less than 10 results by default. 
 *   In this case, the API will return 100 results from the API instead of 10 by default. 
 *   Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 1
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 1</b></kbd>, 
 *   which means this class will be sorted by the given number 1 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <p>
 *   You can add a class comment <kbd><b>Order: </b></kbd>, followed by an Integer to sort this class compared to other classes in the project. 
 *   There is code that is generated that queries several classes and writes code for each class in a sequence. 
 *   The <kbd><b>Order</b></kbd> comment allows you to define which order the class code is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <kbd><b>Promise: true</b></kbd>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the ContractGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ContractGenPage in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class ContractGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(ContractGenPage.class);

	/////////////////////////
  // searchListContract_ //
	/////////////////////////


  /**
   *  The entity searchListContract_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<Contract> searchListContract_;

  /**
   * <br> The entity searchListContract_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:searchListContract_">Find the entity searchListContract_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListContract_(Wrap<SearchList<Contract>> w);

  public SearchList<Contract> getSearchListContract_() {
    return searchListContract_;
  }

  public void setSearchListContract_(SearchList<Contract> searchListContract_) {
    this.searchListContract_ = searchListContract_;
  }
  public static SearchList<Contract> staticSetSearchListContract_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected ContractGenPage searchListContract_Init() {
    Wrap<SearchList<Contract>> searchListContract_Wrap = new Wrap<SearchList<Contract>>().var("searchListContract_");
    if(searchListContract_ == null) {
      _searchListContract_(searchListContract_Wrap);
      Optional.ofNullable(searchListContract_Wrap.getO()).ifPresent(o -> {
        setSearchListContract_(o);
      });
    }
    return (ContractGenPage)this;
  }

	//////////////////
  // listContract //
	//////////////////


  /**
   *  The entity listContract
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listContract = new JsonArray();

  /**
   * <br> The entity listContract
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:listContract">Find the entity listContract in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listContract(JsonArray l);

  public JsonArray getListContract() {
    return listContract;
  }

  public void setListContract(JsonArray listContract) {
    this.listContract = listContract;
  }
  @JsonIgnore
  public void setListContract(String o) {
    this.listContract = ContractGenPage.staticSetListContract(siteRequest_, o);
  }
  public static JsonArray staticSetListContract(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected ContractGenPage listContractInit() {
    _listContract(listContract);
    return (ContractGenPage)this;
  }

  public static String staticSearchListContract(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListContract(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListContract(SiteRequest siteRequest_, String o) {
    return ContractGenPage.staticSearchListContract(siteRequest_, ContractGenPage.staticSetListContract(siteRequest_, o)).toString();
  }

	/////////////////
  // resultCount //
	/////////////////


  /**
   *  The entity resultCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer resultCount;

  /**
   * <br> The entity resultCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _resultCount(Wrap<Integer> w);

  public Integer getResultCount() {
    return resultCount;
  }

  public void setResultCount(Integer resultCount) {
    this.resultCount = resultCount;
  }
  @JsonIgnore
  public void setResultCount(String o) {
    this.resultCount = ContractGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ContractGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (ContractGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return ContractGenPage.staticSearchResultCount(siteRequest_, ContractGenPage.staticSetResultCount(siteRequest_, o)).toString();
  }

	////////////
  // result //
	////////////


  /**
   *  The entity result
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Contract result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<Contract> w);

  public Contract getResult() {
    return result;
  }

  public void setResult(Contract result) {
    this.result = result;
  }
  public static Contract staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected ContractGenPage resultInit() {
    Wrap<Contract> resultWrap = new Wrap<Contract>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (ContractGenPage)this;
  }

	////////
  // pk //
	////////


  /**
   *  The entity pk
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long pk;

  /**
   * <br> The entity pk
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pk(Wrap<Long> w);

  public Long getPk() {
    return pk;
  }

  public void setPk(Long pk) {
    this.pk = pk;
  }
  @JsonIgnore
  public void setPk(String o) {
    this.pk = ContractGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ContractGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (ContractGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return ContractGenPage.staticSearchPk(siteRequest_, ContractGenPage.staticSetPk(siteRequest_, o)).toString();
  }

	////////////
  // solrId //
	////////////


  /**
   *  The entity solrId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String solrId;

  /**
   * <br> The entity solrId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = ContractGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected ContractGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (ContractGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return ContractGenPage.staticSearchSolrId(siteRequest_, ContractGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	/////////////////////
  // pageUriContract //
	/////////////////////


  /**
   *  The entity pageUriContract
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriContract;

  /**
   * <br> The entity pageUriContract
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.contract.ContractGenPage&fq=entiteVar_enUS_indexed_string:pageUriContract">Find the entity pageUriContract in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriContract(Wrap<String> c);

  public String getPageUriContract() {
    return pageUriContract;
  }
  public void setPageUriContract(String o) {
    this.pageUriContract = ContractGenPage.staticSetPageUriContract(siteRequest_, o);
  }
  public static String staticSetPageUriContract(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected ContractGenPage pageUriContractInit() {
    Wrap<String> pageUriContractWrap = new Wrap<String>().var("pageUriContract");
    if(pageUriContract == null) {
      _pageUriContract(pageUriContractWrap);
      Optional.ofNullable(pageUriContractWrap.getO()).ifPresent(o -> {
        setPageUriContract(o);
      });
    }
    return (ContractGenPage)this;
  }

  public static String staticSearchPageUriContract(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriContract(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriContract(SiteRequest siteRequest_, String o) {
    return ContractGenPage.staticSearchPageUriContract(siteRequest_, ContractGenPage.staticSetPageUriContract(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<ContractGenPageGen<DEV>> promiseDeepContractGenPage(SiteRequest siteRequest_) {
    if(this.siteRequest_ == null)
      setSiteRequest_(siteRequest_);
    return promiseDeepContractGenPage();
  }

  public Future<ContractGenPageGen<DEV>> promiseDeepContractGenPage() {
    Promise<ContractGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseContractGenPage(promise2);
    promise2.future().onSuccess(a -> {
      super.promiseDeepPageLayout(siteRequest_).onSuccess(b -> {
        promise.complete(this);
      }).onFailure(ex -> {
        promise.fail(ex);
      });
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseContractGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListContract_Init();
        listContractInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriContractInit();
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

  @Override public Future<? extends ContractGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepContractGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestContractGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestContractGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainContractGenPage(v);
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
  public Object obtainContractGenPage(String var) {
    ContractGenPage oContractGenPage = (ContractGenPage)this;
    switch(var) {
      case "searchListContract_":
        return oContractGenPage.searchListContract_;
      case "listContract":
        return oContractGenPage.listContract;
      case "resultCount":
        return oContractGenPage.resultCount;
      case "result":
        return oContractGenPage.result;
      case "pk":
        return oContractGenPage.pk;
      case "solrId":
        return oContractGenPage.solrId;
      case "pageUriContract":
        return oContractGenPage.pageUriContract;
      default:
        return super.obtainPageLayout(var);
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
        o = relateContractGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateContractGenPage(String var, Object val) {
    ContractGenPage oContractGenPage = (ContractGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, ContractGenPage o) {
    return staticSetContractGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetContractGenPage(String entityVar, SiteRequest siteRequest_, String v, ContractGenPage o) {
    switch(entityVar) {
    case "listContract":
      return ContractGenPage.staticSetListContract(siteRequest_, v);
    case "resultCount":
      return ContractGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return ContractGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return ContractGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriContract":
      return ContractGenPage.staticSetPageUriContract(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchContractGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchContractGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listContract":
      return ContractGenPage.staticSearchListContract(siteRequest_, (JsonArray)o);
    case "resultCount":
      return ContractGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return ContractGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return ContractGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriContract":
      return ContractGenPage.staticSearchPageUriContract(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrContractGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrContractGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listContract":
      return ContractGenPage.staticSearchStrListContract(siteRequest_, (String)o);
    case "resultCount":
      return ContractGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return ContractGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return ContractGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriContract":
      return ContractGenPage.staticSearchStrPageUriContract(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqContractGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqContractGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listContract":
      return ContractGenPage.staticSearchFqListContract(siteRequest_, o);
    case "resultCount":
      return ContractGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return ContractGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return ContractGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriContract":
      return ContractGenPage.staticSearchFqPageUriContract(siteRequest_, o);
      default:
        return PageLayout.staticSearchFqPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "ContractGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaeronautics.model.contract.ContractGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListContract_ = "searchListContract_";
  public static final String SET_searchListContract_ = "setSearchListContract_";
  public static final String VAR_listContract = "listContract";
  public static final String SET_listContract = "setListContract";
  public static final String VAR_resultCount = "resultCount";
  public static final String SET_resultCount = "setResultCount";
  public static final String VAR_result = "result";
  public static final String SET_result = "setResult";
  public static final String VAR_pk = "pk";
  public static final String SET_pk = "setPk";
  public static final String VAR_solrId = "solrId";
  public static final String SET_solrId = "setSolrId";
  public static final String VAR_pageUriContract = "pageUriContract";
  public static final String SET_pageUriContract = "setPageUriContract";

  public static final String DISPLAY_NAME_searchListContract_ = "";
  public static final String DISPLAY_NAME_listContract = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriContract = "";

  public static String displayNameForClass(String var) {
    return ContractGenPage.displayNameContractGenPage(var);
  }
  public static String displayNameContractGenPage(String var) {
    switch(var) {
    case VAR_searchListContract_:
      return DISPLAY_NAME_searchListContract_;
    case VAR_listContract:
      return DISPLAY_NAME_listContract;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriContract:
      return DISPLAY_NAME_pageUriContract;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }
}
