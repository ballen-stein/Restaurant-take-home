package com.affirm.takehome.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.affirm.takehome.R
import com.affirm.takehome.data.Restaurant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.restaurant_item_view.view.*

class RestaurantAdapter: RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private val restaurantList = mutableListOf<Restaurant>()

    fun addRestaurants(restaurants: List<Restaurant>) {
        val oldPosition = restaurants.size
        restaurantList.addAll(restaurants)

        notifyItemRangeChanged(oldPosition, restaurants.size)
    }

    fun getCurrentRestaurant(index: Int): Restaurant {
        return restaurantList[index]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item_view, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class RestaurantViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(restaurant: Restaurant) {
            itemView.restaurantNameTextView.text = restaurant.name
            itemView.restaurantRatingTextView.text = restaurant.rating
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
