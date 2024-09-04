package com.gildedrose

import com.gildedrose.InventoryStrategies.ConjuredStrategy
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class ConjuredStrategyTest {
    @Test
    fun `should decrease the quality by 2`() {
        val items = listOf(Item("something", 5, 5))
        val actualQuality = items[0].quality
        ConjuredStrategy().updateInventory(items)
        items[0].quality `should be equal to` actualQuality - 2
    }

    @Test
    fun `should decrease the quality by 4 when sell in date has passed`() {
        val items = listOf(Item("something", -1, 5))
        val actualQuality = items[0].quality
        ConjuredStrategy().updateInventory(items)
        items[0].quality `should be equal to` actualQuality - 4
    }

    @Test
    fun `should not decrease the quality below 0`() {
        val items = listOf(Item("something", -1, 3))
        val actualQuality = items[0].quality
        ConjuredStrategy().updateInventory(items)
        items[0].quality `should be equal to` actualQuality - 4
    }
}