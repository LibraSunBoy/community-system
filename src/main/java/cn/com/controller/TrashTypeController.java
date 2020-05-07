package cn.com.controller;

import cn.com.entity.TrashType;
import cn.com.service.TrashTypeService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trashType")
public class TrashTypeController {

    @Autowired
    private TrashTypeService trashTypeService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<TrashType>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "limit",defaultValue = "20")Integer pageSize,
                                         @RequestParam(value = "name",required = false)String name){
        Result<List<TrashType>> list = trashTypeService.query(pageNum, pageSize,name);
        return list;
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(TrashType trashType){
        trashTypeService.add(trashType);
        return new Result<>().success();
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        trashTypeService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        trashTypeService.removeList(id);
        return new Result<>().success();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(TrashType trashType){
        trashTypeService.update(trashType);
        return new Result<>().success();
    }
}
