package com.alias.uploadcet.controller;


import com.alias.uploadcet.authentication.TokenService;
import com.alias.uploadcet.constant.Constant;
import com.alias.uploadcet.dto.*;
import com.alias.uploadcet.entity.User;
import com.alias.uploadcet.exception.BaseRuntimeException;
import com.alias.uploadcet.service.IUserService;
import com.alias.uploadcet.util.BaseResponseBuilder;
import com.alias.uploadcet.util.NameUtil;
import com.alias.uploadcet.util.TokenUtil;
import com.alias.uploadcet.vo.UserVo;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 用户控制
 * @Author : ZGS
 * @Date: 2020-04-12 17:06
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    TokenService tokenService;

    // 登录
//    @ApiOperation(value = "登陆", notes = "登陆")
//    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
//    public Object login(User user, HttpServletResponse response) {
////        JSONObject jsonObject = new JSONObject();
////        User userForBase = new User();
////
////        userForBase.setUserId(userService.getById(user).getId());
////        userForBase.setUsername(userService.findByUsername(user).getUsername());
////        userForBase.setPassword(userService.findByUsername(user).getPassword());
////        if (!userForBase.getPassword().equals(user.getPassword())) {
////            jsonObject.put("message", "登录失败,密码错误");
////            return jsonObject;
////        } else {
////            String token = tokenService.getToken(userForBase);
////            jsonObject.put("token", token);
////
////            Cookie cookie = new Cookie("token", token);
////            cookie.setPath("/");
////            response.addCookie(cookie);
////
////            return jsonObject;
////
////        }
//    }
    @ApiOperation(value = "注册或登录", notes = "注册或登录")
    @RequestMapping(value = "/registerOrLogin" ,method = RequestMethod.POST)
    @CrossOrigin(origins = "*",maxAge = 3600)
    public BaseResponse<LoginInfo> registerOrLogin(@RequestBody(required = true)RegisterDto registerDto, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(StringUtils.isEmpty(registerDto.getCode())){
                BaseResponse<LoginInfo> baseResponse = new BaseResponse<>();
                baseResponse.setMessage("code不能为空");
                baseResponse.setData(null);
                baseResponse.setCode(-1);
                return baseResponse;
            }
            log.info("code = "+registerDto.getCode());
            JSONObject jsonObject = getWxUserOpenid(registerDto.getCode(), Constant.appId, Constant.appSecret);
            if(jsonObject == null){
                BaseResponse<LoginInfo> baseResponse = new BaseResponse<>();
                baseResponse.setMessage("获取openId失败");
                baseResponse.setData(null);
                baseResponse.setCode(-1);
                return baseResponse;
            }
            String openId = jsonObject.getString("openid");
            User user = userService.getUserByOpenId(openId);
            if (user == null) {
                user = new User();
                user.setUserName(NameUtil.getStringRandom(10));
                user.setLastLoginTime(LocalDateTime.now());
                user.setOpenId(openId);
            }
            log.info("user = "+user);
            String token = generateToken(user, response);
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setToken(token);
            loginInfo.setUserName(user.getUserName());
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            userService.save(user);
            return BaseResponseBuilder.createBaseResponse(loginInfo);
        }catch (Exception e){
            e.printStackTrace();
            BaseResponse<LoginInfo> baseResponse = new BaseResponse<>();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(null);
            baseResponse.setCode(-1);
            return baseResponse;
        }
    }

    @ApiOperation(value = "注册管理员", notes = "注册管理员")
    @RequestMapping(value = "/registerAdmin" ,method = RequestMethod.POST)
    @CrossOrigin(origins = "*",maxAge = 3600)
    public BaseResponse<LoginInfo> registerAdmin(@RequestBody(required = true) RegisterAdminDto registerDto, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(StringUtils.isEmpty(registerDto.getUserName())||StringUtils.isEmpty(registerDto.getPassword())){
                throw new BaseRuntimeException("用户名密码不能为空！");
            }
            User user = userService.getOne(new QueryWrapper<User>().eq(User.USER_NAME,registerDto.getUserName()));
            if(user!=null){
                throw new BaseRuntimeException("该用户已存在！");
            }
            user = new User();
            user.setUserName(registerDto.getUserName());
            user.setPassword(registerDto.getPassword());
            user.setLastLoginTime(LocalDateTime.now());
            user.setRoleId(2);
            log.info("user = "+user);
            String token = generateToken(user, response);
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setToken(token);
            loginInfo.setUserName(user.getUserName());

            userService.save(user);
            return BaseResponseBuilder.createBaseResponse(loginInfo);
        }catch (Exception e){
            e.printStackTrace();
            BaseResponse<LoginInfo> baseResponse = new BaseResponse<>();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(null);
            baseResponse.setCode(-1);
            return baseResponse;
        }
    }
    @ApiOperation(value = "注册管理员", notes = "注册管理员")
    @RequestMapping(value = "/loginAdmin" ,method = RequestMethod.POST)
    @CrossOrigin(origins = "*",maxAge = 3600)
    public BaseResponse<LoginInfo> loginAdmin(@RequestBody(required = true) LoginAdminDto registerDto, HttpServletRequest request, HttpServletResponse response) {
        try {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq(User.USER_NAME,registerDto.getUserName());
            wrapper.eq(User.PASSWORD,registerDto.getPassword());
            User user = this.userService.getOne(wrapper);
            if(user!=null){
                String token = generateToken(user, response);
                user.setLastLoginTime(LocalDateTime.now());
                LoginInfo loginInfo = new LoginInfo();
                loginInfo.setToken(token);
                loginInfo.setUserName(user.getUserName());
                userService.updateById(user);
                return BaseResponseBuilder.createBaseResponse(loginInfo);
            }else{
                BaseResponse<LoginInfo> baseResponse = new BaseResponse<>();
                baseResponse.setMessage("用户名或密码错误");
                baseResponse.setData(null);
                baseResponse.setCode(-1);
                return baseResponse;
            }
        }catch (Exception e){
            e.printStackTrace();
            BaseResponse<LoginInfo> baseResponse = new BaseResponse<>();
            baseResponse.setMessage(e.getMessage());
            baseResponse.setData(null);
            baseResponse.setCode(-1);
            return baseResponse;
        }
    }
    @GetMapping("/userInfo")
    public BaseResponse<User> getUserInfo(HttpServletRequest request){
//        String token = request.getHeader("token");
        String userId = TokenUtil.getTokenUserId();
        User user = userService.getById(userId);
        return BaseResponseBuilder.createBaseResponse(user);
    }
    private String generateToken(User user,HttpServletResponse response){
        String token = tokenService.getToken(user);
        Cookie cookie = new Cookie("token", token);
        cookie.setPath("/");
        response.addCookie(cookie);
        return token;
    }
    @ApiOperation("获取一个token测试")
    @PostMapping("/getOneTestToken")
    public String getOneTestToken(@RequestBody @ApiParam UserVo user){
        return tokenService.getTokenByParam(user.getUserId(),user.getOpenId());
    }
    //获取openid
    public static JSONObject getWxUserOpenid(String code, String APPID, String APPSecret) {
        //拼接url
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");//appid设置
        url.append(APPID);
        url.append("&secret=");//secret设置
        url.append(APPSecret);
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        JSONObject jsonObject = null;
//        Map<String, Object> map = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            System.out.println(content);//打印返回的信息
            jsonObject = JSONObject.parseObject(content);//把信息封装为json
            //把信息封装到map
//            map = MdzwUtils.parseJSON2Map(res);//这个小工具的代码在下面
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

//    /***
//     * 这个请求需要验证token才能访问
//     *
//     * @author: qiaoyn
//     * @date 2019/06/14
//     * @return String 返回类型
//     */
////    @UserLoginToken
////    @ApiOperation(value = "获取信息", notes = "获取信息")
//    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
//    public String getMessage() {
//
//        // 取出token中带的用户id 进行操作
//        System.out.println(TokenUtil.getTokenUserId());
//
//        return "您已通过验证";
//    }
}
