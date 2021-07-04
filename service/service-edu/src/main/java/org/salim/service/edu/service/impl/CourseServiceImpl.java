package org.salim.service.edu.service.impl;

import org.salim.service.edu.entity.Course;
import org.salim.service.edu.mapper.CourseMapper;
import org.salim.service.edu.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author Salim
 * @since 2021-07-04
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
