package com.kullapat.kt.actor

import akka.actor.ActorRef
import akka.actor.Status.Failure
import com.kullapat.kt.BaseTestKit
import com.kullapat.kt.actor.UserActor.GetUser
import com.kullapat.kt.model.User

class UserActorTest extends BaseTestKit("UserActorTest") {

  private val userActor: ActorRef = system.actorOf(UserActor.props)

  "UserActor" should {
    "return user detail" in {
      userActor ! GetUser
      expectMsgType[User]
    }

    "fail" in {
      userActor ! "unknown message"
      expectMsgType[Failure]
    }
  }
}
