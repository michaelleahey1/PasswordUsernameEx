package com.ust.util.passwordEx.PasswordEx.api;

import com.ust.util.passwordEx.PasswordEx.model.RequiredInfo;
import org.apache.coyote.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.ust.util.passwordEx.PasswordEx.service.RequiredInfoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="requiredInfos/")
public class RequiredInfoController {
    private RequiredInfoService requiredInfoService;
    @Autowired
    public RequiredInfoController(RequiredInfoService requiredInfoService){
        this.requiredInfoService = requiredInfoService;
    }
    @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertRequiredInfo(@RequestBody RequiredInfo requiredInfo){
        requiredInfoService.insertRequiredInfo(requiredInfo);
    }
    @GetMapping
    public List<RequiredInfo> queryRequiredInfo(){
        return requiredInfoService.queryRequiredInfo();
    }
    @GetMapping(value="{uid}")
    Optional<RequiredInfo> queryRequiredInfo(@PathVariable("uid") int uid){
        return  requiredInfoService.queryRequiredInfo(uid);
    }

    @DeleteMapping(value = "{uid}")
        public int deleteRequiredInfo(@PathVariable("uid") int uid){
            return requiredInfoService.deleteRequiredInfo(uid);
        }

    @PutMapping(value="{uid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateRequiredInfo(@PathVariable("uid") int uid, @RequestBody RequiredInfo requiredInfo){
        return requiredInfoService.updateRequiredInfo(uid,requiredInfo);
    }
}
