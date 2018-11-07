package internalmodel

import internalmodel.mapper.{IRequestModelAdapter, IResponseModelAdapter}

trait IDetailsResource[O] {

  def callService(requestAdapter: IRequestModelAdapter): IResponseModelAdapter[O]
}
