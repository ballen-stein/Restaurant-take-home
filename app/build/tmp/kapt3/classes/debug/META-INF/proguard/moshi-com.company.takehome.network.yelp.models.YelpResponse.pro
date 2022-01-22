-if class com.company.takehome.network.yelp.models.YelpResponse
-keepnames class com.company.takehome.network.yelp.models.YelpResponse
-if class com.company.takehome.network.yelp.models.YelpResponse
-keep class com.company.takehome.network.yelp.models.YelpResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.company.takehome.network.yelp.models.YelpResponse
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.company.takehome.network.yelp.models.YelpResponse
-keepclassmembers class com.company.takehome.network.yelp.models.YelpResponse {
    public synthetic <init>(java.util.List,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
