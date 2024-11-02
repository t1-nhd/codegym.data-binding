package com.codegym.formbindingemailconfiguration.model;

import lombok.*;

import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ToKhaiYTe {
    private String hoTen;
    private int namSinh;
    private boolean gioiTinh;
    private String quocTich;
    private String soDinhDanh;
    private String sdt;
    private String email;
	private Map<String, Boolean> dauHieuTrong14Ngay;
    private Map<Integer, Boolean> lichSuPhoiNhiem;
}
