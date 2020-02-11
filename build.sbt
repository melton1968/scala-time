name := "scala-time"

version := "0.1"

scalaVersion := "2.13.1"

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
