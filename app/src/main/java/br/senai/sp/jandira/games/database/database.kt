import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.dao.ConsoleDao
import br.senai.sp.jandira.games.dao.GameDao
import br.senai.sp.jandira.games.dao.UsuarioDao
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.ConsoleRepository

@Database(entities = [Usuario::class, Game::class, Console::class], version = 1)
abstract class GamesDb : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    abstract fun consoleDao(): ConsoleDao
    abstract fun gameDao(): GameDao

    companion object {

        private lateinit var instance: GamesDb
        private fun createConsoles(context: Context) {

            var console1 = Console()
            var console2 = Console()

            console1.consoleName = "PlayStation 5"
            console1.consoleProducer = "Sony"
            console1.consoleDescription = "O PlayStation 5 é um console de jogos eletrônicos de nona geração, desenvolvido pela Sony Interactive Entertainment. "
            console1.consoleReleaseDate = 2020


            console2.consoleName = "Xbox 360"
            console2.consoleProducer = "Microsoft"
            console2.consoleDescription = " O console substitui o Xbox antigo para ser o grande concorrente do PlayStation 3 na batalha da sétima geração de videogames."
            console2.consoleReleaseDate = 2005


            ConsoleRepository(context).save(console1)
            ConsoleRepository(context).save(console2)

        }

        fun getDataBase(context: Context): GamesDb {
            if (!Companion::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(context, GamesDb::class.java, "db_games")
                    .allowMainThreadQueries().build()
                if (ConsoleRepository(context).getAll().isEmpty())
                    createConsoles(context)
            }
            return instance
        }
    }
}