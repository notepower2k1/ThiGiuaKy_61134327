package Bai3_61134327;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SinhVienDAL {
	Connection ketNoi;
	
	public SinhVienDAL() {
		this.ketNoi = KetNoiDB.KetNoi("qlhanghoa", "root", "");
	}
	
	public void insert(SinhVien sinhvien) {
		String sqlThem ="INSERT INTO SinhVien(MaSV, HoSV, TenSV, Namsinh,Diem) VALUES (?,?,?,?,?)";
		PreparedStatement lenhThem;
		try {
			lenhThem = ketNoi.prepareStatement(sqlThem);
			
			lenhThem.setString(1,sinhvien.getMaSV());
			lenhThem.setString(2,sinhvien.getHo());
			lenhThem.setString(3,sinhvien.getTen());
			lenhThem.setObject(4,sinhvien.getNamSinh());

			lenhThem.setString(5,String.valueOf(sinhvien.getDiem()));
			
			lenhThem.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
