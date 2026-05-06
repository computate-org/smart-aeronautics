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

/**
 * Order: 8
 * Description: A work contract
 * AName: a contract
 * Icon: <i class="fa-duotone fa-regular  fa-conveyor-belt"></i>
 * Rows: 100
 * 
 * SearchPageUri: /en-us/search/contract
 * EditPageUri: /en-us/edit/contract/{contractId}
 * ApiUri: /en-us/api/contract
 * ApiMethod:
 *   Search:
 *   GET:
 *   PATCH:
 *   POST:
 *   DELETE:
 *   PUTImport:
 * AuthGroup:
 *   ContractViewer:
 *     GET:
 *   ContractEditor:
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
public class Contract extends ContractGen<BaseModel> {

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: contract region
   * Description: The region of this contract
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 1
   * HtmRowTitleOpen: contract details
   * Required: true
   * Facet: true
   **/
  protected void _region(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: contract name
   * Description: The name of this contract
   * HtmRow: 3
   * HtmCell: 2
   * HtmColumn: 2
   * Required: true
   * Facet: true
   **/
  protected void _name(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: contract abbreviation
   * Description: The abbreviation of this contract
   * HtmRow: 3
   * HtmCell: 3
   * HtmColumn: 3
   * Facet: true
   **/
  protected void _abbreviation(Wrap<String> w) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: contract ID
   * Description: The ID of this contract
   * VarName: true
   **/
  protected void _displayName(Wrap<String> w) {
    w.o(String.format("%s %s (%s)", region, name, abbreviation));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: contract ID
   * Description: The ID of this contract
   * VarId: true
   * Unique: true
   * Required: true
   * Facet: true
   **/
  protected void _contractId(Wrap<String> w) {
    w.o(toId(abbreviation));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: start date
   * Description: The start date of the contract
   * HtmRow: 3
   * HtmCell: 1
   * HtmColumn: 1
   **/
  protected void _startDate(Wrap<ZonedDateTime> w) {
    w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: investment years total
   * Description: The number of years of investment in the contract. 
   * HtmRowTitleOpen: contract projections
   * HtmRow: 4
   * HtmCell: 0
   **/
  protected void _investmentYearsTotal(Wrap<Integer> w) {
    w.o(10);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: investment years
   * Description: The years of investment in the contract. 
   * HtmRow: 4
   * HtmCell: 0
   **/
  protected void _investmentYears(List<Integer> l) {
    Integer startYear = startDate.getYear();
    for(Integer i = 0; i < investmentYearsTotal; i++) {
      l.add(startYear + i);
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: investments per year
   * Description: The amount of investment per year. 
   * HtmRow: 4
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _investmentsPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        l.add(new BigDecimal(0, new MathContext(16, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP));
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: cumulative investments per year
   * Description: The cumulative investment per year. 
   * HtmRow: 4
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _investmentsPerYearCumulative(List<BigDecimal> l) {
    BigDecimal cumulative = new BigDecimal(0, new MathContext(16, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
    for(Integer i = 0; i < investmentsPerYear.size(); i++) {
      cumulative = cumulative.add(investmentsPerYear.get(i), new MathContext(16, RoundingMode.HALF_UP));
      l.add(cumulative);
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: asset classes
   * Description: The asset classes of investment. 
   * HtmRow: 4
   * HtmCell: 0
   **/
  protected void _assetClasses(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: target IRR
   * Description: The targeted Internal Rate of Return per asset class. 
   * HtmRow: 4
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _assetClassesTargetIrr(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < assetClasses.size(); i++) {
        l.add(new BigDecimal(0.10, new MathContext(0, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP));
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: revenue streams
   * Description: The revenue streams of investment. 
   * HtmRow: 4
   * HtmCell: 0
   **/
  protected void _revenueStreams(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: economic output projections
   * Description: The economic output projections per revenue stream. 
   * HtmRow: 4
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _economicOutputProjections(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < revenueStreams.size(); i++) {
        l.add(new BigDecimal(0, new MathContext(16, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP));
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: total GDP impact
   * Description: The total GDP impact based on output projections per revenue stream. 
   * HtmRow: 4
   * HtmCell: 0
   * Precision: 16
   **/
  protected void _totalGdpImpact(Wrap<BigDecimal> w) {
    BigDecimal impact = new BigDecimal(0, new MathContext(16, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
    for(Integer i = 0; i < economicOutputProjections.size(); i++) {
      impact = impact.add(economicOutputProjections.get(i), new MathContext(16, RoundingMode.HALF_UP));
    }
    w.o(impact);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: economic output projections
   * Description: The economic output projections per revenue stream. 
   * HtmRow: 4
   * HtmCell: 0
   **/
  protected void _economicOutputProjectionsDataset(Wrap<JsonArray> w) {
    JsonArray datasets = new JsonArray();
    Integer numYears = investmentYears.size();
    for(Integer i = 0; i < revenueStreams.size(); i++) {
      JsonArray data = new JsonArray();
      String revenueStream = revenueStreams.get(i);
      BigDecimal projection = economicOutputProjections.get(i).divide(new BigDecimal(numYears), new MathContext(16, RoundingMode.HALF_UP));
      BigDecimal cumulativeProjection = new BigDecimal(0, new MathContext(16, RoundingMode.HALF_UP)).setScale(2);
      for(Integer j = 0; j < investmentYears.size(); j++) {
        cumulativeProjection = cumulativeProjection.add(projection, new MathContext(16, RoundingMode.HALF_UP));
        data.add(cumulativeProjection);
      }
      datasets.add(new JsonObject()
          .put("label", revenueStream)
          .put("data", data)
          .put("fill", true)
          );
    }
    w.o(datasets);
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: cumulative investment per year
   * Description: A chart of the cumulative investment per year. 
   * HtmRow: 4
   * HtmCell: 0
   * wa-line-chart:
   * div:
   *   class: wa-stack
   **/
  protected void _cumulativeInvestmentChart(Wrap<JsonObject> w) {
    w.o(new JsonObject()
      .put("data", new JsonObject()
        .put("labels", new JsonArray(investmentYears.stream().map(year -> year.toString()).collect(Collectors.toList())))
        .put("datasets", new JsonArray()
          .add(new JsonObject()
            .put("label", "cumulative investment")
            .put("data", new JsonArray(investmentsPerYearCumulative.stream().map(investment -> investment.toString()).collect(Collectors.toList())))
            .put("fill", -1)
          )
        )
      )
    );
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: architects per year
   * Description: The number of architects on the project per year. 
   * HtmRowTitleOpen: project expenses
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 1
   **/
  protected void _architectsPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        l.add(BigDecimal.ONE);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: remote developers per year
   * Description: The number of remote developers on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 1
   **/
  protected void _remoteDevelopersPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        l.add(BigDecimal.ONE);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: onsite developers per year
   * Description: The number of onsite developers on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 1
   **/
  protected void _onsiteDevelopersPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        l.add(BigDecimal.ONE);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: instructors per year
   * Description: The number of instructors on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 1
   **/
  protected void _instructorsPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        l.add(BigDecimal.ONE);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: remote developer pay per year
   * Description: The total costs for paying a SPINE software developer on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _remoteDeveloperPayPerYear(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: onsite developer pay per year
   * Description: The total costs for paying a SPINE software developer on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _onsiteDeveloperPayPerYear(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: architect pay per year
   * Description: The total costs for paying a SPINE software architect on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _architectPayPerYear(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: instructor pay per year
   * Description: The total costs for paying a SPINE instructor on the project per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _instructorPayPerYear(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: employee subscriptions per year
   * Description: The software subscriptions for each employee per year. 
   * HtmRow: 5
   * HtmCell: 0
   **/
  protected void _subscriptionsPerYear(List<String> l) {
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: subscription costs per year
   * Description: The individual software subscription costs per year. 
   * HtmRow: 5
   * HtmCell: 0
   **/
  protected void _subscriptionCostsPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < subscriptionsPerYear.size(); i++) {
        l.add(BigDecimal.ZERO);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: subscription costs per year
   * Description: The individual software subscription costs per year. 
   * HtmRow: 5
   * HtmCell: 0
   **/
  protected void _totalSubscriptionCostPerYear(Wrap<BigDecimal> w) {
    BigDecimal total = BigDecimal.ZERO;
    for(Integer i = 0; i < subscriptionCostsPerYear.size(); i++) {
      BigDecimal amount = subscriptionCostsPerYear.get(i);
      total = total.add(amount);
    }
    w.o(total);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: subscription costs per year
   * Description: The individual software subscription costs per year. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _employeeSubscriptionCostsPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        BigDecimal remoteDevelopersCount = remoteDevelopersPerYear.get(i);
        BigDecimal onsiteDevelopersCount = onsiteDevelopersPerYear.get(i);
        BigDecimal architectsCount = architectsPerYear.get(i);
        BigDecimal instructorsCount = instructorsPerYear.get(i);
        BigDecimal employeeCount = remoteDevelopersCount.add(onsiteDevelopersCount).add(architectsCount).add(instructorsCount);
        BigDecimal cost = totalSubscriptionCostPerYear.multiply(employeeCount.round(new MathContext(16, RoundingMode.UP)).setScale(0), staticMathContextEmployeeSubscriptionCostsPerYear());
        l.add(cost);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: employees per year dataset
   * Description: The chart data for employees per year. 
   **/
  protected void _employeesPerYearDataset(Wrap<JsonArray> w) {
    JsonArray datasets = new JsonArray();
    Integer numYears = investmentYears.size();
    List<String> employeeGroups = Arrays.asList("architects", "remote developers", "onsite developers", "instructors");
    for(Integer i = 0; i < employeeGroups.size(); i++) {
      JsonArray data = new JsonArray();
      String employeeGroup = employeeGroups.get(i);
      MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);
      for(Integer j = 0; j < investmentYears.size(); j++) {
        if("architects".equals(employeeGroup)) {
          data.add(architectsPerYear.get(j));
        } else if("remote developers".equals(employeeGroup)) {
          data.add(remoteDevelopersPerYear.get(j));
        } else if("onsite developers".equals(employeeGroup)) {
          data.add(onsiteDevelopersPerYear.get(j));
        } else if("instructors".equals(employeeGroup)) {
          data.add(instructorsPerYear.get(j));
        }
      }
      datasets.add(new JsonObject()
          .put("label", employeeGroup)
          .put("data", data)
          .put("fill", true)
          );
    }
    w.o(datasets);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: subscription costs per year dataset
   * Description: The chart data for subscription costs per year. 
   **/
  protected void _subscriptionCostsPerYearDataset(Wrap<JsonArray> w) {
    JsonArray datasets = new JsonArray();
    Integer numYears = investmentYears.size();
    for(Integer i = 0; i < subscriptionsPerYear.size(); i++) {
      JsonArray data = new JsonArray();
      String subscriptionName = subscriptionsPerYear.get(i);
      BigDecimal subscriptionCost = subscriptionCostsPerYear.get(i);
      MathContext mathContext = new MathContext(16, RoundingMode.HALF_UP);
      for(Integer j = 0; j < investmentYears.size(); j++) {
        BigDecimal remoteDevelopersCount = remoteDevelopersPerYear.get(j);
        BigDecimal onsiteDevelopersCount = onsiteDevelopersPerYear.get(j);
        BigDecimal architectsCount = architectsPerYear.get(j);
        BigDecimal instructorsCount = instructorsPerYear.get(j);
        BigDecimal employeeCount = remoteDevelopersCount.add(onsiteDevelopersCount).add(architectsCount).add(instructorsCount);
        BigDecimal cost = subscriptionCost.multiply(employeeCount.round(mathContext).setScale(0), mathContext).setScale(2);
        data.add(cost);
      }
      datasets.add(new JsonObject()
          .put("label", subscriptionName)
          .put("data", data)
          .put("fill", true)
          );
    }
    w.o(datasets);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift control plane nodes
   * Description: The total OpenShift control plane nodes
   * HtmRow: 6
   * HtmCell: 0
   **/
  protected void _openshiftControlPlaneNodes(Wrap<Integer> w) {
    w.o(0);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift control plane cores
   * Description: The number of OpenShift control plane cores per node
   * HtmRow: 6
   * HtmCell: 0
   **/
  protected void _openshiftControlPlaneCores(Wrap<Integer> w) {
    w.o(0);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift control plane cores
   * Description: The total OpenShift control plane cores for all nodes
   **/
  protected void _totalOpenshiftControlPlaneCores(Wrap<Integer> w) {
    w.o(openshiftControlPlaneNodes * openshiftControlPlaneCores);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift control plane hourly price
   * Description: The hourly price of OpenShift control plane cores
   * HtmRow: 6
   * HtmCell: 0
   * Scale: 6
   **/
  protected void _openshiftControlPlaneHourlyPrice(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift infra nodes
   * Description: The total OpenShift infra nodes
   * HtmRow: 6
   * HtmCell: 0
   **/
  protected void _openshiftInfraNodes(Wrap<Integer> w) {
    w.o(0);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift infra cores
   * Description: The number of OpenShift infra cores per node
   * HtmRow: 6
   * HtmCell: 0
   **/
  protected void _openshiftInfraCores(Wrap<Integer> w) {
    w.o(0);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: Total OpenShift infra cores
   * Description: The total OpenShift infra cores for all nodes
   **/
  protected void _totalOpenshiftInfraCores(Wrap<Integer> w) {
    w.o(openshiftInfraNodes * openshiftInfraCores);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift infra node hourly price
   * Description: The hourly price of OpenShift infra node cores
   * HtmRow: 6
   * HtmCell: 0
   * Scale: 6
   **/
  protected void _openshiftInfraHourlyPrice(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift worker nodes
   * Description: The total OpenShift worker nodes
   * HtmRow: 6
   * HtmCell: 0
   **/
  protected void _openshiftWorkerNodes(Wrap<Integer> w) {
    w.o(0);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift worker cores
   * Description: The number of OpenShift worker cores per node
   * HtmRow: 6
   * HtmCell: 0
   **/
  protected void _openshiftWorkerCores(Wrap<Integer> w) {
    w.o(0);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift worker cores
   * Description: The total OpenShift worker cores for all nodes
   **/
  protected void _totalOpenshiftWorkerCores(Wrap<Integer> w) {
    w.o(openshiftWorkerNodes * openshiftWorkerCores);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift worker node hourly price
   * Description: The hourly price of OpenShift worker node cores
   * HtmRow: 6
   * HtmCell: 0
   * Scale: 6
   **/
  protected void _openshiftWorkerHourlyPrice(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift storage per year
   * Description: The amount of storage required for the OpenShift cluster in TiB. 
   * HtmRow: 5
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _openshiftSSDStorageTiBPerYear(List<BigDecimal> l) {
    if(l.size() == 0) {
      for(Integer i = 0; i < investmentYearsTotal; i++) {
        l.add(BigDecimal.ZERO);
      }
    }
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: OpenShift SSD storage price
   * Description: The OpenShift SSD storage price per GiB. 
   * HtmRow: 6
   * HtmCell: 0
   * Scale: 6
   **/
  protected void _openshiftSSDStoragePrice(Wrap<BigDecimal> w) {
    w.o(BigDecimal.ZERO);
  }

  /**
   * {@inheritDoc}
   * DocValues: true
   * Persist: true
   * DisplayName: subscription costs per year
   * Description: The individual software subscription costs per year. 
   * HtmRow: 6
   * HtmCell: 0
   * Scale: 2
   **/
  protected void _openshiftCostsPerYear(List<BigDecimal> l) {
    BigDecimal hoursInYear = new BigDecimal(24).multiply(new BigDecimal(365));
    l.add(openshiftControlPlaneHourlyPrice.multiply(hoursInYear).multiply(new BigDecimal(totalOpenshiftControlPlaneCores), staticMathContextOpenshiftCostsPerYear()));
    l.add(openshiftInfraHourlyPrice.multiply(hoursInYear).multiply(new BigDecimal(totalOpenshiftInfraCores), staticMathContextOpenshiftCostsPerYear()));
    l.add(openshiftWorkerHourlyPrice.multiply(hoursInYear).multiply(new BigDecimal(totalOpenshiftWorkerCores), staticMathContextOpenshiftCostsPerYear()));
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: employees per year
   * Description: A chart of the number of employees per year. 
   * HtmRowTitleOpen: employees and expenses
   * HtmRow: 6
   * HtmCell: 0
   * wa-line-chart:
   * div:
   *   class: wa-stack
   **/
  protected void _employeesPerYearChart(Wrap<JsonObject> w) {
    w.o(new JsonObject()
      .put("data", new JsonObject()
        .put("labels", new JsonArray(investmentYears.stream().map(year -> year.toString()).collect(Collectors.toList())))
        .put("datasets", employeesPerYearDataset)
      )
      .put("options", new JsonObject()
        .put("scales", new JsonObject()
          .put("y", new JsonObject()
            .put("stacked", true)
          )
        )
      )
    );
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: project expenses
   * Description: A chart of the project expenses per year. 
   * HtmRow: 6
   * HtmCell: 0
   * wa-line-chart:
   **/
  protected void _projectExpensesChart(Wrap<JsonObject> w) {
    w.o(new JsonObject()
      .put("data", new JsonObject()
        .put("labels", new JsonArray(investmentYears.stream().map(year -> year.toString()).collect(Collectors.toList())))
        .put("datasets", subscriptionCostsPerYearDataset)
      )
      .put("options", new JsonObject()
        .put("scales", new JsonObject()
          .put("y", new JsonObject()
            .put("stacked", true)
          )
        )
      )
    );
  }

  /**
   * {@inheritDoc}
   * Stored: true
   * DisplayName: economic output projections
   * Description: A chart of the economic output projections per year. 
   * HtmRowTitleOpen: project economic output
   * HtmRow: 7
   * HtmCell: 0
   * wa-line-chart:
   * div:
   *   class: wa-stack
   **/
  protected void _economicOutputChart(Wrap<JsonObject> w) {
    w.o(new JsonObject()
      .put("data", new JsonObject()
        .put("labels", new JsonArray(investmentYears.stream().map(year -> year.toString()).collect(Collectors.toList())))
        .put("datasets", economicOutputProjectionsDataset)
      )
      .put("options", new JsonObject()
        .put("scales", new JsonObject()
          .put("y", new JsonObject()
            .put("stacked", true)
          )
        )
      )
    );
  }
}
