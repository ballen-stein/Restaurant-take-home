package com.affirm.takehome.favorites.favoriterecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.affirm.takehome.R
import com.affirm.takehome.adapter.RestaurantAdapter
import com.affirm.takehome.data.Restaurant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.restaurant_item_view.view.*

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private val restaurantList = mutableListOf<Restaurant>()

    fun addRestaurants(restaurants: List<Restaurant>) {
        val oldPosition = restaurants.size
        restaurantList.addAll(restaurants)

        notifyItemRangeChanged(oldPosition, restaurants.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorited_view_item, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(restaurant: Restaurant) {
            itemView.restaurantNameTextView.text = restaurant.name
            if (restaurant.image.isNotBlank()) {
                Picasso.get()
                    .load(restaurant.image)
                    .placeholder(R.drawable.outline_restaurant_black_48)
                    .into(itemView.imageView)
            } else {
                // Load placeholder if there's no image
                itemView.background = AppCompatResources.getDrawable(itemView.context, R.drawable.outline_restaurant_black_48)
            }
        }
    }
}
