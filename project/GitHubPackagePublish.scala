package sbtghpackage

import sbt._
import Keys._
import scala.util.{Success, Try}
import scala.sys.process._
import sbt.Keys.streams

object GitHubPackagePublish extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    lazy val githubUser = taskKey[String]("The user's github username (e.g. melton1968)")
    lazy val githubToken = taskKey[String]("The user's github personal access token")
    lazy val githubRepo = settingKey[String]("The target repo (e.g. scala-time)")
    lazy val githubRepoOwner = settingKey[String]("The target repo's owner (e.g. album-mus)")
    lazy val githubPublishTo = settingKey[Some[MavenRepository]]("github Maven repo")
    lazy val githubCredentials = settingKey[String]("github Maven credentials")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    githubUser := {
      val log = streams.value.log
      val user = Try(s"git config github.actor" !!).map(_.trim)
      user match {
        case Success(value) => value
        case _ =>
          log.error("Failed to get user's github username")
          "User's github username not found"
      }
    },

    githubToken := {
      val log = streams.value.log
      val token = Try(s"git config github.packageToken" !!).map(_.trim)
      token match {
        case Success(value) => value
        case _ =>
          log.error("Failed to get user's github access token")
          "User's personal resource token not found"
      }
    },

    githubRepo := "github-repo name goes here (e.g. scala-time)",
    githubRepoOwner := "github-repo owner goes here (e.g. album-mus)",

    publishTo := Some("GitHub Package Registry" at
      s"https://maven.pkg.github.com/${githubRepoOwner.value}/${githubRepo.value}"),

    credentials += Credentials("GitHub Package Registry",
      "maven.pkg.github.com",
      githubUser.value,
      githubToken.value),
  )
}
