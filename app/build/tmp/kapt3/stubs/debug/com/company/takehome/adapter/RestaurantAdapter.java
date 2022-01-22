package com.company.takehome.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0006\u0010\u0014\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/company/takehome/adapter/RestaurantAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/company/takehome/adapter/RestaurantAdapter$RestaurantViewHolder;", "()V", "restaurantList", "", "Lcom/company/takehome/data/Restaurant;", "addRestaurants", "", "restaurants", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetList", "RestaurantViewHolder", "app_debug"})
public final class RestaurantAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.company.takehome.adapter.RestaurantAdapter.RestaurantViewHolder> {
    private final java.util.List<com.company.takehome.data.Restaurant> restaurantList = null;
    
    public RestaurantAdapter() {
        super();
    }
    
    public final void addRestaurants(@org.jetbrains.annotations.NotNull()
    java.util.List<com.company.takehome.data.Restaurant> restaurants) {
    }
    
    public final void resetList() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.company.takehome.adapter.RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.company.takehome.adapter.RestaurantAdapter.RestaurantViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/company/takehome/adapter/RestaurantAdapter$RestaurantViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "restaurant", "Lcom/company/takehome/data/Restaurant;", "app_debug"})
    public static final class RestaurantViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public RestaurantViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.company.takehome.data.Restaurant restaurant) {
        }
    }
}