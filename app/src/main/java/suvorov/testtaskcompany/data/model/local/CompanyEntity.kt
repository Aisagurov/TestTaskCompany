package suvorov.testtaskcompany.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class CompanyEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val img: String
)