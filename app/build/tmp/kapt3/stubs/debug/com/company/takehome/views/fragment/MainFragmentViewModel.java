package com.company.takehome.views.fragment;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0006\u0010\'\u001a\u00020(J\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/company/takehome/views/fragment/MainFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "yelpManager", "Lcom/company/takehome/network/yelp/YelpRestaurantService;", "placesRestaurantApi", "Lcom/company/takehome/network/places/PlacesRestaurantService;", "(Lcom/company/takehome/network/yelp/YelpRestaurantService;Lcom/company/takehome/network/places/PlacesRestaurantService;)V", "_isLoading", "Landroidx/lifecycle/MutableLiveData;", "", "_restaurantList", "", "Lcom/company/takehome/data/Restaurant;", "_showApiError", "Lokhttp3/ResponseBody;", "_showError", "currentState", "Lcom/company/takehome/data/RestaurantFetchState;", "getCurrentState", "()Lcom/company/takehome/data/RestaurantFetchState;", "setCurrentState", "(Lcom/company/takehome/data/RestaurantFetchState;)V", "isLoading", "()Landroidx/lifecycle/MutableLiveData;", "latitude", "", "longitude", "nextPageToken", "", "offset", "", "restaurantList", "getRestaurantList", "showApiError", "getShowApiError", "showError", "getShowError", "fetchPlacesRestaurants", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRestaurants", "", "fetchYelpRestaurants", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "app_debug"})
public final class MainFragmentViewModel extends androidx.lifecycle.ViewModel {
    private final com.company.takehome.network.yelp.YelpRestaurantService yelpManager = null;
    private final com.company.takehome.network.places.PlacesRestaurantService placesRestaurantApi = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.company.takehome.data.Restaurant>> _restaurantList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.company.takehome.data.Restaurant>> restaurantList = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _showError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> showError = null;
    private final androidx.lifecycle.MutableLiveData<okhttp3.ResponseBody> _showApiError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<okhttp3.ResponseBody> showApiError = null;
    @org.jetbrains.annotations.NotNull()
    private com.company.takehome.data.RestaurantFetchState currentState = com.company.takehome.data.RestaurantFetchState.YELP;
    private java.lang.String nextPageToken;
    private int offset = 0;
    private double longitude = 0.0;
    private double latitude = 0.0;
    
    @javax.inject.Inject()
    public MainFragmentViewModel(@org.jetbrains.annotations.NotNull()
    com.company.takehome.network.yelp.YelpRestaurantService yelpManager, @org.jetbrains.annotations.NotNull()
    com.company.takehome.network.places.PlacesRestaurantService placesRestaurantApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.company.takehome.data.Restaurant>> getRestaurantList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getShowError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<okhttp3.ResponseBody> getShowApiError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.takehome.data.RestaurantFetchState getCurrentState() {
        return null;
    }
    
    public final void setCurrentState(@org.jetbrains.annotations.NotNull()
    com.company.takehome.data.RestaurantFetchState p0) {
    }
    
    public final void init(double longitude, double latitude) {
    }
    
    public final void fetchRestaurants() {
    }
    
    private final java.lang.Object fetchYelpRestaurants(int offset, kotlin.coroutines.Continuation<? super java.util.List<com.company.takehome.data.Restaurant>> p1) {
        return null;
    }
    
    private final java.lang.Object fetchPlacesRestaurants(kotlin.coroutines.Continuation<? super java.util.List<com.company.takehome.data.Restaurant>> p0) {
        return null;
    }
}