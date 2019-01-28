package com.kullapat.kt.actor

import akka.actor.ActorRef
import akka.actor.Status.Failure
import com.kullapat.kt.BaseTestKit
import com.kullapat.kt.actor.UserActor.GetUser

class UserActorTest extends BaseTestKit("UserActorTest") {

  private val userActor: ActorRef = system.actorOf(UserActor.props)

  "UserActor" should {
    "return get user" in {
      userActor ! GetUser
      expectMsg("get user!")
    }

    "fail" in{
      userActor ! "unknown message"
      expectMsgType[Failure]
    }
  }
}
