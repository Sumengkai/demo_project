package com.example.demo_project;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class DemoProjectApplicationTests_IO_Test {
	// =================================================================
	@Test
	public void fileOutputStreamTest() throws IOException {

		// �o�̥i���w���|�A�Y�S���w�|�]��ӱM�ר��h EX : D:\firstjava\\�ɦW
//		FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text01.txt");
//		try {
//			fos.write(70);
//			System.out.println("�g�J���\ ! ");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			fos.close(); 
//
//		}
		// -----------------------------------------------------------------
		// try-with-resouce (�ۤ�W����try �o�˰����ت��O�L�|��������������� <close> )
		// fos.close(); =>�קK�X�{���w�������~
		String k = "A";
		try (FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text01.txt")) {
			fos.write(k.getBytes()); // ���o�G�i����e (�n�ন�r��)
			System.out.println("�g�J���\ ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// =====================================================�[�ӥ��L�A���|�мg���쥻�b�ɮפ��x�F��
	@Test
	public void fileOutputStreamAndBooleanTest() throws IOException {
		String k = "A";
		String k2 = "C";
		try (FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text01.txt", true)) {
			fos.write('\n');
			fos.write(k2.getBytes()); // ���o�G�i����e (�n�ন�r��)
			System.out.println("�g�J���\ ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ============================================================
	@Test
	public void fileInputStreamTest() {
		try (FileInputStream fis = new FileInputStream("D:\\firstjava\\text01.txt")) {
			int b = fis.read();
			System.out.println(b + " �Ʀr");
			System.out.println((char) b + " ��r��");
			System.out.println("�ɮ�Ū�����\");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ============================================================
//	FileOutputStream�g�J
//	FileInputStream��X
	@Test
	public void fileInputAndOutputStreamTest() {
		String file = "C:\\Users\\lenovo\\Desktop";
		try (FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\�l��\\���۪��l��.jpg");
				FileOutputStream fos = new FileOutputStream("D:\\firstjava\\���۪��l��Test.jpg")) {
			System.out.println(fis.available() + " �ɮפj�p");
			byte[] b = fis.readAllBytes();// Ū�Xfis���ɮ�
			byte[] bb = new byte[fis.available()];
			System.out.println(b + " ��mbyte = b");
			System.out.println(bb + " ��mbyte = bb");
			// �Qbyte = bŪ����Afis���ɮ״N�w���s�b
			System.out.println(fis.available() + " �ɮפj�p�A�]���W�誺�ɮ׳Qbyte = bŪ���A�ҥH�o�̷|�Q�k�s ( fis���ɮ״N�w���s�b )");
			System.out.println("�ɮ�Ū�����\");
			System.out.println("------------");
			fos.write(b);
			System.out.println("�g�J���\ ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ============================================================
	// try-with-resouce (�ۤ�W����try �o�˰����ت��O�L�|��������������� <close> )
	// �w�İ�BufferedOutputStream
	@Test
	public void bufferedFileOutputStreamTest() throws IOException {
		String str = "ASDFĬ���ʹ���";

		try (FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text02.txt");
				BufferedOutputStream bfos = new BufferedOutputStream(fos)) {
			fos.write(str.getBytes()); // ���o�G�i����e (�n�ন�r��)
			bfos.flush();
			System.out.println("�g�J���\ ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
