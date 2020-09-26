package com.rahil.ecommpoc.domain.interactor.homePage

import com.rahil.ecommpoc.domain.executor.PostExecutionThread
import com.rahil.ecommpoc.domain.executor.ThreadExecutor
import com.rahil.ecommpoc.domain.interactor.FlowableUseCase
import com.rahil.ecommpoc.domain.model.homepage.HomePageModel
import com.rahil.ecommpoc.domain.repository.AppRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetHomePageData @Inject constructor(
    private val appRepository: AppRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) :
    FlowableUseCase<HomePageModel, Nothing?>(threadExecutor, postExecutionThread) {
    public override fun buildUseCaseObservable(params: Nothing?): Flowable<HomePageModel> {
        return appRepository.getHomePageData()
    }
}
