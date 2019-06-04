package com.ahead.adapter.v2;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/6/3
 */
public class Main {
	public static void main(String[] args) {
		Phone phone = new Phone();
		VoltageAdapter voltageAdapter = new VoltageAdapter();
		phone.setVoltageAdapter(voltageAdapter);
		phone.charge();
	}
}

class Phone {
	//正常电压是220V，一个常量
	public static final int V = 220;

	private VoltageAdapter voltageAdapter;

	//充电
	public void charge() {
		voltageAdapter.changeVoltage();
	}


	public void setVoltageAdapter(VoltageAdapter voltageAdapter) {
		this.voltageAdapter = voltageAdapter;
	}

}

//变压器
class VoltageAdapter {

	//改变电压的方法
	public void changeVoltage() {
		System.out.println("正在充电...");
		System.out.println("原始电压：" + Phone.V + "V");
		System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
	}
}
