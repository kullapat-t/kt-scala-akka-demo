package com.kullapat.kt.actor

import akka.actor.Status.{Failure}
import akka.actor.{Actor, Props}
import com.kullapat.kt.actor.UserActor.GetUser

class UserActor extends Actor {
  override def receive: Receive = {
    case GetUser ⇒ sender() ! getUser()
    case _       ⇒ sender() ! Failure(new IllegalArgumentException)
  }

  private def getUser() = "get user!"
}

object UserActor {
  def props: Props = Props(new UserActor)

  case object GetUser
}