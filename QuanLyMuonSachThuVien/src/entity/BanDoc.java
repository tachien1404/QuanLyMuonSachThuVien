package entity;

import java.util.Scanner;

import constant.loaiBanDoc;


public class BanDoc {
	 private static int AUTO_ID = -1;
	 
 private int id;
 private String hoTen;
 private String diaChi;
 private String sdt;
 private loaiBanDoc loaiBDoc;
 
 public BanDoc(){
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
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}


public loaiBanDoc getLoaiBDoc() {
	return loaiBDoc;
}

public void setLoaiBDoc(loaiBanDoc loaiBDoc) {
	this.loaiBDoc = loaiBDoc;
}

@Override
public String toString() {
	  return "entity.BanDoc{" +
              "id=" + id +
              ", hoTen='" + hoTen + '\'' +
              ", diaChi='" + diaChi + '\'' +
              ", sdt='" + sdt + '\'' +
              ", loaiBanDoc='" + loaiBDoc + '\'' +
              '}';
}
 
 
public void inputInfo() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhập tên bạn đọc:  ");
	this.hoTen = sc.nextLine();
	System.out.println("Nhập địa chỉ của bạn đọc:  ");
	this.diaChi = sc.nextLine();
	System.out.println("Nhập sdt của bạn đọc:  ");
	this.sdt = sc.nextLine();
	System.out.println("chọn nhóm bạn đọc:");
	System.out.println("1. Sinh viên");
	System.out.println("2. Sinh viên cao học");
	System.out.println("3. Giáo viên");
	System.out.print("Mời chọn lựa chọn của bạn");
	int choice = -1;
	do {
		choice = sc.nextInt();
		if(choice >=1 && choice<=3) {
			break;
		}
		System.out.println("lựa chọn loại bạn đọc không hợp lệ, vui lòng chọn lại");
	} while (choice >3 || choice <1);
	switch (choice) {
	case 1: 
		this.loaiBDoc = loaiBanDoc.SV;
		break;
	case 2: 
		this.loaiBDoc = loaiBanDoc.SVCH;
		break;
	case 3: 
		this.loaiBDoc = loaiBanDoc.GV;
		break;

	}	
}
 
}
