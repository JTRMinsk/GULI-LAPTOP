package org.salim.service.edu.service.impl;

import org.salim.service.edu.entity.CourseDescription;
import org.salim.service.edu.mapper.CourseDescriptionMapper;
import org.salim.service.edu.service.ICourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author Salim
 * @since 2021-07-04
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements ICourseDescriptionService {

}
