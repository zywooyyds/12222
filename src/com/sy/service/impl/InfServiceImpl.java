package com.sy.service.impl;

import com.sy.entity.Det;
import com.sy.entity.Inf;
import com.sy.exception.BusinessException;
import com.sy.mapper.InfMapper;
import com.sy.service.InfService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class InfServiceImpl implements InfService {

    @Autowired
    private InfMapper infMapper;

    @Override
    public boolean insertInf(Inf inf) {
        int num = inf.getNum();
        String username = inf.getUsername();
        String des = inf.getDes();
        if (StringUtils.isBlank(username)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "用户名不能为空");
        }
        if (StringUtils.isBlank(des)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "问题不能为空");
        }
        boolean b = infMapper.insertInf(inf);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "添加失败");
        }
        return true;
    }

    @Override
    public boolean insertOpt(Det det) {

        boolean b = infMapper.insertOpt(det);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "添加失败");
        }
        return true;
    }

    @Override
    public boolean updateDes(Inf inf) {
        boolean b = infMapper.updateDes(inf);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "更新失败");
        }
        return true;
    }

    @Override
    public boolean updateRes(Det det) {
        boolean b = infMapper.updateRes(det);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "更新失败");
        }
        return true;
    }

    @Override
    public boolean deleteDes(Inf inf) {
        boolean b = infMapper.deleteDes(inf);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "删除失败");
        }
        return true;
    }

    @Override
    public boolean deleteOneOpt(Det det) {
        boolean b = infMapper.deleteOneOpt(det);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "删除失败");
        }
        return true;
    }

    @Override
    public boolean deleteAllOpt(Inf inf) {
        boolean b = infMapper.deleteAllOpt(inf);
        if (!b) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "删除失败");
        }
        return true;
    }
}
