package com.gildedrose
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `should decrease quality by 2 when sell in date of an item has passed`(){
        val items = listOf(Item("something", -1 , 5))
        val actualQuality = items[0].quality
        val app = GildedRose(items)
        app.updateQuality()
        items[0].quality `should be equal to` actualQuality -2
    }

    @Test
    fun `should not decrease quality below 0`(){
        val items = listOf(Item("something", -1 , 0))
        val app = GildedRose(items)
        app.updateQuality()
        items[0].quality `should be equal to` 0
    }

    @Test
    fun `should increase the quality of aged brie by 2 when sell in date passes`(){
        val items = listOf(Item("Aged Brie", -1 , 5))
        val actualQuality = items[0].quality
        val app = GildedRose(items)
        app.updateQuality()
        val item= items[0]
        item.quality `should be equal to` actualQuality +2
    }

    @Test
    fun `should not decrease the quality of sulphuras`(){
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 5 , 5))
        val app = GildedRose(items)
        val actualQuality = items[0].quality
        val actualSellIn = items[0].sellIn
        app.updateQuality()
        val item= items[0]
        item.sellIn `should be equal to` actualSellIn
        item.quality `should be equal to` actualQuality
    }

    @Test
    fun `should not increase the quality of an item to more than 50`(){
        val items = listOf(Item("Aged Brie", 10 , 49))
        val app = GildedRose(items)
        app.updateQuality()
        val item= items[0]
        item.quality `should be equal to` 50
    }

    @Test
    fun `should increase the quality of backstage passes by 2 when there are 8 days to concert`(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 8 , 5))
        val app = GildedRose(items)
        val actualQuality = items[0].quality
        app.updateQuality()
        val item= items[0]
        item.quality `should be equal to` actualQuality + 2
    }

    @Test
    fun `should increase the quality of backstage passes by 3 when there are less than 5 days to concert`(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3 , 5))
        val app = GildedRose(items)
        val actualQuality = items[0].quality
        app.updateQuality()
        val item= items[0]
        item.quality `should be equal to` actualQuality + 3
    }

    @Test
    fun `should make quality as 0 when concert as passed`(){
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", -2 , 5))
        val app = GildedRose(items)
        app.updateQuality()
        val item= items[0]
        item.quality `should be equal to` 0
    }
}


