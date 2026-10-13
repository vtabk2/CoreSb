package com.codebasetemplate.features.feature_reward

import androidx.viewbinding.ViewBinding
import com.codebasetemplate.required.ads.AppAdPlaceName
import com.core.baseui.AdSlot
import com.core.baseui.BaseActivity

abstract class BaseAdsActivity<B : ViewBinding> : BaseActivity<B>() {

    fun unlock(callbackSuccess: () -> Unit, callbackFailed: (isNoAds: Boolean) -> Unit) {
        unlockWithRewarded(
            adPlaceName = AppAdPlaceName.REWARD_TEST,
            callbackSuccess = callbackSuccess,
            callbackClose = {
                cancelRewarded()
            },
            callbackNoAds = {
                callbackFailed.invoke(true)
            },
            callbackRetry = {
                callbackFailed.invoke(false)
            })
    }

    open fun cancelRewarded() {}

    override val adSlots: List<AdSlot> = listOf(
        AdSlot.rewarded(AppAdPlaceName.REWARD_TEST)
    )
}
