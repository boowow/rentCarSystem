package com.hwua.view;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.Car;
import com.hwua.service.IAdminService;
import com.hwua.service.IUserService;
import com.hwua.service.impl.AdminServiceImpl;
import com.hwua.service.impl.UserServiceImpl;
import com.hwua.util.InputUtil;

public class AdminCheckCar {
	private IAdminService ias = new AdminServiceImpl();
	public void checkCar() throws SQLException{
		System.out.println("��ѡ���ѯ������ʽ��");
		System.out.println("1.��ѯȫ������  2.�������  3.�������  4.����Ʒ��  5.�������  6.�޸�����  7.��ѯ�⳵��¼  ����.�˳���¼");
		int choose = InputUtil.getInt();
		switch(choose){
		case 1:
			//��ѯȫ������ 
			List<Car> adminCheckCar = ias.adminCheckCar();
			showCarList(adminCheckCar);
			//���ر�ҳ��
			checkCar();
			break;
		case 2:
			//�������
			System.out.println("�����������ı�ţ�");
			long id = InputUtil.getLong();
			List<Car> checkCarId = ias.checkCarId(id);
			showCarList(checkCarId);
			//���ر�ҳ��
			checkCar();
			break;
		case 3:
			//�������
			System.out.println("�������������ͣ�");
			String type = InputUtil.getString();
			List<Car> checkCarType = ias.checkCarType(type);
			showCarList(checkCarType);
			//���ر�ҳ��
			checkCar();
			break;
		case 4:
			//����Ʒ��
			System.out.println("����������Ʒ�ƣ�");
			String brand = InputUtil.getString();
			List<Car> checkCarBrand = ias.checkCarBrand(brand);
			showCarList(checkCarBrand);
			//���ر�ҳ��
			checkCar();
			break;
		case 5:
			//�������
			new AdminAddCarView().addCar();
			//���ر�ҳ��
			checkCar();
			break;
		case 6:
			//�޸�����
			new AdminUpdateCarView().updateCar();
			//���ر�ҳ��
			checkCar();
			break;
		case 7:
			//��ѯ�⳵��¼,�����ѯ�⳵��¼����
			new AdminCheckRecordView().checkRecord();
			//���ر�ҳ��
			checkCar();
			break;
		default:
			System.exit(0);
			break;
		}
	}
	private void showCarList(List<Car> adminCheckCar) {
		System.out.println("��ܰ��ʾ: 1:�������  0:��������");
			System.out.println("       1:�����ϼ�  0:����δ�ϼ�");
		System.out.println("���\t����\t���ƺ�\t��ɫ\t����\t��ע\tƷ��\t����\t���\t����\t�ϼ�");
		for (Car car : adminCheckCar) {
			System.out.println(car.getC_id()+"\t"+car.getC_name()+"\t"+car.getC_carNumber()
			+"\t"+car.getC_color()+"\t"+car.getC_carprice()+"\t"+car.getC_remark()+"\t"+
					car.getC_brand()+"\t"+car.getC_type()+"\t"+car.getC_price()+"\t"+
			car.getC_ifrent()+"\t"+car.getC_ifputaway());
		}
	}
	
}
