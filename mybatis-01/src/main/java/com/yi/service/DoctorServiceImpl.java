package com.yi.service;

import com.yi.mapper.DoctorMapper;
import com.yi.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;
    @Override
    public int insertDoc(Doctor doctor) {
        return 0;
    }

    @Override
    public int deleteDocById(int doctorid) {
        return 0;
    }

    @Override
    public int updateDoc(Doctor doctor) {
        return 0;
    }

    @Override
    public List<Doctor> queryAllDoc() {
        return doctorMapper.queryAllDoc();
    }

    @Override
    public Doctor queryDocById(int doctorid) {
        return doctorMapper.queryDocById(doctorid);
    }
}
