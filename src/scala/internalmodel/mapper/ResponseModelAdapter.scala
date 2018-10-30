/*
 * Copyright (C) 2015 Expedia Inc
 */

package internalmodel.mapper

import internalmodel.Details.model.DetailsResponse
import internalmodel.model.InternalResponse

class ResponseModelAdapter(iResponse: Option[InternalResponse]) extends IResponseModelAdapter {
  @throws[Exception]
  override def getResponse: DetailsResponse = {
    if (iResponse.isEmpty) {
      throw new Exception("Failed getting response")
    }
    val detailsResponse = new DetailsResponse
    detailsResponse.expectedName = iResponse.get.expectedName
    detailsResponse.validatedAddress = iResponse.get.validatedAddress
    detailsResponse
  }
}


