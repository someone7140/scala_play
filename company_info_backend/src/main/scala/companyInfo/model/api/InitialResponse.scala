package companyInfo.model.api

case class InitialResponse
(
  var byNpmrSortCompanies: Seq[CompanyResponse] = Seq.empty, // 売上高当期純利益率順
  var byEquityRatioCompanies: Seq[CompanyResponse] = Seq.empty, // 純資産比率順
  var byRoaCompanies: Seq[CompanyResponse] = Seq.empty, // ROA順
  var byRoeCompanies: Seq[CompanyResponse] = Seq.empty, // ROE順
)
