package com.gildedrose.InventoryStrategies

import com.gildedrose.Item

class AgedBrieStrategy: UpdateQualityStrategy {
    override fun updateInventory(itemList: List<Item>) {
        itemList.forEach { item ->
            item.sellIn -= 1
            if (item.quality < 50) {
                item.quality += 1
                if (item.sellIn <= 0) {
                    item.quality +=1
                }
            }
        }
    }
}