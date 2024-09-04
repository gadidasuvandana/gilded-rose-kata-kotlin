package com.gildedrose.InventoryStrategies

import com.gildedrose.Item

class BackstagePassStrategy : UpdateQualityStrategy {
    override fun updateInventory(itemList: List<Item>) {
        itemList.forEach { item ->
            item.sellIn -= 1
            item.quality += 1
            if(item.sellIn < 0){
                item.quality = 0
            }
            if (item.sellIn in 5..10) {
                if (item.quality < 50) {
                    item.quality += 1
                }
            }
            if (item.sellIn in 0..5) {
                if (item.quality < 50) {
                    item.quality += 2
                }
            }
        }
    }
}