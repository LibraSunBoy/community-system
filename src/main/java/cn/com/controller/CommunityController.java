package cn.com.controller;

import cn.com.entity.Community;
import cn.com.entity.Member;
import cn.com.entity.Unit;
import cn.com.service.CommunityService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Community>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "limit",defaultValue = "20")Integer pageSize){
        Result<List<Community>> list = communityService.query(pageNum, pageSize);
        return list;
    }

    @GetMapping("/allList")
    @ResponseBody
    public Result<List<Community>> allList(){
        Result<List<Community>> list = communityService.allList();
        return list;
    }

    @GetMapping("/getById")
    @ResponseBody
    public Result<Community> getById(@RequestParam(value = "id") Integer id){
        return communityService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(Community community){
        communityService.add(community);
        return new Result<>().success();
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        communityService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        communityService.removeList(id);
        return new Result<>().success();
    }
}
