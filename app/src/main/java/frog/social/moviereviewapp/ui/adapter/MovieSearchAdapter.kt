package frog.social.moviereviewapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import frog.social.moviereviewapp.R
import frog.social.moviereviewapp.data.model.MovieSearchItem

class MovieSearchAdapter : RecyclerView.Adapter<MovieSearchAdapter.MovieSearchViewHolder>() {

    private var itemList: MutableList<MovieSearchItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_view, parent, false)
        return MovieSearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        val movieItem = itemList[position]
        Glide.with(holder.imageViewPoster.context)
            .load(movieItem.poster)
            .into(holder.imageViewPoster)

        holder.tvTitle.text = movieItem.title
        holder.tvReleaseYear.text = movieItem.year

    }

    fun setItems(items: List<MovieSearchItem>) {
        itemList.addAll(items.filter {
            (it.year?.toIntOrNull() ?: 0) > 2000
        })
        itemList.sortBy { it.year }
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    class MovieSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewPoster: ImageView = itemView.findViewById(R.id.iv_poster)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvReleaseYear: TextView = itemView.findViewById(R.id.tv_release_year)
    }
}