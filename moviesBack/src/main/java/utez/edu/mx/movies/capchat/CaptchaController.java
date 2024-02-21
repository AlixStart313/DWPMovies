package utez.edu.mx.movies.capchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/api/captcha")
public class CaptchaController {
    @Autowired
    private  CaptchaService captchaService;

    @PostMapping("/verificar-captcha")
    public CaptchaDTO VerificarCapchat(@RequestParam("solution") String solution){
        return captchaService.VerificarCaptcha(solution);
    }

}
