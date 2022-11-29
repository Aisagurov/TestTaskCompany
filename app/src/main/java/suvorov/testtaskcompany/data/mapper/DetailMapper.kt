package suvorov.testtaskcompany.data.mapper

import suvorov.testtaskcompany.data.model.local.DetailEntity
import suvorov.testtaskcompany.data.model.remote.Detail
import suvorov.testtaskcompany.util.emptyDoubleIfNull
import suvorov.testtaskcompany.util.emptyStringIfNull

object DetailMapper: BaseMapper<List<Detail>, DetailEntity> {
    override fun map(item: List<Detail>): DetailEntity {
        return item.let {
            DetailEntity(
                it.first().id.emptyStringIfNull(),
                it.first().name.emptyStringIfNull(),
                it.first().img.emptyStringIfNull(),
                it.first().description.emptyStringIfNull(),
                it.first().lat.emptyDoubleIfNull(),
                it.first().lon.emptyDoubleIfNull(),
                it.first().www.emptyStringIfNull(),
                it.first().phone.emptyStringIfNull()
            )
        }
    }
}
