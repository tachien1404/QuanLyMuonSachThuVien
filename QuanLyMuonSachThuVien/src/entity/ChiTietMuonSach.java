package entity;

public class ChiTietMuonSach {
private Sach sach;
private int soLuong;
private String tinhTrang;
public Sach getSach() {
	return sach;
}
public void setSach(Sach sach) {
	this.sach = sach;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public String getTinhTrang() {
	return tinhTrang;
}
public void setTinhTrang(String tinhTrang) {
	this.tinhTrang = tinhTrang;
}

@Override
public String toString() {
    return "ChiTietMuonSach{" +
            "sach=" + sach +
             "soluong=" + soLuong +
            ", tinhTrang=" + tinhTrang +
            '}';
}
}
