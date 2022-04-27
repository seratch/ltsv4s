lazy val root =
  (project in file("."))
    .settings(
      organization := "com.github.seratch",
      name := "ltsv4s",
      publishTo := sonatypePublishToBundle.value,
      pomExtra := _pomExtra,
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


val _pomExtra = <url>https://github.com/seratch/ltsv4s/</url>
    <licenses>
      <license>
        <name>Apache License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:seratch/ltsv4.git</url>
      <connection>scm:git:git@github.com:seratch/ltsv4.git</connection>
    </scm>
    <developers>
      <developer>
        <id>seratch</id>
        <name>Kazuhiro Sera</name>
        <url>https://git.io/sera</url>
      </developer>
    </developers>
