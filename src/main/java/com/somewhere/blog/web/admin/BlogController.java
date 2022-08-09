package com.somewhere.blog.web.admin;


import com.somewhere.blog.po.Blog;
import com.somewhere.blog.po.Type;
import com.somewhere.blog.po.User;
import com.somewhere.blog.service.BlogService;
import com.somewhere.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.somewhere.blog.dao.BlogRepository;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @Autowired
    BlogRepository blogRepository;



    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size=6, sort = {"creatTime"},direction = Sort.Direction.DESC) Pageable pageable,Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listType(pageable));
        return "admin/blogs";
    }



    @GetMapping("/blogs/input")
    public String input(Model model){
        //拿到所有分类标签
        model.addAttribute("type",typeService.listType());
        model.addAttribute("blog", new Blog());
        return "admin/blogs_input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog,HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        //获得分类
        //blog.setType(typeService.getType(blog.getType().getId()));
        Blog b = blogService.saveBlog(blog);
        return "redirect:/admin/blogs";
    }


    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.listType());
        model.addAttribute("blog", blogService.getBlog(id));
        return "admin/blogs_input";
    }


    @PostMapping("/blogs/{id}")
    public String editPost(Blog blog,  @PathVariable Long id){
        Blog b = blogService.updateBlog(id,blog);
        return "redirect:/admin/blogs";
    }


/*

*/
/*

    @PostMapping("/blogs/{id}")
    public String editPost(Blog blog, @PathVariable Long id){
        Blog b = blogService.updateBlog(id,blog);
        return "redirect:/admin/blogs";
    }

*/



/*


    //发布  提交


    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id){
        typeService.deleteType(id);
        return "redirect:/admin/blogs";
    }

*/


}
