package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.model.Usuario

class UsuarioRepository(context: Context) {

    private val db = GamesDb.getDataBase(context).usuarioDao()

    fun save(usuario: Usuario): Long {
        return db.save(usuario)
    }

    fun delete(usuario: Usuario): Int {
        return db.delete(usuario)
    }

    fun update(usuario: Usuario): Int {
        return db.update(usuario)
    }

    fun getAll(): List<Usuario> {
        return db.getAll()
    }



}