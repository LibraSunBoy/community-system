package cn.com.controller;

import cn.com.entity.ExamScore;
import cn.com.entity.Member;
import cn.com.exception.CustomException;
import cn.com.service.MemberService;
import cn.com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * Filename      :  MemberController
 * Package       :  cn.com.controller
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2020年04月2020/4/30日
 * </pre>
 *
 * @author : yangdong.jia
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @PostMapping("/login")
    @ResponseBody
    public Result<Member> login(String account, String pwd){
        Member login = memberService.login(account, pwd);
        return new Result<>(CustomException.CodeEnum.OK,login);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Integer> add(Member member){
        Integer memberId = memberService.add(member);
        return new Result<>(CustomException.CodeEnum.OK,memberId);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<List<Member>> query(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "limit",defaultValue = "20") Integer pageSize,
                                      @RequestParam(value = "nickName",required=false) String nickName,
                                      @RequestParam(value = "mobile",required=false) String mobile){
        Result<List<Member>> list = memberService.query(pageNum, pageSize, nickName,mobile);
        return list;
    }

    @PostMapping("/getById")
    @ResponseBody
    public Result<Member> getById(@RequestParam(value = "id")Integer id){
        Member list = memberService.getById(id);
        return new Result<>().success(list);
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result remove(Integer id){
        memberService.remove(id);
        return new Result<>().success();
    }

    @PostMapping("/removeList")
    @ResponseBody
    public Result removeList(@RequestParam(value = "id[]") List<Integer> id){
        memberService.removeList(id);
        return new Result<>().success();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(Member member){
        memberService.update(member);
        return new Result<>().success();
    }
}
