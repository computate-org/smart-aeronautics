package org.computate.smartaeronautics.model.fiware.aircraft;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
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

/**
 * SmartDataModel: Aircraft - Aeronautics - SmartAeronautics
 * Fiware: true
 *
 * Order: 7
 * Description: Represent a generic aircraft
 * AName: an Aircraft
 * Icon: <i class="fa-duotone fa-regular  fa-conveyor-belt"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/aircraft
 * EditPageUri: /en-us/edit/aircraft/{entityShortId}
 * ApiUri: /en-us/api/aircraft
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   AircraftViewer:
 *     GET:
 *   AircraftEditor:
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
public class Aircraft extends AircraftGen<MapModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: time zone
   * DisplayName.frFR: fuseau horaire
   * Description.enUS: The local time zone the fishing trip departure and arrival dates are based on. 
   * Description.frFR: Le fuseau horaire local sur lequel sont basées les dates de départ et d'arrivée du voyage de pêche.
   * HtmRowTitleOpen.enUS: departure/arrival
   * HtmRowTitleOpen.frFR: départ/arrivée
   * HtmRow: 3
   * HtmCell: 0
   * Facet: true
   * Zone: true
   * Relate: TimeZone.id
   **/
  protected void _timeZone(Wrap<String> w) {
    w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: airport ID
   * Description.enUS: The primary airport of this aircraft. 
   * HtmRow: 3
   * HtmCell: 0
   * Relate: Airport.entityShortId
   * Facet: true
   **/
  protected void _airportId(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: departure date
   * DisplayName.frFR: date de départ
   * Description.enUS: The date and time the fishing trip departed. 
   * Description.frFR: La date et l'heure du départ du voyage de pêche.
   * HtmColumn: 1
   * HtmRow: 3
   * HtmCell: 1
   * Facet: true
   **/
  protected void _departureDate(Wrap<ZonedDateTime> w) {
    w.o(created);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: arrival date
   * DisplayName.frFR: date d'arrivée
   * Description.enUS: The date and time the fishing trip returned. 
   * Description.frFR: La date et l'heure du retour du voyage de pêche.
   * HtmColumn: 2
   * HtmRow: 3
   * HtmCell: 2
   * Facet: true
   **/
  protected void _arrivalDate(Wrap<ZonedDateTime> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: average speed (MPH)
   * DisplayName.frFR: vitesse moyenne (MPH)
   * Description.enUS: The average speed of the boat in miles per hour. 
   * Description.frFR: La vitesse moyenne du bateau en miles par heure. 
   * HtmColumn: 2
   * HtmRow: 3
   * HtmCell: 2
   * Facet: true
   **/
  protected void _avgSpeedInMph(Wrap<BigDecimal> w) {
  }

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
   * DisplayName: belongs to aircraft model
   * HtmRow: 3
   * HtmCell: 2
   * Facet: true
   **/
  protected void _belongsToAircraftModel(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: data provider
   * HtmRow: 3
   * HtmCell: 3
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
   * HtmCell: 4
   * Facet: true
   **/
  protected void _dateCreated(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: date issued
   * HtmRow: 3
   * HtmCell: 5
   * Facet: true
   **/
  protected void _dateIssued(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: date modified
   * HtmRow: 3
   * HtmCell: 6
   * Facet: true
   **/
  protected void _dateModified(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: heading
   * HtmRow: 3
   * HtmCell: 7
   * Facet: true
   **/
  protected void _heading(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: is on ground
   * HtmRow: 3
   * HtmCell: 8
   * Facet: true
   **/
  protected void _isOnGround(Wrap<Boolean> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: owner
   * HtmRow: 3
   * HtmCell: 9
   * Facet: true
   **/
  protected void _owner(Wrap<JsonObject> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: registration
   * HtmRow: 3
   * HtmCell: 10
   * Facet: true
   **/
  protected void _registration(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: see also
   * HtmRow: 3
   * HtmCell: 11
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
   * HtmCell: 12
   * Facet: true
   **/
  protected void _source(Wrap<String> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: speed
   * HtmRow: 3
   * HtmCell: 13
   * Facet: true
   **/
  protected void _speed(Wrap<BigDecimal> w) {
  }


  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: vertical speed
   * HtmRow: 3
   * HtmCell: 14
   * Facet: true
   **/
  protected void _verticalSpeed(Wrap<BigDecimal> w) {
  }

  /**
   * {@inheritDoc}
  
   * LocationColor: true
   * Indexed: true
   * Stored: true
   * DisplayName.enUS: area served colors
   * DisplayName.frFR: couleurs de la zone desservie
   * Description.enUS: The colors of each areaServed Paths. 
   * Description.frFR: Les couleurs de chaque chemin de la zone desservie.
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
   * Description.frFR: Les titres de chaque chemin de la zone desservie.
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
   * Description.frFR: Les liens de chaque chemin de la zone desservie.
   */
  protected void _areaServedLinks(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * FiwareType: geo:linestring
   * Area: true
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: path
   * DisplayName.frFR: chemin
   * Description.enUS: The geographic area where the boat goes fishing. 
   * Description.frFR: La zone géographique où le bateau va pêcher.
   * HtmRow: 3
   * HtmCell: 0
   * Facet: true
   **/
  protected void _path(Wrap<Path> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: simulation
   * DisplayName.frFR: simulation
   * Description.enUS: Toggle the digital twin simulation
   * Description.frFR: Basculer la simulation du jumeau numérique
   * HtmRow: 3
   * HtmCell: 1
   **/
  protected void _simulation(Wrap<Boolean> w) {
    w.o(false);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName.enUS: simulation delay in milliseconds
   * DisplayName.frFR: délai de simulation en millisecondes
   * Description.enUS: The number of milliseconds to asynchronously wait before the next update event is sent. 
   * Description.frFR: Le nombre de millisecondes à attendre de manière asynchrone avant l'envoi du prochain événement de mise à jour. 
   * HtmRow: 3
   * HtmCell: 2
   **/
  protected void _simulationDelayMillis(Wrap<Long> w) {
    w.o(499L);
  }

  @Override
  protected void _gltfPath(Wrap<String> w) {
    w.o(String.format("%s%s", siteRequest_.getConfig().getString(ConfigKeys.STATIC_BASE_URL), "/glb/aircraft/airplane.glb"));
  }
}

