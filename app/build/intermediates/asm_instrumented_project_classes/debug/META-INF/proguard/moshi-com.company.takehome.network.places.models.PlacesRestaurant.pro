-if class com.company.takehome.network.places.models.PlacesRestaurant
-keepnames class com.company.takehome.network.places.models.PlacesRestaurant
-if class com.company.takehome.network.places.models.PlacesRestaurant
-keep class com.company.takehome.network.places.models.PlacesRestaurantJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.company.takehome.network.places.models.PlacesRestaurant
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.company.takehome.network.places.models.PlacesRestaurant
-keepclassmembers class com.company.takehome.network.places.models.PlacesRestaurant {
    public synthetic <init>(java.lang.String,java.lang.String,java.util.List,java.lang.String,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
