package com.company.takehome.data;

import java.lang.System;

/**
 * Enum to keep track of the Restaurant list's state
 * YELP -> Showing Yelp items / Most recent API call was for YELP items
 * PLACES -> Showing Places items / Most recent API call was for PLACES items
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/company/takehome/data/RestaurantFetchState;", "", "(Ljava/lang/String;I)V", "YELP", "PLACES", "app_debug"})
public enum RestaurantFetchState {
    /*public static final*/ YELP /* = new YELP() */,
    /*public static final*/ PLACES /* = new PLACES() */;
    
    RestaurantFetchState() {
    }
}