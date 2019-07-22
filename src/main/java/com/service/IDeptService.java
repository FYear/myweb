package com.service;

import com.entity.*;
import java.util.*;

public interface IDeptService {
    List<Dept> selectAll();
    Dept selectByPrimaryKey(Integer deptno);
}
