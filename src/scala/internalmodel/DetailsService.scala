/*
 * Copyright (C) 2018 Julian Martin
 */

package internalmodel

import internalmodel.mapper.{IRequestModelAdapter, IResponseModelAdapter, ResponseModelAdapter}
import internalmodel.model.{InternalRequest, InternalResponse}
import javax.ws.rs.client.{Client, ClientBuilder, Entity}

import scala.util.Try

class DetailsService(client: Client = ClientBuilder.newClient()) {

  def callService(adapter: IRequestModelAdapter): IResponseModelAdapter = {
    val response =
      Try(post(adapter.getRequest,
        s"https://localhost:7000/test"))
    new ResponseModelAdapter(response.toOption)
  }
  def post(request: InternalRequest, url: String): InternalResponse = {
    client.target(url).request().post(Entity.json(request), classOf[InternalResponse])
  }
}


