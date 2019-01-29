package com.kullapat.kt

import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.server.{HttpApp, Route}
import akka.pattern.ask
import akka.util.Timeout
import com.kullapat.kt.actor.UserActor
import com.kullapat.kt.actor.UserActor.GetUser
import com.kullapat.kt.model.User

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}

object WebServer extends HttpApp {

  private val system = ActorSystem("Application")
  private implicit val timeout: Timeout = 30.seconds

  private val userActor: ActorRef = system.actorOf(UserActor.props)

  override protected def routes: Route = {
    path("user") {
      post {
        complete("To be implemented")
      } ~
      get {
        onComplete(userActor ? GetUser) {
          case Success(user: User)  => complete(s"user: $user")
          case Failure(exception)   => complete(s"Failed to get user(s): ${exception.getLocalizedMessage}")
        }
      }
    }
  }
}
