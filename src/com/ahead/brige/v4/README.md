使用桥接模式：
分离抽象与具体实现，让他们可以独自发展
这样就可以随机组合比如WarmFlower、WarmRing、ColdCar、ColdFlower
Gift -> WarmGift ColdGift WildGift
GiftImpl -> Flower Ring Car