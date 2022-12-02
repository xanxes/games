package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_game")
class Game {

    @PrimaryKey(autoGenerate = true)
    var code = 0

    @ColumnInfo(name = "game_name")
    var gameName = ""

    @ColumnInfo(name = "game_developer")
    var gameDeveloper = ""

    @ColumnInfo(name = "game_description")
    var gameDescription = ""

    @ColumnInfo(name = "game_release_date")
    var gameReleaseDate = ""

    @ColumnInfo(name = "game_status")
    var gameStatus = ""

    var userId = 0
}