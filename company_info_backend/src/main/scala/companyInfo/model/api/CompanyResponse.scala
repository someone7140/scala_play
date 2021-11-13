package companyInfo.model.api

case class CompanyResponse
(
  companyId: String,
  companyName: String,
  address: String, // 住所
  accountingPeriod: String, // 決算期
  salesAmount: BigInt, // 売上高
  netIncome: BigInt, // 当期純利益
  totalAssets: BigInt, // 総資産
  netAssets: BigInt, // 純資産
  employees: BigInt, // 従業員数
  npmr: BigDecimal, // 売上高当期純利益率
  roa: BigDecimal, // ROA
  roe: BigDecimal, // ROE
  equityRatio: BigDecimal, // 純資産比率
  salesPerEmployee: BigInt, // 一人当たり売上高
)
