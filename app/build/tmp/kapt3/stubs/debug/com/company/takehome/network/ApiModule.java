package com.company.takehome.network;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/company/takehome/network/ApiModule;", "", "()V", "placesRestaurantService", "Lcom/company/takehome/network/places/PlacesRestaurantService;", "moshi", "Lcom/squareup/moshi/Moshi;", "yelpRestaurantService", "Lcom/company/takehome/network/yelp/YelpRestaurantService;", "Companion", "app_debug"})
@dagger.Module()
public final class ApiModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.company.takehome.network.ApiModule.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PLACES_API_BASE_URL = "https://maps.googleapis.com/maps/api/place/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String YELP_API_BASE_URL = "https://api.yelp.com/";
    
    public ApiModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.company.takehome.network.yelp.YelpRestaurantService yelpRestaurantService(@org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.company.takehome.network.places.PlacesRestaurantService placesRestaurantService(@org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/company/takehome/network/ApiModule$Companion;", "", "()V", "PLACES_API_BASE_URL", "", "YELP_API_BASE_URL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}