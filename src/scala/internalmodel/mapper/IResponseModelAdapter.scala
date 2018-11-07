/*
 * Copyright (C) 2018 Julian Martin
 */

package internalmodel.mapper

/**
  * Interface for request mapping.
  * This class will be used to build the internal request.
  */
trait IResponseModelAdapter[O] {
  def getResponse: O
}


