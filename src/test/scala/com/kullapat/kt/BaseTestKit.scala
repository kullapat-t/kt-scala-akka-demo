package com.kullapat.kt

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import com.typesafe.config.Config
import org.scalatest.{BeforeAndAfterAll, WordSpecLike}

abstract class BaseTestKit(actorSystemName: String, config: Option[Config] = None) extends TestKit(ActorSystem(actorSystemName, config))
  with WordSpecLike
  with BeforeAndAfterAll
  with ImplicitSender {

  override protected def afterAll(): Unit = TestKit.shutdownActorSystem(system)
}
