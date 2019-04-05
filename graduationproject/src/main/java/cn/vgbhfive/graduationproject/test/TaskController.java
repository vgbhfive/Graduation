package cn.vgbhfive.graduationproject.test;

import org.springframework.web.bind.annotation.*;

/**
 * 安全机制测试
 *
 * @time: 2019/03/04
 * @author: Vgbh
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public String listTasks(){
        return "任务列表";
    }

    @PostMapping
    public String newTasks(){
        return "创建了一个新的任务";
    }

    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId")Integer id){
        return "更新了一下id为:"+id+"的任务";
    }


}
