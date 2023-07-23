package az.millisoft.first.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(MainNotFoundException.class)
    public String handleNotFound(Model theModel, MainNotFoundException exception){
        theModel.addAttribute("message",exception.getMessage());
        return "error";
    }

    @ExceptionHandler(AddImageException.class)
    public String handleAddImage(Model theModel,AddImageException exception){
       theModel.addAttribute("message",exception.getMessage());
        return "error";
    }

}
