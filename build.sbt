lazy val root =
  (project in file("."))
    .settings(
      // basis
      organization := "com.github.seratch",
      name := "ltsv4s"
    )
    .settings(
      // compiler
      scalaVersion := "2.13.8",
      scalacOptions ++= Seq("-deprecation", "-unchecked"),
      crossScalaVersions := Seq("2.13.8", "2.12.15")
    )
    .settings(
      // dependencies
      libraryDependencies ++= Seq(
        "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1",
        "org.scalatest" %% "scalatest" % "3.2.11" % Test
      )
    )
    .settings(
      // publish
      homepage := Some(url("https://seratch.github.com/ltsv4s")),
      licenses := Seq(
        "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
      ),
      developers := List(
        Developer(
          "seratch",
          "Kazuhiro Sera",
          "seratch@gmail.com",
          url("http://seratch.net/")
        )
      )
    )
