package com.company.takehome.views.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000e\u00a8\u00063"}, d2 = {"Lcom/company/takehome/views/fragment/MainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "animating", "", "binding", "Lcom/company/takehome/databinding/FragmentMainBinding;", "isLoading", "<set-?>", "", "noCounter", "getNoCounter", "()I", "setNoCounter", "(I)V", "noCounter$delegate", "Lkotlin/properties/ReadWriteProperty;", "restaurantAdapter", "Lcom/company/takehome/adapter/RestaurantAdapter;", "showError", "viewModel", "Lcom/company/takehome/views/fragment/MainFragmentViewModel;", "getViewModel", "()Lcom/company/takehome/views/fragment/MainFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "yesCounter", "getYesCounter", "setYesCounter", "yesCounter$delegate", "animateIcon", "", "drawable", "checkCurrentIndex", "currentItemIndex", "disableViews", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showApiError", "responseBody", "Lokhttp3/ResponseBody;", "showGenericError", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private boolean animating = false;
    private boolean isLoading = false;
    private boolean showError = false;
    private final com.company.takehome.adapter.RestaurantAdapter restaurantAdapter = null;
    private final kotlin.properties.ReadWriteProperty yesCounter$delegate = null;
    private final kotlin.properties.ReadWriteProperty noCounter$delegate = null;
    private com.company.takehome.databinding.FragmentMainBinding binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.takehome.views.fragment.MainFragment.Companion Companion = null;
    public static final int TWO_RESTAURANTS_REMAINING = 2;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_LONGITUDE = "longitude";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_LATITUDE = "latitude";
    private static final int THUMB_UP_ANIM = com.company.takehome.R.drawable.thumb_up;
    private static final int THUMB_DOWN_ANIM = com.company.takehome.R.drawable.thumb_down;
    private java.util.HashMap _$_findViewCache;
    
    public MainFragment() {
        super();
    }
    
    private final com.company.takehome.views.fragment.MainFragmentViewModel getViewModel() {
        return null;
    }
    
    private final int getYesCounter() {
        return 0;
    }
    
    private final void setYesCounter(int p0) {
    }
    
    private final int getNoCounter() {
        return 0;
    }
    
    private final void setNoCounter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkCurrentIndex(int currentItemIndex) {
    }
    
    private final void animateIcon(int drawable) {
    }
    
    private final void showApiError(okhttp3.ResponseBody responseBody) {
    }
    
    private final void showGenericError() {
    }
    
    private final void disableViews() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/company/takehome/views/fragment/MainFragment$Companion;", "", "()V", "ARG_LATITUDE", "", "ARG_LONGITUDE", "THUMB_DOWN_ANIM", "", "THUMB_UP_ANIM", "TWO_RESTAURANTS_REMAINING", "newInstance", "Lcom/company/takehome/views/fragment/MainFragment;", "longitude", "", "latitude", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.company.takehome.views.fragment.MainFragment newInstance(double longitude, double latitude) {
            return null;
        }
    }
}