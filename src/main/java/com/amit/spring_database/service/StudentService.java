package com.amit.spring_database.service;

import java.util.List;

import com.amit.spring_database.domain.ClassDomain;
import com.amit.spring_database.domain.StudentDomain;
import com.amit.spring_database.model.Student;
import com.amit.spring_database.model.request.AddStudentRequest;
import com.amit.spring_database.model.response.BaseResponse;
import com.amit.spring_database.model.utils.ApiException;
import com.amit.spring_database.model.utils.ERROR;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentDomain studentDomain;

    @Autowired
    ClassDomain classDomain;

    public BaseResponse<List<Student>> getAllStudent() {
        BaseResponse<List<Student>> response = new BaseResponse<>();
        response.setData(studentDomain.getAll());
        return response;
    }

    public BaseResponse<String> createdStudent(AddStudentRequest request) throws ApiException {
        if (StringUtils.isBlank(request.getName())) {
            throw new ApiException(ERROR.INVALID_PARAM, "Tên sinh viên không được bỏ trống");
        }

        if (classDomain.findById(request.getAClass().getId()) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Lớp không tốn tại");
        }

        studentDomain.create(request.getName(), request.getCode(), request.getAClass());
        return new BaseResponse<String>();
    }

    public BaseResponse<String> delete(Integer id) throws ApiException {
        if (studentDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }

        studentDomain.delete(id);
        return new BaseResponse<>();
    }

    public BaseResponse<String> update(Integer id, AddStudentRequest request) throws ApiException {
        if (studentDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }

        if (StringUtils.isBlank(request.getName())) {
            throw new ApiException(ERROR.INVALID_PARAM, "Tên sinh viên không được bỏ trống");
        }

        if (classDomain.findById(request.getAClass().getId()) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Lớp không tốn tại");
        }

        studentDomain.update(id, request.getName(), request.getCode(), request.getAClass());

        return new BaseResponse<String>();
    }

    public BaseResponse<Student> findById(Integer id) throws ApiException {
        if (studentDomain.findById(id) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }
        BaseResponse<Student> response = new BaseResponse<>();
        response.setData(studentDomain.findById(id));
        return response;
    }

    public BaseResponse<Student> findByName(String name) throws ApiException {
        if (studentDomain.findByName(name) == null) {
            throw new ApiException(ERROR.NOT_FOUND, "Không tìm thấy sinh viên");
        }
        BaseResponse<Student> response = new BaseResponse<>();
        response.setData(studentDomain.findByName(name));
        return response;
    }
}
