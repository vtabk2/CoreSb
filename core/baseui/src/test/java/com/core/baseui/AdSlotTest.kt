package com.core.baseui

import com.core.config.domain.data.RemoteAdPlaceName
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AdSlotTest {

    @Test
    fun `banner native preload keeps banner group and preload flag`() {
        val slot = AdSlot.bannerNative(
            adPlaceName = RemoteAdPlaceName("banner_native"),
            preload = true,
        )

        assertEquals(AdSlotGroup.BannerNative, slot.group)
        assertTrue(slot.preload)
    }

    @Test
    fun `native interstitial can be explicitly registered as interstitial`() {
        val slot = AdSlot.interstitial(RemoteAdPlaceName("native_interstitial"))

        assertEquals(AdSlotGroup.Interstitial, slot.group)
    }
}
