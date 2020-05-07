package cn.com.controller;

import cn.com.entity.Trash;
import cn.com.service.TrashService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trash")
public class TrashController {
    @Autowired
    private TrashService trashService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Trash>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "limit",defaultValue = "20")Integer pageSize,
                                     @RequestParam(value = "number",required = false)String number,
                                     @RequestParam(value = "capacity",required = false)String capacity,
                                     @RequestParam(value = "location",required = false)String location){
        Result<List<Trash>> list = trashService.query(pageNum, pageSize,number,capacity,location);
        return list;
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(Trash trash){
        trashService.add(trash);
        return new Result<>().success();
    }


    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        trashService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        trashService.removeList(id);
        return new Result<>().success();
    }

}
