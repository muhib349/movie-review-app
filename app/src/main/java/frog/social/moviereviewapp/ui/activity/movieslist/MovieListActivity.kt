package frog.social.moviereviewapp.ui.activity.movieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import frog.social.moviereviewapp.R
import frog.social.moviereviewapp.data.model.MovieSearchItem
import frog.social.moviereviewapp.databinding.ActivityMovieListBinding
import frog.social.moviereviewapp.ui.adapter.MovieSearchAdapter

@AndroidEntryPoint
class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding

    private val viewModel: MovieListViewModel by viewModels()

    private var movieSearchList: List<MovieSearchItem> = emptyList()
    private var adapter = MovieSearchAdapter()
    private var pageNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

        viewModel.getMovies(pageNumber)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        viewModel.moviesData.observe(this){
            it?.let {
                movieSearchList = it.search
                adapter.setItems(movieSearchList)
            }
        }

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = adapter.itemCount

                if (lastVisibleItemPosition == totalItemCount - 1) {
                    viewModel.getMovies(++pageNumber)
                }
            }
        })
    }
}