package com.company.takehome.network.places;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/company/takehome/network/places/PlacesRestaurantService;", "", "getPlacesRestaurants", "Lretrofit2/Call;", "Lcom/company/takehome/network/places/models/PlacesResponse;", "location", "", "pageToken", "key", "rankBy", "type", "Companion", "app_debug"})
public abstract interface PlacesRestaurantService {
    @org.jetbrains.annotations.NotNull()
    public static final com.company.takehome.network.places.PlacesRestaurantService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY = "AIzaSyAcsY9zVrBham7BwJQzRNmtKfOkgtDPZsQ";
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "nearbysearch/json")
    public abstract retrofit2.Call<com.company.takehome.network.places.models.PlacesResponse> getPlacesRestaurants(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "location")
    java.lang.String location, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "pagetoken")
    java.lang.String pageToken, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "rankby")
    java.lang.String rankBy, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "type")
    java.lang.String type);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/company/takehome/network/places/PlacesRestaurantService$Companion;", "", "()V", "KEY", "", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String KEY = "AIzaSyAcsY9zVrBham7BwJQzRNmtKfOkgtDPZsQ";
        
        private Companion() {
            super();
        }
    }
}