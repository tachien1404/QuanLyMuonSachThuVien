package Main;

import java.util.Scanner;

import entity.BanDoc;
import entity.ChiTietMuonSach;
import entity.QuanLyMuonSach;
import entity.Sach;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	private static BanDoc[] BANDOC = new BanDoc[100];
	private static Sach[] SACH = new Sach[100];
	private static QuanLyMuonSach[] QUANLYMUONSACH = new QuanLyMuonSach[100];

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		while (true) {
			int chon = chonMenu();
			switch (chon) {
			case 1:
				nhapMoiSach();
				break;
			case 2:
				hienThiDsSach();
				break;
			case 3:
				themMoiBanDoc();
				break;
			case 4:
				hienThiDsBanDoc();
				break;
			case 5:
				taoPhieuMuon();
				showAllPhieuMuon();
				break;
			case 6:
				showAllPhieuMuon();;
				break;
			case 7:
				sxTheoTen();;
				break;
			case 8:
				sxTheoSL();
				break;
			case 9:
				timKiemTheoTen();
				break;
			case 10:
				System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
				return;
			}
		}
	}

	public static int chonMenu() {
		System.out.println("__________________________Menu___________________________");
		System.out.println("1. Nhập danh sách đầu sách mới");
		System.out.println("2. In danh sách những đầu sách hiện có ");
		System.out.println("3. Nhập danh sách bạn đọc mới");
		System.out.println("4. Hiển thị danh sách bạn đọc có trong hệ thống");
		System.out.println("5. Tạo phiếu mượn ");
		System.out.println("6. Thống kê số lượng mượn sách của bạn đọc theo đầu sách ");
		System.out.println("7. Sắp xếp danh sách QLMS theo tên bạn đọc");
		System.out.println("8. Sắp xếp danh sách QLMS theo số lượng sách được mượn(giảm dần)");
		System.out.println("9 Tìm kiếm và hiện thị danh sách mượn đọc theo tên bạn đọc");
		System.out.println("10. Thoát chương trình");
		System.out.println("___________________________________________________________");
		System.out.print("Xin mời nhập lựa chọn của bạn: ");
		int chon = -1;
		do {
			chon = sc.nextInt();
			if (chon >= 1 && chon <= 10) {
				break;
			}
			System.out.println("Chuc nang khong hop le, vui long chon lai");
		} while (chon > 10 || chon < 1);
		return chon;
	}

	private static void themMoiBanDoc() {
		System.out.print("Nhập số lượng bạn đọc mới muốn thêm: ");
		int slBanDoc = sc.nextInt();
		for (int i = 0; i < slBanDoc; i++) {
			System.out.println("Nhập thông tin cho bạn đoc thứ " + (i + 1));
			BanDoc banDoc = new BanDoc();
			banDoc.inputInfo();
			// lưu vào mảng BANDOC
			luuBanDoc(banDoc);
		}
	}

	private static void luuBanDoc(BanDoc bandoc) {
		for (int j = 0; j < BANDOC.length; j++) {
			if (BANDOC[j] == null) {
				BANDOC[j] = bandoc;
				break;
			}
		}
	}

	private static void hienThiDsBanDoc() {
		for (int i = 0; i < BANDOC.length; i++) {
			if (BANDOC[i] == null) {
				continue;
			}
			System.out.println(BANDOC[i]);
		}
	}

	// sach

	private static void nhapMoiSach() {
		System.out.print("Nhập số lượng đầu sách mới muốn thêm: ");
		int slSach = sc.nextInt();
		for (int i = 0; i < slSach; i++) {
			System.out.println("Nhập thông tin cho sách thứ " + (i + 1));
			Sach sach = new Sach();
			sach.inputInfo();

			luuSach(sach);
		}
	}

	private static void luuSach(Sach sach) {
		for (int i = 0; i < SACH.length; i++) {
			if (SACH[i] == null) {
				SACH[i] = sach;
				break;
			}
		}

	}

	private static void hienThiDsSach() {
		for (int i = 0; i < SACH.length; i++) {
			if (SACH[i] == null) {
				continue;
			}
			System.out.println(SACH[i]);
		}
	}

	// tạo phiếu mượn

	private static void taoPhieuMuon() {
		if (!checkDl()) {
			System.out.println("Chưa có dữ liệu về bạn đọc hay sách, hãy nhập thông tin bạn đọc và sách:");
			return;
		}

		System.out.println("nhập số lượng bạn đọc muốn mượn:");
		int sl = sc.nextInt();

		// xác định bạn đọc
		for (int i = 0; i < sl; i++) {
			QuanLyMuonSach phieumuon = new QuanLyMuonSach();
			// xác nhận người mượn
			BanDoc ngMuon = nhapNguoiMuon(i);
			phieumuon.setBanDoc(ngMuon);

			// xác nhận bạn đọc muốn mượn những quyển sách nào
			ChiTietMuonSach[] chitietMuonSach = taoPhieuMuonCT();
			phieumuon.setChiTietMuonSachh(chitietMuonSach);

			// lưu ds phieu mươn
			luuPhieuMuon(phieumuon);
		}
	}

	private static void luuPhieuMuon(QuanLyMuonSach phieumuon) {
		for (int i = 0; i < QUANLYMUONSACH.length; i++) {
			if (QUANLYMUONSACH[i] == null) {
				QUANLYMUONSACH[i] = phieumuon;
				return;
			}
		}
	}

	private static boolean checkDl() {
		boolean duLieuBanDoc = false;
		for (int i = 0; i < BANDOC.length; i++) {
			if (BANDOC[i] != null) {
				duLieuBanDoc = true;
				break;
			}
		}
		boolean duLieuSach = false;
		for (int i = 0; i < SACH.length; i++) {
			if (SACH[i] != null) {
				duLieuSach = true;
				break;
			}
		}
		return duLieuBanDoc && duLieuSach;
	}

	private static BanDoc nhapNguoiMuon(int index) {
		System.out.print("Nhập mã bạn đọc thứ " + (index + 1) + " muốn mượn sách: ");
		int idBanDoc;
		BanDoc banDoc;
		do {
			idBanDoc = sc.nextInt();
			// checkDl bạn đọc trong hệ thống
			banDoc = timTheoIdBanDoc(idBanDoc);
			if (banDoc != null) {
				break;
			}
			System.out.print("Không tồn tại bạn đọc có ID là " + idBanDoc + ", vui lòng nhập lại: ");
		} while (true);
		return banDoc;
	}

	private static BanDoc timTheoIdBanDoc(int idBanDoc) {
		for (int i = 0; i < BANDOC.length; i++) {
			BanDoc ngMuon = BANDOC[i];
			if (ngMuon != null && ngMuon.getId() == idBanDoc) {
				return ngMuon;
			}
		}
		return null;
	}

	private static void showAllPhieuMuon() {
		for (int i = 0; i < QUANLYMUONSACH.length; i++) {
			QuanLyMuonSach qlMuonSach = QUANLYMUONSACH[i];
			if (qlMuonSach != null) {
				System.out.println("Bạn đọc" + qlMuonSach.getBanDoc().getHoTen() + "đã mượn những  quyển sách:");
				for (int j = 0; j < qlMuonSach.getChiTietMuonSachh().length; j++) {
					System.out.println(qlMuonSach.getChiTietMuonSachh()[j]);
				}
				System.out.println();
			}
		}
	}

	// tạo phiếu mượn chi tiết
	private static ChiTietMuonSach[] taoPhieuMuonCT() {
		System.out.println("Nhập số lượng  đầu sách mà bạn đọc muốn mượn:");
		int slDauSach;
		do {
			slDauSach = sc.nextInt();
			if (slDauSach <= 5 && slDauSach > 0) {
				break;
			}
			System.out.println("Bạn đọc không thể mượn quá 5 đầu sách hoặc số lượng đầu sách nhỏ hơn 0, hãy nhập lai");
		} while (true);

		ChiTietMuonSach[] phieuCT = new ChiTietMuonSach[slDauSach];
		for (int i = 0; i < slDauSach; i++) {
			ChiTietMuonSach phieu = new ChiTietMuonSach();
			// xác nhận bạn đọc muốn mượn sách nào
			Sach sach = nhapSach(i);
			phieu.setSach(sach);

			System.out.println("nhập số lượng sách muốn mượn:");
			int slMuon;

			do {
				slMuon = sc.nextInt();
				if (slMuon >0 && slMuon <=3) {
					break;
				}
				System.out.println("Mỗi bạn đọc không thể  mượn quá 3 cuốn sách/ 1 đầu sách hoặc Sl phải là số dương, hãy nhập lại");
			} while (true);
			phieu.setSoLuong(slMuon);

			System.out.println("Nhập tình trạng sách");
			String tinhTrang =  new Scanner(System.in).nextLine();
			phieu.setTinhTrang(tinhTrang);
			
			// lưu phiếu mượn CT vào phiếu mượn
			for (int j = 0; j < phieuCT.length; j++) {
				if (phieuCT[i] == null) {
					phieuCT[i] = phieu;
					break;
				}
			}
		}
		return phieuCT;
	}

	private static Sach nhapSach(int index) {
		System.out.println("nhập id quyển sách thứ " + (index + 1) + " bạn đọc muốn mượn:  ");
		int idSach;
		Sach sach;
		do {
			idSach = sc.nextInt();
			sach = timTheoMaSach(idSach);
			if (sach != null) {
				break;
			}
			System.out.println("Không tồn tại sách có id là  " + idSach + "  vui lòng nhập lại");
		} while (true);
		return sach;
	}

	private static Sach timTheoMaSach(int idSach) {
		for (int i = 0; i < SACH.length; i++) {
			Sach sach = SACH[i];
			if (sach != null && sach.getId() == idSach) {
				return sach;
			}
		}
		return null;
	}

	private static void timKiemTheoTen() {
		System.out.println("Nhập tên bạn đọc muốn tìm kiếm lịch sử mượn sách:");
		String name =  new Scanner(System.in).nextLine();
		System.out.println("lịch sử mượn sách của bạn đọc" +name);
		
		for(int i=0;i<QUANLYMUONSACH.length;i++) {
			QuanLyMuonSach qlms = QUANLYMUONSACH[i];
			
			if(qlms != null) {
				if(QUANLYMUONSACH[i].getBanDoc().getHoTen().equals(name)) {
					System.out.println("bạn đọc"+qlms.getBanDoc().getHoTen() +"đã mượn các quyển sách sau:");
					for(int j = 0;j<qlms.getChiTietMuonSachh().length;j++) {
						System.out.println(qlms.getChiTietMuonSachh()[j]);
					}
				}
			}
		}
	}
	
	// sx hoa don theo ten
	private static void sxTheoTen() {
        // kiểm tra đã có dữ liệu hay chưa
        boolean coDuLieuHoaDon = false;
        for (int i = 0; i < QUANLYMUONSACH.length; i++) {
            if (QUANLYMUONSACH[i] != null) {
                coDuLieuHoaDon = true;
            }
        }
        if (!coDuLieuHoaDon) {
            System.out.println("Chưa có phiếu mượn nào trong hệ thống,hãy tạo hóa đơn trước khi thực hiện tính năng này.");
            return;
        }
        sxTT();
        showAllPhieuMuon();
    }
	

	 private static void sxTT() {
	        for (int i = 0; i < QUANLYMUONSACH.length - 1; i++) {
	            QuanLyMuonSach qlms1 = QUANLYMUONSACH[i];
	            for (int j = i+1; j < QUANLYMUONSACH.length; j++) {
	                QuanLyMuonSach qlms2 = QUANLYMUONSACH[j];
	                if (qlms1.getBanDoc().getHoTen().compareTo(qlms2.getBanDoc().getHoTen()) > 0){
	                    QuanLyMuonSach temp = qlms1;
	                    qlms1= qlms2;
	                    qlms2= temp;
	                }
	            }
	        }
	    }
	 
	 
	 // sx theo sl
		private static void sxTheoSL() {
	        // kiểm tra đã có dữ liệu hay chưa
	        boolean coDuLieuHoaDon = false;
	        for (int i = 0; i < QUANLYMUONSACH.length; i++) {
	            if (QUANLYMUONSACH[i] != null) {
	                coDuLieuHoaDon = true;
	            }
	        }
	        if (!coDuLieuHoaDon) {
	            System.out.println("Chưa có phiếu mượn nào trong hệ thống,hãy tạo hóa đơn trước khi thực hiện tính năng này.");
	            return;
	        }
	        sxsl();
	        showAllPhieuMuon();
	    }
	   private static void sxsl() {
	        for (int i = 0; i < QUANLYMUONSACH.length - 1; i++) {
	            QuanLyMuonSach qlms1 = QUANLYMUONSACH[i];
	            for (int j = i+1; j < QUANLYMUONSACH.length; j++) {
	                QuanLyMuonSach qlms2 = QUANLYMUONSACH[j];
	              if(qlms1.tongSLSach()>qlms2.tongSLSach()) {
	            	  QuanLyMuonSach temp = qlms1;
	            	  qlms1 = qlms2;
	            	  qlms2 = temp;
	              }
	            }
	        }
	    }
}
