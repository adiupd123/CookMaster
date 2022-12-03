package com.adiupd123.cookmaster.classes

import com.fasterxml.jackson.annotation.JsonProperty

class Recipe(
    @JsonProperty("approved_at")val approved_at: Int,
    @JsonProperty("aspect_ratio") val aspect_ratio: String,
    @JsonProperty("beauty_url")val beauty_url: Any,
    @JsonProperty("brand")val brand: Any,
    @JsonProperty("brand_id")val brand_id: Any,
    @JsonProperty("buzz_id")val buzz_id: Any,
    @JsonProperty("canonical_id")val canonical_id: String,
    @JsonProperty("compilations")val compilations: List<Any>,
    @JsonProperty("cook_time_minutes")val cook_time_minutes: Any,
    @JsonProperty("country")val country: String,
    @JsonProperty("created_at") val created_at: Int,
    @JsonProperty("credits")val credits: List<Credit>,
    @JsonProperty("description")val description: String,
    @JsonProperty("draft_status")val draft_status: String,
    @JsonProperty("facebook_posts")val facebook_posts: List<Any>,
    @JsonProperty("id") val id: Int,
    @JsonProperty("inspired_by_url")val inspired_by_url: Any,
    @JsonProperty("instructions")val instructions: List<Instruction>,
    @JsonProperty("is_one_top")val is_one_top: Boolean,
    @JsonProperty("is_shoppable")val is_shoppable: Boolean,
    @JsonProperty("keywords")val keywords: String,
    @JsonProperty("language")val language: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("num_servings")val num_servings: Int,
    @JsonProperty("nutrition")val nutrition: Nutrition,
    @JsonProperty("nutrition_visibility")val nutrition_visibility: String,
    @JsonProperty("original_video_url")val original_video_url: Any,
    @JsonProperty("prep_time_minutes")val prep_time_minutes: Any,
    @JsonProperty("price")val price: Price,
    @JsonProperty("promotion")val promotion: String,
    @JsonProperty("renditions")val renditions: List<Any>,
    @JsonProperty("sections")val sections: List<Section>,
    @JsonProperty("seo_title")val seo_title: String,
    @JsonProperty("servings_noun_plural")val servings_noun_plural: String,
    @JsonProperty("servings_noun_singular")val servings_noun_singular: String,
    @JsonProperty("show")val show: Show,
    @JsonProperty("show_id")val show_id: Int,
    @JsonProperty("slug")val slug: String,
    @JsonProperty("tags")val tags: List<Tag>,
    @JsonProperty("thumbnail_alt_text")val thumbnail_alt_text: String,
    @JsonProperty("thumbnail_url") val thumbnail_url: String,
    @JsonProperty("tips_and_ratings_enabled")val tips_and_ratings_enabled: Boolean,
    @JsonProperty("topics")val topics: List<Topic>,
    @JsonProperty("total_time_minutes")val total_time_minutes: Any,
    @JsonProperty("total_time_tier")val total_time_tier: Any,
    @JsonProperty("updated_at")val updated_at: Int,
    @JsonProperty("user_ratings")val user_ratings: UserRatings,
    @JsonProperty("video_ad_content")val video_ad_content: Any,
    @JsonProperty("video_id")val video_id: Any,
    @JsonProperty("video_url")val video_url: Any,
    @JsonProperty("yields")val yields: String
)
