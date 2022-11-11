package br.senai.sp.jandira.games.dao

import androidx.room.*
import br.senai.sp.jandira.games.model.Console

@Dao
interface ConsoleDao {

    @Insert
    fun save(console: Console): Long

    @Delete
    fun delete(console: Console): Int

    @Update
    fun update(console: Console): Int

    @Query("SELECT * FROM tbl_console ORDER BY nome ASC")
    fun getAll(): List<Console>

    @Query("SELECT * FROM tbl_console WHERE id = :id")
    fun getContactById(id: Int): Console

}