/*
 * Copyright (C) 2018 Julian Martin
 */

package internalmodel

import com.codahale.metrics.annotation.{ExceptionMetered, Timed}
import internalmodel.Details.model.{DetailsRequest, DetailsResponse}
import internalmodel.mapper.{IRequestModelAdapter, IResponseModelAdapter, RequestModelAdapter, ResponseModelAdapter}
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.{Consumes, POST, Path, Produces}
import org.springframework.stereotype.Component

@Component
@Path("/{p:details|Details}")
class DetailsResource extends IDetailsResource[DetailsResponse] {

  @Produces(Array(APPLICATION_JSON))
  @Consumes(Array(APPLICATION_JSON))
  @POST
  @ExceptionMetered
  @Timed
  def details(request: DetailsRequest): DetailsResponse = {
    val responseAdapter = callService(new RequestModelAdapter(request))
    responseAdapter.getResponse
  }

  def callService(request: IRequestModelAdapter): IResponseModelAdapter[DetailsResponse] = {
    val service = new DetailsService
    val serviceResponse = service.details(request.getRequest)
    new ResponseModelAdapter(serviceResponse)
  }

}
