package com.rahil.ecommpoc.domain.interactor.homePage

import com.rahil.ecommpoc.domain.executor.PostExecutionThread
import com.rahil.ecommpoc.domain.executor.ThreadExecutor
import com.rahil.ecommpoc.domain.interactor.SingleUseCase
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.repository.AppRepository
import io.reactivex.Single
import javax.inject.Inject

class GetHomePageData @Inject constructor(
    private val appRepository: AppRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) :
    SingleUseCase<HomePageModel, Nothing?>(threadExecutor, postExecutionThread) {
    public override fun buildUseCaseObservable(params: Nothing?): Single<HomePageModel> {
        return appRepository.getHomePageData()
    }
}
