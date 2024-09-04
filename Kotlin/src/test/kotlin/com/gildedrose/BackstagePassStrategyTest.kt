package com.gildedrose

import com.gildedrose.InventoryStrategies.BackstagePassStrategy
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class BackstagePassStrategyTest {
    @Test
    fun `should increase the quality of backstage passes by 2 when there are 8 days to concert`(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 8 , 5))
        val actualQuality = items[0].quality
        BackstagePassStrategy().updateInventory(items)
        val item= items[0]
        item.quality `should be equal to` actualQuality + 2
    }

    @Test
    fun `should increase the quality of backstage passes by 3 when there are less than 5 days to concert`(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3 , 5))
        val actualQuality = items[0].quality
        BackstagePassStrategy().updateInventory(items)
        val item= items[0]
        item.quality `should be equal to` actualQuality + 3
    }

    @Test
    fun `should make quality as 0 when concert has passed`(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", -2 , 5))
       BackstagePassStrategy().updateInventory(items)
        val item= items[0]
        item.quality `should be equal to` 0
    }
}