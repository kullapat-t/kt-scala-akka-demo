package com.kullapat.kt

import com.typesafe.config.ConfigFactory

import scala.util.Try

object Application extends App {
  def DEFAULT_HOST = "localhost"
  def DEFAULT_PORT = 8085

  val config = ConfigFactory.load()
  lazy val host = Try(config.getString("service.host")).getOrElse(DEFAULT_HOST)
  lazy val port = Try(config.getInt("service.port")).getOrElse(DEFAULT_PORT)

  WebServer.startServer(host, port)
}
