package com.sy.mapper;

import com.sy.entity.Det;
import com.sy.entity.Inf;

public interface InfMapper {
    boolean insertInf(Inf inf);

    boolean insertOpt(Det det);

    boolean updateDes(Inf inf);

    boolean updateRes(Det det);

    boolean deleteDes(Inf inf);

    boolean deleteOneOpt(Det det);

    boolean deleteAllOpt(Inf inf);
}
