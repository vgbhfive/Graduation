package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.DayInOut;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslClient;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
     * @return 日常收入或支出记录
     */
    public ReturnResult save(Map<String, String> dayInOut) {
        DayInOut day = new DayInOut();
        day.setUserId(Long.valueOf(dayInOut.get("userId")));
        day.setMoney(Integer.parseInt(dayInOut.get("money")));
        day.setIncome(Boolean.parseBoolean(dayInOut.get("income")));
        day.setHowUse(dayInOut.get("use"));
        day.setDate(new Date());
        day.setContent(dayInOut.get("content"));

        DayInOut one = dayRepository.save(day);
        return ReturnResult.ok(one);
    }

    /**
     * 修改日常支出或收入信息
     * @param dayInOut
     * @return 修改后的日常或支出信息
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
        save.setDate(new Date());
        save.setContent(dayInOut.get("content"));

        dayRepository.delete(day); //删除原信息
        DayInOut ret = dayRepository.save(save); //添加修改后的信息
        return ReturnResult.ok(ret);
    }

}
