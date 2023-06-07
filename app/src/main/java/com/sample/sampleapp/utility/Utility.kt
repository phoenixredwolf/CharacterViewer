package com.sample.sampleapp.utility

import com.sample.sampleapp.data.model.CharacterResponse
import org.json.JSONObject

fun getName(str: String): String {
    return str.split("/").last().replace("_", " ")
}

val mockCharacter = CharacterResponse(
    abstract = "",
    abstractSource = "Wikipedia",
    abstractText = "",
    abstractURL = "https://en.wikipedia.org/wiki/The_Simpsons_characters",
    answer = "",
    answerType = "",
    definition = "",
    definitionSource = "",
    definitionURL = "",
    entity = "",
    heading = "The Simpsons characters",
    image = "",
    imageHeight = 0,
    imageIsLogo = 0,
    imageWidth = 0,
    infobox = "",
    redirect = "",
    relatedTopics = listOf(
        CharacterResponse.RelatedTopic(
            "https://duckduckgo.com/Apu_Nahasapeemapetilan",
            CharacterResponse.RelatedTopic.Icon(
                "",
                "",
                ""
            ),
            "<a href=\"https://duckduckgo.com/Apu_Nahasapeemapetilan\">Apu Nahasapeemapetilan</a><br>Apu Nahasapeemapetilan is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \"Thank you, come again\".",
            "Apu Nahasapeemapetilan - Apu Nahasapeemapetilan is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \"Thank you, come again\"."
        ),
        CharacterResponse.RelatedTopic(
            "https://duckduckgo.com/Apu_Nahasapeemapetilon",
            CharacterResponse.RelatedTopic.Icon(
                "",
                "/i/99b04638.png",
                ""
            ),
            "<a href=\"https://duckduckgo.com/Apu_Nahasapeemapetilon\">Apu Nahasapeemapetilon</a><br>Apu Nahasapeemapetilon is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \"Thank you, come again\".",
            "Apu Nahasapeemapetilon - Apu Nahasapeemapetilon is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \"Thank you, come again\"."
        ),
        CharacterResponse.RelatedTopic(
            "https://duckduckgo.com/Barney_Gumble",
            CharacterResponse.RelatedTopic.Icon(
                "",
                "/i/39ce98c0.png",
                ""
            ),
            "<a href=\"https://duckduckgo.com/Barney_Gumble\">Barney Gumble</a><br>Barnard Arnold \"Barney\" Gumble is a recurring character in the American animated TV series The Simpsons. He is voiced by Dan Castellaneta and first appeared in the series premiere episode \"Simpsons Roasting on an Open Fire\". Barney is the town drunk of Springfield and one of Homer Simpson's friends.",
            "Barney Gumble - Barnard Arnold \"Barney\" Gumble is a recurring character in the American animated TV series The Simpsons. He is voiced by Dan Castellaneta and first appeared in the series premiere episode \"Simpsons Roasting on an Open Fire\". Barney is the town drunk of Springfield and one of Homer Simpson's friends."
        ),
        CharacterResponse.RelatedTopic(
            "https://duckduckgo.com/Bart_Simpson",
            CharacterResponse.RelatedTopic.Icon(
                "",
                "",
                ""
            ),
            "<a href=\"https://duckduckgo.com/Bart_Simpson\">Bart Simpson</a><br>Bartholomew Jojo \"Bart\" Simpson is a fictional character in the American animated television series The Simpsons and part of the Simpson family. He is voiced by Nancy Cartwright and first appeared on television in The Tracey Ullman Show short \"Good Night\" on April 19, 1987.",
            "Bart Simpson - Bartholomew Jojo \"Bart\" Simpson is a fictional character in the American animated television series The Simpsons and part of the Simpson family. He is voiced by Nancy Cartwright and first appeared on television in The Tracey Ullman Show short \"Good Night\" on April 19, 1987."
        ),
        CharacterResponse.RelatedTopic(
            "https://duckduckgo.com/Bender_(Futurama)",
            CharacterResponse.RelatedTopic.Icon(
                "",
                "/i/cb4121fd.png",
                ""
            ),
            "<a href=\"https://duckduckgo.com/Bender_(Futurama)\">Bender (Futurama)</a><br>Bender Bending Rodríguez is one of the main characters in the animated television series Futurama. He was conceived by the series' creators Matt Groening and David X. Cohen, and is voiced by John DiMaggio.",
            "Bender (Futurama) - Bender Bending Rodríguez is one of the main characters in the animated television series Futurama. He was conceived by the series' creators Matt Groening and David X. Cohen, and is voiced by John DiMaggio."
        )
    ),
    results = listOf(),
    type = "C",
    meta = CharacterResponse.Meta(
        attribution = null,
        blockgroup = null,
        createdDate = null,
        description = "Wikipedia",
        designer = null,
        devDate = null,
        devMilestone = "live",
        developer = listOf(
            CharacterResponse.Meta.Developer(
                name = "DDG Team",
                type = "ddg",
                url = "http://www.duckduckhack.com"
            )
        ),
        exampleQuery = "nikola tesla",
        id = "wikipedia_fathead",
        isStackexchange = null,
        jsCallbackName = "wikipedia",
        liveDate = null,
        maintainer = CharacterResponse.Meta.Maintainer("duckduckgo"),
        name = "Wikipedia",
        perlModule = "DDG::Fathead::Wikipedia",
        producer = null,
        productionState = "online",
        repo = "fathead",
        signalFrom = "wikipedia_fathead",
        srcId = 1,
        srcName = "Wikipedia",
        srcDomain = "en.wikipedia.org",
        srcOptions = CharacterResponse.Meta.SrcOptions(
            directory = "",
            isFanon = 0,
            isMediawiki = 1,
            isWikipedia = 1,
            language = "en",
            minAbstractLength = "20",
            skipAbstract = 0,
            skipAbstractParen = 0,
            skipEnd = "0",
            skipIcon = 0,
            skipImageName = 0,
            skipQr = "",
            sourceSkip = "",
            srcInfo = ""
        ),
        srcUrl = null,
        status = "live",
        tab = "About",
        topic = listOf("productivity"),
        unsafe = 0
    )
)

const val MOCK_DATA = "{\"Abstract\":\"\",\"AbstractSource\":\"Wikipedia\",\"AbstractText\":\"\",\"AbstractURL\":\"https://en.wikipedia.org/wiki/The_Simpsons_characters\",\"Answer\":\"\",\"AnswerType\":\"\",\"Definition\":\"\",\"DefinitionSource\":\"\",\"DefinitionURL\":\"\",\"Entity\":\"\",\"Heading\":\"The Simpsons characters\",\"Image\":\"\",\"ImageHeight\":0,\"ImageIsLogo\":0,\"ImageWidth\":0,\"Infobox\":\"\",\"Redirect\":\"\",\"RelatedTopics\":[{\"FirstURL\":\"https://duckduckgo.com/Apu_Nahasapeemapetilan\",\"Icon\":{\"Height\":\"\",\"URL\":\"\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Apu_Nahasapeemapetilan\\\">Apu Nahasapeemapetilan</a><br>Apu Nahasapeemapetilan is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\",\"Text\":\"Apu Nahasapeemapetilan - Apu Nahasapeemapetilan is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\"},{\"FirstURL\":\"https://duckduckgo.com/Apu_Nahasapeemapetilon\",\"Icon\":{\"Height\":\"\",\"URL\":\"/i/99b04638.png\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Apu_Nahasapeemapetilon\\\">Apu Nahasapeemapetilon</a><br>Apu Nahasapeemapetilon is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\",\"Text\":\"Apu Nahasapeemapetilon - Apu Nahasapeemapetilon is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\"},{\"FirstURL\":\"https://duckduckgo.com/Barney_Gumble\",\"Icon\":{\"Height\":\"\",\"URL\":\"/i/39ce98c0.png\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Barney_Gumble\\\">Barney Gumble</a><br>Barnard Arnold \\\"Barney\\\" Gumble is a recurring character in the American animated TV series The Simpsons. He is voiced by Dan Castellaneta and first appeared in the series premiere episode \\\"Simpsons Roasting on an Open Fire\\\". Barney is the town drunk of Springfield and one of Homer Simpson's friends.\",\"Text\":\"Barney Gumble - Barnard Arnold \\\"Barney\\\" Gumble is a recurring character in the American animated TV series The Simpsons. He is voiced by Dan Castellaneta and first appeared in the series premiere episode \\\"Simpsons Roasting on an Open Fire\\\". Barney is the town drunk of Springfield and one of Homer Simpson's friends.\"},{\"FirstURL\":\"https://duckduckgo.com/Bart_Simpson\",\"Icon\":{\"Height\":\"\",\"URL\":\"\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Bart_Simpson\\\">Bart Simpson</a><br>Bartholomew Jojo \\\"Bart\\\" Simpson is a fictional character in the American animated television series The Simpsons and part of the Simpson family. He is voiced by Nancy Cartwright and first appeared on television in The Tracey Ullman Show short \\\"Good Night\\\" on April 19, 1987.\",\"Text\":\"Bart Simpson - Bartholomew Jojo \\\"Bart\\\" Simpson is a fictional character in the American animated television series The Simpsons and part of the Simpson family. He is voiced by Nancy Cartwright and first appeared on television in The Tracey Ullman Show short \\\"Good Night\\\" on April 19, 1987.\"},{\"FirstURL\":\"https://duckduckgo.com/Bender_(Futurama)\",\"Icon\":{\"Height\":\"\",\"URL\":\"/i/cb4121fd.png\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Bender_(Futurama)\\\">Bender (Futurama)</a><br>Bender Bending Rodr\\u00edguez is one of the main characters in the animated television series Futurama. He was conceived by the series' creators Matt Groening and David X. Cohen, and is voiced by John DiMaggio.\",\"Text\":\"Bender (Futurama) - Bender Bending Rodr\\u00edguez is one of the main characters in the animated television series Futurama. He was conceived by the series' creators Matt Groening and David X. Cohen, and is voiced by John DiMaggio.\"}],\"Results\":[],\"Type\":\"C\",\"meta\":{\"attribution\":null,\"blockgroup\":null,\"created_date\":null,\"description\":\"Wikipedia\",\"designer\":null,\"dev_date\":null,\"dev_milestone\":\"live\",\"developer\":[{\"name\":\"DDG Team\",\"type\":\"ddg\",\"url\":\"http://www.duckduckhack.com\"}],\"example_query\":\"nikola tesla\",\"id\":\"wikipedia_fathead\",\"is_stackexchange\":null,\"js_callback_name\":\"wikipedia\",\"live_date\":null,\"maintainer\":{\"github\":\"duckduckgo\"},\"name\":\"Wikipedia\",\"perl_module\":\"DDG::Fathead::Wikipedia\",\"producer\":null,\"production_state\":\"online\",\"repo\":\"fathead\",\"signal_from\":\"wikipedia_fathead\",\"src_domain\":\"en.wikipedia.org\",\"src_id\":1,\"src_name\":\"Wikipedia\",\"src_options\":{\"directory\":\"\",\"is_fanon\":0,\"is_mediawiki\":1,\"is_wikipedia\":1,\"language\":\"en\",\"min_abstract_length\":\"20\",\"skip_abstract\":0,\"skip_abstract_paren\":0,\"skip_end\":\"0\",\"skip_icon\":0,\"skip_image_name\":0,\"skip_qr\":\"\",\"source_skip\":\"\",\"src_info\":\"\"},\"src_url\":null,\"status\":\"live\",\"tab\":\"About\",\"topic\":[\"productivity\"],\"unsafe\":0}}"

val MOCK_JSON = JSONObject("{\"Abstract\":\"\",\"AbstractSource\":\"Wikipedia\",\"AbstractText\":\"\",\"AbstractURL\":\"https://en.wikipedia.org/wiki/The_Simpsons_characters\",\"Answer\":\"\",\"AnswerType\":\"\",\"Definition\":\"\",\"DefinitionSource\":\"\",\"DefinitionURL\":\"\",\"Entity\":\"\",\"Heading\":\"The Simpsons characters\",\"Image\":\"\",\"ImageHeight\":0,\"ImageIsLogo\":0,\"ImageWidth\":0,\"Infobox\":\"\",\"Redirect\":\"\",\"RelatedTopics\":[{\"FirstURL\":\"https://duckduckgo.com/Apu_Nahasapeemapetilan\",\"Icon\":{\"Height\":\"\",\"URL\":\"\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Apu_Nahasapeemapetilan\\\">Apu Nahasapeemapetilan</a><br>Apu Nahasapeemapetilan is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\",\"Text\":\"Apu Nahasapeemapetilan - Apu Nahasapeemapetilan is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\"},{\"FirstURL\":\"https://duckduckgo.com/Apu_Nahasapeemapetilon\",\"Icon\":{\"Height\":\"\",\"URL\":\"/i/99b04638.png\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Apu_Nahasapeemapetilon\\\">Apu Nahasapeemapetilon</a><br>Apu Nahasapeemapetilon is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\",\"Text\":\"Apu Nahasapeemapetilon - Apu Nahasapeemapetilon is a recurring character in the American animated television series The Simpsons. He is an Indian immigrant proprietor who runs the Kwik-E-Mart, a popular convenience store in Springfield, and is known for his catchphrase, \\\"Thank you, come again\\\".\"},{\"FirstURL\":\"https://duckduckgo.com/Barney_Gumble\",\"Icon\":{\"Height\":\"\",\"URL\":\"/i/39ce98c0.png\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Barney_Gumble\\\">Barney Gumble</a><br>Barnard Arnold \\\"Barney\\\" Gumble is a recurring character in the American animated TV series The Simpsons. He is voiced by Dan Castellaneta and first appeared in the series premiere episode \\\"Simpsons Roasting on an Open Fire\\\". Barney is the town drunk of Springfield and one of Homer Simpson's friends.\",\"Text\":\"Barney Gumble - Barnard Arnold \\\"Barney\\\" Gumble is a recurring character in the American animated TV series The Simpsons. He is voiced by Dan Castellaneta and first appeared in the series premiere episode \\\"Simpsons Roasting on an Open Fire\\\". Barney is the town drunk of Springfield and one of Homer Simpson's friends.\"},{\"FirstURL\":\"https://duckduckgo.com/Bart_Simpson\",\"Icon\":{\"Height\":\"\",\"URL\":\"\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Bart_Simpson\\\">Bart Simpson</a><br>Bartholomew Jojo \\\"Bart\\\" Simpson is a fictional character in the American animated television series The Simpsons and part of the Simpson family. He is voiced by Nancy Cartwright and first appeared on television in The Tracey Ullman Show short \\\"Good Night\\\" on April 19, 1987.\",\"Text\":\"Bart Simpson - Bartholomew Jojo \\\"Bart\\\" Simpson is a fictional character in the American animated television series The Simpsons and part of the Simpson family. He is voiced by Nancy Cartwright and first appeared on television in The Tracey Ullman Show short \\\"Good Night\\\" on April 19, 1987.\"},{\"FirstURL\":\"https://duckduckgo.com/Bender_(Futurama)\",\"Icon\":{\"Height\":\"\",\"URL\":\"/i/cb4121fd.png\",\"Width\":\"\"},\"Result\":\"<a href=\\\"https://duckduckgo.com/Bender_(Futurama)\\\">Bender (Futurama)</a><br>Bender Bending Rodr\\u00edguez is one of the main characters in the animated television series Futurama. He was conceived by the series' creators Matt Groening and David X. Cohen, and is voiced by John DiMaggio.\",\"Text\":\"Bender (Futurama) - Bender Bending Rodr\\u00edguez is one of the main characters in the animated television series Futurama. He was conceived by the series' creators Matt Groening and David X. Cohen, and is voiced by John DiMaggio.\"}],\"Results\":[],\"Type\":\"C\",\"meta\":{\"attribution\":null,\"blockgroup\":null,\"created_date\":null,\"description\":\"Wikipedia\",\"designer\":null,\"dev_date\":null,\"dev_milestone\":\"live\",\"developer\":[{\"name\":\"DDG Team\",\"type\":\"ddg\",\"url\":\"http://www.duckduckhack.com\"}],\"example_query\":\"nikola tesla\",\"id\":\"wikipedia_fathead\",\"is_stackexchange\":null,\"js_callback_name\":\"wikipedia\",\"live_date\":null,\"maintainer\":{\"github\":\"duckduckgo\"},\"name\":\"Wikipedia\",\"perl_module\":\"DDG::Fathead::Wikipedia\",\"producer\":null,\"production_state\":\"online\",\"repo\":\"fathead\",\"signal_from\":\"wikipedia_fathead\",\"src_domain\":\"en.wikipedia.org\",\"src_id\":1,\"src_name\":\"Wikipedia\",\"src_options\":{\"directory\":\"\",\"is_fanon\":0,\"is_mediawiki\":1,\"is_wikipedia\":1,\"language\":\"en\",\"min_abstract_length\":\"20\",\"skip_abstract\":0,\"skip_abstract_paren\":0,\"skip_end\":\"0\",\"skip_icon\":0,\"skip_image_name\":0,\"skip_qr\":\"\",\"source_skip\":\"\",\"src_info\":\"\"},\"src_url\":null,\"status\":\"live\",\"tab\":\"About\",\"topic\":[\"productivity\"],\"unsafe\":0}}")
