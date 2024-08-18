package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val backStagePasses = SpecialItem.BACKSTAGE_PASSES.itemName
            val agedBrie = SpecialItem.AGED_BRIE.itemName
            val sulfuras = SpecialItem.SULFURAS.itemName
            if (items[i].name != agedBrie && items[i].name != backStagePasses) {
                if (items[i].quality > 0) {
                    if (items[i].name != sulfuras) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == backStagePasses) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != sulfuras) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != agedBrie) {
                    if (items[i].name != backStagePasses) {
                        if (items[i].quality > 0) {
                            if (items[i].name != sulfuras) {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}

