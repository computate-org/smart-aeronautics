package org.computate.smartaeronautics.model.contract;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
   * Stored: true
   * DisplayName: economic output projections
   * Description: A chart of the economic output projections per year. 
   * HtmRowTitleOpen: contract projections
   * HtmRow: 4
   * HtmCell: 0
   * wa-line-chart:
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
