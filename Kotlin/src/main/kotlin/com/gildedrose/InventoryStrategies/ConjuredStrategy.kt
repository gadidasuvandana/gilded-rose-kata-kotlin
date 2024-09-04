package com.gildedrose.InventoryStrategies

import com.gildedrose.Item

class ConjuredStrategy:UpdateQualityStrategy {
    override fun updateInventory(itemList: List<Item>) {
        itemList.forEach { item ->
            item.sellIn -= 1
            if(item.quality > 0){
                item.quality -=2
                if(item.sellIn <0){
                    item.quality -=2
                }
            }
        }
    }
}