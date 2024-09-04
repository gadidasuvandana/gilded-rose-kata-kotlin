package com.gildedrose.InventoryStrategies

import com.gildedrose.Item

interface UpdateQualityStrategy {
    fun updateInventory(itemList: List<Item>) {
        itemList.forEach { item ->
            item.sellIn -= 1
            if (item.quality > 0) {
                item.quality -= 1
                if (item.sellIn <= 0) {
                    item.quality -= 1
                }
            }
        }
    }
}
