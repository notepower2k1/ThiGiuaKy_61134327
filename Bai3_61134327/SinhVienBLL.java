package Bai3_61134327;

import java.sql.ResultSet;


public class SinhVienBLL {
	SinhVienDAL sinhvien; 
	/*public ResultSet selectAll() {
		matHang = new MatHangDAL();
		ResultSet kq = matHang.selectAll();
		return kq;
	}*/
	
	public void insert(SinhVien sv) {
		sinhvien = new SinhVienDAL();
		sinhvien.insert(sv);
	}
}
