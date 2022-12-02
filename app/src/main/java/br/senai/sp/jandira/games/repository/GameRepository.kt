package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.model.Game

class GameRepository(context: Context) {

    private val db = GamesDb.getDataBase(context).gameDao()

    fun save(game: Game): Long {
        return db.save(game)
    }

    fun delete(game: Game): Int {
        return db.delete(game)
    }

    fun update(game: Game): Int {
        return db.update(game)
    }

    fun getAll(): List<Game> {
        return db.getAll()
    }

}