package org.salim.service.edu.service.impl;

import org.salim.service.edu.entity.Comment;
import org.salim.service.edu.mapper.CommentMapper;
import org.salim.service.edu.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Salim
 * @since 2021-07-04
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
