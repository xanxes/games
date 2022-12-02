package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderGame>() {

    private var gamesList = listOf<Game>()

    fun updateGamesList(games: List<Game>) {
        this.gamesList = games
        notifyDataSetChanged()
    }

    class HolderGame(view: View): RecyclerView.ViewHolder(view) {
        val textGameTitle = view.findViewById<TextView>(R.id.text_view_empresa)
        val textDeveloper = view.findViewById<TextView>(R.id.text_view_titulo)
        val textDescription = view.findViewById<TextView>(R.id.text_view_desc)

        fun bind(game: Game) {
            textGameTitle.text = game.gameName
            textDeveloper.text = game.gameDeveloper
            textDescription.text = game.gameDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGame {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)

        return HolderGame(view)
    }

    override fun onBindViewHolder(holder: HolderGame, position: Int) {
        holder.bind(gamesList[position])
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}