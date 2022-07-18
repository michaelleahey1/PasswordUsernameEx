package com.ust.util.passwordEx.PasswordEx.dao;

import com.ust.util.passwordEx.PasswordEx.model.RequiredInfo;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface RequiredInfoDao {
    default int insertRequiredInfo(RequiredInfo requiredInfo){
        Random rand = new Random();
        int uid = rand.nextInt();
        return insertRequiredInfo(uid, requiredInfo);
    }
    int insertRequiredInfo(int uid, RequiredInfo requiredInfo);
    int updateRequiredInfo(int uid, RequiredInfo requiredInfo);
    int deleteRequiredInfos(int uid);
    List<RequiredInfo> queryRequiredInfos();
    Optional<RequiredInfo> queryRequiredInfo(int uid);
}
