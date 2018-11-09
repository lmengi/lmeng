package com.lmeng.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    @Column(name = "userId")
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "nickName")
    private String nickname;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 用户签名
     */
    private String signature;

    /**
     * 注册时随机10位数字
     */
    private String salt;

    /**
     * encode(mobile),IMEI,UDID
     */
    @Column(name = "loginId")
    private String loginid;

    /**
     * 微信openId
     */
    @Column(name = "openId")
    private String openid;

    /**
     * 个推ClientId
     */
    @Column(name = "gtClientId")
    private String gtclientid;

    /**
     * encode(mobile)
     */
    private String mobile;

    /**
     * 隐藏第4到第七位的手机号码
     */
    @Column(name = "partMobile")
    private String partmobile;

    /**
     * 登录密码,md5(password)
     */
    private String password;

    /**
     * 0=假删,1=禁用,2=游客,3=注册用户
     */
    @Column(name = "statusId")
    private Integer statusid;

    /**
     * 0=未实名认证,1=已实名认证
     */
    private Integer identified;

    /**
     * 申请成为配送员的状态,0=未申请,1=待审,2=拒绝,3=通过
     */
    @Column(name = "senderStatusId")
    private Integer senderstatusid;

    /**
     * 0=unknow,1=male,2=female
     */
    private Integer gender;

    /**
     * 上传的头像文件名
     */
    @Column(name = "headFileName")
    private String headfilename;

    /**
     * 上传的头像保存的相对路径和名称
     */
    @Column(name = "headSaveName")
    private String headsavename;

    /**
     * 出生日期
     */
    private Date birth;

    /**
     * 最近一次的经度
     */
    private BigDecimal longitude;

    /**
     * 最近一次的纬度
     */
    private BigDecimal latitude;

    /**
     * 最近一次所在的城市编号
     */
    @Column(name = "lastCityId")
    private Integer lastcityid;

    /**
     * 最近一次登录的小区
     */
    @Column(name = "lastBiotopeId")
    private Integer lastbiotopeid;

    /**
     * 最后一次登录的软件版本表示，如android.main
     */
    @Column(name = "lastBranch")
    private String lastbranch;

    /**
     * 最后一次登录的app版本
     */
    @Column(name = "lastVersionCode")
    private Integer lastversioncode;

    /**
     * 最后一次登录的app版本
     */
    @Column(name = "lastVersionName")
    private String lastversionname;

    /**
     * 最后一次登录系统的时间
     */
    @Column(name = "lastLoginTime")
    private Date lastlogintime;

    /**
     * 注册时间
     */
    @Column(name = "registerTime")
    private Date registertime;

    /**
     * 注册IP
     */
    @Column(name = "registerIp")
    private String registerip;

    /**
     * 最后修改时间
     */
    @Column(name = "lastUpdateTime")
    private Date lastupdatetime;

    /**
     * 可使用的余额
     */
    @Column(name = "useableMoney")
    private BigDecimal useablemoney;

    /**
     * 总余额
     */
    @Column(name = "totalMoney")
    private BigDecimal totalmoney;

    /**
     * 被冻结的余额
     */
    @Column(name = "frozenMoney")
    private BigDecimal frozenmoney;

    /**
     * 支付密码
     */
    @Column(name = "payPassword")
    private String paypassword;

    /**
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userid
     */
    public void setUserId(Integer userid) {
        this.userId = userid;
    }

    /**
     * 获取用户姓名
     *
     * @return nickName - 用户姓名
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户姓名
     *
     * @param nickname 用户姓名
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户真实姓名
     *
     * @return name - 用户真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户真实姓名
     *
     * @param name 用户真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户签名
     *
     * @return signature - 用户签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置用户签名
     *
     * @param signature 用户签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取注册时随机10位数字
     *
     * @return salt - 注册时随机10位数字
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置注册时随机10位数字
     *
     * @param salt 注册时随机10位数字
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取encode(mobile),IMEI,UDID
     *
     * @return loginId - encode(mobile),IMEI,UDID
     */
    public String getLoginid() {
        return loginid;
    }

    /**
     * 设置encode(mobile),IMEI,UDID
     *
     * @param loginid encode(mobile),IMEI,UDID
     */
    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    /**
     * 获取微信openId
     *
     * @return openId - 微信openId
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信openId
     *
     * @param openid 微信openId
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取个推ClientId
     *
     * @return gtClientId - 个推ClientId
     */
    public String getGtclientid() {
        return gtclientid;
    }

    /**
     * 设置个推ClientId
     *
     * @param gtclientid 个推ClientId
     */
    public void setGtclientid(String gtclientid) {
        this.gtclientid = gtclientid;
    }

    /**
     * 获取encode(mobile)
     *
     * @return mobile - encode(mobile)
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置encode(mobile)
     *
     * @param mobile encode(mobile)
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取隐藏第4到第七位的手机号码
     *
     * @return partMobile - 隐藏第4到第七位的手机号码
     */
    public String getPartmobile() {
        return partmobile;
    }

    /**
     * 设置隐藏第4到第七位的手机号码
     *
     * @param partmobile 隐藏第4到第七位的手机号码
     */
    public void setPartmobile(String partmobile) {
        this.partmobile = partmobile;
    }

    /**
     * 获取登录密码,md5(password)
     *
     * @return password - 登录密码,md5(password)
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码,md5(password)
     *
     * @param password 登录密码,md5(password)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取0=假删,1=禁用,2=游客,3=注册用户
     *
     * @return statusId - 0=假删,1=禁用,2=游客,3=注册用户
     */
    public Integer getStatusid() {
        return statusid;
    }

    /**
     * 设置0=假删,1=禁用,2=游客,3=注册用户
     *
     * @param statusid 0=假删,1=禁用,2=游客,3=注册用户
     */
    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    /**
     * 获取0=未实名认证,1=已实名认证
     *
     * @return identified - 0=未实名认证,1=已实名认证
     */
    public Integer getIdentified() {
        return identified;
    }

    /**
     * 设置0=未实名认证,1=已实名认证
     *
     * @param identified 0=未实名认证,1=已实名认证
     */
    public void setIdentified(Integer identified) {
        this.identified = identified;
    }

    /**
     * 获取申请成为配送员的状态,0=未申请,1=待审,2=拒绝,3=通过
     *
     * @return senderStatusId - 申请成为配送员的状态,0=未申请,1=待审,2=拒绝,3=通过
     */
    public Integer getSenderstatusid() {
        return senderstatusid;
    }

    /**
     * 设置申请成为配送员的状态,0=未申请,1=待审,2=拒绝,3=通过
     *
     * @param senderstatusid 申请成为配送员的状态,0=未申请,1=待审,2=拒绝,3=通过
     */
    public void setSenderstatusid(Integer senderstatusid) {
        this.senderstatusid = senderstatusid;
    }

    /**
     * 获取0=unknow,1=male,2=female
     *
     * @return gender - 0=unknow,1=male,2=female
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置0=unknow,1=male,2=female
     *
     * @param gender 0=unknow,1=male,2=female
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取上传的头像文件名
     *
     * @return headFileName - 上传的头像文件名
     */
    public String getHeadfilename() {
        return headfilename;
    }

    /**
     * 设置上传的头像文件名
     *
     * @param headfilename 上传的头像文件名
     */
    public void setHeadfilename(String headfilename) {
        this.headfilename = headfilename;
    }

    /**
     * 获取上传的头像保存的相对路径和名称
     *
     * @return headSaveName - 上传的头像保存的相对路径和名称
     */
    public String getHeadsavename() {
        return headsavename;
    }

    /**
     * 设置上传的头像保存的相对路径和名称
     *
     * @param headsavename 上传的头像保存的相对路径和名称
     */
    public void setHeadsavename(String headsavename) {
        this.headsavename = headsavename;
    }

    /**
     * 获取出生日期
     *
     * @return birth - 出生日期
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置出生日期
     *
     * @param birth 出生日期
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取最近一次的经度
     *
     * @return longitude - 最近一次的经度
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置最近一次的经度
     *
     * @param longitude 最近一次的经度
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取最近一次的纬度
     *
     * @return latitude - 最近一次的纬度
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置最近一次的纬度
     *
     * @param latitude 最近一次的纬度
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取最近一次所在的城市编号
     *
     * @return lastCityId - 最近一次所在的城市编号
     */
    public Integer getLastcityid() {
        return lastcityid;
    }

    /**
     * 设置最近一次所在的城市编号
     *
     * @param lastcityid 最近一次所在的城市编号
     */
    public void setLastcityid(Integer lastcityid) {
        this.lastcityid = lastcityid;
    }

    /**
     * 获取最近一次登录的小区
     *
     * @return lastBiotopeId - 最近一次登录的小区
     */
    public Integer getLastbiotopeid() {
        return lastbiotopeid;
    }

    /**
     * 设置最近一次登录的小区
     *
     * @param lastbiotopeid 最近一次登录的小区
     */
    public void setLastbiotopeid(Integer lastbiotopeid) {
        this.lastbiotopeid = lastbiotopeid;
    }

    /**
     * 获取最后一次登录的软件版本表示，如android.main
     *
     * @return lastBranch - 最后一次登录的软件版本表示，如android.main
     */
    public String getLastbranch() {
        return lastbranch;
    }

    /**
     * 设置最后一次登录的软件版本表示，如android.main
     *
     * @param lastbranch 最后一次登录的软件版本表示，如android.main
     */
    public void setLastbranch(String lastbranch) {
        this.lastbranch = lastbranch;
    }

    /**
     * 获取最后一次登录的app版本
     *
     * @return lastVersionCode - 最后一次登录的app版本
     */
    public Integer getLastversioncode() {
        return lastversioncode;
    }

    /**
     * 设置最后一次登录的app版本
     *
     * @param lastversioncode 最后一次登录的app版本
     */
    public void setLastversioncode(Integer lastversioncode) {
        this.lastversioncode = lastversioncode;
    }

    /**
     * 获取最后一次登录的app版本
     *
     * @return lastVersionName - 最后一次登录的app版本
     */
    public String getLastversionname() {
        return lastversionname;
    }

    /**
     * 设置最后一次登录的app版本
     *
     * @param lastversionname 最后一次登录的app版本
     */
    public void setLastversionname(String lastversionname) {
        this.lastversionname = lastversionname;
    }

    /**
     * 获取最后一次登录系统的时间
     *
     * @return lastLoginTime - 最后一次登录系统的时间
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * 设置最后一次登录系统的时间
     *
     * @param lastlogintime 最后一次登录系统的时间
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * 获取注册时间
     *
     * @return registerTime - 注册时间
     */
    public Date getRegistertime() {
        return registertime;
    }

    /**
     * 设置注册时间
     *
     * @param registertime 注册时间
     */
    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    /**
     * 获取注册IP
     *
     * @return registerIp - 注册IP
     */
    public String getRegisterip() {
        return registerip;
    }

    /**
     * 设置注册IP
     *
     * @param registerip 注册IP
     */
    public void setRegisterip(String registerip) {
        this.registerip = registerip;
    }

    /**
     * 获取最后修改时间
     *
     * @return lastUpdateTime - 最后修改时间
     */
    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    /**
     * 设置最后修改时间
     *
     * @param lastupdatetime 最后修改时间
     */
    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    /**
     * 获取可使用的余额
     *
     * @return useableMoney - 可使用的余额
     */
    public BigDecimal getUseablemoney() {
        return useablemoney;
    }

    /**
     * 设置可使用的余额
     *
     * @param useablemoney 可使用的余额
     */
    public void setUseablemoney(BigDecimal useablemoney) {
        this.useablemoney = useablemoney;
    }

    /**
     * 获取总余额
     *
     * @return totalMoney - 总余额
     */
    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    /**
     * 设置总余额
     *
     * @param totalmoney 总余额
     */
    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    /**
     * 获取被冻结的余额
     *
     * @return frozenMoney - 被冻结的余额
     */
    public BigDecimal getFrozenmoney() {
        return frozenmoney;
    }

    /**
     * 设置被冻结的余额
     *
     * @param frozenmoney 被冻结的余额
     */
    public void setFrozenmoney(BigDecimal frozenmoney) {
        this.frozenmoney = frozenmoney;
    }

    /**
     * 获取支付密码
     *
     * @return payPassword - 支付密码
     */
    public String getPaypassword() {
        return paypassword;
    }

    /**
     * 设置支付密码
     *
     * @param paypassword 支付密码
     */
    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }
}