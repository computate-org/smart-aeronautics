package org.computate.smartaeronautics.model.fiware.airport;

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
import org.computate.smartaeronautics.model.fiware.airport.Airport;
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
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class AirportGenPageGen into the class AirportGenPage. 
 * </li>
 * <h3>About the AirportGenPage class and it's generated class AirportGenPageGen&lt;PageLayout&gt;: </h3>extends AirportGenPageGen
 * <p>
 * This Java class extends a generated Java class AirportGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage">Find the class AirportGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends AirportGenPageGen<PageLayout>
 * <p>This <code>class AirportGenPage extends AirportGenPageGen&lt;PageLayout&gt;</code>, which means it extends a newly generated AirportGenPageGen. 
 * The generated <code>class AirportGenPageGen extends PageLayout</code> which means that AirportGenPage extends AirportGenPageGen which extends PageLayout. 
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
 * <p>By adding a class comment "{@inheritDoc}", the AirportGenPage class will inherit the helpful inherited class comments from the super class AirportGenPageGen. 
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
 *   This means that the AirportGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class AirportGenPage in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&lt;/query&gt;&lt;/delete&gt;'
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
public abstract class AirportGenPageGen<DEV> extends PageLayout {
  protected static final Logger LOG = LoggerFactory.getLogger(AirportGenPage.class);

	////////////////////////
  // searchListAirport_ //
	////////////////////////


  /**
   *  The entity searchListAirport_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected SearchList<Airport> searchListAirport_;

  /**
   * <br> The entity searchListAirport_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:searchListAirport_">Find the entity searchListAirport_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _searchListAirport_(Wrap<SearchList<Airport>> w);

  public SearchList<Airport> getSearchListAirport_() {
    return searchListAirport_;
  }

  public void setSearchListAirport_(SearchList<Airport> searchListAirport_) {
    this.searchListAirport_ = searchListAirport_;
  }
  public static SearchList<Airport> staticSetSearchListAirport_(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected AirportGenPage searchListAirport_Init() {
    Wrap<SearchList<Airport>> searchListAirport_Wrap = new Wrap<SearchList<Airport>>().var("searchListAirport_");
    if(searchListAirport_ == null) {
      _searchListAirport_(searchListAirport_Wrap);
      Optional.ofNullable(searchListAirport_Wrap.getO()).ifPresent(o -> {
        setSearchListAirport_(o);
      });
    }
    return (AirportGenPage)this;
  }

	/////////////////
  // listAirport //
	/////////////////


  /**
   *  The entity listAirport
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonArrayDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonArray listAirport = new JsonArray();

  /**
   * <br> The entity listAirport
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:listAirport">Find the entity listAirport in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _listAirport(JsonArray l);

  public JsonArray getListAirport() {
    return listAirport;
  }

  public void setListAirport(JsonArray listAirport) {
    this.listAirport = listAirport;
  }
  @JsonIgnore
  public void setListAirport(String o) {
    this.listAirport = AirportGenPage.staticSetListAirport(siteRequest_, o);
  }
  public static JsonArray staticSetListAirport(SiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonArray(o);
    }
    return null;
  }
  protected AirportGenPage listAirportInit() {
    _listAirport(listAirport);
    return (AirportGenPage)this;
  }

  public static String staticSearchListAirport(SiteRequest siteRequest_, JsonArray o) {
    return o.toString();
  }

  public static String staticSearchStrListAirport(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqListAirport(SiteRequest siteRequest_, String o) {
    return AirportGenPage.staticSearchListAirport(siteRequest_, AirportGenPage.staticSetListAirport(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:resultCount">Find the entity resultCount in Solr</a>
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
    this.resultCount = AirportGenPage.staticSetResultCount(siteRequest_, o);
  }
  public static Integer staticSetResultCount(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected AirportGenPage resultCountInit() {
    Wrap<Integer> resultCountWrap = new Wrap<Integer>().var("resultCount");
    if(resultCount == null) {
      _resultCount(resultCountWrap);
      Optional.ofNullable(resultCountWrap.getO()).ifPresent(o -> {
        setResultCount(o);
      });
    }
    return (AirportGenPage)this;
  }

  public static Integer staticSearchResultCount(SiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrResultCount(SiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqResultCount(SiteRequest siteRequest_, String o) {
    return AirportGenPage.staticSearchResultCount(siteRequest_, AirportGenPage.staticSetResultCount(siteRequest_, o)).toString();
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
  protected Airport result;

  /**
   * <br> The entity result
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:result">Find the entity result in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _result(Wrap<Airport> w);

  public Airport getResult() {
    return result;
  }

  public void setResult(Airport result) {
    this.result = result;
  }
  public static Airport staticSetResult(SiteRequest siteRequest_, String o) {
    return null;
  }
  protected AirportGenPage resultInit() {
    Wrap<Airport> resultWrap = new Wrap<Airport>().var("result");
    if(result == null) {
      _result(resultWrap);
      Optional.ofNullable(resultWrap.getO()).ifPresent(o -> {
        setResult(o);
      });
    }
    return (AirportGenPage)this;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
    this.pk = AirportGenPage.staticSetPk(siteRequest_, o);
  }
  public static Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected AirportGenPage pkInit() {
    Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
    if(pk == null) {
      _pk(pkWrap);
      Optional.ofNullable(pkWrap.getO()).ifPresent(o -> {
        setPk(o);
      });
    }
    return (AirportGenPage)this;
  }

  public static Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return AirportGenPage.staticSearchPk(siteRequest_, AirportGenPage.staticSetPk(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<String> w);

  public String getSolrId() {
    return solrId;
  }
  public void setSolrId(String o) {
    this.solrId = AirportGenPage.staticSetSolrId(siteRequest_, o);
  }
  public static String staticSetSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected AirportGenPage solrIdInit() {
    Wrap<String> solrIdWrap = new Wrap<String>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (AirportGenPage)this;
  }

  public static String staticSearchSolrId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(SiteRequest siteRequest_, String o) {
    return AirportGenPage.staticSearchSolrId(siteRequest_, AirportGenPage.staticSetSolrId(siteRequest_, o)).toString();
  }

	////////////////////
  // pageUriAirport //
	////////////////////


  /**
   *  The entity pageUriAirport
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUriAirport;

  /**
   * <br> The entity pageUriAirport
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.smartaeronautics.model.fiware.airport.AirportGenPage&fq=entiteVar_enUS_indexed_string:pageUriAirport">Find the entity pageUriAirport in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUriAirport(Wrap<String> c);

  public String getPageUriAirport() {
    return pageUriAirport;
  }
  public void setPageUriAirport(String o) {
    this.pageUriAirport = AirportGenPage.staticSetPageUriAirport(siteRequest_, o);
  }
  public static String staticSetPageUriAirport(SiteRequest siteRequest_, String o) {
    return o;
  }
  protected AirportGenPage pageUriAirportInit() {
    Wrap<String> pageUriAirportWrap = new Wrap<String>().var("pageUriAirport");
    if(pageUriAirport == null) {
      _pageUriAirport(pageUriAirportWrap);
      Optional.ofNullable(pageUriAirportWrap.getO()).ifPresent(o -> {
        setPageUriAirport(o);
      });
    }
    return (AirportGenPage)this;
  }

  public static String staticSearchPageUriAirport(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUriAirport(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUriAirport(SiteRequest siteRequest_, String o) {
    return AirportGenPage.staticSearchPageUriAirport(siteRequest_, AirportGenPage.staticSetPageUriAirport(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<AirportGenPageGen<DEV>> promiseDeepAirportGenPage(SiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepAirportGenPage();
  }

  public Future<AirportGenPageGen<DEV>> promiseDeepAirportGenPage() {
    Promise<AirportGenPageGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseAirportGenPage(promise2);
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

  public Future<Void> promiseAirportGenPage(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        searchListAirport_Init();
        listAirportInit();
        resultCountInit();
        resultInit();
        pkInit();
        solrIdInit();
        pageUriAirportInit();
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

  @Override public Future<? extends AirportGenPageGen<DEV>> promiseDeepForClass(SiteRequest siteRequest_) {
    return promiseDeepAirportGenPage(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestAirportGenPage(SiteRequest siteRequest_) {
      super.siteRequestPageLayout(siteRequest_);
  }

  public void siteRequestForClass(SiteRequest siteRequest_) {
    siteRequestAirportGenPage(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainAirportGenPage(v);
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
  public Object obtainAirportGenPage(String var) {
    AirportGenPage oAirportGenPage = (AirportGenPage)this;
    switch(var) {
      case "searchListAirport_":
        return oAirportGenPage.searchListAirport_;
      case "listAirport":
        return oAirportGenPage.listAirport;
      case "resultCount":
        return oAirportGenPage.resultCount;
      case "result":
        return oAirportGenPage.result;
      case "pk":
        return oAirportGenPage.pk;
      case "solrId":
        return oAirportGenPage.solrId;
      case "pageUriAirport":
        return oAirportGenPage.pageUriAirport;
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
        o = relateAirportGenPage(v, val);
      else if(o instanceof BaseModel) {
        BaseModel baseModel = (BaseModel)o;
        o = baseModel.relateForClass(v, val);
      }
    }
    return o != null;
  }
  public Object relateAirportGenPage(String var, Object val) {
    AirportGenPage oAirportGenPage = (AirportGenPage)this;
    switch(var) {
      default:
        return super.relatePageLayout(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, SiteRequest siteRequest_, String v, AirportGenPage o) {
    return staticSetAirportGenPage(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetAirportGenPage(String entityVar, SiteRequest siteRequest_, String v, AirportGenPage o) {
    switch(entityVar) {
    case "listAirport":
      return AirportGenPage.staticSetListAirport(siteRequest_, v);
    case "resultCount":
      return AirportGenPage.staticSetResultCount(siteRequest_, v);
    case "pk":
      return AirportGenPage.staticSetPk(siteRequest_, v);
    case "solrId":
      return AirportGenPage.staticSetSolrId(siteRequest_, v);
    case "pageUriAirport":
      return AirportGenPage.staticSetPageUriAirport(siteRequest_, v);
      default:
        return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, v, o);
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchAirportGenPage(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchAirportGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listAirport":
      return AirportGenPage.staticSearchListAirport(siteRequest_, (JsonArray)o);
    case "resultCount":
      return AirportGenPage.staticSearchResultCount(siteRequest_, (Integer)o);
    case "pk":
      return AirportGenPage.staticSearchPk(siteRequest_, (Long)o);
    case "solrId":
      return AirportGenPage.staticSearchSolrId(siteRequest_, (String)o);
    case "pageUriAirport":
      return AirportGenPage.staticSearchPageUriAirport(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchPageLayout(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, SiteRequest siteRequest_, Object o) {
    return staticSearchStrAirportGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrAirportGenPage(String entityVar, SiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "listAirport":
      return AirportGenPage.staticSearchStrListAirport(siteRequest_, (String)o);
    case "resultCount":
      return AirportGenPage.staticSearchStrResultCount(siteRequest_, (Integer)o);
    case "pk":
      return AirportGenPage.staticSearchStrPk(siteRequest_, (Long)o);
    case "solrId":
      return AirportGenPage.staticSearchStrSolrId(siteRequest_, (String)o);
    case "pageUriAirport":
      return AirportGenPage.staticSearchStrPageUriAirport(siteRequest_, (String)o);
      default:
        return PageLayout.staticSearchStrPageLayout(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqAirportGenPage(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqAirportGenPage(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "listAirport":
      return AirportGenPage.staticSearchFqListAirport(siteRequest_, o);
    case "resultCount":
      return AirportGenPage.staticSearchFqResultCount(siteRequest_, o);
    case "pk":
      return AirportGenPage.staticSearchFqPk(siteRequest_, o);
    case "solrId":
      return AirportGenPage.staticSearchFqSolrId(siteRequest_, o);
    case "pageUriAirport":
      return AirportGenPage.staticSearchFqPageUriAirport(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "AirportGenPage";
  public static final String CLASS_CANONICAL_NAME = "org.computate.smartaeronautics.model.fiware.airport.AirportGenPage";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_searchListAirport_ = "searchListAirport_";
  public static final String SET_searchListAirport_ = "setSearchListAirport_";
  public static final String VAR_listAirport = "listAirport";
  public static final String SET_listAirport = "setListAirport";
  public static final String VAR_resultCount = "resultCount";
  public static final String SET_resultCount = "setResultCount";
  public static final String VAR_result = "result";
  public static final String SET_result = "setResult";
  public static final String VAR_pk = "pk";
  public static final String SET_pk = "setPk";
  public static final String VAR_solrId = "solrId";
  public static final String SET_solrId = "setSolrId";
  public static final String VAR_pageUriAirport = "pageUriAirport";
  public static final String SET_pageUriAirport = "setPageUriAirport";

  public static final String DISPLAY_NAME_searchListAirport_ = "";
  public static final String DISPLAY_NAME_listAirport = "";
  public static final String DISPLAY_NAME_resultCount = "";
  public static final String DISPLAY_NAME_result = "";
  public static final String DISPLAY_NAME_pk = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_pageUriAirport = "";

  public static String displayNameForClass(String var) {
    return AirportGenPage.displayNameAirportGenPage(var);
  }
  public static String displayNameAirportGenPage(String var) {
    switch(var) {
    case VAR_searchListAirport_:
      return DISPLAY_NAME_searchListAirport_;
    case VAR_listAirport:
      return DISPLAY_NAME_listAirport;
    case VAR_resultCount:
      return DISPLAY_NAME_resultCount;
    case VAR_result:
      return DISPLAY_NAME_result;
    case VAR_pk:
      return DISPLAY_NAME_pk;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_pageUriAirport:
      return DISPLAY_NAME_pageUriAirport;
    default:
      return PageLayout.displayNamePageLayout(var);
    }
  }
}
