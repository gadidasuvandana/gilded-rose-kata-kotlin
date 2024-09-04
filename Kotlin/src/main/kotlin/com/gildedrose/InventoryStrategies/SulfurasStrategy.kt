package com.gildedrose.InventoryStrategies

import com.gildedrose.Item

class SulfurasStrategy: UpdateQualityStrategy {
    override fun updateInventory(itemList: List<Item>) {
        itemList.forEach { item ->
            item.sellIn = item.sellIn
            item.quality= item.quality
        }
    }
}