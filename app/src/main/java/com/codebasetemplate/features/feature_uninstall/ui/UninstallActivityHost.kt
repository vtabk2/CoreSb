package com.codebasetemplate.features.feature_uninstall.ui

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.codebasetemplate.databinding.CoreActivityBaseBinding
import com.codebasetemplate.features.feature_uninstall.ui.navigate.UninstallNavigateEvent
import com.codebasetemplate.required.ads.AppAdPlaceName
import com.core.baseui.AdSlot
import com.core.baseui.HostBaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UninstallActivityHost :
    HostBaseActivity<CoreActivityBaseBinding, UninstallNavigateEvent, UninstallShareViewModel>() {

    override val isHideStatusBar: Boolean
        get() = true

    override val isSpaceStatusBar: Boolean
        get() = false

    override val isSpaceDisplayCutout: Boolean
        get() = false

    override fun bindingProvider(inflater: LayoutInflater): CoreActivityBaseBinding {
        return CoreActivityBaseBinding.inflate(inflater)
    }

    override val containerId: Int
        get() = viewBinding.mainContainer.id

    override
    val sharedViewModel: UninstallShareViewModel by viewModels()

    override fun showFirstScreen() {
        replaceFragment(UninstallHostFragment())
    }

    override val adSlots: List<AdSlot> = listOf(
        AdSlot.bannerNative(
            AppAdPlaceName.ANCHORED_UNINSTALL_BOTTOM_STEP_1,
            preload = true,
        ),
        AdSlot.bannerNative(
            AppAdPlaceName.ANCHORED_UNINSTALL_BOTTOM_STEP_2,
            preload = true,
        ),
    )
}
