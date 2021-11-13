package Bai3_61134327;

import java.time.LocalDate;

public class SinhVien {
	private String MaSV,Ho,Ten;
	private LocalDate NamSinh;
	private Double diem;

	public SinhVien(String maSV, String ho, String ten, LocalDate namSinh, Double diem) {
		super();
		MaSV = maSV;
		Ho = ho;
		Ten = ten;
		NamSinh = namSinh;
		this.diem = diem;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getHo() {
		return Ho;
	}

	public void setHo(String ho) {
		Ho = ho;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public LocalDate getNamSinh() {
		return NamSinh;
	}

	public void setNamSinh(LocalDate namSinh) {
		NamSinh = namSinh;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}
}
