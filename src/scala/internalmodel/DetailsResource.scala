/*
 * Copyright (C) 2015 Expedia Inc
 */

package internalmodel

import com.codahale.metrics.annotation.{ExceptionMetered, Timed}
import internalmodel.Details.model.{DetailsRequest, DetailsResponse}
import internalmodel.mapper.RequestModelAdapter
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.{Consumes, POST, Path, Produces}
import org.springframework.stereotype.Component

@Component
@Path("/{p:details|Details}")
class DetailsResource {

  @Produces(Array(APPLICATION_JSON))
  @Consumes(Array(APPLICATION_JSON))
  @POST
  @ExceptionMetered
  @Timed
  def details(request: DetailsRequest): DetailsResponse = {

    val service = new DetailsService

    val response = service.callService(new RequestModelAdapter(request))

    response.getResponse
  }


}
