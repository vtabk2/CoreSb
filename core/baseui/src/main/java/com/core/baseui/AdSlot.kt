package com.core.baseui

import com.core.config.domain.data.IAdPlaceName

enum class AdSlotGroup {
    BannerNative,
    Interstitial,
    Rewarded,
}

data class AdSlot(
    val adPlaceName: IAdPlaceName,
    val group: AdSlotGroup,
    val preload: Boolean = false,
) {
    companion object {
        fun bannerNative(adPlaceName: IAdPlaceName, preload: Boolean = false) =
            AdSlot(adPlaceName, AdSlotGroup.BannerNative, preload)

        fun interstitial(adPlaceName: IAdPlaceName) =
            AdSlot(adPlaceName, AdSlotGroup.Interstitial)

        fun rewarded(adPlaceName: IAdPlaceName) =
            AdSlot(adPlaceName, AdSlotGroup.Rewarded)
    }
}
