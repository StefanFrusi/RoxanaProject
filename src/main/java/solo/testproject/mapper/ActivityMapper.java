package solo.testproject.mapper;

import solo.testproject.dto.ActivityDto;
import solo.testproject.entity.Activity;

public class ActivityMapper {
    public static Activity toActivity(ActivityDto activityDto)
    { Activity activity=new Activity();
        activity.setDescription(activityDto.getDescription());
        activity.setName(activityDto.getName());
        return activity;

    }
}
