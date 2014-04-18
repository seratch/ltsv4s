import sbt._
import Keys._

object LTSV4SProject extends Build {

  lazy val root = Project("root", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    organization := "com.github.seratch",
    name := "ltsv4s",
    version := "1.0.0",
    crossScalaVersions := Seq("2.11.0", "2.10.3"),
    publishTo <<= version { (v: String) => 
      val nexus = "https://oss.sonatype.org/"
      if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    libraryDependencies <++= (scalaVersion) { scalaVersion =>
      Seq("org.scalatest" %% "scalatest" % "2.1.3" % "test") ++ (scalaVersion match {
        case v if v.startsWith("2.11.") => Seq("org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1" % "compile")
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
          <name>Kazuhuiro Sera</name>
          <url>http://seratch.net/</url>
        </developer>
      </developers>
  )

}

