package com.example.demo.repository;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.ChuyenBay;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
	List<ChuyenBay> findByGaDen(String gaDen);

	@Query(value = "SELECT * FROM chuyenbay  WHERE DoDai > ?1 and DoDai < ?2", nativeQuery = true)
	List<ChuyenBay> findByDuongbay(int dbay1, int dbay2);

//	@Query(value = "SELECT * FROM chuyenbay  WHERE GaDi = ?1 and GaDen = ?2", nativeQuery = true)
//	List<ChuyenBay> findBySG_BMT(String GaDi, String GaDen);
//
//	@Query(value = "SELECT COUNT(*) FROM chuyenbay where GaDi = ?1", nativeQuery = true)
//	int countChuyenBay(String GaDi);
//	
	@Query("select c from ChuyenBay c where c.doDai >= (select m.tamBay from MayBay m where m.loai = ?1)")
	List<ChuyenBay> findChuyenBay(String loaiMB);
//	
//	@Query("select c from ChuyenBay c where c.gaDi in (select cb.gaDen from ChuyenBay cb) and c.gaDen in (select cc.gaDi from ChuyenBay cc)")
//	List<ChuyenBay> findDiVe();
//	
//	@Query("select c.gaDi as gaDi, COUNT(c.gaDi) as soChuyenBay from ChuyenBay c GROUP BY c.gaDi")
//	List<Map<String, Object>> countGadi();
//	
//	@Query("select c.gaDi as gaDi, SUM(c.chiPhi) as tongChiPhi from ChuyenBay c GROUP BY c.gaDi")
//	List<Map<String, Object>> sumChiPhi();
//	
//	@Query("SELECT c FROM ChuyenBay c WHERE gioDi < ?1")
//	List<ChuyenBay> findByGiodi(Time gioDi);
//	
//	@Query("select c.gaDi as gaDi,count(c.gaDi) as soChuyenBayTruoc12h from ChuyenBay c  where c.gioDi < '12:00:00' GROUP BY c.gaDi")
//	List<Map<String, Object>> countChuyenBayTruoc12h();
//	
//	@Query("select c from ChuyenBay c where c.doDai <= (select min(m.tamBay) from MayBay m where m.loai like ?1)")
//    List<ChuyenBay> findChuyenBayBoeing(String tenLoai);
}
