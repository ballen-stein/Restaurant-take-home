// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.company.takehome.network.yelp.models

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import java.lang.reflect.Constructor
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.emptySet
import kotlin.jvm.Volatile
import kotlin.text.buildString

public class YelpResponseJsonAdapter(
  moshi: Moshi
) : JsonAdapter<YelpResponse>() {
  private val options: JsonReader.Options = JsonReader.Options.of("businesses")

  private val listOfYelpRestaurantAdapter: JsonAdapter<List<YelpRestaurant>> =
      moshi.adapter(Types.newParameterizedType(List::class.java, YelpRestaurant::class.java),
      emptySet(), "restaurants")

  @Volatile
  private var constructorRef: Constructor<YelpResponse>? = null

  public override fun toString(): String = buildString(34) {
      append("GeneratedJsonAdapter(").append("YelpResponse").append(')') }

  public override fun fromJson(reader: JsonReader): YelpResponse {
    var restaurants: List<YelpRestaurant>? = null
    var mask0 = -1
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> {
          restaurants = listOfYelpRestaurantAdapter.fromJson(reader) ?:
              throw Util.unexpectedNull("restaurants", "businesses", reader)
          // $mask = $mask and (1 shl 0).inv()
          mask0 = mask0 and 0xfffffffe.toInt()
        }
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    if (mask0 == 0xfffffffe.toInt()) {
      // All parameters with defaults are set, invoke the constructor directly
      return  YelpResponse(
          restaurants = restaurants as List<YelpRestaurant>
      )
    } else {
      // Reflectively invoke the synthetic defaults constructor
      @Suppress("UNCHECKED_CAST")
      val localConstructor: Constructor<YelpResponse> = this.constructorRef ?:
          YelpResponse::class.java.getDeclaredConstructor(List::class.java,
          Int::class.javaPrimitiveType, Util.DEFAULT_CONSTRUCTOR_MARKER).also {
          this.constructorRef = it }
      return localConstructor.newInstance(
          restaurants,
          mask0,
          /* DefaultConstructorMarker */ null
      )
    }
  }

  public override fun toJson(writer: JsonWriter, value_: YelpResponse?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("businesses")
    listOfYelpRestaurantAdapter.toJson(writer, value_.restaurants)
    writer.endObject()
  }
}
