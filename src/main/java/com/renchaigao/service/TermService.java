package com.renchaigao.service;

import com.renchaigao.domain.term.Term;
import com.renchaigao.domain.response.ResponseEntity;

public interface TermService {

    ResponseEntity addTerm(Term term);
    ResponseEntity updateTerm(Term term);
    ResponseEntity deleteTerm(Term term);

    ResponseEntity getTermInfo(Term term);

}
