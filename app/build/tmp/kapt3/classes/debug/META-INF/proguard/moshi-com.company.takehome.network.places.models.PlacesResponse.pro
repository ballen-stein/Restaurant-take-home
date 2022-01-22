-if class com.company.takehome.network.places.models.PlacesResponse
-keepnames class com.company.takehome.network.places.models.PlacesResponse
-if class com.company.takehome.network.places.models.PlacesResponse
-keep class com.company.takehome.network.places.models.PlacesResponseJsonAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
-if class com.company.takehome.network.places.models.PlacesResponse
-keepnames class kotlin.jvm.internal.DefaultConstructorMarker
-if class com.company.takehome.network.places.models.PlacesResponse
-keepclassmembers class com.company.takehome.network.places.models.PlacesResponse {
    public synthetic <init>(java.util.List,java.lang.String,int,kotlin.jvm.internal.DefaultConstructorMarker);
}
