package com.sy.controller;

import com.sy.entity.Det;
import com.sy.entity.Inf;
import com.sy.entity.User;
import com.sy.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("inf")
@RestController
public class InfController {
    @Autowired
    private InfService infService;

    @RequestMapping(value = "insertInf", method = RequestMethod.POST)
    public boolean insertinf(@RequestBody Inf inf) {
        boolean b = infService.insertInf(inf);
        return b;
    }
    @RequestMapping(value = "insertOpt", method = RequestMethod.POST)
    public boolean insertopt(@RequestBody Det det) {
        boolean b = infService.insertOpt(det);
        return b;
    }
    @RequestMapping(value = "updateDes", method = RequestMethod.POST)
    public boolean updateDes(@RequestBody Inf inf) {
        boolean b = infService.updateDes(inf);
        return b;
    }
    @RequestMapping(value = "updateRes", method = RequestMethod.POST)
    public boolean updateRes(@RequestBody Det det) {
        boolean b = infService.updateRes(det);
        return b;
    }
    @RequestMapping(value = "deleteDes", method = RequestMethod.POST)
    public boolean deleteDes(@RequestBody Inf inf) {
        boolean b = infService.deleteDes(inf);
        return b;
    }
    @RequestMapping(value = "oneOpt", method = RequestMethod.POST)
    public boolean deleteOne(@RequestBody Det det) {
        boolean b = infService.deleteOneOpt(det);
        return b;
    }
    @RequestMapping(value = "allOpt", method = RequestMethod.POST)
    public boolean deleteAllOpt(@RequestBody Inf inf) {
        boolean b = infService.deleteAllOpt(inf);
        return b;
    }
}
