/*
 * Copyright (C) 2015 Expedia Inc
 */

package internalmodel.mapper

import internalmodel.Details.model.DetailsRequest
import internalmodel.model.InternalRequest

class RequestModelAdapter(detailsRequest: DetailsRequest) extends IRequestModelAdapter {
  override def getRequest: InternalRequest = {
    val iRequest = new InternalRequest
    iRequest.name = detailsRequest.name
    iRequest.address = detailsRequest.address
    iRequest
  }
}


