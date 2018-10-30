/*
 * Copyright (C) 2015 Expedia Inc
 */

package internalmodel.mapper

import internalmodel.model.InternalRequest

/**
  * Interface for request mapping.
  * This class will be used to build the internal request.
  */
trait IRequestModelAdapter {
  def getRequest: InternalRequest
}


