package org.computate.smartaeronautics.model.fiware.airport;

import org.computate.smartaeronautics.request.SiteRequest;
import org.computate.smartaeronautics.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.computate.smartaeronautics.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import com.hubspot.jinjava.Jinjava;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.computate.search.response.solr.SolrResponse.StatsField;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import java.nio.file.Path;
import java.nio.file.Files;
import com.google.common.io.Resources;
import java.nio.charset.StandardCharsets;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import org.computate.i18n.I18n;
import org.yaml.snakeyaml.Yaml;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpResponseExpectation;
import java.nio.charset.Charset;
import io.vertx.ext.auth.authorization.RoleBasedAuthorization;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.HttpResponse;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map.Entry;
import java.util.Iterator;
import org.computate.search.tool.SearchTool;
import org.computate.search.response.solr.SolrResponse;
import java.util.Base64;
import java.time.ZonedDateTime;
import org.apache.commons.lang3.BooleanUtils;
import org.computate.vertx.search.list.SearchList;
import org.computate.smartaeronautics.model.fiware.airport.AirportPage;


/**
 * Translate: false
 * Generated: true
 **/
public class AirportEnUSGenApiServiceImpl extends BaseApiServiceImpl implements AirportEnUSGenApiService {

  protected static final Logger LOG = LoggerFactory.getLogger(AirportEnUSGenApiServiceImpl.class);

  // Search //

  @Override
  public void searchAirport(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, false, "GET").onSuccess(listAirport -> {
                response200SearchAirport(listAirport).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchAirport succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("searchAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200SearchAirport(SearchList<Airport> listAirport) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
      List<String> fls = listAirport.getRequest().getFields();
      JsonObject json = new JsonObject();
      JsonArray l = new JsonArray();
      List<String> scopes = siteRequest.getScopes();
      listAirport.getList().stream().forEach(o -> {
        JsonObject json2 = JsonObject.mapFrom(o);
        if(fls.size() > 0) {
          Set<String> fieldNames = new HashSet<String>();
          for(String fieldName : json2.fieldNames()) {
            String v = Airport.varIndexedAirport(fieldName);
            if(v != null)
              fieldNames.add(Airport.varIndexedAirport(fieldName));
          }
          if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
            fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
            fieldNames.remove("pk_docvalues_long");
            fieldNames.remove("created_docvalues_date");
          }
          else if(fls.size() >= 1) {
            fieldNames.removeAll(fls);
          }
          for(String fieldName : fieldNames) {
            if(!fls.contains(fieldName))
              json2.remove(fieldName);
          }
        }
        l.add(json2);
      });
      json.put("list", l);
      response200Search(listAirport.getRequest(), listAirport.getResponse(), json);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchAirport(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
    if(pivots != null) {
      for(SolrResponse.Pivot pivotField : pivots) {
        String entityIndexed = pivotField.getField();
        String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
        JsonObject pivotJson = new JsonObject();
        pivotArray.add(pivotJson);
        pivotJson.put("field", entityVar);
        pivotJson.put("value", pivotField.getValue());
        pivotJson.put("count", pivotField.getCount());
        Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
        List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
        if(pivotRanges != null) {
          JsonObject rangeJson = new JsonObject();
          pivotJson.put("ranges", rangeJson);
          for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
            rangeJson.put(rangeFacetVar, rangeFacetJson);
            JsonObject rangeFacetCountsObject = new JsonObject();
            rangeFacetJson.put("counts", rangeFacetCountsObject);
            rangeFacet.getCounts().forEach((value, count) -> {
              rangeFacetCountsObject.put(value, count);
            });
          }
        }
        if(pivotFields2 != null) {
          JsonArray pivotArray2 = new JsonArray();
          pivotJson.put("pivot", pivotArray2);
          responsePivotSearchAirport(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // GET //

  @Override
  public void getAirport(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, false, "GET").onSuccess(listAirport -> {
                response200GETAirport(listAirport).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("getAirport succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("getAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("getAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("getAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("getAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("getAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("getAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200GETAirport(SearchList<Airport> listAirport) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
      JsonObject json = JsonObject.mapFrom(listAirport.getList().stream().findFirst().orElse(null));
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200GETAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PATCH //

  @Override
  public void patchAirport(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("patchAirport started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "PATCH"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("PATCH")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, true, "PATCH").onSuccess(listAirport -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listAirport.getRequest().getRows());
                  apiRequest.setNumFound(listAirport.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listAirport.first());
                  apiRequest.setId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
                  apiRequest.setSolrId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getSolrId()).orElse(null));
                  eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());

                  listPATCHAirport(apiRequest, listAirport).onSuccess(e -> {
                    response200PATCHAirport(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("patchAirport succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("patchAirport failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("patchAirport failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("patchAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("patchAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("patchAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("patchAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPATCHAirport(ApiRequest apiRequest, SearchList<Airport> listAirport) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
    listAirport.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      Airport o2 = jsonObject.mapTo(Airport.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        patchAirportFuture(o2, false).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listPATCHAirport failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAirport.next().onSuccess(next -> {
        if(next) {
          listPATCHAirport(apiRequest, listAirport).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPATCHAirport failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listPATCHAirport failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listPATCHAirport failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void patchAirportFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchAirportList(siteRequest, false, true, true, "PATCH").onSuccess(listAirport -> {
          try {
            Airport o = listAirport.first();
            ApiRequest apiRequest = new ApiRequest();
            apiRequest.setRows(1L);
            apiRequest.setNumFound(1L);
            apiRequest.setNumPATCH(0L);
            apiRequest.initDeepApiRequest(siteRequest);
            siteRequest.setApiRequest_(apiRequest);
            if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
              siteRequest.getRequestVars().put( "refresh", "false" );
            }
            Airport o2;
            if(o != null) {
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAirport.first()).map(o3 -> o3.getEntityShortId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listAirport.first()).map(o3 -> o3.getSolrId()).orElse(null));
              JsonObject jsonObject = JsonObject.mapFrom(o);
              o2 = jsonObject.mapTo(Airport.class);
              o2.setSiteRequest_(siteRequest);
              patchAirportFuture(o2, false).onSuccess(o3 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              String m = String.format("%s %s not found", "Airport", null);
              eventHandler.handle(Future.failedFuture(m));
            }
          } catch(Exception ex) {
            LOG.error(String.format("patchAirport failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("patchAirport failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("patchAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("patchAirport failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<Airport> patchAirportFuture(Airport o, Boolean inheritPrimaryKey) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<Airport> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<Airport> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsAirport(siteRequest).onSuccess(a -> {
          JsonObject jsonObject = o.getSiteRequest_().getJsonObject();
          if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
            ngsildGetEntity(o).compose(ngsildData -> {
              Promise<JsonObject> promise2 = Promise.promise();
              if(ngsildData == null) {
                promise2.complete(jsonObject);
              } else {
                String setNgsildData = String.format("set%s",StringUtils.capitalize(Airport.VAR_ngsildData));
                jsonObject.put(setNgsildData, ngsildData);
                promise2.complete(jsonObject);
              }
              return promise2.future();
            }).compose(ngsildData -> {
              Promise<Airport> promise2 = Promise.promise();
              sqlPATCHAirport(o, inheritPrimaryKey).onSuccess(airport -> {
                persistAirport(airport, true).onSuccess(c -> {
                  relateAirport(airport).onSuccess(d -> {
                    indexAirport(airport).onSuccess(o2 -> {
                      if(apiRequest != null) {
                        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                        if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                          o2.apiRequestAirport();
                          if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                            eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
                        }
                      }
                      promise2.complete(airport);
                    }).onFailure(ex -> {
                      promise2.tryFail(ex);
                    });
                  }).onFailure(ex -> {
                    promise2.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise2.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise2.tryFail(ex);
              });
              return promise2.future();
            }).onSuccess(o2 -> {
              promise1.complete(o2);
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          } else {
            sqlPATCHAirport(o, inheritPrimaryKey).onSuccess(airport -> {
              persistAirport(airport, true).onSuccess(c -> {
                relateAirport(airport).onSuccess(d -> {
                  indexAirport(airport).onSuccess(o2 -> {
                    if(apiRequest != null) {
                      apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                      if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                        o2.apiRequestAirport();
                        if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                          eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
                      }
                    }
                    promise1.complete(airport);
                  }).onFailure(ex -> {
                    promise1.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise1.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(airport -> {
        Promise<Airport> promise2 = Promise.promise();
        refreshAirport(airport).onSuccess(a -> {
          promise2.complete(airport);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(airport -> {
        promise.complete(airport);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("patchAirportFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Airport> sqlPATCHAirport(Airport o, Boolean inheritPrimaryKey) {
    Promise<Airport> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE Airport SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Set<String> methodNames = jsonObject.fieldNames();
      Airport o2 = new Airport();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      for(String entityVar : methodNames) {
        switch(entityVar) {
          case "setName":
              o2.setName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_name + "=$" + num);
              num++;
              bParams.add(o2.sqlName());
            break;
          case "setAddress":
              o2.setAddress(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_address + "=$" + num);
              num++;
              bParams.add(o2.sqlAddress());
            break;
          case "setDescription":
              o2.setDescription(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_description + "=$" + num);
              num++;
              bParams.add(o2.sqlDescription());
            break;
          case "setAlternateName":
              o2.setAlternateName(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_alternateName + "=$" + num);
              num++;
              bParams.add(o2.sqlAlternateName());
            break;
          case "setCreated":
              o2.setCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_created + "=$" + num);
              num++;
              bParams.add(o2.sqlCreated());
            break;
          case "setLocation":
              o2.setLocation(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_location + "=$" + num);
              num++;
              bParams.add(o2.sqlLocation());
            break;
          case "setCodeIATA":
              o2.setCodeIATA(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_codeIATA + "=$" + num);
              num++;
              bParams.add(o2.sqlCodeIATA());
            break;
          case "setId":
              o2.setId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_id + "=$" + num);
              num++;
              bParams.add(o2.sqlId());
            break;
          case "setCodeICAO":
              o2.setCodeICAO(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_codeICAO + "=$" + num);
              num++;
              bParams.add(o2.sqlCodeICAO());
            break;
          case "setArchived":
              o2.setArchived(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_archived + "=$" + num);
              num++;
              bParams.add(o2.sqlArchived());
            break;
          case "setEntityShortId":
              o2.setEntityShortId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_entityShortId + "=$" + num);
              num++;
              bParams.add(o2.sqlEntityShortId());
            break;
          case "setDataProvider":
              o2.setDataProvider(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_dataProvider + "=$" + num);
              num++;
              bParams.add(o2.sqlDataProvider());
            break;
          case "setNgsildTenant":
              o2.setNgsildTenant(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_ngsildTenant + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildTenant());
            break;
          case "setDateCreated":
              o2.setDateCreated(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_dateCreated + "=$" + num);
              num++;
              bParams.add(o2.sqlDateCreated());
            break;
          case "setNgsildPath":
              o2.setNgsildPath(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_ngsildPath + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildPath());
            break;
          case "setDateModified":
              o2.setDateModified(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_dateModified + "=$" + num);
              num++;
              bParams.add(o2.sqlDateModified());
            break;
          case "setNgsildContext":
              o2.setNgsildContext(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_ngsildContext + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildContext());
            break;
          case "setOwner":
              o2.setOwner(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_owner + "=$" + num);
              num++;
              bParams.add(o2.sqlOwner());
            break;
          case "setSessionId":
              o2.setSessionId(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_sessionId + "=$" + num);
              num++;
              bParams.add(o2.sqlSessionId());
            break;
          case "setNgsildData":
              o2.setNgsildData(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_ngsildData + "=$" + num);
              num++;
              bParams.add(o2.sqlNgsildData());
            break;
          case "setSeeAlso":
              o2.setSeeAlso(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_seeAlso + "=$" + num);
              num++;
              bParams.add(o2.sqlSeeAlso());
            break;
          case "setUserKey":
              o2.setUserKey(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_userKey + "=$" + num);
              num++;
              bParams.add(o2.sqlUserKey());
            break;
          case "setColor":
              o2.setColor(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_color + "=$" + num);
              num++;
              bParams.add(o2.sqlColor());
            break;
          case "setSource":
              o2.setSource(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_source + "=$" + num);
              num++;
              bParams.add(o2.sqlSource());
            break;
          case "setObjectTitle":
              o2.setObjectTitle(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_objectTitle + "=$" + num);
              num++;
              bParams.add(o2.sqlObjectTitle());
            break;
          case "setDisplayPage":
              o2.setDisplayPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_displayPage + "=$" + num);
              num++;
              bParams.add(o2.sqlDisplayPage());
            break;
          case "setAreaServed":
              o2.setAreaServed(jsonObject.getJsonObject(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(String.format("%s=ST_GeomFromGeoJSON($%s)", Airport.VAR_areaServed, num));
              num++;
              bParams.add(o2.sqlAreaServed());
            break;
          case "setEditPage":
              o2.setEditPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_editPage + "=$" + num);
              num++;
              bParams.add(o2.sqlEditPage());
            break;
          case "setUserPage":
              o2.setUserPage(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_userPage + "=$" + num);
              num++;
              bParams.add(o2.sqlUserPage());
            break;
          case "setDownload":
              o2.setDownload(jsonObject.getString(entityVar));
              if(bParams.size() > 0)
                bSql.append(", ");
              bSql.append(Airport.VAR_download + "=$" + num);
              num++;
              bParams.add(o2.sqlDownload());
            break;
        }
      }
      bSql.append(" WHERE pk=$" + num);
      if(bParams.size() > 0) {
        bParams.add(pk);
        num++;
        futures2.add(0, Future.future(a -> {
          sqlConnection.preparedQuery(bSql.toString())
              .execute(Tuple.tuple(bParams)
              ).onSuccess(b -> {
            a.handle(Future.succeededFuture());
          }).onFailure(ex -> {
            RuntimeException ex2 = new RuntimeException("value Airport failed", ex);
            LOG.error(String.format("relateAirport failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          Airport o3 = new Airport();
          o3.setSiteRequest_(o.getSiteRequest_());
          o3.setPk(pk);
          promise.complete(o3);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPATCHAirport failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPATCHAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200PATCHAirport(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PATCHAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // POST //

  @Override
  public void postAirport(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("postAirport started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "POST"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("POST")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(1L);
              apiRequest.setNumFound(1L);
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
              JsonObject params = new JsonObject();
              params.put("body", siteRequest.getJsonObject());
              params.put("path", new JsonObject());
              params.put("scopes", scopes2);
              params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
              params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
              params.put("form", new JsonObject());
              JsonObject query = new JsonObject();
              Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
              Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
              if(softCommit == null && commitWithin == null)
                softCommit = true;
              if(softCommit != null)
                query.put("softCommit", softCommit);
              if(commitWithin != null)
                query.put("commitWithin", commitWithin);
              params.put("query", query);
              JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
              JsonObject json = new JsonObject().put("context", context);
              eventBus.request(Airport.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "postAirportFuture")).onSuccess(a -> {
                JsonObject responseMessage = (JsonObject)a.body();
                JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
                apiRequest.setSolrId(responseBody.getString(Airport.VAR_solrId));
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
                LOG.debug(String.format("postAirport succeeded. "));
              }).onFailure(ex -> {
                LOG.error(String.format("postAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("postAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("postAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("postAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  @Override
  public void postAirportFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setRows(1L);
        apiRequest.setNumFound(1L);
        apiRequest.setNumPATCH(0L);
        apiRequest.initDeepApiRequest(siteRequest);
        siteRequest.setApiRequest_(apiRequest);
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        postAirportFuture(siteRequest, false).onSuccess(o -> {
          eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
        }).onFailure(ex -> {
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Throwable ex) {
        LOG.error(String.format("postAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("postAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("postAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Airport> postAirportFuture(SiteRequest siteRequest, Boolean entityShortId) {
    Promise<Airport> promise = Promise.promise();

    try {
      pgPool.withTransaction(sqlConnection -> {
        Promise<Airport> promise1 = Promise.promise();
        siteRequest.setSqlConnection(sqlConnection);
        varsAirport(siteRequest).onSuccess(a -> {
          createAirport(siteRequest).onSuccess(airport -> {
            sqlPOSTAirport(airport, entityShortId).onSuccess(b -> {
              persistAirport(airport, false).onSuccess(c -> {
                relateAirport(airport).onSuccess(d -> {
                  indexAirport(airport).onSuccess(o2 -> {
                    promise1.complete(airport);
                  }).onFailure(ex -> {
                    promise1.tryFail(ex);
                  });
                }).onFailure(ex -> {
                  promise1.tryFail(ex);
                });
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(airport -> {
        Promise<Airport> promise2 = Promise.promise();
        refreshAirport(airport).onSuccess(a -> {
          try {
            ApiRequest apiRequest = siteRequest.getApiRequest_();
            if(apiRequest != null) {
              apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
              airport.apiRequestAirport();
              eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
            }
            promise2.complete(airport);
          } catch(Exception ex) {
            LOG.error(String.format("postAirportFuture failed. "), ex);
            promise2.tryFail(ex);
          }
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(airport -> {
        try {
          ApiRequest apiRequest = siteRequest.getApiRequest_();
          if(apiRequest != null) {
            apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
            airport.apiRequestAirport();
            eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
          }
          promise.complete(airport);
        } catch(Exception ex) {
          LOG.error(String.format("postAirportFuture failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("postAirportFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Airport> sqlPOSTAirport(Airport o, Boolean inheritPrimaryKey) {
    Promise<Airport> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("UPDATE Airport SET ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Airport o2 = new Airport();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(siteRequest.getSessionId() != null) {
        if(bParams.size() > 0) {
          bSql.append(", ");
        }
        bSql.append("sessionId=$" + num);
        num++;
        bParams.add(siteRequest.getSessionId());
      }
      if(siteRequest.getUserKey() != null) {
        if(bParams.size() > 0) {
          bSql.append(", ");
        }
        bSql.append("userKey=$" + num);
        num++;
        bParams.add(siteRequest.getUserKey());
      }

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          case Airport.VAR_name:
            o2.setName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_name + "=$" + num);
            num++;
            bParams.add(o2.sqlName());
            break;
          case Airport.VAR_address:
            o2.setAddress(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_address + "=$" + num);
            num++;
            bParams.add(o2.sqlAddress());
            break;
          case Airport.VAR_description:
            o2.setDescription(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_description + "=$" + num);
            num++;
            bParams.add(o2.sqlDescription());
            break;
          case Airport.VAR_alternateName:
            o2.setAlternateName(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_alternateName + "=$" + num);
            num++;
            bParams.add(o2.sqlAlternateName());
            break;
          case Airport.VAR_created:
            o2.setCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_created + "=$" + num);
            num++;
            bParams.add(o2.sqlCreated());
            break;
          case Airport.VAR_location:
            o2.setLocation(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_location + "=$" + num);
            num++;
            bParams.add(o2.sqlLocation());
            break;
          case Airport.VAR_codeIATA:
            o2.setCodeIATA(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_codeIATA + "=$" + num);
            num++;
            bParams.add(o2.sqlCodeIATA());
            break;
          case Airport.VAR_id:
            o2.setId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_id + "=$" + num);
            num++;
            bParams.add(o2.sqlId());
            break;
          case Airport.VAR_codeICAO:
            o2.setCodeICAO(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_codeICAO + "=$" + num);
            num++;
            bParams.add(o2.sqlCodeICAO());
            break;
          case Airport.VAR_archived:
            o2.setArchived(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_archived + "=$" + num);
            num++;
            bParams.add(o2.sqlArchived());
            break;
          case Airport.VAR_entityShortId:
            o2.setEntityShortId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_entityShortId + "=$" + num);
            num++;
            bParams.add(o2.sqlEntityShortId());
            break;
          case Airport.VAR_dataProvider:
            o2.setDataProvider(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_dataProvider + "=$" + num);
            num++;
            bParams.add(o2.sqlDataProvider());
            break;
          case Airport.VAR_ngsildTenant:
            o2.setNgsildTenant(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_ngsildTenant + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildTenant());
            break;
          case Airport.VAR_dateCreated:
            o2.setDateCreated(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_dateCreated + "=$" + num);
            num++;
            bParams.add(o2.sqlDateCreated());
            break;
          case Airport.VAR_ngsildPath:
            o2.setNgsildPath(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_ngsildPath + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildPath());
            break;
          case Airport.VAR_dateModified:
            o2.setDateModified(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_dateModified + "=$" + num);
            num++;
            bParams.add(o2.sqlDateModified());
            break;
          case Airport.VAR_ngsildContext:
            o2.setNgsildContext(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_ngsildContext + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildContext());
            break;
          case Airport.VAR_owner:
            o2.setOwner(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_owner + "=$" + num);
            num++;
            bParams.add(o2.sqlOwner());
            break;
          case Airport.VAR_sessionId:
            o2.setSessionId(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_sessionId + "=$" + num);
            num++;
            bParams.add(o2.sqlSessionId());
            break;
          case Airport.VAR_ngsildData:
            o2.setNgsildData(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_ngsildData + "=$" + num);
            num++;
            bParams.add(o2.sqlNgsildData());
            break;
          case Airport.VAR_seeAlso:
            o2.setSeeAlso(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_seeAlso + "=$" + num);
            num++;
            bParams.add(o2.sqlSeeAlso());
            break;
          case Airport.VAR_userKey:
            o2.setUserKey(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_userKey + "=$" + num);
            num++;
            bParams.add(o2.sqlUserKey());
            break;
          case Airport.VAR_color:
            o2.setColor(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_color + "=$" + num);
            num++;
            bParams.add(o2.sqlColor());
            break;
          case Airport.VAR_source:
            o2.setSource(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_source + "=$" + num);
            num++;
            bParams.add(o2.sqlSource());
            break;
          case Airport.VAR_objectTitle:
            o2.setObjectTitle(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_objectTitle + "=$" + num);
            num++;
            bParams.add(o2.sqlObjectTitle());
            break;
          case Airport.VAR_displayPage:
            o2.setDisplayPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_displayPage + "=$" + num);
            num++;
            bParams.add(o2.sqlDisplayPage());
            break;
          case Airport.VAR_areaServed:
            o2.setAreaServed(jsonObject.getJsonObject(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_areaServed + "=$" + num);
            num++;
            bParams.add(o2.sqlAreaServed());
            break;
          case Airport.VAR_editPage:
            o2.setEditPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_editPage + "=$" + num);
            num++;
            bParams.add(o2.sqlEditPage());
            break;
          case Airport.VAR_userPage:
            o2.setUserPage(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_userPage + "=$" + num);
            num++;
            bParams.add(o2.sqlUserPage());
            break;
          case Airport.VAR_download:
            o2.setDownload(jsonObject.getString(entityVar));
            if(bParams.size() > 0) {
              bSql.append(", ");
            }
            bSql.append(Airport.VAR_download + "=$" + num);
            num++;
            bParams.add(o2.sqlDownload());
            break;
          }
        }
      }
      bSql.append(" WHERE pk=$" + num);
      if(bParams.size() > 0) {
      bParams.add(pk);
      num++;
        futures2.add(0, Future.future(a -> {
          sqlConnection.preparedQuery(bSql.toString())
              .execute(Tuple.tuple(bParams)
              ).onSuccess(b -> {
            a.handle(Future.succeededFuture());
          }).onFailure(ex -> {
            RuntimeException ex2 = new RuntimeException("value Airport failed", ex);
            LOG.error(String.format("relateAirport failed. "), ex2);
            a.handle(Future.failedFuture(ex2));
          });
        }));
      }
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          promise.complete(o2);
        }).onFailure(ex -> {
          LOG.error(String.format("sqlPOSTAirport failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlPOSTAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200POSTAirport(Airport o) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject json = JsonObject.mapFrom(o);
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200POSTAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // DELETE //

  @Override
  public void deleteAirport(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deleteAirport started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "DELETE"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("DELETE")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, true, "DELETE").onSuccess(listAirport -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listAirport.getRequest().getRows());
                  apiRequest.setNumFound(listAirport.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listAirport.first());
                  apiRequest.setSolrId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getSolrId()).orElse(null));
                  eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());

                  listDELETEAirport(apiRequest, listAirport).onSuccess(e -> {
                    response200DELETEAirport(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("deleteAirport succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("deleteAirport failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("deleteAirport failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("deleteAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("deleteAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deleteAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("deleteAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEAirport(ApiRequest apiRequest, SearchList<Airport> listAirport) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
    listAirport.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      Airport o2 = jsonObject.mapTo(Airport.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deleteAirportFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEAirport failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAirport.next().onSuccess(next -> {
        if(next) {
          listDELETEAirport(apiRequest, listAirport).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEAirport failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEAirport failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEAirport failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deleteAirportFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchAirportList(siteRequest, false, true, true, "DELETE").onSuccess(listAirport -> {
          try {
            Airport o = listAirport.first();
            if(o != null && listAirport.getResponse().getResponse().getNumFound() == 1) {
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(1L);
              apiRequest.setNumFound(1L);
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
                siteRequest.getRequestVars().put( "refresh", "false" );
              }
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deleteAirportFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deleteAirport failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deleteAirport failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deleteAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deleteAirport failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<Airport> deleteAirportFuture(Airport o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<Airport> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<Airport> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsAirport(siteRequest).onSuccess(a -> {
          sqlDELETEAirport(o).onSuccess(airport -> {
            relateAirport(o).onSuccess(d -> {
              unindexAirport(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestAirport();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
                  }
                }
                promise1.complete();
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(airport -> {
        Promise<Airport> promise2 = Promise.promise();
        refreshAirport(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(airport -> {
        promise.complete(airport);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deleteAirportFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEAirport(Airport o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM Airport ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Airport o2 = new Airport();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          }
        }
      }
      bSql.append(" WHERE pk=$" + num);
      bParams.add(pk);
      num++;
      futures2.add(0, Future.future(a -> {
        sqlConnection.preparedQuery(bSql.toString())
            .execute(Tuple.tuple(bParams)
            ).onSuccess(b -> {
          a.handle(Future.succeededFuture());
        }).onFailure(ex -> {
          RuntimeException ex2 = new RuntimeException("value Airport failed", ex);
          LOG.error(String.format("unrelateAirport failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
            cbDeleteEntity(o).onSuccess(c -> {
              promise.complete();
            }).onFailure(ex -> {
              LOG.error(String.format("sqlDELETEAirport failed. "), ex);
              promise.tryFail(ex);
            });
          } else {
            promise.complete();
          }
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEAirport failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEAirport(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // PUTImport //

  @Override
  public void putimportAirport(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("putimportAirport started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "PUT"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("PUT")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              ApiRequest apiRequest = new ApiRequest();
              JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
              apiRequest.setRows(Long.valueOf(jsonArray.size()));
              apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
              varsAirport(siteRequest).onSuccess(d -> {
                listPUTImportAirport(apiRequest, siteRequest).onSuccess(e -> {
                  response200PUTImportAirport(siteRequest).onSuccess(response -> {
                    LOG.debug(String.format("putimportAirport succeeded. "));
                    eventHandler.handle(Future.succeededFuture(response));
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportAirport failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                }).onFailure(ex -> {
                  LOG.error(String.format("putimportAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("putimportAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("putimportAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("putimportAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listPUTImportAirport(ApiRequest apiRequest, SiteRequest siteRequest) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
    try {
      jsonArray.forEach(obj -> {
        futures.add(Future.future(promise1 -> {
          JsonObject params = new JsonObject();
          params.put("body", obj);
          params.put("path", new JsonObject());
          params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
          params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
          params.put("form", new JsonObject());
          JsonObject query = new JsonObject();
          Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
          Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
          if(softCommit == null && commitWithin == null)
            softCommit = true;
          if(softCommit != null)
            query.put("softCommit", softCommit);
          if(commitWithin != null)
            query.put("commitWithin", commitWithin);
          params.put("query", query);
          JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
          JsonObject json = new JsonObject().put("context", context);
          eventBus.request(Airport.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "putimportAirportFuture")).onSuccess(a -> {
            promise1.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listPUTImportAirport failed. "), ex);
            promise1.tryFail(ex);
          });
        }));
      });
      CompositeFuture.all(futures).onSuccess(a -> {
        apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public void putimportAirportFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setRows(1L);
        apiRequest.setNumFound(1L);
        apiRequest.setNumPATCH(0L);
        apiRequest.initDeepApiRequest(siteRequest);
        siteRequest.setApiRequest_(apiRequest);
        String entityShortId = Optional.ofNullable(body.getString(Airport.VAR_entityShortId)).orElse(body.getString(Airport.VAR_solrId));
        if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
          siteRequest.getRequestVars().put( "refresh", "false" );
        }
        pgPool.getConnection().onSuccess(sqlConnection -> {
          String sqlQuery = String.format("select * from %s WHERE entityShortId=$1", Airport.CLASS_SIMPLE_NAME);
          sqlConnection.preparedQuery(sqlQuery)
              .execute(Tuple.tuple(Arrays.asList(entityShortId))
              ).onSuccess(result -> {
            sqlConnection.close().onSuccess(a -> {
              try {
                if(result.size() >= 1) {
                  Airport o = new Airport();
                  o.setSiteRequest_(siteRequest);
                  for(Row definition : result.value()) {
                    for(Integer i = 0; i < definition.size(); i++) {
                      try {
                        String columnName = definition.getColumnName(i);
                        Object columnValue = definition.getValue(i);
                        o.persistForClass(columnName, columnValue);
                      } catch(Exception e) {
                        LOG.error(String.format("persistAirport failed. "), e);
                      }
                    }
                  }
                  Airport o2 = new Airport();
                  o2.setSiteRequest_(siteRequest);
                  JsonObject body2 = new JsonObject();
                  for(String f : body.fieldNames()) {
                    Object bodyVal = body.getValue(f);
                    if(bodyVal instanceof JsonArray) {
                      JsonArray bodyVals = (JsonArray)bodyVal;
                      Object valsObj = o.obtainForClass(f);
                      Collection<?> vals = valsObj instanceof JsonArray ? ((JsonArray)valsObj).getList() : (Collection<?>)valsObj;
                      if(vals != null && bodyVals.size() == vals.size()) {
                        Boolean match = true;
                        for(Object val : vals) {
                          if(val != null) {
                            if(!bodyVals.contains(val.toString())) {
                              match = false;
                              break;
                            }
                          } else {
                            match = false;
                            break;
                          }
                        }
                        vals.clear();
                        body2.put("set" + StringUtils.capitalize(f), bodyVal);
                      } else {
                        if(vals != null)
                          vals.clear();
                        body2.put("set" + StringUtils.capitalize(f), bodyVal);
                      }
                    } else {
                      o2.persistForClass(f, bodyVal);
                      o2.relateForClass(f, bodyVal);
                      if(!StringUtils.containsAny(f, "entityShortId", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.put("set" + StringUtils.capitalize(f), bodyVal);
                    }
                  }
                  for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
                    if(!body.fieldNames().contains(f)) {
                      if(!StringUtils.containsAny(f, "entityShortId", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
                        body2.putNull("set" + StringUtils.capitalize(f));
                    }
                  }
                  if(result.size() >= 1) {
                    apiRequest.setOriginal(o);
                    apiRequest.setId(Optional.ofNullable(o.getEntityShortId()).map(v -> v.toString()).orElse(null));
                    apiRequest.setSolrId(o.getSolrId());
                  }
                  siteRequest.setJsonObject(body2);
                  patchAirportFuture(o, true).onSuccess(b -> {
                    LOG.debug("Import Airport {} succeeded, modified Airport. ", body.getValue(Airport.VAR_entityShortId));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportAirportFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                } else {
                  postAirportFuture(siteRequest, true).onSuccess(b -> {
                    LOG.debug("Import Airport {} succeeded, created new Airport. ", body.getValue(Airport.VAR_entityShortId));
                    eventHandler.handle(Future.succeededFuture());
                  }).onFailure(ex -> {
                    LOG.error(String.format("putimportAirportFuture failed. "), ex);
                    eventHandler.handle(Future.failedFuture(ex));
                  });
                }
              } catch(Exception ex) {
                LOG.error(String.format("putimportAirportFuture failed. "), ex);
                eventHandler.handle(Future.failedFuture(ex));
              }
            }).onFailure(ex -> {
              LOG.error(String.format("putimportAirportFuture failed. "), ex);
              eventHandler.handle(Future.failedFuture(ex));
            });
          }).onFailure(ex -> {
            LOG.error(String.format("putimportAirportFuture failed. "), ex);
            eventHandler.handle(Future.failedFuture(ex));
          });
        }).onFailure(ex -> {
          LOG.error(String.format("putimportAirportFuture failed. "), ex);
          eventHandler.handle(Future.failedFuture(ex));
        });
      } catch(Exception ex) {
        LOG.error(String.format("putimportAirportFuture failed. "), ex);
        eventHandler.handle(Future.failedFuture(ex));
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("putimportAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("putimportAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<ServiceResponse> response200PUTImportAirport(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200PUTImportAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // SearchPage //

  @Override
  public void searchpageAirport(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, false, "GET").onSuccess(listAirport -> {
                response200SearchPageAirport(listAirport).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("searchpageAirport succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("searchpageAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("searchpageAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("searchpageAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("searchpageAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("searchpageAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("searchpageAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void searchpageAirportPageInit(JsonObject ctx, AirportPage page, SearchList<Airport> listAirport, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/airport"));
    ctx.put("enUSUrlPage", String.format("%s%s", siteBaseUrl, "/en-us/search/airport"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriSearchPageAirport(ServiceRequest serviceRequest, Airport result) {
    return "en-us/search/airport/AirportSearchPage.htm";
  }
  public void templateSearchPageAirport(JsonObject ctx, AirportPage page, SearchList<Airport> listAirport, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      Airport result = listAirport.first();
      String pageTemplateUri = templateUriSearchPageAirport(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/search/airport/AirportSearchPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateSearchPageAirport failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200SearchPageAirport(SearchList<Airport> listAirport) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
      AirportPage page = new AirportPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listAirport.size() >= 1)
        siteRequest.setRequestPk(listAirport.get(0).getPk());
      page.setSearchListAirport_(listAirport);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAirportPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          searchpageAirportPageInit(ctx, page, listAirport, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateSearchPageAirport(ctx, page, listAirport, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200SearchPageAirport failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200SearchPageAirport failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200SearchPageAirport failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200SearchPageAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotSearchPageAirport(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
    if(pivots != null) {
      for(SolrResponse.Pivot pivotField : pivots) {
        String entityIndexed = pivotField.getField();
        String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
        JsonObject pivotJson = new JsonObject();
        pivotArray.add(pivotJson);
        pivotJson.put("field", entityVar);
        pivotJson.put("value", pivotField.getValue());
        pivotJson.put("count", pivotField.getCount());
        Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
        List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
        if(pivotRanges != null) {
          JsonObject rangeJson = new JsonObject();
          pivotJson.put("ranges", rangeJson);
          for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
            rangeJson.put(rangeFacetVar, rangeFacetJson);
            JsonObject rangeFacetCountsObject = new JsonObject();
            rangeFacetJson.put("counts", rangeFacetCountsObject);
            rangeFacet.getCounts().forEach((value, count) -> {
              rangeFacetCountsObject.put(value, count);
            });
          }
        }
        if(pivotFields2 != null) {
          JsonArray pivotArray2 = new JsonArray();
          pivotJson.put("pivot", pivotArray2);
          responsePivotSearchPageAirport(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // EditPage //

  @Override
  public void editpageAirport(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "GET"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
              , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
              , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
              )
              .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
              .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
              .sendForm(form)
              .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, false, "GET").onSuccess(listAirport -> {
                response200EditPageAirport(listAirport).onSuccess(response -> {
                  eventHandler.handle(Future.succeededFuture(response));
                  LOG.debug(String.format("editpageAirport succeeded. "));
                }).onFailure(ex -> {
                  LOG.error(String.format("editpageAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("editpageAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
            });
            }
          } catch(Exception ex) {
            LOG.error(String.format("editpageAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("editpageAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("editpageAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("editpageAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public void editpageAirportPageInit(JsonObject ctx, AirportPage page, SearchList<Airport> listAirport, Promise<Void> promise) {
    String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);

    ctx.put("enUSUrlSearchPage", String.format("%s%s", siteBaseUrl, "/en-us/search/airport"));
    ctx.put("enUSUrlDisplayPage", Optional.ofNullable(page.getResult()).map(o -> o.getDisplayPage()));
    ctx.put("enUSUrlEditPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlPage", Optional.ofNullable(page.getResult()).map(o -> o.getEditPage()));
    ctx.put("enUSUrlUserPage", Optional.ofNullable(page.getResult()).map(o -> o.getUserPage()));
    ctx.put("enUSUrlDownload", Optional.ofNullable(page.getResult()).map(o -> o.getDownload()));

    promise.complete();
  }

  public String templateUriEditPageAirport(ServiceRequest serviceRequest, Airport result) {
    return "en-us/edit/airport/AirportEditPage.htm";
  }
  public void templateEditPageAirport(JsonObject ctx, AirportPage page, SearchList<Airport> listAirport, Promise<String> promise) {
    try {
      SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      Airport result = listAirport.first();
      String pageTemplateUri = templateUriEditPageAirport(serviceRequest, result);
      String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
      Path resourceTemplatePath = Path.of(siteTemplatePath, pageTemplateUri);
      if(result == null || !Files.exists(resourceTemplatePath)) {
        String template = Files.readString(Path.of(siteTemplatePath, "en-us/edit/airport/AirportEditPage.htm"), Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      } else if(pageTemplateUri.endsWith(".md")) {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
        Map<String, Object> data = new HashMap<>();
        String body = "";
        if(template.startsWith("---\n")) {
          Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
          if(mMeta.find()) {
            String meta = mMeta.group(1);
            body = mMeta.group(2);
            Yaml yaml = new Yaml();
            Map<String, Object> map = yaml.load(meta);
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
            map.forEach((resultKey, value) -> {
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx.getMap());
                  data.put(key, rendered);
                } else {
                  data.put(key, val);
                }
              }
            });
          }
        }
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder().build();
        org.commonmark.node.Node document = parser.parse(body);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build();
        String pageExtends =  Optional.ofNullable((String)data.get("extends")).orElse("en-us/Article.htm");
        String htmTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
        String renderedTemplate = jinjava.render(htmTemplate, ctx.getMap());
        promise.complete(renderedTemplate);
      } else {
        String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
        String renderedTemplate = jinjava.render(template, ctx.getMap());
        promise.complete(renderedTemplate);
      }
    } catch(Exception ex) {
      LOG.error(String.format("templateEditPageAirport failed. "), ex);
      ExceptionUtils.rethrow(ex);
    }
  }
  public Future<ServiceResponse> response200EditPageAirport(SearchList<Airport> listAirport) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
      AirportPage page = new AirportPage();
      MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
      siteRequest.setRequestHeaders(requestHeaders);

      if(listAirport.size() >= 1)
        siteRequest.setRequestPk(listAirport.get(0).getPk());
      page.setSearchListAirport_(listAirport);
      page.setSiteRequest_(siteRequest);
      page.setServiceRequest(siteRequest.getServiceRequest());
      page.setWebClient(webClient);
      page.setVertx(vertx);
      page.promiseDeepAirportPage(siteRequest).onSuccess(a -> {
        try {
          JsonObject ctx = ConfigKeys.getPageContext(config);
          ctx.mergeIn(JsonObject.mapFrom(page));
          Promise<Void> promise1 = Promise.promise();
          editpageAirportPageInit(ctx, page, listAirport, promise1);
          promise1.future().onSuccess(b -> {
            try {
              Promise<String> promise2 = Promise.promise();
              templateEditPageAirport(ctx, page, listAirport, promise2);
              promise2.future().onSuccess(renderedTemplate -> {
                try {
                  Buffer buffer = Buffer.buffer(renderedTemplate);
                  promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
                } catch(Throwable ex) {
                  LOG.error(String.format("response200EditPageAirport failed. "), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Throwable ex) {
              LOG.error(String.format("response200EditPageAirport failed. "), ex);
              promise.tryFail(ex);
            }
          }).onFailure(ex -> {
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("response200EditPageAirport failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("response200EditPageAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void responsePivotEditPageAirport(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
    if(pivots != null) {
      for(SolrResponse.Pivot pivotField : pivots) {
        String entityIndexed = pivotField.getField();
        String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
        JsonObject pivotJson = new JsonObject();
        pivotArray.add(pivotJson);
        pivotJson.put("field", entityVar);
        pivotJson.put("value", pivotField.getValue());
        pivotJson.put("count", pivotField.getCount());
        Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
        List<SolrResponse.Pivot> pivotFields2 = pivotField.getPivotList();
        if(pivotRanges != null) {
          JsonObject rangeJson = new JsonObject();
          pivotJson.put("ranges", rangeJson);
          for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
            rangeJson.put(rangeFacetVar, rangeFacetJson);
            JsonObject rangeFacetCountsObject = new JsonObject();
            rangeFacetJson.put("counts", rangeFacetCountsObject);
            rangeFacet.getCounts().forEach((value, count) -> {
              rangeFacetCountsObject.put(value, count);
            });
          }
        }
        if(pivotFields2 != null) {
          JsonArray pivotArray2 = new JsonArray();
          pivotJson.put("pivot", pivotArray2);
          responsePivotEditPageAirport(pivotFields2, pivotArray2);
        }
      }
    }
  }

  // DELETEFilter //

  @Override
  public void deletefilterAirport(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    LOG.debug(String.format("deletefilterAirport started. "));
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        String entityShortId = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("entityShortId");
        String AIRPORT = siteRequest.getServiceRequest().getParams().getJsonObject("path").getString("AIRPORT");
        List<String> groups = Optional.ofNullable(siteRequest.getGroups()).orElse(new ArrayList<>());
        MultiMap form = MultiMap.caseInsensitiveMultiMap();
        form.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket");
        form.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT));
        form.add("response_mode", "permissions");
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "GET"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "POST"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PATCH"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "PUT"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "DELETE"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "SuperAdmin"));
        form.add("permission", String.format("%s#%s", Airport.CLASS_AUTH_RESOURCE, "Admin"));
        if(entityShortId != null)
          form.add("permission", String.format("%s-%s#%s", Airport.CLASS_AUTH_RESOURCE, entityShortId, "DELETE"));
        webClient.post(
            config.getInteger(ComputateConfigKeys.AUTH_PORT)
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(config.getBoolean(ComputateConfigKeys.AUTH_SSL))
            .putHeader("Authorization", String.format("Bearer %s", Optional.ofNullable(siteRequest.getUser()).map(u -> u.principal().getString("access_token")).orElse("")))
            .sendForm(form)
            .expecting(HttpResponseExpectation.SC_OK)
        .onComplete(authorizationDecisionResponse -> {
          try {
            HttpResponse<Buffer> authorizationDecision = authorizationDecisionResponse.result();
            JsonArray authorizationDecisionBody = authorizationDecisionResponse.failed() ? new JsonArray() : authorizationDecision.bodyAsJsonArray();
            JsonArray scopes = authorizationDecisionBody.stream().map(o -> (JsonObject)o).filter(o -> "AIRPORT".equals(o.getString("rsname"))).findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            if(authorizationDecisionResponse.failed() || !scopes.contains("DELETE")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              eventHandler.handle(Future.succeededFuture(
                new ServiceResponse(403, "FORBIDDEN",
                  Buffer.buffer().appendString(
                    new JsonObject()
                      .put("errorCode", "403")
                      .put("errorMessage", msg)
                      .encodePrettily()
                    ), MultiMap.caseInsensitiveMultiMap()
                )
              ));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              List<String> scopes2 = siteRequest.getScopes();
              searchAirportList(siteRequest, false, true, true, "DELETE").onSuccess(listAirport -> {
                try {
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(listAirport.getRequest().getRows());
                  apiRequest.setNumFound(listAirport.getResponse().getResponse().getNumFound());
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);
                  if(apiRequest.getNumFound() == 1L)
                    apiRequest.setOriginal(listAirport.first());
                  apiRequest.setSolrId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getSolrId()).orElse(null));
                  eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());

                  listDELETEFilterAirport(apiRequest, listAirport).onSuccess(e -> {
                    response200DELETEFilterAirport(siteRequest).onSuccess(response -> {
                      LOG.debug(String.format("deletefilterAirport succeeded. "));
                      eventHandler.handle(Future.succeededFuture(response));
                    }).onFailure(ex -> {
                      LOG.error(String.format("deletefilterAirport failed. "), ex);
                      error(siteRequest, eventHandler, ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("deletefilterAirport failed. "), ex);
                    error(siteRequest, eventHandler, ex);
                  });
                } catch(Exception ex) {
                  LOG.error(String.format("deletefilterAirport failed. "), ex);
                  error(siteRequest, eventHandler, ex);
                }
              }).onFailure(ex -> {
                LOG.error(String.format("deletefilterAirport failed. "), ex);
                error(siteRequest, eventHandler, ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterAirport failed. "), ex);
            error(null, eventHandler, ex);
          }
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
        try {
          eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
        } catch(Exception ex2) {
          LOG.error(String.format("deletefilterAirport failed. ", ex2));
          error(null, eventHandler, ex2);
        }
      } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
        eventHandler.handle(Future.succeededFuture(
          new ServiceResponse(401, "UNAUTHORIZED",
            Buffer.buffer().appendString(
              new JsonObject()
                .put("errorCode", "401")
                .put("errorMessage", "SSO Resource Permission check returned DENY")
                .encodePrettily()
              ), MultiMap.caseInsensitiveMultiMap()
              )
          ));
      } else {
        LOG.error(String.format("deletefilterAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    });
  }

  public Future<Void> listDELETEFilterAirport(ApiRequest apiRequest, SearchList<Airport> listAirport) {
    Promise<Void> promise = Promise.promise();
    List<Future> futures = new ArrayList<>();
    SiteRequest siteRequest = listAirport.getSiteRequest_(SiteRequest.class);
    listAirport.getList().forEach(o -> {
      SiteRequest siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getUserPrincipal(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequest.class);
      siteRequest2.setScopes(siteRequest.getScopes());
      o.setSiteRequest_(siteRequest2);
      siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
      JsonObject jsonObject = JsonObject.mapFrom(o);
      Airport o2 = jsonObject.mapTo(Airport.class);
      o2.setSiteRequest_(siteRequest2);
      futures.add(Future.future(promise1 -> {
        deletefilterAirportFuture(o).onSuccess(a -> {
          promise1.complete();
        }).onFailure(ex -> {
          LOG.error(String.format("listDELETEFilterAirport failed. "), ex);
          promise1.tryFail(ex);
        });
      }));
    });
    CompositeFuture.all(futures).onSuccess( a -> {
      listAirport.next().onSuccess(next -> {
        if(next) {
          listDELETEFilterAirport(apiRequest, listAirport).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format("listDELETEFilterAirport failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete();
        }
      }).onFailure(ex -> {
        LOG.error(String.format("listDELETEFilterAirport failed. "), ex);
        promise.tryFail(ex);
      });
    }).onFailure(ex -> {
      LOG.error(String.format("listDELETEFilterAirport failed. "), ex);
      promise.tryFail(ex);
    });
    return promise.future();
  }

  @Override
  public void deletefilterAirportFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
    Boolean classPublicRead = false;
    user(serviceRequest, SiteRequest.class, SiteUser.class, SiteUser.getClassApiAddress(), "postSiteUserFuture", "patchSiteUserFuture", classPublicRead).onSuccess(siteRequest -> {
      try {
        siteRequest.setLang("enUS");
        siteRequest.setJsonObject(body);
        serviceRequest.getParams().getJsonObject("query").put("rows", 1);
        Optional.ofNullable(serviceRequest.getParams().getJsonArray("scopes")).ifPresent(scopes -> {
          scopes.stream().map(v -> v.toString()).forEach(scope -> {
            siteRequest.addScopes(scope);
          });
        });
        searchAirportList(siteRequest, false, true, true, "DELETE").onSuccess(listAirport -> {
          try {
            Airport o = listAirport.first();
            if(o != null && listAirport.getResponse().getResponse().getNumFound() == 1) {
              ApiRequest apiRequest = new ApiRequest();
              apiRequest.setRows(1L);
              apiRequest.setNumFound(1L);
              apiRequest.setNumPATCH(0L);
              apiRequest.initDeepApiRequest(siteRequest);
              siteRequest.setApiRequest_(apiRequest);
              if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
                siteRequest.getRequestVars().put( "refresh", "false" );
              }
              if(apiRequest.getNumFound() == 1L)
                apiRequest.setOriginal(o);
              apiRequest.setId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getEntityShortId().toString()).orElse(null));
              apiRequest.setSolrId(Optional.ofNullable(listAirport.first()).map(o2 -> o2.getSolrId()).orElse(null));
              deletefilterAirportFuture(o).onSuccess(o2 -> {
                eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
              }).onFailure(ex -> {
                eventHandler.handle(Future.failedFuture(ex));
              });
            } else {
              eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
            }
          } catch(Exception ex) {
            LOG.error(String.format("deletefilterAirport failed. "), ex);
            error(siteRequest, eventHandler, ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("deletefilterAirport failed. "), ex);
          error(siteRequest, eventHandler, ex);
        });
      } catch(Exception ex) {
        LOG.error(String.format("deletefilterAirport failed. "), ex);
        error(null, eventHandler, ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("deletefilterAirport failed. "), ex);
      error(null, eventHandler, ex);
    });
  }

  public Future<Airport> deletefilterAirportFuture(Airport o) {
    SiteRequest siteRequest = o.getSiteRequest_();
    Promise<Airport> promise = Promise.promise();

    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      Promise<Airport> promise1 = Promise.promise();
      pgPool.withTransaction(sqlConnection -> {
        siteRequest.setSqlConnection(sqlConnection);
        varsAirport(siteRequest).onSuccess(a -> {
          sqlDELETEFilterAirport(o).onSuccess(airport -> {
            relateAirport(o).onSuccess(d -> {
              unindexAirport(o).onSuccess(o2 -> {
                if(apiRequest != null) {
                  apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
                  if(apiRequest.getNumFound() == 1L && Optional.ofNullable(siteRequest.getJsonObject()).map(json -> json.size() > 0).orElse(false)) {
                    o2.apiRequestAirport();
                    if(apiRequest.getVars().size() > 0 && Optional.ofNullable(siteRequest.getRequestVars().get("refresh")).map(refresh -> !refresh.equals("false")).orElse(true))
                      eventBus.publish("websocketAirport", JsonObject.mapFrom(apiRequest).toString());
                  }
                }
                promise1.complete();
              }).onFailure(ex -> {
                promise1.tryFail(ex);
              });
            }).onFailure(ex -> {
              promise1.tryFail(ex);
            });
          }).onFailure(ex -> {
            promise1.tryFail(ex);
          });
        }).onFailure(ex -> {
          promise1.tryFail(ex);
        });
        return promise1.future();
      }).onSuccess(a -> {
        siteRequest.setSqlConnection(null);
      }).onFailure(ex -> {
        siteRequest.setSqlConnection(null);
        promise.tryFail(ex);
      }).compose(airport -> {
        Promise<Airport> promise2 = Promise.promise();
        refreshAirport(o).onSuccess(a -> {
          promise2.complete(o);
        }).onFailure(ex -> {
          promise2.tryFail(ex);
        });
        return promise2.future();
      }).onSuccess(airport -> {
        promise.complete(airport);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("deletefilterAirportFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> sqlDELETEFilterAirport(Airport o) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Integer num = 1;
      StringBuilder bSql = new StringBuilder("DELETE FROM Airport ");
      List<Object> bParams = new ArrayList<Object>();
      Long pk = o.getPk();
      JsonObject jsonObject = siteRequest.getJsonObject();
      Airport o2 = new Airport();
      o2.setSiteRequest_(siteRequest);
      List<Future> futures1 = new ArrayList<>();
      List<Future> futures2 = new ArrayList<>();

      if(jsonObject != null) {
        Set<String> entityVars = jsonObject.fieldNames();
        for(String entityVar : entityVars) {
          switch(entityVar) {
          }
        }
      }
      bSql.append(" WHERE pk=$" + num);
      bParams.add(pk);
      num++;
      futures2.add(0, Future.future(a -> {
        sqlConnection.preparedQuery(bSql.toString())
            .execute(Tuple.tuple(bParams)
            ).onSuccess(b -> {
          a.handle(Future.succeededFuture());
        }).onFailure(ex -> {
          RuntimeException ex2 = new RuntimeException("value Airport failed", ex);
          LOG.error(String.format("unrelateAirport failed. "), ex2);
          a.handle(Future.failedFuture(ex2));
        });
      }));
      CompositeFuture.all(futures1).onSuccess(a -> {
        CompositeFuture.all(futures2).onSuccess(b -> {
          if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
            cbDeleteEntity(o).onSuccess(c -> {
              promise.complete();
            }).onFailure(ex -> {
              LOG.error(String.format("sqlDELETEFilterAirport failed. "), ex);
              promise.tryFail(ex);
            });
          } else {
            promise.complete();
          }
        }).onFailure(ex -> {
          LOG.error(String.format("sqlDELETEFilterAirport failed. "), ex);
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("sqlDELETEFilterAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlDELETEFilterAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<ServiceResponse> response200DELETEFilterAirport(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      JsonObject json = new JsonObject();
      promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
    } catch(Exception ex) {
      LOG.error(String.format("response200DELETEFilterAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  // General //

  public Future<Airport> createAirport(SiteRequest siteRequest) {
    Promise<Airport> promise = Promise.promise();
    try {
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      String userId = siteRequest.getUserId();
      Long userKey = siteRequest.getUserKey();
      ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

      sqlConnection.preparedQuery("INSERT INTO Airport(created, userKey) VALUES($1, $2) RETURNING pk")
          .collecting(Collectors.toList())
          .execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
        Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
        Long pk = createLine.getLong(0);
        Airport o = new Airport();
        o.setPk(pk);
        o.setSiteRequest_(siteRequest);
        promise.complete(o);
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error("createAirport failed. ", ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("createAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public void searchAirportQ(SearchList<Airport> searchList, String entityVar, String valueIndexed, String varIndexed) {
    searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
    if(!"*".equals(entityVar)) {
    }
  }

  public String searchAirportFq(SearchList<Airport> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : Airport.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : Airport.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(Airport.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequest.class), valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchAirportSort(SearchList<Airport> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchAirportRows(SearchList<Airport> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchAirportStart(SearchList<Airport> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public void searchAirportVar(SearchList<Airport> searchList, String var, String value) {
    searchList.getSiteRequest_(SiteRequest.class).getRequestVars().put(var, value);
  }

  public void searchAirportUri(SearchList<Airport> searchList) {
  }

  public Future<ServiceResponse> varsAirport(SiteRequest siteRequest) {
    Promise<ServiceResponse> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();

      serviceRequest.getParams().getJsonObject("query").stream().filter(paramRequest -> "var".equals(paramRequest.getKey()) && paramRequest.getValue() != null).findFirst().ifPresent(paramRequest -> {
        String entityVar = null;
        String valueIndexed = null;
        Object paramValuesObject = paramRequest.getValue();
        JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

        try {
          for(Object paramObject : paramObjects) {
            entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
            valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
            siteRequest.getRequestVars().put(entityVar, valueIndexed);
          }
        } catch(Exception ex) {
          LOG.error(String.format("searchAirport failed. "), ex);
          promise.tryFail(ex);
        }
      });
      promise.complete();
    } catch(Exception ex) {
      LOG.error(String.format("searchAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<SearchList<Airport>> searchAirportList(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, String scope) {
    Promise<SearchList<Airport>> promise = Promise.promise();
    try {
      ServiceRequest serviceRequest = siteRequest.getServiceRequest();
      String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
      String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
      SearchList<Airport> searchList = new SearchList<Airport>();
      searchList.setScope(scope);
      String facetRange = null;
      Date facetRangeStart = null;
      Date facetRangeEnd = null;
      String facetRangeGap = null;
      String statsField = null;
      String statsFieldIndexed = null;
      searchList.setPopulate(populate);
      searchList.setStore(store);
      searchList.q("*:*");
      searchList.setC(Airport.class);
      searchList.setSiteRequest_(siteRequest);
      searchList.facetMinCount(1);
      if(entityList != null) {
        for(String v : entityList) {
          searchList.fl(Airport.varIndexedAirport(v));
        }
      }

      String entityShortId = serviceRequest.getParams().getJsonObject("path").getString("entityShortId");
      if(entityShortId != null) {
        searchList.fq("entityShortId_docvalues_string:" + SearchTool.escapeQueryChars(entityShortId));
      }

      for(String paramName : serviceRequest.getParams().getJsonObject("query").fieldNames()) {
        Object paramValuesObject = serviceRequest.getParams().getJsonObject("query").getValue(paramName);
        String entityVar = null;
        String valueIndexed = null;
        String varIndexed = null;
        String valueSort = null;
        Long valueStart = null;
        Long valueRows = null;
        String valueCursorMark = null;
        JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

        try {
          if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
            Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
            if(mFacetPivot.find()) {
              String solrLocalParams = mFacetPivot.group(1);
              String[] entityVars = mFacetPivot.group(2).trim().split(",");
              String[] varsIndexed = new String[entityVars.length];
              for(Integer i = 0; i < entityVars.length; i++) {
                entityVar = entityVars[i];
                varsIndexed[i] = Airport.varIndexedAirport(entityVar);
              }
              searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
            }
          } else if(paramValuesObject != null) {
            for(Object paramObject : paramObjects) {
              if(paramName.equals("q")) {
                Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
                StringBuffer sb = new StringBuffer();
                while(mQ.find()) {
                  entityVar = mQ.group(1).trim();
                  valueIndexed = mQ.group(2).trim();
                  varIndexed = Airport.varIndexedAirport(entityVar);
                  String entityQ = searchAirportFq(searchList, entityVar, valueIndexed, varIndexed);
                  mQ.appendReplacement(sb, entityQ);
                }
                if(!sb.isEmpty()) {
                  mQ.appendTail(sb);
                  searchList.q(sb.toString());
                }
              } else if(paramName.equals("fq")) {
                Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
                  StringBuffer sb = new StringBuffer();
                while(mFq.find()) {
                  entityVar = mFq.group(1).trim();
                  valueIndexed = mFq.group(2).trim();
                  varIndexed = Airport.varIndexedAirport(entityVar);
                  String entityFq = searchAirportFq(searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = Airport.varIndexedAirport(entityVar);
                searchAirportSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchAirportStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchAirportRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = Airport.varIndexedAirport(entityVar);
                  searchList.statsField((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  statsField = entityVar;
                  statsFieldIndexed = varIndexed;
                }
              } else if(paramName.equals("facet")) {
                searchList.facet((Boolean)paramObject);
              } else if(paramName.equals("facet.range.start")) {
                String startMathStr = (String)paramObject;
                Date start = SearchTool.parseMath(startMathStr);
                searchList.facetRangeStart(start.toInstant().toString());
                facetRangeStart = start;
              } else if(paramName.equals("facet.range.end")) {
                String endMathStr = (String)paramObject;
                Date end = SearchTool.parseMath(endMathStr);
                searchList.facetRangeEnd(end.toInstant().toString());
                facetRangeEnd = end;
              } else if(paramName.equals("facet.range.gap")) {
                String gap = (String)paramObject;
                searchList.facetRangeGap(gap);
                facetRangeGap = gap;
              } else if(paramName.equals("facet.range")) {
                Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mFacetRange.find()) {
                  String solrLocalParams = mFacetRange.group(1);
                  entityVar = mFacetRange.group(2).trim();
                  varIndexed = Airport.varIndexedAirport(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = Airport.varIndexedAirport(entityVar);
                if(varIndexed != null)
                  searchList.facetField(varIndexed);
              } else if(paramName.equals("var")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
                valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
                searchAirportVar(searchList, entityVar, valueIndexed);
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
            searchAirportUri(searchList);
          }
        } catch(Exception e) {
          ExceptionUtils.rethrow(e);
        }
      }
      if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
        searchList.sort("created_docvalues_date", "desc");
      }
      String facetRange2 = facetRange;
      Date facetRangeStart2 = facetRangeStart;
      Date facetRangeEnd2 = facetRangeEnd;
      String facetRangeGap2 = facetRangeGap;
      String statsField2 = statsField;
      String statsFieldIndexed2 = statsFieldIndexed;
      searchAirport2(siteRequest, populate, store, modify, searchList);
      searchList.promiseDeepForClass(siteRequest).onSuccess(searchList2 -> {
        if(facetRange2 != null && statsField2 != null && facetRange2.equals(statsField2)) {
          StatsField stats = searchList.getResponse().getStats().getStatsFields().get(statsFieldIndexed2);
          Instant min = Optional.ofNullable(stats.getMin()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
          Instant max = Optional.ofNullable(stats.getMax()).map(val -> Instant.parse(val.toString())).orElse(Instant.now());
          if(min.equals(max)) {
            min = min.minus(1, ChronoUnit.DAYS);
            max = max.plus(2, ChronoUnit.DAYS);
          }
          Duration duration = Duration.between(min, max);
          String gap = "HOUR";
          if(duration.toDays() >= 365)
            gap = "YEAR";
          else if(duration.toDays() >= 28)
            gap = "MONTH";
          else if(duration.toDays() >= 1)
            gap = "DAY";
          else if(duration.toHours() >= 1)
            gap = "HOUR";
          else if(duration.toMinutes() >= 1)
            gap = "MINUTE";
          else if(duration.toMillis() >= 1000)
            gap = "SECOND";
          else if(duration.toMillis() >= 1)
            gap = "MILLI";

          if(facetRangeStart2 == null)
            searchList.facetRangeStart(min.toString());
          if(facetRangeEnd2 == null)
            searchList.facetRangeEnd(max.toString());
          if(facetRangeGap2 == null)
            searchList.facetRangeGap(String.format("+1%s", gap));
          searchList.query().onSuccess(b -> {
            promise.complete(searchList);
          }).onFailure(ex -> {
            LOG.error(String.format("searchAirport failed. "), ex);
            promise.tryFail(ex);
          });
        } else {
          promise.complete(searchList);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("searchAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("searchAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
  public void searchAirport2(SiteRequest siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<Airport> searchList) {
  }

  public Future<Void> persistAirport(Airport o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      SqlConnection sqlConnection = siteRequest.getSqlConnection();
      Long pk = o.getPk();
      sqlConnection.preparedQuery("SELECT name, address, description, alternateName, created, location, codeIATA, id, codeICAO, archived, entityShortId, dataProvider, ngsildTenant, dateCreated, ngsildPath, dateModified, ngsildContext, owner, sessionId, ngsildData, seeAlso, userKey, color, source, objectTitle, displayPage, ST_AsGeoJSON(areaServed) as areaServed, editPage, userPage, download FROM Airport WHERE pk=$1")
          .collecting(Collectors.toList())
          .execute(Tuple.of(pk)
          ).onSuccess(result -> {
        try {
          for(Row definition : result.value()) {
            for(Integer i = 0; i < definition.size(); i++) {
              String columnName = definition.getColumnName(i);
              Object columnValue = definition.getValue(i);
              if(!"pk".equals(columnName)) {
                try {
                  o.persistForClass(columnName, columnValue);
                } catch(Exception e) {
                  LOG.error(String.format("persistAirport failed. "), e);
                }
              }
            }
          }
          o.promiseDeepForClass(siteRequest).onSuccess(a -> {
            if(config.getBoolean(ComputateConfigKeys.ENABLE_CONTEXT_BROKER_SEND)) {
              cbUpsertEntity(o, patch).onSuccess(b -> {
                promise.complete();
              }).onFailure(ex -> {
                LOG.error(String.format("persistAirport failed. "), ex);
                promise.tryFail(ex);
              });
            } else {
              promise.complete();
            }
          }).onFailure(ex -> {
            LOG.error(String.format("persistAirport failed. "), ex);
            promise.tryFail(ex);
          });
        } catch(Exception ex) {
          LOG.error(String.format("persistAirport failed. "), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        RuntimeException ex2 = new RuntimeException(ex);
        LOG.error(String.format("persistAirport failed. "), ex2);
        promise.tryFail(ex2);
      });
    } catch(Exception ex) {
      LOG.error(String.format("persistAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> cbUpsertEntity(Airport o, Boolean patch) {
    Promise<Void> promise = Promise.promise();
    try {
      ZonedDateTime observedAt = ZonedDateTime.now(ZoneId.of("UTC"));
      String observedAtStr = observedAt.format(ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER);
      JsonArray entityArray = new JsonArray();
      JsonObject entityBody = new JsonObject();
      entityBody.put("@context", config.getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT));
      entityBody.put("id", o.getId());
      entityBody.put("type", Airport.CLASS_SIMPLE_NAME);
      entityBody.put("NGSILD-Tenant"
          , new JsonObject()
          .put("type", "Property")
          .put("value", o.getNgsildTenant())
          .put("observedAt", observedAtStr)
          );
      entityBody.put("NGSILD-Path"
          , new JsonObject()
          .put("type", "Property")
          .put("value", o.getNgsildPath())
          .put("observedAt", observedAtStr)
          );

      List<String> vars = Airport.varsFqForClass();
      for (String var : vars) {
        String ngsiType = Airport.ngsiType(var);
        String displayName = Optional.ofNullable(Airport.displayNameAirport(var)).orElse(var);
        if (ngsiType != null && displayName != null && !var.equals("id") && !var.equals("ngsildData")) {
          Object value = o.obtainForClass(var);
          if(value != null) {
            Object ngsildVal = Airport.ngsiAirport(var, o);
            String ngsildType = Airport.ngsiType(var);
            if(ngsildVal != null) {
              entityBody.put(displayName
                  , new JsonObject()
                  .put("type", ngsildType)
                  .put("value", ngsildVal)
                  .put("observedAt", observedAtStr)
                  );
            }
          }
        }
      }
      entityArray.add(entityBody);
      LOG.debug(entityArray.encodePrettily());
      webClient.post(
          Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT))
          , config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME)
          , "/ngsi-ld/v1/entityOperations/upsert/"
          )
          .ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL)))
          .putHeader("Content-Type", "application/ld+json")
          .putHeader("Fiware-Service", o.getNgsildTenant())
          .putHeader("Fiware-ServicePath", o.getNgsildPath())
          .putHeader("NGSILD-Tenant", o.getNgsildTenant())
          .putHeader("NGSILD-Path", o.getNgsildPath())
          .sendJson(entityArray)
          .expecting(HttpResponseExpectation.SC_NO_CONTENT.or(HttpResponseExpectation.SC_CREATED)).onSuccess(b -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("cbUpsertEntity failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format("cbUpsertEntity failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<JsonObject> ngsildGetEntity(Airport o) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      String entityName = o.getName();
      String entityType = Airport.CLASS_SIMPLE_NAME;
      String entityId = o.getId();
      String ngsildUri = String.format("/ngsi-ld/v1/entities/%s", urlEncode(entityId));
      String ngsildContext = config.getString(ComputateConfigKeys.CONTEXT_BROKER_CONTEXT);
      String link = String.format("<%s>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"", ngsildContext);

      webClient.get(
          Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT))
          , config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME)
          , ngsildUri
          )
          .ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL)))
          .putHeader("Content-Type", "application/ld+json")
          .putHeader("Fiware-Service", o.getNgsildTenant())
          .putHeader("Fiware-ServicePath", o.getNgsildPath())
          .putHeader("NGSILD-Tenant", o.getNgsildTenant())
          .putHeader("NGSILD-Path", o.getNgsildPath())
          .putHeader("Link", link)
          .putHeader("Accept", "*/*")
          .send()
          .expecting(HttpResponseExpectation.SC_OK.or(HttpResponseExpectation.SC_NOT_FOUND)).onSuccess(entityResponse -> {
        JsonObject entity = entityResponse.bodyAsJsonObject();
        entity.remove("NGSILD data");
        promise.complete(entity);
      }).onFailure(ex -> {
        LOG.error(String.format("postIotServiceFuture failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Throwable ex) {
      LOG.error(String.format("postIotServiceFuture failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> cbDeleteEntity(Airport o) {
    Promise<Void> promise = Promise.promise();
    try {
      webClient.delete(
          Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT))
          , config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME)
          , String.format("/ngsi-ld/v1/entities/%s", urlEncode(o.getId()))
          )
          .ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL)))
          .putHeader("Content-Type", "application/ld+json")
          .putHeader("Fiware-Service", o.getNgsildTenant())
          .putHeader("Fiware-ServicePath", o.getNgsildPath())
          .putHeader("NGSILD-Tenant", o.getNgsildTenant())
          .putHeader("NGSILD-Path", o.getNgsildPath())
          .send()
          .expecting(HttpResponseExpectation.SC_NO_CONTENT).onSuccess(b -> {
        promise.complete();
      }).onFailure(ex -> {
        if("Response status code 404 is not equal to 204".equals(ex.getMessage())) {
          promise.complete();
        } else {
          LOG.error(String.format("cbDeleteEntity failed. "), ex);
          promise.tryFail(ex);
        }
      });
    } catch(Throwable ex) {
      LOG.error(String.format("cbDeleteEntity failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> relateAirport(Airport o) {
    Promise<Void> promise = Promise.promise();
    promise.complete();
    return promise.future();
  }

  public String searchVar(String varIndexed) {
    return Airport.searchVarAirport(varIndexed);
  }

  @Override
  public String getClassApiAddress() {
    return Airport.CLASS_API_ADDRESS_Airport;
  }

  public Future<Airport> indexAirport(Airport o) {
    Promise<Airport> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      JsonObject json = new JsonObject();
      JsonObject add = new JsonObject();
      json.put("add", add);
      JsonObject doc = new JsonObject();
      add.put("doc", doc);
      o.indexAirport(doc);
      String solrUsername = siteRequest.getConfig().getString(ConfigKeys.SOLR_USERNAME);
      String solrPassword = siteRequest.getConfig().getString(ConfigKeys.SOLR_PASSWORD);
      String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
      Integer solrPort = Integer.parseInt(siteRequest.getConfig().getString(ConfigKeys.SOLR_PORT));
      String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
      Boolean solrSsl = Boolean.parseBoolean(siteRequest.getConfig().getString(ConfigKeys.SOLR_SSL));
      Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
      Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
        if(softCommit == null && commitWithin == null)
          softCommit = true;
        else if(softCommit == null)
          softCommit = false;
      String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
      webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).putHeader("Content-Type", "application/json").sendBuffer(json.toBuffer()).expecting(HttpResponseExpectation.SC_OK).onSuccess(b -> {
        promise.complete(o);
      }).onFailure(ex -> {
        LOG.error(String.format("indexAirport failed. "), new RuntimeException(ex));
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("indexAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Airport> unindexAirport(Airport o) {
    Promise<Airport> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      o.promiseDeepForClass(siteRequest).onSuccess(a -> {
        JsonObject json = new JsonObject();
        JsonObject delete = new JsonObject();
        json.put("delete", delete);
        String query = String.format("filter(%s:%s)", Airport.VAR_solrId, o.obtainForClass(Airport.VAR_solrId));
        delete.put("query", query);
        String solrUsername = siteRequest.getConfig().getString(ConfigKeys.SOLR_USERNAME);
        String solrPassword = siteRequest.getConfig().getString(ConfigKeys.SOLR_PASSWORD);
        String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
        Integer solrPort = Integer.parseInt(siteRequest.getConfig().getString(ConfigKeys.SOLR_PORT));
        String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
        Boolean solrSsl = Boolean.parseBoolean(siteRequest.getConfig().getString(ConfigKeys.SOLR_SSL));
        Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
        Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
          if(softCommit == null && commitWithin == null)
            softCommit = true;
          else if(softCommit == null)
            softCommit = false;
        String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
        webClient.post(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).putHeader("Content-Type", "application/json").sendBuffer(json.toBuffer()).expecting(HttpResponseExpectation.SC_OK).onSuccess(b -> {
          promise.complete(o);
        }).onFailure(ex -> {
          LOG.error(String.format("unindexAirport failed. "), new RuntimeException(ex));
          promise.tryFail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("unindexAirport failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("unindexAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  public Future<Void> refreshAirport(Airport o) {
    Promise<Void> promise = Promise.promise();
    SiteRequest siteRequest = o.getSiteRequest_();
    try {
      ApiRequest apiRequest = siteRequest.getApiRequest_();
      List<String> solrIds = Optional.ofNullable(apiRequest).map(r -> r.getSolrIds()).orElse(new ArrayList<>());
      List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
      Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
      if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
        List<Future> futures = new ArrayList<>();

        for(int i=0; i < solrIds.size(); i++) {
          String solrId2 = solrIds.get(i);
          String classSimpleName2 = classes.get(i);
        }

        CompositeFuture.all(futures).onSuccess(b -> {
          JsonObject params = new JsonObject();
          params.put("body", new JsonObject());
          params.put("cookie", siteRequest.getServiceRequest().getParams().getJsonObject("cookie"));
          params.put("header", siteRequest.getServiceRequest().getParams().getJsonObject("header"));
          params.put("form", new JsonObject());
          params.put("path", new JsonObject());
          params.put("scopes", siteRequest.getScopes());
          JsonObject query = new JsonObject();
          Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
          Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
          if(softCommit == null && commitWithin == null)
            softCommit = true;
          if(softCommit != null)
            query.put("softCommit", softCommit);
          if(commitWithin != null)
            query.put("commitWithin", commitWithin);
          query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk())).put("var", new JsonArray().add("refresh:false"));
          params.put("query", query);
          JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
          JsonObject json = new JsonObject().put("context", context);
          eventBus.request(Airport.getClassApiAddress(), json, new DeliveryOptions().addHeader("action", "patchAirportFuture")).onSuccess(c -> {
            JsonObject responseMessage = (JsonObject)c.body();
            Integer statusCode = responseMessage.getInteger("statusCode");
            if(statusCode.equals(200))
              promise.complete();
            else
              promise.tryFail(new RuntimeException(responseMessage.getString("statusMessage")));
          }).onFailure(ex -> {
            LOG.error("Refresh relations failed. ", ex);
            promise.tryFail(ex);
          });
        }).onFailure(ex -> {
          LOG.error("Refresh relations failed. ", ex);
          promise.tryFail(ex);
        });
      } else {
        promise.complete();
      }
    } catch(Exception ex) {
      LOG.error(String.format("refreshAirport failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<JsonObject> generatePageBody(ComputateSiteRequest siteRequest, Map<String, Object> ctx, String templatePath, String classSimpleName, String pageTemplate) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      Map<String, Object> result = (Map<String, Object>)ctx.get("result");
      SiteRequest siteRequest2 = (SiteRequest)siteRequest;
      String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);
      Airport o = new Airport();
      o.setSiteRequest_((SiteRequest)siteRequest);

      o.persistForClass(Airport.VAR_name, Airport.staticSetName(siteRequest2, (String)result.get(Airport.VAR_name)));
      o.persistForClass(Airport.VAR_address, Airport.staticSetAddress(siteRequest2, (String)result.get(Airport.VAR_address)));
      o.persistForClass(Airport.VAR_description, Airport.staticSetDescription(siteRequest2, (String)result.get(Airport.VAR_description)));
      o.persistForClass(Airport.VAR_alternateName, Airport.staticSetAlternateName(siteRequest2, (String)result.get(Airport.VAR_alternateName)));
      o.persistForClass(Airport.VAR_created, Airport.staticSetCreated(siteRequest2, (String)result.get(Airport.VAR_created), Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))));
      o.persistForClass(Airport.VAR_location, Airport.staticSetLocation(siteRequest2, (String)result.get(Airport.VAR_location)));
      o.persistForClass(Airport.VAR_codeIATA, Airport.staticSetCodeIATA(siteRequest2, (String)result.get(Airport.VAR_codeIATA)));
      o.persistForClass(Airport.VAR_id, Airport.staticSetId(siteRequest2, (String)result.get(Airport.VAR_id)));
      o.persistForClass(Airport.VAR_codeICAO, Airport.staticSetCodeICAO(siteRequest2, (String)result.get(Airport.VAR_codeICAO)));
      o.persistForClass(Airport.VAR_archived, Airport.staticSetArchived(siteRequest2, (String)result.get(Airport.VAR_archived)));
      o.persistForClass(Airport.VAR_entityShortId, Airport.staticSetEntityShortId(siteRequest2, (String)result.get(Airport.VAR_entityShortId)));
      o.persistForClass(Airport.VAR_dataProvider, Airport.staticSetDataProvider(siteRequest2, (String)result.get(Airport.VAR_dataProvider)));
      o.persistForClass(Airport.VAR_ngsildTenant, Airport.staticSetNgsildTenant(siteRequest2, (String)result.get(Airport.VAR_ngsildTenant)));
      o.persistForClass(Airport.VAR_dateCreated, Airport.staticSetDateCreated(siteRequest2, (String)result.get(Airport.VAR_dateCreated)));
      o.persistForClass(Airport.VAR_ngsildPath, Airport.staticSetNgsildPath(siteRequest2, (String)result.get(Airport.VAR_ngsildPath)));
      o.persistForClass(Airport.VAR_dateModified, Airport.staticSetDateModified(siteRequest2, (String)result.get(Airport.VAR_dateModified)));
      o.persistForClass(Airport.VAR_ngsildContext, Airport.staticSetNgsildContext(siteRequest2, (String)result.get(Airport.VAR_ngsildContext)));
      o.persistForClass(Airport.VAR_owner, Airport.staticSetOwner(siteRequest2, (String)result.get(Airport.VAR_owner)));
      o.persistForClass(Airport.VAR_sessionId, Airport.staticSetSessionId(siteRequest2, (String)result.get(Airport.VAR_sessionId)));
      o.persistForClass(Airport.VAR_ngsildData, Airport.staticSetNgsildData(siteRequest2, (String)result.get(Airport.VAR_ngsildData)));
      o.persistForClass(Airport.VAR_seeAlso, Airport.staticSetSeeAlso(siteRequest2, (String)result.get(Airport.VAR_seeAlso)));
      o.persistForClass(Airport.VAR_userKey, Airport.staticSetUserKey(siteRequest2, (String)result.get(Airport.VAR_userKey)));
      o.persistForClass(Airport.VAR_color, Airport.staticSetColor(siteRequest2, (String)result.get(Airport.VAR_color)));
      o.persistForClass(Airport.VAR_source, Airport.staticSetSource(siteRequest2, (String)result.get(Airport.VAR_source)));
      o.persistForClass(Airport.VAR_objectTitle, Airport.staticSetObjectTitle(siteRequest2, (String)result.get(Airport.VAR_objectTitle)));
      o.persistForClass(Airport.VAR_displayPage, Airport.staticSetDisplayPage(siteRequest2, (String)result.get(Airport.VAR_displayPage)));
      o.persistForClass(Airport.VAR_areaServed, Airport.staticSetAreaServed(siteRequest2, (String)result.get(Airport.VAR_areaServed)));
      o.persistForClass(Airport.VAR_editPage, Airport.staticSetEditPage(siteRequest2, (String)result.get(Airport.VAR_editPage)));
      o.persistForClass(Airport.VAR_userPage, Airport.staticSetUserPage(siteRequest2, (String)result.get(Airport.VAR_userPage)));
      o.persistForClass(Airport.VAR_download, Airport.staticSetDownload(siteRequest2, (String)result.get(Airport.VAR_download)));

      o.promiseDeepForClass((SiteRequest)siteRequest).onSuccess(o2 -> {
        try {
          JsonObject data = JsonObject.mapFrom(o2);
          ctx.put("result", data.getMap());
          promise.complete(data);
        } catch(Exception ex) {
          LOG.error(String.format(importModelFail, classSimpleName), ex);
          promise.tryFail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("generatePageBody failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("generatePageBody failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
}
