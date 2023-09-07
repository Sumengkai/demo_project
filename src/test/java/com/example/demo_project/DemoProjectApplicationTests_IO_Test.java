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

		// 這裡可指定路徑，若沒指定會跑到該專案那層 EX : D:\firstjava\\檔名
//		FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text01.txt");
//		try {
//			fos.write(70);
//			System.out.println("寫入成功 ! ");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			fos.close(); 
//
//		}
		// -----------------------------------------------------------------
		// try-with-resouce (相比上面的try 這樣做的目的是他會幫忙把該關都關掉 <close> )
		// fos.close(); =>避免出現未預期的錯誤
		String k = "A";
		try (FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text01.txt")) {
			fos.write(k.getBytes()); // 取得二進制的內容 (要轉成字元)
			System.out.println("寫入成功 ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// =====================================================加個布林，不會覆寫掉原本在檔案內ㄉ東西
	@Test
	public void fileOutputStreamAndBooleanTest() throws IOException {
		String k = "A";
		String k2 = "C";
		try (FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text01.txt", true)) {
			fos.write('\n');
			fos.write(k2.getBytes()); // 取得二進制的內容 (要轉成字元)
			System.out.println("寫入成功 ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ============================================================
	@Test
	public void fileInputStreamTest() {
		try (FileInputStream fis = new FileInputStream("D:\\firstjava\\text01.txt")) {
			int b = fis.read();
			System.out.println(b + " 數字");
			System.out.println((char) b + " 轉字元");
			System.out.println("檔案讀取成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ============================================================
//	FileOutputStream寫入
//	FileInputStream輸出
	@Test
	public void fileInputAndOutputStreamTest() {
		String file = "C:\\Users\\lenovo\\Desktop";
		try (FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\子瑜\\躺著的子瑜.jpg");
				FileOutputStream fos = new FileOutputStream("D:\\firstjava\\躺著的子瑜Test.jpg")) {
			System.out.println(fis.available() + " 檔案大小");
			byte[] b = fis.readAllBytes();// 讀出fis的檔案
			byte[] bb = new byte[fis.available()];
			System.out.println(b + " 位置byte = b");
			System.out.println(bb + " 位置byte = bb");
			// 被byte = b讀取後，fis的檔案就已不存在
			System.out.println(fis.available() + " 檔案大小，因為上方的檔案被byte = b讀取，所以這裡會被歸零 ( fis的檔案就已不存在 )");
			System.out.println("檔案讀取成功");
			System.out.println("------------");
			fos.write(b);
			System.out.println("寫入成功 ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ============================================================
	// try-with-resouce (相比上面的try 這樣做的目的是他會幫忙把該關都關掉 <close> )
	// 緩衝區BufferedOutputStream
	@Test
	public void bufferedFileOutputStreamTest() throws IOException {
		String str = "ASDF蘇盟凱測試";

		try (FileOutputStream fos = new FileOutputStream("D:\\firstjava\\text02.txt");
				BufferedOutputStream bfos = new BufferedOutputStream(fos)) {
			fos.write(str.getBytes()); // 取得二進制的內容 (要轉成字元)
			bfos.flush();
			System.out.println("寫入成功 ! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
