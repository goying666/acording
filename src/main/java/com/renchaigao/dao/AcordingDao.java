package com.renchaigao.dao;

import com.renchaigao.domain.acording.Acording;
import org.apache.ibatis.annotations.Param;

public interface AcordingDao {
    Integer addAcroding(Acording acording);

    Acording updateAcoPathById(@Param("id") Integer id, @Param("path") String path);
    Acording updateAcoFileNameById(@Param("id") Integer id, @Param("fileName") String fileName);
    Acording updateAcoTingById(@Param("id") Integer id, @Param("tingNum") Integer tingNum);
    Acording updateAcoZanNameById(@Param("id") Integer id, @Param("zanNum") Integer zanNum);
    Acording updateAcoShouNameById(@Param("id") Integer id, @Param("shoucangNum") Integer shoucangNum);
    Acording updateAcoShareNameById(@Param("id") Integer id, @Param("shareNum") Integer shareNum);
    Acording updateAcoBadNameById(@Param("id") Integer id, @Param("badNum") Integer badNum);

    Integer deleteAcordingById(@Param("id") Integer id);

    Acording findAcordingById(@Param("id") Integer id);



}
