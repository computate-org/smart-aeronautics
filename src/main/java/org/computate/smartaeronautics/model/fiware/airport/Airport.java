package org.computate.smartaeronautics.model.fiware.airport;

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
 * SmartDataModel: Airport - Aeronautics - SmartAeronautics
 * Fiware: true
 *
 * Order: 5
 * Description: A description of a generic airport
 * AName: an Airport
 * Icon: <i class="fa-duotone fa-regular  fa-conveyor-belt"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/airport
 * EditPageUri: /en-us/edit/airport/{entityShortId}
 * ApiUri: /en-us/api/airport
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   AirportViewer:
 *     GET:
 *   AirportEditor:
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
public class Airport extends AirportGen<MapModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: address
   * HtmRow: 6
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
   * HtmRow: 6
   * HtmCell: 1
   * Facet: true
   **/
  protected void _alternateName(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: code iata
   * HtmRow: 6
   * HtmCell: 2
   * Facet: true
   **/
  protected void _codeIATA(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: code icao
   * HtmRow: 6
   * HtmCell: 3
   * Facet: true
   **/
  protected void _codeICAO(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: data provider
   * HtmRow: 6
   * HtmCell: 4
   * Facet: true
   **/
  protected void _dataProvider(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: date created
   * HtmRow: 6
   * HtmCell: 5
   * Facet: true
   **/
  protected void _dateCreated(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: date modified
   * HtmRow: 6
   * HtmCell: 6
   * Facet: true
   **/
  protected void _dateModified(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: owner
   * HtmRow: 6
   * HtmCell: 7
   * Facet: true
   **/
  protected void _owner(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: see also
   * HtmRow: 6
   * HtmCell: 8
   * Facet: true
   **/
  protected void _seeAlso(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: source
   * HtmRow: 6
   * HtmCell: 9
   * Facet: true
   **/
  protected void _source(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
  
   * LocationColor: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served colors
   * DisplayName.frFR: couleurs de la zone desservie
   * Description.enUS: The colors of each areaServed Paths. 
   * Description.frFR: Les couleurs de chaque chemin de zone desservie.
   */
  protected void _areaServedColors(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * LocationTitle: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served titles
   * DisplayName.frFR: titres de la zone desservie
   * Description.enUS: The titles of each areaServed Paths. 
   * Description.frFR: Les titres de chaque chemin de zone desservie.
   */
  protected void _areaServedTitles(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * LocationUrl: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served links
   * DisplayName.frFR: liens de la zone desservie
   * Description.enUS: The links of each areaServed Paths. 
   * Description.frFR: Les liens de chaque chemin de zone desservie.
   */
  protected void _areaServedLinks(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * FiwareType: geo:linestring
   * Area: true
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: area served
   * DisplayName.frFR: zone desservie
   * Description.enUS: The geographic area where a service or offered item is provided
   * Description.frFR: La zone géographique où un service ou un article proposé est fourni
   * HtmRow: 4
   * HtmCell: 4
   * Facet: true
   **/
  protected void _areaServed(List<Polygon> l) {
  }
}

