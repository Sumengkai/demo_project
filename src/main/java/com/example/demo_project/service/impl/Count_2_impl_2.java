package com.example.demo_project.service.impl;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Count_1;

@Service
public class Count_2_impl_2 {

	public void getCount() {
		int max = 0;/// �Ω󰻿��� ���j�骺�O����
		String a = "";// �N�L�X���G����_��
		float to;
		String chick = "";// �Ω�T�{�Τ��J���T�P�_
		Count_1 count = new Count_1();// �s��k��
		while (max < 3) {// �Ĥ@�h�j��
			Scanner scan = new Scanner(System.in);// �o�̭n�`�N�Snew�b�j��z,�|�S���s���O����Ŷ�
			System.out.println("��J�A�Q�⪺�覡 + , - , * , / (���k) , % (���l��)");
			String getsign = scan.nextLine();// �����Τ�M�w�⦡����
			count.setSign(getsign);
			if (count.getSign().equals("*") || count.getSign().equals("+") || count.getSign().equals("-")
					|| count.getSign().equals("/") || count.getSign().equals("%")) { // �u�n���T�|���i�ӳo�h�P�_
				System.out.println("��J�Ĥ@�ӼƦr,����2-20");
				double number1 = scan.nextDouble();
				count.setNumber1(number1);
				System.out.println("��J�ĤG�ӼƦr,����2-20");
				double number2 = scan.nextDouble();
				count.setNumber2(number2);
				if (count.getNumber1() < 2 || count.getNumber1() > 20 || count.getNumber2() < 2
						|| count.getNumber2() > 20) {// ��J����ӼƦr��,�P�_�O�_�Q����
					System.out.println("�Ʀr�Q����b2-20");
					max++;// �p����+1
					System.out.println("�o�˿�J���� ���T�����| �o�O��" + max + "��");
					continue;// �^��Ĥ@�h
				}

			} else {// �o�h�P�_�O��Τ��J�����T���B��Ÿ��ɷ|���i��
				max++;
				System.out.println("�o�˿�J�����T ���T�����| �o�O��" + max + "��");
				continue;// �^��Ĥ@�h
			}
			while ((count.getNumber1() >= 2 && count.getNumber1() <= 20)
					&& (count.getNumber2() >= 2 && count.getNumber2() <= 20)) {// while���ĤG�Ӧ^��,��Τ��J���T,�|���i��
				if (count.getSign().equals("*")) {// ���o������B��Ÿ�,�ݬO���@�ثK�|���i��
					to = (float) (count.getNumber1() * count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);
					System.out.println(a + " �аݳo�O�A��J���⦡��? ���T��Jy, �����T��Jn");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {// ���Τ�T�{
						System.out.println("�p�⵲�G�� :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("���Y�ӹL");
						break;// ���X"��e"�j��,�i�ϥΤ�L���ϥΦ��p���

					}

				} else if (count.getSign().equals("+")) {
					to = (float) (count.getNumber1() + count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);
					System.out.println(a + " �аݳo�O�A��J���⦡��? ���T��Jy, �����T��Jn");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("�p�⵲�G�� :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("���Y�ӹL");
						break;

					} 

				} else if (count.getSign().equals("-")) {
					to = (float) (count.getNumber1() - count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);
					System.out.println(a + " �аݳo�O�A��J���⦡��? ���T��Jy, �����T��Jn");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("�p�⵲�G�� :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("���Y�ӹL");
						break;

					}

				} else if (count.getSign().equals("/")) {
					to = (float) (count.getNumber1() / count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);

					System.out.println(a + " �аݳo�O�A��J���⦡��? ���T��Jy, �����T��Jn");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("�p�⵲�G�� :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("���Y�ӹL");
						break;

					}

				} else if (count.getSign().equals("%")) {
					to = (int) (count.getNumber1() % count.getNumber2());
					a = (count.getNumber1() + count.getSign() + count.getNumber2() + "=" + to);

					System.out.println(a + " �аݳo�O�A��J���⦡��? ���T��Jy, �����T��Jn");
					chick = scan.next();
					if (chick.equalsIgnoreCase("y")) {
						System.out.println("�p�⵲�G�� :" + a);
						break;

					} else if (chick.equalsIgnoreCase("n")) {
						System.out.println("���Y�ӹL");
						break;

					}
									}
			}
		}
	}
}
