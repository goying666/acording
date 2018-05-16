package com.renchaigao.service;

import com.renchaigao.domain.request.ReqAcording;
import com.renchaigao.domain.response.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AcordingService {

    ResponseEntity addAcording(ReqAcording reqacording);
    ResponseEntity getAcordingInfo(ReqAcording reqacording);
    ResponseEntity addAcordingFile(MultipartFile file);
}
