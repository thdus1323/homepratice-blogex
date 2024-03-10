package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {
BoardRepository boardRepository;
    @GetMapping({"/", "/board"})
    public String index(HttpServletRequest request) {
            List<Board> boardList = boardRepository.findAll();

            for(Board a : boardList){
                System.out.println(a);
            }
            request.setAttribute("boardList",boardList);
            return "index";
        }


    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/1")
    public String detail() {
        return "board/detail";
    }
}
