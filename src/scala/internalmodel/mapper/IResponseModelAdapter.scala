/*
 * Copyright (C) 2015 Expedia Inc
 */

package internalmodel.mapper

import internalmodel.Details.model.DetailsResponse

/**
  * Interface for request mapping.
  * This class will be used to build the internal request.
  */
trait IResponseModelAdapter {
  def getResponse: DetailsResponse
}


