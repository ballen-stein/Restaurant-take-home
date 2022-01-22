// Generated by view binder compiler. Do not edit!
package com.company.takehome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.company.takehome.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RestaurantItemViewBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView restaurantNameTextView;

  @NonNull
  public final TextView restaurantRatingTextView;

  private RestaurantItemViewBinding(@NonNull CardView rootView, @NonNull ImageView imageView,
      @NonNull TextView restaurantNameTextView, @NonNull TextView restaurantRatingTextView) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.restaurantNameTextView = restaurantNameTextView;
    this.restaurantRatingTextView = restaurantRatingTextView;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static RestaurantItemViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RestaurantItemViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.restaurant_item_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RestaurantItemViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.restaurantNameTextView;
      TextView restaurantNameTextView = rootView.findViewById(id);
      if (restaurantNameTextView == null) {
        break missingId;
      }

      id = R.id.restaurantRatingTextView;
      TextView restaurantRatingTextView = rootView.findViewById(id);
      if (restaurantRatingTextView == null) {
        break missingId;
      }

      return new RestaurantItemViewBinding((CardView) rootView, imageView, restaurantNameTextView,
          restaurantRatingTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}