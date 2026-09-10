import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.profilesettings.core.database.AppDatabase
import com.example.profilesettings.feature.profile.page.impl.data.local.ProfilePageDbModel

@Database(entities = [ProfilePageDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun profileDao(): SettingsProfileDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "profiles.db"

        fun getInstance(application: Context): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context = application,
                    name = DB_NAME,
                    klass = AppDatabase::class.java
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}