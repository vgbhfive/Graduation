package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.DayInOut;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslClient;
import java.util.*;

/**
 * @time: 2019/03/13
 * @author: Vgbh
 */
@Service
public class DayService {

    @Autowired
    private DayRepository dayRepository;

    /**
     * 获取用户的所有日常支出和收入
     * @param userId
     * @return 日常支出或收入集合
     */
    public ReturnResult findAllDayInOut(Long userId) {
        List<DayInOut> allDay = dayRepository.findAllByUserId(userId);
        if (allDay.isEmpty()) {
            return ReturnResult.error(403, "No User Registration!");
        }
        return ReturnResult.ok(allDay);
    }

    /**
     * 持久化日常支出或收入信息
     * @param dayInOut
     * @return 日常收入或支出信息
     */
    public ReturnResult save(Map<String, String> dayInOut) {
        DayInOut day = new DayInOut();
        day.setUserId(Long.valueOf(dayInOut.get("userId")));
        day.setMoney(Integer.parseInt(dayInOut.get("money")));
        day.setIncome(Boolean.parseBoolean(dayInOut.get("income")));
        day.setHowUse(dayInOut.get("use"));
        day.setDatetimes(new Date());
        day.setContents(dayInOut.get("content"));

        DayInOut one = dayRepository.save(day);
        return ReturnResult.ok(one);
    }

    /**
     * 修改日常支出或收入信息
     * @param dayInOut
     * @return 日常收入或支出信息
     */
    public ReturnResult update(Map<String, String> dayInOut) {
        DayInOut day = dayRepository.getOne(Long.valueOf(dayInOut.get("dayId")));
        if (day == null) {
            ReturnResult.error(403, "No This DayInOut!");
        }

        DayInOut save = new DayInOut();
        save.setDayId(day.getDayId());
        save.setUserId(Long.valueOf(dayInOut.get("userId")));
        save.setMoney(Integer.parseInt(dayInOut.get("money")));
        save.setIncome(Boolean.parseBoolean(dayInOut.get("income")));
        save.setHowUse(dayInOut.get("use"));
        save.setDatetimes(new Date());
        save.setContents(dayInOut.get("content"));

        dayRepository.delete(day); //删除原信息
        DayInOut ret = dayRepository.save(save); //添加修改后的信息
        return ReturnResult.ok(ret);
    }

    /**
     * 总计个人的全部支出和收入信息
     * @param userId
     * @return 支出或收入的总和
     */
    public ReturnResult total(Long userId) {
        List<DayInOut> days = dayRepository.findAllByUserId(userId);
        Map<String, Integer> total = new HashMap<>();
        Integer sum = 0;
        for (DayInOut day : days) {
            if (day.getIncome()) {
                sum += day.getMoney(); //收入
            } else {
                sum -= day.getMoney(); //支出
            }
        }
        total.put("Total Money", sum);

        return ReturnResult.ok(total);
    }

}
