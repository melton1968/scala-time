
name := "scala-time"
version := "0.3"
organization := "io.whitemice"
scalaVersion := "2.12.10"

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:experimental.macros",
  "-Xlint",
)

scalacOptions in (Compile, doc) ++= Seq("-groups")

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

//noinspection Annotator
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

ThisBuild / githubRepo := "scala-time"
ThisBuild / githubRepoOwner := "album-mus"
