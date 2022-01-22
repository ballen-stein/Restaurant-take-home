package com.affirm.takehome.favorites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.affirm.takehome.data.Restaurant
import com.affirm.takehome.databinding.ActivityFavoritesBinding
import com.affirm.takehome.favorites.favoriterecycler.FavoriteAdapter

class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding
    private var favoritedRestaurantsList = emptyList<Restaurant>()

    private val favoriteAdapter by lazy {
        FavoriteAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extraData: List<Restaurant> = intent.getParcelableArrayListExtra<Restaurant>(FAVORITED_RESTAURANTS) as ArrayList<Restaurant>
        favoritedRestaurantsList = extraData

        favoriteAdapter.addRestaurants(favoritedRestaurantsList)
        binding.favoritesList.layoutManager = LinearLayoutManager(this)
        binding.favoritesList.adapter = favoriteAdapter

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        const val FAVORITED_RESTAURANTS = "favoritedRestaurants"
    }
}
