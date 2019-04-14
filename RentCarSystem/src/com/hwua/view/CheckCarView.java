package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class CheckCarView {
	private IUserService ius = new UserServiceImpl();
	public void checkCar(String username) throws SQLException{
		System.out.println("============>��ѯ����");
		System.out.println("��ѡ���ѯ��ʽ:");
		System.out.println("1.��ѯȫ������  2.�����ѯ  3.�����ѯ  4.��������ѯ  5.����Ʒ�Ʋ�ѯ  ����.�˳���ѯҳ��");
		Integer choose = InputUtil.getInt();
		switch(choose){
		case 1:
			//�鿴������Ϣ
			List<Car> list = ius.checkCar();
			showCarList(username, list);
			break;
		case 2:
			//���ռ۸�����鿴����������Ϣ
			List<Car> list2 = ius.checkCarUp();
			showCarList(username, list2);
			break;
		case 3:
			//���ռ۸���鿴����������Ϣ
			List<Car> list3 = ius.checkCarLP();
			showCarList(username, list3);
			break;
		case 4:
			//�����������Ͳ鿴����������Ϣ
			System.out.println("�������������ͣ�");
			String type = InputUtil.getString();
			List<Car> list4 = ius.checkCarType(type);
			showCarList(username, list4);
			break;
		case 5:
			//��������Ʒ�Ʋ鿴����������Ϣ
			System.out.println("����������Ʒ�ƣ�");
			String brand = InputUtil.getString();
			List<Car> list5 = ius.checkCarBrand(brand);
			showCarList(username, list5);
			break;
		default:
			//�˳���¼
			//����ѡ��ȷ���û�����
			new SelectFunctionView().select(username);
		}
	}
	private void showCarList(String username, List<Car> list) throws SQLException {
		System.out.println("��ܰ��ʾ: 1:�������  0:��������");
		System.out.println("���\t����\t���ƺ�\t��ɫ\t����\t��ע\tƷ��\t����\t���\t����");
		for (Car car : list) {
			System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
			+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
					car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
			car.getC_ifrent());
		}
		//�ص���ҳ��
		checkCar(username);
	}
}
