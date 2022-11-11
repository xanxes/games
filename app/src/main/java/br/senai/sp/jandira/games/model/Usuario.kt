package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_usuario")
class Usuario {
        @PrimaryKey(autoGenerate = true)
        var id = 0
        var foto: Bitmap? = null
        var email = ""
        var senha = ""
        var nome = ""
        var cidade = ""

        @ColumnInfo(name = "data_nascimento")
        var dataNascimento: LocalDate? = null

        var nivel = NiveisEnum.INICIANTE
        var console: Console? = null
        var sexo =  'I'
}