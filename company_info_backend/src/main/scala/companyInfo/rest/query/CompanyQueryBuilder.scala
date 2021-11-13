package companyInfo.rest.query

object CompanyQueryBuilder {

  def getQuery(sort: String = ""): String = {
    val PREFIX = "PREFIX hj: <http://hojin-info.go.jp/ns/domain/biz/1#> PREFIX ic: <http://imi.go.jp/ns/core/rdf#> "
    val SELECT = "SELECT ?companyId ?companyName ?address ?accountingPeriod ?salesAmount ?netIncome ?totalAssets ?netAssets ?employees "
    val FROM = "FROM <http://hojin-info.go.jp/graph/zaimu> "
    val whereBySort = if (sort == "npmr") {
      "FILTER(?netIncome / ?salesAmount < 1) "
    } else if (sort == "roa") {
      "FILTER(?netIncome / ?totalAssets < 1) "
    } else if (sort == "equityRatio") {
      "FILTER(?netAssets / ?totalAssets < 1) "
    } else {
      ""
    }

    val WHERE = "WHERE { " +
      "?s hj:法人活動情報 ?o . " +
      "?o ic:ID/ic:識別値 ?companyId . " +
      "?o ic:名称/ic:表記 ?companyName . " +
      "?o ic:住所/ic:表記 ?address . " +
      "?o hj:書類情報/ic:記述/ic:説明 ?accountingPeriod . " +
      "?o hj:回次 ?kaiji . " +
      // 売上高
      "OPTIONAL{ " +
        "?o hj:数量コレクション/hj:数量 ?c2 . " +
        "?c2 ic:数値 ?salesAmount . " +
        "?c2 hj:指標 ?salesAmountName . " +
        "FILTER(?salesAmountName = \"http://hojin-info.go.jp/code/財務情報/売上高\"^^ic:コード型) } " +
      // 当期純利益
      "OPTIONAL{ " +
        "?o hj:数量コレクション/hj:数量 ?c3 . " +
        "?c3 ic:数値 ?netIncome . " +
        "?c3 hj:指標 ?netIncomeName . " +
        "FILTER(?netIncomeName = \"http://hojin-info.go.jp/code/財務情報/当期純利益又は当期純損失\"^^ic:コード型) } " +
      // 総資産
      "OPTIONAL{ " +
        "?o hj:数量コレクション/hj:数量 ?c4 . " +
        "?c4 ic:数値 ?totalAssets . " +
        "?c4 hj:指標 ?totalAssetsName . " +
        "FILTER(?totalAssetsName = \"http://hojin-info.go.jp/code/財務情報/総資産額\"^^ic:コード型) } " +
      // 純資産
      "OPTIONAL{ " +
        "?o hj:数量コレクション/hj:数量 ?c5 . " +
        "?c5 ic:数値 ?netAssets . " +
        "?c5 hj:指標 ?netAssetsName . " +
        "FILTER(?netAssetsName = \"http://hojin-info.go.jp/code/財務情報/純資産額\"^^ic:コード型) } " +
      // 従業員数
      "OPTIONAL{ " +
        "?o hj:数量コレクション/hj:数量 ?c6 . " +
        "?c6 ic:数値 ?employees . " +
        "?c6 hj:指標 ?employeesName . " +
        "FILTER(?employeesName = \"http://hojin-info.go.jp/code/財務情報/従業員数\"^^ic:コード型) } " +
      // Filter
      "FILTER(?kaiji = \"0\") " +
      "FILTER(!isBlank(?salesAmount)) " +
      "FILTER(!isBlank(?netIncome)) " +
      "FILTER(!isBlank(?totalAssets)) " +
      "FILTER(!isBlank(?netAssets)) " +
      "FILTER(!isBlank(?employees)) " +
      whereBySort +
      "} "
    val SORT = if (sort == "npmr") {
      "ORDER BY DESC(?netIncome / ?salesAmount) "
    } else if (sort == "roa") {
      "ORDER BY DESC(?netIncome / ?totalAssets) "
    } else if (sort == "roe") {
      "ORDER BY DESC(?netIncome / ?netAssets) "
    } else if (sort == "equityRatio") {
      "ORDER BY DESC(?netAssets / ?totalAssets) "
    } else {
      ""
    }
    val LIMIT = "LIMIT 30 "
    PREFIX + SELECT + FROM + WHERE + SORT + LIMIT
  }

}
