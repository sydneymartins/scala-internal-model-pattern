/*
 * Copyright (C) 2018 Julian Martin
 */

package internalmodel.mapper

import internalmodel.Details.model.DetailsRequest
import internalmodel.model.{IRequestTemplate, InternalRequest}

class RequestModelAdapter(detailsRequest: DetailsRequest) extends IRequestModelAdapter {
  override def getRequest: IRequestTemplate = {
    val iRequest = new InternalRequest
    iRequest.name = detailsRequest.name
    iRequest.address = detailsRequest.address
    iRequest
  }
}


