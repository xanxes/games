package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    fun save(usuario: Usuario): Long

    @Delete
    fun delete(usuario: Usuario): Int

    @Update
    fun update(usuario: Usuario): Int

    @Query("SELECT * FROM tbl_usuario ORDER BY user_name ASC")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM tbl_usuario WHERE codeConsole = :id")
    fun getContactById(id: Int): Usuario

}