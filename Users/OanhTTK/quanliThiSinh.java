package com.quanli;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class quanliThiSinh {
	ArrayList<ThiSinh> arr;

	public void nhapthongtin() {
		String sbd, ten, sdt, diadiem;
		DiemThi dt = new DiemThi();
		ThoiGian ngaysinh = new ThoiGian();
		int khuvuc;
		System.out.println("Nhap danh sach thi sinh: ");
		for (int i = 0; i < 1/*Integer.MAX_VALUE*/; i++) {
			arr = new ArrayList<ThiSinh>();
			System.out.println("Moi nhap so bao danh: ");
			sbd = new Scanner(System.in).nextLine();
/*			if (sbd == "")
				break;
			else {*/
				System.out.println("Moi nhap ho ten: ");
				ten = new Scanner(System.in).nextLine();
				System.out.println("Moi nhap ngay sinh: ");
				ngaysinh.setNgay(new Scanner(System.in).nextInt());
				System.out.println("Moi nhap thang sinh: ");
				ngaysinh.setThang(new Scanner(System.in).nextInt());
				System.out.println("Moi nhap nam sinh: ");
				ngaysinh.setNam(new Scanner(System.in).nextInt());
				System.out.println("Moi nhap dia diem: ");
				diadiem = new Scanner(System.in).nextLine();
				System.out.println("Moi nhap so dien thoai: ");
				sdt = new Scanner(System.in).nextLine();
				System.out.println("Moi nhap khu vuc: ");
				khuvuc = new Scanner(System.in).nextInt();
				System.out.println("Moi nhap diem toan: ");
				dt.setDiemtoan(new Scanner(System.in).nextFloat());
				System.out.println("Moi nhap diem ly: ");
				dt.setDiemly(new Scanner(System.in).nextFloat());
				System.out.println("Moi nhap diem hoa: ");
				dt.setDiemhoa(new Scanner(System.in).nextFloat());
				ThiSinh thisinh = new ThiSinh(sbd, ten, ngaysinh, diadiem, sdt,dt, khuvuc);
				arr.add(thisinh);
			}
		}
	//}

	public String inthongtin(){
		String ret;
		Date date = new Date();
		float diem;
		ret ="";
		for (int i = 0; i < arr.size(); i++){
			ret += "SBD: " + arr.get(i).getSbd() + "\n";
			ret += "Ten: " + arr.get(i).getHoten() + "\n";
			ret += "Tuoi: " + (date.getYear() - arr.get(i).getNgaysinh().getNam()) + "\n";
			ret += "So dien thoai: " + arr.get(i).getSodienthoai() + "\n";
			ret += "Dia diem: " + arr.get(i).getDiadiem() + "\n";
/*			ret += "Diem toan: " + arr.get(i).getDiemthi().getDiemtoan() + "\n";
			ret += "Diem ly: " + arr.get(i).getDiemthi().getDiemly() + "\n";
			ret += "Diem hoa: " + arr.get(i).getDiemthi().getDiemhoa() + "\n";*/
/*			diem = arr.get(i).getDiemthi().getDiemtoan() + arr.get(i).getDiemthi().getDiemly() +arr.get(i).getDiemthi().getDiemhoa();
			if (arr.get(i).getKhuvuc() == 1) diem = diem + 1.5f; 
			else if (arr.get(i).getKhuvuc() == 2) diem = diem + 1f; 
			if (diem >= ThiSinh.DIEM_CHUAN) ret += "Dat"; else ret += "Rot";*/
		}
		return ret;
	}
}
