package companyInfo.model.rest

case class GbizResponse(results: GbizResponseBinding)

case class GbizResponseBinding(bindings: Seq[GbizCompanyResponse])
