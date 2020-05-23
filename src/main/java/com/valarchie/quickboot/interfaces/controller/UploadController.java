package com.valarchie.quickboot.interfaces.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import com.valarchie.quickboot.application.common.api.ResponseResult;
import com.valarchie.quickboot.application.common.api.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.IOException;

/**
 * description: 上传控制器
 *
 * @author: valarchie
 * on: 2020/5/19
 * @email: 343928303@qq.com
 */
@ApiIgnore
@Controller
@Slf4j
@RequestMapping("/upload")
public class UploadController {


    @PostMapping("/img")
    @ResponseBody
    public ResponseResult img(@RequestParam("file") MultipartFile file) throws IOException {

        log.info("[文件类型] - [{}]", file.getContentType());
        log.info("[文件名称] - [{}]", file.getOriginalFilename());
        log.info("[文件大小] - [{}]", file.getSize());

        file.transferTo(new File("C:\\Users\\valarchie\\Desktop\\" + file.getOriginalFilename()));

        return ResponseResult.success();

    }


    @PostMapping("/imgs")
    @ResponseBody
    public ResponseResult imgs(@RequestParam("files") MultipartFile[] files) throws IOException {

        if (files != null && files.length <= 0) {
            return ResponseResult.error(ResultCodeEnum.BUSINESS_ERROR);
        }

        for (MultipartFile file : files) {
            // Spring Mvc 提供的写入方式
            file.transferTo(new File("C:\\Users\\valarchie\\Desktop\\" + file.getOriginalFilename()));
        }

        return ResponseResult.success();
    }


    @PostMapping("/imgbase64")
    @ResponseBody
    public ResponseResult imgbase64(String base64) {

        // BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File tempFile = new File("C:\\Users\\valarchie\\Desktop\\base64.jpg");
        // 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] basesSplits = base64.split("base64,");

        byte[] decode = Base64.decode(basesSplits.length > 1 ? basesSplits[1] : basesSplits[0]);

        FileUtil.writeBytes(decode, tempFile);

        return ResponseResult.success();

    }

}
