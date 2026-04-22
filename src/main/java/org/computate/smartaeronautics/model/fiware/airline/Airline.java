package org.computate.smartaeronautics.model.fiware.airline;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.smartaeronautics.model.MapModel;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * SmartDataModel: Airline - Aeronautics - SmartAeronautics
 * Fiware: true
 *
 * Order: 6
 * Description: A description of a generic airline
 * AName: an Airline
 * Icon: <i class="fa-duotone fa-regular  fa-conveyor-belt"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/airline
 * EditPageUri: /en-us/edit/airline/{entityShortId}
 * ApiUri: /en-us/api/airline
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   AirlineViewer:
 *     GET:
 *   AirlineEditor:
 *     GET:
 *     POST:
 *     PATCH:
 *   SuperAdmin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     SuperAdmin:
 *     Admin:
 *   Admin:
 *     POST:
 *     PATCH:
 *     GET:
 *     PUT:
 *     DELETE:
 *     Admin:
 **/
public class Airline extends AirlineGen<MapModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: address
   * HtmRow: 3
   * HtmCell: 0
   * Facet: true
   **/
  protected void _address(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: alternate name
   * HtmRow: 3
   * HtmCell: 1
   * Facet: true
   **/
  protected void _alternateName(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: call sign
   * HtmRow: 3
   * HtmCell: 2
   * Facet: true
   **/
  protected void _callSign(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: code iata
   * HtmRow: 3
   * HtmCell: 3
   * Facet: true
   **/
  protected void _codeIATA(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: code icao
   * HtmRow: 3
   * HtmCell: 4
   * Facet: true
   **/
  protected void _codeICAO(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: data provider
   * HtmRow: 3
   * HtmCell: 5
   * Facet: true
   **/
  protected void _dataProvider(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: date created
   * HtmRow: 3
   * HtmCell: 6
   * Facet: true
   **/
  protected void _dateCreated(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: date modified
   * HtmRow: 3
   * HtmCell: 7
   * Facet: true
   **/
  protected void _dateModified(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: owner
   * HtmRow: 3
   * HtmCell: 8
   * Facet: true
   **/
  protected void _owner(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: see also
   * HtmRow: 3
   * HtmCell: 9
   * Facet: true
   **/
  protected void _seeAlso(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: source
   * HtmRow: 3
   * HtmCell: 10
   * Facet: true
   **/
  protected void _source(Wrap<String> w) {
  }

}

