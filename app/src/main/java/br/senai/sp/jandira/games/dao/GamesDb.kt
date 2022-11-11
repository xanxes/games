package br.senai.sp.jandira.games.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.Usuario

@Database(entities = [Game::class, Console::class, Usuario::class], version = 1)
abstract class GamesDb: RoomDatabase() {

    abstract fun UsuarioDao(): UsuarioDao
    abstract fun GameDao(): GameDao
    abstract fun ConsoleDao(): ConsoleDao


    companion object {
        private lateinit var instance: GamesDb

        //singletone
        fun  getDataBase(context: Context): GamesDb{
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, GamesDb::class.java, "db_jogos").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}