package com.ust.util.passwordEx.PasswordEx.dao;

import com.ust.util.passwordEx.PasswordEx.model.RequiredInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("RequiredInfoRepository")
public class RequiredInfoRepository implements RequiredInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //private static final List<RequiredInfo> user = new ArrayList<>();

    @Override
    public int insertRequiredInfo(int uid, RequiredInfo requiredInfo) {
        String sql = "INSERT INTO REQUIREDINFOS (uid,username,pword) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[]{requiredInfo.getUid(), requiredInfo.getUsername(), requiredInfo.getPword()});
    }

    @Override
    public int updateRequiredInfo(int uid, RequiredInfo requiredInfo) {
        String sql="UPDATE REQUIREDINFOS set username=?,pword=? where uid=?";
        return jdbcTemplate.update(sql,
                new Object[]{requiredInfo.getUsername(), requiredInfo.getPword(),requiredInfo.getUid()});
    }

    @Override
    public int deleteRequiredInfos(int uid) {
        String sql = "DELETE FROM REQUIREDINFOS WHERE UID=?";
        return jdbcTemplate.update(sql, uid);
    }

    @Override
    public List<RequiredInfo> queryRequiredInfos() {
        String sql = "SELECT * FROM REQUIREDINFOS";
        List<RequiredInfo> results=jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(RequiredInfo.class));
        return results;
    }

    @Override
    public Optional<RequiredInfo> queryRequiredInfo(int uid) {
        RequiredInfo requiredInfo = null;
        try {
            String sql = "SELECT * FROM REQUIREDINFOS WHERE UID=?";
            requiredInfo = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(RequiredInfo.class), uid);
            return Optional.ofNullable(requiredInfo);
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.ofNullable(null);
        }
    }
}
