/*
 * Copyright (C) 2018 Julian Martin
 */

package internalmodel.mapper

import internalmodel.Details.model.DetailsResponse
import internalmodel.model.IResponseTemplate

class ResponseModelAdapter(response: Either[Throwable, IResponseTemplate]) extends IResponseModelAdapter[DetailsResponse] {
  @throws[Exception]
  override def getResponse: DetailsResponse = {
    if (response.isLeft) {
      throw response.left.toOption.get
    }
    val iResponse = response.right.toOption
    val detailsResponse = new DetailsResponse
    detailsResponse.expectedName = iResponse.get.expectedName
    detailsResponse.validatedAddress = iResponse.get.validatedAddress
    detailsResponse
  }
}


