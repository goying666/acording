package com.renchaigao.dao;

import com.renchaigao.domain.term.Term;
import org.apache.ibatis.annotations.Param;

public interface TermDao {

    Integer addTerm(Term term);
    Term updateTermZanById(@Param("id") Integer id, @Param("zanNum") Integer zanNum);
    Term updateTermTingById(@Param("id") Integer id, @Param("tingNum") Integer tingNum);
    Term updateTermContentById(@Param("id") Integer id, @Param("content") String content);
    Term updateTermAcordingIdsById(@Param("id") Integer id, @Param("acordingIds") String acordingIds);
    Term getTermById(Integer id);
    Integer deleteTerm(Integer id);


}
