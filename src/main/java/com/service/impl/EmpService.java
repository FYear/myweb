package com.service.impl;

import com.entity.*;
import java.util.*;
import com.service.*;
import com.dao.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service(value = "empService")
public class EmpService implements IEmpService{
    @Autowired
    private IEmpDao dao;
}
