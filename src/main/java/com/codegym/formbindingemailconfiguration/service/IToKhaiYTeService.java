package com.codegym.formbindingemailconfiguration.service;

import com.codegym.formbindingemailconfiguration.model.ToKhaiYTe;

public interface IToKhaiYTeService {
    ToKhaiYTe getToKhaiYTe();
    void saveToKhaiYTe(ToKhaiYTe toKhaiYTe);
    void updateToKhaiYTe(ToKhaiYTe toKhaiYTe);
    void deleteToKhaiYTe();
}
