package com.example.demo.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ChuyenBay;
import com.example.demo.repository.ChuyenBayRepository;

@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	private ChuyenBayRepository chuyenBayRepository;

	@ResponseBody
	@GetMapping("/")
	public String home() {
		String html = "";
		html += "<ul>";
		html += " <li><a href='/insert'>Insert database</a></li>";
		html += " <li><a href='/showAll'>Show All Chuyến bay</a></li>";
		html += " <li><a href='/1'>1. Cho biết các chuyến bay đi Đà Lạt (DAD).</a></li>";
		html += "</ul>";
		return html;
	}
	
	@GetMapping("/insert")
	public void insertDb() {
		List<ChuyenBay> dsChuyenBay = new ArrayList<>();
		dsChuyenBay.add(
				new ChuyenBay("VN216", "SGN", "DIN", 4170, Time.valueOf("10:30:00"), Time.valueOf("14:20:00"), 26));
		dsChuyenBay.add(
				new ChuyenBay("VN254", "SGN", "HUI", 8765, Time.valueOf("18:40:00"), Time.valueOf("20:00:00"), 781));
		dsChuyenBay.add(
				new ChuyenBay("VN269", "HAN", "CXR", 1262, Time.valueOf("14:10:00"), Time.valueOf("15:50:00"), 202));
		dsChuyenBay.add(
				new ChuyenBay("VN276", "DAD", "CXR", 1283, Time.valueOf("09:00:00"), Time.valueOf("12:00:00"), 203));
		dsChuyenBay.add(
				new ChuyenBay("VN280", "SGN", "HPH", 11979, Time.valueOf("06:00:00"), Time.valueOf("08:00:00"), 1279));
		dsChuyenBay.add(
				new ChuyenBay("VN315", "HAN", "DAD", 134, Time.valueOf("11:45:00"), Time.valueOf("13:00:00"), 112));
		dsChuyenBay.add(
				new ChuyenBay("VN317", "HAN", "UIH", 827, Time.valueOf("15:00:00"), Time.valueOf("16:15:00"), 190));
		dsChuyenBay.add(
				new ChuyenBay("VN320", "SGN", "DAD", 2798, Time.valueOf("06:00:00"), Time.valueOf("07:10:00"), 221));
		dsChuyenBay.add(
				new ChuyenBay("VN338", "SGN", "BMV", 4081, Time.valueOf("15:25:00"), Time.valueOf("16:25:00"), 375));
		dsChuyenBay.add(
				new ChuyenBay("VN374", "HAN", "VII", 510, Time.valueOf("11:40:00"), Time.valueOf("13:25:00"), 120));
		dsChuyenBay.add(
				new ChuyenBay("VN375", "VII", "CXR", 752, Time.valueOf("14:15:00"), Time.valueOf("16:00:00"), 181));
		dsChuyenBay.add(
				new ChuyenBay("VN431", "SGN", "CAH", 3693, Time.valueOf("05:55:00"), Time.valueOf("06:55:00"), 236));
		dsChuyenBay.add(
				new ChuyenBay("VN440", "SGN", "BMV", 4081, Time.valueOf("18:30:00"), Time.valueOf("19:30:00"), 426));
		dsChuyenBay.add(
				new ChuyenBay("VN464", "SGN", "DLI", 2002, Time.valueOf("07:20:00"), Time.valueOf("08:05:00"), 225));
		dsChuyenBay.add(
				new ChuyenBay("VN474", "PXU", "PQC", 1586, Time.valueOf("08:40:00"), Time.valueOf("11:20:00"), 102));
		dsChuyenBay.add(
				new ChuyenBay("VN476", "UIH", "PQC", 485, Time.valueOf("09:15:00"), Time.valueOf("11:50:00"), 117));
		dsChuyenBay.add(
				new ChuyenBay("VN651", "DAD", "SGN", 2798, Time.valueOf("19:30:00"), Time.valueOf("08:00:00"), 221));
		dsChuyenBay.add(
				new ChuyenBay("VN741", "HAN", "PXU", 395, Time.valueOf("06:30:00"), Time.valueOf("08:30:00"), 120));

		chuyenBayRepository.saveAll(dsChuyenBay);
}

	@GetMapping("/showAll")
	public List<ChuyenBay> showAll() {
		return chuyenBayRepository.findAll();
	}

	@ResponseBody
	@RequestMapping("/1")
	public List<ChuyenBay> showGaDen() {
		return chuyenBayRepository.findByGaDen("DAD");
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<ChuyenBay> showByLoaiMB() {
		return chuyenBayRepository.findChuyenBay("Airbus A320");
	}
}
