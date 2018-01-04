package com.xb.powerplatform.utilsclass.base;

import com.xb.powerplatform.education_and_training.bean.RegularAssess;
import com.xb.powerplatform.education_and_training.bean.assess;
import com.xb.powerplatform.education_and_training.bean.result;
import com.xb.powerplatform.utilsclass.person.entity.User;
import com.xb.powerplatform.utilsclass.person.entity.checkPwd;
import com.xb.powerplatform.utilsclass.person.entity.register;
import com.xb.powerplatform.utilsclass.person.entity.upApp;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface RetrofitService {
    //===========================================用户相关===================================================
    /**
     * 注册接口
     * @param mobile
     * @param cred
     * @param pwd
     * @return
     */
    @POST("register")
    Observable<register> Register(@Query("mobile") String mobile,
                                  @Query("cred") String cred, @Query("pwd") String pwd);

    /**
     * 登录接口
     * @param name
     * @param password
     * @return
     */
    @POST("login")
    Observable<User> lgoin(@Query("mobile") String name, @Query("pwd") String password);

    /**
     * 获取试题
     */
    @GET("downLoadByType")
    Observable<assess> getAssessData(@Query("classId") String classId);

    /**
     * 获取正式考试试题
     */
    @GET("createQuesByRule")
    Observable<RegularAssess> getRedularAssessData(@Query("classId") String classId);

    /**
     * 提交考试成绩
     */
    @GET("getScore")
    Observable<result> upResultAssess(@Query("classId") String classId, @Query("cred") String cred
    , @Query("score") String score);

    /**
     * 更新APP
     */
    @GET("version_update")
    Observable<upApp> upApp ();

    /**
     * 修改密码
     * @param num
     * @param cred
     * @param pwd
     * @return
     */
    @POST("resetPwd")
    Observable<checkPwd> checkPwd(@Query("num") String num,
                                  @Query("cred") String cred, @Query("pwd") String pwd);

}
