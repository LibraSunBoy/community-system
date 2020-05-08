package cn.com.controller;

import cn.com.entity.Unit;
import cn.com.service.UnitService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Unit>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "limit",defaultValue = "20")Integer pageSize,
                                    @RequestParam(value = "name",required = false)String name,
                                    @RequestParam(value = "floor",required = false)Integer floor,
                                    @RequestParam(value = "location",required = false)String location){
        Result<List<Unit>> list = unitService.query(pageNum, pageSize,name,floor,location);
        return list;
    }

    @PostMapping("/getByCommunityId")
    @ResponseBody
    public Result<List<Unit>> getByCommunityId(@RequestParam(value = "communityId")Integer communityId,
                                    @RequestParam(value = "name",required = false)String name){
        Result<List<Unit>> list = unitService.getByCommunityId(communityId,name);
        return list;
    }

    @PostMapping("/getById")
    @ResponseBody
    public Result<Unit> getById(@RequestParam(value = "id")Integer id){
        Unit list = unitService.getById(id);
        return new Result<>().success(list);
    }


    @PostMapping("/add")
    @ResponseBody
    public Result add(Unit unit){
        unitService.add(unit);
        return new Result<>().success();
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        unitService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        unitService.removeList(id);
        return new Result<>().success();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(Unit unit){
        unitService.update(unit);
        return new Result<>().success();
    }
}
