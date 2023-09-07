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
		System.out.println(sdff.format(new Date())); // �ɶ���r��
		String dateStr = "2022-11-25";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(dateStr); // �r����ɶ�
		System.out.println(newDate + " newDate");
	}

	// ----------------------------------------------------------
	@Test
	public void dateTimeFormatterTest() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy�~MM��5��");
		String nowStr = now.format(format);
//		LocalDateTime now2 = LocalDateTime.parse(nowStr, format);
		System.out.println(nowStr + " �����r��");// �����r��
//		System.out.println(now2+" �r������");
		// --
		String pa2 = "\\d{4}�~(0[1-9]|1[0-2]|[1-9])��";
		String pa3 = "^[1-9]\\d{3}�~(0[1-9]|1[0-2]|[1-9])��";
		String ss = "2020�~12��";
		String pa = "\\d{4}�~\\d{2}[1-12]��";
		boolean checkDate = ss.matches(pa3);
		System.out.println(checkDate + "���W��F");
		String dateStr = "2021�~1��1��";
		String dateStr2 = "2022�~1��1��";
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy�~M��d��");
		LocalDate date = LocalDate.parse(dateStr, format2);
		LocalDate date2 = LocalDate.parse(dateStr2, format2);
		boolean checkTest = date.isEqual(date2);
		System.out.println(checkTest + " checkTest");
		System.out.println(date + " �r������<�ѪR���>");// �r������<�ѪR���>
		// --
		String dateTimeStr = "2022�~11��25�� 00��00��00��";
		DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy�~MM��dd�� HH��mm��ss��");
		LocalDateTime date22 = LocalDateTime.parse(dateTimeStr, format3);
		System.out.println(date22 + " �r������<�ѪR���>LocalDateTime");// �r������<�ѪR���>LocalDateTime
	}

	// ---------------------------------------------------------------
	@Test
	public void dateToLocalDateTest() {
		// atZone��k�|��^��instant�ͦ���zonedDateTime(���w�ɰ�\)
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault(); // ���ثe�t�ήɰ�,<�t��:�q���t�Σx�ɶ�>
		System.out.println("���w�ɰ� : " + zoneId);
		LocalDate localdate = instant.atZone(zoneId).toLocalDate();
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		System.out.println("date : " + date);
		System.out.println("localdate : " + localdate);
		System.out.println("localDateTime : " + localDateTime);
	}
}
