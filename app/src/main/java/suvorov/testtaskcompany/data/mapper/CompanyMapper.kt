package suvorov.testtaskcompany.data.mapper

import suvorov.testtaskcompany.data.model.local.CompanyEntity
import suvorov.testtaskcompany.data.model.remote.Company
import suvorov.testtaskcompany.util.emptyStringIfNull

object CompanyMapper: BaseMapper<Company, CompanyEntity> {
    override fun map(item: Company): CompanyEntity {
        return CompanyEntity(
            item.id.emptyStringIfNull(),
            item.name.emptyStringIfNull(),
            item.img.emptyStringIfNull()
        )
    }
}