package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_game")
class Game {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var foto: Bitmap? = null
    var titulo = ""
    var descricao = ""
    var estudio = ""

    @ColumnInfo(name = "ano_lancamento")
    var anoLancamento = 0

    var finalizado:Boolean = false
}