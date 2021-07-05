package org.salim.service.edu.service.impl;

import org.salim.service.edu.entity.Video;
import org.salim.service.edu.mapper.VideoMapper;
import org.salim.service.edu.service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author Salim
 * @since 2021-07-05
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

}
