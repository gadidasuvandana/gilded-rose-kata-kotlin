package com.gildedrose
import com.gildedrose.InventoryStrategies.RegularStrategy
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class RegularStrategyTest {
    @Test
    fun `should decrease the sell in date and quality by 1`() {
        val items = listOf(Item("something", 5, 5))
        val actualSellIn = items[0].sellIn
        val actualQuality = items[0].quality
        RegularStrategy().updateInventory(items)
        items[0].sellIn `should be equal to` actualSellIn - 1
        items[0].quality `should be equal to` actualQuality - 1
    }

    @Test
    fun `should decrease quality by 2 when sell in date of an item has passed`() {
        val items = listOf(Item("something", -1, 5))
        val actualQuality = items[0].quality
        RegularStrategy().updateInventory(items)
        items[0].quality `should be equal to` actualQuality - 2
    }

    @Test
    fun `should not decrease quality below 0`() {
        val items = listOf(Item("something", -1, 0))
        RegularStrategy().updateInventory(items)
        items[0].quality `should be equal to` 0
    }
}