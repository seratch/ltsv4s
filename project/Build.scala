import sbt._
import Keys._

object LTSV4SProject extends Build {

  lazy val root = Project("root", file("."), settings = mainSettings)

  lazy val mainSettings = Seq(
    organization := "com.github.seratch",
    name := "ltsv4s",
    version := "1.0.4-SNAPSHOT",
    scalaVersion := "2.11.7",
    crossScalaVersions := Seq("2.11.7", "2.10.6"),
    publishMavenStyle := true,
    libraryDependencies <++= (scalaVersion) { scalaVersion =>
      Seq("org.scalatest" %% "scalatest" % "2.2.5" % "test") ++ (scalaVersion match {
        case v if v.startsWith("2.11.") => Seq("org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4" % "compile")
        case _ => Nil
      })
    },
    sbtPlugin := false,
    transitiveClassifiers in Global := Seq(Artifact.SourceClassifier),
    incOptions := incOptions.value.withNameHashing(true),
    scalacOptions ++= Seq("-deprecation", "-unchecked"),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { x => false },
    pomExtra := <url>http://seratch.github.com/ltsv4s</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:seratch/ltsv4s.git</url>
        <connection>scm:git:git@github.com:seratch/ltsv4s.git</connection>
      </scm>
      <developers>
        <developer>
          <id>seratch</id>
          <name>Kazuhiro Sera</name>
          <url>http://seratch.net/</url>
        </developer>
      </developers>
  )

}

