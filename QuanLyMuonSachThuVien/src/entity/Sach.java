package entity;

import java.util.Scanner;

import constant.chuyenNganh;
import constant.loaiBanDoc;

public class Sach {
	 private static int AUTO_ID = -1;
	 private int id; 
 private String tenSach; 
 private String tacGia;
 private chuyenNganh cnganh; 
 private String namXb;
 
 public Sach(){
	 if(AUTO_ID == -1) {
		 AUTO_ID = 100000;
		 this.id = AUTO_ID;
		 return;
	 }
	 this.id = ++AUTO_ID;
}


public int getId() {
	return id;
}

public String getTenSach() {
	return tenSach;
}

public void setTenSach(String tenSach) {
	this.tenSach = tenSach;
}

public String getTacGia() {
	return tacGia;
}

public void setTacGia(String tacGia) {
	this.tacGia = tacGia;
}

public String getNamXb() {
	return namXb;
}

public void setNamXb(String namXb) {
	this.namXb = namXb;
}
 

@Override
public String toString() {
	  return "entity.Sach{" +
              "id=" + id +
              ", tenSach='" + tenSach + '\'' +
              ", tacgia='" + tacGia + '\'' +
              ", chuyenNganh='" + cnganh + '\'' +
              ", namXuatBan='" + namXb + '\'' +
              '}';
}
 
public void inputInfo() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhập tên sách:  ");
	this.tenSach = sc.nextLine();
	System.out.println("Nhập tác giả:  ");
	this.tacGia = sc.nextLine();
	System.out.println("Nhập năm xuất bản:  ");
	this.namXb = sc.nextLine();
	System.out.println("chọn chuyên ngành của sách:");
	System.out.println("1. Khoa học tự nhiên");
	System.out.println("2. Văn học - Nghệ thuật");
	System.out.println("3. Điện tử - Viễn thông");
	System.out.println("4. Công nghệ thông tin");
	System.out.print("Mời chọn lựa chọn của bạn");
	int choice = -1;
	do {
		choice = sc.nextInt();
		if(choice >=1 && choice<=4) {
			break;
		}
		System.out.println("lựa chọn loại bạn đọc không hợp lệ, vui lòng chọn lại");
	} while (choice >4 || choice <1);
	switch (choice) {
	case 1: 
		this.cnganh = chuyenNganh.KHTN;
		break;
	case 2: 
		this.cnganh = chuyenNganh.VH_NT;
		break;
	case 3: 
		this.cnganh = chuyenNganh.ĐTVT;
		break;
	case 4: 
		this.cnganh = chuyenNganh.CNTT;
		break;
	}	
}

}
