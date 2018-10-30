/*
 * Copyright (C) 2018 Julian Martin
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


