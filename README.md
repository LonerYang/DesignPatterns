# DesignPatterns
23种设计模式
配套笔记（https://note.youdao.com/ynoteshare/index.html?id=2b53c8478ca9d938c7288f92815e26bc&type=notebook&tdsourcetag=s_pctim_aiomsg）
**注意**
调停者模式(Mediator)和门面模式(facade)在坦克大战中用到了
    -对于TankFrame来说，其中的GameModel成员变量就是门面，所有新添加到游戏中的物体只需要给GameModel就行
    -对于新添加到游戏中的物体来说，GameModel是调停者，所有物体的相互碰撞，只要全部交给GameModel就行，GameModel
        中使用责任链模式来处理了
解释器模式(Intepreter)需要写一个解释器；相当于python的解释器，这里就省略了；用的也非常少       