package com.kullapat.kt.actor

import akka.actor.Status.Failure
import akka.actor.{Actor, ActorLogging, Props}
import com.kullapat.kt.actor.UserActor.GetUser
import com.kullapat.kt.model.User

class UserActor extends Actor
  with ActorLogging {

  override def receive: Receive = {
    case GetUser ⇒ sender() ! getUser()
    case _       ⇒ sender() ! Failure(new IllegalArgumentException)
  }

  private def getUser(): User = {
    log.info(s"get user: ...")
    User(firstName = "K", lastName = "T", gender = "M", item = "")
  }
}

object UserActor {
  def props: Props = Props(new UserActor)

  case object GetUser
}