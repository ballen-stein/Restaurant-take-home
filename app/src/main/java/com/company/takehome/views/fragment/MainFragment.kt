package com.company.takehome.views.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.company.takehome.R
import com.company.takehome.adapter.RestaurantAdapter
import com.company.takehome.data.RestaurantFetchState
import com.company.takehome.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.ResponseBody
import kotlin.properties.Delegates

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by viewModels()

    private var animating = false

    private var isLoading = false
    private var showError = false

    private val restaurantAdapter = RestaurantAdapter()

    private var yesCounter: Int by Delegates.observable(0) { _, _, newValue ->
        binding.yesCounterText.text = newValue.toString()
    }

    private var noCounter: Int by Delegates.observable(0) { _, _, newValue ->
        binding.noCounterText.text = newValue.toString()
    }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val longitude = arguments?.getDouble(ARG_LONGITUDE) ?: 0.0
        val latitude = arguments?.getDouble(ARG_LATITUDE) ?: 0.0
        viewModel.init(longitude, latitude)

        viewModel.restaurantList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                restaurantAdapter.addRestaurants(it)
            }
        }

        viewModel.showApiError.observe(viewLifecycleOwner) {
            if (it != null) {
                showApiError(it)
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            isLoading = it
        }

        viewModel.showError.observe(viewLifecycleOwner) {
            showError = it
        }

        binding.viewPager.adapter = restaurantAdapter
        binding.viewPager.isUserInputEnabled = false

        binding.yesButton.setOnClickListener {
            // Check if we have an error from hitting the end of the dataset;
            // if we do, and the view is at the end of the data, show the error dialog
            if (showError && binding.viewPager.currentItem + 1 == restaurantAdapter.itemCount) {
                showGenericError()
            }

            // Make sure the previous animation finishes
            if (!animating) {
                yesCounter++
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
                animateIcon(THUMB_UP_ANIM)

                // If we're not loading, check if we can should an API request
                if (!isLoading && !showError) {
                    checkCurrentIndex(binding.viewPager.currentItem)
                }
            }
        }

        binding.noButton.setOnClickListener {
            // Check if we have an error from hitting the end of the dataset;
            // if we do, and the view is at the end of the data, show the error dialog
            if (showError && binding.viewPager.currentItem + 1 == restaurantAdapter.itemCount) {
                showError
            }

            // Make sure the previous animation finishes
            if (!animating) {
                noCounter++
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
                animateIcon(THUMB_DOWN_ANIM)

                // If we're not loading, check if we can should an API request
                if (!isLoading && !showError) {
                    checkCurrentIndex(binding.viewPager.currentItem)
                }
            }
        }

        binding.yesCounterText.text = yesCounter.toString()
        binding.noCounterText.text = noCounter.toString()

        viewModel.fetchRestaurants()
    }

    private fun checkCurrentIndex(currentItemIndex: Int) {
        val amountOfRestaurants = restaurantAdapter.itemCount
        // When there's "a couple" (2) or less restaurants remaining, fetch more
        if (amountOfRestaurants - currentItemIndex <= TWO_RESTAURANTS_REMAINING) {
            viewModel.currentState = when (viewModel.currentState) {
                RestaurantFetchState.YELP -> {
                    // Currently viewing YELP items; switch to PLACES and make API call
                    RestaurantFetchState.PLACES
                }
                RestaurantFetchState.PLACES -> {
                    // Currently viewing PLACES items; switch to YELP and make API call
                    RestaurantFetchState.YELP
                }
            }
            viewModel.fetchRestaurants()
        }
    }

    private fun animateIcon(drawable: Int) {
        animating = true
        binding.icon.apply {
            setImageDrawable(ContextCompat.getDrawable(requireContext(), drawable))
            alpha = 0.5f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .setDuration(300)
                .scaleX(2f)
                .scaleY(2f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        binding.icon.visibility = View.GONE
                        animating = false
                    }
                })
        }
    }

    private fun showApiError(responseBody: ResponseBody) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error with API or Connection")
            .setMessage("There's an issue with the API/Connection\n\n${responseBody.string()}")
            .setPositiveButton("OK") { _, _ ->
                Log.e( "Error","API Error : ${responseBody.string()}")
            }
            .setOnDismissListener {
                Log.e("Error", "API Error : ${responseBody.string()}")
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun showGenericError() {
        AlertDialog.Builder(requireContext())
            .setTitle("End of the List")
            .setMessage("Oh no! You've reached the end of the list! Thanks for playing!")
            .setPositiveButton("This is OK") { _, _ ->
                Log.d("Error", "User is happy that the list is done")
                disableViews()
            }
            .setNegativeButton("This is not OK") { _, _ ->
                Log.d("Error", "User is not happy that the list is done")
                disableViews()
            }
            .setOnDismissListener {
                disableViews()
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun disableViews() {
        // Disable the buttons to prevent the counters from incrementing
        binding.yesButton.isEnabled = false
        binding.noButton.isEnabled = false
    }

    companion object {
        // Value to make next API call at
        const val TWO_RESTAURANTS_REMAINING = 2

        // ARGs
        const val ARG_LONGITUDE = "longitude"
        const val ARG_LATITUDE = "latitude"

        // Animation Icons
        private const val THUMB_UP_ANIM = R.drawable.thumb_up
        private const val THUMB_DOWN_ANIM = R.drawable.thumb_down

        fun newInstance(longitude: Double, latitude: Double): MainFragment {
            val args = Bundle().apply {
                putDouble(ARG_LONGITUDE, longitude)
                putDouble(ARG_LATITUDE, latitude)
            }
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
