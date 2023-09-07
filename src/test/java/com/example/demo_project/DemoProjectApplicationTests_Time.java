package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DemoProjectApplicationTests_Time {
	@Test
	public void simpleDateFormatTest() throws ParseException {
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		System.out.println(sdff.format(new Date())); // 時間轉字串
		String dateStr = "2022-11-25";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(dateStr); // 字串轉時間
		System.out.println(newDate + " newDate");
	}

	// ----------------------------------------------------------
	@Test
	public void dateTimeFormatterTest() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月5日");
		String nowStr = now.format(format);
//		LocalDateTime now2 = LocalDateTime.parse(nowStr, format);
		System.out.println(nowStr + " 日期轉字串");// 日期轉字串
//		System.out.println(now2+" 字串轉日期");
		// --
		String pa2 = "\\d{4}年(0[1-9]|1[0-2]|[1-9])月";
		String pa3 = "^[1-9]\\d{3}年(0[1-9]|1[0-2]|[1-9])月";
		String ss = "2020年12月";
		String pa = "\\d{4}年\\d{2}[1-12]月";
		boolean checkDate = ss.matches(pa3);
		System.out.println(checkDate + "正規表達");
		String dateStr = "2021年1月1日";
		String dateStr2 = "2022年1月1日";
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy年M月d日");
		LocalDate date = LocalDate.parse(dateStr, format2);
		LocalDate date2 = LocalDate.parse(dateStr2, format2);
		boolean checkTest = date.isEqual(date2);
		System.out.println(checkTest + " checkTest");
		System.out.println(date + " 字串轉日期<解析日期>");// 字串轉日期<解析日期>
		// --
		String dateTimeStr = "2022年11月25日 00時00分00秒";
		DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
		LocalDateTime date22 = LocalDateTime.parse(dateTimeStr, format3);
		System.out.println(date22 + " 字串轉日期<解析日期>LocalDateTime");// 字串轉日期<解析日期>LocalDateTime
	}

	// ---------------------------------------------------------------
	@Test
	public void dateToLocalDateTest() {
		// atZone方法會返回該instant生成的zonedDateTime(指定時區\)
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault(); // 找到目前系統時區,<系統:電腦系統ㄉ時間>
		System.out.println("指定時區 : " + zoneId);
		LocalDate localdate = instant.atZone(zoneId).toLocalDate();
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		System.out.println("date : " + date);
		System.out.println("localdate : " + localdate);
		System.out.println("localDateTime : " + localDateTime);
	}
}
