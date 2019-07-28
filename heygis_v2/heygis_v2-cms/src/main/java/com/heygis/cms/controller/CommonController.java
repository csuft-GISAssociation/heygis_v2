package com.heygis.cms.controller;


import com.heygis.cms.utils.HeyGisResult;
import com.heygis.cms.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * 公共控制层
 */
@RestController
@RequestMapping("/system")
@PropertySource("classpath:resource.properties")
//CORS跨域 开发阶段允许该域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CommonController {


    //Windows环境下路径
    @Value("${WINDOWS_PATH}")
    private String WINDOWS_PATH;

    //本地访问前缀
    @Value("${LOCAL_HTTP_PATH}")
    private String LOCAL_HTTP_PATH;

    /**
     * 图片上传
     * @param file
     * @param token
     * @return
     */
    @PostMapping("/comm/uploadImg") //相当于@RequestMapping(value = “/xx”, method = RequestMethod.POST)
    public HeyGisResult uploadImg(MultipartFile file, @CookieValue("cms-user-token") String token){
        if(file.isEmpty()|| file==null){
            System.out.println("文件为空");
            return HeyGisResult.build(202,"图片获取失败");
        }
        // 获得原始图片名称
        String originalFilename = file.getOriginalFilename();
        // 获得后缀名 由于blob，没有后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // uuid生成图片新的名称
        String picName = UuidUtil.get32UUID()  +suffix;
        try {
            file.transferTo(new File(WINDOWS_PATH,picName));
            return HeyGisResult.build(200,"图片上传成功",LOCAL_HTTP_PATH+picName);
        } catch (IOException e) {
            e.printStackTrace();
            return HeyGisResult.build(201,"图片上传失败");
        }
    }

}
