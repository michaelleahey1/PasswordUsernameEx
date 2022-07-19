package com.ust.util.passwordEx.PasswordEx.service;

import com.ust.util.passwordEx.PasswordEx.dao.RequiredInfoDao;
import com.ust.util.passwordEx.PasswordEx.model.RequiredInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RequiredInfoService {
    private final RequiredInfoDao requiredInfoDao;

    @Autowired
    public RequiredInfoService(@Qualifier("RequiredInfoRepository") RequiredInfoDao requiredInfoDao) {
        this.requiredInfoDao = requiredInfoDao;
    }


    public int insertRequiredInfo(int uid, RequiredInfo requiredInfo) {
        return requiredInfoDao.insertRequiredInfo( uid, requiredInfo);
    }
    public int insertRequiredInfo(RequiredInfo requiredInfo) {
        return requiredInfoDao.insertRequiredInfo(requiredInfo);
    }
    public int updateRequiredInfo(int uid, RequiredInfo requiredInfo) {
        return requiredInfoDao.updateRequiredInfo( uid, requiredInfo);
    }
    public int deleteRequiredInfo(int uid) {
        return requiredInfoDao.deleteRequiredInfos(uid);
    }
    public List<RequiredInfo> queryRequiredInfo() {
        return requiredInfoDao.queryRequiredInfos();
    }
    public Optional<RequiredInfo> queryRequiredInfo(int uid) {
        return requiredInfoDao.queryRequiredInfo(uid);//may return null
    }
}
