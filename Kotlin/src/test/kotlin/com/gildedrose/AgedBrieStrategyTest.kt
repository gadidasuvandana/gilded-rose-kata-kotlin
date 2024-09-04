package com.gildedrose

import com.gildedrose.InventoryStrategies.AgedBrieStrategy
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class AgedBrieStrategyTest {

    @Test
    fun `should increase the quality of aged brie`(){
        val items = listOf(Item("Aged Brie", 4 , 5))
        val actualQuality = items[0].quality
        AgedBrieStrategy().updateInventory(items)
        val item= items[0]
        item.quality `should be equal to` actualQuality +1
    }

    @Test
    fun `should not increase the quality of aged brie to more than 50`(){
        val items = listOf(Item("Aged Brie", 4 , 50))
        val actualQuality = items[0].quality
        AgedBrieStrategy().updateInventory(items)
        val item= items[0]
        item.quality `should be equal to` actualQuality
    }


    @Test
    fun `should increase the quality of aged brie by 2 when sell in date passes`(){
        val items = listOf(Item("Aged Brie", -1 , 5))
        val actualQuality = items[0].quality
        AgedBrieStrategy().updateInventory(items)
        val item= items[0]
        item.quality `should be equal to` actualQuality +2
    }
}