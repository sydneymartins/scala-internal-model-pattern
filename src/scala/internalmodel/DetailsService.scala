/*
 * Copyright (C) 2018 Julian Martin
 */

package internalmodel

import internalmodel.model.{IRequestTemplate, IResponseTemplate}
import javax.ws.rs.client.{Client, ClientBuilder, Entity}

import scala.util.Try

class DetailsService(client: Client = ClientBuilder.newClient()) {

  def details(request: IRequestTemplate): Either[Throwable, IResponseTemplate] = {
    Try(post(request, s"https://localhost:7000/test")).toEither
  }
  def post(request: IRequestTemplate, url: String): IResponseTemplate = {
    client.target(url).request().post(Entity.json(request), classOf[IResponseTemplate])
  }
}


