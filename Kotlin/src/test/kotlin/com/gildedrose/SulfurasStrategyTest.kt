package com.gildedrose

import com.gildedrose.InventoryStrategies.SulfurasStrategy
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class SulfurasStrategyTest {
    @Test
    fun `should not decrease the quality and sell in of sulphuras`(){
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 5 , 5))
        val app = GildedRose(items)
        val actualQuality = items[0].quality
        val actualSellIn = items[0].sellIn
        SulfurasStrategy().updateInventory(items)
        val item= items[0]
        item.sellIn `should be equal to` actualSellIn
        item.quality `should be equal to` actualQuality
    }
}