package com.sample.sampleapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @Json(name = "Abstract")
    val `abstract`: String = "",
    @Json(name = "AbstractSource")
    val abstractSource: String = "",
    @Json(name = "AbstractText")
    val abstractText: String = "",
    @Json(name = "AbstractURL")
    val abstractURL: String = "",
    @Json(name = "Answer")
    val answer: String = "",
    @Json(name = "AnswerType")
    val answerType: String = "",
    @Json(name = "Definition")
    val definition: String = "",
    @Json(name = "DefinitionSource")
    val definitionSource: String = "",
    @Json(name = "DefinitionURL")
    val definitionURL: String = "",
    @Json(name = "Entity")
    val entity: String = "",
    @Json(name = "Heading")
    val heading: String = "",
    @Json(name = "Image")
    val image: String = "",
    @Json(name = "ImageHeight")
    val imageHeight: Int = 0,
    @Json(name = "ImageIsLogo")
    val imageIsLogo: Int = 0,
    @Json(name = "ImageWidth")
    val imageWidth: Int = 0,
    @Json(name = "Infobox")
    val infobox: String = "",
    @Json(name = "meta")
    val meta: Meta = Meta(),
    @Json(name = "Redirect")
    val redirect: String = "",
    @Json(name = "RelatedTopics")
    val relatedTopics: List<RelatedTopic> = listOf(),
    @Json(name = "Results")
    val results: List<Any> = listOf(),
    @Json(name = "Type")
    val type: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Meta(
        @Json(name = "attribution")
        val attribution: Any? = Any(),
        @Json(name = "blockgroup")
        val blockgroup: Any? = Any(),
        @Json(name = "created_date")
        val createdDate: Any? = Any(),
        @Json(name = "description")
        val description: String = "",
        @Json(name = "designer")
        val designer: Any? = Any(),
        @Json(name = "dev_date")
        val devDate: Any? = Any(),
        @Json(name = "dev_milestone")
        val devMilestone: String = "",
        @Json(name = "developer")
        val developer: List<Developer> = listOf(),
        @Json(name = "example_query")
        val exampleQuery: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "is_stackexchange")
        val isStackexchange: Any? = Any(),
        @Json(name = "js_callback_name")
        val jsCallbackName: String = "",
        @Json(name = "live_date")
        val liveDate: Any? = Any(),
        @Json(name = "maintainer")
        val maintainer: Maintainer = Maintainer(),
        @Json(name = "name")
        val name: String = "",
        @Json(name = "perl_module")
        val perlModule: String = "",
        @Json(name = "producer")
        val producer: Any? = Any(),
        @Json(name = "production_state")
        val productionState: String = "",
        @Json(name = "repo")
        val repo: String = "",
        @Json(name = "signal_from")
        val signalFrom: String = "",
        @Json(name = "src_domain")
        val srcDomain: String = "",
        @Json(name = "src_id")
        val srcId: Int = 0,
        @Json(name = "src_name")
        val srcName: String = "",
        @Json(name = "src_options")
        val srcOptions: SrcOptions = SrcOptions(),
        @Json(name = "src_url")
        val srcUrl: Any? = Any(),
        @Json(name = "status")
        val status: String = "",
        @Json(name = "tab")
        val tab: String = "",
        @Json(name = "topic")
        val topic: List<String> = listOf(),
        @Json(name = "unsafe")
        val unsafe: Int = 0
    ) {
        @JsonClass(generateAdapter = true)
        data class Developer(
            @Json(name = "name")
            val name: String = "",
            @Json(name = "type")
            val type: String = "",
            @Json(name = "url")
            val url: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class Maintainer(
            @Json(name = "github")
            val github: String = ""
        )

        @JsonClass(generateAdapter = true)
        data class SrcOptions(
            @Json(name = "directory")
            val directory: String = "",
            @Json(name = "is_fanon")
            val isFanon: Int = 0,
            @Json(name = "is_mediawiki")
            val isMediawiki: Int = 0,
            @Json(name = "is_wikipedia")
            val isWikipedia: Int = 0,
            @Json(name = "language")
            val language: String = "",
            @Json(name = "min_abstract_length")
            val minAbstractLength: String = "",
            @Json(name = "skip_abstract")
            val skipAbstract: Int = 0,
            @Json(name = "skip_abstract_paren")
            val skipAbstractParen: Int = 0,
            @Json(name = "skip_end")
            val skipEnd: String = "",
            @Json(name = "skip_icon")
            val skipIcon: Int = 0,
            @Json(name = "skip_image_name")
            val skipImageName: Int = 0,
            @Json(name = "skip_qr")
            val skipQr: String = "",
            @Json(name = "source_skip")
            val sourceSkip: String = "",
            @Json(name = "src_info")
            val srcInfo: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class RelatedTopic(
        @Json(name = "FirstURL")
        val firstURL: String = "",
        @Json(name = "Icon")
        val icon: Icon = Icon(),
        @Json(name = "Result")
        val result: String = "",
        @Json(name = "Text")
        val text: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Icon(
            @Json(name = "Height")
            val height: String = "",
            @Json(name = "URL")
            val uRL: String = "",
            @Json(name = "Width")
            val width: String = ""
        )
    }
}