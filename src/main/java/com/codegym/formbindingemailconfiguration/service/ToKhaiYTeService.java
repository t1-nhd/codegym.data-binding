package com.codegym.formbindingemailconfiguration.service;

import com.codegym.formbindingemailconfiguration.model.ToKhaiYTe;

public class ToKhaiYTeService implements IToKhaiYTeService {
    private ToKhaiYTe toKhaiYTe = new ToKhaiYTe();

    @Override
    public ToKhaiYTe getToKhaiYTe() {
        return this.toKhaiYTe;
    }

    @Override
    public void saveToKhaiYTe(ToKhaiYTe toKhaiYTe) {
        toKhaiYTe.setHoTen(toKhaiYTe.getHoTen().toUpperCase());
		this.toKhaiYTe = toKhaiYTe;
    }

    @Override
    public void updateToKhaiYTe(ToKhaiYTe toKhaiYTe) {
		this.toKhaiYTe = toKhaiYTe;
    }

    @Override
    public void deleteToKhaiYTe() {
		this.toKhaiYTe = null;
    }
}
