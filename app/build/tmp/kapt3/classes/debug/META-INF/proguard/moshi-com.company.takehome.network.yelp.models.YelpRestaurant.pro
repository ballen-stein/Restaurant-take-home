-if class com.company.takehome.network.yelp.models.YelpRestaurant
-keepnames class com.company.takehome.network.yelp.models.YelpRestaurant
-if class com.company.takehome.network.yelp.models.YelpRestaurant
-keep class com.company.takehome.network.yelp.models.YelpRestaurantJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
