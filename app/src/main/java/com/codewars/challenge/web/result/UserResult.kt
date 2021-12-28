package com.codewars.challenge.web.result


import com.google.gson.annotations.SerializedName

data class UserResult(
    @SerializedName("clan")
    val clan: String,
    @SerializedName("codeChallenges")
    val codeChallenges: CodeChallenges,
    @SerializedName("honor")
    val honor: Int,
    @SerializedName("leaderboardPosition")
    val leaderboardPosition: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("ranks")
    val ranks: Ranks,
    @SerializedName("skills")
    val skills: List<Any>,
    @SerializedName("username")
    val username: String
) {
    data class CodeChallenges(
        @SerializedName("totalAuthored")
        val totalAuthored: Int,
        @SerializedName("totalCompleted")
        val totalCompleted: Int
    )

    data class Ranks(
        @SerializedName("languages")
        val languages: Languages,
        @SerializedName("overall")
        val overall: Overall
    ) {
        data class Languages(
            @SerializedName("c")
            val c: CodeLanguage,
            @SerializedName("cfml")
            val cfml: CodeLanguage,
            @SerializedName("clojure")
            val clojure: CodeLanguage,
            @SerializedName("cobol")
            val cobol: CodeLanguage,
            @SerializedName("coffeescript")
            val coffeescript: CodeLanguage,
            @SerializedName("commonlisp")
            val commonlisp: CodeLanguage,
            @SerializedName("coq")
            val coq: CodeLanguage,
            @SerializedName("cpp")
            val cpp: CodeLanguage,
            @SerializedName("crystal")
            val crystal: CodeLanguage,
            @SerializedName("csharp")
            val csharp: CodeLanguage,
            @SerializedName("d")
            val d: CodeLanguage,
            @SerializedName("dart")
            val dart: CodeLanguage,
            @SerializedName("elixir")
            val elixir: CodeLanguage,
            @SerializedName("elm")
            val elm: CodeLanguage,
            @SerializedName("erlang")
            val erlang: CodeLanguage,
            @SerializedName("factor")
            val factor: CodeLanguage,
            @SerializedName("forth")
            val forth: CodeLanguage,
            @SerializedName("fortran")
            val fortran: CodeLanguage,
            @SerializedName("fsharp")
            val fsharp: CodeLanguage,
            @SerializedName("go")
            val go: CodeLanguage,
            @SerializedName("groovy")
            val groovy: CodeLanguage,
            @SerializedName("haskell")
            val haskell: CodeLanguage,
            @SerializedName("haxe")
            val haxe: CodeLanguage,
            @SerializedName("java")
            val java: CodeLanguage,
            @SerializedName("javascript")
            val javascript: CodeLanguage,
            @SerializedName("julia")
            val julia: CodeLanguage,
            @SerializedName("kotlin")
            val kotlin: CodeLanguage,
            @SerializedName("lua")
            val lua: CodeLanguage,
            @SerializedName("nim")
            val nim: CodeLanguage,
            @SerializedName("objc")
            val objc: CodeLanguage,
            @SerializedName("ocaml")
            val ocaml: CodeLanguage,
            @SerializedName("pascal")
            val pascal: CodeLanguage,
            @SerializedName("perl")
            val perl: CodeLanguage,
            @SerializedName("php")
            val php: CodeLanguage,
            @SerializedName("powershell")
            val powershell: CodeLanguage,
            @SerializedName("prolog")
            val prolog: CodeLanguage,
            @SerializedName("purescript")
            val purescript: CodeLanguage,
            @SerializedName("python")
            val python: CodeLanguage,
            @SerializedName("r")
            val r: CodeLanguage,
            @SerializedName("racket")
            val racket: CodeLanguage,
            @SerializedName("raku")
            val raku: CodeLanguage,
            @SerializedName("reason")
            val reason: CodeLanguage,
            @SerializedName("ruby")
            val ruby: CodeLanguage,
            @SerializedName("rust")
            val rust: CodeLanguage,
            @SerializedName("scala")
            val scala: CodeLanguage,
            @SerializedName("shell")
            val shell: CodeLanguage,
            @SerializedName("solidity")
            val solidity: CodeLanguage,
            @SerializedName("sql")
            val sql: CodeLanguage,
            @SerializedName("swift")
            val swift: CodeLanguage,
            @SerializedName("typescript")
            val typescript: CodeLanguage,
            @SerializedName("vb")
            val vb: CodeLanguage
        ) {
            data class CodeLanguage(
                @SerializedName("color")
                val color: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("rank")
                val rank: Int,
                @SerializedName("score")
                val score: Int
            )
        }

        data class Overall(
            @SerializedName("color")
            val color: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("rank")
            val rank: Int,
            @SerializedName("score")
            val score: Int
        )
    }
}