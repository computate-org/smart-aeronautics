package org.computate.smartaeronautics.model.contract;

import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.json.JsonObject;
import io.vertx.sqlclient.Pool;

import org.computate.smartaeronautics.request.SiteRequest;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import com.hubspot.jinjava.Jinjava;

/**
 * Translate: false
 **/
public class ContractEnUSApiServiceImpl extends ContractEnUSGenApiServiceImpl {

  @Override
  public Future<Contract> sqlPOSTContract(Contract o, Boolean inheritPrimaryKey) {
    Promise<Contract> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject jsonObject = siteRequest.getJsonObject();
      String region = jsonObject.getString(Contract.varJson(Contract.VAR_region, false));
      String name = jsonObject.getString(Contract.varJson(Contract.VAR_name, false));
      String contractId = Contract.toId(String.format("%s-%s", region, name));
      jsonObject.put(Contract.varJson(Contract.VAR_contractId, false), contractId);
      return super.sqlPOSTContract(o, inheritPrimaryKey).onSuccess(o2 -> {
        promise.complete(o2);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPOSTContract failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }

  @Override
  public Future<Contract> sqlPATCHContract(Contract o, Boolean inheritPrimaryKey) {
    Promise<Contract> promise = Promise.promise();
    try {
      SiteRequest siteRequest = o.getSiteRequest_();
      JsonObject jsonObject = siteRequest.getJsonObject();
      String region = jsonObject.getString(Contract.varJson(Contract.VAR_region, true), o.getRegion());
      String name = jsonObject.getString(Contract.varJson(Contract.VAR_name, true), o.getName());
      String contractId = Contract.toId(String.format("%s-%s", region, name));
      jsonObject.put(Contract.varJson(Contract.VAR_contractId, true), contractId);
      return super.sqlPATCHContract(o, inheritPrimaryKey).onSuccess(o2 -> {
        promise.complete(o2);
      }).onFailure(ex -> {
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("sqlPATCHContract failed. "), ex);
      promise.tryFail(ex);
    }
    return promise.future();
  }
}
