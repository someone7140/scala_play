package companyInfo.model.rest

import companyInfo.model.api.CompanyResponse

case class GbizCompanyResponse
(
  companyId: GbizValue,
  companyName: GbizValue,
  address: GbizValue, // 住所
  accountingPeriod: GbizValue, // 決算期
  salesAmount: GbizValue, // 売上高
  netIncome: GbizValue, // 当期純利益
  totalAssets: GbizValue, // 総資産
  netAssets: GbizValue, // 純資産
  employees: GbizValue, // 従業員数
) {

  def convertCompanyResponse(): CompanyResponse = {
    CompanyResponse(
      companyId = companyId.value,
      companyName = companyName.value,
      address = address.value,
      accountingPeriod = accountingPeriod.value,
      salesAmount = BigDecimal(salesAmount.value).toBigInt,
      netIncome = BigDecimal(netIncome.value).toBigInt,
      totalAssets = BigDecimal(totalAssets.value).toBigInt,
      netAssets = BigDecimal(netAssets.value).toBigInt,
      employees = BigDecimal(employees.value).toBigInt,
      npmr = (BigDecimal(netIncome.value) / BigDecimal(salesAmount.value) * 100)
        .bigDecimal.setScale(2, java.math.RoundingMode.HALF_UP),
      roa = (BigDecimal(netIncome.value) / BigDecimal(totalAssets.value) * 100)
        .bigDecimal.setScale(2, java.math.RoundingMode.HALF_UP),
      roe = (BigDecimal(netIncome.value) / BigDecimal(netAssets.value) * 100)
        .bigDecimal.setScale(2, java.math.RoundingMode.HALF_UP),
      equityRatio = (BigDecimal(netAssets.value) / BigDecimal(totalAssets.value) * 100)
        .bigDecimal.setScale(2, java.math.RoundingMode.HALF_UP),
      salesPerEmployee = (BigDecimal(salesAmount.value) / BigDecimal(employees.value)).toBigInt
    )
  }

}
